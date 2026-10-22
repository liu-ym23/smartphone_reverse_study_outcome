package nj2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.LivePromotionListTopPresenter;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends QUIModule {
    public final View l;
    public final Fragment m;
    public final boolean n;
    public final String o;

    public final QIPresenter h() {
        return new LivePromotionListTopPresenter(this.m, this.o);
    }

    public final int j(QModel r1) {
        if (this.n == false) goto L5;
        return 8;
    L5:
        return 0;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public f(View r2, Fragment r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
    }
}
