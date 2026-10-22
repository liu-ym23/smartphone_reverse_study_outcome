package com.larus.platform.model.action;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/action/InstructionRedirectType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SendMessage", "EnterIndependentPage", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InstructionRedirectType extends Enum<InstructionRedirectType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ InstructionRedirectType[] $VALUES = null;
    public static final InstructionRedirectType EnterIndependentPage = null;
    public static final InstructionRedirectType SendMessage = null;
    private final int value;

    private static final /* synthetic */ InstructionRedirectType[] $values() {
        return new InstructionRedirectType[]{SendMessage, EnterIndependentPage};
    }

    public static EnumEntries<InstructionRedirectType> getEntries() {
        return $ENTRIES;
    }

    static {
        SendMessage = new InstructionRedirectType("SendMessage", 0, 1);
        EnterIndependentPage = new InstructionRedirectType("EnterIndependentPage", 1, 2);
        InstructionRedirectType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static InstructionRedirectType[] values() {
        return (InstructionRedirectType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static InstructionRedirectType valueOf(String r100) {
        return (InstructionRedirectType) r27.a.a(InstructionRedirectType.class, r100);
    }

    private InstructionRedirectType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
