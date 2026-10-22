package pj5;

import android.view.View;
import com.bytedance.ee.bear.more.fresh.DocFreshNessAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ DocFreshNessAdapter b;

    public g(i r1, DocFreshNessAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        i r3 = this.a;
        if (r3.a == true) goto L5;
    L7:
        p r0 = this.b.a;
        if (r0 == null) goto L11;
        r0.a(r3);
        return;
    L11:
        return;
    L5:
        if (r3.i == true) goto L7;
    }
}
