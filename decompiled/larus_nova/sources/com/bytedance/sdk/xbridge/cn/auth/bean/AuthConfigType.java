package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "WEB", "LYNX", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AuthConfigType extends Enum<AuthConfigType> {
    public static final a Companion = null;
    public static final AuthConfigType LYNX = null;
    public static final AuthConfigType UNKNOWN = null;
    public static final AuthConfigType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthConfigType[] f269821a = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public final AuthConfigType getType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            if (Intrinsics.areEqual(r100, "h5") == false) goto L6;
            return AuthConfigType.WEB;
        L6:
            if (Intrinsics.areEqual(r100, "lynx") == false) goto L9;
            return AuthConfigType.LYNX;
        L9:
            return AuthConfigType.UNKNOWN;
        }
    }

    public static AuthConfigType valueOf(String r100) {
        return (AuthConfigType) r27.a.a(AuthConfigType.class, r100);
    }

    public static AuthConfigType[] values() {
        return (AuthConfigType[]) f269821a.clone();
    }

    static {
        AuthConfigType r100 = new AuthConfigType("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        AuthConfigType r101 = new AuthConfigType("WEB", 1, "web");
        WEB = r101;
        AuthConfigType r102 = new AuthConfigType("LYNX", 2, "lynx");
        LYNX = r102;
        f269821a = new AuthConfigType[]{r100, r101, r102};
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    public AuthConfigType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
