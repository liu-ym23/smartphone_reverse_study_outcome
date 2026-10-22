package com.bytedance.bdp.appbase.network.dns;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L22;
        r101.getClass();
        if (0 != 0) goto L23;
        r101.getClass();
        if (0 != 0) goto L24;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L25;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L26;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L28;
        return false;
    L28:
        return true;
    L26:
        return false;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((0 * 31) + ((int) (0 ^ (0 >>> 32)))) * 31) + ((int) (0 ^ (0 >>> 32)))) * 31) + 0) * 31) + 0) * 31) + 0;
    }

    public final String toString() {
        return "HttpDnsRecord(host=null, ttl=0, fetchTime=0, ips=null, addrList=null, cip=null)";
    }
}
