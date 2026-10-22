package xp0;

import android.view.View;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.banner.AnchorShelfDisplayBannerItemViewHolder;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorShelfDisplayBannerItemViewHolder f564695a;

    public c(AnchorShelfDisplayBannerItemViewHolder r100) {
        this.f564695a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f564695a.f84541d.onClose();
    }
}
