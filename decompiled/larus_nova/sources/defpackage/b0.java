package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.module.b;
import com.bytedance.android.shopping.store.home.module.q;
import com.bytedance.android.shopping.store.home.presenter.s;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: classes42.dex */
public final class b0 extends b {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new s(this.f183787l);
    }

    public b0(Fragment r100) {
        super(R.id.ec_store_background_container, r100);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r100) {
        return q.a.a(this, R.layout.ec_store_layout_background);
    }
}
