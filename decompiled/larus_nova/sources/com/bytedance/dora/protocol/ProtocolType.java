package com.bytedance.dora.protocol;

import com.larus.network.http.ServiceType;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum ProtocolType extends Enum<ProtocolType> {
    public static final ProtocolType DORA = null;
    public static final ProtocolType EXTERNAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProtocolType[] f204661a = null;
    public final int value;

    static {
        ProtocolType r100 = new ProtocolType(ServiceType.DORA, 0, 1);
        DORA = r100;
        ProtocolType r101 = new ProtocolType("EXTERNAL", 1, 2);
        EXTERNAL = r101;
        f204661a = new ProtocolType[]{r100, r101};
    }

    public static ProtocolType[] values() {
        return (ProtocolType[]) f204661a.clone();
    }

    public static ProtocolType valueOf(String r100) {
        return (ProtocolType) a.a(ProtocolType.class, r100);
    }

    public ProtocolType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
