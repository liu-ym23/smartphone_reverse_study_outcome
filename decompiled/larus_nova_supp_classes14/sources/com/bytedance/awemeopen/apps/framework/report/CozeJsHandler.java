package com.bytedance.awemeopen.apps.framework.report;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.RecommendFirstBrushDataHelper;
import com.bytedance.awemeopen.domain.feed.preload.AosPreloadCacheStrategy;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\tR\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/report/CozeJsHandler;", "", "Lorg/json/JSONObject;", "paramJson", "Lkotlin/Function1;", "", "", "callBack", "tryOpenFeed", "", "data", "onWebExecute", "", "code", "msg", "fn", "callback", "Landroid/webkit/WebView;", "webview", "Landroid/webkit/WebView;", "getWebview", "()Landroid/webkit/WebView;", "isEntering", "Z", "<init>", "(Landroid/webkit/WebView;)V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CozeJsHandler {
    public static final a Companion = null;
    private static final String TAG = "CozeJsHandler";
    private boolean isEntering;
    private final WebView webview;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final WebView getWebview() {
        return this.webview;
    }

    public CozeJsHandler(WebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webview");
        this.webview = r2;
    }

    @JavascriptInterface
    public final void onWebExecute(String r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        AoLogger.g(TAG, new Object[]{"onWebExecute", r8});     // Catch: Exception -> L11
        JSONObject r4 = new JSONObject(r8);     // Catch: Exception -> L11
        String r9 = r4.optString("method");     // Catch: Exception -> L11
        JSONObject r5 = r4.optJSONObject("param");     // Catch: Exception -> L11
        final String r6 = r4.optString("callbackName");     // Catch: Exception -> L11
        if (Intrinsics.areEqual(r9, "openVideo") == false) goto L7;
        tryOpenFeed(r5, new C02361(this, r6));     // Catch: Exception -> L11
    L14:
        return;
    L7:
        if (Intrinsics.areEqual(r9, "close") == false) goto L9;
        Context r10 = this.webview.getContext();     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.app.Activity");     // Catch: Exception -> L11
        ((Activity) r10).finish();     // Catch: Exception -> L11
        callback(1, "", null, r6);     // Catch: Exception -> L11
        goto L14
    L9:
        callback(0, "not handled", null, r6);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        AoLogger.c(TAG, new Object[]{"error onWebExecute", e});
    }

    public static final /* synthetic */ void access$setEntering$p(CozeJsHandler r0, boolean r1) {
        r0.isEntering = r1;
    }

    private final void tryOpenFeed(JSONObject r14, final Function1<? super Boolean, Unit> r15) {
        if (this.isEntering == false) goto L5;
        return;
    L5:
        if (r14 == null) goto L7;
        String r16 = r14.optString("itemId", "");
    L8:
        final String r0 = r16;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        r15.invoke(Boolean.FALSE);
    L17:
        this.isEntering = true;
        int r17 = RecommendFirstBrushDataHelper.a;
        RecommendFirstBrushDataHelper.a(r0, null, null, null, null, null, null, null, null, AosPreloadCacheStrategy.ONLY_NEED_SPECIFIED_AIDS, null, false, new C02371(this, r15, r0));
        return;
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
        goto L15
    L7:
        r16 = null;
        goto L8
    }

    public final void callback(int r3, String r4, JSONObject r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        Intrinsics.checkNotNullParameter(r6, "fn");
        final String r7 = "window." + r6 + '(' + r3 + ",'" + r4 + "'," + r5 + ')';
        AoPool.g(new AnonymousClass1(this, r7));
    }
}
