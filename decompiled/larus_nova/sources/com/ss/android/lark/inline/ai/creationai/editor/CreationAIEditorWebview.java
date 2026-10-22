package com.ss.android.lark.inline.ai.creationai.editor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.utils.x;
import com.ss.android.lark.chameleon.basewebview.LarkWebView;
import com.ss.android.lark.inline.ai.creationai.c0;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0002XYB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0006\u0010)\u001a\u00020*J*\u00101\u001a\u00020*2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0012J\u0010\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u00020*J\u0010\u00109\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u00010;J\u0006\u0010<\u001a\u00020*J\u001c\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\u0007\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020$H\u0016J\u0012\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010\u0007\u001a\u00020?H\u0016J\u001c\u0010A\u001a\u0004\u0018\u00010>2\b\u0010\u0007\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020*H\u0014J\b\u0010C\u001a\u00020*H\u0014J\b\u0010D\u001a\u00020*H\u0016J\b\u0010E\u001a\u00020*H\u0016J\b\u0010F\u001a\u00020*H\u0016J\u0010\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J\u0012\u0010O\u001a\u00020\u001b2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0018\u0010R\u001a\u00020\u001b2\u0006\u0010S\u001a\u00020$2\u0006\u0010@\u001a\u00020$H\u0016J\u0010\u0010T\u001a\u00020*2\u0006\u0010@\u001a\u00020$H\u0016J\b\u0010U\u001a\u00020$H\u0016J\u0012\u0010V\u001a\u00020*2\b\u0010W\u001a\u0004\u0018\u00010&H\u0016R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/editor/CreationAIEditorWebview;", "Lcom/ss/android/lark/inline/ai/creationai/editor/NSCLarkWebViewV1;", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "config", "Lcom/ss/android/lark/inline/ai/api/creationai/CreationAIConfig;", "callback", "Lcom/ss/android/lark/inline/ai/api/creationai/ICreationAIOpCallback;", "iRenderGone", "Lcom/ss/android/lark/inline/ai/creationai/editor/IRenderGone;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/inline/ai/api/creationai/CreationAIConfig;Lcom/ss/android/lark/inline/ai/api/creationai/ICreationAIOpCallback;Lcom/ss/android/lark/inline/ai/creationai/editor/IRenderGone;)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTag", "", "getMTag", "()Ljava/lang/String;", "setMTag", "(Ljava/lang/String;)V", "mWebViewId", "creationAIEditorBridge", "Lcom/ss/android/lark/inline/ai/creationai/editor/CreationAIEditorBridge;", "mPageFinished", "", "Ljava/lang/Boolean;", "mBridge", "Lcom/bytedance/ee/larkwebview/bridge/Bridge;", "getMBridge", "()Lcom/bytedance/ee/larkwebview/bridge/Bridge;", "mBridge$delegate", "Lkotlin/Lazy;", "contentHeight", "", "onHeightChangeListener", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider$OnHeightChangedListener;", "mILarkWebViewContext", "Lcom/bytedance/ee/larkwebview/base/interfaces/ILarkWebViewContext;", "init", "", "subscribe", "Lio/reactivex/disposables/Disposable;", "getSubscribe", "()Lio/reactivex/disposables/Disposable;", "setSubscribe", "(Lio/reactivex/disposables/Disposable;)V", "loadTemplate", "bgColor", GXTemplateKey.FLEXBOX_PADDING, "mode", "renderAIContent", "aiPreviewData", "Lcom/ss/android/lark/inline/ai/creationai/editor/AIPreviewData;", BasicTestActionHandler.TEST_ACTION_RESET, "onMessage", "data", "", "hide", "startActionMode", "Landroid/view/ActionMode;", "Landroid/view/ActionMode$Callback;", "type", "commonStartActionMode", "onAttachedToWindow", "onDetachedFromWindow", "onResume", "onPause", MapMonitorConst.EVENT_DESTROY, "initSettings", "webView", "Landroid/webkit/WebView;", "setUserAgent", "disableScrollBarRunnable", "Ljava/lang/Runnable;", "gestureDetector", "Landroid/view/GestureDetector;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "startNestedScroll", "axes", "stopNestedScroll", "getViewHeight", "setOnHeightChangeListener", "listener", "Companion", "CreationAIEditorLarkWebChromeClient", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationAIEditorWebview extends NSCLarkWebViewV1 implements wlb.g {
    public static final /* synthetic */ int H0 = 0;
    public String M;
    public String N;
    public com.ss.android.lark.inline.ai.creationai.editor.a O;
    public final vlb.a P;
    public final vlb.b Q;
    public final l R;
    public final Lazy S;
    public int T;
    public wlb.g.a U;
    public final j V;
    public Disposable W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final com.ss.android.lark.inline.ai.creationai.editor.e f427066k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final GestureDetector f427067p0;

    public static final class a {
    }

    public static final class b extends ws5.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f427068d;

        public b(j r100) {
            super(r100);
            this.f427068d = "CreationAIChromeClient";
        }

        @Override // ws5.b, android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "cm");
            if (r100.messageLevel().ordinal() <= ConsoleMessage.MessageLevel.LOG.ordinal()) goto L7;
            Log.i(this.f427068d, "onConsoleMessage== cm.message(): " + r100 + ".message(), cm.lineNumber(): " + r100.lineNumber() + " , cm.sourceId(): " + r100.sourceId());
            return true;
        L7:
            return true;
        }

        @Override // ws5.b, android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r100, int r101) {
            super.onProgressChanged(r100, r101);
            String r102 = this.f427068d;
            StringBuilder r103 = new StringBuilder("onProgressChanged: ");
            r103.append(r101);
            r103.append(", url: ");
            if (r100 == null) goto L5;
            String r104 = r100.getUrl();
        L6:
            r103.append(r104);
            Log.i(r102, r103.toString());
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationAIEditorWebview f427069a;

        @Override // com.ss.android.lark.inline.ai.creationai.editor.k
        public final void onPageFinished() {
            CreationAIEditorWebview r100 = this.f427069a;
            int r101 = CreationAIEditorWebview.H0;
            r100.getClass();
        }

        public c(CreationAIEditorWebview r100) {
            this.f427069a = r100;
        }
    }

    public static final class d {
        public d() {
        }
    }

    public static final class e implements com.ss.android.lark.inline.ai.creationai.editor.a.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CreationAIEditorWebview f427070a;

        public e(CreationAIEditorWebview r100) {
            this.f427070a = r100;
        }

        @Override // com.ss.android.lark.inline.ai.creationai.editor.a.i
        public final void a(AIConversation r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Integer r101 = r100.getContentHeight();
            if (r101 == null) goto L8;
            int r102 = r101.intValue();
            CreationAIEditorWebview r103 = this.f427070a;
            r103.T = r102;
            wlb.g.a r104 = r103.U;
            if (r104 == null) goto L9;
            r104.b(f0.a(r102));
            return;
        L9:
            return;
        }
    }

    static {
    }

    private final at5.a getMBridge() {
        return (at5.a) this.S.getValue();
    }

    @Override // wlb.g
    public int getViewHeight() {
        return f0.a(this.T);
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView
    public final void destroy() {
        getMBridge().b();
        com.ss.android.lark.inline.ai.creationai.editor.a r100 = this.O;
        if (r100 == null) goto L5;
        r100.f427076e.removeCallbacks(r100.f427079h);
    L5:
        super.destroy();
    }

    public final void p() {
        this.N = UUID.randomUUID().toString();
        this.M = "creationAIEditorWebview";
        this.M += this.N;
        boolean r100 = LarkKVStorage.f(com.ss.android.lark.inline.ai.logic.b.f427283a, "debug_config", new n6c.b(LarkContext.getApplication().getSharedPreferences("debug_config", 0))).getBoolean("ai_roadster_debug", false);
        Log.i(this.M, "Native init webViewId = " + this.N + " ,  debug = " + r100);
        WebSettings r101 = getSettings();
        r101.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        r101.setLoadWithOverviewMode(true);
        r101.setUseWideViewPort(true);
        r101.setSupportZoom(true);
        r101.setJavaScriptEnabled(true);
        r101.setDomStorageEnabled(true);
        r101.setSupportMultipleWindows(true);
        r101.setJavaScriptCanOpenWindowsAutomatically(true);
        r101.setCacheMode(-1);
        r101.setAllowFileAccess(true);
        r101.setAllowContentAccess(true);
        r101.setDatabaseEnabled(true);
        setUserAgent(this);
        setBackgroundColor(0);
        setWebViewClient(new com.ss.android.lark.inline.ai.creationai.editor.d(this.V, this.R, this.Q, new c(this)));
        setWebChromeClient(new b(this.V));
        com.ss.android.lark.inline.ai.creationai.editor.a r102 = new com.ss.android.lark.inline.ai.creationai.editor.a(this, this.Q, new d());
        this.O = r102;
        r102.f427072a.getBridge().c("biz.creationAI.render", new com.ss.android.lark.inline.ai.creationai.editor.a.c(r102));
        r102.f427072a.getBridge().c("biz.creationAI.renderComplete", new com.ss.android.lark.inline.ai.creationai.editor.a.C5053a(r102));
        r102.f427072a.getBridge().c("biz.creationAI.openLink", new com.ss.android.lark.inline.ai.creationai.editor.a.b(r102));
        r102.f427072a.getBridge().c("biz.creationAI.openProfile", new com.ss.android.lark.inline.ai.creationai.editor.a.d());
        r102.f427072a.getBridge().c("biz.creationAI.sendMessageToDocs", new com.ss.android.lark.inline.ai.creationai.editor.a.f(r102));
        r102.f427072a.getBridge().c("biz.creationAI.onMessageFromDocs", new com.ss.android.lark.inline.ai.creationai.editor.a.h(r102));
        r102.f427072a.getBridge().c("biz.util.logger", new com.ss.android.lark.inline.ai.creationai.editor.a.g());
        r102.f427072a.getBridge().c("biz.creationAI.reset", new com.ss.android.lark.inline.ai.creationai.editor.a.j(r102));
        com.ss.android.lark.inline.ai.creationai.editor.a r103 = this.O;
        if (r103 == null) goto L6;
        r103.f427080i = new e(this);
        return;
    }

    public final String getMTag() {
        return this.M;
    }

    public final Disposable getSubscribe() {
        return this.W;
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public final void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public final void onResume() {
        super.onResume();
    }

    public CreationAIEditorWebview(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setUserAgent(WebView r110) {
        int r100 = com.bytedance.ee.larkwebview.util.h.f242975a;
        String r101 = com.bytedance.ee.larkwebview.util.h.a(r110.getContext());
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = "Mozilla/5.0 (Linux; Android 10.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.2883.91 Mobile Safari/537.36";
    L5:
        int r102 = com.ss.android.lark.inline.ai.utils.a.f427695a;
        List r103 = CollectionsKt.listOf(new String[]{r101, "CreationAI creationAIEditorWebview", "mWebViewId/" + this.N, com.ss.android.lark.inline.ai.utils.a.a(r110.getContext())});
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        String r107 = (String) r106;
        if (r107 != null) goto L11;
    L14:
        boolean r108 = true;
    L16:
        if ((!r108) == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        if (StringsKt.isBlank(r107) == true) goto L14;
        r108 = false;
        goto L16
    L18:
        r110.getSettings().setUserAgentString(CollectionsKt.joinToString$default(r104, " ", null, null, 0, null, null, 62, null));
        Log.i(this.M, "initSettings: ua = " + r110.getSettings().getUserAgentString());
    }

    @Override // com.ss.android.lark.inline.ai.creationai.editor.NSCLarkWebViewV1, com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.f427067p0.onTouchEvent(r100);
        int r101 = r100.getAction();
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L9;
    L11:
        removeCallbacks(this.f427066k0);
        postDelayed(this.f427066k0, 2000);
    L14:
        return super.onTouchEvent(r100);
    L9:
        if (r101 == 3) goto L11;
    L12:
        removeCallbacks(this.f427066k0);
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(true);
        goto L14
    }

    public final void setMTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.M = r100;
    }

    @Override // wlb.g
    public void setOnHeightChangeListener(wlb.g.a r100) {
        this.U = r100;
    }

    public final void setSubscribe(Disposable r100) {
        this.W = r100;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return o(r100, -1);
    }

    @Override // com.ss.android.lark.inline.ai.creationai.editor.NSCLarkWebViewV1, androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        Log.i(LarkWebView.TAG, "stopNestedScroll");
        super.stopNestedScroll(r100);
    }

    public CreationAIEditorWebview(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, gt5.d.f482512b);
        this.M = "CreationAIEditorWebview";
        this.S = LazyKt.lazy(new CreationAIEditorWebview$mBridge$2(this));
        this.V = new j(this);
        this.f427066k0 = new com.ss.android.lark.inline.ai.creationai.editor.e(this);
        this.f427067p0 = new GestureDetector(getContext(), new f(this));
    }

    public final ActionMode o(ActionMode.Callback r100, int r101) {
        vlb.a r102 = this.P;
        if (r102 == null) goto L5;
        FragmentActivity r103 = r102.getActivity();
    L7:
        if (r103 != null) goto L9;
    L19:
        Log.w(LarkWebView.TAG, "startActionMode while not active !");
        return null;
    L9:
        if (r103.isFinishing() == true) goto L19;
        Log.i(LarkWebView.TAG, " start actionMode");     // Catch: Exception -> L16
        if (x.a() == false) goto L15;
        return super.startActionMode(r100, r101);
    L15:
        return super.startActionMode(r100);
    L16:
        e = move-exception;
        Log.e(LarkWebView.TAG, " start actionMode exception ", e);
        return null;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.view.View, zv4.b
    public final ActionMode startActionMode(ActionMode.Callback r100, int r101) {
        return o(r100, r101);
    }

    @Override // com.ss.android.lark.inline.ai.creationai.editor.NSCLarkWebViewV1, androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        Log.i(LarkWebView.TAG, "startNestedScroll");
        return super.startNestedScroll(r100, r101);
    }

    public CreationAIEditorWebview(FragmentActivity r100, vlb.a r101, vlb.b r102, c0 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "iRenderGone");
        this(r100, null);
        this.P = r101;
        this.Q = r102;
        this.R = r103;
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(0);
    }
}
