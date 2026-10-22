package qp3;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.home.header.presenter.WindowHeaderPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.android.window.shop.home.module.a {
    public final View m;

    public final QIPresenter h() {
        View r1 = this.m;
        Fragment r2 = a().i();
        if (r2 == null) goto L7;
        return new WindowHeaderPresenter(r1, r2);
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "root");
        super(-1);
        this.m = r2;
    }

    @Override // com.bytedance.android.window.shop.home.module.a
    public final View k(ViewGroup r1) {
        return this.m;
    }
}
