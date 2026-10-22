package com.ss.android.lark.biz.im.api.extension.cell;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/cell/PinCellUIType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PIN_CELL_CONTENT", "PIN_CELL_CUSTOMIZE", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PinCellUIType extends Enum<PinCellUIType> {
    public static final PinCellUIType PIN_CELL_CONTENT = null;
    public static final PinCellUIType PIN_CELL_CUSTOMIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PinCellUIType[] f410079a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410080b = null;
    private final int value;

    public static EnumEntries<PinCellUIType> getEntries() {
        return f410080b;
    }

    static {
        PinCellUIType r100 = new PinCellUIType("PIN_CELL_CONTENT", 0, 0);
        PIN_CELL_CONTENT = r100;
        PinCellUIType r101 = new PinCellUIType("PIN_CELL_CUSTOMIZE", 1, 1);
        PIN_CELL_CUSTOMIZE = r101;
        PinCellUIType[] r102 = {r100, r101};
        f410079a = r102;
        f410080b = EnumEntriesKt.enumEntries(r102);
    }

    public static PinCellUIType[] values() {
        return (PinCellUIType[]) f410079a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PinCellUIType valueOf(String r100) {
        return (PinCellUIType) a.a(PinCellUIType.class, r100);
    }

    public PinCellUIType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
