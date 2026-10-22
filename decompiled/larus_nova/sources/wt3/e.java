package wt3;

import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends vt3.a {
    @Override // vt3.f
    public final StateType b() {
        return StateType.IDLE;
    }

    @Override // vt3.a, vt3.f
    public final void c() {
        super.c();
    }

    public e(vt3.d r100) {
        super(r100);
    }

    @Override // vt3.a, vt3.f
    public final void a(boolean r100) {
        super.a(r100);
        e("life cycle change when state is idle, lifecycle change to back?: " + r100);
        this.f557196a.b();
    }

    @Override // vt3.a, vt3.f
    public final void d(ut3.c r100, boolean r101) {
        super.d(r100, r101);
        this.f557196a.b();
    }
}
