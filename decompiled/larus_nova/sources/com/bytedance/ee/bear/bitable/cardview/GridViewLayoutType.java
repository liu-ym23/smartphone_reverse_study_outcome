package com.bytedance.ee.bear.bitable.cardview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/cardview/GridViewLayoutType;", "", "value", "", "tag", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getTag", "()Ljava/lang/String;", "GridViewLayout", "CardViewLayout", "UndefineViewLayout", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GridViewLayoutType extends Enum<GridViewLayoutType> {
    public static final GridViewLayoutType CardViewLayout = null;
    public static final a Companion = null;
    public static final GridViewLayoutType GridViewLayout = null;
    public static final GridViewLayoutType UndefineViewLayout = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GridViewLayoutType[] f209203a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209204b = null;
    private final String tag;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<GridViewLayoutType> getEntries() {
        return f209204b;
    }

    static {
        GridViewLayoutType r100 = new GridViewLayoutType("GridViewLayout", 0, 1, "mobile_grid_layout");
        GridViewLayout = r100;
        GridViewLayoutType r101 = new GridViewLayoutType("CardViewLayout", 1, 2, "mobile_card_layout");
        CardViewLayout = r101;
        GridViewLayoutType r102 = new GridViewLayoutType("UndefineViewLayout", 2, -1, "");
        UndefineViewLayout = r102;
        GridViewLayoutType[] r103 = {r100, r101, r102};
        f209203a = r103;
        f209204b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static GridViewLayoutType[] values() {
        return (GridViewLayoutType[]) f209203a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public final int getValue() {
        return this.value;
    }

    public static GridViewLayoutType valueOf(String r100) {
        return (GridViewLayoutType) r27.a.a(GridViewLayoutType.class, r100);
    }

    public GridViewLayoutType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.tag = r103;
    }
}
