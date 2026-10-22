package nlb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends SimpleTarget<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f519572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f519573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LargeImageView f519574c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        LargeImageView r101 = this.f519574c;
        g r102 = this.f519573b;
        int r103 = LargeImageView.f426673f;
        r101.s(r102);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        long r102 = System.currentTimeMillis() - this.f519572a;
        this.f519574c.r("get preview resource success, costTime:" + r102);
        if (this.f519574c.n(this.f519573b) == true) goto L6;
        this.f519574c.q(this.f519573b, r101);
        return;
    }

    public f(LargeImageView r100, long r101, g r102) {
        this.f519574c = r100;
        this.f519572a = r101;
        this.f519573b = r102;
    }
}
