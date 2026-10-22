package com.bytedance.ee.docsdk.impl.document.service;

import android.webkit.WebView;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.BridgeReadyModel;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.AbsWebService;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/service/NotifyReadyService;", "Lcom/ss/android/lark/chameleon/AbsWebService;", "()V", "isReady", "", "readyListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ee/docsdk/impl/document/service/NotifyReadyService$IWebReadyListener;", "onAttachToWeb", "", "web", "Lcom/ss/android/lark/chameleon/pluginsystem/Web;", "registerWebReadyListener", "listener", "unregisterWebReadyListener", "Companion", "IWebReadyListener", "NotifyPreloadReadyHandler", "NotifyReadyHandler", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NotifyReadyService extends AbsWebService {
    public static final Companion Companion = null;
    private static final String TAG = "NotifyReadyService";
    private boolean isReady;
    private final CopyOnWriteArrayList<IWebReadyListener> readyListeners;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/service/NotifyReadyService$Companion;", "", "()V", "TAG", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/service/NotifyReadyService$IWebReadyListener;", "", "onReady", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface IWebReadyListener {
        void onReady();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/service/NotifyReadyService$NotifyPreloadReadyHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "", "webView", "Landroid/webkit/WebView;", "(Lcom/bytedance/ee/docsdk/impl/document/service/NotifyReadyService;Landroid/webkit/WebView;)V", "handle", "", WikiFolderPushPlugin.DATA, "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class NotifyPreloadReadyHandler implements BridgeHandlerV2<Object> {
        final /* synthetic */ NotifyReadyService this$0;
        private final WebView webView;

        public NotifyPreloadReadyHandler(NotifyReadyService r1, WebView r2) {
            this.this$0 = r1;
            this.webView = r2;
        }

        public void handle(Object r2, CallBackFunction r3) {
            Log.i(NotifyReadyService.TAG, "Got preload ready event");
            JsonObject r4 = new JsonObject();
            JsonArray r5 = new JsonArray();
            r5.add(DocumentType.DOCX_NAME);
            r5.add("slides");
            Unit r0 = Unit.INSTANCE;
            r4.add(ResourceData.KEY_TYPE, r5);
            SafeJSExecutor.execJS(this.webView, "javascript:preloadJsModule", r4);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/service/NotifyReadyService$NotifyReadyHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/BridgeReadyModel;", "(Lcom/bytedance/ee/docsdk/impl/document/service/NotifyReadyService;)V", "handle", "", WikiFolderPushPlugin.DATA, "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class NotifyReadyHandler implements BridgeHandlerV2<BridgeReadyModel> {
        final /* synthetic */ NotifyReadyService this$0;

        public NotifyReadyHandler(NotifyReadyService r1) {
            this.this$0 = r1;
        }

        public void handle(BridgeReadyModel r1, CallBackFunction r2) {
            Log.i(NotifyReadyService.TAG, "Got notify ready");
            NotifyReadyService.access$setReady$p(this.this$0, true);
            Iterator r3 = NotifyReadyService.access$getReadyListeners$p(this.this$0).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((IWebReadyListener) r3.next()).onReady();
            goto L4
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, CallBackFunction r2) {
            handle((BridgeReadyModel) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public NotifyReadyService() {
        this.readyListeners = new CopyOnWriteArrayList();
    }

    public final boolean isReady() {
        return this.isReady;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getReadyListeners$p(NotifyReadyService r0) {
        return r0.readyListeners;
    }

    public void onAttachToWeb(Web r3) {
        super/*com.ss.android.lark.chameleon.pluginsystem.BaseWebService*/.onAttachToWeb(r3);
        bindBridgeHandlerAutoUnbind(JsBridgeConstants.BIZ_NOTIFY_READY, new NotifyReadyHandler(this));
        if (r3 == null) goto L5;
        WebView r4 = r3.getWebView();
    L6:
        bindBridgeHandlerAutoUnbind(JsBridgeConstants.BIZ_NOTIFY_PRELOADREADY, new NotifyPreloadReadyHandler(this, r4));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void registerWebReadyListener(IWebReadyListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.readyListeners.add(r2);
        if (this.isReady == false) goto L6;
        r2.onReady();
        return;
    }

    public final void unregisterWebReadyListener(IWebReadyListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.readyListeners.remove(r2);
    }

    public static final /* synthetic */ void access$setReady$p(NotifyReadyService r0, boolean r1) {
        r0.isReady = r1;
    }
}
