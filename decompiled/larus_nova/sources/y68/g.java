package y68;

import fe9.j;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f2a.d f566401a;

    public g() {
        this.f566401a = new f2a.d("ScreenShare", "AVSDK");
    }

    @Override // fe9.j
    public final void b(List r100, final Map r101) {
        Intrinsics.checkNotNullParameter("ScreenShareStartResult", "what");
        Intrinsics.checkNotNullParameter("FlowRTCScreenShareServiceImpl.startScreenShare", "where");
        Intrinsics.checkNotNullParameter(r101, "params");
        f2a.c r102 = this.f566401a.a("ScreenShareStartResult");
        f2a.g r103 = r102.f475230c;
        r103.f475256d = "FlowRTCScreenShareServiceImpl.startScreenShare";
        r103.f475254b = r100;
        r102.f(new f(r101));
        f2a.c.c(r102, null, 15);
    }

    @Override // fe9.j
    public final void a(String r100, String r101, List<String> r102, final Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "what");
        Intrinsics.checkNotNullParameter(r101, "where");
        Intrinsics.checkNotNullParameter(r103, "params");
        f2a.c r104 = this.f566401a.b(r100);
        f2a.g r105 = r104.f475230c;
        r105.f475256d = r101;
        r105.f475254b = r102;
        r104.f(new e(r103));
        f2a.c.c(r104, null, 15);
    }
}
