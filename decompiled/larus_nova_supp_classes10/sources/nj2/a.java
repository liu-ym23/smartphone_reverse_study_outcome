package nj2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.LivePromotionListGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QUIModule {
    public final View l;
    public final Fragment m;
    public final boolean n;
    public final String o;

    public final List<QUIModule> i() {
        return CollectionsKt.mutableListOf(new QUIModule[]{new com.bytedance.android.livesdk.livecommerce.iron.listheader.c(this.l.findViewById(2131378118)), new f(this.l.findViewById(2131383373), this.m, this.n, this.o), new e(this.l.findViewById(2131372865), this.m, this.o), new b(this.l.findViewById(2131374206), this.m, this.o), new c(this.l.findViewById(2131384992), this.m, this.o)});
    }

    public final QIPresenter h() {
        return new LivePromotionListGroupPresenter(this.m, this.o);
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }

    public a(View r2, Fragment r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
    }
}
