package com.larus.bmhome.chat.layout.holder.answeraction;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/answeraction/RegenInstructionEnum;", "", "type", "", "instruction", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getInstruction", "()Ljava/lang/String;", "REGEN_DEFAULT", "REGEN_SHORTER", "REGEN_LONGER", "REGEN_MORE_CASUAL", "REGEN_DEEP_THINK", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RegenInstructionEnum extends Enum<RegenInstructionEnum> {
    public static final RegenInstructionEnum REGEN_DEEP_THINK = null;
    public static final RegenInstructionEnum REGEN_DEFAULT = null;
    public static final RegenInstructionEnum REGEN_LONGER = null;
    public static final RegenInstructionEnum REGEN_MORE_CASUAL = null;
    public static final RegenInstructionEnum REGEN_SHORTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RegenInstructionEnum[] f303493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303494b = null;
    private final String instruction;
    private final int type;

    public static EnumEntries<RegenInstructionEnum> getEntries() {
        return f303494b;
    }

    static {
        RegenInstructionEnum r100 = new RegenInstructionEnum("REGEN_DEFAULT", 0, 0, "default");
        REGEN_DEFAULT = r100;
        RegenInstructionEnum r101 = new RegenInstructionEnum("REGEN_SHORTER", 1, 1, "Shorter");
        REGEN_SHORTER = r101;
        RegenInstructionEnum r102 = new RegenInstructionEnum("REGEN_LONGER", 2, 2, "Longer");
        REGEN_LONGER = r102;
        RegenInstructionEnum r103 = new RegenInstructionEnum("REGEN_MORE_CASUAL", 3, 3, "More_casual");
        REGEN_MORE_CASUAL = r103;
        RegenInstructionEnum r104 = new RegenInstructionEnum("REGEN_DEEP_THINK", 4, 4, "DeepThink");
        REGEN_DEEP_THINK = r104;
        RegenInstructionEnum[] r105 = {r100, r101, r102, r103, r104};
        f303493a = r105;
        f303494b = EnumEntriesKt.enumEntries(r105);
    }

    public static RegenInstructionEnum[] values() {
        return (RegenInstructionEnum[]) f303493a.clone();
    }

    public final String getInstruction() {
        return this.instruction;
    }

    public final int getType() {
        return this.type;
    }

    public static RegenInstructionEnum valueOf(String r100) {
        return (RegenInstructionEnum) r27.a.a(RegenInstructionEnum.class, r100);
    }

    public RegenInstructionEnum(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.type = r102;
        this.instruction = r103;
    }
}
