package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/core/OnlyLocalUnbindAndResetResult;", "", "<init>", "(Ljava/lang/String;I)V", "SPP_DISCONNECT_FAILED", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnlyLocalUnbindAndResetResult extends Enum<OnlyLocalUnbindAndResetResult> {
    public static final OnlyLocalUnbindAndResetResult SPP_DISCONNECT_FAILED = null;
    public static final OnlyLocalUnbindAndResetResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnlyLocalUnbindAndResetResult[] f332180a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f332181b = null;

    public static EnumEntries<OnlyLocalUnbindAndResetResult> getEntries() {
        return f332181b;
    }

    static {
        OnlyLocalUnbindAndResetResult r100 = new OnlyLocalUnbindAndResetResult("SPP_DISCONNECT_FAILED", 0);
        SPP_DISCONNECT_FAILED = r100;
        OnlyLocalUnbindAndResetResult r101 = new OnlyLocalUnbindAndResetResult("SUCCESS", 1);
        SUCCESS = r101;
        OnlyLocalUnbindAndResetResult[] r102 = {r100, r101};
        f332180a = r102;
        f332181b = EnumEntriesKt.enumEntries(r102);
    }

    public static OnlyLocalUnbindAndResetResult[] values() {
        return (OnlyLocalUnbindAndResetResult[]) f332180a.clone();
    }

    public static OnlyLocalUnbindAndResetResult valueOf(String r100) {
        return (OnlyLocalUnbindAndResetResult) r27.a.a(OnlyLocalUnbindAndResetResult.class, r100);
    }

    public OnlyLocalUnbindAndResetResult(String r100, int r101) {
        super(r100, r101);
    }
}
