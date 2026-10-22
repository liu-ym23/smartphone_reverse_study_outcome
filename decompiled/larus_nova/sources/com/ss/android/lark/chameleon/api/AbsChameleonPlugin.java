package com.ss.android.lark.chameleon.api;

import android.content.Context;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonContextAbility;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.pluginsystem.WebFragment;
import com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.BridgeInteractivePlugin;
import com.ss.android.lark.chameleon.util.JsonUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ \u0010\r\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000ej\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f`\u0010H\u0016J \u0010\r\u001a\u00020\n2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0018\u001a\u00020\u0013R\u0015\u0010\u0005\u001a\u00060\u0006R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/BasePlugin;", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/lazy/BridgeInteractivePlugin;", "()V", "webviewHandlerContext", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin$WebviewHandlerContext;", "getWebviewHandlerContext", "()Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin$WebviewHandlerContext;", "callbackOk", "", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "getBridgeHandlers", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonHandler;", "Lkotlin/collections/ArrayList;", "handlersHolder", "", "", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "getChameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "getSession", "getUrl", "Companion", "LarkAPIEvent", "WebviewHandlerContext", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbsChameleonPlugin extends BasePlugin<ChameleonPluginHost> implements BridgeInteractivePlugin {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_AbsChameleonPlugin";
    private final WebviewHandlerContext webviewHandlerContext;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin$Companion;", "", "()V", "TAG", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\u000e\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\b\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin$LarkAPIEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Lcom/ss/android/lark/chameleon/bridge/NonProguard;", "type", "", "sender", "", "detail", "(Ljava/lang/String;ILjava/io/Serializable;)V", "getDetail", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "getSender", "()I", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ILjava/io/Serializable;)Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin$LarkAPIEvent;", "equals", "", "other", "", "hashCode", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LarkAPIEvent<T extends Serializable> implements NonProguard {

        @SerializedName("detail")
        private final T detail;

        @SerializedName("sender")
        private final int sender;

        @SerializedName("type")
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LarkAPIEvent copy$default(LarkAPIEvent r100, String r101, int r102, Serializable r103, int r104, Object r105) {
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

        public final LarkAPIEvent<T> copy(String r100, int r101, T r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r102, "detail");
            return new LarkAPIEvent(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof LarkAPIEvent) == true) goto L8;
            return false;
        L8:
            LarkAPIEvent r101 = (LarkAPIEvent) r100;
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
            return "LarkAPIEvent(type=" + this.type + ", sender=" + this.sender + ", detail=" + this.detail + ')';
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

        public LarkAPIEvent(String r100, int r101, T r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r102, "detail");
            this.type = r100;
            this.sender = r101;
            this.detail = r102;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J'\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u0002H\u0014H\u0016¢\u0006\u0002\u0010\u0018R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin$WebviewHandlerContext;", "Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;", "(Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;)V", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", WidgetService.PARAM_FRAGMENT, "Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "getFragment", "()Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "webviewLoader", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "getWebviewLoader", "()Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "getBizName", "", "getSession", "sendEvent", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "type", "data", "(Ljava/lang/String;Ljava/io/Serializable;)V", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class WebviewHandlerContext implements IChameleonHandlerContext {
        final /* synthetic */ AbsChameleonPlugin this$0;

        @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
        public Context getAppContext() {
            return AbsChameleonPlugin.access$getContext(this.this$0);
        }

        @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
        public String getBizName() {
            String r100 = this.this$0.getChameleonConfig().getBizName();
            if (r100 != null) goto L6;
            return "";
        L6:
            return r100;
        }

        @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
        public WebFragment getFragment() {
            ChameleonPluginHost r100 = this.this$0.getHost();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getFragment();
        }

        @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
        public String getSession() {
            ChameleonPluginHost r100 = this.this$0.getHost();
            if (r100 == null) goto L6;
            String r101 = r100.getSession();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
        public IChameleonLoader getWebviewLoader() {
            ChameleonPluginHost r100 = this.this$0.getHost();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getLoader();
        }

        public WebviewHandlerContext(AbsChameleonPlugin r100) {
            this.this$0 = r100;
        }

        @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
        public <T extends Serializable> void sendEvent(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "data");
            ChameleonPluginHost r102 = this.this$0.getHost();
            if (r102 == null) goto L10;
            Web r103 = r102.getWeb();
            if (r103 == null) goto L11;
            WebView r104 = r103.getWebView();
            if (r104 == null) goto L12;
            r104.evaluateJavascript(StringsKt.trimIndent("\n                javascript:LarkWebViewJavaScriptBridge.nativeCallBack({\n                  callbackID: 'LarkAPI.ipc.event',\n                  callbackType: 'continued',\n                  data: " + JsonUtils.INSTANCE.toJsonString(new LarkAPIEvent(r100, -1, r101)) + ",\n                })\n            "), null);
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

    public final String getUrl() {
        return ((ChameleonContextAbility) getHost().getHostAbility(ChameleonContextAbility.class)).getUrl();
    }

    public final WebviewHandlerContext getWebviewHandlerContext() {
        return this.webviewHandlerContext;
    }

    public static final /* synthetic */ Context access$getContext(AbsChameleonPlugin r100) {
        return r100.getContext();
    }

    public final void callbackOk(CallBackFunction r100) {
        if (r100 == null) goto L10;
        JsonObject r101 = new JsonObject();     // Catch: Throwable -> L5
        r101.addProperty("result", Boolean.TRUE);     // Catch: Throwable -> L5
        r100.onCallBack(r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("CML_TAG_AbsChameleonPlugin", th.toString());
        return;
    }

    public void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r100) {
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
