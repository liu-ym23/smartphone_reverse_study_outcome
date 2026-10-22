package com.larus.contextwindow.impl.membership.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaRowKind;", "", "<init>", "(Ljava/lang/String;I)V", "H5", "D7", "SUBSCRIPTION_TOTAL", "M1", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MembershipQuotaRowKind extends Enum<MembershipQuotaRowKind> {
    public static final MembershipQuotaRowKind D7 = null;
    public static final MembershipQuotaRowKind H5 = null;
    public static final MembershipQuotaRowKind M1 = null;
    public static final MembershipQuotaRowKind SUBSCRIPTION_TOTAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MembershipQuotaRowKind[] f330399a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330400b = null;

    public static EnumEntries<MembershipQuotaRowKind> getEntries() {
        return f330400b;
    }

    static {
        MembershipQuotaRowKind r100 = new MembershipQuotaRowKind("H5", 0);
        H5 = r100;
        MembershipQuotaRowKind r101 = new MembershipQuotaRowKind("D7", 1);
        D7 = r101;
        MembershipQuotaRowKind r102 = new MembershipQuotaRowKind("SUBSCRIPTION_TOTAL", 2);
        SUBSCRIPTION_TOTAL = r102;
        MembershipQuotaRowKind r103 = new MembershipQuotaRowKind("M1", 3);
        M1 = r103;
        MembershipQuotaRowKind[] r104 = {r100, r101, r102, r103};
        f330399a = r104;
        f330400b = EnumEntriesKt.enumEntries(r104);
    }

    public static MembershipQuotaRowKind[] values() {
        return (MembershipQuotaRowKind[]) f330399a.clone();
    }

    public static MembershipQuotaRowKind valueOf(String r100) {
        return (MembershipQuotaRowKind) a.a(MembershipQuotaRowKind.class, r100);
    }

    public MembershipQuotaRowKind(String r100, int r101) {
        super(r100, r101);
    }
}
