package com.bytedance.sdk.xbridge.cn.protocol.auth;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthPriority;", "", "HIGH", "LOW", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AuthPriority extends Enum<AuthPriority> {
    public static final AuthPriority HIGH = null;
    public static final AuthPriority LOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthPriority[] f270059a = null;

    public static AuthPriority valueOf(String r100) {
        return (AuthPriority) a.a(AuthPriority.class, r100);
    }

    public static AuthPriority[] values() {
        return (AuthPriority[]) f270059a.clone();
    }

    static {
        AuthPriority r100 = new AuthPriority("HIGH", 0);
        HIGH = r100;
        AuthPriority r101 = new AuthPriority("LOW", 1);
        LOW = r101;
        f270059a = new AuthPriority[]{r100, r101};
    }

    public AuthPriority(String r100, int r101) {
        super(r100, r101);
    }
}
