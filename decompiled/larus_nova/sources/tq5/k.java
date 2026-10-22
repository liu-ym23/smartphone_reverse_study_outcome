package tq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiMovToFragment f547159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TreeNode f547160b;

    public k(WikiMovToFragment r100, TreeNode r101) {
        this.f547159a = r100;
        this.f547160b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gq5.d.l("confirm", this.f547159a.Y90().getSpaceId());
        this.f547159a.ea0(this.f547160b);
    }
}
