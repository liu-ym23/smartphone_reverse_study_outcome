package com.obric.assistant.special_input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/special_input/ObricComplexTaskPanelType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IDLE", "CLARIFYING", "ADDITION", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricComplexTaskPanelType extends Enum<ObricComplexTaskPanelType> {
    public static final ObricComplexTaskPanelType ADDITION = null;
    public static final ObricComplexTaskPanelType CLARIFYING = null;
    public static final ObricComplexTaskPanelType IDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricComplexTaskPanelType[] f392553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392554b = null;
    private final int value;

    public static EnumEntries<ObricComplexTaskPanelType> getEntries() {
        return f392554b;
    }

    static {
        ObricComplexTaskPanelType r100 = new ObricComplexTaskPanelType("IDLE", 0, 0);
        IDLE = r100;
        ObricComplexTaskPanelType r101 = new ObricComplexTaskPanelType("CLARIFYING", 1, 1);
        CLARIFYING = r101;
        ObricComplexTaskPanelType r102 = new ObricComplexTaskPanelType("ADDITION", 2, 2);
        ADDITION = r102;
        ObricComplexTaskPanelType[] r103 = {r100, r101, r102};
        f392553a = r103;
        f392554b = EnumEntriesKt.enumEntries(r103);
    }

    public static ObricComplexTaskPanelType[] values() {
        return (ObricComplexTaskPanelType[]) f392553a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricComplexTaskPanelType valueOf(String r100) {
        return (ObricComplexTaskPanelType) r27.a.a(ObricComplexTaskPanelType.class, r100);
    }

    public ObricComplexTaskPanelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
