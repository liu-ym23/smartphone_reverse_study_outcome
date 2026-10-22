package com.bytedance.ies.bullet.preloadv2.cache;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public class g extends LruCache<String, PreloadItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247712a;

    public g(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        super(r101);
        this.f247712a = r100;
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r100, String r101, PreloadItem r102, PreloadItem r103) {
        String r104 = r101;
        PreloadItem r105 = r102;
        PreloadItem r106 = r103;
        super.entryRemoved(r100, r104, r105, r106);
        if (r106 != null) goto L13;
        int r107 = m26.f.f511670a;
        m26.f.c("移除缓存 " + this.f247712a + ", size " + size() + ", maxSize " + maxSize() + ", key " + r104);
        Integer r108 = null;
        if (StringsKt.contains$default(this.f247712a, "重定向", false, 2, null) == true) goto L14;
        StringBuilder r109 = new StringBuilder("移除对象 size ");
        if (r105 == null) goto L9;
        r108 = Integer.valueOf(r105.e());
    L9:
        r109.append(r108);
        m26.f.c(r109.toString());
        if (r105 == null) goto L15;
        r105.b();
        return;
    L15:
        return;
    L14:
        return;
    }
}
