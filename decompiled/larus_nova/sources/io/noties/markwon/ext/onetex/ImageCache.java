package io.noties.markwon.ext.onetex;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lio/noties/markwon/ext/onetex/ImageCache;", "Landroidx/collection/LruCache;", "", "Landroid/graphics/Bitmap;", "markwon-ext-onetex_release"}, k = 1, mv = {1, 4, 0})
public final class ImageCache extends LruCache<String, Bitmap> {
    public ImageCache() {
        super(5000);
    }

    @Override // androidx.collection.LruCache
    public final int sizeOf(String r100, Bitmap r101) {
        return r101.getByteCount() / 1024;
    }

    @Override // androidx.collection.LruCache
    public final void entryRemoved(boolean r100, String r101, Bitmap r102, Bitmap r103) {
        Bitmap r104 = r102;
        if (r104.isRecycled() == true) goto L6;
        r104.recycle();
        return;
    }
}
