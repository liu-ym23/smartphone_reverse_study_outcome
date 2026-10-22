package rk2;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.v;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j extends e {
    public final int j(QModel r1) {
        return 4;
    }

    public final QIPresenter h() {
        return new v();
    }

    public final List<QUIModule> i() {
        View r1 = null;
        if (getContext() == null) goto L9;
        k r0 = new k(true);
        View r2 = this.l;
        if (r2 == null) goto L7;
        r1 = r2.findViewById(2131377629);
    L7:
        r0.l = r1;
        return CollectionsKt.listOf(r0);
    L9:
        return null;
    }

    public j() {
    }
}
