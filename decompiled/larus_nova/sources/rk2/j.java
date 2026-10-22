package rk2;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.v;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class j extends e {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final int j(QModel r100) {
        return 4;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new v();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final List<QUIModule> i() {
        View r100 = null;
        if (getContext() == null) goto L9;
        k r101 = new k(true);
        View r102 = this.f538245l;
        if (r102 == null) goto L7;
        r100 = r102.findViewById(R.id.layout_small_card_info);
    L7:
        r101.f538245l = r100;
        return CollectionsKt.listOf(r101);
    L9:
        return null;
    }

    public j() {
    }
}
