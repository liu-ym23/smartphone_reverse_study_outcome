package com.larus.bmhome.instruction.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/ActiveSwitchType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DEEPTHINK", "NETSEARCH", "VOICEINPUT", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActiveSwitchType extends Enum<ActiveSwitchType> {
    public static final ActiveSwitchType DEEPTHINK = null;
    public static final ActiveSwitchType NETSEARCH = null;
    public static final ActiveSwitchType UNKNOWN = null;
    public static final ActiveSwitchType VOICEINPUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActiveSwitchType[] f312053a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312054b = null;
    private final int value;

    public static EnumEntries<ActiveSwitchType> getEntries() {
        return f312054b;
    }

    static {
        ActiveSwitchType r100 = new ActiveSwitchType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ActiveSwitchType r101 = new ActiveSwitchType("DEEPTHINK", 1, 1);
        DEEPTHINK = r101;
        ActiveSwitchType r102 = new ActiveSwitchType("NETSEARCH", 2, 2);
        NETSEARCH = r102;
        ActiveSwitchType r103 = new ActiveSwitchType("VOICEINPUT", 3, 4);
        VOICEINPUT = r103;
        ActiveSwitchType[] r104 = {r100, r101, r102, r103};
        f312053a = r104;
        f312054b = EnumEntriesKt.enumEntries(r104);
    }

    public static ActiveSwitchType[] values() {
        return (ActiveSwitchType[]) f312053a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActiveSwitchType valueOf(String r100) {
        return (ActiveSwitchType) a.a(ActiveSwitchType.class, r100);
    }

    public ActiveSwitchType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
