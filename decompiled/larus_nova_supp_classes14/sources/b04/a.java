package b04;

import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements k {
    public final /* synthetic */ b a;

    public final void c(String r1) {
    }

    public final void d(String r1, long r2, int r4) {
    }

    public final void e(String r1, int r2, String r3) {
    }

    public final void f(String r1, boolean r2, int r3, int r4) {
    }

    public final void g(String r1, boolean r2, String r3) {
    }

    public final void onPlayPrepare(String r1) {
    }

    public a(b r1) {
        this.a = r1;
    }

    public final void h(String r2) {
        if (Intrinsics.areEqual(this.a.j, r2) == false) goto L6;
        this.a.h().a.b(Boolean.FALSE);
        return;
    }

    public final void onPlaying(String r2) {
        if (Intrinsics.areEqual(this.a.j, r2) == false) goto L6;
        this.a.h().a.b(Boolean.TRUE);
        return;
    }

    public final void l(String r1, l r2) {
        Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
    }
}
