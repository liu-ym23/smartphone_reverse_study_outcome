package xx8;

import com.larus.camera.impl.utils.capture.ZoomRatio;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ZoomRatio f565353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565354b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f565355a = null;

        static {
            int[] r100 = new int[ZoomRatio.values().length];
            r100[ZoomRatio.RATIO_1X.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ZoomRatio.RATIO_2X.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ZoomRatio.RATIO_3X.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f565355a = r100;
        }
    }

    public i() {
        this.f565353a = ZoomRatio.RATIO_1X;
        this.f565354b = "ZoomRatioStep";
    }

    public final void a(float r100) {
        FLogger.f375446a.i(this.f565354b, "switchRatioStep: " + r100 + ", wideMinRatio:null");
        ZoomRatio r101 = ZoomRatio.RATIO_4X;
        if (r100 < r101.getRatio()) goto L5;
        this.f565353a = r101;
        return;
    L5:
        ZoomRatio r102 = ZoomRatio.RATIO_3X;
        if (r100 < r102.getRatio()) goto L8;
        this.f565353a = r102;
        return;
    L8:
        ZoomRatio r103 = ZoomRatio.RATIO_2X;
        if (r100 < r103.getRatio()) goto L11;
        this.f565353a = r103;
        return;
    L11:
        ZoomRatio r104 = ZoomRatio.RATIO_1X;
        if (r100 < r104.getRatio()) goto L18;
        this.f565353a = r104;
        return;
    }
}
