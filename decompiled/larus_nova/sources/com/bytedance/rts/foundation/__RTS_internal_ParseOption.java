package com.bytedance.rts.foundation;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/rts/foundation/__RTS_internal_ParseOption;", "", "", "value", "J", "getValue", "()J", "PARSE", "FROM_STRING", "lib_release"}, k = 1, mv = {1, 7, 1})
public final enum __RTS_internal_ParseOption extends Enum<__RTS_internal_ParseOption> {
    public static final __RTS_internal_ParseOption FROM_STRING = null;
    public static final __RTS_internal_ParseOption PARSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ __RTS_internal_ParseOption[] f267574a = null;
    private final long value;

    public static __RTS_internal_ParseOption valueOf(String r100) {
        return (__RTS_internal_ParseOption) r27.a.a(__RTS_internal_ParseOption.class, r100);
    }

    public static __RTS_internal_ParseOption[] values() {
        return (__RTS_internal_ParseOption[]) f267574a.clone();
    }

    static {
        __RTS_internal_ParseOption r100 = new __RTS_internal_ParseOption("PARSE", 0, 0);
        PARSE = r100;
        __RTS_internal_ParseOption r101 = new __RTS_internal_ParseOption("FROM_STRING", 1, 1);
        FROM_STRING = r101;
        f267574a = new __RTS_internal_ParseOption[]{r100, r101};
    }

    public final long getValue() {
        return this.value;
    }

    public __RTS_internal_ParseOption(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
