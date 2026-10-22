package com.bytedance.caijing.sdk.infra.base.api.sec;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum EncryptVendor extends Enum<EncryptVendor> {
    public static final EncryptVendor CCIT = null;
    public static final EncryptVendor ISEC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EncryptVendor[] f202246a = null;

    static {
        EncryptVendor r100 = new EncryptVendor("ISEC", 0);
        ISEC = r100;
        EncryptVendor r101 = new EncryptVendor("CCIT", 1);
        CCIT = r101;
        f202246a = new EncryptVendor[]{r100, r101};
    }

    public static EncryptVendor[] values() {
        return (EncryptVendor[]) f202246a.clone();
    }

    public static EncryptVendor valueOf(String r100) {
        return (EncryptVendor) a.a(EncryptVendor.class, r100);
    }

    public EncryptVendor(String r100, int r101) {
        super(r100, r101);
    }
}
