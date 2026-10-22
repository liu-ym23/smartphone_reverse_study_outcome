package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/WebviewType;", "", "", "value", "I", "getValue", "()I", "TTWebView", "System", "Unknown", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum WebviewType extends Enum<WebviewType> {
    public static final WebviewType System = null;
    public static final WebviewType TTWebView = null;
    public static final WebviewType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebviewType[] f267929a = null;
    private final int value;

    public static WebviewType valueOf(String r100) {
        return (WebviewType) r27.a.a(WebviewType.class, r100);
    }

    public static WebviewType[] values() {
        return (WebviewType[]) f267929a.clone();
    }

    static {
        WebviewType r100 = new WebviewType("TTWebView", 0, 0);
        TTWebView = r100;
        WebviewType r101 = new WebviewType("System", 1, 1);
        System = r101;
        WebviewType r102 = new WebviewType("Unknown", 2, 2);
        Unknown = r102;
        f267929a = new WebviewType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public WebviewType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
