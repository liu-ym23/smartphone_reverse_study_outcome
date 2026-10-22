package tq5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ x a;
    public final /* synthetic */ WikiSelectorBean b;

    public z(x r1, WikiSelectorBean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        int r0 = x.k;
        tt5.a.d("WikiMoveToWikiCommand", "getMoveNodeAuthorizedUserInfo()...failed, error = " + r6);
        Toast.cancelLoading();
        if (tp5.b.b(r6, 920004109) == false) goto L6;
        Toast.showFailureText(this.a.getContext(), this.a.getContext().getResources().getString(2131887492));
        return;
    L6:
        if (tp5.b.b(r6, 920004112) == false) goto L8;
        Toast.showFailureText(this.a.getContext(), xo5.a.c(this.a.getContext(), 2131887495, ResourceData.KEY_PAGE, this.b.g));
        return;
    L8:
        Toast.showFailureText(this.a.getContext(), this.a.getContext().getResources().getString(2131887672));
    }
}
