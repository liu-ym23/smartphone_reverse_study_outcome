package com.larus.search.impl.combine.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/search/impl/combine/model/AutoSearchType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "MESSAGE", "BOT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AutoSearchType extends Enum<AutoSearchType> {
    public static final AutoSearchType BOT = null;
    public static final AutoSearchType MESSAGE = null;
    public static final AutoSearchType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AutoSearchType[] f367595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367596b = null;

    public static EnumEntries<AutoSearchType> getEntries() {
        return f367596b;
    }

    static {
        AutoSearchType r100 = new AutoSearchType("UNKNOWN", 0);
        UNKNOWN = r100;
        AutoSearchType r101 = new AutoSearchType("MESSAGE", 1);
        MESSAGE = r101;
        AutoSearchType r102 = new AutoSearchType("BOT", 2);
        BOT = r102;
        AutoSearchType[] r103 = {r100, r101, r102};
        f367595a = r103;
        f367596b = EnumEntriesKt.enumEntries(r103);
    }

    public static AutoSearchType[] values() {
        return (AutoSearchType[]) f367595a.clone();
    }

    public static AutoSearchType valueOf(String r100) {
        return (AutoSearchType) a.a(AutoSearchType.class, r100);
    }

    public AutoSearchType(String r100, int r101) {
        super(r100, r101);
    }
}
