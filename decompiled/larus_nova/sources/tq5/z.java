package tq5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f547211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WikiSelectorBean f547212b;

    public z(x r100, WikiSelectorBean r101) {
        this.f547211a = r100;
        this.f547212b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = x.f547194k;
        tt5.a.d("WikiMoveToWikiCommand", "getMoveNodeAuthorizedUserInfo()...failed, error = " + r101);
        Toast.cancelLoading();
        if (tp5.b.b(r101, 920004109) == false) goto L6;
        Toast.showFailureText(this.f547211a.getContext(), this.f547211a.getContext().getResources().getString(R.string.CreationMobile_Wiki_MoveToSpace_NoWorkspaceAdmin));
        return;
    L6:
        if (tp5.b.b(r101, 920004112) == false) goto L8;
        Toast.showFailureText(this.f547211a.getContext(), xo5.a.c(this.f547211a.getContext(), R.string.CreationMobile_Wiki_MoveToSpace_UnableToMove_PermChange, "page", this.f547212b.f241134g));
        return;
    L8:
        Toast.showFailureText(this.f547211a.getContext(), this.f547211a.getContext().getResources().getString(R.string.Doc_Doc_LoadFailed));
    }
}
