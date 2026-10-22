package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/JSErrorCode;", "", "", "value", "I", "getValue", "()I", "Lepus", "JS", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum JSErrorCode extends Enum<JSErrorCode> {
    public static final JSErrorCode JS = null;
    public static final JSErrorCode Lepus = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JSErrorCode[] f267886a = null;
    private final int value;

    public static JSErrorCode valueOf(String r100) {
        return (JSErrorCode) r27.a.a(JSErrorCode.class, r100);
    }

    public static JSErrorCode[] values() {
        return (JSErrorCode[]) f267886a.clone();
    }

    static {
        JSErrorCode r100 = new JSErrorCode("Lepus", 0, 1101);
        Lepus = r100;
        JSErrorCode r101 = new JSErrorCode("JS", 1, 201);
        JS = r101;
        f267886a = new JSErrorCode[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public JSErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
