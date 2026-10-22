package com.bytedance.rts.foundation;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/rts/foundation/PromiseStates;", "", "PENDING", "RESOLVED", "REJECTED", "lib_release"}, k = 1, mv = {1, 7, 1})
public final enum PromiseStates extends Enum<PromiseStates> {
    public static final PromiseStates PENDING = null;
    public static final PromiseStates REJECTED = null;
    public static final PromiseStates RESOLVED = null;
    public static final /* synthetic */ PromiseStates[] a = null;

    public static PromiseStates valueOf(String r1) {
        return (PromiseStates) r27.a.a(PromiseStates.class, r1);
    }

    public static PromiseStates[] values() {
        return (PromiseStates[]) a.clone();
    }

    static {
        PromiseStates r0 = new PromiseStates("PENDING", 0);
        PENDING = r0;
        PromiseStates r1 = new PromiseStates("RESOLVED", 1);
        RESOLVED = r1;
        PromiseStates r3 = new PromiseStates("REJECTED", 2);
        REJECTED = r3;
        a = new PromiseStates[]{r0, r1, r3};
    }

    public PromiseStates(String r1, int r2) {
        super(r1, r2);
    }
}
