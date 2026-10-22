package com.bytedance.rts.foundation;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/rts/foundation/__RTS_internal_ExplicitType;", "", "", "value", "J", "getValue", "()J", "UNKNOWN", "INT_32", "INT_64", "FLOAT_32", "FLOAT_64", "lib_release"}, k = 1, mv = {1, 7, 1})
public final enum __RTS_internal_ExplicitType extends Enum<__RTS_internal_ExplicitType> {
    public static final __RTS_internal_ExplicitType FLOAT_32 = null;
    public static final __RTS_internal_ExplicitType FLOAT_64 = null;
    public static final __RTS_internal_ExplicitType INT_32 = null;
    public static final __RTS_internal_ExplicitType INT_64 = null;
    public static final __RTS_internal_ExplicitType UNKNOWN = null;
    public static final /* synthetic */ __RTS_internal_ExplicitType[] a = null;
    private final long value;

    public static __RTS_internal_ExplicitType valueOf(String r1) {
        return (__RTS_internal_ExplicitType) r27.a.a(__RTS_internal_ExplicitType.class, r1);
    }

    public static __RTS_internal_ExplicitType[] values() {
        return (__RTS_internal_ExplicitType[]) a.clone();
    }

    static {
        __RTS_internal_ExplicitType r0 = new __RTS_internal_ExplicitType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        __RTS_internal_ExplicitType r1 = new __RTS_internal_ExplicitType("INT_32", 1, 1);
        INT_32 = r1;
        __RTS_internal_ExplicitType r2 = new __RTS_internal_ExplicitType("INT_64", 2, 2);
        INT_64 = r2;
        __RTS_internal_ExplicitType r3 = new __RTS_internal_ExplicitType("FLOAT_32", 3, 3);
        FLOAT_32 = r3;
        __RTS_internal_ExplicitType r7 = new __RTS_internal_ExplicitType("FLOAT_64", 4, 4);
        FLOAT_64 = r7;
        a = new __RTS_internal_ExplicitType[]{r0, r1, r2, r3, r7};
    }

    public final long getValue() {
        return this.value;
    }

    public __RTS_internal_ExplicitType(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
