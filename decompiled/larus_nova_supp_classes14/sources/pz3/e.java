package pz3;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends pz3.a {
    public final View l;
    public final View m;
    public final f n;

    public static final class a {
    }

    static {
    }

    public final void f() {
        View r0 = this.g;
        if (r0 == null) goto L12;
        ViewGroup.LayoutParams r1 = this.e;
        if (r1 == null) goto L8;
        b.b(r0, r1);
        c.b("resetParamByUnbind");
    L8:
        if (d(r0) == null) goto L12;
        if (this.f == null) goto L12;
        b.b(d(r0), this.f);
        c.b("resetParamByUnbind");
    L12:
        this.b = x54.a.a(539);
        this.d = 2.1474836E9f;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = true;
    }

    public static View b(View r1) {
        Object r2 = r1.getParent().getParent();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
        return ((View) r2).findViewById(2131373354);
    }

    public static View c(View r1) {
        Object r2 = r1.getParent().getParent();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
        return ((View) r2).findViewById(2131392433);
    }

    public static View d(View r1) {
        Object r2 = r1.getParent().getParent();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
        return ((View) r2).findViewById(2131373355);
    }

    public static View e(View r1) {
        Object r2 = r1.getParent().getParent();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
        return ((View) r2).findViewById(2131392434);
    }

    public final void a(float r2) {
        if (r2 <= 120) goto L11;
        if (this.a == false) goto L17;
        Function0<Unit> r3 = this.n.a;
        if (r3 == null) goto L9;
        r3.invoke();
    L9:
        this.a = false;
        return;
    L17:
        return;
    L11:
        if (this.a == true) goto L19;
        Function0<Unit> r4 = this.n.b;
        if (r4 == null) goto L15;
        r4.invoke();
    L15:
        this.a = true;
        return;
    }

    public e(View r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "mRootView");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.l = r2;
        this.m = null;
        this.n = r3;
    }
}
