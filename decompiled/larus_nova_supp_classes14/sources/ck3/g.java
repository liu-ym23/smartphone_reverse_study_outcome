package ck3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.search.presenter.ShopSearchResultContentPresenter;
import com.bytedance.android.shopping.store.search.presenter.ShopSearchResultTopBarPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends QUIModule {
    public final View l;
    public final Fragment m;

    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        r0.a(new ShopSearchResultContentPresenter(this.m));
        r0.a(new ShopSearchResultTopBarPresenter(this.m));
        return r0;
    }

    public g(View r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentContainer");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
