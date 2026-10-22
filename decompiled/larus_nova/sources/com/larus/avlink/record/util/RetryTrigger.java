package com.larus.avlink.record.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/record/util/RetryTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "BACKOFF", "NETWORK_RECOVERY", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RetryTrigger extends Enum<RetryTrigger> {
    public static final RetryTrigger BACKOFF = null;
    public static final RetryTrigger INITIAL = null;
    public static final RetryTrigger NETWORK_RECOVERY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RetryTrigger[] f294407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294408b = null;

    public static EnumEntries<RetryTrigger> getEntries() {
        return f294408b;
    }

    static {
        RetryTrigger r100 = new RetryTrigger("INITIAL", 0);
        INITIAL = r100;
        RetryTrigger r101 = new RetryTrigger("BACKOFF", 1);
        BACKOFF = r101;
        RetryTrigger r102 = new RetryTrigger("NETWORK_RECOVERY", 2);
        NETWORK_RECOVERY = r102;
        RetryTrigger[] r103 = {r100, r101, r102};
        f294407a = r103;
        f294408b = EnumEntriesKt.enumEntries(r103);
    }

    public static RetryTrigger[] values() {
        return (RetryTrigger[]) f294407a.clone();
    }

    public static RetryTrigger valueOf(String r100) {
        return (RetryTrigger) r27.a.a(RetryTrigger.class, r100);
    }

    public RetryTrigger(String r100, int r101) {
        super(r100, r101);
    }
}
