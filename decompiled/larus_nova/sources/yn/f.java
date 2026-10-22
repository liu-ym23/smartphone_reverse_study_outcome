package yn;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.home.presenter.ECWindowLinkageHeaderLivePresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f568465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f568466b;

    public f(LifecycleOwner r100, ECWindowLinkageHeaderLivePresenter.b r101) {
        this.f568465a = r100;
        this.f568466b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L6;
        r101.booleanValue();
        this.f568466b.b(r101.booleanValue());
        return;
    }
}
