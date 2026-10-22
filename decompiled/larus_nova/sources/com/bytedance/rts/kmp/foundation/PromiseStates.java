package com.bytedance.rts.kmp.foundation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/rts/kmp/foundation/PromiseStates;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "RESOLVED", "REJECTED", "rts2native_kmp_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PromiseStates extends Enum<PromiseStates> {
    public static final PromiseStates PENDING = null;
    public static final PromiseStates REJECTED = null;
    public static final PromiseStates RESOLVED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromiseStates[] f267599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f267600b = null;

    public static EnumEntries<PromiseStates> getEntries() {
        return f267600b;
    }

    static {
        PromiseStates r100 = new PromiseStates("PENDING", 0);
        PENDING = r100;
        PromiseStates r101 = new PromiseStates("RESOLVED", 1);
        RESOLVED = r101;
        PromiseStates r102 = new PromiseStates("REJECTED", 2);
        REJECTED = r102;
        PromiseStates[] r103 = {r100, r101, r102};
        f267599a = r103;
        f267600b = EnumEntriesKt.enumEntries(r103);
    }

    public static PromiseStates[] values() {
        return (PromiseStates[]) f267599a.clone();
    }

    public static PromiseStates valueOf(String r100) {
        return (PromiseStates) r27.a.a(PromiseStates.class, r100);
    }

    public PromiseStates(String r100, int r101) {
        super(r100, r101);
    }
}
