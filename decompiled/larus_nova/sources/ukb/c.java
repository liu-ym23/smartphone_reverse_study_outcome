package ukb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Resource<BitmapDrawable>, Initializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f550580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resource<Bitmap> f550581b;

    @Override // com.bumptech.glide.load.engine.Resource
    public final BitmapDrawable get() {
        return new a(this.f550580a, this.f550581b.get());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return this.f550581b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public final void initialize() {
        Resource<Bitmap> r100 = this.f550581b;
        if ((r100 instanceof Initializable) == false) goto L6;
        ((Initializable) r100).initialize();
        return;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
        if (this.f550581b.get().isRecycled() == true) goto L6;
        this.f550581b.recycle();
        return;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    public c(Resources r100, Resource<Bitmap> r101) {
        this.f550580a = (Resources) Preconditions.checkNotNull(r100);
        this.f550581b = (Resource) Preconditions.checkNotNull(r101);
    }
}
