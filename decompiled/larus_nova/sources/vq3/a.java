package vq3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.window.shop.search.presenter.WindowSearchGroupPresenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f556759l;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final List<QUIModule> i() {
        return CollectionsKt.mutableListOf(new QUIModule[]{new k(this.f556759l), new c(this.f556759l)});
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new WindowSearchGroupPresenter();
    }

    public a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(0);
        this.f556759l = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f556759l;
    }
}
