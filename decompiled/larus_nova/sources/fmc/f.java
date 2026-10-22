package fmc;

import com.ss.ugc.live.sdk.msg.network.HttpException;
import com.ss.ugc.live.sdk.msg.task.HistoryHttpException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements com.ss.ugc.live.sdk.msg.network.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f477899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.utils.j f477900b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.network.e
    public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    L18:
        th = move-exception;
        if ((th instanceof Exception) == false) goto L32;
        int r101 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        com.ss.ugc.live.sdk.msg.utils.g r102 = com.ss.ugc.live.sdk.msg.utils.g.a.a(th);
    L23:
        if ((r102 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L26;
        com.ss.ugc.live.sdk.msg.utils.g r103 = new com.ss.ugc.live.sdk.msg.utils.g.c(((com.ss.ugc.live.sdk.msg.utils.g.c) r102).f458479b);
    L28:
        this.f477900b.b(new com.ss.ugc.live.sdk.msg.utils.k(this.f477899a.f458505b, r103));
        return;
    L26:
        if ((r102 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L31;
        Exception r104 = (Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r102).f458478b;
        r103 = new com.ss.ugc.live.sdk.msg.utils.g.b(new HistoryHttpException(this.f477899a.f477903e, r104));
        goto L28
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        throw th;
    L4:
        if ((r100 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L14;
        com.ss.ugc.live.sdk.msg.network.g r105 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r100).f458479b;     // Catch: Throwable -> L18
        Object r106 = r105.f458315e;     // Catch: Throwable -> L18
        if ((r106 instanceof com.ss.ugc.live.sdk.msg.data.b) == true) goto L8;
        r106 = null;
    L8:
        com.ss.ugc.live.sdk.msg.data.b r107 = (com.ss.ugc.live.sdk.msg.data.b) r106;     // Catch: Throwable -> L18
        if (r105.a() == false) goto L12;
        if (r107 == null) goto L12;
        int r108 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;     // Catch: Throwable -> L18
        r102 = new com.ss.ugc.live.sdk.msg.utils.g.c(r107);     // Catch: Throwable -> L18
    L12:
        int r109 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;     // Catch: Throwable -> L18
        r102 = com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(r105.f458311a, com.ss.ugc.live.sdk.msg.utils.c.c(r105)));     // Catch: Throwable -> L18
        goto L23
    L14:
        if ((r100 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L17;
        r102 = new com.ss.ugc.live.sdk.msg.utils.g.b(((com.ss.ugc.live.sdk.msg.utils.g.b) r100).f458478b);     // Catch: Throwable -> L18
        goto L23
    L17:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L18
    }

    public f(g r100, com.ss.ugc.live.sdk.msg.utils.j r101) {
        this.f477899a = r100;
        this.f477900b = r101;
    }
}
