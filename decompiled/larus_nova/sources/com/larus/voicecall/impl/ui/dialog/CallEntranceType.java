package com.larus.voicecall.impl.ui.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voicecall/impl/ui/dialog/CallEntranceType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "VIDEO", "CALL", "SHARE_SCREEN", "CALL_SCENE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallEntranceType extends Enum<CallEntranceType> {
    public static final CallEntranceType CALL = null;
    public static final CallEntranceType CALL_SCENE = null;
    public static final CallEntranceType SHARE_SCREEN = null;
    public static final CallEntranceType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CallEntranceType[] f379371a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f379372b = null;
    private final int type;

    public static EnumEntries<CallEntranceType> getEntries() {
        return f379372b;
    }

    static {
        CallEntranceType r100 = new CallEntranceType("VIDEO", 0, 1);
        VIDEO = r100;
        CallEntranceType r101 = new CallEntranceType("CALL", 1, 2);
        CALL = r101;
        CallEntranceType r102 = new CallEntranceType("SHARE_SCREEN", 2, 3);
        SHARE_SCREEN = r102;
        CallEntranceType r103 = new CallEntranceType("CALL_SCENE", 3, 4);
        CALL_SCENE = r103;
        CallEntranceType[] r104 = {r100, r101, r102, r103};
        f379371a = r104;
        f379372b = EnumEntriesKt.enumEntries(r104);
    }

    public static CallEntranceType[] values() {
        return (CallEntranceType[]) f379371a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static CallEntranceType valueOf(String r100) {
        return (CallEntranceType) a.a(CallEntranceType.class, r100);
    }

    public CallEntranceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
