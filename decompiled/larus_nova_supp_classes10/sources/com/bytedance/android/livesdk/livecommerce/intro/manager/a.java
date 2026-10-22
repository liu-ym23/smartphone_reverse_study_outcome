package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a {
    public int a;
    public final String b;
    public final View c;
    public final int d;
    public final Function2<View, Function0<Unit>, Unit> e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.intro.manager.a$a, reason: collision with other inner class name */
    public static final class C0065a {
    }

    static {
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public final boolean d() {
        int r0 = this.a;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public final int hashCode() {
        return (((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.a;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("AnimationRequest(card = ");
        r0.append(this.c.getClass().getSimpleName());
        r0.append('@');
        r0.append(this.c.hashCode());
        r0.append(", id=");
        r0.append(this.b);
        r0.append(", animType=");
        if (this.d != 0) goto L5;
        String r1 = "show";
    L6:
        r0.append(r1);
        r0.append(')');
        return r0.toString();
    L5:
        r1 = "hide";
        goto L6
    }

    public final boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if ((r4 instanceof a) == false) goto L16;
        a r5 = (a) r4;
        if (Intrinsics.areEqual(this.b, r5.b) == true) goto L10;
        return false;
    L10:
        if (this.d != r5.d) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, View r3, int r4, Function2<? super View, ? super Function0<Unit>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r5, "animation");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
