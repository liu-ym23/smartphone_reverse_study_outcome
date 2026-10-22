package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.q0;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends b {
    public final QIPresenter h() {
        return new q0(this.l);
    }

    public final List<QUIModule> i() {
        ArrayList r0 = new ArrayList();
        r0.add(new p(this.l));
        r0.add(new com.bytedance.android.shopping.store.home.slice.a(this.l));
        return r0;
    }

    public j(Fragment r2) {
        super(2131371092, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r1) {
        return q.a.a(this, 2131560944);
    }
}
