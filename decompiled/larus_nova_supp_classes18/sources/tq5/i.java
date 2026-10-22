package tq5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ WikiMovToFragment a;
    public final /* synthetic */ TreeNode b;

    public i(WikiMovToFragment r1, TreeNode r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Boolean r4 = (Boolean) r3;
        tt5.a.h("Wiki_WikiMovToFragment", "requestMoveEnable: enable = " + r4);
        if (r4.booleanValue() == false) goto L5;
        WikiMovToFragment.ca0(this.a, this.b);
        return;
    L5:
        Toast.cancelLoading();
        Toast.showFailureText(this.a.getContext(), 2131889141);
    }
}
