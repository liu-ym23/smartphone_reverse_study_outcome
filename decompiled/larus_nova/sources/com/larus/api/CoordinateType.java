package com.larus.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/api/CoordinateType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "GCJ_O2", "WGS_84", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CoordinateType extends Enum<CoordinateType> {
    public static final CoordinateType GCJ_O2 = null;
    public static final CoordinateType WGS_84 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CoordinateType[] f286871a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286872b = null;
    private final String type;

    public static EnumEntries<CoordinateType> getEntries() {
        return f286872b;
    }

    static {
        CoordinateType r100 = new CoordinateType("GCJ_O2", 0, "gcj02");
        GCJ_O2 = r100;
        CoordinateType r101 = new CoordinateType("WGS_84", 1, "wgs84");
        WGS_84 = r101;
        CoordinateType[] r102 = {r100, r101};
        f286871a = r102;
        f286872b = EnumEntriesKt.enumEntries(r102);
    }

    public static CoordinateType[] values() {
        return (CoordinateType[]) f286871a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static CoordinateType valueOf(String r100) {
        return (CoordinateType) a.a(CoordinateType.class, r100);
    }

    public CoordinateType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
