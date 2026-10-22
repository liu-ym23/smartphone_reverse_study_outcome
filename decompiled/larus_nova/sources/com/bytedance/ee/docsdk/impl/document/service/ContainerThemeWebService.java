package com.bytedance.ee.docsdk.impl.document.service;

import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.BaseWebService;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/service/ContainerThemeWebService;", "Lcom/ss/android/lark/chameleon/pluginsystem/BaseWebService;", "()V", "themeHandler", "Lcom/bytedance/ee/docsdk/impl/document/service/ContainerThemeWebService$JSThemeHandler;", "getThemeHandler", "()Lcom/bytedance/ee/docsdk/impl/document/service/ContainerThemeWebService$JSThemeHandler;", "themeHandler$delegate", "Lkotlin/Lazy;", "onAttachToWeb", "", "web", "Lcom/ss/android/lark/chameleon/pluginsystem/Web;", "onDetachFromWeb", "Companion", "JSThemeHandler", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContainerThemeWebService extends BaseWebService {
    public static final Companion Companion = null;
    private static final String TAG = "ContainerThemeWebService";
    public static final String THEME_CONFIG_JSB_NAME = "biz.util.theme";
    public static final String THEME_CONFIG_KEY = "theme";
    public static final String THEME_CONFIG_VALUE_DARK = "dark";
    public static final String THEME_CONFIG_VALUE_LIGHT = "light";
    private final Lazy themeHandler$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/service/ContainerThemeWebService$Companion;", "", "()V", "TAG", "", "THEME_CONFIG_JSB_NAME", "THEME_CONFIG_KEY", "THEME_CONFIG_VALUE_DARK", "THEME_CONFIG_VALUE_LIGHT", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/service/ContainerThemeWebService$JSThemeHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "", "()V", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "handle", "", "data", "notifyDarkMode", "release", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class JSThemeHandler implements BridgeHandlerV2<Object> {
        private CallBackFunction callback;

        public JSThemeHandler() {
        }

        public final void release() {
            Log.i(ContainerThemeWebService.TAG, "JSThemeHandler - release");
            this.callback = null;
        }

        public final void notifyDarkMode() {
            if (Env.isDarkMode() == false) goto L5;
            String r100 = "dark";
        L6:
            Log.i(ContainerThemeWebService.TAG, "JSThemeHandler - notifyDarkMode, currentTheme: ".concat(r100));
            JsonObject r101 = new JsonObject();
            r101.addProperty("theme", r100);
            CallBackFunction r102 = this.callback;
            if (r102 == null) goto L10;
            r102.onCallBack(r101);
            return;
        L10:
            return;
        L5:
            r100 = "light";
            goto L6
        }

        @Override // com.ss.android.lark.chameleon.bridge.JSHandler
        public void handle(Object r100, CallBackFunction r101) {
            if (r101 != null) goto L6;
            Log.e(ContainerThemeWebService.TAG, "JSThemeHandler - handle, callback is null");
            return;
        L6:
            Log.i(ContainerThemeWebService.TAG, "JSThemeHandler - handle");
            this.callback = r101;
            notifyDarkMode();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final JSThemeHandler getThemeHandler() {
        return (JSThemeHandler) this.themeHandler$delegate.getValue();
    }

    public ContainerThemeWebService() {
        this.themeHandler$delegate = LazyKt.lazy(ContainerThemeWebService$themeHandler$2.INSTANCE);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.BaseWebService, com.ss.android.lark.chameleon.pluginsystem.WebService
    public void onAttachToWeb(Web r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind(THEME_CONFIG_JSB_NAME, getThemeHandler());
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.BaseWebService, com.ss.android.lark.chameleon.pluginsystem.WebService
    public void onDetachFromWeb(Web r100) {
        super.onDetachFromWeb(r100);
        getThemeHandler().release();
    }
}
