package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/ViewPagerAttributeKey;", "", "", "value", "I", "getValue", "()I", "SelectIndex", "AllowHorizontalGesture", "PageChangeAnimation", "KeepItemView", "IosGestureOffset", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ViewPagerAttributeKey extends Enum<ViewPagerAttributeKey> {
    public static final ViewPagerAttributeKey AllowHorizontalGesture = null;
    public static final ViewPagerAttributeKey IosGestureOffset = null;
    public static final ViewPagerAttributeKey KeepItemView = null;
    public static final ViewPagerAttributeKey PageChangeAnimation = null;
    public static final ViewPagerAttributeKey SelectIndex = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewPagerAttributeKey[] f404989a = null;
    private final int value;

    public static ViewPagerAttributeKey valueOf(String r100) {
        return (ViewPagerAttributeKey) r27.a.a(ViewPagerAttributeKey.class, r100);
    }

    public static ViewPagerAttributeKey[] values() {
        return (ViewPagerAttributeKey[]) f404989a.clone();
    }

    static {
        ViewPagerAttributeKey r100 = new ViewPagerAttributeKey("SelectIndex", 0, 20182);
        SelectIndex = r100;
        ViewPagerAttributeKey r101 = new ViewPagerAttributeKey("AllowHorizontalGesture", 1, 20183);
        AllowHorizontalGesture = r101;
        ViewPagerAttributeKey r102 = new ViewPagerAttributeKey("PageChangeAnimation", 2, 20184);
        PageChangeAnimation = r102;
        ViewPagerAttributeKey r103 = new ViewPagerAttributeKey("KeepItemView", 3, 20185);
        KeepItemView = r103;
        ViewPagerAttributeKey r104 = new ViewPagerAttributeKey("IosGestureOffset", 4, 20317);
        IosGestureOffset = r104;
        f404989a = new ViewPagerAttributeKey[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public ViewPagerAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
