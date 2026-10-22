package com.larus.avlink.business.timeout;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/business/timeout/DoraAvlinkTimeoutTimerType;", "", "<init>", "(Ljava/lang/String;I)V", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "BOT", "dora_business_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum DoraAvlinkTimeoutTimerType extends Enum<DoraAvlinkTimeoutTimerType> {
    public static final DoraAvlinkTimeoutTimerType BOT = null;
    public static final DoraAvlinkTimeoutTimerType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraAvlinkTimeoutTimerType[] f291708a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291709b = null;

    public static EnumEntries<DoraAvlinkTimeoutTimerType> getEntries() {
        return f291709b;
    }

    static {
        DoraAvlinkTimeoutTimerType r100 = new DoraAvlinkTimeoutTimerType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0);
        USER = r100;
        DoraAvlinkTimeoutTimerType r101 = new DoraAvlinkTimeoutTimerType("BOT", 1);
        BOT = r101;
        DoraAvlinkTimeoutTimerType[] r102 = {r100, r101};
        f291708a = r102;
        f291709b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraAvlinkTimeoutTimerType[] values() {
        return (DoraAvlinkTimeoutTimerType[]) f291708a.clone();
    }

    public static DoraAvlinkTimeoutTimerType valueOf(String r100) {
        return (DoraAvlinkTimeoutTimerType) r27.a.a(DoraAvlinkTimeoutTimerType.class, r100);
    }

    public DoraAvlinkTimeoutTimerType(String r100, int r101) {
        super(r100, r101);
    }
}
