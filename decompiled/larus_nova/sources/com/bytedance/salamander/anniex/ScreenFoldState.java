package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/salamander/anniex/ScreenFoldState;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "FLAT", "HALF", "FOLDED", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ScreenFoldState extends Enum<ScreenFoldState> {
    public static final ScreenFoldState FLAT = null;
    public static final ScreenFoldState FOLDED = null;
    public static final ScreenFoldState HALF = null;
    public static final ScreenFoldState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScreenFoldState[] f267919a = null;
    private final String value;

    public static ScreenFoldState valueOf(String r100) {
        return (ScreenFoldState) r27.a.a(ScreenFoldState.class, r100);
    }

    public static ScreenFoldState[] values() {
        return (ScreenFoldState[]) f267919a.clone();
    }

    static {
        ScreenFoldState r100 = new ScreenFoldState("UNKNOWN", 0, "");
        UNKNOWN = r100;
        ScreenFoldState r101 = new ScreenFoldState("FLAT", 1, "flat");
        FLAT = r101;
        ScreenFoldState r102 = new ScreenFoldState("HALF", 2, "half");
        HALF = r102;
        ScreenFoldState r103 = new ScreenFoldState("FOLDED", 3, "folded");
        FOLDED = r103;
        f267919a = new ScreenFoldState[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public ScreenFoldState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
