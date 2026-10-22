package xl4;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import em4.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f564499a = null;

    static {
        f564499a = new b();
    }

    public b() {
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ void c(b r100, a r110, View r111, int r112, boolean r113, int r114, int r115, int r116) {
        if ((r116 & 32) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r116 & 64) == 0) goto L9;
        int r102 = 0;
    L10:
        r100.b(r110, r111, r112, r113, 0.0f, r101, r102, false);
        return;
    L9:
        r102 = r115;
        goto L10
    L5:
        r101 = r114;
        goto L7
    }

    public final void b(a r110, View r111, int r210, boolean r211, float r212, int r213, int r214, boolean r215) {
        Intrinsics.checkNotNullParameter(r110, "popover");
        Intrinsics.checkNotNullParameter(r111, "anchor");
        int[] r100 = new int[2];
        r111.getLocationOnScreen(r100);
        boolean r101 = false;
        int r102 = r100[0];
        int r103 = r100[1];
        r110.j(r210);
        r110.f564449i = r213;
        r110.f564450j = r214;
        r110.f564457q = true;
        int[] r112 = a.c(r110, r211, r210, r111.getMeasuredWidth(), r111.getMeasuredHeight());
        r110.j(3);
        if (r210 != 48) goto L5;
    L49:
        r110.j(r210);
        int r104 = r110.e();
        int r113 = r110.f();
        r110.j(3);
        int r114 = g.d(r111.getContext());
        int r115 = g.e(r111.getContext());
        int r105 = r103 + r112[1];
        if (r105 >= 0) goto L55;
        if (r215 == true) goto L55;
        b(r110, r111, 80, r211, r212, r213, -r214, true);
        return;
    L55:
        if ((r105 + r104) <= r114) goto L59;
        if (r215 == true) goto L59;
        b(r110, r111, 48, r211, r212, r213, -r214, true);
        return;
    L59:
        int r106 = r112[0] + r102;
        if (r106 >= 0) goto L76;
        if (r211 == false) goto L65;
        b(r110, r111, r210, false, r212, r213, r214, true);
        return;
    L65:
        if (r212 != 0.0f) goto L67;
        boolean r107 = true;
    L68:
        if (r107 == false) goto L73;
        if (r213 != 0) goto L73;
        if (r214 != 0) goto L73;
        r110.l(r111, r210, r211, (((MathKt.roundToInt(TypedValue.applyDimension(1, 25, a(Resources.getSystem()))) + r102) + (r111.getMeasuredWidth() / 2)) - r110.d()) - MathKt.roundToInt(TypedValue.applyDimension(1, 3, a(Resources.getSystem()))), ((-(r102 + r112[0])) - r110.d()) + MathKt.roundToInt(TypedValue.applyDimension(1, 10, a(Resources.getSystem()))), r214);
        return;
    L73:
        c(this, r110, r111, r210, r211, 0, 0, 240);
        return;
    L67:
        r107 = false;
        goto L68
    L76:
        if ((r106 + r113) <= r115) goto L95;
        if (r211 == false) goto L85;
        b(r110, r111, r210, false, r212, r213, r214, true);     // Catch: Throwable -> L81
        return;
    L81:
        th = move-exception;
        throw th;
    L85:
        if (r212 != 0.0f) goto L87;
        boolean r108 = true;
    L88:
        if (r108 == false) goto L93;
        if (r213 != 0) goto L93;
        if (r214 != 0) goto L93;
        int r109 = (((r111.getWidth() / 2) + r102) - ((r115 - r110.f()) + MathKt.roundToInt(TypedValue.applyDimension(1, 3, a(Resources.getSystem()))))) - r110.d();
        float r116 = 10;
        Integer r117 = Integer.valueOf(r109 + MathKt.roundToInt(TypedValue.applyDimension(1, r116, a(Resources.getSystem()))));
        r110.l(r111, r210, r211, r117.floatValue(), (r115 - (((r102 + r112[0]) + r113) - r110.d())) - MathKt.roundToInt(TypedValue.applyDimension(1, r116, a(Resources.getSystem()))), r214);
        return;
    L93:
        c(this, r110, r111, r210, r211, 0, 0, 240);
        return;
    L87:
        r108 = false;
        goto L88
    L95:
        r110.l(r111, r210, r211, r212, r213, r214);
        return;
    L5:
        if (r210 == 80) goto L49;
        r110.j(r210);
        int r118 = r110.e();
        int r119 = r110.f();
        r110.j(3);
        int r120 = g.d(r111.getContext());
        int r121 = g.e(r111.getContext());
        int r122 = r102 + r112[0];
        if ((r122 + r213) >= 0) goto L13;
        if (r215 == false) goto L10;
        b(r110, r111, 48, r211, r212, -r214, -Math.abs(r213), true);
        return;
    L10:
        b(r110, r111, 5, r211, r212, -r213, r214, true);
        return;
    L13:
        if (((r122 + r119) + r213) <= r121) goto L18;
        if (r215 == false) goto L16;
        b(r110, r111, 48, r211, r212, -r214, -Math.abs(r213), true);
        return;
    L16:
        b(r110, r111, 3, r211, r212, -r213, r214, true);
        return;
    L18:
        int r123 = r112[1] + r103;
        if (r123 >= 0) goto L34;
        if (r211 == false) goto L24;
        b(r110, r111, r210, false, r212, r213, r214, true);
        return;
    L24:
        if (r212 != 0.0f) goto L26;
        r101 = true;
    L26:
        if (r101 == false) goto L31;
        if (r213 != 0) goto L31;
        if (r214 != 0) goto L31;
        r110.l(r111, r210, r211, (r103 - MathKt.roundToInt(TypedValue.applyDimension(1, 15, a(Resources.getSystem())))) + r111.getHeight(), r213, (-r103) - r112[1]);
        return;
    L31:
        c(this, r110, r111, r210, r211, 0, 0, 240);
        return;
    L34:
        if ((r123 + r118) <= r120) goto L48;
        if (r211 == false) goto L39;
        b(r110, r111, r210, false, r212, r213, r214, true);
        return;
    L39:
        if (r212 != 0.0f) goto L41;
        r101 = true;
    L41:
        if (r101 == false) goto L46;
        if (r213 != 0) goto L46;
        if (r214 != 0) goto L46;
        r110.l(r111, r210, r211, -(((r120 - (r111.getHeight() + r103)) - MathKt.roundToInt(TypedValue.applyDimension(1, 15, a(Resources.getSystem())))) + (r111.getHeight() / 2)), r213, r120 - ((r103 + r112[1]) + r118));
        return;
    L46:
        c(this, r110, r111, r210, r211, 0, 0, 240);
        return;
    L48:
        r110.l(r111, r210, r211, r212, r213, r214);
    }
}
