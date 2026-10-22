package com.larus.contextwindow.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowTotalSource;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE", "CURRENT_MODEL", "MESSAGE_FALLBACK", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowTotalSource extends Enum<ContextWindowTotalSource> {
    public static final ContextWindowTotalSource CURRENT_MODEL = null;
    public static final ContextWindowTotalSource MESSAGE = null;
    public static final ContextWindowTotalSource MESSAGE_FALLBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContextWindowTotalSource[] f330265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330266b = null;

    public static EnumEntries<ContextWindowTotalSource> getEntries() {
        return f330266b;
    }

    static {
        ContextWindowTotalSource r100 = new ContextWindowTotalSource("MESSAGE", 0);
        MESSAGE = r100;
        ContextWindowTotalSource r101 = new ContextWindowTotalSource("CURRENT_MODEL", 1);
        CURRENT_MODEL = r101;
        ContextWindowTotalSource r102 = new ContextWindowTotalSource("MESSAGE_FALLBACK", 2);
        MESSAGE_FALLBACK = r102;
        ContextWindowTotalSource[] r103 = {r100, r101, r102};
        f330265a = r103;
        f330266b = EnumEntriesKt.enumEntries(r103);
    }

    public static ContextWindowTotalSource[] values() {
        return (ContextWindowTotalSource[]) f330265a.clone();
    }

    public static ContextWindowTotalSource valueOf(String r100) {
        return (ContextWindowTotalSource) r27.a.a(ContextWindowTotalSource.class, r100);
    }

    public ContextWindowTotalSource(String r100, int r101) {
        super(r100, r101);
    }
}
