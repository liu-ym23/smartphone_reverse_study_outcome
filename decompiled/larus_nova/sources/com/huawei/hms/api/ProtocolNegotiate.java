package com.huawei.hms.api;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class ProtocolNegotiate {
    private static final int MAX_VERSION = 2;
    private static ProtocolNegotiate instance;
    private int version;

    static {
        instance = new ProtocolNegotiate();
    }

    public ProtocolNegotiate() {
        this.version = 1;
    }

    public static ProtocolNegotiate getInstance() {
        return instance;
    }

    public int getVersion() {
        return this.version;
    }

    public int negotiate(List<Integer> r100) {
        if (r100 != null) goto L5;
    L13:
        this.version = 1;
        return 1;
    L5:
        if (r100.isEmpty() == true) goto L13;
        if (r100.contains(2) == true) goto L10;
        this.version = ((Integer) ListProtector.get(r100, r100.size() - 1)).intValue();
    L12:
        return this.version;
    L10:
        this.version = 2;
        goto L12
    }
}
