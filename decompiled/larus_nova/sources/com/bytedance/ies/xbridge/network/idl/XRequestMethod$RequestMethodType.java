package com.bytedance.ies.xbridge.network.idl;

import com.alipay.sdk.m.p.e;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"com/bytedance/ies/xbridge/network/idl/XRequestMethod$RequestMethodType", "", "Lcom/bytedance/ies/xbridge/network/idl/XRequestMethod$RequestMethodType;", "", e.f25671s, "Ljava/lang/String;", "getMethod", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GET", "POST", "PUT", "DELETE", "UNSUPPORTED", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XRequestMethod$RequestMethodType extends Enum<XRequestMethod$RequestMethodType> {
    public static final a Companion = null;
    public static final XRequestMethod$RequestMethodType DELETE = null;
    public static final XRequestMethod$RequestMethodType GET = null;
    public static final XRequestMethod$RequestMethodType POST = null;
    public static final XRequestMethod$RequestMethodType PUT = null;
    public static final XRequestMethod$RequestMethodType UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XRequestMethod$RequestMethodType[] f249511a = null;
    private final String method;

    public static XRequestMethod$RequestMethodType valueOf(String r100) {
        return (XRequestMethod$RequestMethodType) r27.a.a(XRequestMethod$RequestMethodType.class, r100);
    }

    public static XRequestMethod$RequestMethodType[] values() {
        return (XRequestMethod$RequestMethodType[]) f249511a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ies.xbridge.network.idl.XRequestMethod$RequestMethodType$a] */
    static {
        XRequestMethod$RequestMethodType r100 = new XRequestMethod$RequestMethodType("GET", 0, MonitorConstants.CONNECT_TYPE_GET);
        GET = r100;
        XRequestMethod$RequestMethodType r101 = new XRequestMethod$RequestMethodType("POST", 1, UGCMonitor.TYPE_POST);
        POST = r101;
        XRequestMethod$RequestMethodType r102 = new XRequestMethod$RequestMethodType("PUT", 2, "put");
        PUT = r102;
        XRequestMethod$RequestMethodType r103 = new XRequestMethod$RequestMethodType("DELETE", 3, "delete");
        DELETE = r103;
        XRequestMethod$RequestMethodType r104 = new XRequestMethod$RequestMethodType("UNSUPPORTED", 4, "unsupported");
        UNSUPPORTED = r104;
        f249511a = new XRequestMethod$RequestMethodType[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public final String getMethod() {
        return this.method;
    }

    public XRequestMethod$RequestMethodType(String r100, int r101, String r102) {
        super(r100, r101);
        this.method = r102;
    }
}
