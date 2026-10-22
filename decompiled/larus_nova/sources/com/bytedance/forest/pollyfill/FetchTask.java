package com.bytedance.forest.pollyfill;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.pollyfill.ttnet.ForestNetAPI;
import com.bytedance.forest.postprocessor.j;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.forest.utils.ThreadUtils;
import com.bytedance.forest.utils.e;
import com.bytedance.lynx.webview.TTWebSdk;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public abstract class FetchTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile State f244386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f244387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f244388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f244389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f244390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Response f244391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f244392g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/forest/pollyfill/FetchTask$State;", "", "PENDING", "SUCCESS", "FAILURE", "CANCEL", "REDIRECTION", "INTERCEPT", "forest_release"}, k = 1, mv = {1, 4, 0})
    public static final enum State extends Enum<State> {
        public static final State CANCEL = null;
        public static final State FAILURE = null;
        public static final State INTERCEPT = null;
        public static final State PENDING = null;
        public static final State REDIRECTION = null;
        public static final State SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f244393a = null;

        static {
            State r100 = new State("PENDING", 0);
            PENDING = r100;
            State r101 = new State("SUCCESS", 1);
            SUCCESS = r101;
            State r102 = new State("FAILURE", 2);
            FAILURE = r102;
            State r103 = new State("CANCEL", 3);
            CANCEL = r103;
            State r104 = new State("REDIRECTION", 4);
            REDIRECTION = r104;
            State r105 = new State("INTERCEPT", 5);
            INTERCEPT = r105;
            f244393a = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f244393a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public void d() {
    }

    public void a() {
        this.f244386a = State.CANCEL;
        this.f244388c = null;
    }

    public boolean b() {
        AtomicInteger r100 = j.f244462a;
        Response r101 = this.f244391f;
        if (r101.f244315q.getEnableTTWebViewDelegate$forest_release() == true) goto L5;
    L53:
        WebResourceResponse r102 = null;
    L54:
        if (r102 == null) goto L58;
        this.f244386a = State.SUCCESS;
        this.f244391f.f244316r = true;
        this.f244388c = null;
        this.f244391f.f244302d = r102;
        this.f244391f.f244313o = true;
        String[] r103 = e.f244536h;
        this.f244392g.b(new String[]{"cdn_download_internal_start"}, null);
        return true;
    L58:
        return false;
    L5:
        if (com.bytedance.forest.utils.b.f244511b == false) goto L57;
    L10:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L53;
        ForestNetAPI.a r105 = r101.f244315q.getHttpRequest$forest_release();
        if (r105 == null) goto L22;
        Map<String, String> r106 = r105.f244425b;
        if (r106 == null) goto L22;
    L31:
        String r107 = j.b();
        Pair[] r108 = new Pair[5];
        r108[0] = TuplesKt.to("X-TTWEB-CONTROL-LOADER-TYPE", "TTNET");
        JSONObject r109 = new JSONObject();
        r109.put("skip_common_business", true);
        r109.put("enable_http_cache", false);
        r109.put("streaming_load", r101.f244315q.getStreamingLoad());
        if (r101.f244315q.getScene() == Scene.WEB_MAIN_DOCUMENT) goto L34;
        boolean r110 = true;
    L35:
        r109.put("follow_redirect_internal", r110);
        r108[1] = TuplesKt.to("X-TTWEB-CONTROL-TTNET-PARAMS", r109.toString());
        ForestNetAPI.a r111 = r101.f244315q.getHttpRequest$forest_release();
        if (r111 == null) goto L40;
        String r112 = r111.f244426c;
        if (r112 == null) goto L40;
    L41:
        if (r112 == null) goto L52;
        r108[2] = TuplesKt.to("X-TTWEB-CONTROL-FINAL-URL", r112);
        r108[3] = TuplesKt.to("X-TTWEB-CONTROL-REQUEST-HEADER", new JSONObject(r106).toString());
        r108[4] = TuplesKt.to("X-TTWEB-CONTROL-HANDLE-ID", r107);
        Map r113 = j.d(MapsKt.mutableMapOf(r108), r107);
        if (r113 == null) goto L53;
        OfflineUtil r114 = OfflineUtil.f244497d;
        String r115 = r101.d();
        String r116 = r101.c();
        ByteArrayInputStream r117 = new ByteArrayInputStream(new byte[0]);
        ForestNetAPI.a r118 = r101.f244315q.getHttpRequest$forest_release();
        if (r118 == null) goto L49;
        String r119 = r118.f244426c;
        if (r119 == null) goto L49;
        String r120 = r119;
    L50:
        r114.getClass();
        r102 = OfflineUtil.c(r115, r116, r117, r120, r113, 200);
    L49:
        r120 = r101.f244315q.getUrl();
        goto L50
    L52:
        throw new IllegalStateException("http url not exists in request");
    L40:
        r112 = r101.f244315q.getUrl();
        goto L41
    L34:
        r110 = false;
    L22:
        Object r121 = r101.f244315q.getWebResourceRequest();
        if ((r121 instanceof WebResourceRequest) == true) goto L25;
        r121 = null;
    L25:
        WebResourceRequest r122 = (WebResourceRequest) r121;
        if (r122 == null) goto L30;
        r106 = r122.getRequestHeaders();
        if (r106 != null) goto L31;
    L30:
        r106 = MapsKt.emptyMap();
        goto L31
    L57:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L13
        if (TTWebSdk.isFeatureSupport("ttnet_native_interceptor", 2) == false) goto L11;
        com.bytedance.forest.utils.b.f244511b = true;     // Catch: Throwable -> L13
        goto L10
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        r104 = false;
    L13:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public void e() {
        String[] r100 = e.f244536h;
        this.f244392g.b(new String[]{"cdn_finish"}, null);
        this.f244386a = State.REDIRECTION;
        this.f244391f.f244316r = true;
        this.f244391f.A = true;
        this.f244388c = null;
    }

    public void f() {
        String[] r100 = e.f244536h;
        this.f244392g.b(new String[]{"cdn_finish"}, null);
        this.f244386a = State.SUCCESS;
        this.f244391f.f244316r = true;
        this.f244388c = null;
    }

    public FetchTask(Response r100, e r101) {
        this.f244391f = r100;
        this.f244392g = r101;
        this.f244386a = State.PENDING;
        Request r102 = r100.f244315q;
        boolean r103 = true;
        if (r102.getOnlyLocal() == false) goto L5;
    L10:
        boolean r104 = true;
    L11:
        this.f244389d = r104;
        if (r104 == true) goto L22;
        Request r105 = r100.f244315q;
        if (r105.getOnlyOnline() == false) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
    L23:
        this.f244390e = r103;
        return;
    L16:
        if (r105.getEnableCDNCache() == false) goto L19;
        r106 = false;
    L22:
        r103 = false;
        goto L23
    L5:
        if (ThreadUtils.a() == true) goto L7;
    L9:
        r104 = false;
        goto L11
    L7:
        if (r102.isASync() == true) goto L9;
        goto L9
    }

    public void c(boolean r100, Throwable r101) {
        String[] r102 = e.f244536h;
        this.f244392g.b(new String[]{"cdn_finish"}, null);
        this.f244386a = State.FAILURE;
        this.f244388c = null;
    }
}
