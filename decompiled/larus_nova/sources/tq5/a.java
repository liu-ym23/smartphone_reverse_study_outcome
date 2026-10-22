package tq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiMovToFragment f547140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TreeNode f547141b;

    public a(WikiMovToFragment r100, TreeNode r101) {
        this.f547140a = r100;
        this.f547141b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gq5.d.m(this.f547140a.Y90().getSpaceId());
        gq5.d.l("confirm", this.f547140a.Y90().getSpaceId());
        this.f547140a.ea0(this.f547141b);
    }
}
