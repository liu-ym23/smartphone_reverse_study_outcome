package nn;

import android.graphics.Rect;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;

/* JADX INFO: loaded from: classes44.dex */
public abstract class d implements ln.c {
    public d() {
    }

    @Override // ln.c
    public final Rect r() {
        return null;
    }

    @Override // ln.c
    public final void pausePlay() {
        v();
        M();
    }

    @Override // ln.c
    public final void startPlay() {
        R();
        x();
    }

    @Override // ln.c
    public final void stopPlay() {
        B();
        z();
    }

    @Override // ln.c
    public final void M() {
        ln.c.a.a(this);
    }

    @Override // ln.c
    public final PlayAbleType P() {
        return PlayAbleType.OTHER;
    }

    @Override // ln.c
    public final void x() {
        ln.c.a.b(this);
    }

    @Override // ln.c
    public final void z() {
        ln.c.a.c(this);
    }
}
