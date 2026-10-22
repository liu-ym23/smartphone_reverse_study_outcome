package sk3;

import android.app.Activity;
import android.util.SparseArray;
import com.bytedance.android.shopping.store.utils.screenAdapt.DisplayMetricsInfo;
import com.bytedance.android.shopping.store.utils.screenAdapt.unit.Subunits;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements b {
    public g() {
    }

    @Override // sk3.b
    public final void a(Object r22, Activity r23) {
        Intrinsics.checkNotNullParameter(r22, "target");
        Intrinsics.checkNotNullParameter(r23, "activity");
        e r3 = e.u;
        r3.b.getClass();
        if ((r22 instanceof uk3.a) == false) goto L53;
        uk3.a r0 = (uk3.a) r22;
        float r6 = 0;
        if (r0.b() <= r6) goto L54;
        SparseArray<DisplayMetricsInfo> r4 = d.a;
        Intrinsics.checkNotNullParameter(r23, "activity");
        Intrinsics.checkNotNullParameter(r0, "customAdapt");
        float r2 = r0.b();
        if (r2 <= r6) goto L9;
    L13:
        boolean r1 = r0.g();
        r3.c.getClass();
        float r5 = 0.0f;
        if (0.0f <= r6) goto L16;
        float r7 = 0.0f;
    L17:
        if (r1 == false) goto L19;
        int r8 = r3.j;
    L20:
        int r9 = MathKt.roundToInt(((r2 + r7) + r8) * r3.f) & 1073741823;
        if (r1 == false) goto L23;
        int r10 = r9 | 1073741824;
    L25:
        if (r3.m == false) goto L27;
        int r11 = r10 | Integer.MIN_VALUE;
    L28:
        SparseArray<DisplayMetricsInfo> r12 = d.a;
        DisplayMetricsInfo r13 = r12.get(r11);
        if (r13 != null) goto L42;
        if (r1 == false) goto L32;
        int r14 = r3.j;
    L33:
        float r15 = (r14 * 1.0f) / r2;
        if (0.0f > r6) goto L37;
        r5 = (r3.f * 1.0f) / r3.d;
    L37:
        float r16 = r5 * r15;
        int r17 = (int) (160 * r15);
        int r18 = (int) (r3.j / r15);
        int r19 = (int) (r3.a() / r15);
        if (r1 == false) goto L40;
        int r110 = r3.j;
    L41:
        float r111 = (r110 * 1.0f) / r7;
        r12.put(r11, new DisplayMetricsInfo(r15, r17, r16, r111, r18, r19));
        int r112 = r19;
        int r113 = r18;
    L43:
        d.b(r23, r15, r17, r16, r111);
        r3.c.getClass();
        r3.c.getClass();
        int r20 = wk3.a.a;
        StringCompanionObject r21 = StringCompanionObject.INSTANCE;
        Locale r24 = Locale.ENGLISH;
        Object[] r25 = new Object[13];
        r25[0] = r23.getClass().getName();
        r25[1] = r23.getClass().getSimpleName();
        r25[2] = Boolean.valueOf(r1);
        if (r1 == false) goto L46;
        String r26 = "designWidthInDp";
    L47:
        r25[3] = r26;
        r25[4] = Float.valueOf(r2);
        if (r1 == false) goto L50;
        String r27 = "designWidthInSubunits";
    L51:
        r25[5] = r27;
        r25[6] = Float.valueOf(r7);
        r25[7] = Float.valueOf(r15);
        r25[8] = Float.valueOf(r16);
        r25[9] = Integer.valueOf(r17);
        r25[10] = Float.valueOf(r111);
        r25[11] = Integer.valueOf(r113);
        r25[12] = Integer.valueOf(r112);
        wk3.a.a(String.format(r24, "The %s has been adapted! \n%s Info: isBaseOnWidth = %s, %s = %f, %s = %f, targetDensity = %f, targetScaledDensity = %f, targetDensityDpi = %d, targetXdpi = %f, targetScreenWidthDp = %d, targetScreenHeightDp = %d", Arrays.copyOf(r25, 13)));
        return;
    L50:
        r27 = "designHeightInSubunits";
        goto L51
    L46:
        r26 = "designHeightInDp";
        goto L47
    L40:
        r110 = r3.a();
        goto L41
    L32:
        r14 = r3.a();
        goto L33
    L42:
        float r28 = r13.a;
        r17 = r13.b;
        float r29 = r13.c;
        r111 = r13.d;
        r113 = r13.e;
        r112 = r13.f;
        r15 = r28;
        r16 = r29;
        goto L43
    L27:
        r11 = r10 & Integer.MAX_VALUE;
        goto L28
    L23:
        r10 = r9 & (-1073741825);
        goto L25
    L19:
        r8 = r3.a();
        goto L20
    L16:
        r7 = r2;
        goto L17
    L9:
        if (r0.g() == false) goto L11;
        int r30 = r3.h;
    L12:
        r2 = r30;
        goto L13
    L11:
        r30 = r3.i;
        goto L12
    L54:
        return;
    }

    @Override // sk3.b
    public final void b(Object r5, Activity r6) {
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r6, "activity");
        int r1 = wk3.a.a;
        StringBuilder r2 = new StringBuilder("cancelAdapt：");
        r2.append(r5.getClass().getSimpleName());
        r2.append(";;");
        boolean r7 = r5 instanceof uk3.a;
        r2.append(r7);
        wk3.a.a(r2.toString());
        if (r7 == false) goto L14;
        wk3.a.a("cancelAdapt::true");
        SparseArray<DisplayMetricsInfo> r8 = d.a;
        Intrinsics.checkNotNullParameter(r6, "activity");
        e r9 = e.u;
        float r0 = r9.g;
        Subunits r3 = r9.c.a;
        int r4 = c.a[r3.ordinal()];
        if (r4 != 1) goto L7;
        float r10 = 72.0f;
    L11:
        r0 = r0 / r10;
    L12:
        d.b(r6, r9.d, r9.e, r9.f, r0);
        r9.c.getClass();
        r9.c.getClass();
        return;
    L7:
        if (r4 != 2) goto L12;
        r10 = 25.4f;
        goto L11
    }
}
