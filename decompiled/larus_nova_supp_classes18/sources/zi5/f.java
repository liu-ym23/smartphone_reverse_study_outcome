package zi5;

import android.view.View;
import com.bytedance.ee.bear.middleground.record.viewhistory.ViewHistoryFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ ViewHistoryFragment a;

    public f(ViewHistoryFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ViewHistoryFragment r3 = this.a;
        int r0 = ViewHistoryFragment.q;
        r3.U90();
        this.a.p.pull();
    }
}
