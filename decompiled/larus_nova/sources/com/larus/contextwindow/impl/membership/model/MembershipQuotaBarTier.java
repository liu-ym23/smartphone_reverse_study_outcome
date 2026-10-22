package com.larus.contextwindow.impl.membership.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaBarTier;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY", "PRIMARY", "WARNING", "DANGER", "NEUTRAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MembershipQuotaBarTier extends Enum<MembershipQuotaBarTier> {
    public static final MembershipQuotaBarTier DANGER = null;
    public static final MembershipQuotaBarTier EMPTY = null;
    public static final MembershipQuotaBarTier NEUTRAL = null;
    public static final MembershipQuotaBarTier PRIMARY = null;
    public static final MembershipQuotaBarTier WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MembershipQuotaBarTier[] f330397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330398b = null;

    public static EnumEntries<MembershipQuotaBarTier> getEntries() {
        return f330398b;
    }

    static {
        MembershipQuotaBarTier r100 = new MembershipQuotaBarTier("EMPTY", 0);
        EMPTY = r100;
        MembershipQuotaBarTier r101 = new MembershipQuotaBarTier("PRIMARY", 1);
        PRIMARY = r101;
        MembershipQuotaBarTier r102 = new MembershipQuotaBarTier("WARNING", 2);
        WARNING = r102;
        MembershipQuotaBarTier r103 = new MembershipQuotaBarTier("DANGER", 3);
        DANGER = r103;
        MembershipQuotaBarTier r104 = new MembershipQuotaBarTier("NEUTRAL", 4);
        NEUTRAL = r104;
        MembershipQuotaBarTier[] r105 = {r100, r101, r102, r103, r104};
        f330397a = r105;
        f330398b = EnumEntriesKt.enumEntries(r105);
    }

    public static MembershipQuotaBarTier[] values() {
        return (MembershipQuotaBarTier[]) f330397a.clone();
    }

    public static MembershipQuotaBarTier valueOf(String r100) {
        return (MembershipQuotaBarTier) a.a(MembershipQuotaBarTier.class, r100);
    }

    public MembershipQuotaBarTier(String r100, int r101) {
        super(r100, r101);
    }
}
