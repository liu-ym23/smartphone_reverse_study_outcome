package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXSLEngineType;", "", "", "value", "I", "getValue", "()I", "unknow", "lynx", "web", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXSLEngineType extends Enum<AnnieXSLEngineType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXSLEngineType[] f267857a = null;
    public static final AnnieXSLEngineType lynx = null;
    public static final AnnieXSLEngineType unknow = null;

    /* JADX INFO: renamed from: web, reason: collision with root package name */
    public static final AnnieXSLEngineType f267858web = null;
    private final int value;

    public static AnnieXSLEngineType valueOf(String r100) {
        return (AnnieXSLEngineType) r27.a.a(AnnieXSLEngineType.class, r100);
    }

    public static AnnieXSLEngineType[] values() {
        return (AnnieXSLEngineType[]) f267857a.clone();
    }

    static {
        AnnieXSLEngineType r100 = new AnnieXSLEngineType("unknow", 0, 0);
        unknow = r100;
        AnnieXSLEngineType r101 = new AnnieXSLEngineType("lynx", 1, 1);
        lynx = r101;
        AnnieXSLEngineType r102 = new AnnieXSLEngineType("web", 2, 2);
        f267858web = r102;
        f267857a = new AnnieXSLEngineType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public AnnieXSLEngineType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
