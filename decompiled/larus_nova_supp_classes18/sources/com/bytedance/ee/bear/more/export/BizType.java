package com.bytedance.ee.bear.more.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/more/export/BizType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "Space", "Wiki", "Unknown", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BizType extends Enum<BizType> {
    public static final BizType Space = null;
    public static final BizType Unknown = null;
    public static final BizType Wiki = null;
    public static final /* synthetic */ BizType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int value;

    public static EnumEntries<BizType> getEntries() {
        return b;
    }

    static {
        BizType r0 = new BizType("Space", 0, 1);
        Space = r0;
        BizType r1 = new BizType("Wiki", 1, 2);
        Wiki = r1;
        BizType r4 = new BizType("Unknown", 2, -1);
        Unknown = r4;
        BizType[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static BizType[] values() {
        return (BizType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BizType valueOf(String r1) {
        return (BizType) a.a(BizType.class, r1);
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public BizType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
