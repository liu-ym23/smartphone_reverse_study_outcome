package com.bytedance.ee.bear.list.constants;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/list/constants/AscOrder;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DESC", "ASC", "Companion", "contentmanager-list-export-min_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AscOrder extends Enum<AscOrder> {
    public static final AscOrder ASC = null;
    public static final a Companion = null;
    public static final AscOrder DESC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AscOrder[] f227689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f227690b = null;
    private final int value;

    public static EnumEntries<AscOrder> getEntries() {
        return f227690b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.list.constants.AscOrder$a] */
    static {
        AscOrder r100 = new AscOrder("DESC", 0, 0);
        DESC = r100;
        AscOrder r101 = new AscOrder("ASC", 1, 1);
        ASC = r101;
        AscOrder[] r102 = {r100, r101};
        f227689a = r102;
        f227690b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static AscOrder[] values() {
        return (AscOrder[]) f227689a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AscOrder valueOf(String r100) {
        return (AscOrder) r27.a.a(AscOrder.class, r100);
    }

    public AscOrder(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
