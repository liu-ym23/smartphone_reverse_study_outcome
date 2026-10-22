package com.larus.im.internal.tracking.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/im/internal/tracking/network/NetworkTrackOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "CANCELLED", "TIMEOUT", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NetworkTrackOutcome extends Enum<NetworkTrackOutcome> {
    public static final NetworkTrackOutcome CANCELLED = null;
    public static final NetworkTrackOutcome FAILURE = null;
    public static final NetworkTrackOutcome SUCCESS = null;
    public static final NetworkTrackOutcome TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkTrackOutcome[] f350328a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350329b = null;

    public static EnumEntries<NetworkTrackOutcome> getEntries() {
        return f350329b;
    }

    static {
        NetworkTrackOutcome r100 = new NetworkTrackOutcome("SUCCESS", 0);
        SUCCESS = r100;
        NetworkTrackOutcome r101 = new NetworkTrackOutcome("FAILURE", 1);
        FAILURE = r101;
        NetworkTrackOutcome r102 = new NetworkTrackOutcome("CANCELLED", 2);
        CANCELLED = r102;
        NetworkTrackOutcome r103 = new NetworkTrackOutcome("TIMEOUT", 3);
        TIMEOUT = r103;
        NetworkTrackOutcome[] r104 = {r100, r101, r102, r103};
        f350328a = r104;
        f350329b = EnumEntriesKt.enumEntries(r104);
    }

    public static NetworkTrackOutcome[] values() {
        return (NetworkTrackOutcome[]) f350328a.clone();
    }

    public static NetworkTrackOutcome valueOf(String r100) {
        return (NetworkTrackOutcome) r27.a.a(NetworkTrackOutcome.class, r100);
    }

    public NetworkTrackOutcome(String r100, int r101) {
        super(r100, r101);
    }
}
