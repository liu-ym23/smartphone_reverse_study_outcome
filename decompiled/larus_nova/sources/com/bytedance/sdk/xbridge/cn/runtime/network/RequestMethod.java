package com.bytedance.sdk.xbridge.cn.runtime.network;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/network/RequestMethod;", "", "GET", "POST", "PUT", "DELETE", HttpMethod.DOWNLOAD, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum RequestMethod extends Enum<RequestMethod> {
    public static final RequestMethod DELETE = null;
    public static final RequestMethod DOWNLOAD = null;
    public static final RequestMethod GET = null;
    public static final RequestMethod POST = null;
    public static final RequestMethod PUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestMethod[] f270140a = null;

    public static RequestMethod valueOf(String r100) {
        return (RequestMethod) a.a(RequestMethod.class, r100);
    }

    public static RequestMethod[] values() {
        return (RequestMethod[]) f270140a.clone();
    }

    static {
        RequestMethod r100 = new RequestMethod("GET", 0);
        GET = r100;
        RequestMethod r101 = new RequestMethod("POST", 1);
        POST = r101;
        RequestMethod r102 = new RequestMethod("PUT", 2);
        PUT = r102;
        RequestMethod r103 = new RequestMethod("DELETE", 3);
        DELETE = r103;
        RequestMethod r104 = new RequestMethod(HttpMethod.DOWNLOAD, 4);
        DOWNLOAD = r104;
        f270140a = new RequestMethod[]{r100, r101, r102, r103, r104};
    }

    public RequestMethod(String r100, int r101) {
        super(r100, r101);
    }
}
