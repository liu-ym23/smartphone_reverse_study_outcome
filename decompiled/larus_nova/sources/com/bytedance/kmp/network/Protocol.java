package com.bytedance.kmp.network;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/network/Protocol;", "", "", "protocol", "Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "HTTP_0_9", "HTTP_1_0", "HTTP_1_1", "HTTP_2", "QUIC", "network_service_release"}, k = 1, mv = {1, 7, 0})
public final enum Protocol extends Enum<Protocol> {
    public static final a Companion = null;
    public static final Protocol HTTP_0_9 = null;
    public static final Protocol HTTP_1_0 = null;
    public static final Protocol HTTP_1_1 = null;
    public static final Protocol HTTP_2 = null;
    public static final Protocol QUIC = null;
    public static final Protocol UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Protocol[] f252477a = null;
    private final String protocol;

    public static Protocol valueOf(String r100) {
        return (Protocol) r27.a.a(Protocol.class, r100);
    }

    public static Protocol[] values() {
        return (Protocol[]) f252477a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.kmp.network.Protocol$a] */
    static {
        Protocol r100 = new Protocol("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        Protocol r101 = new Protocol("HTTP_0_9", 1, "http/0.9");
        HTTP_0_9 = r101;
        Protocol r102 = new Protocol("HTTP_1_0", 2, "http/1.0");
        HTTP_1_0 = r102;
        Protocol r103 = new Protocol("HTTP_1_1", 3, "http/1.1");
        HTTP_1_1 = r103;
        Protocol r104 = new Protocol("HTTP_2", 4, "http/2");
        HTTP_2 = r104;
        Protocol r105 = new Protocol("QUIC", 5, "quic");
        QUIC = r105;
        f252477a = new Protocol[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static final /* synthetic */ String access$getProtocol$p(Protocol r100) {
        return r100.protocol;
    }

    public Protocol(String r100, int r101, String r102) {
        super(r100, r101);
        this.protocol = r102;
    }
}
