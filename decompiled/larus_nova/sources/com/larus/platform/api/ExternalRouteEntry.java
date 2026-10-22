package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/ExternalRouteEntry;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL_ACTIVITY", "NEW_INTENT", "EXISTING_STACK", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExternalRouteEntry extends Enum<ExternalRouteEntry> {
    public static final ExternalRouteEntry EXISTING_STACK = null;
    public static final ExternalRouteEntry INITIAL_ACTIVITY = null;
    public static final ExternalRouteEntry NEW_INTENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalRouteEntry[] f364768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364769b = null;

    public static EnumEntries<ExternalRouteEntry> getEntries() {
        return f364769b;
    }

    static {
        ExternalRouteEntry r100 = new ExternalRouteEntry("INITIAL_ACTIVITY", 0);
        INITIAL_ACTIVITY = r100;
        ExternalRouteEntry r101 = new ExternalRouteEntry("NEW_INTENT", 1);
        NEW_INTENT = r101;
        ExternalRouteEntry r102 = new ExternalRouteEntry("EXISTING_STACK", 2);
        EXISTING_STACK = r102;
        ExternalRouteEntry[] r103 = {r100, r101, r102};
        f364768a = r103;
        f364769b = EnumEntriesKt.enumEntries(r103);
    }

    public static ExternalRouteEntry[] values() {
        return (ExternalRouteEntry[]) f364768a.clone();
    }

    public static ExternalRouteEntry valueOf(String r100) {
        return (ExternalRouteEntry) r27.a.a(ExternalRouteEntry.class, r100);
    }

    public ExternalRouteEntry(String r100, int r101) {
        super(r100, r101);
    }
}
