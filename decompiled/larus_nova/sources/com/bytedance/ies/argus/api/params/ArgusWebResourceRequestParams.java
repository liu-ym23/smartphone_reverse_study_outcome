package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusWebResourceRequestParams extends BaseAspectParams<l> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<String, Integer> f245651m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map<String, Integer> f245652n = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArgusRequestNetworkType f245653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f245656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f245657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f245658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f245659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f245660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f245661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f245662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f245663l;

    public static final class a {
    }

    static {
        List r100 = CollectionsKt.listOf(new String[]{"audio", "video", "image", "style", "audioworklet", "paintworklet", LynxResourceModule.FONT_TYPE, GXTemplateKey.GAIAX_TRACK, "report"});
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Object r103 = r102.next();
        String r104 = (String) r103;
        r101.put(r103, 1);
        goto L4
    L6:
        f245651m = r101;
        List r105 = CollectionsKt.listOf(new String[]{"mcs.snssdk.com", "zijieapi.com", "seclink.bytedance.com", "bytegoofy.com"});
        LinkedHashMap r106 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r105, 10)), 16));
        Iterator r107 = r105.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        Object r108 = r107.next();
        String r109 = (String) r108;
        r106.put(r108, 1);
        goto L8
    L10:
        f245652n = r106;
    }

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public final com.bytedance.ies.argus.strategy.a f() {
        return new l(0);
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return JSONUtilsKt.d(new JSONObject(), "url", this.f245655d);
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = JSONUtilsKt.d(JSONUtilsKt.d(JSONUtilsKt.d(JSONUtilsKt.d(JSONUtilsKt.d(JSONUtilsKt.d(new JSONObject(), MonitorConstants.URL_HOST, this.f245660i), "url", this.f245655d), "is_for_main_frame", this.f245656e), "is_redirect", this.f245657f), com.alipay.sdk.m.p.e.f25671s, this.f245658g), "type", (String) this.f245662k.getValue());
        Map<String, String> r102 = this.f245659h;
        if (r102 == null) goto L5;
        Set<String> r103 = r102.keySet();
    L7:
        return JSONUtilsKt.d(JSONUtilsKt.d(JSONUtilsKt.d(JSONUtilsKt.d(r101, AdDownloadModel.JsonKey.HEADER_KEYS, r103), "network_type", this.f245653b.getStr()), "is_inner_host", Boolean.valueOf(((Boolean) this.f245663l.getValue()).booleanValue())), "view_url", this.f245654c);
    L5:
        r103 = null;
        goto L7
    }

    public ArgusWebResourceRequestParams(final String r100, WebResourceRequest r101, ArgusRequestNetworkType r102) {
        Intrinsics.checkNotNullParameter(r102, "networkType");
        this.f245653b = r102;
        int r103 = Build.VERSION.SDK_INT;
        Object r104 = null;
        if (r100 != null) goto L8;
        if (r101 == null) goto L6;
        Uri r105 = r101.getUrl();
    L7:
        String r106 = String.valueOf(r105);
    L9:
        this.f245655d = r106;
        if (r101 == null) goto L12;
        Boolean r107 = Boolean.valueOf(r101.isForMainFrame());
    L13:
        this.f245656e = r107;
        if (r103 < 24) goto L17;
        if (r101 == null) goto L17;
        Boolean r108 = Boolean.valueOf(r101.isRedirect());
    L18:
        this.f245657f = r108;
        if (r101 == null) goto L21;
        String r109 = r101.getMethod();
    L22:
        this.f245658g = r109;
        if (r101 == null) goto L25;
        Map<String, String> r110 = r101.getRequestHeaders();
    L26:
        this.f245659h = r110;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L29
        Object r112 = Result.m9449constructorimpl(new URI(r100).getHost());     // Catch: Throwable -> L29
    L32:
        if (Result.m9455isFailureimpl(r112) == true) goto L35;
        r104 = r112;
    L35:
        this.f245660i = (String) r104;
        this.f245661j = LazyKt.lazy(new ArgusWebResourceRequestParams$urlParentHost$2(this));
        this.f245662k = LazyKt.lazy(new ArgusWebResourceRequestParams$type$2(this));
        this.f245663l = LazyKt.lazy(new ArgusWebResourceRequestParams$isInnerHost$2(r100, this));
        return;
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L25:
        r110 = null;
        goto L26
    L21:
        r109 = null;
    L17:
        r108 = null;
        goto L18
    L12:
        r107 = null;
        goto L13
    L6:
        r105 = null;
        goto L7
    L8:
        r106 = r100;
        goto L9
    }
}
