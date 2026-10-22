package yj3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.router.hybridpage.fragment.ShopClassificationHybridPageFragment;
import com.bytedance.android.shopping.store.router.hybridpage.presenter.page.f;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends QUIModule {
    public final View l;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 != null) goto L7;
        return null;
    L7:
        if ((r0 instanceof ShopClassificationHybridPageFragment) == false) goto L10;
        return new com.bytedance.android.shopping.store.router.hybridpage.presenter.page.a(r0);
    L10:
        return new f(r0);
    }

    public c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(0);
        this.l = r2;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
