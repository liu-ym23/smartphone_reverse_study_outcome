package r95;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.scaleimageview.ImageViewState;
import com.bytedance.ee.bear.scaleimageview.SubsamplingScaleImageView;
import com.ss.android.lark.passportc.entity.UserSession;

/* JADX INFO: loaded from: classes16.dex */
public final class h extends SubsamplingScaleImageView implements d {
    public com.bytedance.ee.bear.drive.view.preview.imageviewer.b E2;
    public n65.b.a F2;
    public final c G2;
    public float H2;

    public class a extends SubsamplingScaleImageView.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f536720a;

        public a(h r100) {
            this.f536720a = r100;
        }
    }

    @Override // r95.d
    public String getViewTag() {
        return "DriveSubsamplingScaleImageView";
    }

    @Override // r95.d
    public final void d() {
        if (getStandScale() > 1.0f) goto L6;
        a(getStandScale(), false);
        return;
    }

    @Override // r95.d
    public RectF getDisplayRect() {
        return getContentRect();
    }

    public float getInitImageScale() {
        return Math.min((com.bytedance.ee.util.ui.n.t() * 1.0f) / this.G2.f536711e.outHeight, (com.bytedance.ee.util.ui.n.v() * 1.0f) / this.G2.f536711e.outWidth);
    }

    public float getStandScale() {
        return getScale() / this.H2;
    }

    @Override // r95.d
    public void setImageActionListener(n65.b.a r100) {
        this.F2 = r100;
    }

    @Override // r95.d
    public void setOnPhotoRequestListener(com.bytedance.ee.bear.drive.view.preview.imageviewer.b r100) {
        this.E2 = r100;
    }

    public h(Context r100, c r101) {
        super(r100);
        this.H2 = 1.0f;
        this.G2 = r101;
        setOrientation(-1);
        setScaleImageConfig(new SubsamplingScaleImageView.k(true, true));
    }

    @Override // r95.d
    public final void a(final float r100, final boolean r101) {
        postDelayed(new f(this, r100, r101), 50);
    }

    @Override // r95.d
    public final void c(z r100, UserSession r101) {
        tt5.a.h("preview_image", "DriveSubsamplingScaleImageView show()");
        setOnImageEventListener(new a(this));
        float r102 = getInitImageScale();
        setEagerLoadingEnabled(false);
        setMinimumScaleType(1);
        setMinScale(r102);
        setMaxScale(3.0f + r102);
        O(zl5.a.a(z75.b.a(r100.f225836d, r101)), new ImageViewState(r102, new PointF(0.0f, 0.0f), -1));
        this.H2 = r102;
    }
}
