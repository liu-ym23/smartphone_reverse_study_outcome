package ml4;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements ml4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f514360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f514361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f514362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f514363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDateFormat f514364f;

    public static final class a {
    }

    static {
    }

    @Override // ml4.a
    public final long getNtpTime() {
        return System.currentTimeMillis() + this.f514361c;
    }

    public c(String r100) {
        ExecutorService r101 = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("UrlNTPTimeProvider"));
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "executor");
        this.f514359a = r100;
        this.f514360b = r101;
        AtomicBoolean r102 = new AtomicBoolean(false);
        this.f514363e = r102;
        SimpleDateFormat r103 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        r103.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.f514364f = r103;
        if ((System.currentTimeMillis() - this.f514362d) > 3600000) goto L5;
        return;
    L5:
        if (r102.compareAndSet(false, true) == false) goto L10;
        final Function2 r104 = null;
        r101.execute(new b(this, r104));
        return;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }
}
