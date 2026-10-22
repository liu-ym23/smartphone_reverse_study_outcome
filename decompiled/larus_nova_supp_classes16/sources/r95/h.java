package r95;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.scaleimageview.ImageViewState;
import com.bytedance.ee.bear.scaleimageview.SubsamplingScaleImageView;
import com.ss.android.lark.passportc.entity.UserSession;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends SubsamplingScaleImageView implements d {
    public com.bytedance.ee.bear.drive.view.preview.imageviewer.b E2;
    public n65.b.a F2;
    public final c G2;
    public float H2;

    public class a extends SubsamplingScaleImageView.g {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
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
        return Math.min((com.bytedance.ee.util.ui.n.t() * 1.0f) / this.G2.e.outHeight, (com.bytedance.ee.util.ui.n.v() * 1.0f) / this.G2.e.outWidth);
    }

    public float getStandScale() {
        return getScale() / this.H2;
    }

    @Override // r95.d
    public void setImageActionListener(n65.b.a r1) {
        this.F2 = r1;
    }

    @Override // r95.d
    public void setOnPhotoRequestListener(com.bytedance.ee.bear.drive.view.preview.imageviewer.b r1) {
        this.E2 = r1;
    }

    public h(Context r1, c r2) {
        super(r1);
        this.H2 = 1.0f;
        this.G2 = r2;
        setOrientation(-1);
        setScaleImageConfig(new SubsamplingScaleImageView.k(true, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r95.d
    public final void a(final float r2, final boolean r3) {
        postDelayed(new f(this, r2, r3), 50);
    }

    @Override // r95.d
    public final void c(z r4, UserSession r5) {
        tt5.a.h("preview_image", "DriveSubsamplingScaleImageView show()");
        setOnImageEventListener(new a(this));
        float r0 = getInitImageScale();
        setEagerLoadingEnabled(false);
        setMinimumScaleType(1);
        setMinScale(r0);
        setMaxScale(3.0f + r0);
        O(zl5.a.a(z75.b.a(r4.d, r5)), new ImageViewState(r0, new PointF(0.0f, 0.0f), -1));
        this.H2 = r0;
    }
}
