package kk2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter.ECFloatWindowCarouselPresenter;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QUIModule {
    public a() {
        super(0);
    }

    public final QIPresenter h() {
        return new ECFloatWindowCarouselPresenter();
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        View r5 = th.a.c(r3, 2131560929, r4, false);
        r5.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.d(112), -2));
        return r5;
    }
}
