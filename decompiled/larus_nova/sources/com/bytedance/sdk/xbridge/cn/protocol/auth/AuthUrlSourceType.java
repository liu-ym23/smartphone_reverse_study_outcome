package com.bytedance.sdk.xbridge.cn.protocol.auth;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthUrlSourceType;", "", "", "code", "I", "getCode", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DisableSafeAuthInXBridge2", "DisableSafeAuthInXBridge3", "Unset", "PageStartedUrl", "PageCommitVisibleUrl", "WebViewUrl", "TokenUrl", "TokenUrlDegrade", "TokenUrlCompat", "NoTokenUrl", "AbnormalUrl", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AuthUrlSourceType extends Enum<AuthUrlSourceType> {
    public static final AuthUrlSourceType AbnormalUrl = null;
    public static final a Companion = null;
    public static final AuthUrlSourceType DisableSafeAuthInXBridge2 = null;
    public static final AuthUrlSourceType DisableSafeAuthInXBridge3 = null;
    public static final AuthUrlSourceType NoTokenUrl = null;
    public static final AuthUrlSourceType PageCommitVisibleUrl = null;
    public static final AuthUrlSourceType PageStartedUrl = null;
    public static final AuthUrlSourceType TokenUrl = null;
    public static final AuthUrlSourceType TokenUrlCompat = null;
    public static final AuthUrlSourceType TokenUrlDegrade = null;
    public static final AuthUrlSourceType Unset = null;
    public static final AuthUrlSourceType WebViewUrl = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthUrlSourceType[] f270060a = null;
    private final int code;

    public static AuthUrlSourceType valueOf(String r100) {
        return (AuthUrlSourceType) r27.a.a(AuthUrlSourceType.class, r100);
    }

    public static AuthUrlSourceType[] values() {
        return (AuthUrlSourceType[]) f270060a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.sdk.xbridge.cn.protocol.auth.AuthUrlSourceType$a] */
    static {
        AuthUrlSourceType r100 = new AuthUrlSourceType("DisableSafeAuthInXBridge2", 0, -2);
        DisableSafeAuthInXBridge2 = r100;
        AuthUrlSourceType r101 = new AuthUrlSourceType("DisableSafeAuthInXBridge3", 1, -1);
        DisableSafeAuthInXBridge3 = r101;
        AuthUrlSourceType r102 = new AuthUrlSourceType("Unset", 2, 0);
        Unset = r102;
        AuthUrlSourceType r103 = new AuthUrlSourceType("PageStartedUrl", 3, 2);
        PageStartedUrl = r103;
        AuthUrlSourceType r104 = new AuthUrlSourceType("PageCommitVisibleUrl", 4, 3);
        PageCommitVisibleUrl = r104;
        AuthUrlSourceType r105 = new AuthUrlSourceType("WebViewUrl", 5, 4);
        WebViewUrl = r105;
        AuthUrlSourceType r110 = new AuthUrlSourceType("TokenUrl", 6, 5);
        TokenUrl = r110;
        AuthUrlSourceType r111 = new AuthUrlSourceType("TokenUrlDegrade", 7, 6);
        TokenUrlDegrade = r111;
        AuthUrlSourceType r112 = new AuthUrlSourceType("TokenUrlCompat", 8, 7);
        TokenUrlCompat = r112;
        AuthUrlSourceType r113 = new AuthUrlSourceType("NoTokenUrl", 9, 8);
        NoTokenUrl = r113;
        AuthUrlSourceType r114 = new AuthUrlSourceType("AbnormalUrl", 10, 101);
        AbnormalUrl = r114;
        f270060a = new AuthUrlSourceType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        Companion = new a();
    }

    public final int getCode() {
        return this.code;
    }

    public AuthUrlSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
