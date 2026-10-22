package l17;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.lynx.webview.internal.AppInfo;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.c0;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {
    public a() {
    }

    public static void a() {
        if (n.d(TTWebContext.h().getContext()) == false) goto L38;
        c0 r100 = TTWebContext.h().p();
    L33:
        e = move-exception;
        e.toString();
        return;
    L6:
        if (b.f506992b == true) goto L39;
        int r101 = 1;
        b.f506992b = true;     // Catch: Exception -> L33
        int r102 = r100.f265273b.getInt(ILoadStallMonitor.START_TIME, 0);     // Catch: Exception -> L33
        com.bytedance.lynx.webview.internal.a r103 = TTWebContext.e();     // Catch: Exception -> L33
        if (r103 == null) goto L18;
        AppInfo r104 = r103.a();     // Catch: Exception -> L33
        if (r104 == null) goto L18;
        String r105 = r104.getUpdateVersionCode();     // Catch: Exception -> L33
        if (r105.isEmpty() == true) goto L18;
        if (r100.a(r105) == false) goto L18;
        b.f506993c = true;     // Catch: Exception -> L33
    L18:
        if (b.f506993c == false) goto L20;
    L26:
        r100.f265273b.edit().putInt("start_time_by_version", 1).apply();     // Catch: Exception -> L33
    L27:
        int r106 = r102 + 1;     // Catch: Exception -> L33
        if (r106 == 100000) goto L31;
        r101 = r106;
    L31:
        r100.f265273b.edit().putInt(ILoadStallMonitor.START_TIME, r101).apply();     // Catch: Exception -> L33
        return;
    L20:
        if (r100.f265273b.getInt("start_time_by_version", 0) == 0) goto L26;
        int r107 = r100.f265273b.getInt("start_time_by_version", 0) + 1;     // Catch: Exception -> L33
        if (r107 != 100000) goto L25;
        r107 = 1;
    L25:
        r100.f265273b.edit().putInt("start_time_by_version", r107).apply();     // Catch: Exception -> L33
        goto L27
    L39:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
