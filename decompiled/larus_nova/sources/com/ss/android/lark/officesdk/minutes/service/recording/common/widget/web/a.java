package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f435504a;

    public a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "renderGoneHandler");
        this.f435504a = r100;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        e r102 = this.f435504a;
        r102.getClass();
        long r103 = System.currentTimeMillis();
        int r104 = Build.VERSION.SDK_INT;
        int r105 = 0;
        if (r104 < 26) goto L6;
        if (r101 == null) goto L6;
        boolean r106 = r101.didCrash();
    L7:
        if (r104 < 26) goto L10;
        if (r101 == null) goto L10;
        r105 = r101.rendererPriorityAtExit();
    L10:
        lvb.a.b(r102.f435509b, "[handleRenderProcessGone] didCrash=" + r106 + ", rendererPriority=" + r105 + ", isInBackground=" + r102.f435512e + ", recreateCount=" + r102.f435510c);
        if (r102.f435508a.f435517d.invoke(r100).booleanValue() == true) goto L17;
        String r107 = r102.f435509b;
        StringBuilder r108 = new StringBuilder("[handleRenderProcessGone] ignore stale webView callback, callbackWebView=");
        if (r100 == null) goto L15;
        Integer r109 = Integer.valueOf(r100.hashCode());
    L16:
        r108.append(r109);
        lvb.a.b(r107, r108.toString());
    L27:
        return true;
    L15:
        r109 = null;
        goto L16
    L17:
        r102.f435508a.f435518e.invoke();
        Function2<String, JSONObject, Unit> r110 = r102.f435508a.f435521h;
        JSONObject r111 = new JSONObject();
        r111.put("did_crash", r106);
        r111.put("renderer_priority", r105);
        r111.put("web_view_type", r102.f435508a.f435514a);
        r111.put("is_in_background", r102.f435512e);
        r111.put("recreate_count", r102.f435510c);
        Unit r112 = Unit.INSTANCE;
        r110.invoke("mm_webview_render_gone", r111);
        long r113 = r103 - r102.f435511d;
        e.b r114 = r102.f435508a;
        if (r113 >= r114.f435516c) goto L21;
        lvb.a.b(r102.f435509b, "[handleRenderProcessGone] in cooldown period, mark load failed");
        r102.f435508a.f435520g.invoke();
        goto L27
    L21:
        if (r102.f435510c < r114.f435515b) goto L24;
        lvb.a.b(r102.f435509b, "[handleRenderProcessGone] max recreate count reached");
        r102.f435508a.f435520g.invoke();
        goto L27
    L24:
        if (r102.f435512e == false) goto L26;
        lvb.a.e(r102.f435509b, "[handleRenderProcessGone] in background, mark need recreate on resume");
        r102.f435513f = true;
        goto L27
    L26:
        r102.b();
    L6:
        r106 = false;
        goto L7
    }
}
