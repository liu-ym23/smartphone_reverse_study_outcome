package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/ScreenFoldType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Horizontal", "Vertical", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ScreenFoldType extends Enum<ScreenFoldType> {
    public static final ScreenFoldType Horizontal = null;
    public static final ScreenFoldType Vertical = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScreenFoldType[] f267920a = null;
    private final String value;

    public static ScreenFoldType valueOf(String r100) {
        return (ScreenFoldType) r27.a.a(ScreenFoldType.class, r100);
    }

    public static ScreenFoldType[] values() {
        return (ScreenFoldType[]) f267920a.clone();
    }

    static {
        ScreenFoldType r100 = new ScreenFoldType("Horizontal", 0, "horizontal");
        Horizontal = r100;
        ScreenFoldType r101 = new ScreenFoldType("Vertical", 1, "vertical");
        Vertical = r101;
        f267920a = new ScreenFoldType[]{r100, r101};
    }

    public final String getValue() {
        return this.value;
    }

    public ScreenFoldType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
