package yn;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.home.presenter.ECWindowLinkageHeaderLivePresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes44.dex */
public final class l<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f568478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f568479b;

    public l(LifecycleOwner r100, ECWindowLinkageHeaderLivePresenter.b r101) {
        this.f568478a = r100;
        this.f568479b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        this.f568479b.c();
    }
}
