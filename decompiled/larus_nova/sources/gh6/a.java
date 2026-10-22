package gh6;

import com.bytedance.android.live.livelink.platformapi.avclient.video.AndroidVideoStreamApi;
import ec6.b;
import fr2.m0;
import kotlin.jvm.internal.Intrinsics;
import sk0.c;
import uf2.x;
import vb6.g;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements pf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f481282a;

    public final b d() {
        ec6.a r100 = this.f481282a.j().r0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.r();
    }

    @Override // pf6.a
    public final void M() {
        b r100 = d();
        if (r100 == null) goto L8;
        sk0.a r101 = ((c) r100).f542319b;
        if (r101 == null) goto L9;
        r101.d();
        return;
    L9:
        return;
    }

    @Override // pf6.a
    public final boolean a() {
        b r100 = d();
        if (r100 == null) goto L7;
        uk0.a r101 = ((c) r100).f542323f;
        if (r101 == null) goto L7;
        return r101.c();
    L7:
        return false;
    }

    @Override // pf6.a
    public final x b() {
        b r100 = d();
        if (r100 == null) goto L7;
        AndroidVideoStreamApi r101 = ((c) r100).f542322e;
        if (r101 == null) goto L7;
        return r101.b();
    L7:
        return null;
    }

    @Override // pf6.a
    public final void s() {
        b r100 = d();
        if (r100 == null) goto L8;
        sk0.a r101 = ((c) r100).f542319b;
        if (r101 == null) goto L9;
        r101.g();
        return;
    L9:
        return;
    }

    @Override // pf6.a
    public final m0 y0() {
        b r100 = d();
        if (r100 == null) goto L7;
        sk0.a r101 = ((c) r100).f542319b;
        if (r101 == null) goto L7;
        return r101.c();
    L7:
        return null;
    }

    public a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        this.f481282a = r100;
    }

    @Override // pf6.a
    public final void B(String r100) {
        b r101 = d();
        if (r101 == null) goto L8;
        AndroidVideoStreamApi r102 = ((c) r101).f542322e;
        if (r102 == null) goto L9;
        r102.c(r100);
        return;
    L9:
        return;
    }

    @Override // pf6.a
    public final void O(boolean r100) {
        b r101 = d();
        if (r101 == null) goto L8;
        sk0.a r102 = ((c) r101).f542319b;
        if (r102 == null) goto L9;
        r102.f(r100);
        return;
    L9:
        return;
    }

    @Override // pf6.a
    public final void t(boolean r100) {
        b r101 = d();
        if (r101 == null) goto L8;
        uk0.a r102 = ((c) r101).f542323f;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    L9:
        return;
    }

    @Override // pf6.a
    public final void c(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        b r102 = d();
        if (r102 == null) goto L8;
        tk0.a r103 = ((c) r102).f542320c;
        if (r103 == null) goto L9;
        r103.d(r100, r101);
        return;
    L9:
        return;
    }
}
