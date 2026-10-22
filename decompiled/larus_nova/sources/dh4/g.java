package dh4;

import com.bytedance.crash.jni.NativeBridge;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f468601a;

    @Override // dh4.d
    public final void flush() {
        NativeBridge.e0(this.f468601a);
    }

    @Override // dh4.d
    public final void release() {
        NativeBridge.f0(this.f468601a);
    }

    public g(long r100) {
        this.f468601a = r100;
    }

    @Override // dh4.d
    public final void a(String r100) {
        NativeBridge.d0(this.f468601a, r100, r100.length());
    }

    @Override // dh4.d
    public final void b(int r100) {
        a(Integer.toString(r100));
    }

    @Override // dh4.d
    public final void c(long r100) {
        a(Long.toString(r100));
    }

    @Override // dh4.d
    public final void d(char[] r100, int r101) {
        NativeBridge.c0(this.f468601a, r100, r101);
    }
}
