package vcb;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t6c.d f554141a;

    @Override // vcb.b
    public final void a() {
        t6c.d r100 = this.f554141a;
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L7;
        View r102 = r100.f544851i;
        if (r102 == null) goto L7;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
    L8:
        t6c.d r104 = this.f554141a;
        if (r104 == null) goto L13;
        q6c.c r105 = r104.f544843a;
        if (r105 == null) goto L13;
        s6c.a r106 = r105.c();
    L14:
        if (r106 == null) goto L18;
        t6c.d r107 = this.f554141a;
        if (r107 == null) goto L18;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r107.f544848f = r106;
    L18:
        t6c.d r108 = this.f554141a;
        if (r108 == null) goto L21;
        r108.c();
    L21:
        t6c.d r109 = this.f554141a;
        if (r109 == null) goto L24;
        r109.f();
    L24:
        t6c.d r110 = this.f554141a;
        if (r110 == null) goto L29;
        View r111 = r110.f544851i;
        if (r111 == null) goto L29;
        r101 = r111.getLayoutParams();
    L29:
        if (r103 == null) goto L39;
        if (r101 != null) goto L32;
        return;
    L32:
        if (Intrinsics.areEqual(r103, r101) == true) goto L41;
        r103.width = r101.width;
        r103.height = r101.height;
        t6c.d r112 = this.f554141a;
        if (r112 == null) goto L42;
        View r113 = r112.f544851i;
        if (r113 == null) goto L43;
        r113.setLayoutParams(r103);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L39:
        return;
    L13:
        r106 = null;
    L7:
        r103 = null;
        goto L8
    }

    public c(t6c.d r100) {
        this.f554141a = r100;
    }
}
