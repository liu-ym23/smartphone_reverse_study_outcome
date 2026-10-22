package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/ViewType;", "", "", "value", "I", "getValue", "()I", "Page", "Popup", "Card", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ViewType extends Enum<ViewType> {
    public static final ViewType Card = null;
    public static final ViewType Page = null;
    public static final ViewType Popup = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewType[] f267928a = null;
    private final int value;

    public static ViewType valueOf(String r100) {
        return (ViewType) r27.a.a(ViewType.class, r100);
    }

    public static ViewType[] values() {
        return (ViewType[]) f267928a.clone();
    }

    static {
        ViewType r100 = new ViewType("Page", 0, 0);
        Page = r100;
        ViewType r101 = new ViewType("Popup", 1, 1);
        Popup = r101;
        ViewType r102 = new ViewType("Card", 2, 2);
        Card = r102;
        f267928a = new ViewType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ViewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
