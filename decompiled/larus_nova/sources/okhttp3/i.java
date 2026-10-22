package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i {
    public static final i NONE = null;

    public static class a extends i {
        public a() {
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f523874a;

        public b(i r100) {
            this.f523874a = r100;
        }

        @Override // okhttp3.i.c
        public final i create(Call r100) {
            return this.f523874a;
        }
    }

    public interface c {
        i create(Call r100);
    }

    public i() {
    }

    public void callEnd(Call r100) {
    }

    public void callFailed(Call r100, IOException r101) {
    }

    public void callInSecureRedirect(Call r100, JSONObject r101) {
    }

    public void callStart(Call r100) {
    }

    public void connectEnd(Call r100, InetSocketAddress r101, Proxy r102, @Nullable Protocol r103) {
    }

    public void connectFailed(Call r100, InetSocketAddress r101, Proxy r102, @Nullable Protocol r103, IOException r104) {
    }

    public void connectFailed(Call r100, InetSocketAddress r101, Proxy r102, @Nullable Protocol r103, IOException r104, String r105) {
    }

    public void connectStart(Call r100, InetSocketAddress r101, Proxy r102) {
    }

    public void connectionAcquired(Call r100, Connection r101) {
    }

    public void connectionReleased(Call r100, Connection r101) {
    }

    public void dnsEnd(Call r100, String r101, List<InetAddress> r102) {
    }

    public void dnsEnd(Call r100, String r101, List<InetAddress> r102, String r103) {
    }

    public void dnsStart(Call r100, String r101) {
    }

    public void requestBodyEnd(Call r100, long r101) {
    }

    public void requestBodyStart(Call r100) {
    }

    public void requestHeadersEnd(Call r100, Request r101) {
    }

    public void requestHeadersStart(Call r100) {
    }

    public void responseBodyEnd(Call r100, long r101) {
    }

    public void responseBodyStart(Call r100) {
    }

    public void responseHeadersEnd(Call r100, Response r101) {
    }

    public void responseHeadersStart(Call r100) {
    }

    public void secureConnectEnd(Call r100, @Nullable j r101) {
    }

    public void secureConnectStart(Call r100) {
    }

    static {
        NONE = new a();
    }

    public static c factory(i r100) {
        return new b(r100);
    }
}
