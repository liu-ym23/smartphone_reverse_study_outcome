package rk2;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.ExplainCardPresenter;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.LiveExplainCardPresenterV2;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIAction;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends e {
    public final ExplainCardViewModel n;

    public static final class a {
    }

    static {
    }

    public final String b() {
        return "BOTTOM_RIGHT";
    }

    public final int j(QModel r1) {
        return 4;
    }

    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        r0.a(new ExplainCardPresenter());
        if (this.n.isFromLive() == false) goto L5;
        r0.a(new LiveExplainCardPresenterV2());
    L5:
        return r0;
    }

    public final List<QUIModule> i() {
        if (getContext() != null) goto L5;
        return null;
    L5:
        return CollectionsKt.listOf(new e[]{new b(), new l(), new c()});
    }

    public g(ExplainCardViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        this.n = r2;
    }

    public final QUIAction c(ArrayList r2) {
        Intrinsics.checkNotNullParameter(r2, "conflictModule");
        return QUIAction.REPLACE;
    }

    @Override // rk2.e
    public final void e(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.m = r4;
        FrameLayout r0 = new FrameLayout(r4);
        r0.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.d(112), -2));
        Unit r5 = Unit.INSTANCE;
        this.l = r0;
    }
}
