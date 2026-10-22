package com.ss.android.lark.chameleon.api;

import com.ss.android.lark.chameleon.pluginsystem.WebService;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleon/api/WebviewConfig;", "Ljava/io/Serializable;", "webViewPoolConfig", "Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;", "webService", "Lcom/ss/android/lark/chameleon/api/IWebService;", "bizUAgent", "", "(Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;Lcom/ss/android/lark/chameleon/api/IWebService;Ljava/lang/String;)V", "getBizUAgent", "()Ljava/lang/String;", "setBizUAgent", "(Ljava/lang/String;)V", "getWebService", "()Lcom/ss/android/lark/chameleon/api/IWebService;", "setWebService", "(Lcom/ss/android/lark/chameleon/api/IWebService;)V", "getWebViewPoolConfig", "()Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;", "setWebViewPoolConfig", "(Lcom/ss/android/lark/chameleon/api/WebViewPoolConfig;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WebviewConfig implements Serializable {
    public static final Companion Companion = null;
    public static final long DEFAULT_ALIVE_DURATION = 300000;
    public static final int DEFAULT_MAX_REUSE_TIMES = 10;
    private String bizUAgent;
    private IWebService webService;
    private WebViewPoolConfig webViewPoolConfig;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/api/WebviewConfig$Companion;", "", "()V", "DEFAULT_ALIVE_DURATION", "", "DEFAULT_MAX_REUSE_TIMES", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WebviewConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ WebviewConfig copy$default(WebviewConfig r100, WebViewPoolConfig r101, IWebService r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.webViewPoolConfig;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.webService;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.bizUAgent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final WebViewPoolConfig component1() {
        return this.webViewPoolConfig;
    }

    public final IWebService component2() {
        return this.webService;
    }

    public final String component3() {
        return this.bizUAgent;
    }

    public final WebviewConfig copy(WebViewPoolConfig r100, IWebService r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "bizUAgent");
        return new WebviewConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WebviewConfig) == true) goto L8;
        return false;
    L8:
        WebviewConfig r101 = (WebviewConfig) r100;
        if (Intrinsics.areEqual(this.webViewPoolConfig, r101.webViewPoolConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.webService, r101.webService) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bizUAgent, r101.bizUAgent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        WebViewPoolConfig r100 = this.webViewPoolConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        IWebService r104 = this.webService;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.bizUAgent.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("WebviewConfig(webViewPoolConfig=");
        r100.append(this.webViewPoolConfig);
        r100.append(", bizUAgent=");
        r100.append(this.bizUAgent);
        r100.append(", webService=");
        IWebService r101 = this.webService;
        if (r101 == null) goto L7;
        List<WebService> r102 = r101.getWebService();
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.size());
    L8:
        r100.append(r103);
        r100.append(')');
        return r100.toString();
    L7:
        r103 = null;
        goto L8
    }

    public final String getBizUAgent() {
        return this.bizUAgent;
    }

    public final IWebService getWebService() {
        return this.webService;
    }

    public final WebViewPoolConfig getWebViewPoolConfig() {
        return this.webViewPoolConfig;
    }

    public final void setBizUAgent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bizUAgent = r100;
    }

    public final void setWebService(IWebService r100) {
        this.webService = r100;
    }

    public final void setWebViewPoolConfig(WebViewPoolConfig r100) {
        this.webViewPoolConfig = r100;
    }

    public WebviewConfig(WebViewPoolConfig r100, IWebService r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "bizUAgent");
        this.webViewPoolConfig = r100;
        this.webService = r101;
        this.bizUAgent = r102;
    }

    public /* synthetic */ WebviewConfig(WebViewPoolConfig r100, IWebService r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
