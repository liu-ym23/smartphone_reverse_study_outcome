package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/AppletDebuggerEntryState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "HIDDEN", "VISIBLE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletDebuggerEntryState extends Enum<AppletDebuggerEntryState> {
    public static final AppletDebuggerEntryState HIDDEN = null;
    public static final AppletDebuggerEntryState LOADING = null;
    public static final AppletDebuggerEntryState VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppletDebuggerEntryState[] f364750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364751b = null;

    public static EnumEntries<AppletDebuggerEntryState> getEntries() {
        return f364751b;
    }

    static {
        AppletDebuggerEntryState r100 = new AppletDebuggerEntryState("LOADING", 0);
        LOADING = r100;
        AppletDebuggerEntryState r101 = new AppletDebuggerEntryState("HIDDEN", 1);
        HIDDEN = r101;
        AppletDebuggerEntryState r102 = new AppletDebuggerEntryState("VISIBLE", 2);
        VISIBLE = r102;
        AppletDebuggerEntryState[] r103 = {r100, r101, r102};
        f364750a = r103;
        f364751b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppletDebuggerEntryState[] values() {
        return (AppletDebuggerEntryState[]) f364750a.clone();
    }

    public static AppletDebuggerEntryState valueOf(String r100) {
        return (AppletDebuggerEntryState) r27.a.a(AppletDebuggerEntryState.class, r100);
    }

    public AppletDebuggerEntryState(String r100, int r101) {
        super(r100, r101);
    }
}
