package m63;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.kolbuyershow.KolBuyerShowActivity;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KolBuyerShowActivity f512278a;

    public a(KolBuyerShowActivity r100) {
        this.f512278a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f512278a.finish();
    }
}
