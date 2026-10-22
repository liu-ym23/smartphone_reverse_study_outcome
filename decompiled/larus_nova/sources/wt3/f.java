package wt3;

import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a {
    @Override // wt3.a
    public final long f() {
        ut3.c r100 = this.f561191b;
        if (r100 != null) goto L10;
        if (this.f561193d == true) goto L14;
        return 30000;
    L14:
        return 600000;
    L10:
        if (this.f561193d == false) goto L13;
        return 600000;
    L13:
        return ((long) r100.f551646k) * 1000;
    }

    @Override // vt3.f
    public final StateType b() {
        return StateType.PROCESS_DETECT;
    }

    public f(vt3.d r100) {
        super(r100);
    }

    @Override // wt3.a
    public final boolean g(boolean r100) {
        if (r100 == false) goto L11;
        vt3.c.a.f557200a.getClass();
        vt3.d r101 = this.f557196a;
        monitor-enter(r101);
        r101.a(r101.f557209i);     // Catch: Throwable -> L8
        monitor-exit(r101);
    L8:
        th = move-exception;
        throw th;
    L11:
        return r100;
    }
}
