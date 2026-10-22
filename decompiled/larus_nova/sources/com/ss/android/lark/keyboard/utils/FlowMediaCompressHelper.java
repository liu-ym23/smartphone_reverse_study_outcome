package com.ss.android.lark.keyboard.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.ss.android.lark.videosend.compress.m;
import com.ss.android.lark.videosend.tools.VideoCompressTools;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowMediaCompressHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowMediaCompressHelper f430950a = null;

    public static final class a extends com.ss.android.lark.videosend.compress.f {
        @Override // com.ss.android.lark.videosend.compress.f
        public final void b() {
            com.ss.android.lark.videosend.compress.f.a r100 = new com.ss.android.lark.videosend.compress.f.a(this);
            r100.e(this.f444946c);
            Log.i("MediaCompressTask", "startCompressWithoutLock isStartSuccess: " + VideoCompressTools.d(this.f444945b, this.f444947d, r100, this.f444944a.f444934i));
        }

        public a(com.ss.android.lark.videosend.compress.a r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            super(r100);
        }
    }

    public static final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Boolean, Unit> f430951a;

        @Override // com.ss.android.lark.videosend.tools.VideoTools.b
        public final void a(float r100) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Boolean, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.f430951a = r100;
        }

        @Override // com.ss.android.lark.videosend.compress.b
        public final void b(ErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Log.e("FlowMediaCompressHelper", "onCompressError, error: " + r100.getErrorCode() + ", " + r100.getMessage() + ", " + r100.getDebugMsg());
            this.f430951a.invoke(Boolean.FALSE);
        }

        @Override // com.ss.android.lark.videosend.compress.b
        public final void c(VideoCompressResult r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Log.i("FlowMediaCompressHelper", "compressVideo success: " + r100.a().f444907m);
            this.f430951a.invoke(Boolean.TRUE);
        }
    }

    static {
        f430950a = new FlowMediaCompressHelper();
    }

    public FlowMediaCompressHelper() {
    }

    public static String b(Context r110, String r111, ImageInfo r112, com.ss.android.lark.image.uploader.entity.b r113) {
        if (r112 != null) goto L7;
        Log.e("FlowMediaCompressHelper", "failed to get imageInfo, uploadImage:" + r113 + ", skip compress");
        return "";
    L7:
        if (r113.f426388b == false) goto L9;
    L12:
        boolean r100 = true;
    L14:
        if (r100 == false) goto L17;
        Log.i("FlowMediaCompressHelper", "uploadImage:" + r113 + ", skip compress");
        return r111;
    L17:
        int[] r101 = blb.a.a(r112, null);
        int r102 = r101[0];
        int r103 = r101[1];
        if (r102 >= Math.min(r112.f426421a, r112.f426422b)) goto L20;
    L24:
        boolean r104 = false;
    L25:
        if (r104 == false) goto L28;
        Log.i("FlowMediaCompressHelper", "uploadImage:" + r113 + ", cal no need compress, skip compress");
        return r111;
    L28:
        zkb.a r105 = zkb.a.f572738a;
        String r106 = zkb.a.a(r110, r111, r101[0], r101[1]);
        if (new PolarisFileWrapper(r106).exists() == false) goto L31;
        Log.i("FlowMediaCompressHelper", "uploadImage:" + r113 + ", compress cache exist:" + r106);
    L34:
        return r106;
    L31:
        String r107 = r105.b(r106);
        blb.b r108 = blb.d.a(blb.e.a(r111, r112, r101[0]), r113, r112, r101[1], r107);
        if (r108 == null) goto L36;
        Log.i("FlowMediaCompressHelper", "compress finish, outputPath:" + r108.f19524a);
        Log.i("FlowMediaCompressHelper", "rename ret:" + r105.c(r107, r106) + ", tempPath:" + r107 + ", finalPath:" + r106);
        goto L34
    L36:
        if (r113.f426395i == false) goto L42;
        r113.f426395i = false;
        if (new PolarisFileWrapper(r107).exists() == false) goto L41;
        Log.e("FlowMediaCompressHelper", "delete last file");
        new PolarisFileWrapper(r107).delete();
    L41:
        return b(r110, r111, r112, r113);
    L42:
        return "";
    L20:
        if (r103 < r112.f426424d) goto L24;
        if (r112.f426428h != ImageUtils.ImageType.TYPE_JPG) goto L24;
        r104 = true;
        goto L25
    L9:
        if (r112.f426429i == true) goto L12;
        r100 = false;
        goto L14
    }

    public final Object a(Context r100, UplinkFileEntity r110, String r111, String r112, Continuation<? super String> r113) {
        if ((r113 instanceof FlowMediaCompressHelper$compress$1) == false) goto L7;
        FlowMediaCompressHelper$compress$1 r101 = (FlowMediaCompressHelper$compress$1) r113;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r114 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L17;
        if (r104 != 2) goto L16;
        UplinkFileEntity r115 = (UplinkFileEntity) r101.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L20
    L45:
        return r114;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        UplinkFileEntity r116 = (UplinkFileEntity) r101.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L20
    L39:
        return r114;
    L22:
        ResultKt.throwOnFailure(r114);
        if (r100 != null) goto L25;
    L48:
        Log.e("FlowMediaCompressHelper", "compress context or localPath is empty");
        return null;
    L25:
        if (r111.length() != 0) goto L27;
        boolean r117 = true;
    L28:
        if (r117 == true) goto L48;
        if (new PolarisFileWrapper(r111).exists() == true) goto L35;
        Log.e("FlowMediaCompressHelper", "compress localPath file not exists: " + r111);     // Catch: Throwable -> L20
        return null;
    L35:
        if (wxa.f.d(r110) == false) goto L41;
        r101.L$0 = r110;     // Catch: Throwable -> L20
        r101.label = 1;     // Catch: Throwable -> L20
        r114 = BuildersKt.withContext(Dispatchers.getIO(), new FlowMediaCompressHelper$compressImage$2(r111, r100, null), r101);     // Catch: Throwable -> L20
        if (r114 != r103) goto L39;
        return r103;
    L41:
        if (wxa.f.e(r110) == false) goto L47;
        r101.L$0 = r110;     // Catch: Throwable -> L20
        r101.label = 2;     // Catch: Throwable -> L20
        r114 = BuildersKt.withContext(Dispatchers.getIO(), new FlowMediaCompressHelper$compressVideo$2(r111, r110, r112, null), r101);     // Catch: Throwable -> L20
        if (r114 != r103) goto L45;
        return r103;
    L47:
        return null;
    L27:
        r117 = false;
    L20:
        th = move-exception;
        Log.e("FlowMediaCompressHelper", "compress error, entity: " + r110 + ", message: " + th.getMessage());
    L7:
        r101 = new FlowMediaCompressHelper$compress$1(this, r113);
        goto L8
    }
}
