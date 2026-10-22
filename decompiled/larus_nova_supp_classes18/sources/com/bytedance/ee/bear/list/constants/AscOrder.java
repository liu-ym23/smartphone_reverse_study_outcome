package com.bytedance.ee.bear.list.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/list/constants/AscOrder;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DESC", "ASC", "Companion", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AscOrder extends Enum<AscOrder> {
    public static final AscOrder ASC = null;
    public static final a Companion = null;
    public static final AscOrder DESC = null;
    public static final /* synthetic */ AscOrder[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<AscOrder> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.list.constants.AscOrder$a] */
    static {
        AscOrder r0 = new AscOrder("DESC", 0, 0);
        DESC = r0;
        AscOrder r1 = new AscOrder("ASC", 1, 1);
        ASC = r1;
        AscOrder[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static AscOrder[] values() {
        return (AscOrder[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AscOrder valueOf(String r1) {
        return (AscOrder) r27.a.a(AscOrder.class, r1);
    }

    public AscOrder(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
