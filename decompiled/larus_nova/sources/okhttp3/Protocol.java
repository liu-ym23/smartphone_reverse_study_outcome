package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final enum Protocol extends Enum<Protocol> {
    public static final Protocol H2_PRIOR_KNOWLEDGE = null;
    public static final Protocol HTTP_1_0 = null;
    public static final Protocol HTTP_1_1 = null;
    public static final Protocol HTTP_2 = null;
    public static final Protocol QUIC = null;
    public static final Protocol SPDY_3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Protocol[] f523784a = null;
    private final String protocol;

    static {
        Protocol r100 = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_0 = r100;
        Protocol r101 = new Protocol("HTTP_1_1", 1, "http/1.1");
        HTTP_1_1 = r101;
        Protocol r102 = new Protocol("SPDY_3", 2, "spdy/3.1");
        SPDY_3 = r102;
        Protocol r103 = new Protocol("HTTP_2", 3, "h2");
        HTTP_2 = r103;
        Protocol r104 = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        H2_PRIOR_KNOWLEDGE = r104;
        Protocol r105 = new Protocol("QUIC", 5, "quic");
        QUIC = r105;
        f523784a = new Protocol[]{r100, r101, r102, r103, r104, r105};
    }

    public static Protocol[] values() {
        return (Protocol[]) f523784a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }

    public static Protocol get(String r100) throws IOException {
        Protocol r101 = HTTP_1_0;
        if (r100.equals(r101.protocol) == false) goto L5;
        return r101;
    L5:
        Protocol r102 = HTTP_1_1;
        if (r100.equals(r102.protocol) == false) goto L8;
        return r102;
    L8:
        Protocol r103 = H2_PRIOR_KNOWLEDGE;
        if (r100.equals(r103.protocol) == false) goto L11;
        return r103;
    L11:
        Protocol r104 = HTTP_2;
        if (r100.equals(r104.protocol) == false) goto L14;
        return r104;
    L14:
        Protocol r105 = SPDY_3;
        if (r100.equals(r105.protocol) == false) goto L17;
        return r105;
    L17:
        Protocol r106 = QUIC;
        if (r100.equals(r106.protocol) == false) goto L21;
        return r106;
    L21:
        throw new IOException("Unexpected protocol: ".concat(r100));
    }

    public static Protocol valueOf(String r100) {
        return (Protocol) r27.a.a(Protocol.class, r100);
    }

    public Protocol(String r100, int r101, String r102) {
        super(r100, r101);
        this.protocol = r102;
    }
}
