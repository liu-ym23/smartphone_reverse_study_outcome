package com.bytedance.kmp.livesdk.gift.platform.core.extra;

import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements qc6.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BehaviorSubject<List<g0>> f252256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f252257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xc6.a f252258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f252259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i12.e f252260e;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // qc6.a
    public final com.bytedance.revenue.platform.api.core.rx.b a() {
        return new com.bytedance.revenue.platform.api.core.rx.b(this.f252256a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f252257b.clear();
    }

    public f(xc6.a r100, g r101, i12.e r102) {
        Intrinsics.checkNotNullParameter(r100, "giftExtraDataStore");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "scope");
        this.f252258c = r100;
        this.f252259d = r101;
        this.f252260e = r102;
        int r103 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        this.f252256a = BehaviorSubject.createDefault(com.bytedance.revenue.platform.api.core.c.a(new g0[0]));
        this.f252257b = new CompositeDisposable();
    }
}
