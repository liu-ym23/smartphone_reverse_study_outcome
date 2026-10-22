package rk2;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.AuctionV2CardPresenter;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIAction;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends e {
    public final String b() {
        return "EXPLAIN_CARD";
    }

    public final int j(QModel r1) {
        return 4;
    }

    public final QIPresenter h() {
        return new AuctionV2CardPresenter();
    }

    public c() {
    }

    public final QUIAction c(ArrayList r2) {
        Intrinsics.checkNotNullParameter(r2, "conflictModule");
        return QUIAction.REPLACE;
    }

    @Override // rk2.e
    public final void e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.m = r3;
        FrameLayout r0 = new FrameLayout(r3);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r4 = Unit.INSTANCE;
        this.l = r0;
    }
}
