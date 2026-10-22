package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "PUBLIC", "PRIVATE", "SECURE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AuthBridgeAccess extends Enum<AuthBridgeAccess> {
    public static final a Companion = null;
    public static final AuthBridgeAccess PRIVATE = null;
    public static final AuthBridgeAccess PUBLIC = null;
    public static final AuthBridgeAccess SECURE = null;
    public static final AuthBridgeAccess UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthBridgeAccess[] f269820a = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static AuthBridgeAccess a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            String r101 = r100.toLowerCase();
            switch(r101.hashCode()) {
                case -977423767: goto L20;
                case -906273929: goto L16;
                case -608539730: goto L12;
                case -314497661: goto L9;
                case -309012785: goto L6;
                default: goto L24;
            };
        L6:
            if (r101.equals("protect") == false) goto L24;
        L25:
            return AuthBridgeAccess.PRIVATE;
        L9:
            if (r101.equals(BridgePrivilege.PRIVATE) == true) goto L25;
        L12:
            if (r101.equals("protected") == true) goto L25;
        L16:
            if (r101.equals("secure") == false) goto L24;
            return AuthBridgeAccess.SECURE;
        L20:
            if (r101.equals("public") == false) goto L24;
            return AuthBridgeAccess.PUBLIC;
        L24:
            return AuthBridgeAccess.PRIVATE;
        }
    }

    public static AuthBridgeAccess valueOf(String r100) {
        return (AuthBridgeAccess) r27.a.a(AuthBridgeAccess.class, r100);
    }

    public static AuthBridgeAccess[] values() {
        return (AuthBridgeAccess[]) f269820a.clone();
    }

    static {
        AuthBridgeAccess r100 = new AuthBridgeAccess("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        AuthBridgeAccess r101 = new AuthBridgeAccess("PUBLIC", 1, "public");
        PUBLIC = r101;
        AuthBridgeAccess r102 = new AuthBridgeAccess("PRIVATE", 2, BridgePrivilege.PRIVATE);
        PRIVATE = r102;
        AuthBridgeAccess r103 = new AuthBridgeAccess("SECURE", 3, "secure");
        SECURE = r103;
        f269820a = new AuthBridgeAccess[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    public AuthBridgeAccess(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
