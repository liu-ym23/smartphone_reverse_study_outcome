package com.larus.bmhome.chat.list.cell.text.components.bottom.riskwarning;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/components/bottom/riskwarning/TipsBlockType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TIPS_BLOCK_TYPE_UNKNOWN", "TIPS_BLOCK_TYPE_TEXT", "TIPS_BLOCK_TYPE_URL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TipsBlockType extends Enum<TipsBlockType> {
    public static final TipsBlockType TIPS_BLOCK_TYPE_TEXT = null;
    public static final TipsBlockType TIPS_BLOCK_TYPE_UNKNOWN = null;
    public static final TipsBlockType TIPS_BLOCK_TYPE_URL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TipsBlockType[] f306237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f306238b = null;
    private final int value;

    public static EnumEntries<TipsBlockType> getEntries() {
        return f306238b;
    }

    static {
        TipsBlockType r100 = new TipsBlockType("TIPS_BLOCK_TYPE_UNKNOWN", 0, 0);
        TIPS_BLOCK_TYPE_UNKNOWN = r100;
        TipsBlockType r101 = new TipsBlockType("TIPS_BLOCK_TYPE_TEXT", 1, 1);
        TIPS_BLOCK_TYPE_TEXT = r101;
        TipsBlockType r102 = new TipsBlockType("TIPS_BLOCK_TYPE_URL", 2, 2);
        TIPS_BLOCK_TYPE_URL = r102;
        TipsBlockType[] r103 = {r100, r101, r102};
        f306237a = r103;
        f306238b = EnumEntriesKt.enumEntries(r103);
    }

    public static TipsBlockType[] values() {
        return (TipsBlockType[]) f306237a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TipsBlockType valueOf(String r100) {
        return (TipsBlockType) a.a(TipsBlockType.class, r100);
    }

    public TipsBlockType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
