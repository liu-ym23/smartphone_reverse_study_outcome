package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/ListItemAttributeKey;", "", "", "value", "I", "getValue", "()I", "ItemKey", "ReuseIdentifier", "StickyTop", "StickyBottom", "FullSpan", "EstimatedMainAxisSizePx", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ListItemAttributeKey extends Enum<ListItemAttributeKey> {
    public static final ListItemAttributeKey EstimatedMainAxisSizePx = null;
    public static final ListItemAttributeKey FullSpan = null;
    public static final ListItemAttributeKey ItemKey = null;
    public static final ListItemAttributeKey ReuseIdentifier = null;
    public static final ListItemAttributeKey StickyBottom = null;
    public static final ListItemAttributeKey StickyTop = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListItemAttributeKey[] f404771a = null;
    private final int value;

    public static ListItemAttributeKey valueOf(String r100) {
        return (ListItemAttributeKey) r27.a.a(ListItemAttributeKey.class, r100);
    }

    public static ListItemAttributeKey[] values() {
        return (ListItemAttributeKey[]) f404771a.clone();
    }

    static {
        ListItemAttributeKey r100 = new ListItemAttributeKey("ItemKey", 0, 20106);
        ItemKey = r100;
        ListItemAttributeKey r101 = new ListItemAttributeKey("ReuseIdentifier", 1, 20335);
        ReuseIdentifier = r101;
        ListItemAttributeKey r102 = new ListItemAttributeKey("StickyTop", 2, 20336);
        StickyTop = r102;
        ListItemAttributeKey r103 = new ListItemAttributeKey("StickyBottom", 3, 20337);
        StickyBottom = r103;
        ListItemAttributeKey r104 = new ListItemAttributeKey("FullSpan", 4, 20338);
        FullSpan = r104;
        ListItemAttributeKey r105 = new ListItemAttributeKey("EstimatedMainAxisSizePx", 5, 20339);
        EstimatedMainAxisSizePx = r105;
        f404771a = new ListItemAttributeKey[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public ListItemAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
