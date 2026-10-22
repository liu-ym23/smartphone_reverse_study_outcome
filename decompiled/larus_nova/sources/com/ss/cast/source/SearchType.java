package com.ss.cast.source;

/* JADX INFO: loaded from: classes40.dex */
public final enum SearchType extends Enum<SearchType> {
    public static final SearchType BLE = null;
    public static final SearchType MDNS = null;
    public static final SearchType SSDP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchType[] f456540a = null;

    static {
        SearchType r100 = new SearchType("BLE", 0);
        BLE = r100;
        SearchType r101 = new SearchType("SSDP", 1);
        SSDP = r101;
        SearchType r102 = new SearchType("MDNS", 2);
        MDNS = r102;
        f456540a = new SearchType[]{r100, r101, r102};
    }

    public static SearchType[] values() {
        return (SearchType[]) f456540a.clone();
    }

    public static SearchType valueOf(String r100) {
        return (SearchType) r27.a.a(SearchType.class, r100);
    }

    public SearchType(String r100, int r101) {
        super(r100, r101);
    }
}
