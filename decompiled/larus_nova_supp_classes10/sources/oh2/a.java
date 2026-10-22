package oh2;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a extends QPresenter implements bk2.d {
    public IntroCardViewModel e;
    public e f;
    public c g;
    public final bk2.d h;

    public a() {
        this(0);
    }

    public abstract void D(h r1);

    @Override // bk2.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.h.add(r2);
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.h.clearDisposable();
    }

    @Override // bk2.d
    public final Disposable ignore(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.h.ignore(r2);
    }

    @Override // bk2.d
    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.h.remove(r2);
    }

    public void C() {
        clearDisposable();
    }

    public a(int r2) {
        bk2.b r3 = new bk2.b();
        Intrinsics.checkNotNullParameter(r3, "disposableContext");
        this.h = r3;
    }

    public final void A(QModel r2) {
        if ((r2 instanceof h) == false) goto L11;
        h r3 = (h) r2;
        if ((r3.a() instanceof IntroCardViewModel) == false) goto L12;
        QViewModel r0 = r3.a();
        if (r0 == null) goto L10;
        this.e = (IntroCardViewModel) r0;
        D(r3);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel");
    L12:
        return;
    }
}
