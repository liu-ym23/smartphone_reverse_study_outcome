package h9c;

import android.view.View;
import com.ss.android.lark.ug.banner.ui.normal.BannerNormalView;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerNormalView f484357a;

    public c(BannerNormalView r100) {
        this.f484357a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BannerNormalView r101 = this.f484357a;
        f9c.a r102 = r101.f444382i;
        if (r102 == null) goto L6;
        r102.a(r100, r101.f444383j);
        return;
    }
}
