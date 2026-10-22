package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXPopupScrollHeight;", "", "", "value", "I", "getValue", "()I", "initialHeight", "fullScreenHeight", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXPopupScrollHeight extends Enum<AnnieXPopupScrollHeight> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXPopupScrollHeight[] f267840a = null;
    public static final AnnieXPopupScrollHeight fullScreenHeight = null;
    public static final AnnieXPopupScrollHeight initialHeight = null;
    private final int value;

    public static AnnieXPopupScrollHeight valueOf(String r100) {
        return (AnnieXPopupScrollHeight) r27.a.a(AnnieXPopupScrollHeight.class, r100);
    }

    public static AnnieXPopupScrollHeight[] values() {
        return (AnnieXPopupScrollHeight[]) f267840a.clone();
    }

    static {
        AnnieXPopupScrollHeight r100 = new AnnieXPopupScrollHeight("initialHeight", 0, 0);
        initialHeight = r100;
        AnnieXPopupScrollHeight r101 = new AnnieXPopupScrollHeight("fullScreenHeight", 1, 1);
        fullScreenHeight = r101;
        f267840a = new AnnieXPopupScrollHeight[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public AnnieXPopupScrollHeight(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
