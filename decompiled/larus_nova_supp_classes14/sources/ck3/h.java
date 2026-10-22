package ck3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.search.presenter.n;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends QUIModule {
    public final ViewGroup l;

    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new QUIModule[]{new i(th.a.d(th.a.e(this.l.getContext(), true), 2131564594, this.l, 4)), new j(this.l.findViewById(2131372863)), new k(this.l.findViewById(2131387792))});
    }

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new n(r0);
    }

    public h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(0);
        this.l = r2;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
