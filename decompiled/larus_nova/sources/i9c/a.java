package i9c;

import android.view.View;
import com.ss.android.lark.ug.banner.ui.template.BannerTemplateView;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerTemplateView f488830a;

    public a(BannerTemplateView r100) {
        this.f488830a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        f9c.a r101 = this.f488830a.f444394g;
        if (r101 == null) goto L6;
        r101.onClose(r100);
        return;
    }
}
