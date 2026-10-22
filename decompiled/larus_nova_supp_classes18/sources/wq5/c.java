package wq5;

import android.app.Activity;
import android.view.View;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ TreeNode b;
    public final /* synthetic */ Activity c;

    public c(a r1, TreeNode r2, Activity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        a r6 = this.a;
        String r0 = r6.b;
        String r7 = r6.d;
        String r1 = this.b.wiki_token;
        int r2 = lw4.a.g;
        o.a(r0, r7, r1, null, Boolean.valueOf(com.bytedance.ee.util.ui.a.a(this.c)));
    }
}
