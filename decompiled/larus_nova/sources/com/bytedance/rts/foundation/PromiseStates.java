package com.bytedance.rts.foundation;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/rts/foundation/PromiseStates;", "", "PENDING", "RESOLVED", "REJECTED", "lib_release"}, k = 1, mv = {1, 7, 1})
public final enum PromiseStates extends Enum<PromiseStates> {
    public static final PromiseStates PENDING = null;
    public static final PromiseStates REJECTED = null;
    public static final PromiseStates RESOLVED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromiseStates[] f267564a = null;

    public static PromiseStates valueOf(String r100) {
        return (PromiseStates) r27.a.a(PromiseStates.class, r100);
    }

    public static PromiseStates[] values() {
        return (PromiseStates[]) f267564a.clone();
    }

    static {
        PromiseStates r100 = new PromiseStates("PENDING", 0);
        PENDING = r100;
        PromiseStates r101 = new PromiseStates("RESOLVED", 1);
        RESOLVED = r101;
        PromiseStates r102 = new PromiseStates("REJECTED", 2);
        REJECTED = r102;
        f267564a = new PromiseStates[]{r100, r101, r102};
    }

    public PromiseStates(String r100, int r101) {
        super(r100, r101);
    }
}
