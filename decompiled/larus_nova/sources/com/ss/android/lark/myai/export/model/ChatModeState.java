package com.ss.android.lark.myai.export.model;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/myai/export/model/ChatModeState;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN_STATE", "OPEN", ErrorCode.CLOSED, "Companion", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatModeState extends Enum<ChatModeState> {
    public static final ChatModeState CLOSED = null;
    public static final a Companion = null;
    public static final ChatModeState OPEN = null;
    public static final ChatModeState UNKNOWN_STATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatModeState[] f432888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f432889b = null;
    private final int number;

    public static EnumEntries<ChatModeState> getEntries() {
        return f432889b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.myai.export.model.ChatModeState$a] */
    static {
        ChatModeState r100 = new ChatModeState("UNKNOWN_STATE", 0, 0);
        UNKNOWN_STATE = r100;
        ChatModeState r101 = new ChatModeState("OPEN", 1, 1);
        OPEN = r101;
        ChatModeState r102 = new ChatModeState(ErrorCode.CLOSED, 2, 2);
        CLOSED = r102;
        ChatModeState[] r103 = {r100, r101, r102};
        f432888a = r103;
        f432889b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ChatModeState[] values() {
        return (ChatModeState[]) f432888a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static ChatModeState valueOf(String r100) {
        return (ChatModeState) r27.a.a(ChatModeState.class, r100);
    }

    public ChatModeState(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
