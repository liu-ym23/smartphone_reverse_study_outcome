package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusContainerType;
import com.bytedance.ies.argus.bean.ArgusFeId;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class WebLoadUrlParams extends BaseAspectParams<e0> implements s {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final List<String> f245699p = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f245700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f245703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f245704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f245705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f245706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f245707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f245708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WebLoadPageType f245709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f245710l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WebLoadUrlParams f245711m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f245712n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConcurrentLinkedDeque<Pair<WebLoadRiskTag, WebLoadVerifySource>> f245713o;

    public static final class a {
    }

    public WebLoadUrlParams() {
        throw null;
    }

    static {
        f245699p = CollectionsKt.listOf(new String[]{"about", AdBaseConstants.BYTEDANCE_PACKAGE_NAME_SUFFIX, "javascript"});
    }

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public final com.bytedance.ies.argus.strategy.a f() {
        return new e0();
    }

    public final JSONObject g() {
        JSONObject r100 = new JSONObject();
        JSONUtilsKt.e(r100, "origin_seclink_scene", this.f245702d);
        JSONUtilsKt.d(r100, "url", this.f245701c);
        e0 r101 = e();
        if (r101 == null) goto L6;
        String r102 = r101.e();
        if (r102 == null) goto L6;
    L7:
        JSONUtilsKt.e(r100, "seclink_scene", r102);
        return r100;
    L6:
        r102 = this.f245702d;
        goto L7
    }

    @Override // com.bytedance.ies.argus.api.params.s
    public final String a() {
        e0 r100 = e();
        if (r100 == null) goto L7;
        String r101 = r100.f();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.f245701c;
    }

    public final String h() {
        if (Intrinsics.areEqual(a(), this.f245701c) == true) goto L10;
        int r100 = CommonUtils.f246248a;
        String r101 = a();
        Intrinsics.checkNotNullParameter(r101, "url");
        String r102 = CommonUtils.d(r101);
        if (r102 != null) goto L11;
        return null;
    L11:
        return CommonUtils.f(r102);
    L10:
        return (String) this.f245704f.getValue();
    }

    @Override // com.bytedance.ies.argus.api.params.s
    public final long b() {
        return this.f245712n;
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return g();
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        JSONObject r111 = g();
        JSONUtilsKt.d(r111, MonitorConstants.URL_HOST, this.f245703e);
        JSONUtilsKt.d(r111, "url_protocol", this.f245705g);
        Map<String, String> r100 = this.f245700b;
        if (r100 == null) goto L5;
        Set<String> r101 = r100.keySet();
    L6:
        JSONUtilsKt.d(r111, AdDownloadModel.JsonKey.HEADER_KEYS, r101);
        JSONUtilsKt.d(r111, "is_entry", Boolean.valueOf(this.f245708j));
        WebLoadPageType r102 = this.f245709k;
        WebLoadPageType r103 = WebLoadPageType.WHITE_INNER;
        boolean r104 = true;
        if (r102 != r103) goto L9;
        boolean r105 = true;
    L10:
        JSONUtilsKt.d(r111, "is_inner_host", Boolean.valueOf(r105));
        if (this.f245707i == false) goto L19;
        WebLoadPageType r106 = this.f245709k;
        if (r106 == null) goto L19;
        if (r106 != r103) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == true) goto L19;
    L20:
        JSONUtilsKt.d(r111, "is_third", Boolean.valueOf(r104));
        JSONUtilsKt.d(r111, "url_path", this.f245706h);
        Pair r108 = (Pair) CollectionsKt.last(this.f245713o);
        WebLoadRiskTag r109 = (WebLoadRiskTag) r108.component1();
        WebLoadVerifySource r112 = (WebLoadVerifySource) r108.component2();
        JSONUtilsKt.d(r111, "final_verify_type", r109.getStrValue());
        JSONUtilsKt.d(r111, "final_verify_source", r112.getStrValue());
        JSONUtilsKt.d(r111, "load_verify_record", CollectionsKt.joinToString$default(this.f245713o, ">", null, null, 0, null, WebLoadUrlParams$toMonitorObject$1$2.INSTANCE, 30, null));
        return r111;
    L16:
        r107 = false;
    L19:
        r104 = false;
        goto L20
    L9:
        r105 = false;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final void i(WebLoadVerifySource r100, WebLoadRiskTag r101, WebLoadPageType r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "riskTag");
        this.f245713o.add(new Pair(r101, r100));
        if (r102 == null) goto L6;
        this.f245709k = r102;
        return;
    }

    public WebLoadUrlParams(String r100, String r101, Map r102, int r103) {
        if ((r103 & 128) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f245700b = r102;
        this.f245701c = r100;
        this.f245702d = r101;
        this.f245704f = LazyKt.lazy(new WebLoadUrlParams$parentHost$2(this));
        this.f245710l = LazyKt.lazy(new WebLoadUrlParams$isSecLinkPage$2(this));
        this.f245712n = ArgusFeId.UNSET.getLongValue();
        ArgusContainerType r104 = ArgusContainerType.WEB;
        ConcurrentLinkedDeque<Pair<WebLoadRiskTag, WebLoadVerifySource>> r105 = new ConcurrentLinkedDeque();
        r105.add(new Pair(WebLoadRiskTag.Default, WebLoadVerifySource.Inner));
        this.f245713o = r105;
        URI r106 = new URI(r100);     // Catch: Exception -> L14
        this.f245703e = r106.getHost();     // Catch: Exception -> L14
        this.f245705g = r106.getScheme();     // Catch: Exception -> L14
        this.f245706h = r106.getPath();     // Catch: Exception -> L14
        if (r106.getScheme() != null) goto L9;
    L12:
        this.f245707i = true;     // Catch: Exception -> L14
        return;
    L9:
        if (Intrinsics.areEqual(r106.getScheme(), "http") == true) goto L12;
        if (Intrinsics.areEqual(r106.getScheme(), "https") == true) goto L12;
        return;
    L15:
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == false) goto L21;
        this.f245707i = true;
        return;
    }
}
