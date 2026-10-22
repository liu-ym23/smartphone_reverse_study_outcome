package n07;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r07.f f516581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f516582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<String> f516583c;

    /* JADX INFO: renamed from: n07.a$a, reason: collision with other inner class name */
    public interface InterfaceC6878a {
    }

    public a(g17.b r100) {
        this.f516581a = new r07.f(r100);
        this.f516582b = new ArrayList();
        this.f516583c = new ArrayList();
    }

    public final void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        ArrayList<String> r101 = this.f516583c;
        monitor-enter(r101);
        this.f516583c.add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void b(String r110) {
        r07.f r100 = this.f516581a;
        r100.getClass();
        if (b.a() != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r110) == true) goto L61;
        String r101 = null;
        if (TextUtils.isEmpty(r110) == false) goto L10;
        String r102 = null;
    L12:
        if (TextUtils.isEmpty(r102) == false) goto L15;
    L19:
        boolean r103 = false;
    L21:
        if (r103 == false) goto L72;
        String r111 = q07.b.b(r110);
        r07.c r104 = new r07.c();
        r104.f535488b = SystemClock.uptimeMillis();
        ((ConcurrentHashMap) r104.f535487a).put("scc_cloudservice_url", r111);
        monitor-enter(r100);
        e r105 = r100.f535497a;     // Catch: Throwable -> L58
        boolean r106 = r105.f516599a;     // Catch: Throwable -> L58
        boolean r107 = r105.f516600b;     // Catch: Throwable -> L58
        String r108 = r105.f516602d;     // Catch: Throwable -> L58
        int r109 = r105.f516601c;     // Catch: Throwable -> L58
        monitor-exit(r100);     // Catch: Throwable -> L58
        if (r106 == true) goto L30;
        r104.f535488b = SystemClock.uptimeMillis();
        ((ConcurrentHashMap) r104.f535487a).put("scc_report_reason", "internal_switch_off");
        r104.d();
        return;
    L30:
        if (TextUtils.isEmpty(r111) == true) goto L33;
        r101 = UriProtector.parse(r111).getHost();
    L33:
        f r112 = r100.a(r101);
        if (r112 == null) goto L40;
        String r113 = r112.f516605a;
        ((ConcurrentHashMap) r104.f535487a).put("scc_report_reason", "scc_cloudservice_local_white_list");
        Map<String, String> r114 = r104.f535487a;
        if (r113 != null) goto L38;
        r113 = "";
    L38:
        ((ConcurrentHashMap) r114).put("scc_cs_local_white_list_matched_rule", r113);
        r104.d();
        return;
    L40:
        if (r07.a.C7413a.f535483a.a(r111) == false) goto L43;
        ((ConcurrentHashMap) r104.f535487a).put("scc_report_reason", "scc_cloudservice");
        ((ConcurrentHashMap) r104.f535487a).put("scc_cloudservice_check_delta", "0");
        ((ConcurrentHashMap) r104.f535487a).put("scc_cloudservice_label", "cache_white");
        r104.d();
        return;
    L43:
        if (r100.b(r111) == null) goto L45;
        ((ConcurrentHashMap) r104.f535487a).put("scc_report_reason", "user_skip");
        r104.d();
        return;
    L45:
        monitor-enter(r100);
    L55:
        th = move-exception;
        throw th;
    L47:
        if (r100.f535499c.containsKey(r111) == false) goto L50;
        monitor-exit(r100);     // Catch: Throwable -> L55
        return;
    L50:
        r104.b();     // Catch: Throwable -> L55
        r100.f535502f.put(r111, r104);     // Catch: Throwable -> L55
        r100.f535498b.schedule(new r07.e(r100, r111), 5, TimeUnit.SECONDS);     // Catch: Throwable -> L55
        r100.f535499c.putIfAbsent(r111, r100.f535498b.submit(new r07.b(r111, r108, r100)));     // Catch: Throwable -> L55
        if (r107 == false) goto L53;
        r100.f535500d.putIfAbsent(r111, r100.f535498b.submit(new r07.d(r111, r109, r104)));     // Catch: Throwable -> L55
    L53:
        monitor-exit(r100);     // Catch: Throwable -> L55
        return;
    L58:
        th = move-exception;
        throw th;
    L72:
        return;
    L15:
        if ("http".equalsIgnoreCase(r102) == false) goto L17;
    L20:
        r103 = true;
        goto L21
    L17:
        if ("https".equalsIgnoreCase(r102) == false) goto L19;
    L10:
        r102 = UriProtector.parse(r110).getScheme();
        goto L12
    }

    public final d c(String r100) {
        r07.f r101 = this.f516581a;
        r101.getClass();
        d r102 = null;
        if (TextUtils.isEmpty(r100) == true) goto L38;
        String r103 = q07.b.b(r100);
        Future<d> r104 = r101.f535499c.remove(r103);
        if (r104 == null) goto L38;
        r07.c r105 = r101.f535502f.get(r103);
        if (r105 == null) goto L12;
        r105.f535490d = SystemClock.uptimeMillis();
    L12:
        monitor-enter(r101);
        int r106 = r101.f535497a.f516601c;     // Catch: Throwable -> L39
        monitor-exit(r101);     // Catch: Throwable -> L39
        d r107 = r104.get(r106, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L28 InterruptedException -> L30 ExecutionException -> L32
        if (r105 != null) goto L46;
    L27:
        r102 = r107;
        r101.f535502f.remove(r103);
        Objects.toString(r102);
        goto L38
    L46:
        r105.c(true, null);     // Catch: TimeoutException -> L21 InterruptedException -> L23 ExecutionException -> L25
    L23:
        Exception e100 = e;
    L34:
        Log.getStackTraceString(e100);
        if (r105 == null) goto L27;
        r105.c(false, e100.toString());
    L25:
        e100 = e;
    L21:
        e100 = e;
    L28:
        e = move-exception;
        e100 = e;
        r107 = null;
    L39:
        th = move-exception;
        throw th;
    L38:
        return r102;
    }

    public final boolean d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        ArrayList<String> r101 = this.f516583c;
        monitor-enter(r101);
        boolean r102 = this.f516583c.remove(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e(String r100) {
        r07.f r101 = this.f516581a;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L15;
        String r102 = q07.b.b(r100);
        monitor-enter(r101);
        ((ArrayList) r101.f535501e).add(r102);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void f(JsonObject r100) {
        r07.f r101 = this.f516581a;
        monitor-enter(r101);
        e.a(r100, r101.f535497a);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final WebResourceResponse g(String r100) {
        r07.f r101 = this.f516581a;
        r101.getClass();
        String r102 = q07.b.b(r100);
        Future<o07.d> r103 = r101.f535500d.get(r102);
        if (r103 == null) goto L18;
    L9:
        e = move-exception;
        e.toString();
        return null;
    L11:
        e = move-exception;
        e.toString();
        return null;
    L6:
        if (r103.isDone() == false) goto L16;
    L19:
        return q07.b.c(r103.get());
    L16:
        return null;
    L18:
        return null;
    }
}
