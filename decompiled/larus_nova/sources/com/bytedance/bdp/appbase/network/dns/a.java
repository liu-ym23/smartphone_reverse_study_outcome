package com.bytedance.bdp.appbase.network.dns;

import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Dns;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Dns {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f200880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f200881b = null;

    public a() {
    }

    static {
        f200881b = new a();
        BdpTask.f200457j.produceGroup(1);
        f200880a = new ConcurrentHashMap();
    }

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String r100) {
        if (q94.a.f532096b == false) goto L20;
        g94.b.a("BdpHttpDns", new Object[]{"lookup", r100});
    L20:
        b r101 = f200880a.get(r100);     // Catch: Exception -> L19
        if (r101 != null) goto L15;
        List<InetAddress> r102 = Dns.SYSTEM.lookup(r100);     // Catch: Exception -> L19
        if (r102 == null) goto L17;
        if ((true ^ r102.isEmpty()) == false) goto L17;
        if (r101 != null) goto L13;
        return r102;
    L13:
        r101.getClass();     // Catch: Exception -> L19
        Collection r103 = (Collection) null;     // Catch: Exception -> L19
        throw null;     // Catch: Exception -> L19
    L15:
        r101.getClass();     // Catch: Exception -> L19
        Collection r104 = (Collection) null;     // Catch: Exception -> L19
        throw null;     // Catch: Exception -> L19
    L17:
        int r105 = c.f200882a;
        c.a(null, "https://dig.bdurl.net/q?host=" + r100);
        throw null;
    }
}
