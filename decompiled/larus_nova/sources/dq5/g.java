package dq5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomeLibraryFragment f469671a;

    public g(HomeLibraryFragment r100) {
        this.f469671a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        CommonCreateButton r102 = this.f469671a.V90();
        if (r102 == null) goto L6;
        r102.setEnableStyle(true);
        return;
    }
}
