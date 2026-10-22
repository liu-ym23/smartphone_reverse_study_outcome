package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.internal.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class a<S extends c<?>> {
    public S[] a;
    public int b;
    public int c;
    public r d;

    public a() {
    }

    public final S b() {
        monitor-enter(this);
        S[] r0 = this.a;     // Catch: Throwable -> L23
        if (r0 != null) goto L7;
        r0 = (S[]) d();
        this.a = r0;     // Catch: Throwable -> L23
    L9:
        int r1 = this.c;     // Catch: Throwable -> L23
    L10:
        S r2 = r0[r1];     // Catch: Throwable -> L23
        if (r2 != null) goto L13;
        r2 = (S) c();
        r0[r1] = r2;     // Catch: Throwable -> L23
    L13:
        r1 = r1 + 1;     // Catch: Throwable -> L23
        if (r1 < r0.length) goto L16;
        r1 = 0;
    L16:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L23
        if (r2.a(this) == false) goto L10;
        this.c = r1;     // Catch: Throwable -> L23
        this.b++;     // Catch: Throwable -> L23
        r r3 = this.d;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r3 == null) goto L22;
        r3.s(1);
    L22:
        return r2;
    L7:
        if (this.b < r0.length) goto L9;
        Object[] r4 = Arrays.copyOf(r0, r0.length * 2);     // Catch: Throwable -> L23
        this.a = (S[]) ((c[]) r4);     // Catch: Throwable -> L23
        r0 = (S[]) ((c[]) r4);
    L23:
        th = move-exception;
        throw th;
    }

    public abstract S c();

    public abstract c[] d();

    public final i1<Integer> getSubscriptionCount() {
        monitor-enter(this);
        r r0 = this.d;     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = new r(this.b);     // Catch: Throwable -> L8
        this.d = r0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    public final void e(S r7) {
        monitor-enter(this);
        int r0 = this.b - 1;     // Catch: Throwable -> L17
        this.b = r0;     // Catch: Throwable -> L17
        r r2 = this.d;     // Catch: Throwable -> L17
        int r3 = 0;
        if (r0 != 0) goto L6;
        this.c = 0;     // Catch: Throwable -> L17
    L6:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L17
        Continuation[] r8 = r7.b(this);     // Catch: Throwable -> L17
        monitor-exit(this);
        int r1 = r8.length;
    L9:
        if (r3 >= r1) goto L14;
        Continuation r4 = r8[r3];
        if (r4 == null) goto L13;
        Result.Companion r5 = Result.Companion;
        r4.resumeWith(Result.m49constructorimpl(Unit.INSTANCE));
    L13:
        r3 = r3 + 1;
        goto L9
    L14:
        if (r2 == null) goto L25;
        r2.s(-1);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
