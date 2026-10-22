package v35;

import android.webkit.WebView;
import com.bytedance.ee.bear.document.render.node.perf.SendEventData;
import com.bytedance.ee.bear.document.render.preload.BridgeReadyModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.ui.j;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends AbsChameleonService {
    public final com.bytedance.ee.bear.contract.d a;
    public final Map<String, Boolean> b;
    public BearUrl c;
    public String d;
    public c e;
    public long f;

    /* JADX INFO: renamed from: v35.a$a, reason: collision with other inner class name */
    public static final class C0309a {
    }

    public static final class b extends AbsChameleonHandler<Unit> {
        public final a a;
        public final String b;

        public final String getName() {
            return this.b;
        }

        public b(a r2) {
            Intrinsics.checkNotNullParameter(r2, "service");
            this.a = r2;
            this.b = "biz.util.hideLoading";
        }

        public final void handle(Callback r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            tt5.a.h("SSR_REN_SsrWebViewWebService", "handle BIZ_UTIL_HIDE_LOADING_VIEW");
            a r3 = this.a;
            r3.getClass();
            j.c(new v35.c(r3));
        }
    }

    public interface c {
        void a();

        void b(SendEventData r1);
    }

    public static final class d extends AbsChameleonHandler<BridgeReadyModel> {
        public final a a;
        public final String b;

        public final String getName() {
            return this.b;
        }

        public d(a r2) {
            Intrinsics.checkNotNullParameter(r2, "service");
            this.a = r2;
            this.b = "biz.notify.ready";
        }

        public final void handle(Object r2, Callback r3) {
            BridgeReadyModel r4 = (BridgeReadyModel) r2;
            Intrinsics.checkNotNullParameter(r4, "req");
            Intrinsics.checkNotNullParameter(r3, "callback");
            tt5.a.h("SSR_REN_SsrWebViewWebService", "handle BIZ_NOTIFY_READY, " + r4);
            a r5 = this.a;
            String r6 = r4.getType();
            r5.getClass();
            j.c(new v35.b(r6, r5));
        }
    }

    public static final class e extends AbsChameleonHandler<SendEventData> {
        public final a a;
        public final String b;

        public final String getName() {
            return this.b;
        }

        public e(a r2) {
            Intrinsics.checkNotNullParameter(r2, "service");
            this.a = r2;
            this.b = "biz.statistics.sendEvent";
        }

        public final void handle(Object r2, Callback r3) {
            SendEventData r4 = (SendEventData) r2;
            Intrinsics.checkNotNullParameter(r4, "req");
            Intrinsics.checkNotNullParameter(r3, "callback");
            tt5.a.h("SSR_REN_SsrWebViewWebService", "handle BIZ_STATISTICS_SENDEVENT, " + r4);
            a r5 = this.a;
            r5.getClass();
            j.c(new v35.d(r5, r4));
        }
    }

    static {
    }

    public final ArrayList<AbsChameleonHandler<?>> getBridgeHandlers() {
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new d(this), new b(this), new e(this)});
    }

    public a() {
        this.a = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        this.b = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(String r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        k r2 = getWeb();     // Catch: Throwable -> L10
        Unit r3 = null;
        if (r2 == null) goto L8;
        WebView r4 = r2.getWebView();     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        r4.evaluateJavascript("javascript:renderCacheHTML(" + r5 + ')', null);     // Catch: Throwable -> L10
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r6 = Result.constructor-impl(r3);     // Catch: Throwable -> L10
    L12:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L18;
        tt5.a.f("SSR_REN_SsrWebViewWebService", r7, false);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
