package com.larus.im.internal.tracking.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/tracking/network/NetworkTrackColdStartStep;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_CONVERSATION", "CMD", "RECENT_CONVERSATION", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NetworkTrackColdStartStep extends Enum<NetworkTrackColdStartStep> {
    public static final NetworkTrackColdStartStep CMD = null;
    public static final NetworkTrackColdStartStep MAIN_CONVERSATION = null;
    public static final NetworkTrackColdStartStep RECENT_CONVERSATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkTrackColdStartStep[] f350326a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350327b = null;

    public static EnumEntries<NetworkTrackColdStartStep> getEntries() {
        return f350327b;
    }

    static {
        NetworkTrackColdStartStep r100 = new NetworkTrackColdStartStep("MAIN_CONVERSATION", 0);
        MAIN_CONVERSATION = r100;
        NetworkTrackColdStartStep r101 = new NetworkTrackColdStartStep("CMD", 1);
        CMD = r101;
        NetworkTrackColdStartStep r102 = new NetworkTrackColdStartStep("RECENT_CONVERSATION", 2);
        RECENT_CONVERSATION = r102;
        NetworkTrackColdStartStep[] r103 = {r100, r101, r102};
        f350326a = r103;
        f350327b = EnumEntriesKt.enumEntries(r103);
    }

    public static NetworkTrackColdStartStep[] values() {
        return (NetworkTrackColdStartStep[]) f350326a.clone();
    }

    public static NetworkTrackColdStartStep valueOf(String r100) {
        return (NetworkTrackColdStartStep) r27.a.a(NetworkTrackColdStartStep.class, r100);
    }

    public NetworkTrackColdStartStep(String r100, int r101) {
        super(r100, r101);
    }
}
