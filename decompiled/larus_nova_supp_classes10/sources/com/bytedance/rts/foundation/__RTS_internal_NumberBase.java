package com.bytedance.rts.foundation;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/rts/foundation/__RTS_internal_NumberBase;", "", "", "value", "J", "getValue", "()J", "DECIMAL", "HEX", "OCTAL", "BINARY", "lib_release"}, k = 1, mv = {1, 7, 1})
public final enum __RTS_internal_NumberBase extends Enum<__RTS_internal_NumberBase> {
    public static final __RTS_internal_NumberBase BINARY = null;
    public static final __RTS_internal_NumberBase DECIMAL = null;
    public static final __RTS_internal_NumberBase HEX = null;
    public static final __RTS_internal_NumberBase OCTAL = null;
    public static final /* synthetic */ __RTS_internal_NumberBase[] a = null;
    private final long value;

    public static __RTS_internal_NumberBase valueOf(String r1) {
        return (__RTS_internal_NumberBase) r27.a.a(__RTS_internal_NumberBase.class, r1);
    }

    public static __RTS_internal_NumberBase[] values() {
        return (__RTS_internal_NumberBase[]) a.clone();
    }

    static {
        __RTS_internal_NumberBase r0 = new __RTS_internal_NumberBase("DECIMAL", 0, 10);
        DECIMAL = r0;
        __RTS_internal_NumberBase r1 = new __RTS_internal_NumberBase("HEX", 1, 16);
        HEX = r1;
        __RTS_internal_NumberBase r2 = new __RTS_internal_NumberBase("OCTAL", 2, 8);
        OCTAL = r2;
        __RTS_internal_NumberBase r3 = new __RTS_internal_NumberBase("BINARY", 3, 2);
        BINARY = r3;
        a = new __RTS_internal_NumberBase[]{r0, r1, r2, r3};
    }

    public final long getValue() {
        return this.value;
    }

    public __RTS_internal_NumberBase(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
