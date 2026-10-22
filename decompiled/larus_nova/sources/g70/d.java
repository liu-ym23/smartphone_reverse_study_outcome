package g70;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import j70.k;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e70.f f480207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f480208b;

    @Override // j70.k
    public final Tetris<? extends h70.b> b() {
        return ((e70.g) this.f480207a).b();
    }

    @Override // j70.k
    public final boolean k() {
        return ((e70.g) this.f480207a).k();
    }

    @Override // j70.k
    public final boolean v() {
        return this.f480208b;
    }

    public d(e70.f r100, boolean r101) {
        this.f480207a = r100;
        this.f480208b = r101;
    }
}
