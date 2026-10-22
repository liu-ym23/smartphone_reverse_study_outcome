package zz7;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel4;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ZoomLevel6 f574096a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f574097a = null;

        static {
            int[] r100 = new int[ZoomLevel6.values().length];
            r100[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[ZoomLevel6.LARGE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[ZoomLevel6.LARGE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[ZoomLevel6.LARGE3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ZoomLevel6.LARGE4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[ZoomLevel6.NORMAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f574097a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final ZoomLevel6 d() {
        ZoomLevel6 r100 = f574096a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ZoomLevel6.NORMAL;
    }

    @JvmStatic
    public static final ZoomLevel4 e() {
        ZoomLevel6 r100 = d();
        int r101 = a.f574097a[r100.ordinal()];
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L22;
        if (r101 == 4) goto L21;
        if (r101 == 5) goto L20;
        return ZoomLevel4.NORMAL;
    L20:
        return ZoomLevel4.LARGE4;
    L21:
        return ZoomLevel4.LARGE3;
    L22:
        return ZoomLevel4.LARGE2;
    L23:
        return ZoomLevel4.LARGE1;
    L18:
        return ZoomLevel4.SMALL;
    }

    public static float c(LarkFont r100) {
        switch(a.f574097a[d().ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        int r101 = r100.getNormal();
    L11:
        return r101;
    L7:
        r101 = r100.getLarge2();
        goto L11
    L8:
        r101 = r100.getLarge1();
        goto L11
    L9:
        r101 = r100.getSmall();
        goto L11
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final float f(float r100) {
        return d().getMultiplier() * r100;
    }

    @JvmStatic
    public static final float j(int r100) {
        LarkFont[] r101 = LarkFont.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        LarkFont r104 = r101[r103];
        if (r104.getNormal() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        Intrinsics.checkNotNullParameter(r104, "larkFont");
        return b(r104, d());
    L10:
        return d().getMultiplier() * r100;
    }

    public static float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static float b(LarkFont r100, ZoomLevel6 r101) {
        switch(a.f574097a[r101.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        int r102 = r100.getNormal();
    L13:
        return r102;
    L7:
        r102 = r100.getLarge4();
        goto L13
    L8:
        r102 = r100.getLarge3();
        goto L13
    L9:
        r102 = r100.getLarge2();
        goto L13
    L10:
        r102 = r100.getLarge1();
        goto L13
    L11:
        r102 = r100.getSmall();
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final int g(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return MathKt.roundToInt(a(r100, d().getMultiplier() * r101));
    }

    @JvmStatic
    public static final float h(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarkFont[] r102 = LarkFont.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        LarkFont r105 = r102[r104];
        if (r105.getNormal() == r101) goto L7;
        r104 = r104 + 1;
        goto L3
    L7:
        return i(r100, r105);
    L10:
        return a(r100, d().getMultiplier() * r101);
    }

    @JvmStatic
    public static final float i(Context r100, LarkFont r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "larkFont");
        return a(r100, b(r101, d()));
    }
}
