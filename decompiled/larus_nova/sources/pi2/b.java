package pi2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.livesdk.livecommerce.livereplay.presenter.ECTopButtonUIPresenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f529321l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewModelProvider.Factory f529322m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECTopButtonUIPresenter(this.f529321l, this.f529322m);
    }

    public b(String r100, ViewModelProvider.Factory r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "factory");
        super(0);
        this.f529321l = r100;
        this.f529322m = r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ShoppingAsyncInflater.f45268e.getClass();
        return ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_view_live_replay_top_button, r101, false);
    }
}
