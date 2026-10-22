package zi5;

import android.view.View;
import com.bytedance.ee.bear.middleground.record.viewhistory.ViewHistoryFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ ViewHistoryFragment a;

    public g(ViewHistoryFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.bytedance.ee.bear.middleground.record.a.c("setting", "ccm_space_docs_details_setting_view");
        wi5.a r6 = (wi5.a) org.koin.java.a.a(wi5.a.class);
        ViewHistoryFragment r0 = this.a;
        r6.a(r0.f, r0.e, "record", r0);
    }
}
