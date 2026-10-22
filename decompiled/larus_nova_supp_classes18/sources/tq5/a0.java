package tq5;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveNodePuller;
import dd5.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ x a;
    public final /* synthetic */ WikiSelectorBean b;
    public final /* synthetic */ String c;

    public a0(x r1, WikiSelectorBean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        MoveNodePuller.Result r4 = (MoveNodePuller.Result) r3;
        int r5 = x.k;
        tt5.a.h("WikiMoveToWikiCommand", "moveToWiki()...success");
        Toast.cancelLoading();
        Toast.showSuccessText(this.a.getContext(), 2131888334);
        s1.a.a.c(this.b.d, this.c);
        x r6 = this.a;
        String r0 = this.b.d;
        r6.getClass();
        td5.c.a(r0);
        if (yp5.c.i() == true) goto L5;
    L9:
        FragmentActivity r7 = this.a.b.getActivity();
        if (r7 == null) goto L15;
        r7.setResult(101, new Intent());
        r7.finish();
        return;
    L15:
        return;
    L5:
        if (ForsetiHelper.s(this.a.b) == false) goto L9;
        com.suite.lark.component.navroute.forseti.g r8 = com.suite.lark.component.navroute.forseti.f.b(this.a.b);
        if (r8 == null) goto L13;
        r8.c(101, new Bundle());
        return;
    }
}
