package aq3;

import android.view.View;
import com.bytedance.android.window.shop.innerflow.holder.element.presenter.ECWindowInnerFlowBarrageElementPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends a {
    public final vp.c n;
    public final boolean o;

    public final QIPresenter h() {
        return new ECWindowInnerFlowBarrageElementPresenter(this.n, this.o);
    }

    public b(View r2, vp.c r3) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "barrageElementPlayerProxy");
        super(r2, yp3.a.a);
        this.n = r3;
        this.o = false;
    }
}
