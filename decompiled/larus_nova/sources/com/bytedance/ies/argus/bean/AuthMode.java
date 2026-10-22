package com.bytedance.ies.argus.bean;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/bean/AuthMode;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "INTERNAL_H5_APPID", "INTERNAL_H5_OLD", "STANDARD_H5_V3", "STANDARD_H5_V3_FORCE_PRIVATE", "STANDARD_LYNX", "STANDARD_LYNX_FORCE_PRIVATE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AuthMode extends Enum<AuthMode> {
    public static final AuthMode INTERNAL_H5_APPID = null;
    public static final AuthMode INTERNAL_H5_OLD = null;
    public static final AuthMode STANDARD_H5_V3 = null;
    public static final AuthMode STANDARD_H5_V3_FORCE_PRIVATE = null;
    public static final AuthMode STANDARD_LYNX = null;
    public static final AuthMode STANDARD_LYNX_FORCE_PRIVATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthMode[] f246008a = null;
    private final String desc;

    public static AuthMode valueOf(String r100) {
        return (AuthMode) r27.a.a(AuthMode.class, r100);
    }

    public static AuthMode[] values() {
        return (AuthMode[]) f246008a.clone();
    }

    static {
        AuthMode r100 = new AuthMode("INTERNAL_H5_APPID", 0, "internal_h5_appID");
        INTERNAL_H5_APPID = r100;
        AuthMode r101 = new AuthMode("INTERNAL_H5_OLD", 1, "internal_h5_old");
        INTERNAL_H5_OLD = r101;
        AuthMode r102 = new AuthMode("STANDARD_H5_V3", 2, "standard_h5_v3");
        STANDARD_H5_V3 = r102;
        AuthMode r103 = new AuthMode("STANDARD_H5_V3_FORCE_PRIVATE", 3, "standard_h5_v3_force_private");
        STANDARD_H5_V3_FORCE_PRIVATE = r103;
        AuthMode r104 = new AuthMode("STANDARD_LYNX", 4, "standard_lynx");
        STANDARD_LYNX = r104;
        AuthMode r105 = new AuthMode("STANDARD_LYNX_FORCE_PRIVATE", 5, "standard_lynx_force_private");
        STANDARD_LYNX_FORCE_PRIVATE = r105;
        f246008a = new AuthMode[]{r100, r101, r102, r103, r104, r105};
    }

    public final String getDesc() {
        return this.desc;
    }

    public AuthMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
