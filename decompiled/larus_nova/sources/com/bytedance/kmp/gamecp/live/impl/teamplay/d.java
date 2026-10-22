package com.bytedance.kmp.gamecp.live.impl.teamplay;

import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements o, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<ab6.a> f252130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f252131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xa6.a f252132c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f252131b.clear();
    }

    @Override // com.bytedance.kmp.gamecp.live.impl.teamplay.c
    public final BehaviorSubject<ab6.a> a() {
        return this.f252130a;
    }

    public d(xa6.a r100, xa6.c r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "inst");
        this.f252132c = r100;
        int r102 = qa6.b.f532260a;
        qa6.b.a("TeamPlayRepository", "init ->>> ");
        int r103 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        this.f252130a = BehaviorSubject.create();
        this.f252131b = new CompositeDisposable();
    }
}
