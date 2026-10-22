package h9c;

import android.view.View;
import com.ss.android.lark.ug.banner.ui.normal.BannerNormalView;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerNormalView f484358a;

    public d(BannerNormalView r100) {
        this.f484358a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f9c.a r101 = this.f484358a.f444382i;
        if (r101 == null) goto L6;
        r101.onClose(r100);
        return;
    }
}
