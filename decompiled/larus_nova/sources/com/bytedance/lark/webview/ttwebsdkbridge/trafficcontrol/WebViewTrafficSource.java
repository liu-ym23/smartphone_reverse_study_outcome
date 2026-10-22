package com.bytedance.lark.webview.ttwebsdkbridge.trafficcontrol;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/webview/ttwebsdkbridge/trafficcontrol/WebViewTrafficSource;", "", "<init>", "(Ljava/lang/String;I)V", "RESOURCE", "SERVICE_WORKER", "ttwebsdk-bridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WebViewTrafficSource extends Enum<WebViewTrafficSource> {
    public static final WebViewTrafficSource RESOURCE = null;
    public static final WebViewTrafficSource SERVICE_WORKER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebViewTrafficSource[] f254475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254476b = null;

    public static EnumEntries<WebViewTrafficSource> getEntries() {
        return f254476b;
    }

    static {
        WebViewTrafficSource r100 = new WebViewTrafficSource("RESOURCE", 0);
        RESOURCE = r100;
        WebViewTrafficSource r101 = new WebViewTrafficSource("SERVICE_WORKER", 1);
        SERVICE_WORKER = r101;
        WebViewTrafficSource[] r102 = {r100, r101};
        f254475a = r102;
        f254476b = EnumEntriesKt.enumEntries(r102);
    }

    public static WebViewTrafficSource[] values() {
        return (WebViewTrafficSource[]) f254475a.clone();
    }

    public static WebViewTrafficSource valueOf(String r100) {
        return (WebViewTrafficSource) a.a(WebViewTrafficSource.class, r100);
    }

    public WebViewTrafficSource(String r100, int r101) {
        super(r100, r101);
    }
}
