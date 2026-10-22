package iv8;

import android.os.SystemClock;
import com.larus.browsertakeover.cdp.BrowserCdpClient;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient f496087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f496088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f496089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f496090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BrowserCdpClient.k f496091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f496092f;

    public /* synthetic */ s(BrowserCdpClient r100, int r101, int r102, int r103, BrowserCdpClient.k r104, long r105) {
        this.f496087a = r100;
        this.f496088b = r101;
        this.f496089c = r102;
        this.f496090d = r103;
        this.f496091e = r104;
        this.f496092f = r105;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BrowserCdpClient r100 = this.f496087a;
        int r101 = this.f496088b;
        int r102 = this.f496089c;
        int r103 = this.f496090d;
        BrowserCdpClient.k r104 = this.f496091e;
        long r105 = this.f496092f;
        Object r106 = r100.f319393m;
        monitor-enter(r106);
        String r107 = r104.f319439b;     // Catch: Throwable -> L29
        if (r107 != null) goto L9;
        monitor-exit(r106);
        return;
    L9:
        if (r100.f319392l.get(Integer.valueOf(r102)) == r104) goto L11;
    L27:
        monitor-exit(r106);
        return;
    L11:
        if (r104.f319440c != r100.f319388h.get()) goto L27;
        if (r100.w(r107, r101) == false) goto L27;
        if (SystemClock.elapsedRealtime() >= r105) goto L27;
        int r108 = r100.f319386f.getAndIncrement();     // Catch: Throwable -> L29
        Set<Integer> r109 = r104.f319443f;     // Catch: Throwable -> L29
        if (r109 == null) goto L20;
        r109.add(Integer.valueOf(r108));     // Catch: Throwable -> L29
    L20:
        r100.f319392l.put(Integer.valueOf(r108), r104);     // Catch: Throwable -> L29
        monitor-exit(r106);
        FLogger.f375446a.i("BrowserCdpClient", "client=" + r100.f319395o + " generation=" + r101 + " event=page_enable_retry originalId=" + r102 + " id=" + r108 + " attempt=" + r103);
        JSONObject r110 = new JSONObject().put("id", r108).put(com.alipay.sdk.m.p.e.f25671s, "Page.enable").put("params", new JSONObject());
        Intrinsics.checkNotNull(r110);
        if (r100.d0(r108, "Page.enable", r110, r104) == true) goto L25;
        return;
    L25:
        if (r103 >= 4) goto L35;
        r100.f319384d.postDelayed(new s(r100, r101, r102, r103 + 1, r104, r105), 1000);
        return;
    L35:
        return;
    L29:
        th = move-exception;
        throw th;
    }
}
