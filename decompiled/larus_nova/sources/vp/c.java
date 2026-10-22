package vp;

import android.graphics.Rect;
import com.bytedance.android.shopping.extensions.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tp.c f556543a;

    @Override // tp.c
    public final void B() {
        tp.c r100 = this.f556543a;
        if (r100 == null) goto L6;
        r100.stopPlay();
        return;
    }

    @Override // tp.c
    public final boolean D3() {
        tp.c r100 = this.f556543a;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.D3());
    L7:
        return k.i(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // tp.c
    public final void R() {
        tp.c r100 = this.f556543a;
        if (r100 == null) goto L6;
        r100.startPlay();
        return;
    }

    @Override // tp.c
    public final boolean g0() {
        tp.c r100 = this.f556543a;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.resumePlay());
    L7:
        return k.i(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // tp.c
    public final boolean isPlaying() {
        tp.c r100 = this.f556543a;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isPlaying());
    L7:
        return k.i(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // tp.c
    public final tp.b m() {
        tp.c r100 = this.f556543a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.m();
    }

    @Override // tp.c
    public final void v() {
        tp.c r100 = this.f556543a;
        if (r100 == null) goto L6;
        r100.pausePlay();
        return;
    }

    public c() {
        this.f556543a = null;
    }

    @Override // tp.c
    public final List<tp.c> L(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        ArrayList r101 = new ArrayList();
        int r102 = d.f556544a;
        d.a(r100, this.f556543a, r101);
        return r101;
    }

    @Override // tp.c
    public final void o2(tp.b r100) {
        tp.c r101 = this.f556543a;
        if (r101 == null) goto L6;
        r101.o2(r100);
        return;
    }
}
