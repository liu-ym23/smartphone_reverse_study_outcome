package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CertificateStatus extends Enum<CertificateStatus> implements WireEnum {
    private static final /* synthetic */ CertificateStatus[] $VALUES = null;
    public static final ProtoAdapter<CertificateStatus> ADAPTER = null;
    public static final CertificateStatus CERTIFICATED = null;
    public static final CertificateStatus EXPIRED = null;
    public static final CertificateStatus TEAM_CERTIFICATED = null;
    public static final CertificateStatus UNCERTIFICATED = null;
    private final int value;

    static {
        CertificateStatus r100 = new CertificateStatus("UNCERTIFICATED", 0, 0);
        UNCERTIFICATED = r100;
        CertificateStatus r101 = new CertificateStatus("CERTIFICATED", 1, 1);
        CERTIFICATED = r101;
        CertificateStatus r102 = new CertificateStatus("EXPIRED", 2, 2);
        EXPIRED = r102;
        CertificateStatus r103 = new CertificateStatus("TEAM_CERTIFICATED", 3, 3);
        TEAM_CERTIFICATED = r103;
        $VALUES = new CertificateStatus[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(CertificateStatus.class);
    }

    public static CertificateStatus[] values() {
        return (CertificateStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CertificateStatus fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return TEAM_CERTIFICATED;
    L14:
        return EXPIRED;
    L16:
        return CERTIFICATED;
    L18:
        return UNCERTIFICATED;
    }

    public static CertificateStatus valueOf(String r100) {
        return (CertificateStatus) a.a(CertificateStatus.class, r100);
    }

    private CertificateStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
