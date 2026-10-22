package com.larus.avlink.record.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/record/util/RetryDecision;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "RETRY", "TERMINAL", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RetryDecision extends Enum<RetryDecision> {
    public static final RetryDecision RETRY = null;
    public static final RetryDecision SUCCESS = null;
    public static final RetryDecision TERMINAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RetryDecision[] f294405a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294406b = null;

    public static EnumEntries<RetryDecision> getEntries() {
        return f294406b;
    }

    static {
        RetryDecision r100 = new RetryDecision("SUCCESS", 0);
        SUCCESS = r100;
        RetryDecision r101 = new RetryDecision("RETRY", 1);
        RETRY = r101;
        RetryDecision r102 = new RetryDecision("TERMINAL", 2);
        TERMINAL = r102;
        RetryDecision[] r103 = {r100, r101, r102};
        f294405a = r103;
        f294406b = EnumEntriesKt.enumEntries(r103);
    }

    public static RetryDecision[] values() {
        return (RetryDecision[]) f294405a.clone();
    }

    public static RetryDecision valueOf(String r100) {
        return (RetryDecision) r27.a.a(RetryDecision.class, r100);
    }

    public RetryDecision(String r100, int r101) {
        super(r100, r101);
    }
}
