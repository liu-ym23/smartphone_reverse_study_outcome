package com.bytedance.ee.bear.bitable.uikit.drag;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/drag/DragAreaState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "PARENT_SELECTED", "ERROR", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DragAreaState extends Enum<DragAreaState> {
    public static final DragAreaState ERROR = null;
    public static final DragAreaState NONE = null;
    public static final DragAreaState PARENT_SELECTED = null;
    public static final /* synthetic */ DragAreaState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<DragAreaState> getEntries() {
        return b;
    }

    static {
        DragAreaState r0 = new DragAreaState("NONE", 0, 0);
        NONE = r0;
        DragAreaState r1 = new DragAreaState("PARENT_SELECTED", 1, 1);
        PARENT_SELECTED = r1;
        DragAreaState r3 = new DragAreaState("ERROR", 2, 2);
        ERROR = r3;
        DragAreaState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DragAreaState[] values() {
        return (DragAreaState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DragAreaState valueOf(String r1) {
        return (DragAreaState) a.a(DragAreaState.class, r1);
    }

    public DragAreaState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
