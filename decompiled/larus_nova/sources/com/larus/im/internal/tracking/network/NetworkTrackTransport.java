package com.larus.im.internal.tracking.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/tracking/network/NetworkTrackTransport;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HTTP", "SSE", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NetworkTrackTransport extends Enum<NetworkTrackTransport> {
    public static final NetworkTrackTransport HTTP = null;
    public static final NetworkTrackTransport SSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkTrackTransport[] f350330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350331b = null;
    private final String value;

    public static EnumEntries<NetworkTrackTransport> getEntries() {
        return f350331b;
    }

    static {
        NetworkTrackTransport r100 = new NetworkTrackTransport("HTTP", 0, "http");
        HTTP = r100;
        NetworkTrackTransport r101 = new NetworkTrackTransport("SSE", 1, "sse");
        SSE = r101;
        NetworkTrackTransport[] r102 = {r100, r101};
        f350330a = r102;
        f350331b = EnumEntriesKt.enumEntries(r102);
    }

    public static NetworkTrackTransport[] values() {
        return (NetworkTrackTransport[]) f350330a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static NetworkTrackTransport valueOf(String r100) {
        return (NetworkTrackTransport) r27.a.a(NetworkTrackTransport.class, r100);
    }

    public NetworkTrackTransport(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
