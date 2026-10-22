package com.larus.bmhome.social.page.datasource.event;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/social/page/datasource/event/RefreshTraceSource;", "", "tag", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "PRELOAD", AccountType.LOCAL, "REMOTE", "SEND", "RECEIVE", "UPDATE", "REGEN", "REMOVE", "REFRESH_ALL", "LIST_INSERT", "LIST_UPDATE", "LIST_REPLACE", "STREAM_END", "CONVERSATION_CHANGE", "REPROCESS", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RefreshTraceSource extends Enum<RefreshTraceSource> {
    public static final RefreshTraceSource CONVERSATION_CHANGE = null;
    public static final RefreshTraceSource LIST_INSERT = null;
    public static final RefreshTraceSource LIST_REPLACE = null;
    public static final RefreshTraceSource LIST_UPDATE = null;
    public static final RefreshTraceSource LOCAL = null;
    public static final RefreshTraceSource PRELOAD = null;
    public static final RefreshTraceSource RECEIVE = null;
    public static final RefreshTraceSource REFRESH_ALL = null;
    public static final RefreshTraceSource REGEN = null;
    public static final RefreshTraceSource REMOTE = null;
    public static final RefreshTraceSource REMOVE = null;
    public static final RefreshTraceSource REPROCESS = null;
    public static final RefreshTraceSource SEND = null;
    public static final RefreshTraceSource STREAM_END = null;
    public static final RefreshTraceSource UNKNOWN = null;
    public static final RefreshTraceSource UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshTraceSource[] f314030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314031b = null;
    private final String tag;

    public static EnumEntries<RefreshTraceSource> getEntries() {
        return f314031b;
    }

    static {
        RefreshTraceSource r100 = new RefreshTraceSource("PRELOAD", 0, "preload");
        PRELOAD = r100;
        RefreshTraceSource r101 = new RefreshTraceSource(AccountType.LOCAL, 1, "local");
        LOCAL = r101;
        RefreshTraceSource r102 = new RefreshTraceSource("REMOTE", 2, "remote");
        REMOTE = r102;
        RefreshTraceSource r103 = new RefreshTraceSource("SEND", 3, "onSendMessage");
        SEND = r103;
        RefreshTraceSource r104 = new RefreshTraceSource("RECEIVE", 4, "onReceiveMessage");
        RECEIVE = r104;
        RefreshTraceSource r105 = new RefreshTraceSource("UPDATE", 5, "onUpdateMessage");
        UPDATE = r105;
        RefreshTraceSource r110 = new RefreshTraceSource("REGEN", 6, "onRegenMessage");
        REGEN = r110;
        RefreshTraceSource r111 = new RefreshTraceSource("REMOVE", 7, "removeMessage");
        REMOVE = r111;
        RefreshTraceSource r112 = new RefreshTraceSource("REFRESH_ALL", 8, "refreshAllMessage");
        REFRESH_ALL = r112;
        RefreshTraceSource r113 = new RefreshTraceSource("LIST_INSERT", 9, "onMessageListInsert");
        LIST_INSERT = r113;
        RefreshTraceSource r114 = new RefreshTraceSource("LIST_UPDATE", 10, "onMessageListUpdate");
        LIST_UPDATE = r114;
        RefreshTraceSource r106 = new RefreshTraceSource("LIST_REPLACE", 11, "onMessageListReplaced");
        LIST_REPLACE = r106;
        RefreshTraceSource r107 = new RefreshTraceSource("STREAM_END", 12, "onStreamEnd");
        STREAM_END = r107;
        RefreshTraceSource r108 = new RefreshTraceSource("CONVERSATION_CHANGE", 13, "conversationChange");
        CONVERSATION_CHANGE = r108;
        RefreshTraceSource r109 = new RefreshTraceSource("REPROCESS", 14, "reprocess");
        REPROCESS = r109;
        RefreshTraceSource r115 = new RefreshTraceSource("UNKNOWN", 15, "unknown");
        UNKNOWN = r115;
        RefreshTraceSource[] r116 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115};
        f314030a = r116;
        f314031b = EnumEntriesKt.enumEntries(r116);
    }

    public static RefreshTraceSource[] values() {
        return (RefreshTraceSource[]) f314030a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public static RefreshTraceSource valueOf(String r100) {
        return (RefreshTraceSource) r27.a.a(RefreshTraceSource.class, r100);
    }

    public RefreshTraceSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
