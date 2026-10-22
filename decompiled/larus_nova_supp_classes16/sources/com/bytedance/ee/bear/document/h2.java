package com.bytedance.ee.bear.document;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.larkwebview.util.NetWorkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h2 extends WebViewClient {
    public static final HashMap<Integer, Integer> a = null;
    public static final int[] b = null;

    static {
        a = new HashMap();
        b = new int[]{-2, -4, -8};
    }

    public h2() {
        HashMap<Integer, Integer> r0 = a;
        r0.put(-8, -1);
        r0.put(-1, -2);
        r0.put(-2, -3);
        r0.put(-3, -4);
        r0.put(-6, -5);
        r0.put(10002, 10002);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r3, RenderProcessGoneDetail r4) {
        if ((r3 instanceof DocBridgeWebViewV2) == false) goto L6;
        ((DocBridgeWebViewV2) r3).P(r4.didCrash(), r4.rendererPriorityAtExit());
    L6:
        if (r4.didCrash() == true) goto L8;
        tt5.a.d("DocWebViewClient", "System killed the WebView======= not crashed");
        return true;
    L8:
        tt5.a.d("DocWebViewClient", "System killed the WebView======= crashed");
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r2, String r3, Bitmap r4) {
        super.onPageStarted(r2, r3, r4);
        tt5.a.h("DocWebViewClient", "start page load, url = " + du5.b.k(r3));
        if (TextUtils.equals(r3, "javascript:clear()") == true) goto L6;
        tt5.a.b("DocWebViewClient", "set webview visible");
        r2.setVisibility(0);
        return;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r6, WebResourceRequest r7, WebResourceError r8) {
        super.onReceivedError(r6, r7, r8);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L8:
        tt5.a.k("DocWebViewClient", "onReceivedError: received error, error = " + r8.toString() + ", url = ");
        return;
    L5:
        if (a.get(Integer.valueOf(r8.getErrorCode())) != null) goto L7;
        return;
    L7:
        tt5.a.k("DocWebViewClient", "onReceivedError: received error, error = " + r8.toString() + ", url = ");
        a(r6, r7.getUrl().toString(), r8.getErrorCode(), r8.getDescription().toString());
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r1, WebResourceRequest r2, WebResourceResponse r3) {
        super.onReceivedHttpError(r1, r2, r3);
        tt5.a.k("DocWebViewClient", "onReceivedHttpError: received error, error = " + r3.getStatusCode() + ", url = ");
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView r3, SslErrorHandler r4, SslError r5) {
        super.onReceivedSslError(r3, r4, r5);
        tt5.a.k("DocWebViewClient", "onReceivedSslError: received error, error = " + (r5.getPrimaryError() + 10000) + "， url = ");
        a(r3, r5.getUrl(), 10002, r5.toString());
    }

    public final void a(final WebView r12, final String r13, final int r14, final String r16) {
        if ((r12 instanceof DocBridgeWebViewV2) == false) goto L153;
        boolean r1 = true;
        if ((!idb.f.a().isCurrentEnable("ccm.mobile.vpn_iframe_notify")) == true) goto L7;
    L133:
        b(r12, r13, r14, r16, false);
        return;
    L7:
        if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.b.class)).isPrimaryHost() == false) goto L133;
        int r0 = 0;
    L9:
        int[] r3 = b;
        if (r0 >= r3.length) goto L15;
        if (r14 == r3[r0]) goto L13;
        r0 = r0 + 1;
        goto L9
    L13:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L133;
        int r4 = HostIsPrivateChecker.a;
        Intrinsics.checkNotNullParameter(r13, "hostName");
        Log.i("HostIsPrivateChecker", "call api :" + r13);
        if (r13.length() != 0) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == false) goto L135;
        Flowable r6 = Flowable.just(Boolean.FALSE);
    L132:
        r6.subscribe(new f2(this, r12, r13, r14, r16), new g2(this, r12, r13, r14, r16));
        return;
    L135:
        HostIsPrivateChecker.OpenplatformErrorPageInfo r7 = (HostIsPrivateChecker.OpenplatformErrorPageInfo) SettingManager.getInstance().get(HostIsPrivateChecker.OpenplatformErrorPageInfo.class);     // Catch: Exception -> L29
        if (r7 == null) goto L28;
        String r8 = r7.b();     // Catch: Exception -> L29
    L32:
        if (TextUtils.isEmpty(r8) == false) goto L34;
    L42:
        boolean r9 = true;
    L43:
        if (r9 == false) goto L130;
        HostIsPrivateChecker.OpenplatformErrorPageInfo r10 = (HostIsPrivateChecker.OpenplatformErrorPageInfo) SettingManager.getInstance().get(HostIsPrivateChecker.OpenplatformErrorPageInfo.class);
        if (r10 == null) goto L127;
        List<String> r11 = r10.a();
        if (r11 == null) goto L127;
        List r17 = CollectionsKt.filterNotNull(r11);
        if (r17 == null) goto L127;
        List r18 = r17;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L52:
        if (r20.hasNext() == false) goto L64;
        String r21 = (String) r20.next();
        String r22 = UriProtector.parse(r21).getHost();
        if (r22 != null) goto L56;
    L59:
        boolean r23 = true;
    L60:
        if (r23 == true) goto L63;
        r21 = r22;
    L63:
        r19.add(r21);
        goto L52
    L56:
        if (r22.length() == 0) goto L59;
        r23 = false;
        goto L60
    L64:
        ArrayList r24 = new ArrayList();
        Iterator r26 = r19.iterator();
    L66:
        if (r26.hasNext() == false) goto L73;
        Object r27 = r26.next();
        if (((String) r27).length() <= 0) goto L70;
        boolean r28 = true;
    L71:
        if (r28 == false) goto L66;
        r24.add(r27);
        goto L66
    L70:
        r28 = false;
        goto L71
    L73:
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r30 = r24.iterator();
    L75:
        if (r30.hasNext() == false) goto L77;
        r29.add("https://" + ((String) r30.next()));
        goto L75
    L77:
        Uri r31 = UriProtector.parse(r13);
        String r32 = r31.getScheme();
        if (r32 != null) goto L80;
    L83:
        boolean r33 = true;
    L84:
        if (r33 == false) goto L86;
    L91:
        String r34 = r31.getHost();
        if (r34 != null) goto L94;
    L97:
        boolean r36 = true;
    L98:
        if (r36 == false) goto L100;
        Uri r37 = UriProtector.parse("https://".concat(r13));
    L101:
        Intrinsics.checkNotNullParameter(r29, "gadgetSafeDomains");
        Iterator r38 = r29.iterator();
    L103:
        if (r38.hasNext() == false) goto L126;
        String r39 = (String) r38.next();
        Log.i("HostIsPrivateChecker", "safeHost:" + r39);
        if (TextUtils.isEmpty(r39) == true) goto L123;
        if (r37 == null) goto L123;
        if (r37.isOpaque() == true) goto L123;
        Uri r40 = UriProtector.parse(r39);
        String r41 = r40.getScheme();
        String r42 = r40.getHost();
        if (TextUtils.equals(r41, r37.getScheme()) == false) goto L123;
        if (new StringTokenizer(r42, ".").countTokens() < 2) goto L123;
        String r43 = r37.getHost();
        if (r43 == null) goto L123;
        if (TextUtils.equals(r43, r42) == false) goto L121;
    L122:
        boolean r44 = true;
    L124:
        if (r44 == false) goto L103;
        boolean r46 = true;
    L128:
        if (r46 == false) goto L130;
    L131:
        r6 = Flowable.just(Boolean.valueOf(r1));
        goto L132
    L121:
        if (StringsKt.endsWith$default(r43, "." + r42, false, 2, null) == true) goto L122;
    L123:
        r44 = false;
        goto L124
    L126:
        Log.e("HostIsPrivateChecker", "not safe url");
        goto L127
    L100:
        r37 = UriProtector.parse("https://" + r31.getHost());
        goto L101
    L94:
        if (r34.length() == 0) goto L97;
        r36 = false;
        goto L98
    L86:
        if (Intrinsics.areEqual(r32, "http") == true) goto L91;
        if (Intrinsics.areEqual(r32, "https") == true) goto L91;
        Log.i("HostIsPrivateChecker", "jundgeIsPrivateHostBySetting target scheme illegal, scheme: " + r32);
        goto L127
    L80:
        if (r32.length() == 0) goto L83;
        r33 = false;
    L127:
        r46 = false;
    L130:
        r1 = false;
        goto L131
    L34:
        if (com.bytedance.apm.util.u.a() == true) goto L42;
        Pair r47 = NetWorkUtils.c(r8, true, 1);
        if (TextUtils.isEmpty((CharSequence) r47.first) == false) goto L38;
    L40:
        r9 = false;
    L41:
        Log.i("HostIsPrivateChecker", "pingPublicHostSuc: " + r9);
        goto L43
    L38:
        if (((Number) r47.second).floatValue() <= 0.0f) goto L40;
        r9 = true;
        goto L41
    L28:
        r8 = null;
    L29:
        e = move-exception;
        Log.e("HostIsPrivateChecker", "get setting failed", e);
        r8 = "";
        goto L32
    L20:
        r5 = false;
        goto L21
    L15:
        r2 = false;
        goto L16
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r3, int r4, String r5, String r6) {
        super.onReceivedError(r3, r4, r5, r6);
        if (a.get(Integer.valueOf(r4)) != null) goto L5;
        return;
    L5:
        a(r3, r6, r4, r5);
        tt5.a.k("DocWebViewClient", "onReceivedHttpError: received error, error = " + r4 + " desc = " + r5 + ", url = ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(WebView r2, String r3, int r4, String r5, boolean r6) {
        JSONObject r0 = new JSONObject();
        r0.put("url", r3);
        if (r6 == false) goto L5;
        int r7 = -100000;
    L6:
        r0.put("errorCode", Integer.valueOf(r7));
        r0.put("errorMsg", r5);
        ((DocBridgeWebViewV2) r2).F("javascript:window.lark.biz.notifyFrameError", r0);
        return;
    L5:
        r7 = a.get(Integer.valueOf(r4)).intValue();
        goto L6
    }
}
