package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/preloaderv2/loader/DataPreLoaderType;", "", "<init>", "(Ljava/lang/String;I)V", "CHAT_DATA", "CHAT_WINDOW", "CHAT_DESTINATION", "TEAM_VISITOR_CHAT", "MY_AI_THREAD", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DataPreLoaderType extends Enum<DataPreLoaderType> {
    public static final DataPreLoaderType CHAT_DATA = null;
    public static final DataPreLoaderType CHAT_DESTINATION = null;
    public static final DataPreLoaderType CHAT_WINDOW = null;
    public static final DataPreLoaderType MY_AI_THREAD = null;
    public static final DataPreLoaderType TEAM_VISITOR_CHAT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataPreLoaderType[] f413499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f413500b = null;

    public static EnumEntries<DataPreLoaderType> getEntries() {
        return f413500b;
    }

    static {
        DataPreLoaderType r100 = new DataPreLoaderType("CHAT_DATA", 0);
        CHAT_DATA = r100;
        DataPreLoaderType r101 = new DataPreLoaderType("CHAT_WINDOW", 1);
        CHAT_WINDOW = r101;
        DataPreLoaderType r102 = new DataPreLoaderType("CHAT_DESTINATION", 2);
        CHAT_DESTINATION = r102;
        DataPreLoaderType r103 = new DataPreLoaderType("TEAM_VISITOR_CHAT", 3);
        TEAM_VISITOR_CHAT = r103;
        DataPreLoaderType r104 = new DataPreLoaderType("MY_AI_THREAD", 4);
        MY_AI_THREAD = r104;
        DataPreLoaderType[] r105 = {r100, r101, r102, r103, r104};
        f413499a = r105;
        f413500b = EnumEntriesKt.enumEntries(r105);
    }

    public static DataPreLoaderType[] values() {
        return (DataPreLoaderType[]) f413499a.clone();
    }

    public static DataPreLoaderType valueOf(String r100) {
        return (DataPreLoaderType) r27.a.a(DataPreLoaderType.class, r100);
    }

    public DataPreLoaderType(String r100, int r101) {
        super(r100, r101);
    }
}
