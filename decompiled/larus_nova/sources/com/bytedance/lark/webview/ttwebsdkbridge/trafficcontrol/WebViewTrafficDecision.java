package com.bytedance.lark.webview.ttwebsdkbridge.trafficcontrol;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/webview/ttwebsdkbridge/trafficcontrol/WebViewTrafficDecision;", "", "<init>", "(Ljava/lang/String;I)V", "PASS", "BLOCK", "ttwebsdk-bridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WebViewTrafficDecision extends Enum<WebViewTrafficDecision> {
    public static final WebViewTrafficDecision BLOCK = null;
    public static final WebViewTrafficDecision PASS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebViewTrafficDecision[] f254473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f254474b = null;

    public static EnumEntries<WebViewTrafficDecision> getEntries() {
        return f254474b;
    }

    static {
        WebViewTrafficDecision r100 = new WebViewTrafficDecision("PASS", 0);
        PASS = r100;
        WebViewTrafficDecision r101 = new WebViewTrafficDecision("BLOCK", 1);
        BLOCK = r101;
        WebViewTrafficDecision[] r102 = {r100, r101};
        f254473a = r102;
        f254474b = EnumEntriesKt.enumEntries(r102);
    }

    public static WebViewTrafficDecision[] values() {
        return (WebViewTrafficDecision[]) f254473a.clone();
    }

    public static WebViewTrafficDecision valueOf(String r100) {
        return (WebViewTrafficDecision) a.a(WebViewTrafficDecision.class, r100);
    }

    public WebViewTrafficDecision(String r100, int r101) {
        super(r100, r101);
    }
}
