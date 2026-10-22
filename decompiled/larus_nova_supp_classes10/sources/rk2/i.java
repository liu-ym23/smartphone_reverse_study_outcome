package rk2;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.ExtendInfoRootPresenter;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i extends e {
    public final QIPresenter h() {
        return new ExtendInfoRootPresenter();
    }

    public final List<QUIModule> i() {
        View r1 = null;
        if (getContext() == null) goto L13;
        e[] r0 = new e[2];
        j r2 = new j();
        View r3 = this.l;
        if (r3 == null) goto L7;
        View r4 = r3.findViewById(2131378881);
    L8:
        r2.l = r4;
        Unit r5 = Unit.INSTANCE;
        r0[0] = r2;
        h r6 = new h();
        View r7 = this.l;
        if (r7 == null) goto L11;
        r1 = r7.findViewById(2131372726);
    L11:
        r6.l = r1;
        r0[1] = r6;
        return CollectionsKt.listOf(r0);
    L7:
        r4 = null;
        goto L8
    L13:
        return null;
    }

    public i() {
    }

    public final int j(QModel r1) {
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_EXPLAIN_CARD_CLICKABLE() == false) goto L6;
        return 4;
    L6:
        return 0;
    }
}
