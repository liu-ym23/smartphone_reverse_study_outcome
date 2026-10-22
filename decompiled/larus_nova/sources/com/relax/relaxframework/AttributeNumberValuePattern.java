package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/AttributeNumberValuePattern;", "", "", "value", "I", "getValue", "()I", "BOOLEAN", "INT", "DOUBLE", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AttributeNumberValuePattern extends Enum<AttributeNumberValuePattern> {
    public static final AttributeNumberValuePattern BOOLEAN = null;
    public static final AttributeNumberValuePattern DOUBLE = null;
    public static final AttributeNumberValuePattern INT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttributeNumberValuePattern[] f404674a = null;
    private final int value;

    public static AttributeNumberValuePattern valueOf(String r100) {
        return (AttributeNumberValuePattern) r27.a.a(AttributeNumberValuePattern.class, r100);
    }

    public static AttributeNumberValuePattern[] values() {
        return (AttributeNumberValuePattern[]) f404674a.clone();
    }

    static {
        AttributeNumberValuePattern r100 = new AttributeNumberValuePattern("BOOLEAN", 0, 0);
        BOOLEAN = r100;
        AttributeNumberValuePattern r101 = new AttributeNumberValuePattern("INT", 1, 1);
        INT = r101;
        AttributeNumberValuePattern r102 = new AttributeNumberValuePattern("DOUBLE", 2, 2);
        DOUBLE = r102;
        f404674a = new AttributeNumberValuePattern[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public AttributeNumberValuePattern(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
