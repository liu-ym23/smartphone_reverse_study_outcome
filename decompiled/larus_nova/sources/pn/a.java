package pn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f529890l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Fragment f529891m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1<Fragment, QIPresenter> f529892n;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return this.f529892n.invoke(this.f529891m);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f529890l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(View r100, Fragment r101, Function1<? super Fragment, ? extends QIPresenter> r102) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "presenterGenerator");
        super(0);
        this.f529890l = r100;
        this.f529891m = r101;
        this.f529892n = r102;
    }
}
