package tq5;

import android.content.Context;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ x a;

    public b0(x r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        int r0 = x.k;
        StringBuilder r1 = new StringBuilder("moveToWiki()...failed, error = ");
        r6.printStackTrace();
        r1.append(Unit.INSTANCE);
        tt5.a.d("WikiMoveToWikiCommand", r1.toString());
        Toast.cancelLoading();
        WikiAction r2 = WikiAction.MOV;
        Intrinsics.checkNotNull(r6);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a r3 = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a(r2, r6);
        WikiDialogs r7 = new WikiDialogs();
        if (k0.c(r3.d) == false) goto L6;
        return;
    L6:
        if (tp5.b.a(r3.d) != 900099011) goto L8;
        return;
    L8:
        if (tp5.b.a(r3.d) != 233525002) goto L11;
        r7.i(tp5.b.a(r3.d), this.a.getContext());
        return;
    L11:
        if (tp5.b.a(r3.d) != 90003088) goto L13;
        Toast.showFailureText(this.a.getContext(), 2131889781);
        return;
    L13:
        Context r8 = this.a.getContext();
        Map<String, Integer> r4 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        WikiDialogs.j(r8, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.d(r2, r3.d));
    }
}
