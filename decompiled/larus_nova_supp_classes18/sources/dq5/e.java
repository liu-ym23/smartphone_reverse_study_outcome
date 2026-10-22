package dq5;

import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryEmptyContentView;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements WikiTreeCtrlView.b {
    public final /* synthetic */ HomeLibraryFragment a;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.b
    public final void onUpdate() {
        if (this.a.Y90().getViewModel().isEmpty() == false) goto L5;
        HomeLibraryEmptyContentView r0 = this.a.W90();
        UDEmptyState r1 = r0.a;
        r1.setImageRes(2131232547);
        r1.setTitle(null);
        r1.setDesc(r1.getContext().getString(2131887751));
        r1.setPrimaryText(r1.getContext().getString(2131887730));
        r1.setPrimaryClickListener(r0.c);
        r0.setVisibility(0);
        return;
    L5:
        this.a.W90().setVisibility(8);
    }

    public e(HomeLibraryFragment r1) {
        this.a = r1;
    }
}
