package com.ss.android.lark.chameleon;

import android.content.Context;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.officesdk.utils.di.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.i;
import vv4.k;
import vv4.m;
import yv4.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001a\u001b\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\rH\u0016J \u0010\n\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011`\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0015\u0010\u0006\u001a\u00060\u0007R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/lazy/BridgeInteractivePlugin;", "<init>", "()V", "webviewHandlerContext", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$WebviewHandlerContext;", "getWebviewHandlerContext", "()Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$WebviewHandlerContext;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleon/AbsChameleonHandler;", "Lkotlin/collections/ArrayList;", "getUrl", "getChameleonConfig", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "getSession", "callbackOk", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "Companion", "WebviewHandlerContext", "LKAPIEvent", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsChameleonPlugin extends BasePlugin<ChameleonPluginHost> implements a {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_AbsChameleonPlugin";
    private final WebviewHandlerContext webviewHandlerContext;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$Companion;", "", "<init>", "()V", "TAG", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$LKAPIEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "type", "", "sender", "", "detail", "<init>", "(Ljava/lang/String;ILjava/io/Serializable;)V", "getType", "()Ljava/lang/String;", "getSender", "()I", "getDetail", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ILjava/io/Serializable;)Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$LKAPIEvent;", "equals", "", "other", "", "hashCode", "toString", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LKAPIEvent<T extends Serializable> implements NonProguard {

        @SerializedName("detail")
        private final T detail;

        @SerializedName("sender")
        private final int sender;

        @SerializedName("type")
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LKAPIEvent copy$default(LKAPIEvent r100, String r101, int r102, Serializable r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.type;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.sender;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.detail;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.type;
        }

        public final int component2() {
            return this.sender;
        }

        public final T component3() {
            return this.detail;
        }

        public final LKAPIEvent<T> copy(String r100, int r101, T r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r102, "detail");
            return new LKAPIEvent(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LKAPIEvent) == true) goto L8;
            return false;
        L8:
            LKAPIEvent r101 = (LKAPIEvent) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
            return false;
        L12:
            if (this.sender == r101.sender) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.detail, r101.detail) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + this.sender) * 31) + this.detail.hashCode();
        }

        public String toString() {
            return "LKAPIEvent(type=" + this.type + ", sender=" + this.sender + ", detail=" + this.detail + ')';
        }

        public final T getDetail() {
            return this.detail;
        }

        public final int getSender() {
            return this.sender;
        }

        public final String getType() {
            return this.type;
        }

        public LKAPIEvent(String r100, int r101, T r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r102, "detail");
            this.type = r100;
            this.sender = r101;
            this.detail = r102;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J'\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u0002H\u0011H\u0016¢\u0006\u0002\u0010\u0015R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$WebviewHandlerContext;", "Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", "<init>", "(Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;)V", "getCmlContext", "Landroid/content/Context;", "getFragment", "Landroidx/fragment/app/Fragment;", "webviewLoader", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getWebviewLoader", "()Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getSession", "", "getBizName", "sendEvent", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "type", "data", "(Ljava/lang/String;Ljava/io/Serializable;)V", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class WebviewHandlerContext implements IChameleonHandlerContext {
        final /* synthetic */ AbsChameleonPlugin this$0;

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public Context getCmlContext() {
            return AbsChameleonPlugin.access$getContext(this.this$0);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public Fragment getFragment() {
            ChameleonPluginHost r100 = this.this$0.getHost();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getFragment();
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public String getSession() {
            ChameleonPluginHost r100 = this.this$0.getHost();
            if (r100 == null) goto L6;
            String r101 = r100.getSession();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public IChameleonLoader getWebviewLoader() {
            ChameleonPluginHost r100 = this.this$0.getHost();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getLoader();
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public String getBizName() {
            ChameleonConfig r100 = getChameleonConfig();
            if (r100 == null) goto L6;
            String r101 = r100.getBizName();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public ChameleonConfig getChameleonConfig() {
            return IChameleonHandlerContext.DefaultImpls.getChameleonConfig(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public WebView getWebview() {
            return IChameleonHandlerContext.DefaultImpls.getWebview(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public void destroyWebview() {
            IChameleonHandlerContext.DefaultImpls.destroyWebview(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public void reloadWebview() {
            IChameleonHandlerContext.DefaultImpls.reloadWebview(this);
        }

        public WebviewHandlerContext(AbsChameleonPlugin r100) {
            this.this$0 = r100;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public <T extends m> T getWebService(Class<T> r100) {
            return (T) IChameleonHandlerContext.DefaultImpls.getWebService(this, r100);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public <T extends Serializable> void sendEvent(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "data");
            ChameleonPluginHost r102 = this.this$0.getHost();
            if (r102 == null) goto L10;
            k r103 = r102.getWeb();
            if (r103 == null) goto L11;
            WebView r104 = r103.getWebView();
            if (r104 == null) goto L12;
            r104.evaluateJavascript(StringsKt.trimIndent("\n                javascript:LarkWebViewJavaScriptBridge.nativeCallBack({\n                  callbackID: 'LarkAPI.ipc.event',\n                  callbackType: 'continued',\n                  data: " + swb.k.b(new LKAPIEvent(r100, -1, r101)) + ",\n                })\n            "), null);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public ArrayList<AbsChameleonHandler<?>> getBridgeHandlers() {
        return new ArrayList();
    }

    public AbsChameleonPlugin() {
        this.webviewHandlerContext = new WebviewHandlerContext(this);
    }

    public final ChameleonConfig getChameleonConfig() {
        return ((ChameleonContextAbility) getHost().getHostAbility(ChameleonContextAbility.class)).getChameleonConfig();
    }

    public final String getSession() {
        return ((ChameleonContextAbility) getHost().getHostAbility(ChameleonContextAbility.class)).getSession();
    }

    public String getUrl() {
        return ((ChameleonContextAbility) getHost().getHostAbility(ChameleonContextAbility.class)).getUrl();
    }

    public final WebviewHandlerContext getWebviewHandlerContext() {
        return this.webviewHandlerContext;
    }

    public static final /* synthetic */ Context access$getContext(AbsChameleonPlugin r100) {
        return r100.getContext();
    }

    public final void callbackOk(tb5.m r100) {
        if (r100 == null) goto L10;
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L5
        r101.put("result", Boolean.TRUE);     // Catch: Throwable -> L5
        r100.b(r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        j.d("CML_TAG_AbsChameleonPlugin", th);
        return;
    }

    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        Iterator<AbsChameleonHandler<?>> r101 = getBridgeHandlers().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        AbsChameleonHandler<?> r102 = r101.next();
        r102.setContext(this.webviewHandlerContext);
        r100.put(r102.getName(), r102);
        goto L4
    }
}
