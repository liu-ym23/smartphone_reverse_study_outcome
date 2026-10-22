package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthScene;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "NULL", "ARGUS_WEB_AUTHENTICATOR", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AuthScene extends Enum<AuthScene> {
    public static final AuthScene ARGUS_WEB_AUTHENTICATOR = null;
    public static final AuthScene NULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthScene[] f269824a = null;
    private final String desc;

    public static AuthScene valueOf(String r100) {
        return (AuthScene) a.a(AuthScene.class, r100);
    }

    public static AuthScene[] values() {
        return (AuthScene[]) f269824a.clone();
    }

    static {
        AuthScene r100 = new AuthScene("NULL", 0, "null");
        NULL = r100;
        AuthScene r101 = new AuthScene("ARGUS_WEB_AUTHENTICATOR", 1, "argus_web_authenticator");
        ARGUS_WEB_AUTHENTICATOR = r101;
        f269824a = new AuthScene[]{r100, r101};
    }

    public final String getDesc() {
        return this.desc;
    }

    public AuthScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
