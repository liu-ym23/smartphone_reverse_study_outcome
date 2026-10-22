package wq5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l extends t {
    public final /* synthetic */ TreeNode c;
    public final /* synthetic */ j d;
    public final /* synthetic */ Activity e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        Bundle r6 = new Bundle();
        r6.putString("ccm_open_type", AnalyticConstant.OpenType.WIKI_CREATE_NEW.getType());
        TreeNode r0 = this.c;
        String r1 = r0.space_id;
        String r2 = this.d.d;
        String r3 = r0.wiki_token;
        int r4 = lw4.a.g;
        o.a(r1, r2, r3, r6, Boolean.valueOf(com.bytedance.ee.util.ui.a.a(this.e)));
    }

    public l(TreeNode r1, j r2, Activity r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
