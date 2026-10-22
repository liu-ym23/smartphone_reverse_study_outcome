package zi5;

import android.view.View;
import com.bytedance.ee.bear.middleground.record.viewhistory.ViewHistoryFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewHistoryFragment f572251a;

    public f(ViewHistoryFragment r100) {
        this.f572251a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ViewHistoryFragment r101 = this.f572251a;
        int r102 = ViewHistoryFragment.f234360q;
        r101.U90();
        this.f572251a.f234372p.pull();
    }
}
