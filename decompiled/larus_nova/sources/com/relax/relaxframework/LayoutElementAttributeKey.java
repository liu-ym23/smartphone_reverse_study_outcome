package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/relax/relaxframework/LayoutElementAttributeKey;", "", "", "value", "I", "getValue", "()I", "FlexDirection", "FlexWrap", "AlignItems", "AlignContent", "JustifyContent", "LinearOrientation", "LinearCrossGravity", "LinearGravity", "LinearWeightSum", "GridTemplateColumns", "GridTemplateRows", "GridAutoColumns", "GridAutoRows", "GridColumnGap", "GridRowGap", "JustifyItems", "GridAutoFlow", "ColumnGap", "RowGap", "Reverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LayoutElementAttributeKey extends Enum<LayoutElementAttributeKey> {
    public static final LayoutElementAttributeKey AlignContent = null;
    public static final LayoutElementAttributeKey AlignItems = null;
    public static final LayoutElementAttributeKey ColumnGap = null;
    public static final LayoutElementAttributeKey FlexDirection = null;
    public static final LayoutElementAttributeKey FlexWrap = null;
    public static final LayoutElementAttributeKey GridAutoColumns = null;
    public static final LayoutElementAttributeKey GridAutoFlow = null;
    public static final LayoutElementAttributeKey GridAutoRows = null;
    public static final LayoutElementAttributeKey GridColumnGap = null;
    public static final LayoutElementAttributeKey GridRowGap = null;
    public static final LayoutElementAttributeKey GridTemplateColumns = null;
    public static final LayoutElementAttributeKey GridTemplateRows = null;
    public static final LayoutElementAttributeKey JustifyContent = null;
    public static final LayoutElementAttributeKey JustifyItems = null;
    public static final LayoutElementAttributeKey LinearCrossGravity = null;
    public static final LayoutElementAttributeKey LinearGravity = null;
    public static final LayoutElementAttributeKey LinearOrientation = null;
    public static final LayoutElementAttributeKey LinearWeightSum = null;
    public static final LayoutElementAttributeKey Reverse = null;
    public static final LayoutElementAttributeKey RowGap = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutElementAttributeKey[] f404755a = null;
    private final int value;

    public static LayoutElementAttributeKey valueOf(String r100) {
        return (LayoutElementAttributeKey) r27.a.a(LayoutElementAttributeKey.class, r100);
    }

    public static LayoutElementAttributeKey[] values() {
        return (LayoutElementAttributeKey[]) f404755a.clone();
    }

    static {
        LayoutElementAttributeKey r100 = new LayoutElementAttributeKey("FlexDirection", 0, 20234);
        FlexDirection = r100;
        LayoutElementAttributeKey r101 = new LayoutElementAttributeKey("FlexWrap", 1, 20235);
        FlexWrap = r101;
        LayoutElementAttributeKey r102 = new LayoutElementAttributeKey("AlignItems", 2, 20236);
        AlignItems = r102;
        LayoutElementAttributeKey r103 = new LayoutElementAttributeKey("AlignContent", 3, 20237);
        AlignContent = r103;
        LayoutElementAttributeKey r104 = new LayoutElementAttributeKey("JustifyContent", 4, 20238);
        JustifyContent = r104;
        LayoutElementAttributeKey r105 = new LayoutElementAttributeKey("LinearOrientation", 5, 20239);
        LinearOrientation = r105;
        LayoutElementAttributeKey r110 = new LayoutElementAttributeKey("LinearCrossGravity", 6, 20240);
        LinearCrossGravity = r110;
        LayoutElementAttributeKey r111 = new LayoutElementAttributeKey("LinearGravity", 7, 20241);
        LinearGravity = r111;
        LayoutElementAttributeKey r112 = new LayoutElementAttributeKey("LinearWeightSum", 8, 20242);
        LinearWeightSum = r112;
        LayoutElementAttributeKey r113 = new LayoutElementAttributeKey("GridTemplateColumns", 9, 20245);
        GridTemplateColumns = r113;
        LayoutElementAttributeKey r114 = new LayoutElementAttributeKey("GridTemplateRows", 10, 20246);
        GridTemplateRows = r114;
        LayoutElementAttributeKey r106 = new LayoutElementAttributeKey("GridAutoColumns", 11, 20247);
        GridAutoColumns = r106;
        LayoutElementAttributeKey r107 = new LayoutElementAttributeKey("GridAutoRows", 12, 20248);
        GridAutoRows = r107;
        LayoutElementAttributeKey r108 = new LayoutElementAttributeKey("GridColumnGap", 13, 20249);
        GridColumnGap = r108;
        LayoutElementAttributeKey r109 = new LayoutElementAttributeKey("GridRowGap", 14, 20250);
        GridRowGap = r109;
        LayoutElementAttributeKey r115 = new LayoutElementAttributeKey("JustifyItems", 15, 20251);
        JustifyItems = r115;
        LayoutElementAttributeKey r116 = new LayoutElementAttributeKey("GridAutoFlow", 16, 20252);
        GridAutoFlow = r116;
        LayoutElementAttributeKey r117 = new LayoutElementAttributeKey("ColumnGap", 17, 20253);
        ColumnGap = r117;
        LayoutElementAttributeKey r118 = new LayoutElementAttributeKey("RowGap", 18, 20254);
        RowGap = r118;
        LayoutElementAttributeKey r119 = new LayoutElementAttributeKey("Reverse", 19, 20255);
        Reverse = r119;
        f404755a = new LayoutElementAttributeKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119};
    }

    public final int getValue() {
        return this.value;
    }

    public LayoutElementAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
