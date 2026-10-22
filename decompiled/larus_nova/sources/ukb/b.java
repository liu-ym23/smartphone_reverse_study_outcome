package ukb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements ResourceTranscoder<Bitmap, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f550579a;

    public b(Context r100) {
        this.f550579a = r100.getResources();
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource<BitmapDrawable> transcode(Resource<Bitmap> r100, Options r101) {
        Resources r102 = this.f550579a;
        if (r100 != null) goto L6;
        return null;
    L6:
        return new c(r102, r100);
    }
}
