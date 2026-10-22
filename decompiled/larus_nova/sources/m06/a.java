package m06;

import com.bytedance.keva.Keva;
import com.bytedance.keva.ext.KevaMultiProcessCache;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f511487b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f511488a;

    static {
        f511487b = new a();
    }

    public a() {
        System.nanoTime();
        this.f511488a = KevaMultiProcessCache.getRepoSync("config_center_repo");
        System.nanoTime();
    }
}
