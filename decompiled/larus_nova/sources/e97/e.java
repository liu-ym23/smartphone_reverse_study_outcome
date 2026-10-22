package e97;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f471517b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f471518a;

    public static e a() {
        if (f471517b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f471517b != null) goto L9;
        f471517b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f471517b;
    }

    public e() {
        OkHttpClient.Builder r100 = new OkHttpClient.Builder();
        TimeUnit r101 = TimeUnit.SECONDS;
        this.f471518a = r100.connectTimeout(2, r101).readTimeout(2, r101).writeTimeout(2, r101).build();
    }
}
