package com.bytedance.lark.sdk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/sdk/LarkNetProtocol;", "", "protocol", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getProtocol", "()Ljava/lang/String;", "UNKNOWN", "HTTP_1_1", "HTTP_2", "QUIC", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkNetProtocol extends Enum<LarkNetProtocol> {
    public static final LarkNetProtocol HTTP_1_1 = null;
    public static final LarkNetProtocol HTTP_2 = null;
    public static final LarkNetProtocol QUIC = null;
    public static final LarkNetProtocol UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LarkNetProtocol[] f254050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254051b = null;
    private final String protocol;

    public static EnumEntries<LarkNetProtocol> getEntries() {
        return f254051b;
    }

    static {
        LarkNetProtocol r100 = new LarkNetProtocol("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        LarkNetProtocol r101 = new LarkNetProtocol("HTTP_1_1", 1, "http/1.1");
        HTTP_1_1 = r101;
        LarkNetProtocol r102 = new LarkNetProtocol("HTTP_2", 2, "h2");
        HTTP_2 = r102;
        LarkNetProtocol r103 = new LarkNetProtocol("QUIC", 3, "quic");
        QUIC = r103;
        LarkNetProtocol[] r104 = {r100, r101, r102, r103};
        f254050a = r104;
        f254051b = EnumEntriesKt.enumEntries(r104);
    }

    public static LarkNetProtocol[] values() {
        return (LarkNetProtocol[]) f254050a.clone();
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public static LarkNetProtocol valueOf(String r100) {
        return (LarkNetProtocol) r27.a.a(LarkNetProtocol.class, r100);
    }

    public LarkNetProtocol(String r100, int r101, String r102) {
        super(r100, r101);
        this.protocol = r102;
    }
}
