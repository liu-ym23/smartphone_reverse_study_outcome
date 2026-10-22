package com.larus.im.internal.rtcsdk.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/rtcsdk/impl/RTCAVPlayerState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "WORKING", "PAUSE", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCAVPlayerState extends Enum<RTCAVPlayerState> {
    public static final RTCAVPlayerState IDLE = null;
    public static final RTCAVPlayerState PAUSE = null;
    public static final RTCAVPlayerState WORKING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTCAVPlayerState[] f349837a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349838b = null;

    public static EnumEntries<RTCAVPlayerState> getEntries() {
        return f349838b;
    }

    static {
        RTCAVPlayerState r100 = new RTCAVPlayerState("IDLE", 0);
        IDLE = r100;
        RTCAVPlayerState r101 = new RTCAVPlayerState("WORKING", 1);
        WORKING = r101;
        RTCAVPlayerState r102 = new RTCAVPlayerState("PAUSE", 2);
        PAUSE = r102;
        RTCAVPlayerState[] r103 = {r100, r101, r102};
        f349837a = r103;
        f349838b = EnumEntriesKt.enumEntries(r103);
    }

    public static RTCAVPlayerState[] values() {
        return (RTCAVPlayerState[]) f349837a.clone();
    }

    public static RTCAVPlayerState valueOf(String r100) {
        return (RTCAVPlayerState) r27.a.a(RTCAVPlayerState.class, r100);
    }

    public RTCAVPlayerState(String r100, int r101) {
        super(r100, r101);
    }
}
