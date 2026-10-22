package rqc;

import android.view.View;
import com.yalantis.ucrop.UCropActivity;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropActivity f538964a;

    public e(UCropActivity r100) {
        this.f538964a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UCropActivity r101 = this.f538964a;
        r101.f464384r.v(90);
        r101.f464384r.setImageToWrapCropBounds(true);
    }
}
