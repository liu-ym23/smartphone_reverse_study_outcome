package com.larus.dora.impl.nl;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Type f336275e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile List<com.larus.dora.impl.network.s> f336276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f336277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Keva f336278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Gson f336279d;

    public class a extends TypeToken<List<com.larus.dora.impl.network.s>> {
        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f336280a = null;

        static {
            f336280a = new k();
        }
    }

    static {
        f336275e = new a().getType();
    }

    public final Keva a() {
        if (this.f336278c != null) goto L22;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (this.f336278c == null) goto L27;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        goto L22
    L27:
        this.f336278c = Keva.getRepo("_nl_apps");     // Catch: Throwable -> L14
        String r100 = this.f336278c.getString("_nl_apps_list", null);     // Catch: Throwable -> L14
        if (r100 == null) goto L16;
        this.f336276a = new CopyOnWriteArrayList((List) this.f336279d.fromJson(r100, f336275e));     // Catch: Throwable -> L11
        b();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        g49.d.c("NLApps", "getAppList", th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        g49.d.c("NLApps", "getKeva", th);     // Catch: Throwable -> L18
    L22:
        return this.f336278c;
    }

    public final void b() {
        if (this.f336276a != null) goto L5;
        return;
    L5:
        if (this.f336276a.isEmpty() == true) goto L27;
        Iterator<com.larus.dora.impl.network.s> r100 = this.f336276a.iterator();
    L8:
        if (r100.hasNext() == false) goto L28;
        com.larus.dora.impl.network.s r101 = r100.next();
        if (r101.e() != 2) goto L15;
        if (this.f336277b.contains(r101.d()) == true) goto L15;
        this.f336277b.add(r101.d());
    L15:
        if (r101.e() != 1) goto L8;
        this.f336277b.remove(r101.d());
        goto L8
    L28:
        return;
    }

    public k() {
        this.f336276a = null;
        this.f336277b = new CopyOnWriteArrayList(Collections.singletonList(pk4.n.f529659c.getPackageName()));
        this.f336278c = null;
        this.f336279d = new Gson();
        a();
    }

    public final void c(List<com.larus.dora.impl.network.s> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f336276a = new CopyOnWriteArrayList(r100);
        String r101 = this.f336279d.toJson(r100, f336275e);     // Catch: Throwable -> L7
        a().storeString("_nl_apps_list", r101);     // Catch: Throwable -> L7
    L9:
        b();
        return;
    L7:
        th = move-exception;
        g49.d.c("NLApps", "storeAppList error", th);
        goto L9
    }
}
