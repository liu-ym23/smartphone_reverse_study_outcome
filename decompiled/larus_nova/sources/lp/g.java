package lp;

import android.app.Activity;
import android.util.SparseArray;
import com.bytedance.android.ec.window.base.shop.screenAdapt.WindowDisplayMetricsInfo;
import com.bytedance.android.ec.window.base.shop.screenAdapt.unit.WindowSubunits;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements b {
    public g() {
    }

    @Override // lp.b
    public final void a(Object r210, Activity r211) {
        Intrinsics.checkNotNullParameter(r210, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r211, "activity");
        e r100 = e.f510177u;
        r100.f510179b.getClass();
        if ((r210 instanceof np.a) == false) goto L59;
        np.a r101 = (np.a) r210;
        float r102 = 0;
        if (r101.b() <= r102) goto L60;
        SparseArray<WindowDisplayMetricsInfo> r103 = d.f510174a;
        Intrinsics.checkNotNullParameter(r211, "activity");
        Intrinsics.checkNotNullParameter(r101, "customAdapt");
        float r104 = r101.b();
        if (r104 <= r102) goto L9;
    L13:
        boolean r105 = r101.g();
        r100.f510180c.getClass();
        float r106 = 0.0f;
        if (0.0f <= r102) goto L16;
        float r107 = 0.0f;
    L17:
        if (r105 == false) goto L19;
        int r108 = r100.f510187j;
    L20:
        int r109 = MathKt.roundToInt(((r104 + r107) + r108) * r100.f510183f) & 1073741823;
        if (r105 == false) goto L23;
        int r110 = r109 | 1073741824;
    L25:
        if (r100.f510190m == false) goto L27;
        int r111 = r110 | Integer.MIN_VALUE;
    L28:
        SparseArray<WindowDisplayMetricsInfo> r112 = d.f510174a;
        WindowDisplayMetricsInfo r113 = r112.get(r111);
        if (r113 != null) goto L42;
        if (r105 == false) goto L32;
        int r114 = r100.f510187j;
    L33:
        float r115 = (r114 * 1.0f) / r104;
        if (0.0f > r102) goto L37;
        r106 = (r100.f510183f * 1.0f) / r100.f510181d;
    L37:
        float r116 = r106 * r115;
        int r117 = (int) (160 * r115);
        int r118 = (int) (r100.f510187j / r115);
        int r119 = (int) (r100.a() / r115);
        if (r105 == false) goto L40;
        int r120 = r100.f510187j;
    L41:
        float r121 = (r120 * 1.0f) / r107;
        r112.put(r111, new WindowDisplayMetricsInfo(r115, r117, r116, r121, r118, r119));
        int r122 = r119;
        int r123 = r118;
    L43:
        d.b(r211, r115, r117, r116, r121);
        r100.f510180c.getClass();
        r100.f510180c.getClass();
        StringCompanionObject r124 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L54
        Locale r125 = Locale.ENGLISH;     // Catch: Exception -> L54
        Object[] r126 = new Object[13];     // Catch: Exception -> L54
        r126[0] = r211.getClass().getName();     // Catch: Exception -> L54
        r126[1] = r211.getClass().getSimpleName();     // Catch: Exception -> L54
        r126[2] = Boolean.valueOf(r105);     // Catch: Exception -> L54
        if (r105 == false) goto L47;
        String r127 = "designWidthInDp";
    L48:
        r126[3] = r127;     // Catch: Exception -> L54
        r126[4] = Float.valueOf(r104);     // Catch: Exception -> L54
        if (r105 == false) goto L51;
        String r128 = "designWidthInSubunits";
    L52:
        r126[5] = r128;     // Catch: Exception -> L54
        r126[6] = Float.valueOf(r107);     // Catch: Exception -> L54
        r126[7] = Float.valueOf(r115);     // Catch: Exception -> L54
        r126[8] = Float.valueOf(r116);     // Catch: Exception -> L54
        r126[9] = Integer.valueOf(r117);     // Catch: Exception -> L54
        r126[10] = Float.valueOf(r121);     // Catch: Exception -> L54
        r126[11] = Integer.valueOf(r123);     // Catch: Exception -> L54
        r126[12] = Integer.valueOf(r122);     // Catch: Exception -> L54
        pp.a.a(String.format(r125, "The %s has been adapted! \n%s Info: isBaseOnWidth = %s, %s = %f, %s = %f, targetDensity = %f, targetScaledDensity = %f, targetDensityDpi = %d, targetXdpi = %f, targetScreenWidthDp = %d, targetScreenHeightDp = %d", Arrays.copyOf(r126, 13)));     // Catch: Exception -> L54
        return;
    L51:
        r128 = "designHeightInSubunits";
        goto L52
    L47:
        r127 = "designHeightInDp";
    L54:
        e = move-exception;
        e.toString();
        return;
    L40:
        r120 = r100.a();
        goto L41
    L32:
        r114 = r100.a();
        goto L33
    L42:
        float r129 = r113.f49657a;
        r117 = r113.f49658b;
        float r130 = r113.f49659c;
        r121 = r113.f49660d;
        r123 = r113.f49661e;
        r122 = r113.f49662f;
        r115 = r129;
        r116 = r130;
        goto L43
    L27:
        r111 = r110 & Integer.MAX_VALUE;
        goto L28
    L23:
        r110 = r109 & (-1073741825);
        goto L25
    L19:
        r108 = r100.a();
        goto L20
    L16:
        r107 = r104;
        goto L17
    L9:
        if (r101.g() == false) goto L11;
        int r131 = r100.f510185h;
    L12:
        r104 = r131;
        goto L13
    L11:
        r131 = r100.f510186i;
        goto L12
    L60:
        return;
    }

    @Override // lp.b
    public final void b(Object r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "activity");
        int r102 = pp.a.f530156a;
        StringBuilder r103 = new StringBuilder("cancelAdapt：");
        r103.append(r100.getClass().getSimpleName());
        r103.append(";;");
        boolean r104 = r100 instanceof np.a;
        r103.append(r104);
        pp.a.a(r103.toString());
        if (r104 == false) goto L14;
        pp.a.a("cancelAdapt::true");
        SparseArray<WindowDisplayMetricsInfo> r105 = d.f510174a;
        Intrinsics.checkNotNullParameter(r101, "activity");
        e r106 = e.f510177u;
        float r107 = r106.f510184g;
        WindowSubunits r108 = r106.f510180c.f524677a;
        int r109 = c.f510172a[r108.ordinal()];
        if (r109 != 1) goto L7;
        float r110 = 72.0f;
    L11:
        r107 = r107 / r110;
    L12:
        d.b(r101, r106.f510181d, r106.f510182e, r106.f510183f, r107);
        r106.f510180c.getClass();
        r106.f510180c.getClass();
        return;
    L7:
        if (r109 != 2) goto L12;
        r110 = 25.4f;
        goto L11
    }
}
