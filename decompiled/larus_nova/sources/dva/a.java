package dva;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.bumptech.glide.load.engine.Resource;
import com.caverock.androidsvg.SVG;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Resource<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resource<SVG> f470224a;

    @Override // com.bumptech.glide.load.engine.Resource
    public final Bitmap get() {
        SVG r100 = this.f470224a.get();
        if (r100.f272756a == null) goto L11;
        int r101 = (int) r100.a(r100.f272757b).f272816c;
        if (r100.f272756a == null) goto L9;
        Bitmap r102 = Bitmap.createBitmap(r101, (int) r100.a(r100.f272757b).f272817d, Bitmap.Config.ARGB_8888);
        r100.e(new Canvas(r102));
        return r102;
    L9:
        throw new IllegalArgumentException("SVG document is empty");
    L11:
        throw new IllegalArgumentException("SVG document is empty");
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return this.f470224a.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
        this.f470224a.recycle();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    public a(Resource<SVG> r100) {
        Intrinsics.checkNotNullParameter(r100, "resource");
        this.f470224a = r100;
    }
}
