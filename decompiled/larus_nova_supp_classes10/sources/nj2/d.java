package nj2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.LivePromotionListRootPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends QUIModule {
    public final View l;
    public final Fragment m;

    public final QIPresenter h() {
        return new LivePromotionListRootPresenter(this.m);
    }

    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new a(this.l.findViewById(2131372612), this.m, false, null));
    }

    public d(View r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
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
