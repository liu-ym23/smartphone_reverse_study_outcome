package com.ss.android.lark.inline.ai.ui.richtext;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.x;
import com.ss.android.lark.chameleon.basewebview.LarkWebView;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0002RSB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0006\u0010)\u001a\u00020*J*\u00101\u001a\u00020*2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0012J\u0010\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u00020*J\u001c\u00109\u001a\u0004\u0018\u00010:2\b\u0010\u0007\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020$H\u0016J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u0007\u001a\u00020;H\u0016J\u001c\u0010=\u001a\u0004\u0018\u00010:2\b\u0010\u0007\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020$H\u0002J\b\u0010>\u001a\u00020*H\u0014J\b\u0010?\u001a\u00020*H\u0014J\b\u0010@\u001a\u00020*H\u0016J\b\u0010A\u001a\u00020*H\u0016J\b\u0010B\u001a\u00020*H\u0016J\u0010\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020*2\u0006\u0010D\u001a\u00020EH\u0002J\u0012\u0010I\u001a\u00020\u001b2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0018\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020$2\u0006\u0010<\u001a\u00020$H\u0016J\u0010\u0010N\u001a\u00020*2\u0006\u0010<\u001a\u00020$H\u0016J\b\u0010O\u001a\u00020$H\u0016J\u0012\u0010P\u001a\u00020*2\b\u0010Q\u001a\u0004\u0018\u00010&H\u0016R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/richtext/RichtextPreviewWebview;", "Lcom/ss/android/lark/inline/ai/ui/richtext/NSCLarkWebView;", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "config", "Lcom/ss/android/lark/inline/ai/api/ui/InlineAIConfig;", "callback", "Lcom/ss/android/lark/inline/ai/api/ui/IOperationCallback;", "iRenderGone", "Lcom/ss/android/lark/inline/ai/ui/richtext/IRenderGone;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/inline/ai/api/ui/InlineAIConfig;Lcom/ss/android/lark/inline/ai/api/ui/IOperationCallback;Lcom/ss/android/lark/inline/ai/ui/richtext/IRenderGone;)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTag", "", "getMTag", "()Ljava/lang/String;", "setMTag", "(Ljava/lang/String;)V", "mWebViewId", "richtextPreviewBridge", "Lcom/ss/android/lark/inline/ai/ui/richtext/RichtextPreviewBridge;", "mPageFinished", "", "Ljava/lang/Boolean;", "mBridge", "Lcom/bytedance/ee/larkwebview/bridge/Bridge;", "getMBridge", "()Lcom/bytedance/ee/larkwebview/bridge/Bridge;", "mBridge$delegate", "Lkotlin/Lazy;", "contentHeight", "", "onHeightChangeListener", "Lcom/ss/android/lark/inline/ai/api/ui/IViewHeightProvider$OnHeightChangedListener;", "mILarkWebViewContext", "Lcom/bytedance/ee/larkwebview/base/interfaces/ILarkWebViewContext;", "init", "", "subscribe", "Lio/reactivex/disposables/Disposable;", "getSubscribe", "()Lio/reactivex/disposables/Disposable;", "setSubscribe", "(Lio/reactivex/disposables/Disposable;)V", "loadTemplate", "bgColor", GXTemplateKey.FLEXBOX_PADDING, "mode", "renderAIContent", "aiPreviewData", "Lcom/ss/android/lark/inline/ai/ui/richtext/AIPreviewData;", "hide", "startActionMode", "Landroid/view/ActionMode;", "Landroid/view/ActionMode$Callback;", "type", "commonStartActionMode", "onAttachedToWindow", "onDetachedFromWindow", "onResume", "onPause", MapMonitorConst.EVENT_DESTROY, "initSettings", "webView", "Landroid/webkit/WebView;", "setUserAgent", "disableScrollBarRunnable", "Ljava/lang/Runnable;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "startNestedScroll", "axes", "stopNestedScroll", "getViewHeight", "setOnHeightChangeListener", "listener", "Companion", "RichtextPreviewLarkWebChromeClient", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichtextPreviewWebview extends NSCLarkWebView implements wlb.g {
    public static final /* synthetic */ int V0 = 0;
    public final k H0;
    public Disposable L0;
    public final j P0;
    public String Q;
    public String R;
    public com.ss.android.lark.inline.ai.ui.richtext.g S;
    public final wlb.h T;
    public final wlb.e U;
    public final com.ss.android.lark.inline.ai.ui.richtext.b V;
    public final Lazy W;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f427617k0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public wlb.g.a f427618p0;

    public static final class a {
    }

    public static final class b extends ws5.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f427619d;

        public b(k r100) {
            super(r100);
            this.f427619d = "RichtextPreviewLarkWebChromeClient";
        }

        @Override // ws5.b, android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "cm");
            if (r100.messageLevel().ordinal() <= ConsoleMessage.MessageLevel.LOG.ordinal()) goto L7;
            Log.i(this.f427619d, "onConsoleMessage== cm.message(): " + r100 + ".message(), cm.lineNumber(): " + r100.lineNumber() + " , cm.sourceId(): " + r100.sourceId());
            return true;
        L7:
            return true;
        }

        @Override // ws5.b, android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r100, int r101) {
            super.onProgressChanged(r100, r101);
            String r102 = this.f427619d;
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

    public static final class c implements com.ss.android.lark.inline.ai.ui.richtext.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichtextPreviewWebview f427620a;

        @Override // com.ss.android.lark.inline.ai.ui.richtext.a
        public final void onPageFinished() {
            RichtextPreviewWebview r100 = this.f427620a;
            int r101 = RichtextPreviewWebview.V0;
            r100.getClass();
        }

        public c(RichtextPreviewWebview r100) {
            this.f427620a = r100;
        }
    }

    public static final class d implements NSCLarkWebView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichtextPreviewWebview f427621a;

        public d(RichtextPreviewWebview r100) {
            this.f427621a = r100;
        }

        @Override // com.ss.android.lark.inline.ai.ui.richtext.NSCLarkWebView.b
        public final void setEnable(boolean r100) {
            Log.i(this.f427621a.getMTag(), "IEnableCallback enable = " + r100);
            this.f427621a.setMEnable(r100);
        }
    }

    public static final class e implements com.ss.android.lark.inline.ai.ui.richtext.g.InterfaceC5062g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichtextPreviewWebview f427622a;

        public e(RichtextPreviewWebview r100) {
            this.f427622a = r100;
        }

        @Override // com.ss.android.lark.inline.ai.ui.richtext.g.InterfaceC5062g
        public final void a(AIConversation r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Integer r101 = r100.getContentHeight();
            if (r101 == null) goto L8;
            int r102 = r101.intValue();
            RichtextPreviewWebview r103 = this.f427622a;
            r103.f427617k0 = r102;
            wlb.g.a r104 = r103.f427618p0;
            if (r104 == null) goto L9;
            r104.b(f0.a(r102));
            return;
        L9:
            return;
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichtextPreviewWebview f427623a;

        public f(RichtextPreviewWebview r100) {
            this.f427623a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            Intrinsics.checkNotNullParameter((Boolean) r210, "it");
            int r100 = l.f427653a;
            Context r101 = this.f427623a.getContext();
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Log.i("RichtextResLoader", "getRichtextRes  1");
            long r102 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
            Object r104 = Result.m9449constructorimpl(l.c(new BufferedReader(new InputStreamReader(r101.getAssets().open("inlineai/current_revision")))));     // Catch: Throwable -> L5
        L7:
            Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
            if (r105 == null) goto L10;
            Log.i("RichtextResLoader", "getAssetVersion onFailure : " + r105);
        L10:
            com.ss.android.lark.inline.ai.ui.richtext.f r106 = new com.ss.android.lark.inline.ai.ui.richtext.f();
            if (Result.m9455isFailureimpl(r104) == false) goto L13;
            r104 = r106;
        L13:
            String r110 = ((com.ss.android.lark.inline.ai.ui.richtext.f) r104).f427632b;
            if (r110 != null) goto L16;
        L19:
            boolean r107 = true;
        L20:
            if (r107 == true) goto L71;
            VFSPath r111 = l.b();
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        L26:
            th = move-exception;
            Log.e("RichtextResLoader", "getResLocalVersion error", th);
        L28:
            com.ss.android.lark.inline.ai.ui.richtext.f r108 = new com.ss.android.lark.inline.ai.ui.richtext.f();
        L29:
            String r109 = r108.f427632b;
            if (r109 != null) goto L32;
            r109 = "";
        L32:
            List r112 = StringsKt.split$default(r110, new char[]{'.'}, false, 0, 6, null);
            List r113 = StringsKt.split$default(r109, new char[]{'.'}, false, 0, 6, null);
            int r114 = Math.min(r112.size(), r113.size());
            int r115 = 0;
            int r116 = 0;
        L33:
            if (r115 >= r114) goto L40;
            r116 = ((String) ListProtector.get(r112, r115)).length() - ((String) ListProtector.get(r113, r115)).length();
            if (r116 != 0) goto L37;
            r116 = ((String) ListProtector.get(r112, r115)).compareTo((String) ListProtector.get(r113, r115));
        L37:
            if (r116 != 0) goto L40;
            r115 = r115 + 1;
        L40:
            if (r116 != 0) goto L42;
            r116 = r112.size() - r113.size();
        L42:
            Log.i("RichtextResLoader", "getRichtextRes   cost1 : " + (System.currentTimeMillis() - r102) + ",  localVersion: " + r109 + ",  assetVersion: " + r110 + ",  versionCompare: " + r116 + ",  resLocalDir: " + r111.getAbsolutePath());
            if (r116 <= 0) goto L45;
        L51:
            Log.i("RichtextResLoader", "replaceLocal");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            VFSPath r117 = l.b();
            VFSFiles.f444819b.getClass();
            FileUtils.f(VFSFiles.b(true).i(r117.getAbsolutePath()));
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            VFSPath r118 = r111;
            Intrinsics.checkNotNullParameter(r118, "dest");
            VFSPath r119 = l.b().subPath("inline_ai_preview.7z");
            com.suite.lark.component.storage.ext.b.delete(r119);
            l.a(r101, "inlineai/inline_ai_preview.7z", r119);
            String r120 = r119.getRealPath();
            String r121 = r118.getRealPath();
            Intrinsics.checkNotNullParameter(r121, "destFold1");
            if (TextUtils.isEmpty(r120) == false) goto L54;
        L63:
            int r122 = -1;
        L64:
            com.suite.lark.component.storage.ext.b.delete(r119);
            if (r122 != 0) goto L69;
        L66:
            Log.i("RichtextResLoader", "getRichtextRes   cost2 : " + (System.currentTimeMillis() - r102));
            return r118.subPath("inline_ai_preview").subPath("index.html").getAbsolutePath();
        L69:
            throw new IllegalAccessException("extract7z failed " + r122);
        L54:
            if (TextUtils.isEmpty(r121) == true) goto L63;
        L61:
            e = move-exception;
            Log.e("RichtextResLoader", "extractAll fails : " + e + "  message:" + e.getMessage());
            goto L63
        L57:
            if (StringsKt.endsWith$default(r121, HTTP.URL_DEFAULT, false, 2, null) == true) goto L59;
            r121 = r121 + File.separator;     // Catch: IOException -> L61
        L59:
            r122 = Archive.extractAll(r120, r121, null, 0);     // Catch: IOException -> L61
            goto L64
        L45:
            if (r109.length() != 0) goto L47;
            boolean r123 = true;
        L48:
            if (r123 == true) goto L51;
            r118 = r111;
            goto L66
        L47:
            r123 = false;
            goto L48
        L23:
            if (com.suite.lark.component.storage.ext.b.b(l.b().subPath("inline_ai_preview").subPath(ChameleonResConstants.TEMPLATE_VERSION)) == false) goto L28;
            VFSFiles.f444819b.getClass();     // Catch: Throwable -> L26
            r108 = l.c(new BufferedReader(new PolarisFileReaderWrapper(VFSFiles.b(true).r(l.b().subPath("inline_ai_preview").subPath(ChameleonResConstants.TEMPLATE_VERSION), false))));     // Catch: Throwable -> L26
            goto L29
        L71:
            throw new IllegalArgumentException("assetVersion is null");
        L16:
            if (r110.length() == 0) goto L19;
            r107 = false;
        L5:
            th = move-exception;
            Result.Companion r124 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f427624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f427625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f427626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ RichtextPreviewWebview f427627d;

        public g(String r100, String r101, String r102, RichtextPreviewWebview r103) {
            this.f427624a = r100;
            this.f427625b = r101;
            this.f427626c = r102;
            this.f427627d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = MSkiaImageRegionDecoder.FILE_PREFIX + ((String) r100);
            yob.e.a().getClass();
            int r102 = com.ss.android.lark.language.service.impl.a.f431092f;
            Locale r103 = com.ss.android.lark.language.service.impl.a.b.f431098a.getLanguageSetting();
            if (r103 != null) goto L5;
            r103 = Locale.ENGLISH;
        L5:
            String r104 = r101 + "?locale=" + (r103.getLanguage() + '-' + r103.getCountry());
            String r105 = this.f427624a;
            if (r105 == null) goto L8;
            r104 = r104 + "&bgColor=" + r105;
        L8:
            String r106 = this.f427625b;
            if (r106 == null) goto L11;
            r104 = r104 + "&padding=" + r106;
        L11:
            String r107 = this.f427626c;
            if (r107 == null) goto L14;
            r104 = r104 + "&mode=" + r107;
        L14:
            Log.i(this.f427627d.getMTag(), "loadTemplate  loader = " + r104);
            com.ss.android.lark.inline.ai.ui.richtext.g r108 = this.f427627d.S;
            if (r108 == null) goto L17;
            System.currentTimeMillis();
            r108.f427638f.postDelayed(r108.f427640h, 10000);
        L17:
            this.f427627d.loadUrl(r104);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichtextPreviewWebview f427628a;

        public h(RichtextPreviewWebview r100) {
            this.f427628a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            int r102 = zlb.a.f572823d;
            if (r101 == null) goto L5;
            String r103 = r101.toString();
        L6:
            zlb.a.C8475a.e(404, r103, 0);
            Log.e(this.f427628a.getMTag(), r101, true);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }

    private final at5.a getMBridge() {
        return (at5.a) this.W.getValue();
    }

    @Override // wlb.g
    public int getViewHeight() {
        return f0.a(this.f427617k0);
    }

    public final void p() {
        Disposable r100 = this.L0;
        if (r100 != null) goto L5;
    L7:
        AIPreviewData r101 = new AIPreviewData("", null, null, null, null, null, null, null, 254, null);
        com.ss.android.lark.inline.ai.ui.richtext.g r102 = this.S;
        if (r102 == null) goto L12;
        amb.d r103 = r102.f427639g;
        if (r103 == null) goto L12;
        r103.b();
    L12:
        com.ss.android.lark.inline.ai.ui.richtext.g r104 = this.S;
        if (r104 == null) goto L15;
        r104.a(r101);
    L15:
        com.ss.android.lark.inline.ai.ui.richtext.g r105 = this.S;
        if (r105 == null) goto L21;
        amb.d r106 = r105.f427639g;
        if (r106 == null) goto L22;
        r106.b();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r100.dispose();
        goto L7
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView
    public final void destroy() {
        getMBridge().b();
        com.ss.android.lark.inline.ai.ui.richtext.g r100 = this.S;
        if (r100 == null) goto L5;
        r100.f427638f.removeCallbacks(r100.f427640h);
    L5:
        super.destroy();
    }

    public final void q() {
        this.R = UUID.randomUUID().toString();
        this.Q = "RichtextPreviewWebview";
        this.Q += this.R;
        boolean r100 = LarkKVStorage.f(com.ss.android.lark.inline.ai.logic.b.f427283a, "debug_config", new n6c.b(LarkContext.getApplication().getSharedPreferences("debug_config", 0))).getBoolean("ai_roadster_debug", false);
        Log.i(this.Q, "Native init webViewId = " + this.R + " ,  debug = " + r100);
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
        setWebViewClient(new i(this.H0, this.V, this.U, new c(this)));
        setWebChromeClient(new b(this.H0));
        com.ss.android.lark.inline.ai.ui.richtext.g r102 = new com.ss.android.lark.inline.ai.ui.richtext.g(this, this.U, new d(this));
        this.S = r102;
        r102.f427633a.getBridge().c("biz.render.AIContent", new com.ss.android.lark.inline.ai.ui.richtext.g.c(r102));
        r102.f427633a.getBridge().c("biz.render.AIContent.complete", new com.ss.android.lark.inline.ai.ui.richtext.g.a(r102));
        amb.d r103 = new amb.d(r102.f427634b);
        r102.f427639g = r103;
        r102.f427633a.getBridge().c("biz.selection.showMenu", r103);
        r102.f427633a.getBridge().c("biz.selection.closeMenu", new amb.a(r103));
        r102.f427633a.getBridge().c("biz.selection.longPress", new amb.b());
        r102.f427633a.getBridge().c("biz.render.AIContent.openLink", new com.ss.android.lark.inline.ai.ui.richtext.g.b(r102));
        r102.f427633a.getBridge().c("biz.selection.setScrollStatus", new amb.c(r102.f427635c));
        if (new bmb.a().f19670b.isCurrentEnable("ccm.knowledge.inline_ai_mention_all_enable") == false) goto L5;
        r102.f427633a.getBridge().c("biz.render.AIContent.openProfile", new com.ss.android.lark.inline.ai.ui.richtext.g.d());
    L5:
        r102.f427633a.getBridge().c("biz.inlineAI.sendMessageToDocs", new com.ss.android.lark.inline.ai.ui.richtext.g.f(r102));
        com.ss.android.lark.inline.ai.ui.richtext.g r104 = this.S;
        if (r104 == null) goto L9;
        r104.f427641i = new e(this);
        return;
    }

    public final String getMTag() {
        return this.Q;
    }

    public final Disposable getSubscribe() {
        return this.L0;
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

    public RichtextPreviewWebview(Context r100) {
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
        List r103 = CollectionsKt.listOf(new String[]{r101, "inlineAI RichtextPreviewWebview", "mWebViewId/" + this.R, com.ss.android.lark.inline.ai.utils.a.a(r110.getContext())});
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
        Log.i(this.Q, "initSettings: ua = " + r110.getSettings().getUserAgentString());
    }

    @Override // com.ss.android.lark.inline.ai.ui.richtext.NSCLarkWebView, com.bytedance.ee.larkwebview.base.LarkWebView, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getAction();
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L9;
    L11:
        removeCallbacks(this.P0);
        postDelayed(this.P0, 2000);
    L14:
        return super.onTouchEvent(r100);
    L9:
        if (r101 == 3) goto L11;
    L12:
        removeCallbacks(this.P0);
        setVerticalScrollBarEnabled(true);
        goto L14
    }

    public final void setMTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.Q = r100;
    }

    @Override // wlb.g
    public void setOnHeightChangeListener(wlb.g.a r100) {
        this.f427618p0 = r100;
    }

    public final void setSubscribe(Disposable r100) {
        this.L0 = r100;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return o(r100, -1);
    }

    @Override // com.ss.android.lark.inline.ai.ui.richtext.NSCLarkWebView, androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        Log.i(LarkWebView.TAG, "stopNestedScroll");
        super.stopNestedScroll(r100);
    }

    public RichtextPreviewWebview(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, gt5.d.f482512b);
        this.Q = "RichtextPreviewWebview";
        this.W = LazyKt.lazy(new RichtextPreviewWebview$mBridge$2(this));
        this.H0 = new k(this);
        this.P0 = new j(this);
    }

    public final ActionMode o(ActionMode.Callback r100, int r101) {
        wlb.h r102 = this.T;
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

    @Override // com.ss.android.lark.inline.ai.ui.richtext.NSCLarkWebView, androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        Log.i(LarkWebView.TAG, "startNestedScroll");
        return super.startNestedScroll(r100, r101);
    }

    public final void r(String r100, String r101, String r102) {
        this.L0 = Single.just(Boolean.TRUE).map(new f(this)).subscribeOn(new ExecutorScheduler(CoreThreadPool.getDefault().getSingleScheduledThreadPool(this.Q), false)).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r100, r101, r102, this), new h(this));
    }

    public RichtextPreviewWebview(FragmentActivity r100, wlb.h r101, wlb.e r102, com.ss.android.lark.inline.ai.ui.richtext.b r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "iRenderGone");
        this(r100, null);
        this.T = r101;
        this.U = r102;
        this.V = r103;
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(0);
    }
}
