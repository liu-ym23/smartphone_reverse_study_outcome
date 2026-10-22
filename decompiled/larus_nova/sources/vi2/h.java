package vi2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.host.network.LiveCommerceApi;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.LiveSettingKeys;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f555073a = null;

    public class a implements f<ECCurrentPromotion> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f555074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f555075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f555076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f555077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f555078e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f555079f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f555080g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f555081h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f555082i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.model.response.s f555083j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ uj2.c f555084k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f555085l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f555086m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f555087n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ boolean f555088o;

        @Override // vi2.h.f
        public final wi2.a<ECCurrentPromotion> execute() throws Exception {
            FilterNullArrayList r100 = new FilterNullArrayList();
            if (this.f555074a == false) goto L5;
            int r101 = 61;
        L6:
            String r102 = String.valueOf(r101);
            int r103 = si2.k.f542177c;
            r100.add(si2.k.a.a("request_scene", r102));
            Map r104 = this.f555075b;
            if (r104 == null) goto L12;
            Iterator r105 = r104.entrySet().iterator();
        L10:
            if (r105.hasNext() == false) goto L12;
            Map.Entry r106 = (Map.Entry) r105.next();
            r100.add(si2.k.a.a((String) r106.getKey(), (String) r106.getValue()));
        L12:
            r100.add(si2.k.a.a("room_unique_key", this.f555076c));
            boolean r107 = true;
            String r108 = "0";
            String r109 = "1";
            if (hh2.f.g() == false) goto L51;
            h.b(r100, this.f555077d, true);
            r100.add(si2.k.a.a("sec_author_id", this.f555078e));
            r100.add(si2.k.a.a("room_id", this.f555079f));
            r100.add(si2.k.a.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f555080g));
            r100.add(si2.k.a.a("op_type", this.f555081h));
            r100.add(si2.k.a.a("use_new_price", String.valueOf(LiveSettingKeys.getEC_LIVE_CARD_USE_NEW_PRICE())));
            r100.add(si2.k.a.a("opt_entrance_info", "1"));
            r100.add(si2.k.a.a("is_retry", String.valueOf(this.f555082i)));
            if (this.f555074a == false) goto L17;
            r108 = "1";
        L17:
            r100.add(si2.k.a.a("first_enter", r108));
            com.bytedance.android.ec.model.response.s r110 = this.f555083j;
            if (r110 != null) goto L138;
        L23:
            Map<String, String> r111 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r100);
            ECLiveABUtils r112 = ECLiveABUtils.INSTANCE;
            if (r112.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L29;
            if (this.f555084k == null) goto L29;
            int r113 = com.bytedance.android.livesdk.livecommerce.network.hook.a.f149493a;
            this.f555084k.a(com.bytedance.android.livesdk.livecommerce.network.hook.a.a(this.f555085l, r100));
        L29:
            if (this.f555086m == false) goto L31;
            SsResponse r114 = h.h(this.f555085l, r100);
        L33:
            if (r112.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L37;
            uj2.c r115 = this.f555084k;
            if (r115 == null) goto L37;
            r115.b(Integer.valueOf(r114.code()));
        L37:
            ECCurrentPromotion r116 = (ECCurrentPromotion) h.j(r114, ECCurrentPromotion.class);
            if (r116 != null) goto L40;
        L48:
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.a(this.f555079f, this.f555076c, this.f555087n, r116);
            return h.f(r116, r111, r114);
        L40:
            if (r116.statusCode != 0) goto L48;
            if (r116.a() != null) goto L44;
        L46:
            r107 = false;
        L47:
            int r117 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.f152313a;
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.d(this.f555085l.replaceFirst(si2.g.f542149a, ""), this.f555079f, this.f555076c, r107);
            goto L48
        L44:
            if (r116.a().size() <= 0) goto L46;
        L31:
            r114 = h.i(si2.g.f542166p, r100);
            goto L33
        L138:
            String r118 = new Gson().toJson(r110);     // Catch: Exception -> L21
        L22:
            r100.add(si2.k.a.a("pop_product_info", r118));
        L21:
            r118 = null;
            goto L22
        L51:
            if (this.f555074a == false) goto L53;
            int r119 = com.bytedance.android.livesdk.livecommerce.kmp.a.f149243a;
            Intrinsics.checkNotNullParameter("pop_card_enter_request", "scene");
        L53:
            OptCardUtil.b(null, "getPopPromotion request start");
            if (OptCardUtil.f45543a == false) goto L58;
            cl.d r120 = com.bytedance.android.ec.sdk.helper.k.a();
            if (r120 == null) goto L58;
            r120.m();
        L58:
            h.b(r100, this.f555077d, false);
            r100.add(si2.k.a.a("sec_author_id", this.f555078e));
            r100.add(si2.k.a.a("room_id", this.f555079f));
            r100.add(si2.k.a.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f555080g));
            r100.add(si2.k.a.a("op_type", this.f555081h));
            r100.add(si2.k.a.a("use_new_price", String.valueOf(LiveSettingKeys.getEC_LIVE_CARD_USE_NEW_PRICE())));
            r100.add(si2.k.a.a("opt_entrance_info", "1"));
            r100.add(si2.k.a.a("is_retry", String.valueOf(this.f555082i)));
            if (this.f555074a == true) goto L62;
            r109 = "0";
        L62:
            r100.add(si2.k.a.a("first_enter", r109));
            com.bytedance.android.ec.model.response.s r121 = this.f555083j;
            if (r121 != null) goto L140;
        L68:
            Map<String, String> r122 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r100);
            if (this.f555088o == false) goto L75;
            String r123 = this.f555079f;
            String r124 = this.f555076c;
            ECLivePerformanceMonitor.b r125 = ECLivePerformanceMonitor.f149745x;
            ECLivePerformanceMonitor r126 = ECLivePerformanceMonitor.c.a(r123, r124);
            if (r126 == null) goto L75;
            r126.u("ec_perf_duration_shopping_card", "pop_api_pure_start", Long.valueOf(SystemClock.elapsedRealtime()));
            String r127 = r126.f149762p;
            if (r127 == null) goto L75;
            Map<String, com.bytedance.android.ec.core.monitor.a> r128 = com.bytedance.android.ec.core.monitor.c.f45142a;
            com.bytedance.android.ec.core.monitor.c.h(r127, MetricNames.POP_API_PURE_DURATION, null);
        L75:
            ECLiveABUtils r129 = ECLiveABUtils.INSTANCE;
            if (r129.getEC_LIVE_ENABLE_API_ERROR_REPORT() == true) goto L78;
        L80:
            SsResponse r130 = h.h(this.f555085l, r100);
            OptCardUtil.b(null, "getPopPromotion request end");
            if (r129.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L86;
            uj2.c r131 = this.f555084k;
            if (r131 == null) goto L86;
            r131.b(Integer.valueOf(r130.code()));
        L86:
            if (this.f555088o == false) goto L92;
            String r132 = this.f555079f;
            String r133 = this.f555076c;
            ECLivePerformanceMonitor.b r134 = ECLivePerformanceMonitor.f149745x;
            ECLivePerformanceMonitor r135 = ECLivePerformanceMonitor.c.a(r132, r133);
            if (r135 == null) goto L92;
            r135.u("ec_perf_duration_shopping_card", "pop_api_pure_end", Long.valueOf(SystemClock.elapsedRealtime()));
            String r136 = r135.f149762p;
            if (r136 == null) goto L92;
            Map<String, com.bytedance.android.ec.core.monitor.a> r137 = com.bytedance.android.ec.core.monitor.c.f45142a;
            com.bytedance.android.ec.core.monitor.c.j(r136, MetricNames.POP_API_PURE_DURATION);
        L92:
            ECCurrentPromotion r138 = (ECCurrentPromotion) h.j(r130, ECCurrentPromotion.class);
            if (r138 != null) goto L95;
        L113:
            String r139 = "";
        L114:
            com.bytedance.android.livesdk.livecommerce.network.hook.c.f149498a.a(this.f555079f, this.f555076c, r138);
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.a(this.f555079f, this.f555076c, this.f555087n, r138);
            if (r138 != null) goto L136;
            String r140 = null;
        L120:
            if (r138 == null) goto L135;
            if (r138.a().size() != 1) goto L135;
            ECPromotion r141 = (ECPromotion) ListProtector.get(r138.a(), 0);     // Catch: Exception -> L117
            if (r141 == null) goto L135;
            int r142 = ECSdk.f48106a;     // Catch: Exception -> L117
            IECAPTService r143 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Exception -> L117
            if (r143 == null) goto L135;
            String r144 = this.f555085l;     // Catch: Exception -> L117
            String r145 = r141.promotionId;     // Catch: Exception -> L117
            if (r140 == null) goto L130;
            String r146 = r140;
        L131:
            String r147 = r141.detailUrl;     // Catch: Exception -> L117
            int r148 = com.bytedance.android.livesdk.livecommerce.utils.m0.f153098a;     // Catch: Exception -> L117
            Gson r149 = com.bytedance.android.livesdk.livecommerce.utils.m0.a.f153099a;     // Catch: Exception -> L117
            r143.record(new si2.l(r144, r145, r146, r147, null, r149.toJson(r141.jumpDestination), r149.toJson(r141.eventParams)));     // Catch: Exception -> L117
        L117:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L135
        L130:
            r146 = r139;
        L135:
            return h.f(r138, r122, r130);
        L136:
            r140 = r138.getLogId();     // Catch: Exception -> L117
            goto L120
        L95:
            if (r138.statusCode != 0) goto L113;
            if (r138.a() != null) goto L99;
        L111:
            boolean r150 = false;
        L112:
            int r151 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.f152313a;
            r139 = "";
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.d(this.f555085l.replaceFirst(si2.g.f542149a, r139), this.f555079f, this.f555076c, r150);
            goto L114
        L99:
            if (r138.a().size() <= 0) goto L111;
            ECPromotion r152 = (ECPromotion) ListProtector.get(r138.a(), 0);
            if (r152.eventParams != null) goto L103;
            r152.eventParams = new HashMap();
        L103:
            Map<String, String> r153 = r152.eventParams;
            if (this.f555074a == false) goto L106;
            String r154 = "enter_room";
        L107:
            r153.put("popup_scene", r154);
            if (this.f555074a == false) goto L110;
            int r155 = com.bytedance.android.livesdk.livecommerce.kmp.a.f149243a;
            Intrinsics.checkNotNullParameter("pop_card_enter_request", "scene");
        L110:
            r150 = true;
            goto L112
        L106:
            r154 = "message";
            goto L107
        L78:
            if (this.f555084k == null) goto L80;
            int r156 = com.bytedance.android.livesdk.livecommerce.network.hook.a.f149493a;
            this.f555084k.a(com.bytedance.android.livesdk.livecommerce.network.hook.a.a(this.f555085l, r100));
            goto L80
        L140:
            String r157 = new Gson().toJson(r121);     // Catch: Exception -> L66
        L67:
            r100.add(si2.k.a.a("pop_product_info", r157));
        L66:
            r157 = null;
            goto L67
        L5:
            r101 = 62;
            goto L6
        }

        public a(boolean r100, Map r101, String r102, String r103, String r104, String r105, String r106, String r107, boolean r108, com.bytedance.android.ec.model.response.s r110, uj2.c r111, String r112, boolean r113, boolean r114, boolean r115) {
            this.f555074a = r100;
            this.f555075b = r101;
            this.f555076c = r102;
            this.f555077d = r103;
            this.f555078e = r104;
            this.f555079f = r105;
            this.f555080g = r106;
            this.f555081h = r107;
            this.f555082i = r108;
            this.f555083j = r110;
            this.f555084k = r111;
            this.f555085l = r112;
            this.f555086m = r113;
            this.f555087n = r114;
            this.f555088o = r115;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wi2.a[] f555089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f555090b;

        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) throws Exception {
            wi2.a[] r101 = this.f555089a;
            String r102 = this.f555090b;
            if (EComABUtils.enableMonitorNetworkReport() == true) goto L13;
            return;
        L13:
            wi2.a r103 = r101[0];     // Catch: Exception -> L10
            if (r103 == null) goto L15;
            vi2.a.a(r103, r102);     // Catch: Exception -> L10
            return;
        L15:
            return;
        L10:
            e = move-exception;
            ECExceptionMonitor.f(e, "livecommerce new api monitor error");
        }

        public b(wi2.a[] r100, String r101) {
            this.f555089a = r100;
            this.f555090b = r101;
        }
    }

    public class c implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wi2.a[] f555091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f555092b;

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            Throwable r101 = r100;
            wi2.a[] r102 = this.f555091a;
            String r103 = this.f555092b;
            if (EComABUtils.enableMonitorNetworkReport() == true) goto L15;
            return;
        L15:
            wi2.a r104 = r102[0];     // Catch: Exception -> L12
            if (r104 == null) goto L17;
            if (r101 == null) goto L10;
            r101.toString();     // Catch: Exception -> L12
        L10:
            vi2.a.a(r104, r103);     // Catch: Exception -> L12
            return;
        L17:
            return;
        L12:
            e = move-exception;
            ECExceptionMonitor.f(e, "livecommerce new api monitor error");
        }

        public c(wi2.a[] r100, String r101) {
            this.f555091a = r100;
            this.f555092b = r101;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements ObservableOnSubscribe<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f555093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f555094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f555095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ wi2.a[] f555096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ f f555097e;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<T> r110) throws Exception {
        L18:
            e = move-exception;
            wi2.a r100 = new wi2.a();
            if ((e instanceof JsonSyntaxException) == false) goto L22;
        L25:
            r100.f559777d = 2;
        L26:
            Intrinsics.checkNotNullParameter(e, "e");
            String r101 = null;
            Object[] r102 = 0;
            Object[] r103 = 0;
            if ((e instanceof CronetIOException) == false) goto L31;
            String r104 = "CronetIOException";
            int r105 = ((CronetIOException) e).getStatusCode();     // Catch: Exception -> L57
            int r106 = ((CronetIOException) e).getCronetInternalErrorCode();     // Catch: Exception -> L57
            String r107 = wi2.a.a(((CronetIOException) e).getRequestInfo());     // Catch: Exception -> L57
        L50:
            if (r104 != null) goto L52;
            r104 = e.getClass().getName();     // Catch: Exception -> L57
        L52:
            r100.f559784k = new wi2.a.C8116a(r104, e.getMessage());     // Catch: Exception -> L57
            wi2.a.d r108 = r100.f559783j;     // Catch: Exception -> L57
            if (r108 != null) goto L55;
            r108 = new wi2.a.d(r101, r103 == true ? 1 : 0, r102 == true ? 1 : 0, 15);     // Catch: Exception -> L57
        L55:
            r100.f559783j = wi2.a.d.a(r108, String.valueOf(r105), String.valueOf(r106));     // Catch: Exception -> L57
            r100.f559785l = new wi2.a.b(r107);     // Catch: Exception -> L57
        L59:
            this.f555096d[0] = r100;
            r110.tryOnError(e);
            return;
        L31:
            if ((e instanceof HttpResponseException) == false) goto L34;
            r104 = "HttpResponseException";
            r105 = ((HttpResponseException) e).getStatusCode();     // Catch: Exception -> L57
            r107 = null;
            r106 = 0;
            goto L50
        L34:
            if ((e instanceof NetworkNotAvailabeException) == false) goto L37;
            r104 = "NetworkNotAvailabeException";
            int r109 = ((NetworkNotAvailabeException) e).getCronetInternalErrorCode();     // Catch: Exception -> L57
        L46:
            r106 = r109;
        L48:
            r105 = -1;
            r107 = null;
            goto L50
        L37:
            if ((e instanceof NotAllowUseNetworkException) == false) goto L40;
            r104 = "NotAllowUseNetworkException";
        L45:
            r109 = 0;
            goto L46
        L40:
            if ((e instanceof DownloadFileTooLargeException) == false) goto L43;
            r104 = "DownloadFileTooLargeException";
            goto L45
        L43:
            if ((e instanceof CdnCacheVerifyException) == false) goto L47;
            r104 = "CdnCacheVerifyException";
            goto L45
        L47:
            r104 = null;
            r106 = 0;
        L57:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L59
        L22:
            if ((e instanceof IllegalArgumentException) == true) goto L25;
            r100.f559777d = 3;
            goto L26
        L4:
            if (t0.a(this.f555093a, this.f555094b, this.f555095c) == true) goto L6;
        L10:
            long r111 = SystemClock.elapsedRealtime();     // Catch: Exception -> L18
            wi2.a<T> r112 = this.f555097e.execute();     // Catch: Exception -> L18
            r112.f559779f = SystemClock.elapsedRealtime() - r111;     // Catch: Exception -> L18
            this.f555096d[0] = r112;     // Catch: Exception -> L18
            T r113 = r112.f559774a;     // Catch: Exception -> L18
            if (r113 == null) goto L14;
            r110.onNext(r113);     // Catch: Exception -> L18
            return;
        L14:
            if (r112.f559777d != 0) goto L16;
            r112.f559777d = 2;     // Catch: Exception -> L18
        L16:
            r110.tryOnError(new Throwable("empty response or json syntax error"));     // Catch: Exception -> L18
            return;
        L6:
            if (RoomContextController.a.a().x() == false) goto L10;
            if (RoomContextController.a.a().M() == true) goto L10;
            wi2.a r114 = new wi2.a();     // Catch: Exception -> L18
            r114.f559777d = 4;     // Catch: Exception -> L18
            this.f555096d[0] = r114;     // Catch: Exception -> L18
            r110.tryOnError(new Throwable("request when not logged in"));     // Catch: Exception -> L18
        }

        public d(String r100, String r101, String r102, wi2.a[] r103, f r104) {
            this.f555093a = r100;
            this.f555094b = r101;
            this.f555095c = r102;
            this.f555096d = r103;
            this.f555097e = r104;
        }
    }

    public class e implements f<vj2.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f555098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f555099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f555100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f555101d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f555102e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f555103f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f555104g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f555105h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f555106i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f555107j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f555108k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ List f555109l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f555110m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f555111n;

        @Override // vi2.h.f
        public final wi2.a<vj2.a> execute() throws Exception {
            FilterNullArrayList r100 = new FilterNullArrayList();
            Map r101 = this.f555098a;
            if (r101 == null) goto L9;
            Iterator r102 = r101.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L9;
            Map.Entry r103 = (Map.Entry) r102.next();
            String r104 = (String) r103.getKey();
            String r105 = (String) r103.getValue();
            int r106 = si2.k.f542177c;
            r100.add(si2.k.a.a(r104, r105));
        L9:
            if (hh2.f.g() == false) goto L11;
            String r107 = this.f555099b;
            int r108 = si2.k.f542177c;
            r100.add(si2.k.a.a("author_open_id", r107));
        L12:
            r100.add(si2.k.a.a("sec_author_id", this.f555100c));
            r100.add(si2.k.a.a("room_id", this.f555101d));
            r100.add(si2.k.a.a("room_unique_key", this.f555102e));
            r100.add(si2.k.a.a("container_room_id", this.f555103f));
            r100.add(si2.k.a.a(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f555104g));
            r100.add(si2.k.a.a(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS, this.f555105h));
            r100.add(si2.k.a.a("use_promotion_v2", String.valueOf(this.f555106i)));
            int r109 = this.f555107j;
            if (r109 <= 0) goto L15;
            r100.add(si2.k.a.a("request_scene", String.valueOf(r109)));
        L15:
            r100.add(si2.k.a.a(ECFindSimilarConfig.HEIGHT_PERCENT, String.valueOf(this.f555108k)));
            List r110 = this.f555109l;
            if (r110 != null) goto L18;
        L41:
            r100.add(si2.k.a.a("enable_ab_opt", String.valueOf(EComABUtils.enableListAbOpt())));
            r100.add(si2.k.a.a("routine_optimize", String.valueOf(EComABUtils.enableServerRoutineOpt())));
            r100.add(si2.k.a.a("routine_optimize_reverse_step", String.valueOf(EComABUtils.serverRoutineReverseStep())));
            String r111 = this.f555101d;
            String r112 = this.f555102e;
            PromotionListController.T.getClass();
            String r113 = PromotionListController.a.c(r111, r112).Q;
            if (TextUtils.isEmpty(r113) == true) goto L44;
            r100.add(si2.k.a.a("header_callback", r113));
        L44:
            r100.add(si2.k.a.a("preferred_coupon", this.f555110m));
            Map<String, String> r114 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r100);
            SsResponse r115 = h.h(this.f555111n, r100);
            vj2.a r116 = (vj2.a) h.j(r115, vj2.a.class);
            if (r116 == null) goto L58;
        L55:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L58
        L47:
            if (r116.c() == null) goto L58;
            Iterator<ECPromotion> r117 = r116.c().values().iterator();     // Catch: Exception -> L55
        L50:
            if (r117.hasNext() == false) goto L58;
            ECPromotion r118 = r117.next();     // Catch: Exception -> L55
            int r119 = ECSdk.f48106a;     // Catch: Exception -> L55
            IECAPTService r120 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Exception -> L55
            if (r120 == null) goto L50;
            String r121 = this.f555111n;     // Catch: Exception -> L55
            String r122 = r118.promotionId;     // Catch: Exception -> L55
            String r123 = r116.a();     // Catch: Exception -> L55
            String r124 = r118.detailUrl;     // Catch: Exception -> L55
            int r125 = com.bytedance.android.livesdk.livecommerce.utils.m0.f153098a;     // Catch: Exception -> L55
            Gson r126 = com.bytedance.android.livesdk.livecommerce.utils.m0.a.f153099a;     // Catch: Exception -> L55
            r120.record(new si2.l(r121, r122, r123, r124, null, r126.toJson(r118.jumpDestination), r126.toJson(r118.eventParams)));     // Catch: Exception -> L55
        L58:
            return h.f(r116, r114, r115);
        L18:
            if (r110.isEmpty() == true) goto L41;
            JSONArray r127 = new JSONArray();
            Iterator r128 = this.f555109l.iterator();
        L21:
            if (r128.hasNext() == false) goto L40;
            vj2.d r129 = (vj2.d) r128.next();
            r129.getClass();
            Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L34
            JSONObject r131 = new JSONObject();     // Catch: Throwable -> L34
            String r132 = r129.f555402a;     // Catch: Throwable -> L34
            if (r132 == null) goto L26;
            r131.put("product_id", r132);     // Catch: Throwable -> L34
        L26:
            String r133 = r129.f555403b;     // Catch: Throwable -> L34
            if (r133 == null) goto L29;
            r131.put("promotion_id", r133);     // Catch: Throwable -> L34
        L29:
            String r134 = r129.f555404c;     // Catch: Throwable -> L34
            if (r134 == null) goto L32;
            r131.put(com.bytedance.android.ec.core.event.a.KEY_SKU_ID, r134);     // Catch: Throwable -> L34
        L32:
            Object r135 = Result.m9449constructorimpl(r131);     // Catch: Throwable -> L34
        L36:
            JSONObject r136 = new JSONObject();
            if (Result.m9455isFailureimpl(r135) == false) goto L39;
            r135 = r136;
        L39:
            r127.put((JSONObject) r135);
        L34:
            th = move-exception;
            Result.Companion r137 = Result.Companion;
            r135 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L36
        L40:
            r100.add(si2.k.a.a("product_infos", r127.toString()));
            goto L41
        L11:
            String r138 = this.f555099b;
            int r139 = si2.k.f542177c;
            r100.add(si2.k.a.a("author_id", r138));
            goto L12
        }

        public e(Map r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, boolean r108, int r110, int r111, List r112, String r113, String r114) {
            this.f555098a = r100;
            this.f555099b = r101;
            this.f555100c = r102;
            this.f555101d = r103;
            this.f555102e = r104;
            this.f555103f = r105;
            this.f555104g = r106;
            this.f555105h = r107;
            this.f555106i = r108;
            this.f555107j = r110;
            this.f555108k = r111;
            this.f555109l = r112;
            this.f555110m = r113;
            this.f555111n = r114;
        }
    }

    public interface f<T> {
        wi2.a<T> execute() throws Exception;
    }

    static {
        String[] r100 = {"a3c2bdf4", "4c3e517d", "f0917b74", "df886f96"};
        f555073a = r100[3] + r100[1] + r100[2] + r100[0];
    }

    public static String d(String r100) {
        Lazy r101 = ECSettingKeys.f43616a;
        int r102 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Object r103 = 0;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r105 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r106 = jj4.a.a("live_anchor_api_migrate_enable", Integer.class, r103, false);     // Catch: Throwable -> L7
        if (r106 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        if (((Number) r106).intValue() == 1) goto L16;
        return r100;
    L16:
        if (r100.endsWith(HTTP.URL_DEFAULT) == false) goto L20;
        return r100.concat("v1/");
    L20:
        return r100.concat("/v1/");
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r108) == true) goto L12;
        r103 = r108;
    L12:
        r106 = r103;
        goto L14
    }

    public static String a(String r100, FilterNullArrayList r101) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r100, r101);
        String r102 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a(r100, r101);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r102, r101, UGCMonitor.TYPE_POST);
        int r103 = zj2.a.f572446a;
        Intrinsics.checkNotNullParameter(r102, "url");
        return zj2.a.b(r102, r101, true, null);
    }

    @Deprecated(message = "使用executeGetHttpWithMonitor")
    public static String g(String r100, FilterNullArrayList r101) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r100, r101);
        String r102 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a(r100, r101);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r102, r101, MonitorConstants.CONNECT_TYPE_GET);
        int r103 = zj2.a.f572446a;
        Intrinsics.checkNotNullParameter(r102, "url");
        return zj2.a.b(r102, r101, false, null);
    }

    public static SsResponse h(String r100, FilterNullArrayList r101) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r100, r101);
        String r102 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a(r100, r101);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r102, r101, MonitorConstants.CONNECT_TYPE_GET);
        return zj2.a.c(r102, r101, false, null);
    }

    public static SsResponse i(String r100, FilterNullArrayList r101) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r100, r101);
        String r102 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a(r100, r101);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r102, r101, UGCMonitor.TYPE_POST);
        return zj2.a.c(r102, r101, true, null);
    }

    public static <T> T j(SsResponse<String> r100, Class<T> r101) {
        String r102 = r100.body();
        if (r102 != null) goto L5;
    L11:
        return null;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L11;
        if (EComABUtils.getApiDataCatchException() == true) goto L14;
        int r103 = com.bytedance.android.livesdk.livecommerce.utils.m0.f153098a;
        return (T) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.f153099a, r102, r101);
    L14:
        int r104 = com.bytedance.android.livesdk.livecommerce.utils.m0.f153098a;     // Catch: Exception -> L13
        return (T) com.bytedance.android.livesdk.livecommerce.utils.m0.a.f153099a.fromJson(r102, r101);
    }

    public static void b(FilterNullArrayList r100, String r101, boolean r102) {
        if (r102 == false) goto L4;
        String r103 = "author_open_id";
    L5:
        int r104 = si2.k.f542177c;
        r100.add(si2.k.a.a(r103, r101));
        return;
    L4:
        r103 = "author_id";
        goto L5
    }

    public static <T extends com.bytedance.android.ec.model.g> wi2.a<T> f(T r100, Map<String, String> r101, SsResponse<String> r110) {
        if (r100 == null) goto L5;
        int r102 = r100.statusCode;
    L6:
        String r103 = "";
        if (r100 == null) goto L9;
        String r104 = r100.statusMessage;
    L10:
        if (r100 == null) goto L14;
        LogPbData r105 = r100.logPb;
        if (r105 == null) goto L14;
        r103 = r105.getImprId();
    L14:
        String r106 = r103;
        if (r100 != null) goto L17;
        boolean r107 = true;
    L18:
        wi2.a<T> r108 = new wi2.a(r102, r104, r106, r101, r110, r107);
        if (r100 == null) goto L21;
        r108.f559774a = r100;
    L21:
        return r108;
    L17:
        r107 = false;
        goto L18
    L9:
        r104 = "";
        goto L10
    L5:
        r102 = -1;
        goto L6
    }

    public static xi2.u n(String r100, String r101, String r102) throws Exception {
        FilterNullArrayList r103 = new FilterNullArrayList();
        int r104 = si2.k.f542177c;
        r103.add(si2.k.a.a("category_id", r100));
        r103.add(si2.k.a.a(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r101));
        r103.add(si2.k.a.a("prefix", r102));
        String r105 = g(d(si2.g.I), r103);
        int r106 = com.bytedance.android.livesdk.livecommerce.utils.m0.f153098a;
        return (xi2.u) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.f153099a, r105, xi2.u.class);
    }

    public static String c(String r100, FilterNullArrayList r101, JSONObject r102, Map r103) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r100, r101);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r100, r101, UGCMonitor.TYPE_POST);
        int r104 = zj2.a.f572446a;
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "paramList");
        Intrinsics.checkNotNullParameter(r102, "paramBody");
        LinkedHashMap r105 = new LinkedHashMap();
        zj2.a.a(r105);
        boolean r106 = true;
        if ((!r101.isEmpty()) == false) goto L8;
        Iterator<E> r107 = r101.iterator();
    L6:
        if (r107.hasNext() == false) goto L8;
        si2.k r108 = (si2.k) r107.next();
        r105.put(r108.f45605a, r108.f45606b);
    L8:
        LinkedHashSet r109 = new LinkedHashSet();
        Iterator<String> r110 = r102.keys();
        if (r110 != null) goto L11;
    L13:
        Iterator r111 = r105.entrySet().iterator();
    L15:
        if (r111.hasNext() == false) goto L23;
        Map.Entry r112 = (Map.Entry) r111.next();
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L15
    L18:
        if (r109.contains(r112.getKey()) == true) goto L15;
        r102.put((String) r112.getKey(), r112.getValue());     // Catch: JSONException -> L21
        goto L15
    L23:
        LiveCommerceApi.f151849a.getClass();
        LiveCommerceApi r113 = LiveCommerceApi.a.a();
        if (r113 == null) goto L36;
        SsResponse<String> r114 = r113.postBodyWithHeader(r100, RequestBody.create(MediaType.parse("application/json"), r102.toString()), r103).execute();
        com.bytedance.android.livesdk.livecommerce.utils.z.a(r100, r114);
        String r115 = r114.body();
        if (r115 != null) goto L28;
    L31:
        if (r106 == true) goto L34;
        return r115;
    L34:
        throw new IllegalArgumentException("response body is null or empty");
    L28:
        if (r115.length() == 0) goto L31;
        r106 = false;
        goto L31
    L36:
        throw new IllegalArgumentException("LiveCommerceApi INSTANCE is null");
    L11:
        if (r110.hasNext() == false) goto L13;
        r109.add(r110.next());
        goto L11
    }

    public static <T> Observable<T> e(String r100, String r101, String r110, f<T> r111) {
        wi2.a[] r102 = new wi2.a[1];
        return Observable.create(new d(r100, r101, r110, r102, r111)).subscribeOn(Schedulers.io()).doOnError(new c(r102, r110)).doAfterNext(new b(r102, r110));
    }

    public static Observable<ECCurrentPromotion> m(final String r110, final String r111, final String r112, final String r113, final String r114, final String r115, final boolean r116, final String r117) {
        final String r118 = si2.g.f542168r;
        OptCardUtil.b(null, "getPopPromotion");
        return e(r110, r111, r118, new g(r112, r113, r110, r111, r114, r115, r117, r118, r116));
    }

    public static Observable<vj2.a> k(String r110, String r111, String r112, String r210, String r211, String r212, List<vj2.d> r213, String r214, int r215, int r216, String r217, boolean r218, String r219, Map<String, String> r310) {
        if (r217 != null) goto L5;
    L8:
        String r100 = si2.g.f542161k;
    L9:
        if (r310 != null) goto L11;
    L13:
        String r113 = r100;
        return e(r112, r210, r113, new e(r310, r110, r111, r112, r210, r211, r212, r214, r218, r215, r216, r213, r219, r113));
    L11:
        if (String.valueOf(42).equals(r310.get("request_scene")) == false) goto L13;
        r100 = "https://ecom5-normal-lq.ecombdapi.com/live/promotions/page/get/bottom/";
        goto L13
    L5:
        if (TextUtils.isEmpty(r217) == true) goto L8;
        r100 = si2.g.f542149a + r217;
        goto L9
    }

    public static Observable<ECCurrentPromotion> l(String r110, String r111, String r210, String r211, String r212, String r213, boolean r214, boolean r215, boolean r216, boolean r217, com.bytedance.android.ec.model.response.s r218, String r219, boolean r310, Map<String, String> r311, uj2.c r312) {
        if (r214 == false) goto L11;
        if (r219 != null) goto L6;
    L9:
        String r100 = si2.g.f542167q;
    L14:
        String r112 = r100;
        OptCardUtil.b(null, "getPopPromotion");
        return e(r210, r211, r112, new a(r310, r311, r211, r110, r111, r210, r212, r213, r217, r218, r312, r112, r214, r216, r215));
    L6:
        if (TextUtils.isEmpty(r219) == true) goto L9;
        r100 = si2.g.f542149a + r219;
        goto L14
    L11:
        if (hh2.f.g() == false) goto L13;
        r100 = si2.g.f542166p;
        goto L14
    L13:
        r100 = si2.g.f542165o;
        goto L14
    }
}
