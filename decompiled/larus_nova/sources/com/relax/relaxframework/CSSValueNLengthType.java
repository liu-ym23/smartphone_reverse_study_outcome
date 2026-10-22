package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/CSSValueNLengthType;", "", "", "value", "I", "getValue", "()I", "kAuto", "kMaxContent", "kFitContent", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum CSSValueNLengthType extends Enum<CSSValueNLengthType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CSSValueNLengthType[] f404692a = null;
    public static final CSSValueNLengthType kAuto = null;
    public static final CSSValueNLengthType kFitContent = null;
    public static final CSSValueNLengthType kMaxContent = null;
    private final int value;

    public static CSSValueNLengthType valueOf(String r100) {
        return (CSSValueNLengthType) r27.a.a(CSSValueNLengthType.class, r100);
    }

    public static CSSValueNLengthType[] values() {
        return (CSSValueNLengthType[]) f404692a.clone();
    }

    static {
        CSSValueNLengthType r100 = new CSSValueNLengthType("kAuto", 0, 0);
        kAuto = r100;
        CSSValueNLengthType r101 = new CSSValueNLengthType("kMaxContent", 1, 1);
        kMaxContent = r101;
        CSSValueNLengthType r102 = new CSSValueNLengthType("kFitContent", 2, 2);
        kFitContent = r102;
        f404692a = new CSSValueNLengthType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public CSSValueNLengthType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
