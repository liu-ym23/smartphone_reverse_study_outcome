package tq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiMovToFragment f547157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TreeNode f547158b;

    public j(WikiMovToFragment r100, TreeNode r101) {
        this.f547157a = r100;
        this.f547158b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("Wiki_WikiMovToFragment", "requestMoveEnable()...error: " + ((Throwable) r100));
        WikiMovToFragment.ca0(this.f547157a, this.f547158b);
    }
}
