package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/TokenAuthMode;", "", "", "code", "I", "getCode", "()I", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "UNSET", "DISABLE", "TOKEN_AUTH_WITH_DEGRADE", "FORCE_USE_TOKEN_AUTH", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TokenAuthMode extends Enum<TokenAuthMode> {
    public static final TokenAuthMode DISABLE = null;
    public static final TokenAuthMode FORCE_USE_TOKEN_AUTH = null;
    public static final TokenAuthMode TOKEN_AUTH_WITH_DEGRADE = null;
    public static final TokenAuthMode UNSET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TokenAuthMode[] f269832a = null;
    private final int code;
    private final String desc;

    public static TokenAuthMode valueOf(String r100) {
        return (TokenAuthMode) a.a(TokenAuthMode.class, r100);
    }

    public static TokenAuthMode[] values() {
        return (TokenAuthMode[]) f269832a.clone();
    }

    static {
        TokenAuthMode r100 = new TokenAuthMode("UNSET", 0, -1, "unset");
        UNSET = r100;
        TokenAuthMode r101 = new TokenAuthMode("DISABLE", 1, 0, "disable");
        DISABLE = r101;
        TokenAuthMode r102 = new TokenAuthMode("TOKEN_AUTH_WITH_DEGRADE", 2, 1, "token_auth_with_degrade");
        TOKEN_AUTH_WITH_DEGRADE = r102;
        TokenAuthMode r103 = new TokenAuthMode("FORCE_USE_TOKEN_AUTH", 3, 2, "force_use_token_auth");
        FORCE_USE_TOKEN_AUTH = r103;
        f269832a = new TokenAuthMode[]{r100, r101, r102, r103};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDesc() {
        return this.desc;
    }

    public TokenAuthMode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.desc = r103;
    }
}
