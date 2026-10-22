package kj2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter.f;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends QUIModule {
    public final View l;
    public final LivePromotionCardArgsV2 m;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a n;
    public final Map<PromotionCardModuleName, Integer> o;

    public final QIPresenter h() {
        return new f(this.m, this.n, this.o);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public b(View r2, LivePromotionCardArgsV2 r3, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r4, Map<PromotionCardModuleName, Integer> r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "argument");
        Intrinsics.checkNotNullParameter(r4, "containerAbility");
        Intrinsics.checkNotNullParameter(r5, "moduleIdMap");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
    }
}
