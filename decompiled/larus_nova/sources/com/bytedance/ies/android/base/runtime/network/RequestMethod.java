package com.bytedance.ies.android.base.runtime.network;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.IAdNetworkDepend", imports = {}))
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/network/RequestMethod;", "", "GET", "POST", "HEAD", HttpMethod.DOWNLOAD, "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public final enum RequestMethod extends Enum<RequestMethod> {
    public static final RequestMethod DOWNLOAD = null;
    public static final RequestMethod GET = null;
    public static final RequestMethod HEAD = null;
    public static final RequestMethod POST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestMethod[] f245618a = null;

    static {
        RequestMethod r100 = new RequestMethod("GET", 0);
        GET = r100;
        RequestMethod r101 = new RequestMethod("POST", 1);
        POST = r101;
        RequestMethod r102 = new RequestMethod("HEAD", 2);
        HEAD = r102;
        RequestMethod r103 = new RequestMethod(HttpMethod.DOWNLOAD, 3);
        DOWNLOAD = r103;
        f245618a = new RequestMethod[]{r100, r101, r102, r103};
    }

    public static RequestMethod valueOf(String r100) {
        return (RequestMethod) a.a(RequestMethod.class, r100);
    }

    public static RequestMethod[] values() {
        return (RequestMethod[]) f245618a.clone();
    }

    public RequestMethod(String r100, int r101) {
        super(r100, r101);
    }
}
