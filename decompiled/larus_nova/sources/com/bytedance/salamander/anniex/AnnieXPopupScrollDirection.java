package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXPopupScrollDirection;", "", "", "value", "I", "getValue", "()I", "Unknown", "Up", "Down", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXPopupScrollDirection extends Enum<AnnieXPopupScrollDirection> {
    public static final AnnieXPopupScrollDirection Down = null;
    public static final AnnieXPopupScrollDirection Unknown = null;
    public static final AnnieXPopupScrollDirection Up = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXPopupScrollDirection[] f267839a = null;
    private final int value;

    public static AnnieXPopupScrollDirection valueOf(String r100) {
        return (AnnieXPopupScrollDirection) r27.a.a(AnnieXPopupScrollDirection.class, r100);
    }

    public static AnnieXPopupScrollDirection[] values() {
        return (AnnieXPopupScrollDirection[]) f267839a.clone();
    }

    static {
        AnnieXPopupScrollDirection r100 = new AnnieXPopupScrollDirection("Unknown", 0, 0);
        Unknown = r100;
        AnnieXPopupScrollDirection r101 = new AnnieXPopupScrollDirection("Up", 1, 1);
        Up = r101;
        AnnieXPopupScrollDirection r102 = new AnnieXPopupScrollDirection("Down", 2, 2);
        Down = r102;
        f267839a = new AnnieXPopupScrollDirection[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public AnnieXPopupScrollDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
