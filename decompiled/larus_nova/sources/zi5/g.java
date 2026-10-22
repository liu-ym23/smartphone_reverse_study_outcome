package zi5;

import android.view.View;
import com.bytedance.ee.bear.middleground.record.viewhistory.ViewHistoryFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewHistoryFragment f572252a;

    public g(ViewHistoryFragment r100) {
        this.f572252a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.middleground.record.a.c("setting", "ccm_space_docs_details_setting_view");
        wi5.a r101 = (wi5.a) org.koin.java.a.a(wi5.a.class);
        ViewHistoryFragment r102 = this.f572252a;
        r101.a(r102.f234362f, r102.f234361e, "record", r102);
    }
}
