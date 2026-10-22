package okhttp3;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class Route {
    final a address;
    final String dnsInfoJson;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;

    public int hashCode() {
        return ((((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode();
    }

    public boolean requiresTunnel() {
        if (this.address.f523809i != null) goto L5;
    L7:
        return false;
    L5:
        if (this.proxy.type() != Proxy.Type.HTTP) goto L7;
        return true;
    }

    public String toString() {
        return "Route{" + this.inetSocketAddress + com.alipay.sdk.m.u.i.f25855d;
    }

    public a address() {
        return this.address;
    }

    public String dnsInfoJson() {
        return this.dnsInfoJson;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }

    public boolean equals(@Nullable Object r100) {
        if ((r100 instanceof Route) == false) goto L11;
        Route r101 = (Route) r100;
        if (r101.address.equals(this.address) == false) goto L11;
        if (r101.proxy.equals(this.proxy) == false) goto L11;
        if (r101.inetSocketAddress.equals(this.inetSocketAddress) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public Route(a r100, Proxy r101, InetSocketAddress r102) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L11;
        if (r102 == null) goto L9;
        this.address = r100;
        this.proxy = r101;
        this.inetSocketAddress = r102;
        this.dnsInfoJson = null;
        return;
    L9:
        throw new NullPointerException("inetSocketAddress == null");
    L11:
        throw new NullPointerException("proxy == null");
    L13:
        throw new NullPointerException("address == null");
    }

    public Route(a r100, Proxy r101, InetSocketAddress r102, String r103) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L11;
        if (r102 == null) goto L9;
        this.address = r100;
        this.proxy = r101;
        this.inetSocketAddress = r102;
        this.dnsInfoJson = r103;
        return;
    L9:
        throw new NullPointerException("inetSocketAddress == null");
    L11:
        throw new NullPointerException("proxy == null");
    L13:
        throw new NullPointerException("address == null");
    }
}
