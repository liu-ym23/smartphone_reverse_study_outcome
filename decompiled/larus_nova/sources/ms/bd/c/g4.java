package ms.bd.c;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;

/* JADX INFO: loaded from: classes5.dex */
public final class g4 extends f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f515153a;

    public final void finalize() {
        p2.a(50331650, 0, this.f515153a, null, null);
        p2.a(100663298, 0, this.f515153a, null, null);
        this.f515153a = -1;
        super.finalize();
    }

    public g4() {
    }

    @Override // ms.bd.c.f2
    public final void a(long r100) {
        this.f515153a = r100;
        f4 r101 = new f4(this);
        monitor-enter(this);
        NetworkParams.setAddSecurityFactorProcessCallback(r101);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
