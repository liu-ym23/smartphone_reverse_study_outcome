package loc;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f510167a;

    public d(ImageView r100) {
        this.f510167a = r100;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        super.onLoadFailed(r100);
        this.f510167a.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f510167a.setImageDrawable(r100);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        if (r101 == null) goto L7;
        this.f510167a.setImageDrawable(r101);
        return;
    }
}
