package com.ss.android.lark.image.impl.passthrough;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.image.uploader.utils.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.a0;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import qpc.e;

/* JADX INFO: loaded from: classes36.dex */
public class PassThroughImageDataFetcher extends ResourceImageDataFetcher<PassThroughImage> {
    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "PassThroughImageDataFetcher";
    }

    public PassThroughImageDataFetcher(PassThroughImage r100) {
        super(r100);
    }

    private Resource getPassThroughImage(PassThroughImage r100) {
        e r101 = (e) ApiUtils.getApi(e.class);
        String r102 = a0.g(LarkContext.getApplication());
        return r101.getImageService().getPassThroughImage(r102, r100.getImageKey(), r100.getFsUnit(), r100.getCrypto(), r100.getFileType());
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(PassThroughImage r100) throws FileNotFoundException {
        long r101 = SystemClock.elapsedRealtime();
        Resource r102 = getPassThroughImage(r100);
        String r103 = r102.f461377b;
        long r104 = SystemClock.elapsedRealtime() - r101;
        Log.i("PassThroughImageDataFetcher", "load passThrough image, key is:" + r100.getImageKey() + ", fsUnit:" + r100.getFsUnit() + ", filePath is:" + r103);
        r100.setErrorResult(r102.f461380e);
        Trace r105 = r102.f461379d;
        if (r105 == null) goto L8;
        if (r105.spans == null) goto L8;
        ArrayList r106 = new ArrayList(r105.spans);
        r106.add(new Trace.Span.Builder().name("sdk_cost").duration_millis(Long.valueOf(r104)).build());
        r100.setTrace(new Trace.Builder().spans(r106).build());
    L8:
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return null;
    L11:
        ImageInfo r107 = b.d(r103, false, false);
        if (r107 == null) goto L15;
        r100.setImageType(r107.f426428h.getValue());
        r100.setResourceSize(r107.f426423c);
    L15:
        return new PolarisFileInputStreamWrapper(r103);
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(PassThroughImage r100) throws FileNotFoundException {
        return getResourceStream2(r100);
    }
}
