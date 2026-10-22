package fqc;

import com.volcengine.zeus.log.ZeusLogger;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f478478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f478479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f478480e;

    public final void a(String r110) {
        long r100 = System.currentTimeMillis() - this.f478480e;
        long r101 = System.currentTimeMillis() - this.f478479d;
        ZeusLogger.i(this.f478476a, this.f478477b + String.format(" watcher[%s]-%s cost=%s, total=%s", new Object[]{this.f478478c, r110, Long.valueOf(r100), Long.valueOf(r101)}));
    }

    public a(String r100, String r101, String r102) {
        this.f478476a = r100;
        this.f478477b = r101;
        this.f478478c = r102;
        long r103 = System.currentTimeMillis();
        this.f478480e = r103;
        this.f478479d = r103;
        ZeusLogger.i(r100, r101 + String.format(" watcher[%s]-start", new Object[]{r102}));
    }
}
