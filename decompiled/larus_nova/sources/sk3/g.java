package sk3;

import android.app.Activity;
import android.util.SparseArray;
import com.bytedance.android.shopping.store.utils.screenAdapt.DisplayMetricsInfo;
import com.bytedance.android.shopping.store.utils.screenAdapt.unit.Subunits;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements b {
    public g() {
    }

    @Override // sk3.b
    public final void a(Object r210, Activity r211) {
        Intrinsics.checkNotNullParameter(r210, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r211, "activity");
        e r100 = e.f542343u;
        r100.f542345b.getClass();
        if ((r210 instanceof uk3.a) == false) goto L53;
        uk3.a r101 = (uk3.a) r210;
        float r102 = 0;
        if (r101.b() <= r102) goto L54;
        SparseArray<DisplayMetricsInfo> r103 = d.f542340a;
        Intrinsics.checkNotNullParameter(r211, "activity");
        Intrinsics.checkNotNullParameter(r101, "customAdapt");
        float r104 = r101.b();
        if (r104 <= r102) goto L9;
    L13:
        boolean r105 = r101.g();
        r100.f542346c.getClass();
        float r106 = 0.0f;
        if (0.0f <= r102) goto L16;
        float r107 = 0.0f;
    L17:
        if (r105 == false) goto L19;
        int r108 = r100.f542353j;
    L20:
        int r109 = MathKt.roundToInt(((r104 + r107) + r108) * r100.f542349f) & 1073741823;
        if (r105 == false) goto L23;
        int r110 = r109 | 1073741824;
    L25:
        if (r100.f542356m == false) goto L27;
        int r111 = r110 | Integer.MIN_VALUE;
    L28:
        SparseArray<DisplayMetricsInfo> r112 = d.f542340a;
        DisplayMetricsInfo r113 = r112.get(r111);
        if (r113 != null) goto L42;
        if (r105 == false) goto L32;
        int r114 = r100.f542353j;
    L33:
        float r115 = (r114 * 1.0f) / r104;
        if (0.0f > r102) goto L37;
        r106 = (r100.f542349f * 1.0f) / r100.f542347d;
    L37:
        float r116 = r106 * r115;
        int r117 = (int) (160 * r115);
        int r118 = (int) (r100.f542353j / r115);
        int r119 = (int) (r100.a() / r115);
        if (r105 == false) goto L40;
        int r120 = r100.f542353j;
    L41:
        float r121 = (r120 * 1.0f) / r107;
        r112.put(r111, new DisplayMetricsInfo(r115, r117, r116, r121, r118, r119));
        int r122 = r119;
        int r123 = r118;
    L43:
        d.b(r211, r115, r117, r116, r121);
        r100.f542346c.getClass();
        r100.f542346c.getClass();
        int r124 = wk3.a.f560094a;
        StringCompanionObject r125 = StringCompanionObject.INSTANCE;
        Locale r126 = Locale.ENGLISH;
        Object[] r127 = new Object[13];
        r127[0] = r211.getClass().getName();
        r127[1] = r211.getClass().getSimpleName();
        r127[2] = Boolean.valueOf(r105);
        if (r105 == false) goto L46;
        String r128 = "designWidthInDp";
    L47:
        r127[3] = r128;
        r127[4] = Float.valueOf(r104);
        if (r105 == false) goto L50;
        String r129 = "designWidthInSubunits";
    L51:
        r127[5] = r129;
        r127[6] = Float.valueOf(r107);
        r127[7] = Float.valueOf(r115);
        r127[8] = Float.valueOf(r116);
        r127[9] = Integer.valueOf(r117);
        r127[10] = Float.valueOf(r121);
        r127[11] = Integer.valueOf(r123);
        r127[12] = Integer.valueOf(r122);
        wk3.a.a(String.format(r126, "The %s has been adapted! \n%s Info: isBaseOnWidth = %s, %s = %f, %s = %f, targetDensity = %f, targetScaledDensity = %f, targetDensityDpi = %d, targetXdpi = %f, targetScreenWidthDp = %d, targetScreenHeightDp = %d", Arrays.copyOf(r127, 13)));
        return;
    L50:
        r129 = "designHeightInSubunits";
        goto L51
    L46:
        r128 = "designHeightInDp";
        goto L47
    L40:
        r120 = r100.a();
        goto L41
    L32:
        r114 = r100.a();
        goto L33
    L42:
        float r130 = r113.f186966a;
        r117 = r113.f186967b;
        float r131 = r113.f186968c;
        r121 = r113.f186969d;
        r123 = r113.f186970e;
        r122 = r113.f186971f;
        r115 = r130;
        r116 = r131;
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
        int r132 = r100.f542351h;
    L12:
        r104 = r132;
        goto L13
    L11:
        r132 = r100.f542352i;
        goto L12
    L54:
        return;
    }

    @Override // sk3.b
    public final void b(Object r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "activity");
        int r102 = wk3.a.f560094a;
        StringBuilder r103 = new StringBuilder("cancelAdapt：");
        r103.append(r100.getClass().getSimpleName());
        r103.append(";;");
        boolean r104 = r100 instanceof uk3.a;
        r103.append(r104);
        wk3.a.a(r103.toString());
        if (r104 == false) goto L14;
        wk3.a.a("cancelAdapt::true");
        SparseArray<DisplayMetricsInfo> r105 = d.f542340a;
        Intrinsics.checkNotNullParameter(r101, "activity");
        e r106 = e.f542343u;
        float r107 = r106.f542350g;
        Subunits r108 = r106.f542346c.f555470a;
        int r109 = c.f542338a[r108.ordinal()];
        if (r109 != 1) goto L7;
        float r110 = 72.0f;
    L11:
        r107 = r107 / r110;
    L12:
        d.b(r101, r106.f542347d, r106.f542348e, r106.f542349f, r107);
        r106.f542346c.getClass();
        r106.f542346c.getClass();
        return;
    L7:
        if (r109 != 2) goto L12;
        r110 = 25.4f;
        goto L11
    }
}
