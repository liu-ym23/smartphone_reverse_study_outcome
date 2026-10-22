package com.larus.contextwindow.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowContainer;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT_CHAT", "NATIVE_ROUTE", "UNSUPPORTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowContainer extends Enum<ContextWindowContainer> {
    public static final ContextWindowContainer DEFAULT_CHAT = null;
    public static final ContextWindowContainer NATIVE_ROUTE = null;
    public static final ContextWindowContainer UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContextWindowContainer[] f330231a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330232b = null;

    public static EnumEntries<ContextWindowContainer> getEntries() {
        return f330232b;
    }

    static {
        ContextWindowContainer r100 = new ContextWindowContainer("DEFAULT_CHAT", 0);
        DEFAULT_CHAT = r100;
        ContextWindowContainer r101 = new ContextWindowContainer("NATIVE_ROUTE", 1);
        NATIVE_ROUTE = r101;
        ContextWindowContainer r102 = new ContextWindowContainer("UNSUPPORTED", 2);
        UNSUPPORTED = r102;
        ContextWindowContainer[] r103 = {r100, r101, r102};
        f330231a = r103;
        f330232b = EnumEntriesKt.enumEntries(r103);
    }

    public static ContextWindowContainer[] values() {
        return (ContextWindowContainer[]) f330231a.clone();
    }

    public static ContextWindowContainer valueOf(String r100) {
        return (ContextWindowContainer) r27.a.a(ContextWindowContainer.class, r100);
    }

    public ContextWindowContainer(String r100, int r101) {
        super(r100, r101);
    }
}
