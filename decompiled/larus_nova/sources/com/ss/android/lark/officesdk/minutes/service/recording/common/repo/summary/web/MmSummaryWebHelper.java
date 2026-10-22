package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmAISummaryLayoutData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$initWebHelper$1;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class MmSummaryWebHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f435365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f435366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<MmRecordingUILaunchMode> f435367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f435368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OfficeWebView f435369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableContextWrapper f435370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f435371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f435372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f435373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MmAISummaryLayoutData f435374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f435375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f435376l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f435377m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e f435378n;

    public interface a {
        com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.a a();

        void b(String r100, JSONObject r101);

        void c();

        void d();

        boolean e(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.d r100);

        void f();

        void g();

        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a getFeatureService();

        com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b getSettingsService();

        void j();
    }

    public final void b() {
        lvb.a.e(this.f435368d, "[destroyWebView]");
        OfficeWebView r100 = this.f435369e;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ((ConcurrentHashMap) r100.getBridge().f565288b.f565311a).clear();
        r100.stopLoading();
        r100.getSettings().setJavaScriptEnabled(false);
        r100.clearHistory();
        r100.clearView();
        r100.removeAllViews();
        r100.destroy();
    L5:
        this.f435369e = null;
        this.f435370f = null;
        this.f435375k = null;
        this.f435371g = false;
        this.f435372h = false;
        this.f435373i = "";
        this.f435374j = null;
        this.f435376l = null;
        this.f435377m = false;
    }

    public final OfficeWebView c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f435369e == null) goto L6;
        lvb.a.e(this.f435368d, "[initWebView] reuse existing webView");
        e(r100, "initWebView");
        OfficeWebView r101 = this.f435369e;
        Intrinsics.checkNotNull(r101);
        return r101;
    L6:
        lvb.a.e(this.f435368d, "[initWebView] create new webView");
        MutableContextWrapper r102 = new MutableContextWrapper(r100.getApplicationContext());
        r102.setBaseContext(r100);
        this.f435370f = r102;
        this.f435375k = r100;
        OfficeWebView r103 = new OfficeWebView(r102, null, 6);
        r103.setHorizontalScrollBarEnabled(false);
        r103.setVerticalScrollBarEnabled(false);
        r103.getSettings().setAllowFileAccess(true);
        r103.getSettings().setJavaScriptEnabled(true);
        r103.getSettings().setSupportZoom(false);
        r103.getSettings().setNeedInitialFocus(false);
        r103.setOverScrollMode(2);
        r103.setLayerType(2, null);
        int r104 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.f434976a;
        r103.setBackgroundColor(UIUtils.getColor(r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a(this.f435367c.invoke())));
        if (DevEnvUtil.isDebugMode(r100) == false) goto L9;
        WebView.setWebContentsDebuggingEnabled(true);
    L9:
        xwb.a r105 = r103.getBridge();
        r105.b("common.ready", new e(this));
        r105.b("common.fishBoneContentUpdate", new f(this));
        r105.b("common.markFishBone", new g(this));
        r105.b("common.vibrate", new h(this));
        r105.b("common.showToast", new i(this));
        r105.b("common.log", new j(this));
        r105.b("common.sendTrackEvent", new k(this));
        r105.b("common.getSettings", new l(this));
        r105.b("common.getFG", new c(this));
        r105.b("common.networkProxy", new d(this));
        r103.setWebViewClient(new m(this, this.f435378n));
        this.f435369e = r103;
        this.f435371g = false;
        this.f435372h = false;
        return r103;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L28:
        lvb.a.b(this.f435368d, "[loadUrl] url is empty or webView is null, url=" + r100);
        return;
    L5:
        if (this.f435369e == null) goto L28;
        if (Intrinsics.areEqual(r100, this.f435373i) == true) goto L10;
    L13:
        this.f435373i = r100;
        this.f435371g = false;
        this.f435372h = false;
        yub.d r101 = yub.d.f569261a;
        Context r102 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r102 != null) goto L16;
        LarkAppContext.Companion.getClass();
        r102 = LarkAppContext.access$getInstance$cp().getContext();
    L16:
        boolean r103 = h18.f.a(r102);
        this.f435376l = Boolean.valueOf(r103);
        if (r103 == false) goto L19;
        String r104 = "dark";
    L20:
        String r105 = "theme=".concat(r104);
        if (StringsKt.contains$default(r100, "?", false, 2, null) == false) goto L23;
        StringBuilder r106 = new StringBuilder();
        r106.append(r100);
        char r107 = Typography.amp;
    L24:
        r106.append(r107);
        r106.append(r105);
        String r108 = r106.toString();
        lvb.a.e(this.f435368d, "[loadUrl] url=" + r108);
        OfficeWebView r109 = this.f435369e;
        if (r109 == null) goto L30;
        r109.loadUrl(r108);
        return;
    L30:
        return;
    L23:
        r106 = new StringBuilder();
        r106.append(r100);
        r107 = '?';
        goto L24
    L19:
        r104 = "light";
        goto L20
    L10:
        if (this.f435371g == false) goto L13;
        lvb.a.e(this.f435368d, "[loadUrl] skip, same url and web is ready");
    }

    public final void f(MmAISummaryLayoutData r100) {
        Intrinsics.checkNotNullParameter(r100, "fishBoneData");
        this.f435374j = r100;
        if (this.f435371g == true) goto L6;
        lvb.a.e(this.f435368d, "[updateFishBoneData] web not ready, cache pending data, timestamp=" + r100.getTimeStamp());
        return;
    L6:
        lvb.a.e(this.f435368d, "[updateFishBoneData] send data to web, timestamp=" + r100.getTimeStamp());
        int r101 = b.f435380a;
        b.b(this.f435369e, r100);
    }

    public final void e(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "newContext");
        Intrinsics.checkNotNullParameter(r101, "from");
        if (Intrinsics.areEqual(this.f435375k, r100) == false) goto L6;
        lvb.a.a(this.f435368d, "[updateContext] skip, same context. from=" + r101);
        return;
    L6:
        lvb.a.e(this.f435368d, "[updateContext] newContext=" + r100 + ", from=" + r101);
        this.f435375k = r100;
        MutableContextWrapper r102 = this.f435370f;
        if (r102 == null) goto L10;
        r102.setBaseContext(r100);
        return;
    }

    public MmSummaryWebHelper(CoroutineScope r100, MmRecordingSummaryRepo$opt$2$1$initWebHelper$1 r110, Function0 r111) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r111, "uiLaunchModeProvider");
        this.f435365a = r100;
        this.f435366b = r110;
        this.f435367c = r111;
        this.f435368d = "MmSummaryWebHelper";
        this.f435373i = "";
        this.f435378n = new com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e(new com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e.b("summary", 5, new MmSummaryWebHelper$renderGoneHandler$1(this), new MmSummaryWebHelper$renderGoneHandler$2(this), new MmSummaryWebHelper$renderGoneHandler$3(this), new MmSummaryWebHelper$renderGoneHandler$4(this), new MmSummaryWebHelper$renderGoneHandler$5(this)));
    }

    public final void a(final String r110, final int r111, final int r112, final Function1<? super Boolean, Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, "direction");
        Intrinsics.checkNotNullParameter(r113, "callback");
        OfficeWebView r100 = this.f435369e;
        if (r100 != null) goto L7;
        lvb.a.h(this.f435368d, "[canScroll] webView is null, direction=" + r110 + ", x=" + r111 + ", y=" + r112);
        r113.invoke(Boolean.FALSE);
        return;
    L7:
        if (this.f435371g == true) goto L10;
        lvb.a.h(this.f435368d, "[canScroll] web not ready, direction=" + r110 + ", x=" + r111 + ", y=" + r112);
        r113.invoke(Boolean.FALSE);
        return;
    L10:
        int r101 = b.f435380a;
        Function1<Boolean, Unit> r102 = new MmSummaryWebHelper$canScroll$1(this, r110, r111, r112, r113);
        Intrinsics.checkNotNullParameter(r110, "direction");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Message r114 = new Message();
        r114.setCallbackID("common.checkCanScroll");
        JSONObject r103 = new JSONObject();
        r103.put("x", r111);
        r103.put("y", r112);
        r103.put("direction", r110);
        r114.setData(r103.toString());
        StringCompanionObject r115 = StringCompanionObject.INSTANCE;
        String r116 = String.format(Bridge.CALLBACK_FUN, Arrays.copyOf(new Object[]{e0.c(r114)}, 1));
        lvb.a.a("MmSummaryNativeToJSHelper", "[checkFishBoneCanScroll] script=" + r116);
        r100.evaluateJavascript(r116, new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.web.a(r102));
    }
}
