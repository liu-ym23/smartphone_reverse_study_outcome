package i52;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f488301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsPublicScreenMessageViewHolder f488302b;

    public c(View.OnClickListener r100, AbsPublicScreenMessageViewHolder r101) {
        this.f488301a = r100;
        this.f488302b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f488301a.onClick(r100);
        AbsPublicScreenMessageViewHolder r101 = this.f488302b;
        r101.f133722b = false;
        r101.d3();
    }
}
