package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/im/bean/message/ChatEntrySourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ChatEntrySourceType_Default", "ChatEntrySourceType_EcomSaaS", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatEntrySourceType extends Enum<ChatEntrySourceType> {
    public static final ChatEntrySourceType ChatEntrySourceType_Default = null;
    public static final ChatEntrySourceType ChatEntrySourceType_EcomSaaS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatEntrySourceType[] f346591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346592b = null;
    private final int value;

    public static EnumEntries<ChatEntrySourceType> getEntries() {
        return f346592b;
    }

    static {
        ChatEntrySourceType r100 = new ChatEntrySourceType("ChatEntrySourceType_Default", 0, 0);
        ChatEntrySourceType_Default = r100;
        ChatEntrySourceType r101 = new ChatEntrySourceType("ChatEntrySourceType_EcomSaaS", 1, 1);
        ChatEntrySourceType_EcomSaaS = r101;
        ChatEntrySourceType[] r102 = {r100, r101};
        f346591a = r102;
        f346592b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatEntrySourceType[] values() {
        return (ChatEntrySourceType[]) f346591a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatEntrySourceType valueOf(String r100) {
        return (ChatEntrySourceType) r27.a.a(ChatEntrySourceType.class, r100);
    }

    public ChatEntrySourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
