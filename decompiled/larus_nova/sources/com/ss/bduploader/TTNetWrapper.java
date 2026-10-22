package com.ss.bduploader;

import com.bytedance.ttnet.TTNetInit;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class TTNetWrapper {
    public TTNetWrapper() {
    }

    public static List<InetAddress> dnsLookup(String r100) {
        return TTNetInit.dnsLookup(r100);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
