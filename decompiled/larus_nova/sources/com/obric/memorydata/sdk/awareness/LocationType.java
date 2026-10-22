package com.obric.memorydata.sdk.awareness;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/LocationType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HOME", "COMPANY", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum LocationType extends Enum<LocationType> {
    public static final LocationType COMPANY = null;
    public static final LocationType HOME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocationType[] f397095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397096b = null;
    private final String value;

    public static EnumEntries<LocationType> getEntries() {
        return f397096b;
    }

    static {
        LocationType r100 = new LocationType("HOME", 0, "location_home_gps");
        HOME = r100;
        LocationType r101 = new LocationType("COMPANY", 1, "location_company_gps");
        COMPANY = r101;
        LocationType[] r102 = {r100, r101};
        f397095a = r102;
        f397096b = EnumEntriesKt.enumEntries(r102);
    }

    public static LocationType[] values() {
        return (LocationType[]) f397095a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static LocationType valueOf(String r100) {
        return (LocationType) r27.a.a(LocationType.class, r100);
    }

    public LocationType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
