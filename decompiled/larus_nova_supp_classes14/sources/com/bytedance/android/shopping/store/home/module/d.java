package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.l0;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends b {
    public final boolean d() {
        return true;
    }

    public final QIPresenter h() {
        return new l0(this.l);
    }

    public final List<QUIModule> i() {
        ArrayList r0 = new ArrayList();
        r0.add(new e(this.l));
        r0.add(new m(this.l));
        return r0;
    }

    public d(Fragment r2) {
        super(2131371060, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r2) {
        View r3 = q.a.a(this, 2131560867);
        r3.setVisibility(0);
        return r3;
    }
}
