package qz6;

import androidx.collection.LruCache;
import com.baidu.platform.comapi.bmsdk.BmLocated;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f535377b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, com.bytedance.lottie.d> f535378a;

    static {
        f535377b = new g();
    }

    public g() {
        this.f535378a = new LruCache(BmLocated.ALIGN_RIGHT_BOTTOM);
    }
}
