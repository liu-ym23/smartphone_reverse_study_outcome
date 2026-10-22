package com.ss.android.lark.keyboard.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.keyboard.base.ImageCompressInfo;
import com.ss.android.lark.keyboard.base.ResourceUploadInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.checker.VideoSendChecker;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowSendMessageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowSendMessageUtils f430952a = null;

    static {
        f430952a = new FlowSendMessageUtils();
    }

    public FlowSendMessageUtils() {
    }

    public static ResourceFile.FileType c(UplinkFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        if (wxa.f.d(r100) == false) goto L6;
        return ResourceFile.FileType.IMAGE;
    L6:
        if (wxa.f.c(r100) == false) goto L9;
        return ResourceFile.FileType.FILE;
    L9:
        if (wxa.f.e(r100) == true) goto L15;
        ResourceFile.FileType r101 = ResourceFile.DEFAULT_FILE_TYPE;
        Intrinsics.checkNotNull(r101);
        return r101;
    L15:
        return ResourceFile.FileType.MEDIA;
    }

    public final Object a(String r100, Continuation<? super f> r101) {
        if ((r101 instanceof FlowSendMessageUtils$getFlowImageInfo$1) == false) goto L7;
        FlowSendMessageUtils$getFlowImageInfo$1 r102 = (FlowSendMessageUtils$getFlowImageInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        ImageInfo r107 = (ImageInfo) r104;
        if (r107 != null) goto L25;
        Log.e("FlowSendMessageUtils", "getFlowImageInfo error, imageInfo is null, filePath: " + r100);
        return null;
    L25:
        int r108 = r107.f426421a;
        if (r108 <= 0) goto L32;
        int r109 = r107.f426422b;
        if (r109 <= 0) goto L32;
        return new f(r108, r109);
    L32:
        Log.e("FlowSendMessageUtils", "getFlowImageInfo error, width: " + r107.f426421a + ", height: " + r107.f426422b + ", filePath: " + r100);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (TextUtils.isEmpty(r100) == false) goto L18;
        Log.e("FlowSendMessageUtils", "getFlowImageInfo error, filePath is empty");
        return null;
    L18:
        CoroutineDispatcher r110 = Dispatchers.getIO();
        FlowSendMessageUtils$getFlowImageInfo$imageInfo$1 r111 = new FlowSendMessageUtils$getFlowImageInfo$imageInfo$1(r100, null);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = BuildersKt.withContext(r110, r111, r102);
        if (r104 != r105) goto L21;
        return r105;
    L7:
        r102 = new FlowSendMessageUtils$getFlowImageInfo$1(this, r101);
        goto L8
    }

    public final Object b(Context r210, String r211, String r212, UplinkFileEntity r213, ConcurrentHashMap<String, ResourceUploadInfo> r214, Continuation<? super g> r215) {
        String r100 = r211;
        String r101 = r212;
        UplinkFileEntity r102 = r213;
        ConcurrentHashMap<String, ResourceUploadInfo> r103 = r214;
        if ((r215 instanceof FlowSendMessageUtils$handleResourceBeforeUpload$1) == false) goto L7;
        FlowSendMessageUtils$handleResourceBeforeUpload$1 r104 = (FlowSendMessageUtils$handleResourceBeforeUpload$1) r215;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r110 = "";
        switch(r104.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResourceFile.FileType r108 = (ResourceFile.FileType) r104.L$1;
        String r109 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r110 = "";
    L80:
        String r111 = (String) r106;
        Log.i("FlowSendMessageUtils", "compress video, originPath: " + r109 + ", compressPath: " + r111);
        if (r111 != null) goto L83;
        String r112 = r110;
    L85:
        return new g(r108, r112);
    L83:
        r112 = r111;
        goto L85
    L13:
        r108 = (ResourceFile.FileType) r104.L$5;
        ConcurrentHashMap<String, ResourceUploadInfo> r113 = (ConcurrentHashMap) r104.L$4;
        UplinkFileEntity r114 = (UplinkFileEntity) r104.L$3;
        String r115 = (String) r104.L$2;
        String r116 = (String) r104.L$1;
        Context r117 = (Context) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r103 = r113;
        r100 = r116;
    L75:
        if (((VideoSendChecker.Result) r106) != VideoSendChecker.Result.VALID) goto L86;
        FlowMediaCompressHelper r118 = FlowMediaCompressHelper.f430950a;
        r104.L$0 = r115;
        r104.L$1 = r108;
        r104.L$2 = null;
        r104.L$3 = null;
        r104.L$4 = null;
        r104.L$5 = null;
        r104.label = 6;
        r106 = r118.a(r117, r114, r115, r100, r104);
        if (r106 != r107) goto L79;
        return r107;
    L79:
        r109 = r115;
        goto L80
    L86:
        String r119 = r114.getFileIdentifier();
        if (r119 == null) goto L89;
        r103.put(r119, new ResourceUploadInfo(ResourceFile.FileType.FILE, null, 2, null));
    L91:
        return new g(ResourceFile.FileType.FILE, r115);
    L89:
        Log.e("FlowSendMessageUtils", "fileIdentifier is null");
        goto L91
    L14:
        String r120 = (String) r104.L$4;
        ResourceFile.FileType r121 = (ResourceFile.FileType) r104.L$3;
        ConcurrentHashMap<String, ResourceUploadInfo> r122 = (ConcurrentHashMap) r104.L$2;
        UplinkFileEntity r123 = (UplinkFileEntity) r104.L$1;
        String r124 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r110 = "";
    L56:
        f r125 = (f) r106;
        if (r125 == null) goto L63;
        ImageCompressInfo r126 = new ImageCompressInfo(r124, r125.f430963a, r125.f430964b);
        String r127 = r123.getFileIdentifier();
        if (r127 == null) goto L61;
        r122.put(r127, new ResourceUploadInfo(r121, r126));
        goto L63
    L61:
        Log.e("FlowSendMessageUtils", "fileIdentifier is null");
    L63:
        if (r120 != null) goto L65;
        String r128 = r110;
    L67:
        return new g(r121, r128);
    L65:
        r128 = r120;
        goto L67
    L15:
        ResourceFile.FileType r129 = (ResourceFile.FileType) r104.L$3;
        ConcurrentHashMap<String, ResourceUploadInfo> r130 = (ConcurrentHashMap) r104.L$2;
        UplinkFileEntity r131 = (UplinkFileEntity) r104.L$1;
        String r132 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r124 = r132;
        r110 = "";
    L16:
        r123 = r131;
        r122 = r130;
        r121 = r129;
        r120 = (String) r106;
        Log.i("FlowSendMessageUtils", "compress image, originPath: " + r124 + ", compressPath: " + r120);
        r104.L$0 = r124;
        r104.L$1 = r123;
        r104.L$2 = r122;
        r104.L$3 = r121;
        r104.L$4 = r120;
        r104.label = 4;
        r106 = a(r120, r104);
        if (r106 != r107) goto L56;
        return r107;
    L17:
        r129 = (ResourceFile.FileType) r104.L$5;
        r130 = (ConcurrentHashMap) r104.L$4;
        r131 = (UplinkFileEntity) r104.L$3;
        String r133 = (String) r104.L$2;
        String r134 = (String) r104.L$1;
        Context r135 = (Context) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r110 = "";
    L37:
        alb.a r136 = (alb.a) r106;
        Log.i("FlowSendMessageUtils", "FileTypeChecker, " + r136.f4211a);
        if (r136.a() == true) goto L46;
        String r137 = r131.getFileIdentifier();
        if (r137 == null) goto L42;
        r130.put(r137, new ResourceUploadInfo(ResourceFile.FileType.FILE, null, 2, null));
    L44:
        return new g(ResourceFile.FileType.FILE, r133);
    L42:
        Log.e("FlowSendMessageUtils", "fileIdentifier is null");
        goto L44
    L46:
        if (Intrinsics.areEqual(r131.isOriginalImageChecked(), Boxing.boxBoolean(true)) == false) goto L49;
        Log.i("FlowSendMessageUtils", "isOriginalImageChecked: true");
        return new g(r129, r133);
    L49:
        FlowMediaCompressHelper r138 = FlowMediaCompressHelper.f430950a;
        r104.L$0 = r133;
        r104.L$1 = r131;
        r104.L$2 = r130;
        r104.L$3 = r129;
        r104.L$4 = null;
        r104.L$5 = null;
        r104.label = 3;
        r106 = r138.a(r135, r131, r133, r134, r104);
        if (r106 != r107) goto L52;
        return r107;
    L52:
        r124 = r133;
        goto L16
    L18:
        ImageUploadTask r139 = (ImageUploadTask) r104.L$6;
        ResourceFile.FileType r140 = (ResourceFile.FileType) r104.L$5;
        ConcurrentHashMap<String, ResourceUploadInfo> r141 = (ConcurrentHashMap) r104.L$4;
        r102 = (UplinkFileEntity) r104.L$3;
        String r142 = (String) r104.L$2;
        String r143 = (String) r104.L$1;
        Context r144 = (Context) r104.L$0;
        ResultKt.throwOnFailure(r106);
        r103 = r141;
        r101 = r142;
    L25:
        alb.a r145 = (alb.a) r106;
        Log.i("FlowSendMessageUtils", "FileSizeChecker, " + r145.f4211a);
        if (r145.a() == true) goto L33;
        String r146 = r102.getFileIdentifier();
        if (r146 == null) goto L30;
        r103.put(r146, new ResourceUploadInfo(ResourceFile.FileType.FILE, null, 2, null));
    L32:
        return new g(ResourceFile.FileType.FILE, r101);
    L30:
        Log.e("FlowSendMessageUtils", "fileIdentifier is null");
        goto L32
    L33:
        CoroutineDispatcher r147 = Dispatchers.getIO();
        FlowSendMessageUtils$handleResourceBeforeUpload$fileTypeCheckResult$1 r148 = new FlowSendMessageUtils$handleResourceBeforeUpload$fileTypeCheckResult$1(r139, null);
        r104.L$0 = r144;
        r104.L$1 = r143;
        r104.L$2 = r101;
        r104.L$3 = r102;
        r104.L$4 = r103;
        r104.L$5 = r140;
        r104.L$6 = null;
        r104.label = 2;
        r106 = BuildersKt.withContext(r147, r148, r104);
        if (r106 != r107) goto L36;
        return r107;
    L36:
        r129 = r140;
        r130 = r103;
        r134 = r143;
        r135 = r144;
        UplinkFileEntity r149 = r102;
        r133 = r101;
        r131 = r149;
        goto L37
    L19:
        ResultKt.throwOnFailure(r106);
        ResourceFile.FileType r150 = c(r213);
        Log.i("FlowSendMessageUtils", "handleResourceBeforeUpload, uploadId: " + r100 + ", fileType: " + r150 + ", localPath: " + r101);
        if (wxa.f.d(r213) == false) goto L69;
        flb.a.C5924a r151 = new flb.a.C5924a();
        flb.a r152 = new flb.a(r151.f477763a, r151.f477764b);
        ImageUploadTask r153 = new ImageUploadTask(r210);
        r153.f426378d = r152;
        com.ss.android.lark.image.uploader.entity.b.a r154 = new com.ss.android.lark.image.uploader.entity.b.a();
        Intrinsics.checkNotNullParameter(r101, "path");
        r154.f426401a = r101;
        com.ss.android.lark.image.uploader.entity.b r155 = r154.b();
        Intrinsics.checkNotNullParameter(r155, "image");
        r153.f426376b.add(r155);
        CoroutineDispatcher r156 = Dispatchers.getIO();
        FlowSendMessageUtils$handleResourceBeforeUpload$fileSizeCheckResult$1 r157 = new FlowSendMessageUtils$handleResourceBeforeUpload$fileSizeCheckResult$1(r153, null);
        r104.L$0 = r210;
        r104.L$1 = r100;
        r104.L$2 = r101;
        r104.L$3 = r102;
        r104.L$4 = r103;
        r104.L$5 = r150;
        r104.L$6 = r153;
        r104.label = 1;
        Object r158 = BuildersKt.withContext(r156, r157, r104);
        if (r158 != r107) goto L24;
        return r107;
    L24:
        r144 = r210;
        r139 = r153;
        r143 = r100;
        r140 = r150;
        r106 = r158;
        goto L25
    L69:
        if (wxa.f.e(r213) == false) goto L93;
        CoroutineDispatcher r159 = Dispatchers.getIO();
        FlowSendMessageUtils$handleResourceBeforeUpload$result$1 r160 = new FlowSendMessageUtils$handleResourceBeforeUpload$result$1(r101, null);
        r104.L$0 = r210;
        r104.L$1 = r100;
        r104.L$2 = r101;
        r104.L$3 = r102;
        r104.L$4 = r103;
        r104.L$5 = r150;
        r104.label = 5;
        Object r161 = BuildersKt.withContext(r159, r160, r104);
        if (r161 != r107) goto L73;
        return r107;
    L73:
        r117 = r210;
        r108 = r150;
        r106 = r161;
        r115 = r101;
        r114 = r102;
        goto L75
    L93:
        return new g(c(r213), r101);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r104 = new FlowSendMessageUtils$handleResourceBeforeUpload$1(this, r215);
        goto L8
    }
}
