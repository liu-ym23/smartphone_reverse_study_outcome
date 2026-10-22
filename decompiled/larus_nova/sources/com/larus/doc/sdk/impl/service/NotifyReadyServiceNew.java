package com.larus.doc.sdk.impl.service;

import android.webkit.WebView;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.BridgeReadyModel;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
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

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/doc/sdk/impl/service/NotifyReadyServiceNew;", "Lcom/ss/android/lark/chameleon/AbsWebService;", "<init>", "()V", "isReady", "", "readyListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/doc/sdk/impl/service/NotifyReadyServiceNew$IWebReadyListener;", "onAttachToWeb", "", "web", "Lcom/ss/android/lark/chameleon/pluginsystem/Web;", "registerWebReadyListener", "listener", "unregisterWebReadyListener", "Companion", "NotifyReadyHandler", "NotifyPreloadReadyHandler", "IWebReadyListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifyReadyServiceNew extends AbsWebService {
    public static final Companion Companion = null;
    private static final String TAG = "NotifyReadyService";
    private boolean isReady;
    private final CopyOnWriteArrayList<IWebReadyListener> readyListeners;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/service/NotifyReadyServiceNew$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/larus/doc/sdk/impl/service/NotifyReadyServiceNew$IWebReadyListener;", "", "onReady", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IWebReadyListener {
        void onReady();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/doc/sdk/impl/service/NotifyReadyServiceNew$NotifyPreloadReadyHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "", "webView", "Landroid/webkit/WebView;", "<init>", "(Lcom/larus/doc/sdk/impl/service/NotifyReadyServiceNew;Landroid/webkit/WebView;)V", "handle", "", "data", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NotifyPreloadReadyHandler implements BridgeHandlerV2<Object> {
        final /* synthetic */ NotifyReadyServiceNew this$0;
        private final WebView webView;

        public NotifyPreloadReadyHandler(NotifyReadyServiceNew r100, WebView r101) {
            this.this$0 = r100;
            this.webView = r101;
        }

        @Override // com.ss.android.lark.chameleon.bridge.JSHandler
        public void handle(Object r100, CallBackFunction r101) {
            Log.i(NotifyReadyServiceNew.TAG, "Got preload ready event");
            JsonObject r102 = new JsonObject();
            JsonArray r103 = new JsonArray();
            r103.add(DocumentType.DOCX_NAME);
            r103.add("slides");
            Unit r104 = Unit.INSTANCE;
            r102.add("type", r103);
            SafeJSExecutor.execJS(this.webView, "javascript:preloadJsModule", r102);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/service/NotifyReadyServiceNew$NotifyReadyHandler;", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandlerV2;", "Lcom/bytedance/ee/docsdk/impl/document/plugins/BridgeReadyModel;", "<init>", "(Lcom/larus/doc/sdk/impl/service/NotifyReadyServiceNew;)V", "handle", "", "data", "callback", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NotifyReadyHandler implements BridgeHandlerV2<BridgeReadyModel> {
        final /* synthetic */ NotifyReadyServiceNew this$0;

        public NotifyReadyHandler(NotifyReadyServiceNew r100) {
            this.this$0 = r100;
        }

        public void handle(BridgeReadyModel r100, CallBackFunction r101) {
            Log.i(NotifyReadyServiceNew.TAG, "Got notify ready");
            NotifyReadyServiceNew.access$setReady$p(this.this$0, true);
            Iterator r102 = NotifyReadyServiceNew.access$getReadyListeners$p(this.this$0).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((IWebReadyListener) r102.next()).onReady();
            goto L4
        }

        @Override // com.ss.android.lark.chameleon.bridge.JSHandler
        public /* bridge */ /* synthetic */ void handle(Object r100, CallBackFunction r101) {
            handle((BridgeReadyModel) r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public NotifyReadyServiceNew() {
        this.readyListeners = new CopyOnWriteArrayList();
    }

    public final boolean isReady() {
        return this.isReady;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getReadyListeners$p(NotifyReadyServiceNew r100) {
        return r100.readyListeners;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.BaseWebService, com.ss.android.lark.chameleon.pluginsystem.WebService
    public void onAttachToWeb(Web r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind(JsBridgeConstants.BIZ_NOTIFY_READY, new NotifyReadyHandler(this));
        if (r100 == null) goto L5;
        WebView r101 = r100.getWebView();
    L6:
        bindBridgeHandlerAutoUnbind(JsBridgeConstants.BIZ_NOTIFY_PRELOADREADY, new NotifyPreloadReadyHandler(this, r101));
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void registerWebReadyListener(IWebReadyListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.readyListeners.add(r100);
        if (this.isReady == false) goto L6;
        r100.onReady();
        return;
    }

    public final void unregisterWebReadyListener(IWebReadyListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.readyListeners.remove(r100);
    }

    public static final /* synthetic */ void access$setReady$p(NotifyReadyServiceNew r100, boolean r101) {
        r100.isReady = r101;
    }
}
