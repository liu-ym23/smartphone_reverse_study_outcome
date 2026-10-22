package com.ttnet.org.chromium.net;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.InetAddress;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@JNINamespace("net::android")
public class DnsStatus {
    private final List<InetAddress> mDnsServers;
    private final boolean mPrivateDnsActive;
    private final String mPrivateDnsServerName;
    private final String mSearchDomains;

    public byte[][] getDnsServers() {
        byte[][] r0 = new byte[this.mDnsServers.size()][];
        int r1 = 0;
    L4:
        if (r1 >= this.mDnsServers.size()) goto L6;
        r0[r1] = ((InetAddress) ListProtector.get(this.mDnsServers, r1)).getAddress();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
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

    public DnsStatus(List<InetAddress> r1, boolean r2, String r3, String r4) {
        this.mDnsServers = r1;
        this.mPrivateDnsActive = r2;
        if (r3 != null) goto L6;
        r3 = XmlPullParser.NO_NAMESPACE;
    L6:
        this.mPrivateDnsServerName = r3;
        if (r4 != null) goto L10;
        r4 = XmlPullParser.NO_NAMESPACE;
    L10:
        this.mSearchDomains = r4;
    }
}
