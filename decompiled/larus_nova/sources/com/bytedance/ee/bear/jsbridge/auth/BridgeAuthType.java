package com.bytedance.ee.bear.jsbridge.auth;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/jsbridge/auth/BridgeAuthType;", "", "authType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAuthType", "()Ljava/lang/String;", "Secure", "Private", "Public", "Companion", "protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BridgeAuthType extends Enum<BridgeAuthType> {
    public static final a Companion = null;
    public static final BridgeAuthType Private = null;
    public static final BridgeAuthType Public = null;
    public static final BridgeAuthType Secure = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BridgeAuthType[] f227155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f227156b = null;
    private final String authType;

    public static EnumEntries<BridgeAuthType> getEntries() {
        return f227156b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType$a] */
    static {
        BridgeAuthType r100 = new BridgeAuthType("Secure", 0, "secure");
        Secure = r100;
        BridgeAuthType r101 = new BridgeAuthType("Private", 1, BridgePrivilege.PRIVATE);
        Private = r101;
        BridgeAuthType r102 = new BridgeAuthType("Public", 2, "public");
        Public = r102;
        BridgeAuthType[] r103 = {r100, r101, r102};
        f227155a = r103;
        f227156b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static BridgeAuthType[] values() {
        return (BridgeAuthType[]) f227155a.clone();
    }

    public final String getAuthType() {
        return this.authType;
    }

    public static BridgeAuthType valueOf(String r100) {
        return (BridgeAuthType) r27.a.a(BridgeAuthType.class, r100);
    }

    public BridgeAuthType(String r100, int r101, String r102) {
        super(r100, r101);
        this.authType = r102;
    }
}
