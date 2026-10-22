package lp;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.bytedance.android.ec.window.base.shop.screenAdapt.WindowDisplayMetricsInfo;
import com.bytedance.android.ec.window.base.shop.screenAdapt.unit.WindowSubunits;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<WindowDisplayMetricsInfo> f510174a = null;

    static {
        f510174a = new SparseArray();
    }

    public static DisplayMetrics a(Resources r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        e r101 = e.f510177u;
        if (r101.f510193p == false) goto L14;
        Field r102 = r101.f510194q;
        if (r102 == null) goto L17;
        Object r103 = r102.get(r100);     // Catch: Exception -> L15
        if (r103 == null) goto L13;
        return (DisplayMetrics) r103;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.util.DisplayMetrics");     // Catch: Exception -> L15
    L19:
        return null;
    L17:
        return null;
    L14:
        return null;
    }

    public static void b(Activity r100, float r101, int r102, float r103, float r104) {
        Resources r105 = th.a.f(r100);
        c(WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()), r101, r102, r103, r104);
        e r106 = e.f510177u;
        Application r107 = r106.f510178a;
        if (r107 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mApplication");
    L5:
        Resources r108 = null;
        if (r107 == null) goto L10;
        Resources r109 = th.a.f(r107);
        if (r109 == null) goto L10;
        DisplayMetrics r110 = WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics());
    L11:
        if (r110 == null) goto L13;
        c(r110, r101, r102, r103, r104);
    L13:
        Resources r111 = Resources.getSystem();
        DisplayMetrics r112 = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics());
        if (r112 == null) goto L16;
        c(r112, r101, r102, r103, r104);
    L16:
        DisplayMetrics r113 = a(th.a.f(r100));
        Application r114 = r106.f510178a;
        if (r114 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mApplication");
    L19:
        if (r114 == null) goto L21;
        r108 = th.a.f(r114);
    L21:
        DisplayMetrics r115 = a(r108);
        if (r113 == null) goto L24;
        c(r113, r101, r102, r103, r104);
    L24:
        if (r115 == null) goto L27;
        c(r115, r101, r102, r103, r104);
        return;
    L27:
        return;
    L10:
        r110 = null;
        goto L11
    }

    public static void c(DisplayMetrics r100, float r101, int r102, float r103, float r104) {
        e r105 = e.f510177u;
        r105.f510180c.getClass();
        r100.density = r101;
        r100.densityDpi = r102;
        r105.f510180c.getClass();
        r100.scaledDensity = r103;
        WindowSubunits r106 = r105.f510180c.f524677a;
        int r107 = c.f510173b[r106.ordinal()];
        if (r107 != 2) goto L5;
        r100.xdpi = r104 * 72.0f;
        return;
    L5:
        if (r107 != 3) goto L7;
        r100.xdpi = r104;
        return;
    L7:
        if (r107 != 4) goto L15;
        r100.xdpi = r104 * 25.4f;
        return;
    }
}
