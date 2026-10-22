package com.ss.android.lark.chameleon;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vv4.m;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\"\u001a\u00020\u0000J\b\u0010#\u001a\u00020\u0007H\u0016J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J?\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, d2 = {"Lcom/ss/android/lark/chameleon/WebviewConfig;", "Ljava/io/Serializable;", "webViewPoolConfig", "Lcom/ss/android/lark/chameleon/WebViewPoolConfig;", "webService", "Lcom/ss/android/lark/chameleon/IWebService;", "bizUAgent", "", "larkApiEnable", "", "jsbAuthConfig", "Lcom/ss/android/lark/chameleon/JsbAuthConfig;", "<init>", "(Lcom/ss/android/lark/chameleon/WebViewPoolConfig;Lcom/ss/android/lark/chameleon/IWebService;Ljava/lang/String;ZLcom/ss/android/lark/chameleon/JsbAuthConfig;)V", "getWebViewPoolConfig", "()Lcom/ss/android/lark/chameleon/WebViewPoolConfig;", "setWebViewPoolConfig", "(Lcom/ss/android/lark/chameleon/WebViewPoolConfig;)V", "getWebService", "()Lcom/ss/android/lark/chameleon/IWebService;", "setWebService", "(Lcom/ss/android/lark/chameleon/IWebService;)V", "getBizUAgent", "()Ljava/lang/String;", "setBizUAgent", "(Ljava/lang/String;)V", "getLarkApiEnable", "()Z", "setLarkApiEnable", "(Z)V", "getJsbAuthConfig", "()Lcom/ss/android/lark/chameleon/JsbAuthConfig;", "setJsbAuthConfig", "(Lcom/ss/android/lark/chameleon/JsbAuthConfig;)V", "copy", "toString", "component1", "component2", "component3", "component4", "component5", "equals", "other", "", "hashCode", "", "Companion", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebviewConfig implements Serializable {
    public static final Companion Companion = null;
    public static final long DEFAULT_ALIVE_DURATION = 300000;
    public static final int DEFAULT_MAX_REUSE_TIMES = 10;
    private String bizUAgent;
    private JsbAuthConfig jsbAuthConfig;
    private boolean larkApiEnable;
    private IWebService webService;
    private WebViewPoolConfig webViewPoolConfig;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/WebviewConfig$Companion;", "", "<init>", "()V", "DEFAULT_ALIVE_DURATION", "", "DEFAULT_MAX_REUSE_TIMES", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        this(null, null, null, false, null, 31, null);
    }

    public static /* synthetic */ WebviewConfig copy$default(WebviewConfig r100, WebViewPoolConfig r101, IWebService r102, String r103, boolean r104, JsbAuthConfig r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.webViewPoolConfig;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.webService;
    L8:
        IWebService r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.bizUAgent;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.larkApiEnable;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.jsbAuthConfig;
    L17:
        WebViewPoolConfig r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    public final boolean component4() {
        return this.larkApiEnable;
    }

    public final JsbAuthConfig component5() {
        return this.jsbAuthConfig;
    }

    public final WebviewConfig copy(WebViewPoolConfig r100, IWebService r101, String r110, boolean r111, JsbAuthConfig r112) {
        Intrinsics.checkNotNullParameter(r110, "bizUAgent");
        Intrinsics.checkNotNullParameter(r112, "jsbAuthConfig");
        return new WebviewConfig(r100, r101, r110, r111, r112);
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
        if (Intrinsics.areEqual(this.bizUAgent, r101.bizUAgent) == true) goto L18;
        return false;
    L18:
        if (this.larkApiEnable == r101.larkApiEnable) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.jsbAuthConfig, r101.jsbAuthConfig) == true) goto L23;
        return false;
    L23:
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
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.bizUAgent.hashCode()) * 31;
        if (this.larkApiEnable == false) goto L13;
        int r106 = 1231;
    L15:
        return ((r105 + r106) * 31) + this.jsbAuthConfig.hashCode();
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final WebviewConfig copy() {
        WebViewPoolConfig r100 = this.webViewPoolConfig;
        if (r100 == null) goto L5;
        WebViewPoolConfig r101 = r100.copy();
    L7:
        return new WebviewConfig(r101, this.webService, this.bizUAgent, this.larkApiEnable, this.jsbAuthConfig.copy());
    L5:
        r101 = null;
        goto L7
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("WebviewConfig(webViewPoolConfig=");
        r100.append(this.webViewPoolConfig);
        r100.append(", bizUAgent=");
        r100.append(this.bizUAgent);
        r100.append(", larkApiEnable=");
        r100.append(this.larkApiEnable);
        r100.append(", webService=");
        IWebService r101 = this.webService;
        if (r101 == null) goto L7;
        List<? extends m> r102 = r101.getWebService();
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

    public final JsbAuthConfig getJsbAuthConfig() {
        return this.jsbAuthConfig;
    }

    public final boolean getLarkApiEnable() {
        return this.larkApiEnable;
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

    public final void setJsbAuthConfig(JsbAuthConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jsbAuthConfig = r100;
    }

    public final void setLarkApiEnable(boolean r100) {
        this.larkApiEnable = r100;
    }

    public final void setWebService(IWebService r100) {
        this.webService = r100;
    }

    public final void setWebViewPoolConfig(WebViewPoolConfig r100) {
        this.webViewPoolConfig = r100;
    }

    public WebviewConfig(WebViewPoolConfig r100, IWebService r101, String r102, boolean r103, JsbAuthConfig r104) {
        Intrinsics.checkNotNullParameter(r102, "bizUAgent");
        Intrinsics.checkNotNullParameter(r104, "jsbAuthConfig");
        this.webViewPoolConfig = r100;
        this.webService = r101;
        this.bizUAgent = r102;
        this.larkApiEnable = r103;
        this.jsbAuthConfig = r104;
    }

    public /* synthetic */ WebviewConfig(WebViewPoolConfig r110, IWebService r111, String r112, boolean r113, JsbAuthConfig r114, int r115, DefaultConstructorMarker r116) {
        IWebService r100 = null;
        if ((r115 & 1) == 0) goto L5;
        WebViewPoolConfig r101 = null;
    L7:
        if ((r115 & 2) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r115 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r115 & 8) == 0) goto L17;
        boolean r103 = true;
    L19:
        if ((r115 & 16) == 0) goto L21;
        JsbAuthConfig r104 = new JsbAuthConfig(false, false, null, 7, null);
    L22:
        this(r101, r100, r102, r103, r104);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
