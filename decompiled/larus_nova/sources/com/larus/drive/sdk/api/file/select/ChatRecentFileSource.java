package com.larus.drive.sdk.api.file.select;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/drive/sdk/api/file/select/ChatRecentFileSource;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", AccountType.LARK, "DOUBAO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatRecentFileSource extends Enum<ChatRecentFileSource> {
    public static final ChatRecentFileSource DOUBAO = null;
    public static final ChatRecentFileSource LARK = null;
    public static final ChatRecentFileSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatRecentFileSource[] f341585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341586b = null;

    public static EnumEntries<ChatRecentFileSource> getEntries() {
        return f341586b;
    }

    static {
        ChatRecentFileSource r100 = new ChatRecentFileSource("UNKNOWN", 0);
        UNKNOWN = r100;
        ChatRecentFileSource r101 = new ChatRecentFileSource(AccountType.LARK, 1);
        LARK = r101;
        ChatRecentFileSource r102 = new ChatRecentFileSource("DOUBAO", 2);
        DOUBAO = r102;
        ChatRecentFileSource[] r103 = {r100, r101, r102};
        f341585a = r103;
        f341586b = EnumEntriesKt.enumEntries(r103);
    }

    public static ChatRecentFileSource[] values() {
        return (ChatRecentFileSource[]) f341585a.clone();
    }

    public static ChatRecentFileSource valueOf(String r100) {
        return (ChatRecentFileSource) a.a(ChatRecentFileSource.class, r100);
    }

    public ChatRecentFileSource(String r100, int r101) {
        super(r100, r101);
    }
}
