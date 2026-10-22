package vp;

import android.graphics.Rect;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;

/* JADX INFO: loaded from: classes44.dex */
public abstract class e implements tp.c {
    public e() {
    }

    @Override // tp.c
    public final Rect r() {
        return null;
    }

    @Override // tp.c
    public final void pausePlay() {
        v();
        M();
    }

    @Override // tp.c
    public final boolean resumePlay() {
        boolean r100 = g0();
        U0();
        return r100;
    }

    @Override // tp.c
    public final void startPlay() {
        R();
        x();
    }

    @Override // tp.c
    public final void stopPlay() {
        B();
        z();
    }

    @Override // tp.c
    public final void M() {
        tp.c.a.a(this);
    }

    @Override // tp.c
    public final WindowPlayAbleType P() {
        return WindowPlayAbleType.OTHER;
    }

    @Override // tp.c
    public final void U0() {
        tp.c.a.b(this);
    }

    @Override // tp.c
    public final void x() {
        tp.c.a.c(this);
    }

    @Override // tp.c
    public final void z() {
        tp.c.a.d(this);
    }
}
