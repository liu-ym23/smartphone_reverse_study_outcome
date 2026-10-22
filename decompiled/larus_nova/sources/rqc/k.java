package rqc;

import android.view.View;
import com.yalantis.ucrop.UCropFragment;

/* JADX INFO: loaded from: classes41.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropFragment f538970a;

    public k(UCropFragment r100) {
        this.f538970a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UCropFragment r101 = this.f538970a;
        r101.f464403l.v(90);
        r101.f464403l.setImageToWrapCropBounds(true);
    }
}
