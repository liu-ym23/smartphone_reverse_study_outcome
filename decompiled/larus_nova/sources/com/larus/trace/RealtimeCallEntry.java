package com.larus.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/trace/RealtimeCallEntry;", "", "trackName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackName", "()Ljava/lang/String;", "CHAT_TITLE_BAR", "MAIN_ACTION_BAR", "MAIN_PLUS_PANEL", "LIST_MAIN_ICON", "LIST_UGC_BOTS_ICON", "DISCOVER_UGC_BOTS_ICON", "INPUT_ACTION", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimeCallEntry extends Enum<RealtimeCallEntry> {
    public static final RealtimeCallEntry CHAT_TITLE_BAR = null;
    public static final RealtimeCallEntry DISCOVER_UGC_BOTS_ICON = null;
    public static final RealtimeCallEntry INPUT_ACTION = null;
    public static final RealtimeCallEntry LIST_MAIN_ICON = null;
    public static final RealtimeCallEntry LIST_UGC_BOTS_ICON = null;
    public static final RealtimeCallEntry MAIN_ACTION_BAR = null;
    public static final RealtimeCallEntry MAIN_PLUS_PANEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealtimeCallEntry[] f370153a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370154b = null;
    private final String trackName;

    public static EnumEntries<RealtimeCallEntry> getEntries() {
        return f370154b;
    }

    static {
        RealtimeCallEntry r100 = new RealtimeCallEntry("CHAT_TITLE_BAR", 0, "chat_title_bar");
        CHAT_TITLE_BAR = r100;
        RealtimeCallEntry r101 = new RealtimeCallEntry("MAIN_ACTION_BAR", 1, "main_action_bar");
        MAIN_ACTION_BAR = r101;
        RealtimeCallEntry r102 = new RealtimeCallEntry("MAIN_PLUS_PANEL", 2, "main_plus_panel");
        MAIN_PLUS_PANEL = r102;
        RealtimeCallEntry r103 = new RealtimeCallEntry("LIST_MAIN_ICON", 3, "list_main_icon");
        LIST_MAIN_ICON = r103;
        RealtimeCallEntry r104 = new RealtimeCallEntry("LIST_UGC_BOTS_ICON", 4, "list_ugc_bots_icon");
        LIST_UGC_BOTS_ICON = r104;
        RealtimeCallEntry r105 = new RealtimeCallEntry("DISCOVER_UGC_BOTS_ICON", 5, "discover_ugc_bots_icon");
        DISCOVER_UGC_BOTS_ICON = r105;
        RealtimeCallEntry r110 = new RealtimeCallEntry("INPUT_ACTION", 6, "input_action");
        INPUT_ACTION = r110;
        RealtimeCallEntry[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f370153a = r111;
        f370154b = EnumEntriesKt.enumEntries(r111);
    }

    public static RealtimeCallEntry[] values() {
        return (RealtimeCallEntry[]) f370153a.clone();
    }

    public final String getTrackName() {
        return this.trackName;
    }

    public static RealtimeCallEntry valueOf(String r100) {
        return (RealtimeCallEntry) a.a(RealtimeCallEntry.class, r100);
    }

    public RealtimeCallEntry(String r100, int r101, String r102) {
        super(r100, r101);
        this.trackName = r102;
    }
}
