package dq3;

import android.view.View;
import android.view.ViewGroup;
import aq3.h;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends com.bytedance.android.window.shop.home.module.a {
    public final View m;

    public final QIPresenter h() {
        return new com.bytedance.android.window.shop.innerflow.presenter.c();
    }

    public final List<QUIModule> i() {
        ArrayList r0 = new ArrayList();
        r0.add(new c(this.m.findViewById(2131370918)));
        r0.add(new a(this.m.findViewById(2131370907)));
        r0.add(new h());
        return r0;
    }

    public b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "root");
        super(null);
        this.m = r2;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r1) {
        return this.m;
    }
}
