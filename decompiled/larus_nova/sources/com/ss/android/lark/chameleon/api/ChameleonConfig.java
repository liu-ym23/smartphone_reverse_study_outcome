package com.ss.android.lark.chameleon.api;

import com.bytedance.locallife.cube.PrefetchTiming;
import com.heytap.mcssdk.constant.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 E2\u00020\u0001:\u0002DEBq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\b\u0010C\u001a\u00020\u0003H\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006F"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "Ljava/io/Serializable;", "bizName", "", "loadUrl", PrefetchTiming.ROUTER, "Lcom/ss/android/lark/chameleon/api/RouteConfig;", "resConfig", "Lcom/ss/android/lark/chameleon/api/ResConfig;", "resInterceptConfig", "Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "preloadConfig", "Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "openConfig", "Lcom/ss/android/lark/chameleon/api/OpenConfig;", "webviewConfig", "Lcom/ss/android/lark/chameleon/api/WebviewConfig;", b.f276371u, "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/RouteConfig;Lcom/ss/android/lark/chameleon/api/ResConfig;Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;Lcom/ss/android/lark/chameleon/api/PreloadConfig;Lcom/ss/android/lark/chameleon/api/OpenConfig;Lcom/ss/android/lark/chameleon/api/WebviewConfig;Ljava/lang/String;)V", "getAppID", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "getBizName", "setBizName", "getLoadUrl", "setLoadUrl", "getOpenConfig", "()Lcom/ss/android/lark/chameleon/api/OpenConfig;", "setOpenConfig", "(Lcom/ss/android/lark/chameleon/api/OpenConfig;)V", "getPreloadConfig", "()Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "setPreloadConfig", "(Lcom/ss/android/lark/chameleon/api/PreloadConfig;)V", "getResConfig", "()Lcom/ss/android/lark/chameleon/api/ResConfig;", "setResConfig", "(Lcom/ss/android/lark/chameleon/api/ResConfig;)V", "getResInterceptConfig", "()Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "setResInterceptConfig", "(Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;)V", "getRouter", "()Lcom/ss/android/lark/chameleon/api/RouteConfig;", "setRouter", "(Lcom/ss/android/lark/chameleon/api/RouteConfig;)V", "getWebviewConfig", "()Lcom/ss/android/lark/chameleon/api/WebviewConfig;", "setWebviewConfig", "(Lcom/ss/android/lark/chameleon/api/WebviewConfig;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Builder", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonConfig implements Serializable {
    public static final Companion Companion = null;
    public static final String STYLE_FULLSCREEN = "fullScreen";
    private String appID;
    private String bizName;
    private String loadUrl;
    private OpenConfig openConfig;
    private PreloadConfig preloadConfig;
    private ResConfig resConfig;
    private ResInterceptConfig resInterceptConfig;
    private RouteConfig router;
    private WebviewConfig webviewConfig;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0006\u00100\u001a\u000201J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010*\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010+R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ChameleonConfig$Builder;", "", "()V", "bizName", "", "getBizName", "()Ljava/lang/String;", "setBizName", "(Ljava/lang/String;)V", "loadUrl", "getLoadUrl", "setLoadUrl", "openConfig", "Lcom/ss/android/lark/chameleon/api/OpenConfig;", "getOpenConfig", "()Lcom/ss/android/lark/chameleon/api/OpenConfig;", "setOpenConfig", "(Lcom/ss/android/lark/chameleon/api/OpenConfig;)V", "preloadConfig", "Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "getPreloadConfig", "()Lcom/ss/android/lark/chameleon/api/PreloadConfig;", "setPreloadConfig", "(Lcom/ss/android/lark/chameleon/api/PreloadConfig;)V", "resConfig", "Lcom/ss/android/lark/chameleon/api/ResConfig;", "getResConfig", "()Lcom/ss/android/lark/chameleon/api/ResConfig;", "setResConfig", "(Lcom/ss/android/lark/chameleon/api/ResConfig;)V", "resInterceptConfig", "Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "getResInterceptConfig", "()Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;", "setResInterceptConfig", "(Lcom/ss/android/lark/chameleon/api/ResInterceptConfig;)V", PrefetchTiming.ROUTER, "Lcom/ss/android/lark/chameleon/api/RouteConfig;", "getRouter", "()Lcom/ss/android/lark/chameleon/api/RouteConfig;", "setRouter", "(Lcom/ss/android/lark/chameleon/api/RouteConfig;)V", "webviewConfig", "Lcom/ss/android/lark/chameleon/api/WebviewConfig;", "getWebviewConfig", "()Lcom/ss/android/lark/chameleon/api/WebviewConfig;", "setWebviewConfig", "(Lcom/ss/android/lark/chameleon/api/WebviewConfig;)V", "build", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private String bizName;
        private String loadUrl;
        private OpenConfig openConfig;
        private PreloadConfig preloadConfig;
        private ResConfig resConfig;
        private ResInterceptConfig resInterceptConfig;
        private RouteConfig router;
        private WebviewConfig webviewConfig;

        public Builder() {
        }

        public final ChameleonConfig build() {
            return new ChameleonConfig(this.bizName, this.loadUrl, this.router, this.resConfig, this.resInterceptConfig, this.preloadConfig, this.openConfig, this.webviewConfig, null, 256, null);
        }

        public final String getBizName() {
            return this.bizName;
        }

        public final String getLoadUrl() {
            return this.loadUrl;
        }

        public final OpenConfig getOpenConfig() {
            return this.openConfig;
        }

        public final PreloadConfig getPreloadConfig() {
            return this.preloadConfig;
        }

        public final ResConfig getResConfig() {
            return this.resConfig;
        }

        public final ResInterceptConfig getResInterceptConfig() {
            return this.resInterceptConfig;
        }

        public final RouteConfig getRouter() {
            return this.router;
        }

        public final WebviewConfig getWebviewConfig() {
            return this.webviewConfig;
        }

        public final Builder bizName(String r100) {
            this.bizName = r100;
            return this;
        }

        public final Builder loadUrl(String r100) {
            this.loadUrl = r100;
            return this;
        }

        public final Builder openConfig(OpenConfig r100) {
            this.openConfig = r100;
            return this;
        }

        public final Builder preloadConfig(PreloadConfig r100) {
            this.preloadConfig = r100;
            return this;
        }

        public final Builder resConfig(ResConfig r100) {
            this.resConfig = r100;
            return this;
        }

        public final Builder resInterceptConfig(ResInterceptConfig r100) {
            this.resInterceptConfig = r100;
            return this;
        }

        public final Builder router(RouteConfig r100) {
            this.router = r100;
            return this;
        }

        public final void setBizName(String r100) {
            this.bizName = r100;
        }

        public final void setLoadUrl(String r100) {
            this.loadUrl = r100;
        }

        public final void setOpenConfig(OpenConfig r100) {
            this.openConfig = r100;
        }

        public final void setPreloadConfig(PreloadConfig r100) {
            this.preloadConfig = r100;
        }

        public final void setResConfig(ResConfig r100) {
            this.resConfig = r100;
        }

        public final void setResInterceptConfig(ResInterceptConfig r100) {
            this.resInterceptConfig = r100;
        }

        public final void setRouter(RouteConfig r100) {
            this.router = r100;
        }

        public final void setWebviewConfig(WebviewConfig r100) {
            this.webviewConfig = r100;
        }

        public final Builder webviewConfig(WebviewConfig r100) {
            this.webviewConfig = r100;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ChameleonConfig$Companion;", "", "()V", "STYLE_FULLSCREEN", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public ChameleonConfig() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ ChameleonConfig copy$default(ChameleonConfig r110, String r111, String r112, RouteConfig r113, ResConfig r114, ResInterceptConfig r115, PreloadConfig r116, OpenConfig r117, WebviewConfig r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.bizName;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.loadUrl;
    L11:
        if ((r210 & 4) == 0) goto L13;
        RouteConfig r102 = r110.router;
    L15:
        if ((r210 & 8) == 0) goto L17;
        ResConfig r103 = r110.resConfig;
    L19:
        if ((r210 & 16) == 0) goto L21;
        ResInterceptConfig r104 = r110.resInterceptConfig;
    L23:
        if ((r210 & 32) == 0) goto L25;
        PreloadConfig r105 = r110.preloadConfig;
    L27:
        if ((r210 & 64) == 0) goto L29;
        OpenConfig r106 = r110.openConfig;
    L31:
        if ((r210 & 128) == 0) goto L33;
        WebviewConfig r107 = r110.webviewConfig;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.appID;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.bizName;
    }

    public final String component2() {
        return this.loadUrl;
    }

    public final RouteConfig component3() {
        return this.router;
    }

    public final ResConfig component4() {
        return this.resConfig;
    }

    public final ResInterceptConfig component5() {
        return this.resInterceptConfig;
    }

    public final PreloadConfig component6() {
        return this.preloadConfig;
    }

    public final OpenConfig component7() {
        return this.openConfig;
    }

    public final WebviewConfig component8() {
        return this.webviewConfig;
    }

    public final String component9() {
        return this.appID;
    }

    public final ChameleonConfig copy(String r110, String r111, RouteConfig r112, ResConfig r113, ResInterceptConfig r114, PreloadConfig r115, OpenConfig r116, WebviewConfig r117, String r210) {
        return new ChameleonConfig(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChameleonConfig) == true) goto L8;
        return false;
    L8:
        ChameleonConfig r101 = (ChameleonConfig) r100;
        if (Intrinsics.areEqual(this.bizName, r101.bizName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.loadUrl, r101.loadUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.router, r101.router) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resConfig, r101.resConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resInterceptConfig, r101.resInterceptConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.preloadConfig, r101.preloadConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.openConfig, r101.openConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.webviewConfig, r101.webviewConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.appID, r101.appID) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.bizName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.loadUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        RouteConfig r107 = this.router;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ResConfig r110 = this.resConfig;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ResInterceptConfig r113 = this.resInterceptConfig;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        PreloadConfig r116 = this.preloadConfig;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        OpenConfig r119 = this.openConfig;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        WebviewConfig r122 = this.webviewConfig;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.appID;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ChameleonConfig(bizName=" + this.bizName + ", loadUrl=" + this.loadUrl + ", router=" + this.router + ", resConfig=" + this.resConfig + ", resInterceptConfig=" + this.resInterceptConfig + ", preloadConfig=" + this.preloadConfig + ", openConfig=" + this.openConfig + ", webviewConfig=" + this.webviewConfig + ", appID=" + this.appID + ')';
    }

    public final String getAppID() {
        return this.appID;
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final String getLoadUrl() {
        return this.loadUrl;
    }

    public final OpenConfig getOpenConfig() {
        return this.openConfig;
    }

    public final PreloadConfig getPreloadConfig() {
        return this.preloadConfig;
    }

    public final ResConfig getResConfig() {
        return this.resConfig;
    }

    public final ResInterceptConfig getResInterceptConfig() {
        return this.resInterceptConfig;
    }

    public final RouteConfig getRouter() {
        return this.router;
    }

    public final WebviewConfig getWebviewConfig() {
        return this.webviewConfig;
    }

    public final void setAppID(String r100) {
        this.appID = r100;
    }

    public final void setBizName(String r100) {
        this.bizName = r100;
    }

    public final void setLoadUrl(String r100) {
        this.loadUrl = r100;
    }

    public final void setOpenConfig(OpenConfig r100) {
        this.openConfig = r100;
    }

    public final void setPreloadConfig(PreloadConfig r100) {
        this.preloadConfig = r100;
    }

    public final void setResConfig(ResConfig r100) {
        this.resConfig = r100;
    }

    public final void setResInterceptConfig(ResInterceptConfig r100) {
        this.resInterceptConfig = r100;
    }

    public final void setRouter(RouteConfig r100) {
        this.router = r100;
    }

    public final void setWebviewConfig(WebviewConfig r100) {
        this.webviewConfig = r100;
    }

    public ChameleonConfig(String r100, String r101, RouteConfig r102, ResConfig r103, ResInterceptConfig r104, PreloadConfig r105, OpenConfig r106, WebviewConfig r107, String r108) {
        this.bizName = r100;
        this.loadUrl = r101;
        this.router = r102;
        this.resConfig = r103;
        this.resInterceptConfig = r104;
        this.preloadConfig = r105;
        this.openConfig = r106;
        this.webviewConfig = r107;
        this.appID = r108;
    }

    public /* synthetic */ ChameleonConfig(String r110, String r111, RouteConfig r112, ResConfig r113, ResInterceptConfig r114, PreloadConfig r115, OpenConfig r116, WebviewConfig r117, String r118, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        RouteConfig r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        ResConfig r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        ResInterceptConfig r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        PreloadConfig r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        OpenConfig r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        WebviewConfig r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
