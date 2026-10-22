package com.obric.assistant.chat.menu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/chat/menu/AsrFeedBack;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ToDouBao", "NotToDouBao", "Reset", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrFeedBack extends Enum<AsrFeedBack> {
    public static final AsrFeedBack NotToDouBao = null;
    public static final AsrFeedBack Reset = null;
    public static final AsrFeedBack ToDouBao = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrFeedBack[] f386963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f386964b = null;
    private final String value;

    public static EnumEntries<AsrFeedBack> getEntries() {
        return f386964b;
    }

    static {
        AsrFeedBack r100 = new AsrFeedBack("ToDouBao", 0, "1");
        ToDouBao = r100;
        AsrFeedBack r101 = new AsrFeedBack("NotToDouBao", 1, "2");
        NotToDouBao = r101;
        AsrFeedBack r102 = new AsrFeedBack("Reset", 2, "3");
        Reset = r102;
        AsrFeedBack[] r103 = {r100, r101, r102};
        f386963a = r103;
        f386964b = EnumEntriesKt.enumEntries(r103);
    }

    public static AsrFeedBack[] values() {
        return (AsrFeedBack[]) f386963a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AsrFeedBack valueOf(String r100) {
        return (AsrFeedBack) r27.a.a(AsrFeedBack.class, r100);
    }

    public AsrFeedBack(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
