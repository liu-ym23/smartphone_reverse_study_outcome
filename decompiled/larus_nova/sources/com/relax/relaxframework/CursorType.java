package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/CursorType;", "", "", "value", "I", "getValue", "()I", "Url", "Keyword", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum CursorType extends Enum<CursorType> {
    public static final CursorType Keyword = null;
    public static final CursorType Url = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CursorType[] f404705a = null;
    private final int value;

    public static CursorType valueOf(String r100) {
        return (CursorType) r27.a.a(CursorType.class, r100);
    }

    public static CursorType[] values() {
        return (CursorType[]) f404705a.clone();
    }

    static {
        CursorType r100 = new CursorType("Url", 0, 0);
        Url = r100;
        CursorType r101 = new CursorType("Keyword", 1, 1);
        Keyword = r101;
        f404705a = new CursorType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public CursorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
