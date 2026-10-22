package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class p extends QPresenter implements bk2.d {
    public ExplainCardViewModel e;
    public final bk2.d f;

    public abstract void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r1);

    @Override // bk2.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.f.add(r2);
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.f.clearDisposable();
    }

    @Override // bk2.d
    public final Disposable ignore(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.f.ignore(r2);
    }

    @Override // bk2.d
    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.f.remove(r2);
    }

    public p() {
        bk2.b r0 = new bk2.b();
        Intrinsics.checkNotNullParameter(r0, "disposableContext");
        this.f = r0;
    }

    public void C() {
        clearDisposable();
    }

    public final void A(QModel r2) {
        if ((r2 instanceof com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c) == false) goto L11;
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3 = (com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c) r2;
        if ((r3.a() instanceof ExplainCardViewModel) == false) goto L12;
        QViewModel r0 = r3.a();
        if (r0 == null) goto L10;
        this.e = (ExplainCardViewModel) r0;
        D(r3);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel");
    L12:
        return;
    }
}
