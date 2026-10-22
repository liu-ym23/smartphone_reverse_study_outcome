package v0c;

import android.os.Bundle;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f552361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f552362b;

    @Override // v0c.p.a
    public final void a(o r100) {
        if ((r100 instanceof com.ss.android.lark.player.player.o) == false) goto L7;
        Bundle r101 = this.f552361a;
        if (r101 == null) goto L7;
        ((com.ss.android.lark.player.player.o) r100).e(r101.getInt("int_arg1"), this.f552361a.getInt("int_arg2"), this.f552361a.getInt("int_arg3"));
    L7:
        r100.a(this.f552362b, this.f552361a);
    }

    public h(Bundle r100, int r101) {
        this.f552361a = r100;
        this.f552362b = r101;
    }
}
