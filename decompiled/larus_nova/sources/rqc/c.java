package rqc;

import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements HorizontalProgressWheelView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropActivity f538962a;

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public final void a() {
        this.f538962a.f464384r.s();
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public final void c() {
        this.f538962a.f464384r.setImageToWrapCropBounds(true);
    }

    public c(UCropActivity r100) {
        this.f538962a = r100;
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public final void b(float r100) {
        this.f538962a.f464384r.v(r100 / 42.0f);
    }
}
