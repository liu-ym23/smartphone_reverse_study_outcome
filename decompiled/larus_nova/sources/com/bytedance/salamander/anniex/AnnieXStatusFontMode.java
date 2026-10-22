package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXStatusFontMode;", "", "", "value", "I", "getValue", "()I", "LIGHT", "DARK", "DEFAULT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXStatusFontMode extends Enum<AnnieXStatusFontMode> {
    public static final AnnieXStatusFontMode DARK = null;
    public static final AnnieXStatusFontMode DEFAULT = null;
    public static final AnnieXStatusFontMode LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXStatusFontMode[] f267862a = null;
    private final int value;

    public static AnnieXStatusFontMode valueOf(String r100) {
        return (AnnieXStatusFontMode) r27.a.a(AnnieXStatusFontMode.class, r100);
    }

    public static AnnieXStatusFontMode[] values() {
        return (AnnieXStatusFontMode[]) f267862a.clone();
    }

    static {
        AnnieXStatusFontMode r100 = new AnnieXStatusFontMode("LIGHT", 0, 0);
        LIGHT = r100;
        AnnieXStatusFontMode r101 = new AnnieXStatusFontMode("DARK", 1, 1);
        DARK = r101;
        AnnieXStatusFontMode r102 = new AnnieXStatusFontMode("DEFAULT", 2, 2);
        DEFAULT = r102;
        f267862a = new AnnieXStatusFontMode[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public AnnieXStatusFontMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
