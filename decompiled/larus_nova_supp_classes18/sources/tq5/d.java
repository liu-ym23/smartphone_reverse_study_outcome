package tq5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ WikiMovToFragment a;
    public final /* synthetic */ TreeNode b;

    public d(WikiMovToFragment r1, TreeNode r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        tt5.a.d("Wiki_WikiMovToFragment", "needShowSinglePageOwnerTips failed, error = " + ((Throwable) r3));
        Toast.cancelLoading();
        WikiMovToFragment.da0(this.a, this.b);
    }
}
