package com.ss.android.ugc.tools.net;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/tools/net/NetworkState;", "", "UNKNOWN", "AVAILABLE", "NOT_AVAILABLE", "FAKE", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final enum NetworkState extends Enum<NetworkState> {
    public static final NetworkState AVAILABLE = null;
    public static final NetworkState FAKE = null;
    public static final NetworkState NOT_AVAILABLE = null;
    public static final NetworkState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkState[] f454838a = null;

    static {
        NetworkState r100 = new NetworkState("UNKNOWN", 0);
        UNKNOWN = r100;
        NetworkState r101 = new NetworkState("AVAILABLE", 1);
        AVAILABLE = r101;
        NetworkState r102 = new NetworkState("NOT_AVAILABLE", 2);
        NOT_AVAILABLE = r102;
        NetworkState r103 = new NetworkState("FAKE", 3);
        FAKE = r103;
        f454838a = new NetworkState[]{r100, r101, r102, r103};
    }

    public static NetworkState valueOf(String r100) {
        return (NetworkState) r27.a.a(NetworkState.class, r100);
    }

    public static NetworkState[] values() {
        return (NetworkState[]) f454838a.clone();
    }

    public NetworkState(String r100, int r101) {
        super(r100, r101);
    }
}
