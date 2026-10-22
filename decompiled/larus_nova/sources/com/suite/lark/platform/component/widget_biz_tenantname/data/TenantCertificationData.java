package com.suite.lark.platform.component.widget_biz_tenantname.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class TenantCertificationData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f461123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CertificateStatus f461124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f461125c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_tenantname/data/TenantCertificationData$CertificateStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNCERTIFICATED", "CERTIFICATED", "EXPIRED", "TEAM_CERTIFICATED", "getValue", "Companion", "widget-biz-tenantname_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CertificateStatus extends Enum<CertificateStatus> {
        public static final CertificateStatus CERTIFICATED = null;
        public static final a Companion = null;
        public static final CertificateStatus EXPIRED = null;
        public static final CertificateStatus TEAM_CERTIFICATED = null;
        public static final CertificateStatus UNCERTIFICATED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CertificateStatus[] f461126a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f461127b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<CertificateStatus> getEntries() {
            return f461127b;
        }

        static {
            CertificateStatus r100 = new CertificateStatus("UNCERTIFICATED", 0, 0);
            UNCERTIFICATED = r100;
            CertificateStatus r101 = new CertificateStatus("CERTIFICATED", 1, 1);
            CERTIFICATED = r101;
            CertificateStatus r102 = new CertificateStatus("EXPIRED", 2, 2);
            EXPIRED = r102;
            CertificateStatus r103 = new CertificateStatus("TEAM_CERTIFICATED", 3, 3);
            TEAM_CERTIFICATED = r103;
            CertificateStatus[] r104 = {r100, r101, r102, r103};
            f461126a = r104;
            f461127b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static CertificateStatus[] values() {
            return (CertificateStatus[]) f461126a.clone();
        }

        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final CertificateStatus fromValue(Integer r100) {
            Companion.getClass();
            if (r100 != null) goto L6;
            return UNCERTIFICATED;
        L6:
            if (r100.intValue() != 0) goto L9;
            return UNCERTIFICATED;
        L9:
            if (r100.intValue() != 1) goto L12;
            return CERTIFICATED;
        L12:
            if (r100.intValue() != 2) goto L15;
            return EXPIRED;
        L15:
            if (r100.intValue() == 3) goto L23;
            return null;
        L23:
            return TEAM_CERTIFICATED;
        }

        public static CertificateStatus valueOf(String r100) {
            return (CertificateStatus) r27.a.a(CertificateStatus.class, r100);
        }

        public CertificateStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public TenantCertificationData() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TenantCertificationData) == true) goto L8;
        return false;
    L8:
        TenantCertificationData r101 = (TenantCertificationData) r100;
        if (Intrinsics.areEqual(this.f461123a, r101.f461123a) == true) goto L12;
        return false;
    L12:
        if (this.f461124b == r101.f461124b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f461125c, r101.f461125c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f461123a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        CertificateStatus r104 = this.f461124b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f461125c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TenantCertificationData(isShowCertSign=" + this.f461123a + ", certificateStatus=" + this.f461124b + ", tenantCertificationUrl=" + this.f461125c + ')';
    }

    public TenantCertificationData(Boolean r100, CertificateStatus r101, String r102) {
        this.f461123a = r100;
        this.f461124b = r101;
        this.f461125c = r102;
    }
}
