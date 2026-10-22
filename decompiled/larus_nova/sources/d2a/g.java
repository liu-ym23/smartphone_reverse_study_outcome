package d2a;

import android.animation.Animator;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f466565a = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [d2a.e] */
    static {
        f466565a = new e();
    }

    public static final void c(Animator r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "callback");
        b(r100, null, r101, null, 13);
    }

    public static final f a(Animator r100, Function1 r101, Function1 r102, Function1 r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r102, "onEnd");
        Intrinsics.checkNotNullParameter(r110, "onCancel");
        Intrinsics.checkNotNullParameter(r111, "onRepeat");
        f r103 = new f(r111, r100, r102, r110, r101);
        r100.addListener(r103);
        return r103;
    }

    public static /* synthetic */ f b(Animator r100, Function1 r101, Function1 r102, Function1 r103, int r104) {
        int r105 = r104 & 1;
        e r106 = f466565a;
        if (r105 == 0) goto L6;
        r101 = r106;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r106;
    L9:
        if ((r104 & 4) == 0) goto L11;
        e r107 = r106;
    L13:
        if ((r104 & 8) == 0) goto L16;
        r103 = r106;
    L16:
        return a(r100, r101, r102, r107, r103);
    L11:
        r107 = null;
        goto L13
    }
}
