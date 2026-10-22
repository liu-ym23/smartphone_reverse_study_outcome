package dq5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ HomeLibraryFragment a;

    public g(HomeLibraryFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
        CommonCreateButton r4 = this.a.V90();
        if (r4 == null) goto L6;
        r4.setEnableStyle(true);
        return;
    }
}
