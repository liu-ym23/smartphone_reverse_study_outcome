package com.larus.business.floatchat.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/floatchat/api/AIChatActionBarItemLocation;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY_BAR", "DETAIL_PANEL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIChatActionBarItemLocation extends Enum<AIChatActionBarItemLocation> {
    public static final AIChatActionBarItemLocation DETAIL_PANEL = null;
    public static final AIChatActionBarItemLocation PRIMARY_BAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AIChatActionBarItemLocation[] f320083a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f320084b = null;

    public static EnumEntries<AIChatActionBarItemLocation> getEntries() {
        return f320084b;
    }

    static {
        AIChatActionBarItemLocation r100 = new AIChatActionBarItemLocation("PRIMARY_BAR", 0);
        PRIMARY_BAR = r100;
        AIChatActionBarItemLocation r101 = new AIChatActionBarItemLocation("DETAIL_PANEL", 1);
        DETAIL_PANEL = r101;
        AIChatActionBarItemLocation[] r102 = {r100, r101};
        f320083a = r102;
        f320084b = EnumEntriesKt.enumEntries(r102);
    }

    public static AIChatActionBarItemLocation[] values() {
        return (AIChatActionBarItemLocation[]) f320083a.clone();
    }

    public static AIChatActionBarItemLocation valueOf(String r100) {
        return (AIChatActionBarItemLocation) a.a(AIChatActionBarItemLocation.class, r100);
    }

    public AIChatActionBarItemLocation(String r100, int r101) {
        super(r100, r101);
    }
}
