package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.internal.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<S extends c<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S[] f504877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f504878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f504879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f504880d;

    public a() {
    }

    public final S b() {
        monitor-enter(this);
        S[] r100 = this.f504877a;     // Catch: Throwable -> L23
        if (r100 != null) goto L7;
        r100 = (S[]) d();
        this.f504877a = r100;     // Catch: Throwable -> L23
    L9:
        int r101 = this.f504879c;     // Catch: Throwable -> L23
    L10:
        S r102 = r100[r101];     // Catch: Throwable -> L23
        if (r102 != null) goto L13;
        r102 = (S) c();
        r100[r101] = r102;     // Catch: Throwable -> L23
    L13:
        r101 = r101 + 1;     // Catch: Throwable -> L23
        if (r101 < r100.length) goto L16;
        r101 = 0;
    L16:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L23
        if (r102.a(this) == false) goto L10;
        this.f504879c = r101;     // Catch: Throwable -> L23
        this.f504878b++;     // Catch: Throwable -> L23
        r r103 = this.f504880d;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r103 == null) goto L22;
        r103.s(1);
    L22:
        return r102;
    L7:
        if (this.f504878b < r100.length) goto L9;
        Object[] r104 = Arrays.copyOf(r100, r100.length * 2);     // Catch: Throwable -> L23
        this.f504877a = (S[]) ((c[]) r104);     // Catch: Throwable -> L23
        r100 = (S[]) ((c[]) r104);
    L23:
        th = move-exception;
        throw th;
    }

    public abstract S c();

    public abstract c[] d();

    public final i1<Integer> getSubscriptionCount() {
        monitor-enter(this);
        r r100 = this.f504880d;     // Catch: Throwable -> L8
        if (r100 != null) goto L6;
        r100 = new r(this.f504878b);     // Catch: Throwable -> L8
        this.f504880d = r100;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r100;
    L8:
        th = move-exception;
        throw th;
    }

    public final void e(S r100) {
        monitor-enter(this);
        int r101 = this.f504878b - 1;     // Catch: Throwable -> L17
        this.f504878b = r101;     // Catch: Throwable -> L17
        r r102 = this.f504880d;     // Catch: Throwable -> L17
        int r103 = 0;
        if (r101 != 0) goto L6;
        this.f504879c = 0;     // Catch: Throwable -> L17
    L6:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L17
        Continuation[] r104 = r100.b(this);     // Catch: Throwable -> L17
        monitor-exit(this);
        int r105 = r104.length;
    L9:
        if (r103 >= r105) goto L14;
        Continuation r106 = r104[r103];
        if (r106 == null) goto L13;
        Result.Companion r107 = Result.Companion;
        r106.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
    L13:
        r103 = r103 + 1;
        goto L9
    L14:
        if (r102 == null) goto L25;
        r102.s(-1);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
