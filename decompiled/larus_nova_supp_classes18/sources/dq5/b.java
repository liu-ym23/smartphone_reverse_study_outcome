package dq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ HomeLibraryFragment a;

    public b(HomeLibraryFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        WikiTreeCtrlView r3 = this.a.Y90();
        int r0 = WikiTreeCtrlView.q;
        r3.l(null);
    }
}
