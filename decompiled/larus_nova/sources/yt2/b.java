package yt2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.ry0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569044a = 0;

    public static final Boolean a() {
        return ry0.f121167a.getValue();
    }

    static {
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("LiveWelfare", r100);
    }
}
