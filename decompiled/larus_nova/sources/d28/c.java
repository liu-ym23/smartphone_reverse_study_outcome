package d28;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.g;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements ClearableCookieJar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f466548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f466549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CookieCache f466550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CookiePersistor f466551e;

    public final void c() {
        if (this.f466548b == false) goto L5;
        return;
    L5:
        List<g> r100 = this.f466551e.a();
        if (r100 != null) goto L8;
    L12:
        Log.i("PersistentCookieJar", "ensureLoaded failed");
        return;
    L8:
        if (r100.size() <= 0) goto L12;
        this.f466548b = true;
        this.f466550d.addAll(r100);
        Log.i("PersistentCookieJar ensureLoaded process:" + z.b(this.f466549c));
    }

    @Override // okhttp3.h
    public final synchronized List<g> a(HttpUrl r110) {
        monitor-enter(this);
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L46
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L46
        c();     // Catch: Throwable -> L46
        Iterator<g> r102 = this.f466550d.iterator();     // Catch: Throwable -> L46
    L5:
        if (r102.hasNext() == false) goto L43;
        g r103 = r102.next();     // Catch: Throwable -> L46
        boolean r104 = true;
        if (r103.f523857c >= System.currentTimeMillis()) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L11;
        if (r103.f523863i == false) goto L19;
        boolean r106 = r110.host().equals(r103.f523858d);     // Catch: Throwable -> L46
    L20:
        if (r106 == true) goto L22;
    L21:
        r104 = false;
    L41:
        if (r104 == false) goto L5;
        r101.add(r103);     // Catch: Throwable -> L46
        goto L5
    L22:
        String r107 = r103.f523859e;     // Catch: Throwable -> L46
        String r108 = r110.encodedPath();     // Catch: Throwable -> L46
        if (r108.equals(r107) == false) goto L26;
    L32:
        boolean r109 = true;
    L34:
        if (r109 == false) goto L21;
        if (r103.f523860f == false) goto L41;
        if (r110.isHttps() == true) goto L41;
    L26:
        if (r108.startsWith(r107) == true) goto L28;
    L33:
        r109 = false;
        goto L34
    L28:
        if (r107.endsWith(HTTP.URL_DEFAULT) == true) goto L32;
        if (r108.charAt(r107.length()) != '/') goto L33;
    L19:
        r106 = g.b(r110.host(), r103.f523858d);     // Catch: Throwable -> L46
        goto L20
    L11:
        r100.add(r103);     // Catch: Throwable -> L46
        r102.remove();     // Catch: Throwable -> L46
        Log.i("PersistentCookieJar expiredcookie loadForRequest", r110.toString());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Log.e("logCookie", th);     // Catch: Throwable -> L46
        goto L5
    L9:
        r105 = false;
        goto L10
    L43:
        this.f466551e.removeAll(r100);     // Catch: Throwable -> L46
        r110.host();     // Catch: Throwable -> L46
        monitor-exit(this);
        return r101;
    L46:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.h
    public final synchronized void b(HttpUrl r100, List<g> r101) {
        monitor-enter(this);
        this.f466550d.addAll(r101);     // Catch: Throwable -> L12
        CookiePersistor r102 = this.f466551e;     // Catch: Throwable -> L12
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L12
        Iterator<g> r104 = r101.iterator();     // Catch: Throwable -> L12
    L5:
        if (r104.hasNext() == false) goto L9;
        g r105 = r104.next();     // Catch: Throwable -> L12
        if (r105.f523862h == false) goto L5;
        r103.add(r105);     // Catch: Throwable -> L12
        goto L5
    L9:
        r102.b(r103);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public c(Context r100, SetCookieCache r101, d r102) {
        this.f466548b = false;
        this.f466549c = r100;
        this.f466550d = r101;
        this.f466551e = r102;
    }
}
