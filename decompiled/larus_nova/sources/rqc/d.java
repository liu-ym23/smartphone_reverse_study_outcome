package rqc;

import android.view.View;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropActivity f538963a;

    public d(UCropActivity r100) {
        this.f538963a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UCropActivity r101 = this.f538963a;
        GestureCropImageView r102 = r101.f464384r;
        r102.v(-r102.getCurrentAngle());
        r101.f464384r.setImageToWrapCropBounds(true);
    }
}
