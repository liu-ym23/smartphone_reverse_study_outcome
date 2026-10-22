package e55;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements RequestListener<Drawable> {
    public b() {
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException r100, Object r101, Target<Drawable> r102, boolean r103) {
        tt5.a.e("LikeCircleImageView", "glide onLoadFailed(), error=", r100, false);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final /* bridge */ /* synthetic */ boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
        return false;
    }
}
