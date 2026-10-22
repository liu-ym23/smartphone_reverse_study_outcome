package i36;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends b {
    public a() {
    }

    @Override // i36.b
    public final long b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        long r101 = super.b(r100);
        if (r101 >= 0) goto L6;
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.j("get negative duration: " + r100 + ' ' + r101, LogLevel.W, "Monitor-Timeline");
        return 0;
    L6:
        return r101;
    }
}
