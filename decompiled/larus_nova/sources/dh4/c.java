package dh4;

import com.bytedance.crash.jni.NativeBridge;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends a {
    @Override // dh4.a
    public final void f() {
        this.f468592a.release();
    }

    public c(String r100) {
        long r101 = NativeBridge.b0(r100, 0);
        if (r101 == 0) goto L5;
        d r102 = new g(r101);
    L6:
        if (r102 != null) goto L9;
        r102 = new e(r100);
    L9:
        this.f468592a = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // dh4.a
    public final void a(char r100) {
        this.f468592a.a(String.valueOf(r100));
    }

    @Override // dh4.a
    public final void b(int r100) {
        this.f468592a.b(r100);
    }

    @Override // dh4.a
    public final void c(long r100) {
        this.f468592a.c(r100);
    }

    @Override // dh4.a
    public final void d(String r100) {
        this.f468592a.a(r100);
    }

    @Override // dh4.a
    public final void e(char[] r100) {
        this.f468592a.d(r100, r100.length);
    }
}
