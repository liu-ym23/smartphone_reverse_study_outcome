package ys2;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568987a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        int r101 = zs2.a.f573474a;
        Intrinsics.checkNotNullParameter("SaaSDeepLink", "tag");
        ALogger.i("SaaSLogger", "[#SaaSDeepLink#]" + r100);
    }
}
