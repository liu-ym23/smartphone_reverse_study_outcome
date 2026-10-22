package kk2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter.ECFloatWindowCarouselPresenter;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends QUIModule {
    public a() {
        super(0);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECFloatWindowCarouselPresenter();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = th.a.c(r100, R.layout.ec_size_info_carousel_layout, r101, false);
        r102.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.d(112), -2));
        return r102;
    }
}
