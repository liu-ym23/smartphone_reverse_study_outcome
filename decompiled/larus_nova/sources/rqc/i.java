package rqc;

import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

/* JADX INFO: loaded from: classes41.dex */
public final class i implements HorizontalProgressWheelView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropFragment f538968a;

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public final void a() {
        this.f538968a.f464403l.s();
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public final void c() {
        this.f538968a.f464403l.setImageToWrapCropBounds(true);
    }

    public i(UCropFragment r100) {
        this.f538968a = r100;
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
    public final void b(float r100) {
        this.f538968a.f464403l.v(r100 / 42.0f);
    }
}
