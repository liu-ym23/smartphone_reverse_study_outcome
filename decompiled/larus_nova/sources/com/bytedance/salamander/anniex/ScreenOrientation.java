package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/ScreenOrientation;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PORTRAIT", "LANDSCAPE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ScreenOrientation extends Enum<ScreenOrientation> {
    public static final ScreenOrientation LANDSCAPE = null;
    public static final ScreenOrientation PORTRAIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScreenOrientation[] f267921a = null;
    private final String value;

    public static ScreenOrientation valueOf(String r100) {
        return (ScreenOrientation) r27.a.a(ScreenOrientation.class, r100);
    }

    public static ScreenOrientation[] values() {
        return (ScreenOrientation[]) f267921a.clone();
    }

    static {
        ScreenOrientation r100 = new ScreenOrientation("PORTRAIT", 0, "portrait");
        PORTRAIT = r100;
        ScreenOrientation r101 = new ScreenOrientation("LANDSCAPE", 1, "landscape");
        LANDSCAPE = r101;
        f267921a = new ScreenOrientation[]{r100, r101};
    }

    public final String getValue() {
        return this.value;
    }

    public ScreenOrientation(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
