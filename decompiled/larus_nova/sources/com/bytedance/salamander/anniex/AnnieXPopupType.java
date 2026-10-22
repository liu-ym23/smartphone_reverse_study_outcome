package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXPopupType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BOTTOM", "CENTER", "RIGHT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXPopupType extends Enum<AnnieXPopupType> {
    public static final AnnieXPopupType BOTTOM = null;
    public static final AnnieXPopupType CENTER = null;
    public static final AnnieXPopupType RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXPopupType[] f267842a = null;
    private final String value;

    public static AnnieXPopupType valueOf(String r100) {
        return (AnnieXPopupType) r27.a.a(AnnieXPopupType.class, r100);
    }

    public static AnnieXPopupType[] values() {
        return (AnnieXPopupType[]) f267842a.clone();
    }

    static {
        AnnieXPopupType r100 = new AnnieXPopupType("BOTTOM", 0, "bottom");
        BOTTOM = r100;
        AnnieXPopupType r101 = new AnnieXPopupType("CENTER", 1, "center");
        CENTER = r101;
        AnnieXPopupType r102 = new AnnieXPopupType("RIGHT", 2, "right");
        RIGHT = r102;
        f267842a = new AnnieXPopupType[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public AnnieXPopupType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
