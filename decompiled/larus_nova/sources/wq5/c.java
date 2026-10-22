package wq5;

import android.app.Activity;
import android.view.View;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f560718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TreeNode f560719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f560720c;

    public c(a r100, TreeNode r101, Activity r102) {
        this.f560718a = r100;
        this.f560719b = r101;
        this.f560720c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f560718a;
        String r102 = r101.f560705b;
        String r103 = r101.f560707d;
        String r104 = this.f560719b.wiki_token;
        int r105 = lw4.a.f511011g;
        o.a(r102, r103, r104, null, Boolean.valueOf(com.bytedance.ee.util.ui.a.a(this.f560720c)));
    }
}
