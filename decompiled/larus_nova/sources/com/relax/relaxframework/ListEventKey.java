package com.relax.relaxframework;

import com.byted.cast.mediacommon.MediaCaptureError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/ListEventKey;", "", "", "value", "I", "getValue", "()I", "Scroll", "ScrollToUpper", "ScrollToLower", "ScrollStateChange", "ListLayoutComplete", "StickyTop", "StickyBottom", "Snap", "ScrollToUpperEdge", "ScrollToLowerEdge", "ScrollToNormalState", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ListEventKey extends Enum<ListEventKey> {
    public static final ListEventKey ListLayoutComplete = null;
    public static final ListEventKey Scroll = null;
    public static final ListEventKey ScrollStateChange = null;
    public static final ListEventKey ScrollToLower = null;
    public static final ListEventKey ScrollToLowerEdge = null;
    public static final ListEventKey ScrollToNormalState = null;
    public static final ListEventKey ScrollToUpper = null;
    public static final ListEventKey ScrollToUpperEdge = null;
    public static final ListEventKey Snap = null;
    public static final ListEventKey StickyBottom = null;
    public static final ListEventKey StickyTop = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListEventKey[] f404769a = null;
    private final int value;

    public static ListEventKey valueOf(String r100) {
        return (ListEventKey) r27.a.a(ListEventKey.class, r100);
    }

    public static ListEventKey[] values() {
        return (ListEventKey[]) f404769a.clone();
    }

    static {
        ListEventKey r100 = new ListEventKey("Scroll", 0, 30005);
        Scroll = r100;
        ListEventKey r101 = new ListEventKey("ScrollToUpper", 1, MediaCaptureError.ERROR_CAST_CONNECTION_NOT_BUILT);
        ScrollToUpper = r101;
        ListEventKey r102 = new ListEventKey("ScrollToLower", 2, 30007);
        ScrollToLower = r102;
        ListEventKey r103 = new ListEventKey("ScrollStateChange", 3, 30012);
        ScrollStateChange = r103;
        ListEventKey r104 = new ListEventKey("ListLayoutComplete", 4, 30015);
        ListLayoutComplete = r104;
        ListEventKey r105 = new ListEventKey("StickyTop", 5, 30141);
        StickyTop = r105;
        ListEventKey r110 = new ListEventKey("StickyBottom", 6, 30142);
        StickyBottom = r110;
        ListEventKey r111 = new ListEventKey("Snap", 7, 30143);
        Snap = r111;
        ListEventKey r112 = new ListEventKey("ScrollToUpperEdge", 8, 30144);
        ScrollToUpperEdge = r112;
        ListEventKey r113 = new ListEventKey("ScrollToLowerEdge", 9, 30145);
        ScrollToLowerEdge = r113;
        ListEventKey r114 = new ListEventKey("ScrollToNormalState", 10, 30146);
        ScrollToNormalState = r114;
        f404769a = new ListEventKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public final int getValue() {
        return this.value;
    }

    public ListEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
