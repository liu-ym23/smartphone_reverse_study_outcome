package kj2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QUIModule {
    public final View l;
    public final LivePromotionCardArgsV2 m;

    public final boolean d() {
        return true;
    }

    public final QIPresenter h() {
        LivePromotionCardArgsV2 r1 = this.m;
        return new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter.b(r1, r1.h, r1.i);
    }

    public a(View r2, LivePromotionCardArgsV2 r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "arguments");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
