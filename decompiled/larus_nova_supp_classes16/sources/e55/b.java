package e55;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements RequestListener<Drawable> {
    public b() {
    }

    public final boolean onLoadFailed(GlideException r1, Object r2, Target<Drawable> r3, boolean r4) {
        tt5.a.e("LikeCircleImageView", "glide onLoadFailed(), error=", r1, false);
        return false;
    }

    public final /* bridge */ /* synthetic */ boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
        Drawable r6 = (Drawable) r1;
        return false;
    }
}
