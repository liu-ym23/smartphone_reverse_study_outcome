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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final SparseArray<DisplayMetricsInfo> a = null;

    static {
        a = new SparseArray();
    }

    public static DisplayMetrics a(Resources r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        e r1 = e.u;
        if (r1.p == false) goto L14;
        Field r2 = r1.q;
        if (r2 == null) goto L17;
        Object r4 = r2.get(r3);     // Catch: Exception -> L15
        if (r4 == null) goto L13;
        return (DisplayMetrics) r4;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.util.DisplayMetrics");     // Catch: Exception -> L15
    L19:
        return null;
    L17:
        return null;
    L14:
        return null;
    }

    public static void b(Activity r5, float r6, int r7, float r8, float r9) {
        Resources r0 = r5.getResources();
        DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
        float r2 = r1.density;
        c(r1, r6, r7, r8, r9);
        ECShopABSettings.k.getClass();
        if (((Boolean) ECShopABSettings.h.getValue()).booleanValue() == false) goto L5;
        ViewConfiguration.get(r5);
    L5:
        j2 r3 = j2.g;
        StringBuilder r4 = new StringBuilder("call setDensity origin=");
        r4.append(r2);
        r4.append(" target=");
        r4.append(r6);
        r4.append(" debug_info=");
        Resources r10 = null;
        r4.append(r3.b(null));
        r4.append(" activity=");
        r4.append(r5);
        j2.d(r4.toString());
        e r11 = e.u;
        Application r12 = r11.a;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mApplication");
    L8:
        if (r12 == null) goto L12;
        Resources r13 = r12.getResources();
        if (r13 == null) goto L12;
        DisplayMetrics r14 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());
    L13:
        if (r14 == null) goto L15;
        c(r14, r6, r7, r8, r9);
    L15:
        Resources r15 = Resources.getSystem();
        DisplayMetrics r16 = WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics());
        if (r16 == null) goto L18;
        c(r16, r6, r7, r8, r9);
    L18:
        DisplayMetrics r17 = a(r5.getResources());
        Application r18 = r11.a;
        if (r18 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mApplication");
    L21:
        if (r18 == null) goto L23;
        r10 = r18.getResources();
    L23:
        DisplayMetrics r19 = a(r10);
        if (r17 == null) goto L26;
        c(r17, r6, r7, r8, r9);
    L26:
        if (r19 == null) goto L29;
        c(r19, r6, r7, r8, r9);
        return;
    L29:
        return;
    L12:
        r14 = null;
        goto L13
    }

    public static void c(DisplayMetrics r2, float r3, int r4, float r5, float r6) {
        e r0 = e.u;
        r0.c.getClass();
        r2.density = r3;
        r2.densityDpi = r4;
        r0.c.getClass();
        r2.scaledDensity = r5;
        Subunits r7 = r0.c.a;
        int r8 = c.b[r7.ordinal()];
        if (r8 != 2) goto L5;
        r2.xdpi = r6 * 72.0f;
        return;
    L5:
        if (r8 != 3) goto L7;
        r2.xdpi = r6;
        return;
    L7:
        if (r8 != 4) goto L15;
        r2.xdpi = r6 * 25.4f;
        return;
    }
}
