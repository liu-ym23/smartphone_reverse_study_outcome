package m21;

import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorLinkUserListFragment;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends i21.c {
    public g(AnchorLinkUserListFragment r100) {
        super(r100);
    }

    @Override // i21.c
    public final void e(int r100) {
        Observable r101 = r31.b.a(r31.a.f535859a).c(4, false, r100, "", 3, 0);
        if (r101 == null) goto L8;
        ObservableSubscribeProxy r102 = (ObservableSubscribeProxy) r101.as(c());
        if (r102 == null) goto L9;
        r102.subscribe(new e(this), new f(this));
        return;
    L9:
        return;
    }
}
