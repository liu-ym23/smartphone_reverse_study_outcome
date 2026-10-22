package i52;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsPublicScreenMessageViewHolder f488303a;

    public d(AbsPublicScreenMessageViewHolder r100) {
        this.f488303a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        AbsPublicScreenMessageViewHolder r101 = this.f488303a;
        r101.f133722b = false;
        r101.d3();
        return false;
    }
}
