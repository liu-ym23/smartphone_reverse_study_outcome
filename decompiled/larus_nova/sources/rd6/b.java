package rd6;

import com.bytedance.lark.express.cache.CacheManager;
import com.bytedance.lark.express.exception.ExprException;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f537280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f537281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final wd6.a f537282c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final td6.a f537283d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CacheManager f537284e = null;

    public b() {
    }

    static {
        f537280a = new b();
        f537282c = new wd6.a();
        f537283d = new td6.a();
        f537284e = new CacheManager();
    }

    public static a a(Object r100, int r101, Throwable r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        Object r102 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r111 & 8) == 0) goto L13;
        r110 = null;
    L13:
        a r104 = new a(r102, r103, null, r110, null);
        if ((r110 instanceof ExprException) == false) goto L16;
        r104.f537276b = ((ExprException) r110).getErrorCode();
    L16:
        return r104;
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
