package com.larus.camera.impl.utils;

import android.graphics.Bitmap;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.vlm.VLMFileDataType;
import com.larus.camera.api.vlm.VLMIntentTrackSource;
import com.larus.camera.api.vlm.VLMSceneType;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.platform.model.camera.ICameraEventExt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class CaptureResultDetectLogic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CaptureResultDetectLogic f322697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f322698b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f322699c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f322700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f322701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f322702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f322703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f322704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f322705f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ix8.d f322706g;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f322700a == r101.f322700a) goto L12;
            return false;
        L12:
            if (this.f322701b == r101.f322701b) goto L15;
            return false;
        L15:
            if (this.f322702c == r101.f322702c) goto L18;
            return false;
        L18:
            if (this.f322703d == r101.f322703d) goto L21;
            return false;
        L21:
            if (this.f322704e == r101.f322704e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f322705f, r101.f322705f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f322706g, r101.f322706g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f322700a * 31;
            long r101 = this.f322701b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f322702c;
            return ((((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f322703d) * 31) + this.f322704e) * 31) + this.f322705f.hashCode()) * 31) + this.f322706g.hashCode();
        }

        public final String toString() {
            return "IntentDetectAppLogInfo(status=" + this.f322700a + ", totalDuration=" + this.f322701b + ", preProcessDuration=" + this.f322702c + ", originImageSize=" + this.f322703d + ", compressedImageSize=" + this.f322704e + ", errMsg=" + this.f322705f + ", detectResult=" + this.f322706g + ')';
        }

        public /* synthetic */ a(int r110) {
            this(0, 0, 0, 0, 0, "", new ix8.d.a(ix8.e.c.f496406a));
        }

        public a(int r100, long r101, long r102, int r103, int r104, String r105, ix8.d r110) {
            Intrinsics.checkNotNullParameter(r105, "errMsg");
            Intrinsics.checkNotNullParameter(r110, "detectResult");
            this.f322700a = r100;
            this.f322701b = r101;
            this.f322702c = r102;
            this.f322703d = r103;
            this.f322704e = r104;
            this.f322705f = r105;
            this.f322706g = r110;
        }

        public static a a(a r110, int r111, long r112, long r113, int r114, int r115, String r116, ix8.d r117, int r210) {
            if ((r210 & 1) == 0) goto L5;
            int r100 = r110.f322700a;
        L7:
            if ((r210 & 2) == 0) goto L9;
            long r101 = r110.f322701b;
        L11:
            if ((r210 & 4) == 0) goto L13;
            long r102 = r110.f322702c;
        L15:
            if ((r210 & 8) == 0) goto L17;
            int r103 = r110.f322703d;
        L19:
            if ((r210 & 16) == 0) goto L21;
            int r104 = r110.f322704e;
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r105 = r110.f322705f;
        L27:
            if ((r210 & 64) == 0) goto L29;
            ix8.d r106 = r110.f322706g;
        L30:
            r110.getClass();
            Intrinsics.checkNotNullParameter(r105, "errMsg");
            Intrinsics.checkNotNullParameter(r106, "detectResult");
            return new a(r100, r101, r102, r103, r104, r105, r106);
        L29:
            r106 = r117;
            goto L30
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }
    }

    public CaptureResultDetectLogic() {
    }

    static {
        f322697a = new CaptureResultDetectLogic();
        f322698b = LazyKt.lazy(new t());
        f322699c = new a(0);
    }

    public static boolean a(CameraData r100) {
        Intrinsics.checkNotNullParameter(r100, "cameraData");
        boolean r101 = r100.getEnableCaptureDetectModeList().contains(r100.getCaptureMode());
        int r102 = od8.h0.f522875a;
        ICameraEventExt r103 = r100.getEventExt();
        Integer r104 = null;
        if (r103 == null) goto L7;
        JSONObject r105 = r103.enterCameraEventExt();
        if (r105 == null) goto L7;
        Integer r106 = Integer.valueOf(r105.optInt("action_bar_instruction_type"));
    L8:
        boolean r107 = od8.h0.f(r106);
        ICameraEventExt r108 = r100.getEventExt();
        if (r108 == null) goto L13;
        JSONObject r109 = r108.enterCameraEventExt();
        if (r109 == null) goto L13;
        r104 = Integer.valueOf(r109.optInt("action_bar_instruction_type"));
    L13:
        boolean r110 = od8.h0.i(r104);
        if (Intrinsics.areEqual(PollingConfigService.f326423a.f("edu_dg"), "1") == false) goto L16;
    L25:
        return false;
    L16:
        if (((oq9.j) f322698b.getValue()).c() == false) goto L25;
        if (r101 == false) goto L25;
        if (r100.getAddedAttachmentCount() > 0) goto L25;
        if (r107 == true) goto L25;
        if (r110 == true) goto L25;
        if (r100.getDisableCaptureDetect() == true) goto L25;
        return true;
    L7:
        r106 = null;
        goto L8
    }

    public final Object b(Bitmap r110, VLMSceneType r111, Continuation<? super ix8.d> r112) {
        if ((r112 instanceof CaptureResultDetectLogic$requestServerDetect$1) == false) goto L7;
        CaptureResultDetectLogic$requestServerDetect$1 r100 = (CaptureResultDetectLogic$requestServerDetect$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L19:
        ix8.d r105 = (ix8.d) r102;
        if (r105 != null) goto L23;
    L22:
        r105 = new ix8.d.a(new ix8.e.b("vlm service unavailable"));
    L23:
        ix8.g r106 = r105.a();
        f322699c = a.a(f322699c, 0, 0, r106.f496408a, r106.f496409b, r106.f496410c, null, null, 99);
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        f322699c = new a(0);
        List r107 = CollectionsKt.listOf(new ix8.b(r110, VLMFileDataType.IMAGE));
        Lazy r108 = f322698b;
        ix8.c r109 = new ix8.c(r107, r111, new ix8.a(Boxing.boxLong(((oq9.j) r108.getValue()).a()), 720.0f, ((oq9.j) r108.getValue()).d(), w.f322805b.b(), true, 8), VLMIntentTrackSource.MAIN_CAMERA, 8);
        IFlowCamera r113 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r113 == null) goto L22;
        r100.label = 1;
        r102 = r113.d(r109, r100);
        if (r102 != r103) goto L19;
        return r103;
    L7:
        r100 = new CaptureResultDetectLogic$requestServerDetect$1(this, r112);
        goto L8
    }
}
