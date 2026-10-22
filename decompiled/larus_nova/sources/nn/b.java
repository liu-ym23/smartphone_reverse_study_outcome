package nn;

import android.graphics.Rect;
import com.bytedance.android.shopping.extensions.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ln.c f519621a;

    @Override // ln.c
    public final void B() {
        ln.c r100 = this.f519621a;
        if (r100 == null) goto L6;
        r100.stopPlay();
        return;
    }

    @Override // ln.c
    public final void R() {
        ln.c r100 = this.f519621a;
        if (r100 == null) goto L6;
        r100.startPlay();
        return;
    }

    @Override // ln.c
    public final boolean isPlaying() {
        ln.c r100 = this.f519621a;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isPlaying());
    L7:
        return k.i(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // ln.c
    public final ln.b m() {
        ln.c r100 = this.f519621a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.m();
    }

    @Override // ln.c
    public final void v() {
        ln.c r100 = this.f519621a;
        if (r100 == null) goto L6;
        r100.pausePlay();
        return;
    }

    public b() {
        this.f519621a = null;
    }

    @Override // ln.c
    public final List<ln.c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        ArrayList r101 = new ArrayList();
        int r102 = c.f519622a;
        c.a(r100, this.f519621a, r101);
        return r101;
    }

    @Override // ln.c
    public final void k1(e.a r100) {
        ln.c r101 = this.f519621a;
        if (r101 == null) goto L6;
        r101.k1(r100);
        return;
    }
}
