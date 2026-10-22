package tq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ WikiMovToFragment a;
    public final /* synthetic */ TreeNode b;

    public a(WikiMovToFragment r1, TreeNode r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        gq5.d.m(this.a.Y90().getSpaceId());
        gq5.d.l("confirm", this.a.Y90().getSpaceId());
        this.a.ea0(this.b);
    }
}
