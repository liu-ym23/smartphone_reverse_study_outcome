package m0;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;
import com.baidu.platform.comapi.bmsdk.BmLocated;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f511472b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, LottieComposition> f511473a;

    static {
        f511472b = new g();
    }

    public g() {
        if (r0.c.a.f535397a == false) goto L5;
        this.f511473a = new LruCache(20);
        return;
    L5:
        this.f511473a = new LruCache(BmLocated.ALIGN_RIGHT_BOTTOM);
    }

    public final LottieComposition a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return this.f511473a.get(r100);
    }

    public final void b(String r100, LottieComposition r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f511473a.put(r100, r101);
    }
}
