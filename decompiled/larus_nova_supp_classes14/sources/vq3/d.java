package vq3;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.product.presenter.element.mainimage.ECWindowProductCardMainImagePresenter;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.window.shop.search.presenter.WindowSearchProductCardGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends xo.a {
    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 == null) goto L5;
        WindowSearchProductCardGroupPresenter r1 = new WindowSearchProductCardGroupPresenter(r0);
        r1.d0(new ECWindowProductCardRecommendInfoElementPresenter(r0));
        r1.d0(new com.bytedance.android.ec.window.base.product.presenter.element.title.a(r0));
        r1.d0(new com.bytedance.android.ec.window.base.product.presenter.element.tags.c(r0));
        r1.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.a(r0));
        r1.d0(new com.bytedance.android.ec.window.base.product.presenter.element.source.a(r0));
        r1.d0(new ECWindowProductCardMainImagePresenter(r0));
        return r1;
    L5:
        return null;
    }

    public d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }
}
