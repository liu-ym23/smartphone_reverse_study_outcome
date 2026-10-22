package rk2;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.AuctionCardPresenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIAction;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends e {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final String b() {
        return "EXPLAIN_CARD";
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final int j(QModel r100) {
        return 4;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new AuctionCardPresenter();
    }

    public b() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QUIAction c(ArrayList r100) {
        Intrinsics.checkNotNullParameter(r100, "conflictModule");
        return QUIAction.REPLACE;
    }

    @Override // rk2.e, com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f538246m = r100;
        FrameLayout r101 = new FrameLayout(r100);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r102 = Unit.INSTANCE;
        this.f538245l = r101;
    }
}
