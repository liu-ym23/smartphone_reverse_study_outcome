package com.bytedance.rts.kmp.foundation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/rts/kmp/foundation/PromiseStates;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "RESOLVED", "REJECTED", "rts2native_kmp_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PromiseStates extends Enum<PromiseStates> {
    public static final PromiseStates PENDING = null;
    public static final PromiseStates REJECTED = null;
    public static final PromiseStates RESOLVED = null;
    public static final /* synthetic */ PromiseStates[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PromiseStates> getEntries() {
        return b;
    }

    static {
        PromiseStates r0 = new PromiseStates("PENDING", 0);
        PENDING = r0;
        PromiseStates r1 = new PromiseStates("RESOLVED", 1);
        RESOLVED = r1;
        PromiseStates r3 = new PromiseStates("REJECTED", 2);
        REJECTED = r3;
        PromiseStates[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PromiseStates[] values() {
        return (PromiseStates[]) a.clone();
    }

    public static PromiseStates valueOf(String r1) {
        return (PromiseStates) r27.a.a(PromiseStates.class, r1);
    }

    public PromiseStates(String r1, int r2) {
        super(r1, r2);
    }
}
