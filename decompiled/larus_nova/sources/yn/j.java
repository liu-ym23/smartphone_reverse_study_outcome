package yn;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.home.presenter.ECWindowLinkageHeaderLivePresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes44.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f568473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f568474b;

    public j(LifecycleOwner r100, ECWindowLinkageHeaderLivePresenter.b r101) {
        this.f568473a = r100;
        this.f568474b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.booleanValue() == false) goto L9;
        this.f568474b.onPlayComplete();
        return;
    }
}
