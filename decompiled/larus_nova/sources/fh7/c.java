package fh7;

import com.bytedance.ruler.utils.g;
import com.bytedance.timonbase.TMEnv;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements g {
    public c() {
    }

    @Override // com.bytedance.ruler.utils.g
    public final synchronized d b(String r100) {
        monitor-enter(this);
        d r101 = new d(vg7.a.b().a(TMEnv.f270769c, r100, 1));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }
}
