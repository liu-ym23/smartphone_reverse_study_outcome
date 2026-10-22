package aq3;

import android.view.View;
import com.bytedance.android.window.shop.innerflow.holder.element.presenter.ECWindowInnerFlowVideoElementPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends a {
    public final vp.c n;
    public final vp.c o;

    public final QIPresenter h() {
        return new ECWindowInnerFlowVideoElementPresenter(this.n, this.o);
    }

    public g(View r2, vp.c r3, vp.c r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "videoPlayerProxy");
        super(r2, yp3.h.a);
        this.n = r3;
        this.o = r4;
    }
}
