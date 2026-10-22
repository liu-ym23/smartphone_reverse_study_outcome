package com.bytedance.rts.kmp.foundation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/rts/kmp/foundation/__RTS_internal_NumberBase;", "", "value", "", "<init>", "(Ljava/lang/String;IJ)V", "getValue", "()J", "DECIMAL", "HEX", "OCTAL", "BINARY", "rts2native_kmp_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum __RTS_internal_NumberBase extends Enum<__RTS_internal_NumberBase> {
    public static final __RTS_internal_NumberBase BINARY = null;
    public static final __RTS_internal_NumberBase DECIMAL = null;
    public static final __RTS_internal_NumberBase HEX = null;
    public static final __RTS_internal_NumberBase OCTAL = null;
    public static final /* synthetic */ __RTS_internal_NumberBase[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final long value;

    public static EnumEntries<__RTS_internal_NumberBase> getEntries() {
        return b;
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
        __RTS_internal_NumberBase[] r7 = {r0, r1, r2, r3};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static __RTS_internal_NumberBase[] values() {
        return (__RTS_internal_NumberBase[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public static __RTS_internal_NumberBase valueOf(String r1) {
        return (__RTS_internal_NumberBase) r27.a.a(__RTS_internal_NumberBase.class, r1);
    }

    public __RTS_internal_NumberBase(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
