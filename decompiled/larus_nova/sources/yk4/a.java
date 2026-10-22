package yk4;

import android.net.Network;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;
import pk4.j;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Dns {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Network f568125a;

    public a(Network r100) {
        this.f568125a = r100;
    }

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String r100) throws UnknownHostException {
        return Arrays.asList(this.f568125a.getAllByName(r100));
    L4:
        e = move-exception;
        j.f("DoraLanRequest", "lookup: " + e.getMessage());
        return Dns.SYSTEM.lookup(r100);
    }
}
