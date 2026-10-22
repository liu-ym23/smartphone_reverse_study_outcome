package pi2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.livesdk.livecommerce.livereplay.presenter.ECTopButtonUIPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends QUIModule {
    public final String l;
    public final ViewModelProvider.Factory m;

    public final QIPresenter h() {
        return new ECTopButtonUIPresenter(this.l, this.m);
    }

    public b(String r2, ViewModelProvider.Factory r3) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r3, "factory");
        super(0);
        this.l = r2;
        this.m = r3;
    }

    public final View f(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ShoppingAsyncInflater.e.getClass();
        return ShoppingAsyncInflater.a.a(r3).aU(2131560986, r4, false);
    }
}
