package v35;

import android.webkit.WebView;
import com.bytedance.ee.bear.document.render.node.perf.SendEventData;
import com.bytedance.ee.bear.document.render.preload.BridgeReadyModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.bytedance.ee.util.ui.j;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.Callback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends AbsChameleonService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f552827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f552828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BearUrl f552829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f552830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f552831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f552832f;

    /* JADX INFO: renamed from: v35.a$a, reason: collision with other inner class name */
    public static final class C7960a {
    }

    public static final class b extends AbsChameleonHandler<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f552833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f552834b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f552834b;
        }

        public b(a r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            this.f552833a = r100;
            this.f552834b = JsBridgeConstants.BIZ_UTIL_HIDELOADING;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            tt5.a.h("SSR_REN_SsrWebViewWebService", "handle BIZ_UTIL_HIDE_LOADING_VIEW");
            a r101 = this.f552833a;
            r101.getClass();
            j.c(new v35.c(r101));
        }
    }

    public interface c {
        void a();

        void b(SendEventData r100);
    }

    public static final class d extends AbsChameleonHandler<BridgeReadyModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f552835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f552836b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f552836b;
        }

        public d(a r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            this.f552835a = r100;
            this.f552836b = JsBridgeConstants.BIZ_NOTIFY_READY;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(BridgeReadyModel r100, Callback r101) {
            BridgeReadyModel r102 = r100;
            Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            tt5.a.h("SSR_REN_SsrWebViewWebService", "handle BIZ_NOTIFY_READY, " + r102);
            a r103 = this.f552835a;
            String r104 = r102.getType();
            r103.getClass();
            j.c(new v35.b(r104, r103));
        }
    }

    public static final class e extends AbsChameleonHandler<SendEventData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f552837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f552838b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f552838b;
        }

        public e(a r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            this.f552837a = r100;
            this.f552838b = "biz.statistics.sendEvent";
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(SendEventData r100, Callback r101) {
            SendEventData r102 = r100;
            Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            tt5.a.h("SSR_REN_SsrWebViewWebService", "handle BIZ_STATISTICS_SENDEVENT, " + r102);
            a r103 = this.f552837a;
            r103.getClass();
            j.c(new v35.d(r103, r102));
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService
    public final ArrayList<AbsChameleonHandler<?>> getBridgeHandlers() {
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new d(this), new b(this), new e(this)});
    }

    public a() {
        this.f552827a = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        this.f552828b = new HashMap();
    }

    public final void e(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        k r102 = getWeb();     // Catch: Throwable -> L10
        Unit r103 = null;
        if (r102 == null) goto L8;
        WebView r104 = r102.getWebView();     // Catch: Throwable -> L10
        if (r104 == null) goto L8;
        r104.evaluateJavascript("javascript:renderCacheHTML(" + r100 + ')', null);     // Catch: Throwable -> L10
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r105 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L10
    L12:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L18;
        tt5.a.f("SSR_REN_SsrWebViewWebService", r106, false);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
