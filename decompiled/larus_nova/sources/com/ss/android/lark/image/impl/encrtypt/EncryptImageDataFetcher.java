package com.ss.android.lark.image.impl.encrtypt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.image.uploader.utils.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import javax.annotation.Nullable;
import qpc.e;

/* JADX INFO: loaded from: classes36.dex */
public class EncryptImageDataFetcher extends ResourceImageDataFetcher<EncryptImage> {
    private boolean hasFetchedAgain;

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "EncryptImageDataFetcher";
    }

    public EncryptImageDataFetcher(EncryptImage r100) {
        super(r100);
    }

    @Nullable
    private byte[] decryptResource(String r100) {
        e r101 = (e) ApiUtils.getApi(e.class);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.decryptResource(r100);
    }

    private Resource getEncryptImage(EncryptImage r100) {
        return ImageModule.f426214a.getEncryptImage(null, r100.getEncryptKey(), r100.getFsUnit(), r100.getCrypto(), r100.getContextId(), r100.isNeedCollectTrace(), r100.getDraftResourceSource());
    }

    private static String getFileCRC32(String r100) {
        CRC32 r101 = new CRC32();
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100));     // Catch: IOException -> L9
        CheckedInputStream r103 = new CheckedInputStream(r102, r101);     // Catch: IOException -> L9
        byte[] r104 = new byte[1024];     // Catch: IOException -> L9
        int r105 = 1024;
    L5:
        if (r105 == (-1)) goto L7;
        r105 = r103.read(r104, 0, 1024);     // Catch: IOException -> L9
        goto L5
    L7:
        r103.close();     // Catch: IOException -> L9
        r102.close();     // Catch: IOException -> L9
        return Long.toHexString(r101.getValue());
    L9:
        e = move-exception;
        e.printStackTrace();
        Log.i("EncryptImageDataFetcher", "get file crc32 failed : " + e.getMessage());
        return "";
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(EncryptImage r110) throws FileNotFoundException {
        long r100 = r110.getCreateTime();
        long r101 = 0;
        if (r100 == 0) goto L5;
        r110.setWaitTime(System.currentTimeMillis() - r100);
    L5:
        long r102 = SystemClock.elapsedRealtime();
        Resource r103 = getEncryptImage(r110);
        r110.setDecodeStartTime(System.currentTimeMillis());
        long r104 = SystemClock.elapsedRealtime() - r102;
        if (r103 == null) goto L13;
        String r105 = r103.f461377b;
        Trace r106 = r103.f461379d;
        if (r106 != null) goto L10;
    L12:
        r110.setTrace(r106);
        r110.setErrorResult(r103.f461380e);
    L14:
        boolean r107 = FileUtils.r(r105);
        Log.i("EncryptImageDataFetcher", "load encrypt image, key is:" + r110.getEncryptKey() + ", filePath is:" + r105 + ", isFileExits, " + r107 + ", collect_trace:" + r110.isNeedCollectTrace() + ", contextId:" + r110.getContextId());
        if (TextUtils.isEmpty(r105) == true) goto L17;
        boolean r108 = true;
        if (r107 == false) goto L26;
        ImageInfo r109 = b.d(r105, false, false);
        if (r109 == null) goto L33;
        String r111 = r109.f426428h.getValue();
        r110.setResourceSize(r109.f426423c);
    L35:
        if (TextUtils.isEmpty(r111) == false) goto L37;
    L38:
        r111 = ImageUtils.c(VFSFiles.f444819b.i(r105)).getValue();
    L39:
        r110.setImageType(r111);
        if (r109 != null) goto L42;
    L48:
        r110.setResourceHash(getFileCRC32(r105));
        r110.setFormatHeader(ImageUtils.a(new PolarisFileWrapper(r105)));
        String r112 = r110.getContextId();
        String r113 = r110.getEncryptKey();
        if (r109 == null) goto L51;
        r101 = r109.f426423c;
    L51:
        Log.e("EncryptImageDataFetcher", "image decode failed , context_id:" + r112 + ",resource_key:" + r113 + ",size:" + r101 + ",hash:" + r110.getResourceHash());
    L52:
        if (r103 == null) goto L65;
        String r114 = r103.f461377b;
        if (r103.f461378c.booleanValue() == false) goto L65;
        long r115 = System.currentTimeMillis();
        Log.d("EncryptImageDataFetcher", "start decrypt resource = " + r114);
        Log.i("EncryptImageDataFetcher", "start decrypt resource = " + r114.hashCode());
        byte[] r116 = decryptResource(r114);
        if (r116 != null) goto L58;
    L62:
        Log.e("EncryptImageDataFetcher", "decrypt image resource failed = " + r114.hashCode() + "result length = 0");
        return null;
    L58:
        if (r116.length == 0) goto L62;
        Log.i("EncryptImageDataFetcher", "decrypt image resource success = " + r114.hashCode() + "result length = " + r116.length);
        long r117 = System.currentTimeMillis() - r115;
        r110.setDecryptTime(r117);
        Log.d("EncryptImageDataFetcher", "decrypt image resource cost :" + r117);
        return new ByteArrayInputStream(r116);
    L65:
        return new PolarisFileInputStreamWrapper(r105);
    L42:
        if (r109.f426421a > 0) goto L44;
    L46:
        r108 = false;
    L47:
        if (r108 == true) goto L52;
    L44:
        if (r109.f426422b <= 0) goto L46;
    L37:
        if (Objects.equals(r111, ImageUtils.ImageType.TYPE_UNKNOWN.getValue()) == false) goto L39;
    L33:
        r111 = "";
        goto L35
    L26:
        if (this.hasFetchedAgain == true) goto L29;
        this.hasFetchedAgain = true;
        Log.i("EncryptImageDataFetcher", "resource file not exist, retry get");
        return getResourceStream2(r110);
    L29:
        r110.setErrorResult(new ErrorResult(701003, "file no exist"));
        Log.i("EncryptImageDataFetcher", "resource file not exist, " + r105);
        goto L52
    L17:
        if (r110.getErrorResult() != null) goto L19;
    L20:
        r110.setErrorResult(new ErrorResult(701002, "file path is empty"));
    L21:
        Log.i("EncryptImageDataFetcher", "resource path is empty, " + r105);
        return null;
    L19:
        if (r110.getErrorResult().getCode() != 0) goto L21;
    L10:
        if (r106.spans == null) goto L12;
        ArrayList r118 = new ArrayList(r106.spans);
        r118.add(new Trace.Span.Builder().name("sdk_cost").duration_millis(Long.valueOf(r104)).build());
        r106 = new Trace.Builder().spans(r118).build();
        goto L12
    L13:
        r105 = null;
        goto L14
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(EncryptImage r100) throws FileNotFoundException {
        return getResourceStream2(r100);
    }
}
