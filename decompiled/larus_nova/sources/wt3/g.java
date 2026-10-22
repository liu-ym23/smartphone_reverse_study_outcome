package wt3;

import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f561206e;

    @Override // wt3.a
    public final long f() {
        if (this.f561193d == false) goto L5;
        return 300000;
    L5:
        return 5000;
    }

    @Override // vt3.f
    public final StateType b() {
        return StateType.PROCESS_DOUBLE_DETECT;
    }

    public g(vt3.d r100) {
        super(r100);
        this.f561206e = 0;
    }

    @Override // wt3.a, vt3.a, vt3.f
    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        this.f561206e = 0;
    L4:
        super.a(r100);
    }

    @Override // wt3.a
    public final boolean g(boolean r100) {
        if (r100 == false) goto L15;
        this.f561206e++;
        e("over time: " + this.f561206e + " max over time: 2");
        if (this.f561206e < 2) goto L14;
        this.f561206e = 0;
        vt3.d r101 = this.f557196a;
        monitor-enter(r101);
        r101.a(r101.f557210j);     // Catch: Throwable -> L11
        monitor-exit(r101);
        return true;
    L11:
        th = move-exception;
        throw th;
    L14:
        return false;
    L15:
        this.f561206e = 0;
        this.f557196a.b();
        return true;
    }
}
