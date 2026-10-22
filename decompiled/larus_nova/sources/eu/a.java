package eu;

import com.bytedance.android.gamecp.host_api.service.FmpCalculator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f473969a = 0;

    static {
    }

    public static void a(FmpCalculator r100) {
        Intrinsics.checkNotNullParameter(r100, "fmpCalculator");
        com.bytedance.android.gamecp.host_api.a.b().getHostFmpCalculatorService().J(r100);
    }
}
