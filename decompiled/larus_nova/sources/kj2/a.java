package kj2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f503688l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LivePromotionCardArgsV2 f503689m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final boolean d() {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        LivePromotionCardArgsV2 r100 = this.f503689m;
        return new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter.b(r100, r100.f150472h, r100.f150473i);
    }

    public a(View r100, LivePromotionCardArgsV2 r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "arguments");
        super(0);
        this.f503688l = r100;
        this.f503689m = r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f503688l;
    }
}
