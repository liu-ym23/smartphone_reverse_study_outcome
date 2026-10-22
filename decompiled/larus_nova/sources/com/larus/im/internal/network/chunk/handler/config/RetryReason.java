package com.larus.im.internal.network.chunk.handler.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/network/chunk/handler/config/RetryReason;", "", "<init>", "(Ljava/lang/String;I)V", "REQUEST_FAILED", "STREAM_DISCONNECT", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RetryReason extends Enum<RetryReason> {
    public static final RetryReason REQUEST_FAILED = null;
    public static final RetryReason STREAM_DISCONNECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RetryReason[] f349144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349145b = null;

    public static EnumEntries<RetryReason> getEntries() {
        return f349145b;
    }

    static {
        RetryReason r100 = new RetryReason("REQUEST_FAILED", 0);
        REQUEST_FAILED = r100;
        RetryReason r101 = new RetryReason("STREAM_DISCONNECT", 1);
        STREAM_DISCONNECT = r101;
        RetryReason[] r102 = {r100, r101};
        f349144a = r102;
        f349145b = EnumEntriesKt.enumEntries(r102);
    }

    public static RetryReason[] values() {
        return (RetryReason[]) f349144a.clone();
    }

    public static RetryReason valueOf(String r100) {
        return (RetryReason) a.a(RetryReason.class, r100);
    }

    public RetryReason(String r100, int r101) {
        super(r100, r101);
    }
}
