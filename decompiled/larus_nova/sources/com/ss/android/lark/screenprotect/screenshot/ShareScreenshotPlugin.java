package com.ss.android.lark.screenprotect.screenshot;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.protocol.emm.api.ISecurityEmmApi;
import com.ss.android.lark.security.protocol.emm.api.SecurityActionType;
import com.ss.android.lark.security.protocol.emm.api.SecurityBizType;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0007J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/screenprotect/screenshot/ShareScreenshotPlugin;", "Lcom/larksuite/framework/apiplugin/AutoRegisterLKPlugin;", "<init>", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", ShareScreenshotPlugin.SHARE_SCREENSHOT, "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "lkBridgeContext", "Lcom/larksuite/framework/apiplugin/LKBridgeContext;", "request", "Lcom/ss/android/lark/screenprotect/screenshot/ShareScreenshotPlugin$ShareScreenshotRequestModel;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/ss/android/lark/screenprotect/screenshot/ShareScreenshotPlugin$ShareScreenshotResponseModel;", "onRelease", "resumeEmm", "exemptionEmm", "Companion", "ShareScreenshotRequestModel", "ShareScreenshotResponseModel", "ApiShareScreenshotErrNo", "screen-protect_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareScreenshotPlugin extends i18.b {
    public static final b Companion = null;
    public static final String SHARE_SCREENSHOT = "shareScreenshot";
    public static final String SHARE_SCREENSHOT_EMM_FG_NAME = "lark.security.open_app_exemption";
    public static final String SHARE_SCREENSHOT_FG_NAME = "lark.security.share_screenshot_plugin";
    public static final String TAG = "SHARE_SS_ShareScreenshotPlugin";
    private Context context;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/screenprotect/screenshot/ShareScreenshotPlugin$ShareScreenshotRequestModel;", "Lcom/larksuite/framework/apiplugin/common/LKBaseRequestModel;", "<init>", "()V", "screen-protect_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ShareScreenshotRequestModel extends LKBaseRequestModel {
        public ShareScreenshotRequestModel() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/screenprotect/screenshot/ShareScreenshotPlugin$ShareScreenshotResponseModel;", "Lcom/larksuite/framework/apiplugin/common/LKBaseResponseModel;", "<init>", "()V", "screen-protect_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ShareScreenshotResponseModel extends LKBaseResponseModel {
        public ShareScreenshotResponseModel() {
        }
    }

    public static final class a extends n18.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f439803c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f439804d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f439805e = null;

        /* JADX INFO: renamed from: com.ss.android.lark.screenprotect.screenshot.ShareScreenshotPlugin$a$a, reason: collision with other inner class name */
        public static final class C5282a {
        }

        static {
            f439803c = new a(1019001, "Failed to capture screenshot");
            f439804d = new a(1019002, "Failed to forward screenshot");
            f439805e = new a(1019003, "Forwarding canceled by user");
        }

        public a(int r100, String r101) {
            super(r100, r101);
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    private final void exemptionEmm() {
        if (FeatureGatingModule.getFeatureGatingService().isEnable(SHARE_SCREENSHOT_EMM_FG_NAME) == true) goto L13;
        return;
    L13:
        Iterator r100 = ClaymoreServiceLoader.loadAll(ISecurityEmmApi.class);     // Catch: Exception -> L10
    L7:
        if (r100.hasNext() == false) goto L17;
        ((ISecurityEmmApi) r100.next()).requestExemptionAction(SecurityBizType.SCREEN_CAPTURE_PROTECT, SecurityActionType.EXEMPT);     // Catch: Exception -> L10
        ScsLogger.d(TAG, "ISecurityEmmApi requestExemptionAction SCREEN_CAPTURE_PROTECT exemption success.");     // Catch: Exception -> L10
        goto L7
    L17:
        return;
    L10:
        e = move-exception;
        int r101 = ScsLogger.f440428a;
        ScsLogger.c(TAG, "ISecurityEmmApi requestExemptionAction SCREEN_CAPTURE_PROTECT exemption error, msg:" + e.getMessage());
    }

    private final void resumeEmm() {
        if (FeatureGatingModule.getFeatureGatingService().isEnable(SHARE_SCREENSHOT_EMM_FG_NAME) == true) goto L13;
        return;
    L13:
        Iterator r100 = ClaymoreServiceLoader.loadAll(ISecurityEmmApi.class);     // Catch: Exception -> L10
    L7:
        if (r100.hasNext() == false) goto L17;
        ((ISecurityEmmApi) r100.next()).requestExemptionAction(SecurityBizType.SCREEN_CAPTURE_PROTECT, SecurityActionType.RESUME);     // Catch: Exception -> L10
        ScsLogger.d(TAG, "ISecurityEmmApi requestExemptionAction SCREEN_CAPTURE_PROTECT resume success.");     // Catch: Exception -> L10
        goto L7
    L17:
        return;
    L10:
        e = move-exception;
        int r101 = ScsLogger.f440428a;
        ScsLogger.c(TAG, "ISecurityEmmApi requestExemptionAction SCREEN_CAPTURE_PROTECT resume error, msg:" + e.getMessage());
    }

    @Override // i18.d
    public void onRelease() {
        ScsLogger.d(TAG, "ShareScreenshotPlugin onRelease()");
        Map<Integer, ShareScreenshotUtil.b> r100 = ShareScreenshotUtil.f439807b;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (Intrinsics.areEqual(((ShareScreenshotUtil.b) r103.getValue()).getContext(), this.context) == false) goto L4;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L8:
        Iterator r104 = r101.keySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        int r105 = ((Number) r104.next()).intValue();
        ShareScreenshotUtil r106 = ShareScreenshotUtil.f439806a;
        ShareScreenshotUtil.d(r105);
        goto L10
    L12:
        this.context = null;
    }

    public ShareScreenshotPlugin() {
    }

    public static final /* synthetic */ void access$resumeEmm(ShareScreenshotPlugin r100) {
        r100.resumeEmm();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larksuite.framework.callback.IGetDataCallback, com.ss.android.lark.screenprotect.screenshot.ShareScreenshotPlugin$shareScreenshot$1$1, java.lang.Object] */
    @LKPluginFunction(async = true, eventName = {SHARE_SCREENSHOT})
    public final void shareScreenshot(final LKEvent r110, final i18.c r111, ShareScreenshotRequestModel r112, final j18.f<ShareScreenshotResponseModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "lkEvent");
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable(SHARE_SCREENSHOT_FG_NAME) == true) goto L8;
        ScsLogger.d(TAG, "ShareScreenshotPlugin.shareScreenshot, fg is close!");
        ShareScreenshotResponseModel r114 = new ShareScreenshotResponseModel();
        r114.setApiErrNo(o18.a.f521727f);
        if (r113 == null) goto L41;
        r113.callback(r114);
        return;
    L41:
        return;
    L8:
        Context r115 = null;
        if (r111 == null) goto L11;
        Context r100 = r111.getContext();
    L12:
        this.context = r100;
        if (r111 == null) goto L16;
        r115 = r111.getContext();
    L16:
        if ((r115 instanceof Activity) == false) goto L18;
        Activity r116 = ContextsKt.requireActivity(r111.getContext());
    L19:
        if (r116 == null) goto L37;
        exemptionEmm();
        final Activity r101 = r116;
        ?? r102 = new ShareScreenshotPlugin$shareScreenshot$1$1(this, r113, r111, r110, r101);
        int r117 = m.f439829a;
        Intrinsics.checkNotNullParameter(r116, "activity");
        Intrinsics.checkNotNullParameter(r102, "callback");
        View r118 = ((ViewGroup) r116.findViewById(R.id.content)).getRootView();
        Window r103 = r116.getWindow();
        Intrinsics.checkNotNullParameter(r103, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r118 != null) goto L23;
        Log.e("SHARE_SS_ScreenshotUtil", "getScreenshot view is null");
        r102.onError(new ErrorResult("getScreenshot view is null"));
        return;
    L23:
        int r119 = r118.getWidth();
        if (r119 > 0) goto L26;
        String r120 = "getScreenshot view.getWidth() <= 0, view.getWidth() = " + r119;
        Log.e("SHARE_SS_ScreenshotUtil", r120);
        r102.onError(new ErrorResult(r120));
        return;
    L26:
        int r121 = r118.getHeight();
        if (r121 > 0) goto L30;
        String r122 = "getScreenshot view.getHeight() <= 0, view.getWidth() = " + r121;
        Log.e("SHARE_SS_ScreenshotUtil", r122);
        r102.onError(new ErrorResult(r122));
        return;
    L30:
        if (Build.VERSION.SDK_INT < 26) goto L36;
        Bitmap r104 = Bitmap.createBitmap(r118.getWidth(), r118.getHeight(), Bitmap.Config.ARGB_8888);
        j r123 = new j(r102, r104);
        Handler r124 = new Handler(Looper.getMainLooper());
        int[] r105 = new int[2];     // Catch: Exception -> L34
        r118.getLocationInWindow(r105);     // Catch: Exception -> L34
        wf7.b r106 = wf7.b.f559487a;     // Catch: Exception -> L34
        int r107 = r105[0];     // Catch: Exception -> L34
        r106.e(r103, new Rect(r107, r105[1], r118.getWidth() + r107, r105[1] + r118.getHeight()), r104, r123, r124, new Token("LARK-PSDA-openapi-share-screenshot-pixelcopy"));     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        Log.e("SHARE_SS_ScreenshotUtil", "screenshotAndroidO error", e);
        r124.post(new l(r123));
        return;
    L36:
        UICallbackExecutor.execute(new k(r118, r102));
        return;
    L37:
        ScsLogger.c(TAG, "activity is null， cant do screenshot！");
        ShareScreenshotUtil r125 = ShareScreenshotUtil.f439806a;
        ShareScreenshotUtil.c(r113);
        return;
    L18:
        ScsLogger.d(TAG, "ShareScreenshotPlugin.shareScreenshot, lkBridgeContext?.context is not Activity");
        r116 = AppLifecycle.a.f408803a.f();
        goto L19
    L11:
        r100 = null;
        goto L12
    }
}
