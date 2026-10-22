package com.larus.bmhome.chat.dora;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/dora/ChatDoraSoundType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DORA_SOUND_TYPE_RECORDING_START", "DORA_SOUND_TYPE_RECORDING_COMPLETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatDoraSoundType extends Enum<ChatDoraSoundType> {
    public static final ChatDoraSoundType DORA_SOUND_TYPE_RECORDING_COMPLETE = null;
    public static final ChatDoraSoundType DORA_SOUND_TYPE_RECORDING_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatDoraSoundType[] f302935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f302936b = null;

    public static EnumEntries<ChatDoraSoundType> getEntries() {
        return f302936b;
    }

    static {
        ChatDoraSoundType r100 = new ChatDoraSoundType("DORA_SOUND_TYPE_RECORDING_START", 0);
        DORA_SOUND_TYPE_RECORDING_START = r100;
        ChatDoraSoundType r101 = new ChatDoraSoundType("DORA_SOUND_TYPE_RECORDING_COMPLETE", 1);
        DORA_SOUND_TYPE_RECORDING_COMPLETE = r101;
        ChatDoraSoundType[] r102 = {r100, r101};
        f302935a = r102;
        f302936b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatDoraSoundType[] values() {
        return (ChatDoraSoundType[]) f302935a.clone();
    }

    public static ChatDoraSoundType valueOf(String r100) {
        return (ChatDoraSoundType) r27.a.a(ChatDoraSoundType.class, r100);
    }

    public ChatDoraSoundType(String r100, int r101) {
        super(r100, r101);
    }
}
