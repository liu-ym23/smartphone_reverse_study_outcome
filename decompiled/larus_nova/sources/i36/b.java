package i36;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.h;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f488108a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f488108a = new JSONObject();
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f488108a.optLong(r100) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        long r101 = this.f488108a.optLong(r100);
        if (r101 != 0) goto L6;
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j("get null metric: " + r100, LogLevel.W, "Monitor-Timeline");
        return -1;
    L6:
        return r101;
    }

    public final void c(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f488108a.optLong(r100) != 0) goto L5;
        d(r100, r101);
        return;
    L5:
        if (h.h() == true) goto L10;
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j("redundancy record: " + r100 + ", " + r101, LogLevel.W, "Monitor-Timeline");
        return;
    }

    public final void d(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 != null) goto L12;
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j("record with null metric: " + r100 + ", " + r101, LogLevel.W, "Monitor-Timeline");
        return;
    L12:
        this.f488108a.put(r100, r101.longValue());     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.j("record exception: key=" + r100 + ", msg=" + e.getMessage(), LogLevel.W, "Monitor-Timeline");
    }
}
