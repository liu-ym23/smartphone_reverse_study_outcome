package com.bytedance.android.tetrisinspectorsdk;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/tetrisinspectorsdk/Protocol;", "", "", "encode", "", "protocol", "Ljava/lang/String;", "getProtocol", "()Ljava/lang/String;", "UNKNOWN", "PROTOCOL_END", "PROTOCOL_VERSION", "PROTOCOL_DUMP_VIEW", "tetris-inspector-sdk_release"}, k = 1, mv = {1, 4, 0})
public final enum Protocol extends Enum<Protocol> {
    public static final Protocol PROTOCOL_DUMP_VIEW = null;
    public static final Protocol PROTOCOL_END = null;
    public static final Protocol PROTOCOL_VERSION = null;
    public static final Protocol UNKNOWN = null;
    public static final /* synthetic */ Protocol[] a = null;
    private final String protocol;

    static {
        Protocol r1 = new Protocol("UNKNOWN", 0, "un_known");
        UNKNOWN = r1;
        Protocol r2 = new Protocol("PROTOCOL_END", 1, "end");
        PROTOCOL_END = r2;
        Protocol r3 = new Protocol("PROTOCOL_VERSION", 2, "version");
        PROTOCOL_VERSION = r3;
        Protocol r4 = new Protocol("PROTOCOL_DUMP_VIEW", 3, "dump_view");
        PROTOCOL_DUMP_VIEW = r4;
        a = new Protocol[]{r1, r2, r3, r4};
    }

    public static Protocol valueOf(String r1) {
        return (Protocol) a.a(Protocol.class, r1);
    }

    public static Protocol[] values() {
        return (Protocol[]) a.clone();
    }

    public final byte[] encode() {
        int r0 = xl3.a.a;
        return xl3.a.a(this.protocol);
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public Protocol(String r1, int r2, String r3) {
        super(r1, r2);
        this.protocol = r3;
    }
}
