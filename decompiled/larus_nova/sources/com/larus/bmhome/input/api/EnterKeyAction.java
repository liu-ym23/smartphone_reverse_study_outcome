package com.larus.bmhome.input.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/input/api/EnterKeyAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SEND", "NEWLINE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnterKeyAction extends Enum<EnterKeyAction> {
    public static final EnterKeyAction NEWLINE = null;
    public static final EnterKeyAction SEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnterKeyAction[] f311784a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f311785b = null;
    private final int value;

    public static EnumEntries<EnterKeyAction> getEntries() {
        return f311785b;
    }

    static {
        EnterKeyAction r100 = new EnterKeyAction("SEND", 0, 1);
        SEND = r100;
        EnterKeyAction r101 = new EnterKeyAction("NEWLINE", 1, 2);
        NEWLINE = r101;
        EnterKeyAction[] r102 = {r100, r101};
        f311784a = r102;
        f311785b = EnumEntriesKt.enumEntries(r102);
    }

    public static EnterKeyAction[] values() {
        return (EnterKeyAction[]) f311784a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EnterKeyAction valueOf(String r100) {
        return (EnterKeyAction) a.a(EnterKeyAction.class, r100);
    }

    public EnterKeyAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
