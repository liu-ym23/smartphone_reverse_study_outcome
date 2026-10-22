package com.ss.android.lark.biz.im.api.extension.embedded;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/embedded/EmbeddedChatType;", "", "<init>", "(Ljava/lang/String;I)V", "Chat", "Thread", "MyAI", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EmbeddedChatType extends Enum<EmbeddedChatType> {
    public static final EmbeddedChatType Chat = null;
    public static final EmbeddedChatType MyAI = null;
    public static final EmbeddedChatType Thread = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmbeddedChatType[] f410111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410112b = null;

    public static EnumEntries<EmbeddedChatType> getEntries() {
        return f410112b;
    }

    static {
        EmbeddedChatType r100 = new EmbeddedChatType("Chat", 0);
        Chat = r100;
        EmbeddedChatType r101 = new EmbeddedChatType("Thread", 1);
        Thread = r101;
        EmbeddedChatType r102 = new EmbeddedChatType("MyAI", 2);
        MyAI = r102;
        EmbeddedChatType[] r103 = {r100, r101, r102};
        f410111a = r103;
        f410112b = EnumEntriesKt.enumEntries(r103);
    }

    public static EmbeddedChatType[] values() {
        return (EmbeddedChatType[]) f410111a.clone();
    }

    public static EmbeddedChatType valueOf(String r100) {
        return (EmbeddedChatType) a.a(EmbeddedChatType.class, r100);
    }

    public EmbeddedChatType(String r100, int r101) {
        super(r100, r101);
    }
}
