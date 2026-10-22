package com.ttnet.org.chromium.net;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace("net::android")
public class DnsStatus {
    private final List<InetAddress> mDnsServers;
    private final boolean mPrivateDnsActive;
    private final String mPrivateDnsServerName;
    private final String mSearchDomains;

    public byte[][] getDnsServers() {
        byte[][] r100 = new byte[this.mDnsServers.size()][];
        int r101 = 0;
    L4:
        if (r101 >= this.mDnsServers.size()) goto L6;
        r100[r101] = ((InetAddress) ListProtector.get(this.mDnsServers, r101)).getAddress();
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public boolean getPrivateDnsActive() {
        return this.mPrivateDnsActive;
    }

    public String getPrivateDnsServerName() {
        return this.mPrivateDnsServerName;
    }

    public String getSearchDomains() {
        return this.mSearchDomains;
    }

    public DnsStatus(List<InetAddress> r100, boolean r101, String r102, String r103) {
        this.mDnsServers = r100;
        this.mPrivateDnsActive = r101;
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        this.mPrivateDnsServerName = r102;
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        this.mSearchDomains = r103;
    }
}
