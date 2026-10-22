package nr1;

import com.bytedance.android.livesdk.player.LivePlayerMonitor;
import com.bytedance.android.livesdk.player.g0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vr1.a0;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LivePlayerMonitor f520168a;

    @Override // vr1.a0
    public final void b() {
        Intrinsics.checkNotNullParameter("", "enterFromMerge");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.f520168a.t("", "", 0);
    }

    @Override // vr1.a0
    public final void h() {
        this.f520168a.f154960f = 1;
    }

    public c(LivePlayerMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "livePlayerMonitor");
        this.f520168a = r100;
    }

    @Override // vr1.a0
    public final void a(int r100) {
        this.f520168a.f154959e = r100;
    }

    @Override // vr1.a0
    public final void f(long r110) {
        Intrinsics.checkNotNullParameter("", "enterFromMerge");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.f520168a.o(105, "ttplayer init failed", r110, "", "", "", "", 0);
    }

    @Override // vr1.a0
    public final void g(long r100) {
        Intrinsics.checkNotNullParameter("", "enterFromMerge");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.f520168a.n(r100, "", "", 0);
    }

    @Override // vr1.a0
    public final void c(int r100, String r101, long r102) {
        this.f520168a.q(new g0(r100, r101, r102));
    }

    @Override // vr1.a0
    public final void d(int r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter("", "enterFromMerge");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.f520168a.s(r110, r111, r112, "", "", "", "", 0);
    }

    @Override // vr1.a0
    public final void e(int r100, JSONObject r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "info");
        this.f520168a.q(new g0(r100, r101, r102));
    }
}
