package im4;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import hm4.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f490534a = 0;

    static {
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static int b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "breakPointUpdate");
        hm4.b r101 = r100.f485934b;
        jm4.a.f499636a.getClass();
        if (Intrinsics.areEqual(r101, jm4.a.C6460a.f499638b) == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        return MathKt.roundToInt(TypedValue.applyDimension(1, r100.f485936d.f485914a, a(Resources.getSystem())));
    L15:
        if (Intrinsics.areEqual(r101, hm4.b.f485921f) == false) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == false) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == false) goto L27;
        return MathKt.roundToInt(TypedValue.applyDimension(1, 420, a(Resources.getSystem())));
    L27:
        return MathKt.roundToInt(TypedValue.applyDimension(1, 500, a(Resources.getSystem())));
    L23:
        r107 = Intrinsics.areEqual(r101, hm4.b.f485924i);
        goto L24
    L20:
        r106 = Intrinsics.areEqual(r101, hm4.b.f485923h);
        goto L21
    L17:
        r105 = Intrinsics.areEqual(r101, hm4.b.f485922g);
        goto L18
    L11:
        r104 = Intrinsics.areEqual(r101, hm4.b.f485920e);
        goto L12
    L8:
        r103 = Intrinsics.areEqual(r101, hm4.b.f485919d);
        goto L9
    L5:
        r102 = Intrinsics.areEqual(r101, hm4.b.f485918c);
        goto L6
    }
}
