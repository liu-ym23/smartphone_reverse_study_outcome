package fe9;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f476627a = null;

    static {
        f476627a = new g();
    }

    public g() {
    }

    @Override // fe9.j
    public final void a(String r100, String r101, List<String> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "what");
        Intrinsics.checkNotNullParameter(r101, "where");
        Intrinsics.checkNotNullParameter(r103, "params");
    }

    @Override // fe9.j
    public final void b(List r100, Map r101) {
        Intrinsics.checkNotNullParameter("ScreenShareStartResult", "what");
        Intrinsics.checkNotNullParameter("FlowRTCScreenShareServiceImpl.startScreenShare", "where");
        Intrinsics.checkNotNullParameter(r101, "params");
    }
}
