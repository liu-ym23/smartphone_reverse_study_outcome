package pj5;

import android.view.View;
import com.bytedance.ee.bear.more.fresh.DocFreshNessAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ DocFreshNessAdapter a;
    public final /* synthetic */ i b;

    public h(DocFreshNessAdapter r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        p r3 = this.a.a;
        if (r3 == null) goto L6;
        r3.b(this.b);
        return;
    }
}
