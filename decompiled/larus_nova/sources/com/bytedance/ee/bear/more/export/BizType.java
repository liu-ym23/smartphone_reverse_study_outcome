package com.bytedance.ee.bear.more.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/more/export/BizType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "Space", "Wiki", "Unknown", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BizType extends Enum<BizType> {
    public static final BizType Space = null;
    public static final BizType Unknown = null;
    public static final BizType Wiki = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BizType[] f234502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f234503b = null;
    private int value;

    public static EnumEntries<BizType> getEntries() {
        return f234503b;
    }

    static {
        BizType r100 = new BizType("Space", 0, 1);
        Space = r100;
        BizType r101 = new BizType("Wiki", 1, 2);
        Wiki = r101;
        BizType r102 = new BizType("Unknown", 2, -1);
        Unknown = r102;
        BizType[] r103 = {r100, r101, r102};
        f234502a = r103;
        f234503b = EnumEntriesKt.enumEntries(r103);
    }

    public static BizType[] values() {
        return (BizType[]) f234502a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BizType valueOf(String r100) {
        return (BizType) a.a(BizType.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public BizType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
