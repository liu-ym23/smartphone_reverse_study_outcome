package fqc;

import com.volcengine.zeus.log.ZeusLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;

    public final void a(String r10) {
        long r0 = System.currentTimeMillis() - this.e;
        long r2 = System.currentTimeMillis() - this.d;
        ZeusLogger.i(this.a, this.b + String.format(" watcher[%s]-%s cost=%s, total=%s", new Object[]{this.c, r10, Long.valueOf(r0), Long.valueOf(r2)}));
    }

    public a(String r3, String r4, String r5) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        long r0 = System.currentTimeMillis();
        this.e = r0;
        this.d = r0;
        ZeusLogger.i(r3, r4 + String.format(" watcher[%s]-start", new Object[]{r5}));
    }
}
