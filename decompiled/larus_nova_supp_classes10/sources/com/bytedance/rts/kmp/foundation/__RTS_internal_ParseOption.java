package com.bytedance.rts.kmp.foundation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/rts/kmp/foundation/__RTS_internal_ParseOption;", "", "value", "", "<init>", "(Ljava/lang/String;IJ)V", "getValue", "()J", "PARSE", "FROM_STRING", "rts2native_kmp_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum __RTS_internal_ParseOption extends Enum<__RTS_internal_ParseOption> {
    public static final __RTS_internal_ParseOption FROM_STRING = null;
    public static final __RTS_internal_ParseOption PARSE = null;
    public static final /* synthetic */ __RTS_internal_ParseOption[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final long value;

    public static EnumEntries<__RTS_internal_ParseOption> getEntries() {
        return b;
    }

    static {
        __RTS_internal_ParseOption r0 = new __RTS_internal_ParseOption("PARSE", 0, 0);
        PARSE = r0;
        __RTS_internal_ParseOption r1 = new __RTS_internal_ParseOption("FROM_STRING", 1, 1);
        FROM_STRING = r1;
        __RTS_internal_ParseOption[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static __RTS_internal_ParseOption[] values() {
        return (__RTS_internal_ParseOption[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public static __RTS_internal_ParseOption valueOf(String r1) {
        return (__RTS_internal_ParseOption) r27.a.a(__RTS_internal_ParseOption.class, r1);
    }

    public __RTS_internal_ParseOption(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
