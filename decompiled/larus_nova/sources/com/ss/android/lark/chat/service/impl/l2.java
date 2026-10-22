package com.ss.android.lark.chat.service.impl;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class l2 implements m6b.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f416540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f416541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f416542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f416543d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.r
    public final void a() {
        Disposable r100 = this.f416543d;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // m6b.r
    public final void d() {
        Disposable r100 = this.f416542c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Inject
    public l2(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f416540a = r100;
        this.f416541b = r101;
    }

    @Override // m6b.r
    public final void b(final h2 r100, final e2 r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f416543d = y0.a("ThreadPushRepositoryV2", this.f416540a, new ThreadPushRepositoryV2$subscribeMyThreadsReplyPromptPush$1(this, r100, r101));
    }

    @Override // m6b.r
    public final void c(final g2 r100, final e2 r101) {
        Intrinsics.checkNotNullParameter(r100, "onReceive");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        d();
        this.f416542c = y0.a("ThreadPushRepositoryV2", this.f416540a, new ThreadPushRepositoryV2$subscribeThreadsPush$1(this, r100, r101));
    }
}
