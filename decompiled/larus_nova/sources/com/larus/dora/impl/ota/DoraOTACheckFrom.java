package com.larus.dora.impl.ota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/ota/DoraOTACheckFrom;", "", "<init>", "(Ljava/lang/String;I)V", "ANDROID_INFO_RECEIVED", "FRAGMENT_VIEW_CREATED", "FRAGMENT_RETRY", "FILE_NOT_EXIST", "REQUIRE_FULL_PACKAGE", "DEBUG_PAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraOTACheckFrom extends Enum<DoraOTACheckFrom> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DoraOTACheckFrom[] $VALUES = null;
    public static final DoraOTACheckFrom ANDROID_INFO_RECEIVED = null;
    public static final DoraOTACheckFrom DEBUG_PAGE = null;
    public static final DoraOTACheckFrom FILE_NOT_EXIST = null;
    public static final DoraOTACheckFrom FRAGMENT_RETRY = null;
    public static final DoraOTACheckFrom FRAGMENT_VIEW_CREATED = null;
    public static final DoraOTACheckFrom REQUIRE_FULL_PACKAGE = null;

    private static final /* synthetic */ DoraOTACheckFrom[] $values() {
        return new DoraOTACheckFrom[]{ANDROID_INFO_RECEIVED, FRAGMENT_VIEW_CREATED, FRAGMENT_RETRY, FILE_NOT_EXIST, REQUIRE_FULL_PACKAGE, DEBUG_PAGE};
    }

    public static EnumEntries<DoraOTACheckFrom> getEntries() {
        return $ENTRIES;
    }

    static {
        ANDROID_INFO_RECEIVED = new DoraOTACheckFrom("ANDROID_INFO_RECEIVED", 0);
        FRAGMENT_VIEW_CREATED = new DoraOTACheckFrom("FRAGMENT_VIEW_CREATED", 1);
        FRAGMENT_RETRY = new DoraOTACheckFrom("FRAGMENT_RETRY", 2);
        FILE_NOT_EXIST = new DoraOTACheckFrom("FILE_NOT_EXIST", 3);
        REQUIRE_FULL_PACKAGE = new DoraOTACheckFrom("REQUIRE_FULL_PACKAGE", 4);
        DEBUG_PAGE = new DoraOTACheckFrom("DEBUG_PAGE", 5);
        DoraOTACheckFrom[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DoraOTACheckFrom[] values() {
        return (DoraOTACheckFrom[]) $VALUES.clone();
    }

    public static DoraOTACheckFrom valueOf(String r100) {
        return (DoraOTACheckFrom) r27.a.a(DoraOTACheckFrom.class, r100);
    }

    private DoraOTACheckFrom(String r100, int r101) {
        super(r100, r101);
    }
}
