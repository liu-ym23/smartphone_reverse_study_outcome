package com.bytedance.ee.bear.bitable.baseadd.transformer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/transformer/ViewType;", "", "viewType", "", "<init>", "(Ljava/lang/String;II)V", "getViewType", "()I", "GRID", "KAN_BAN", "GALLERY", "GANTT", "CALENDAR", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ViewType extends Enum<ViewType> {
    public static final ViewType CALENDAR = null;
    public static final ViewType GALLERY = null;
    public static final ViewType GANTT = null;
    public static final ViewType GRID = null;
    public static final ViewType KAN_BAN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewType[] f207001a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207002b = null;
    private final int viewType;

    public static EnumEntries<ViewType> getEntries() {
        return f207002b;
    }

    static {
        ViewType r100 = new ViewType("GRID", 0, 1);
        GRID = r100;
        ViewType r101 = new ViewType("KAN_BAN", 1, 2);
        KAN_BAN = r101;
        ViewType r102 = new ViewType("GALLERY", 2, 4);
        GALLERY = r102;
        ViewType r103 = new ViewType("GANTT", 3, 5);
        GANTT = r103;
        ViewType r104 = new ViewType("CALENDAR", 4, 7);
        CALENDAR = r104;
        ViewType[] r110 = {r100, r101, r102, r103, r104};
        f207001a = r110;
        f207002b = EnumEntriesKt.enumEntries(r110);
    }

    public static ViewType[] values() {
        return (ViewType[]) f207001a.clone();
    }

    public final int getViewType() {
        return this.viewType;
    }

    public static ViewType valueOf(String r100) {
        return (ViewType) a.a(ViewType.class, r100);
    }

    public ViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.viewType = r102;
    }
}
