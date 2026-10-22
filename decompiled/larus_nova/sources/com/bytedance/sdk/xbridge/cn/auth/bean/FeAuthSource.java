package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthSource;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "NULL", "CONTENT", "CONTENT_V2", "PRIVATE_DOMAINS", "CONTENT_DEGRADE", "CLOSE_AUTH_URL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum FeAuthSource extends Enum<FeAuthSource> {
    public static final FeAuthSource CLOSE_AUTH_URL = null;
    public static final FeAuthSource CONTENT = null;
    public static final FeAuthSource CONTENT_DEGRADE = null;
    public static final FeAuthSource CONTENT_V2 = null;
    public static final FeAuthSource NULL = null;
    public static final FeAuthSource PRIVATE_DOMAINS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeAuthSource[] f269829a = null;
    private final String desc;

    public static FeAuthSource valueOf(String r100) {
        return (FeAuthSource) a.a(FeAuthSource.class, r100);
    }

    public static FeAuthSource[] values() {
        return (FeAuthSource[]) f269829a.clone();
    }

    static {
        FeAuthSource r100 = new FeAuthSource("NULL", 0, "null");
        NULL = r100;
        FeAuthSource r101 = new FeAuthSource("CONTENT", 1, "content");
        CONTENT = r101;
        FeAuthSource r102 = new FeAuthSource("CONTENT_V2", 2, "content_v2");
        CONTENT_V2 = r102;
        FeAuthSource r103 = new FeAuthSource("PRIVATE_DOMAINS", 3, "private_domains");
        PRIVATE_DOMAINS = r103;
        FeAuthSource r104 = new FeAuthSource("CONTENT_DEGRADE", 4, "content_degrade");
        CONTENT_DEGRADE = r104;
        FeAuthSource r105 = new FeAuthSource("CLOSE_AUTH_URL", 5, "close_auth_url");
        CLOSE_AUTH_URL = r105;
        f269829a = new FeAuthSource[]{r100, r101, r102, r103, r104, r105};
    }

    public final String getDesc() {
        return this.desc;
    }

    public FeAuthSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
