package sk3;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements b {
    public final b a;

    public h(b r1) {
        this.a = r1;
    }

    @Override // sk3.b
    public final void a(Object r5, Activity r6) {
        Intrinsics.checkNotNullParameter(r5, "target");
        Intrinsics.checkNotNullParameter(r6, "activity");
        e r0 = e.s;
        uk3.b r1 = e.u.r;
        if (r1 == null) goto L5;
        r1.b(r5, r6);
    L5:
        boolean r2 = r5 instanceof uk3.b;
        Object r3 = null;
        if (r2 == true) goto L8;
        Object r4 = null;
    L9:
        uk3.b r7 = (uk3.b) r4;
        if (r7 == null) goto L12;
        r7.b(r5, r6);
    L12:
        b r8 = this.a;
        if (r8 == null) goto L15;
        r8.a(r5, r6);
    L15:
        if (r2 == false) goto L18;
        r3 = r5;
    L18:
        uk3.b r9 = (uk3.b) r3;
        if (r9 == null) goto L21;
        r9.a(r5, r6);
    L21:
        if (r1 == null) goto L24;
        r1.a(r5, r6);
        return;
    L24:
        return;
    L8:
        r4 = r5;
        goto L9
    }

    @Override // sk3.b
    public final void b(Object r2, Activity r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "activity");
        b r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }
}
