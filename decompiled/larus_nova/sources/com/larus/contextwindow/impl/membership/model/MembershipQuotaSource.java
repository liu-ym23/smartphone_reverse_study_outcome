package com.larus.contextwindow.impl.membership.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaSource;", "", "<init>", "(Ljava/lang/String;I)V", "PERSONAL", "ENTERPRISE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MembershipQuotaSource extends Enum<MembershipQuotaSource> {
    public static final MembershipQuotaSource ENTERPRISE = null;
    public static final MembershipQuotaSource PERSONAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MembershipQuotaSource[] f330401a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330402b = null;

    public static EnumEntries<MembershipQuotaSource> getEntries() {
        return f330402b;
    }

    static {
        MembershipQuotaSource r100 = new MembershipQuotaSource("PERSONAL", 0);
        PERSONAL = r100;
        MembershipQuotaSource r101 = new MembershipQuotaSource("ENTERPRISE", 1);
        ENTERPRISE = r101;
        MembershipQuotaSource[] r102 = {r100, r101};
        f330401a = r102;
        f330402b = EnumEntriesKt.enumEntries(r102);
    }

    public static MembershipQuotaSource[] values() {
        return (MembershipQuotaSource[]) f330401a.clone();
    }

    public static MembershipQuotaSource valueOf(String r100) {
        return (MembershipQuotaSource) a.a(MembershipQuotaSource.class, r100);
    }

    public MembershipQuotaSource(String r100, int r101) {
        super(r100, r101);
    }
}
