package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/relax/relaxframework/ListAttributeKey;", "", "", "value", "I", "getValue", "()I", "ListType", "SpanCount", "EnableScroll", "ScrollOrientation", "Sticky", "StickyOffset", "InitialScrollIndex", "NeedVisibleItemInfo", "LowerThresholdItemCount", "UpperThresholdItemCount", "ScrollEventThrottle", "EnableNestedScroll", "NeedLayoutCompleteInfo", "LayoutId", "ItemSnap", "EnableFadeInAnimation", "UpdateAnimationFadeInDuration", "PreloadBufferCount", "ExperimentalMaxFlingDistanceRatio", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ListAttributeKey extends Enum<ListAttributeKey> {
    public static final ListAttributeKey EnableFadeInAnimation = null;
    public static final ListAttributeKey EnableNestedScroll = null;
    public static final ListAttributeKey EnableScroll = null;
    public static final ListAttributeKey ExperimentalMaxFlingDistanceRatio = null;
    public static final ListAttributeKey InitialScrollIndex = null;
    public static final ListAttributeKey ItemSnap = null;
    public static final ListAttributeKey LayoutId = null;
    public static final ListAttributeKey ListType = null;
    public static final ListAttributeKey LowerThresholdItemCount = null;
    public static final ListAttributeKey NeedLayoutCompleteInfo = null;
    public static final ListAttributeKey NeedVisibleItemInfo = null;
    public static final ListAttributeKey PreloadBufferCount = null;
    public static final ListAttributeKey ScrollEventThrottle = null;
    public static final ListAttributeKey ScrollOrientation = null;
    public static final ListAttributeKey SpanCount = null;
    public static final ListAttributeKey Sticky = null;
    public static final ListAttributeKey StickyOffset = null;
    public static final ListAttributeKey UpdateAnimationFadeInDuration = null;
    public static final ListAttributeKey UpperThresholdItemCount = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListAttributeKey[] f404768a = null;
    private final int value;

    public static ListAttributeKey valueOf(String r100) {
        return (ListAttributeKey) r27.a.a(ListAttributeKey.class, r100);
    }

    public static ListAttributeKey[] values() {
        return (ListAttributeKey[]) f404768a.clone();
    }

    static {
        ListAttributeKey r100 = new ListAttributeKey("ListType", 0, 20093);
        ListType = r100;
        ListAttributeKey r101 = new ListAttributeKey("SpanCount", 1, 20322);
        SpanCount = r101;
        ListAttributeKey r102 = new ListAttributeKey("EnableScroll", 2, 20066);
        EnableScroll = r102;
        ListAttributeKey r103 = new ListAttributeKey("ScrollOrientation", 3, 20102);
        ScrollOrientation = r103;
        ListAttributeKey r104 = new ListAttributeKey("Sticky", 4, 20099);
        Sticky = r104;
        ListAttributeKey r105 = new ListAttributeKey("StickyOffset", 5, 20324);
        StickyOffset = r105;
        ListAttributeKey r110 = new ListAttributeKey("InitialScrollIndex", 6, 20325);
        InitialScrollIndex = r110;
        ListAttributeKey r111 = new ListAttributeKey("NeedVisibleItemInfo", 7, 20326);
        NeedVisibleItemInfo = r111;
        ListAttributeKey r112 = new ListAttributeKey("LowerThresholdItemCount", 8, 20090);
        LowerThresholdItemCount = r112;
        ListAttributeKey r113 = new ListAttributeKey("UpperThresholdItemCount", 9, 20091);
        UpperThresholdItemCount = r113;
        ListAttributeKey r114 = new ListAttributeKey("ScrollEventThrottle", 10, 20092);
        ScrollEventThrottle = r114;
        ListAttributeKey r106 = new ListAttributeKey("EnableNestedScroll", 11, 20067);
        EnableNestedScroll = r106;
        ListAttributeKey r107 = new ListAttributeKey("NeedLayoutCompleteInfo", 12, 20327);
        NeedLayoutCompleteInfo = r107;
        ListAttributeKey r108 = new ListAttributeKey("LayoutId", 13, 20328);
        LayoutId = r108;
        ListAttributeKey r109 = new ListAttributeKey("ItemSnap", 14, 20329);
        ItemSnap = r109;
        ListAttributeKey r115 = new ListAttributeKey("EnableFadeInAnimation", 15, 20330);
        EnableFadeInAnimation = r115;
        ListAttributeKey r116 = new ListAttributeKey("UpdateAnimationFadeInDuration", 16, 20331);
        UpdateAnimationFadeInDuration = r116;
        ListAttributeKey r117 = new ListAttributeKey("PreloadBufferCount", 17, 20332);
        PreloadBufferCount = r117;
        ListAttributeKey r118 = new ListAttributeKey("ExperimentalMaxFlingDistanceRatio", 18, 20333);
        ExperimentalMaxFlingDistanceRatio = r118;
        f404768a = new ListAttributeKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118};
    }

    public final int getValue() {
        return this.value;
    }

    public ListAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
