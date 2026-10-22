package xk7;

import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends jl7.a<String> {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(String r100) {
        RandomAccess r101 = this.f499531b;
        monitor-enter(r101);
        this.f499530a = r100;     // Catch: Throwable -> L14
        int r102 = 0;
    L6:
        if (r102 >= this.f499531b.size()) goto L11;
        jl7.b r103 = (jl7.b) this.f499531b.get(r102);     // Catch: Throwable -> L14
        if (r103 == null) goto L10;
        r103.a(this.f499530a);     // Catch: Throwable -> L14
    L10:
        r102 = r102 + 1;     // Catch: Throwable -> L14
        goto L6
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L14
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ITrigger", "trigger request from ".concat(r100));
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
