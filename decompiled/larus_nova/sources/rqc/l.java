package rqc;

import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

/* JADX INFO: loaded from: classes41.dex */
public final class l implements HorizontalProgressWheelView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropFragment f538971a;

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public final void a() {
        this.f538971a.f464403l.s();
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public final void c() {
        this.f538971a.f464403l.setImageToWrapCropBounds(true);
    }

    public l(UCropFragment r100) {
        this.f538971a = r100;
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public final void b(float r100) {
        if (r100 <= 0.0f) goto L5;
        GestureCropImageView r101 = this.f538971a.f464403l;
        r101.w(r101.getCurrentScale() + (r100 * ((this.f538971a.f464403l.getMaxScale() - this.f538971a.f464403l.getMinScale()) / 15000.0f)), r101.f464442p.centerX(), r101.f464442p.centerY());
        return;
    L5:
        GestureCropImageView r102 = this.f538971a.f464403l;
        r102.x(r102.getCurrentScale() + (r100 * ((this.f538971a.f464403l.getMaxScale() - this.f538971a.f464403l.getMinScale()) / 15000.0f)));
    }
}
