package com.bytedance.caijing.sdk.infra.base.api.hybridkit;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/hybridkit/ContainerType;", "", "", "isUnknown", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "host", "getHost", "H5", "Lynx", "Unknown", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType H5 = null;
    public static final ContainerType Lynx = null;
    public static final ContainerType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f202228a = null;
    private final String desc;
    private final String host;

    public static ContainerType valueOf(String r100) {
        return (ContainerType) a.a(ContainerType.class, r100);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f202228a.clone();
    }

    static {
        ContainerType r100 = new ContainerType("H5", 0, "web", "cjpay_webview");
        H5 = r100;
        ContainerType r101 = new ContainerType("Lynx", 1, "lynx", "cjpay_lynxview");
        Lynx = r101;
        ContainerType r102 = new ContainerType("Unknown", 2, "unknown", null, 2, null);
        Unknown = r102;
        f202228a = new ContainerType[]{r100, r101, r102};
    }

    public final boolean isUnknown() {
        if (this != Unknown) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getHost() {
        return this.host;
    }

    public ContainerType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.desc = r102;
        this.host = r103;
    }

    public /* synthetic */ ContainerType(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "";
    L5:
        this(r100, r101, r102, r103);
    }
}
