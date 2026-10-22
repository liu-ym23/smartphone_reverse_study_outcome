package rqc;

import android.view.View;
import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.view.GestureCropImageView;

/* JADX INFO: loaded from: classes41.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropFragment f538969a;

    public j(UCropFragment r100) {
        this.f538969a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UCropFragment r101 = this.f538969a;
        GestureCropImageView r102 = r101.f464403l;
        r102.v(-r102.getCurrentAngle());
        r101.f464403l.setImageToWrapCropBounds(true);
    }
}
