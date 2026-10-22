package com.larus.bmhome.chat.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/bean/ActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Redirection", "SendMessage", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType Redirection = null;
    public static final ActionType SendMessage = null;
    public static final ActionType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f297401a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297402b = null;
    private final int value;

    public static EnumEntries<ActionType> getEntries() {
        return f297402b;
    }

    static {
        ActionType r100 = new ActionType("Unknown", 0, 0);
        Unknown = r100;
        ActionType r101 = new ActionType("Redirection", 1, 1);
        Redirection = r101;
        ActionType r102 = new ActionType("SendMessage", 2, 2);
        SendMessage = r102;
        ActionType[] r103 = {r100, r101, r102};
        f297401a = r103;
        f297402b = EnumEntriesKt.enumEntries(r103);
    }

    public static ActionType[] values() {
        return (ActionType[]) f297401a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) r27.a.a(ActionType.class, r100);
    }

    public ActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
