package sk3;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.ViewConfiguration;
import com.bytedance.android.ec.core.utils.j2;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.utils.screenAdapt.DisplayMetricsInfo;
import com.bytedance.android.shopping.store.utils.screenAdapt.unit.Subunits;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<DisplayMetricsInfo> f542340a = null;

    static {
        f542340a = new SparseArray();
    }

    public static DisplayMetrics a(Resources r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        e r101 = e.f542343u;
        if (r101.f542359p == false) goto L14;
        Field r102 = r101.f542360q;
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
        Resources r105 = r100.getResources();
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());
        float r107 = r106.density;
        c(r106, r101, r102, r103, r104);
        ECShopABSettings.f186148k.getClass();
        if (((Boolean) ECShopABSettings.f186145h.getValue()).booleanValue() == false) goto L5;
        ViewConfiguration.get(r100);
    L5:
        j2 r108 = j2.f45623g;
        StringBuilder r109 = new StringBuilder("call setDensity origin=");
        r109.append(r107);
        r109.append(" target=");
        r109.append(r101);
        r109.append(" debug_info=");
        Resources r110 = null;
        r109.append(r108.b(null));
        r109.append(" activity=");
        r109.append(r100);
        j2.d(r109.toString());
        e r111 = e.f542343u;
        Application r112 = r111.f542344a;
        if (r112 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mApplication");
    L8:
        if (r112 == null) goto L12;
        Resources r113 = r112.getResources();
        if (r113 == null) goto L12;
        DisplayMetrics r114 = WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics());
    L13:
        if (r114 == null) goto L15;
        c(r114, r101, r102, r103, r104);
    L15:
        Resources r115 = Resources.getSystem();
        DisplayMetrics r116 = WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics());
        if (r116 == null) goto L18;
        c(r116, r101, r102, r103, r104);
    L18:
        DisplayMetrics r117 = a(r100.getResources());
        Application r118 = r111.f542344a;
        if (r118 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mApplication");
    L21:
        if (r118 == null) goto L23;
        r110 = r118.getResources();
    L23:
        DisplayMetrics r119 = a(r110);
        if (r117 == null) goto L26;
        c(r117, r101, r102, r103, r104);
    L26:
        if (r119 == null) goto L29;
        c(r119, r101, r102, r103, r104);
        return;
    L29:
        return;
    L12:
        r114 = null;
        goto L13
    }

    public static void c(DisplayMetrics r100, float r101, int r102, float r103, float r104) {
        e r105 = e.f542343u;
        r105.f542346c.getClass();
        r100.density = r101;
        r100.densityDpi = r102;
        r105.f542346c.getClass();
        r100.scaledDensity = r103;
        Subunits r106 = r105.f542346c.f555470a;
        int r107 = c.f542339b[r106.ordinal()];
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
