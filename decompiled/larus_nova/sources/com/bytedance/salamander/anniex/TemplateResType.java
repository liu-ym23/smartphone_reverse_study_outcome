package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/salamander/anniex/TemplateResType;", "", "", "value", "I", "getValue", "()I", "Gecko", "GeckoUpdate", "CDN", "CDNCache", "BuiltIn", "Offline", "TemplateBundle", "BinaryData", "Unknown", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TemplateResType extends Enum<TemplateResType> {
    public static final TemplateResType BinaryData = null;
    public static final TemplateResType BuiltIn = null;
    public static final TemplateResType CDN = null;
    public static final TemplateResType CDNCache = null;
    public static final TemplateResType Gecko = null;
    public static final TemplateResType GeckoUpdate = null;
    public static final TemplateResType Offline = null;
    public static final TemplateResType TemplateBundle = null;
    public static final TemplateResType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TemplateResType[] f267923a = null;
    private final int value;

    public static TemplateResType valueOf(String r100) {
        return (TemplateResType) r27.a.a(TemplateResType.class, r100);
    }

    public static TemplateResType[] values() {
        return (TemplateResType[]) f267923a.clone();
    }

    static {
        TemplateResType r100 = new TemplateResType("Gecko", 0, 0);
        Gecko = r100;
        TemplateResType r101 = new TemplateResType("GeckoUpdate", 1, 1);
        GeckoUpdate = r101;
        TemplateResType r102 = new TemplateResType("CDN", 2, 2);
        CDN = r102;
        TemplateResType r103 = new TemplateResType("CDNCache", 3, 3);
        CDNCache = r103;
        TemplateResType r104 = new TemplateResType("BuiltIn", 4, 4);
        BuiltIn = r104;
        TemplateResType r105 = new TemplateResType("Offline", 5, 5);
        Offline = r105;
        TemplateResType r110 = new TemplateResType("TemplateBundle", 6, 6);
        TemplateBundle = r110;
        TemplateResType r111 = new TemplateResType("BinaryData", 7, 7);
        BinaryData = r111;
        TemplateResType r112 = new TemplateResType("Unknown", 8, 8);
        Unknown = r112;
        f267923a = new TemplateResType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public final int getValue() {
        return this.value;
    }

    public TemplateResType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
