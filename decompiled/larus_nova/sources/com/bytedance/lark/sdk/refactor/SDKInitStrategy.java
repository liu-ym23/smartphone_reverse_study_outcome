package com.bytedance.lark.sdk.refactor;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/sdk/refactor/SDKInitStrategy;", "", "<init>", "(Ljava/lang/String;I)V", BridgeSyncType.SYNC, BridgeSyncType.ASYNC, "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SDKInitStrategy extends Enum<SDKInitStrategy> {
    public static final SDKInitStrategy ASYNC = null;
    public static final SDKInitStrategy SYNC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SDKInitStrategy[] f254239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254240b = null;

    public static EnumEntries<SDKInitStrategy> getEntries() {
        return f254240b;
    }

    static {
        SDKInitStrategy r100 = new SDKInitStrategy(BridgeSyncType.SYNC, 0);
        SYNC = r100;
        SDKInitStrategy r101 = new SDKInitStrategy(BridgeSyncType.ASYNC, 1);
        ASYNC = r101;
        SDKInitStrategy[] r102 = {r100, r101};
        f254239a = r102;
        f254240b = EnumEntriesKt.enumEntries(r102);
    }

    public static SDKInitStrategy[] values() {
        return (SDKInitStrategy[]) f254239a.clone();
    }

    public static SDKInitStrategy valueOf(String r100) {
        return (SDKInitStrategy) r27.a.a(SDKInitStrategy.class, r100);
    }

    public SDKInitStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
