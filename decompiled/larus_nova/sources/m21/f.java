package m21;

import com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkUserListContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f511644a;

    public f(g r100) {
        this.f511644a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f511644a.d(r101);
        AnchorLinkUserListContract$View r102 = (AnchorLinkUserListContract$View) this.f511644a.f92392c;
        if (r102 == null) goto L7;
        r102.ba0(r101);
        return;
    }
}
