package s4;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f540517a = 0;

    /* JADX INFO: renamed from: s4.a$a, reason: collision with other inner class name */
    public static final class C7565a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f540518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f540519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f540520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f540521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f540522e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f540523f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7565a) == true) goto L8;
            return false;
        L8:
            C7565a r101 = (C7565a) r100;
            if (Double.compare(this.f540518a, r101.f540518a) == 0) goto L12;
            return false;
        L12:
            if (this.f540519b == r101.f540519b) goto L15;
            return false;
        L15:
            if (this.f540520c == r101.f540520c) goto L18;
            return false;
        L18:
            if (this.f540521d == r101.f540521d) goto L21;
            return false;
        L21:
            if (this.f540522e == r101.f540522e) goto L24;
            return false;
        L24:
            if (this.f540523f == r101.f540523f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r100 = Double.doubleToLongBits(this.f540518a);
            int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f540519b) * 31) + this.f540520c) * 31) + this.f540521d) * 31) + this.f540522e) * 31;
            if (this.f540523f == false) goto L5;
            int r102 = 1231;
        L7:
            return r101 + r102;
        L5:
            r102 = 1237;
            goto L7
        }

        public final String toString() {
            return "ScreenSizeInfo(density=" + this.f540518a + ", screenWidthPx=" + this.f540519b + ", screenHeightPx=" + this.f540520c + ", screenWidthDp=" + this.f540521d + ", screenHeightDp=" + this.f540522e + ", swappedWH=" + this.f540523f + ')';
        }

        public C7565a(double r100, int r101, int r102, int r103, int r104, boolean r105) {
            this.f540518a = r100;
            this.f540519b = r101;
            this.f540520c = r102;
            this.f540521d = r103;
            this.f540522e = r104;
            this.f540523f = r105;
        }
    }

    static {
    }

    public static int c(int r100, double r101) {
        return (int) ((((double) r100) / r101) + ((double) 0.5f));
    }

    public static C7565a a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r110.getResources().getConfiguration().orientation != 2) goto L5;
        boolean r100 = true;
    L6:
        Resources r101 = r110.getResources();
        double r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
        f r103 = f.f540533a;
        int r104 = f.b(r110);
        int r111 = f.a(r110);
        if (r100 == false) goto L9;
        if (r104 >= r111) goto L9;
    L11:
        boolean r112 = true;
    L13:
        if (r100 == false) goto L15;
        int r105 = Math.max(r104, r111);
    L16:
        int r106 = r105;
        if (r100 == false) goto L19;
        int r113 = Math.min(r104, r111);
    L20:
        int r107 = r113;
        return new C7565a(r102, r106, r107, c(r106, r102), c(r107, r102), r112);
    L19:
        r113 = Math.max(r104, r111);
        goto L20
    L15:
        r105 = Math.min(r104, r111);
    L9:
        if (r100 == true) goto L12;
        if (r104 > r111) goto L11;
    L12:
        r112 = false;
        goto L13
    L5:
        r100 = false;
        goto L6
    }

    public static int b(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == false) goto L10;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r102 = AppletRuntimeManager.f36749d;
        if (r102 == null) goto L7;
        int r103 = r102.getStatusBarHeight(r100);
    L8:
        if (r103 <= 0) goto L10;
        return r103;
    L7:
        r103 = 0;
    L10:
        int r104 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r104 > 0) goto L13;
        return 0;
    L13:
        return r100.getResources().getDimensionPixelSize(r104);
    }
}
