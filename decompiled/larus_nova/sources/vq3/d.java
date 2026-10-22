package vq3;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.product.presenter.element.mainimage.ECWindowProductCardMainImagePresenter;
import com.bytedance.android.ec.window.base.product.presenter.element.recommend.ECWindowProductCardRecommendInfoElementPresenter;
import com.bytedance.android.window.shop.search.presenter.WindowSearchProductCardGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends xo.a {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        Fragment r100 = a().i();
        if (r100 == null) goto L5;
        WindowSearchProductCardGroupPresenter r101 = new WindowSearchProductCardGroupPresenter(r100);
        r101.d0(new ECWindowProductCardRecommendInfoElementPresenter(r100));
        r101.d0(new com.bytedance.android.ec.window.base.product.presenter.element.title.a(r100));
        r101.d0(new com.bytedance.android.ec.window.base.product.presenter.element.tags.c(r100));
        r101.d0(new com.bytedance.android.ec.window.base.product.presenter.element.price.a(r100));
        r101.d0(new com.bytedance.android.ec.window.base.product.presenter.element.source.a(r100));
        r101.d0(new ECWindowProductCardMainImagePresenter(r100));
        return r101;
    L5:
        return null;
    }

    public d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }
}
