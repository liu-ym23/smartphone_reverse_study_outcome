package ys4;

import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f568988a;

    public a(LinearLayout r100) {
        this.f568988a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f568988a.setVisibility(8);
    }
}
