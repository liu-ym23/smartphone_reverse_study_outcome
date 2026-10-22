package vq3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.search.presenter.WindowSearchHistoryPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends QUIModule {
    public final View l;

    public final QIPresenter h() {
        return new WindowSearchHistoryPresenter();
    }

    public b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        super(-1, null);
        this.l = r3;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
