package ij2;

import android.content.Context;
import android.util.LruCache;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class d {
    public List<? extends b> a;
    public final LruCache<String, a> b;
    public final Context c;

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.a = CollectionsKt.emptyList();
        this.b = new LruCache(4);
    }
}
