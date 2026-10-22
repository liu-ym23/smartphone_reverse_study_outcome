package vi2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.api.LogPbData;
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
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h {
    public static final String a = null;

    public class a implements f<ECCurrentPromotion> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ com.bytedance.android.ec.model.response.s j;
        public final /* synthetic */ uj2.c k;
        public final /* synthetic */ String l;
        public final /* synthetic */ boolean m;
        public final /* synthetic */ boolean n;
        public final /* synthetic */ boolean o;

        @Override // vi2.h.f
        public final wi2.a<ECCurrentPromotion> execute() throws Exception {
            FilterNullArrayList r0 = new FilterNullArrayList();
            if (this.a == false) goto L5;
            int r2 = 61;
        L6:
            String r3 = String.valueOf(r2);
            int r4 = si2.k.c;
            r0.add(si2.k.a.a("request_scene", r3));
            Map r5 = this.b;
            if (r5 == null) goto L12;
            Iterator r6 = r5.entrySet().iterator();
        L10:
            if (r6.hasNext() == false) goto L12;
            Map.Entry r7 = (Map.Entry) r6.next();
            r0.add(si2.k.a.a((String) r7.getKey(), (String) r7.getValue()));
        L12:
            r0.add(si2.k.a.a("room_unique_key", this.c));
            boolean r8 = hh2.f.g();
            boolean r9 = true;
            String r10 = BDLocationException.ERROR_TIMEOUT;
            String r11 = "1";
            if (r8 == false) goto L51;
            h.b(r0, this.d, true);
            r0.add(si2.k.a.a("sec_author_id", this.e));
            r0.add(si2.k.a.a("room_id", this.f));
            r0.add(si2.k.a.a("entrance_info", this.g));
            r0.add(si2.k.a.a("op_type", this.h));
            r0.add(si2.k.a.a("use_new_price", String.valueOf(LiveSettingKeys.getEC_LIVE_CARD_USE_NEW_PRICE())));
            r0.add(si2.k.a.a("opt_entrance_info", "1"));
            r0.add(si2.k.a.a("is_retry", String.valueOf(this.i)));
            if (this.a == false) goto L17;
            r10 = "1";
        L17:
            r0.add(si2.k.a.a("first_enter", r10));
            com.bytedance.android.ec.model.response.s r12 = this.j;
            if (r12 != null) goto L138;
        L23:
            Map<String, String> r13 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
            ECLiveABUtils r14 = ECLiveABUtils.INSTANCE;
            if (r14.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L29;
            if (this.k == null) goto L29;
            int r15 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a;
            this.k.a(com.bytedance.android.livesdk.livecommerce.network.hook.a.a(this.l, r0));
        L29:
            if (this.m == false) goto L31;
            SsResponse r1 = h.h(this.l, r0);
        L33:
            if (r14.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L37;
            uj2.c r16 = this.k;
            if (r16 == null) goto L37;
            r16.b(Integer.valueOf(r1.code()));
        L37:
            ECCurrentPromotion r17 = (ECCurrentPromotion) h.j(r1, ECCurrentPromotion.class);
            if (r17 != null) goto L40;
        L48:
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.a(this.f, this.c, this.n, r17);
            return h.f(r17, r13, r1);
        L40:
            if (((com.bytedance.android.ec.model.g) r17).statusCode != 0) goto L48;
            if (r17.a() != null) goto L44;
        L46:
            r9 = false;
        L47:
            int r18 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.d(this.l.replaceFirst(si2.g.a, ""), this.f, this.c, r9);
            goto L48
        L44:
            if (r17.a().size() <= 0) goto L46;
        L31:
            r1 = h.i(si2.g.p, r0);
            goto L33
        L138:
            String r19 = new Gson().toJson(r12);     // Catch: Exception -> L21
        L22:
            r0.add(si2.k.a.a("pop_product_info", r19));
        L21:
            r19 = null;
            goto L22
        L51:
            if (this.a == false) goto L53;
            int r20 = com.bytedance.android.livesdk.livecommerce.kmp.a.a;
            Intrinsics.checkNotNullParameter("pop_card_enter_request", "scene");
        L53:
            OptCardUtil.b(null, "getPopPromotion request start");
            if (OptCardUtil.a == false) goto L58;
            cl.d r21 = com.bytedance.android.ec.sdk.helper.k.a();
            if (r21 == null) goto L58;
            r21.m();
        L58:
            h.b(r0, this.d, false);
            r0.add(si2.k.a.a("sec_author_id", this.e));
            r0.add(si2.k.a.a("room_id", this.f));
            r0.add(si2.k.a.a("entrance_info", this.g));
            r0.add(si2.k.a.a("op_type", this.h));
            r0.add(si2.k.a.a("use_new_price", String.valueOf(LiveSettingKeys.getEC_LIVE_CARD_USE_NEW_PRICE())));
            r0.add(si2.k.a.a("opt_entrance_info", "1"));
            r0.add(si2.k.a.a("is_retry", String.valueOf(this.i)));
            if (this.a == true) goto L62;
            r11 = BDLocationException.ERROR_TIMEOUT;
        L62:
            r0.add(si2.k.a.a("first_enter", r11));
            com.bytedance.android.ec.model.response.s r22 = this.j;
            if (r22 != null) goto L140;
        L68:
            Map<String, String> r23 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
            if (this.o == false) goto L75;
            String r24 = this.f;
            String r25 = this.c;
            ECLivePerformanceMonitor.b r26 = ECLivePerformanceMonitor.x;
            ECLivePerformanceMonitor r27 = ECLivePerformanceMonitor.c.a(r24, r25);
            if (r27 == null) goto L75;
            r27.u("ec_perf_duration_shopping_card", "pop_api_pure_start", Long.valueOf(SystemClock.elapsedRealtime()));
            String r28 = r27.p;
            if (r28 == null) goto L75;
            Map r29 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.h(r28, MetricNames.POP_API_PURE_DURATION, null);
        L75:
            ECLiveABUtils r30 = ECLiveABUtils.INSTANCE;
            if (r30.getEC_LIVE_ENABLE_API_ERROR_REPORT() == true) goto L78;
        L80:
            SsResponse r31 = h.h(this.l, r0);
            OptCardUtil.b(null, "getPopPromotion request end");
            if (r30.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L86;
            uj2.c r32 = this.k;
            if (r32 == null) goto L86;
            r32.b(Integer.valueOf(r31.code()));
        L86:
            if (this.o == false) goto L92;
            String r33 = this.f;
            String r34 = this.c;
            ECLivePerformanceMonitor.b r35 = ECLivePerformanceMonitor.x;
            ECLivePerformanceMonitor r36 = ECLivePerformanceMonitor.c.a(r33, r34);
            if (r36 == null) goto L92;
            r36.u("ec_perf_duration_shopping_card", "pop_api_pure_end", Long.valueOf(SystemClock.elapsedRealtime()));
            String r37 = r36.p;
            if (r37 == null) goto L92;
            Map r38 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.j(r37, MetricNames.POP_API_PURE_DURATION);
        L92:
            ECCurrentPromotion r39 = (ECCurrentPromotion) h.j(r31, ECCurrentPromotion.class);
            if (r39 != null) goto L95;
        L113:
            String r40 = "";
        L114:
            com.bytedance.android.livesdk.livecommerce.network.hook.c.a.a(this.f, this.c, r39);
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.a(this.f, this.c, this.n, r39);
            if (r39 != null) goto L136;
            String r41 = null;
        L120:
            if (r39 == null) goto L135;
            if (r39.a().size() != 1) goto L135;
            ECPromotion r42 = (ECPromotion) ListProtector.get(r39.a(), 0);     // Catch: Exception -> L117
            if (r42 == null) goto L135;
            int r43 = ECSdk.a;     // Catch: Exception -> L117
            IECAPTService r44 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Exception -> L117
            if (r44 == null) goto L135;
            String r45 = this.l;     // Catch: Exception -> L117
            String r110 = r42.promotionId;     // Catch: Exception -> L117
            if (r41 == null) goto L130;
            String r111 = r41;
        L131:
            String r112 = r42.detailUrl;     // Catch: Exception -> L117
            int r46 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;     // Catch: Exception -> L117
            Gson r47 = com.bytedance.android.livesdk.livecommerce.utils.m0.a.a;     // Catch: Exception -> L117
            r44.record(new si2.l(r45, r110, r111, r112, null, r47.toJson(r42.jumpDestination), r47.toJson(r42.eventParams)));     // Catch: Exception -> L117
        L117:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L135
        L130:
            r111 = r40;
        L135:
            return h.f(r39, r23, r31);
        L136:
            r41 = r39.getLogId();     // Catch: Exception -> L117
            goto L120
        L95:
            if (((com.bytedance.android.ec.model.g) r39).statusCode != 0) goto L113;
            if (r39.a() != null) goto L99;
        L111:
            boolean r48 = false;
        L112:
            int r49 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
            r40 = "";
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.d(this.l.replaceFirst(si2.g.a, r40), this.f, this.c, r48);
            goto L114
        L99:
            if (r39.a().size() <= 0) goto L111;
            ECPromotion r50 = (ECPromotion) ListProtector.get(r39.a(), 0);
            if (r50.eventParams != null) goto L103;
            r50.eventParams = new HashMap();
        L103:
            Map r51 = r50.eventParams;
            if (this.a == false) goto L106;
            String r52 = "enter_room";
        L107:
            r51.put("popup_scene", r52);
            if (this.a == false) goto L110;
            int r53 = com.bytedance.android.livesdk.livecommerce.kmp.a.a;
            Intrinsics.checkNotNullParameter("pop_card_enter_request", "scene");
        L110:
            r48 = true;
            goto L112
        L106:
            r52 = "message";
            goto L107
        L78:
            if (this.k == null) goto L80;
            int r54 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a;
            this.k.a(com.bytedance.android.livesdk.livecommerce.network.hook.a.a(this.l, r0));
            goto L80
        L140:
            String r55 = new Gson().toJson(r22);     // Catch: Exception -> L66
        L67:
            r0.add(si2.k.a.a("pop_product_info", r55));
        L66:
            r55 = null;
            goto L67
        L5:
            r2 = 62;
            goto L6
        }

        public a(boolean r1, Map r2, String r3, String r4, String r5, String r6, String r7, String r8, boolean r9, com.bytedance.android.ec.model.response.s r10, uj2.c r11, String r12, boolean r13, boolean r14, boolean r15) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.l = r12;
            this.m = r13;
            this.n = r14;
            this.o = r15;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements Consumer<T> {
        public final /* synthetic */ wi2.a[] a;
        public final /* synthetic */ String b;

        public final void accept(T r3) throws Exception {
            wi2.a[] r4 = this.a;
            String r0 = this.b;
            if (EComABUtils.enableMonitorNetworkReport() == true) goto L13;
            return;
        L13:
            wi2.a r5 = r4[0];     // Catch: Exception -> L10
            if (r5 == null) goto L15;
            vi2.a.a(r5, r0);     // Catch: Exception -> L10
            return;
        L15:
            return;
        L10:
            e = move-exception;
            ECExceptionMonitor.f(e, "livecommerce new api monitor error");
        }

        public b(wi2.a[] r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public class c implements Consumer<Throwable> {
        public final /* synthetic */ wi2.a[] a;
        public final /* synthetic */ String b;

        public final void accept(Object r4) throws Exception {
            Throwable r5 = (Throwable) r4;
            wi2.a[] r0 = this.a;
            String r1 = this.b;
            if (EComABUtils.enableMonitorNetworkReport() == true) goto L15;
            return;
        L15:
            wi2.a r2 = r0[0];     // Catch: Exception -> L12
            if (r2 == null) goto L17;
            if (r5 == null) goto L10;
            r5.toString();     // Catch: Exception -> L12
        L10:
            vi2.a.a(r2, r1);     // Catch: Exception -> L12
            return;
        L17:
            return;
        L12:
            e = move-exception;
            ECExceptionMonitor.f(e, "livecommerce new api monitor error");
        }

        public c(wi2.a[] r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements ObservableOnSubscribe<T> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ wi2.a[] d;
        public final /* synthetic */ f e;

        public final void subscribe(ObservableEmitter<T> r11) throws Exception {
        L18:
            e = move-exception;
            wi2.a r3 = new wi2.a();
            if ((e instanceof JsonSyntaxException) == false) goto L22;
        L25:
            r3.d = 2;
        L26:
            Intrinsics.checkNotNullParameter(e, "e");
        L57:
            e = move-exception;
            ECExceptionMonitor.e(e);
        L59:
            this.d[0] = r3;
            r11.tryOnError(e);
            return;
        L28:
            if ((e instanceof CronetIOException) == false) goto L31;
            String r0 = "CronetIOException";
            int r5 = e.getStatusCode();     // Catch: Exception -> L57
            int r6 = e.getCronetInternalErrorCode();     // Catch: Exception -> L57
            String r7 = wi2.a.a(e.getRequestInfo());     // Catch: Exception -> L57
        L50:
            if (r0 != null) goto L52;
            r0 = e.getClass().getName();     // Catch: Exception -> L57
        L52:
            r3.k = new wi2.a.C0184a(r0, e.getMessage());     // Catch: Exception -> L57
            wi2.a.d r1 = r3.j;     // Catch: Exception -> L57
            if (r1 != null) goto L55;
            r1 = new wi2.a.d(null, null, null, 15);     // Catch: Exception -> L57
        L55:
            r3.j = wi2.a.d.a(r1, String.valueOf(r5), String.valueOf(r6));     // Catch: Exception -> L57
            r3.l = new wi2.a.b(r7);     // Catch: Exception -> L57
            goto L59
        L31:
            if ((e instanceof HttpResponseException) == false) goto L34;
            r0 = "HttpResponseException";
            r5 = ((HttpResponseException) e).getStatusCode();     // Catch: Exception -> L57
            r7 = null;
            r6 = 0;
            goto L50
        L34:
            if ((e instanceof NetworkNotAvailabeException) == false) goto L37;
            r0 = "NetworkNotAvailabeException";
            int r8 = ((NetworkNotAvailabeException) e).getCronetInternalErrorCode();     // Catch: Exception -> L57
        L46:
            r6 = r8;
        L48:
            r5 = -1;
            r7 = null;
            goto L50
        L37:
            if ((e instanceof NotAllowUseNetworkException) == false) goto L40;
            r0 = "NotAllowUseNetworkException";
        L45:
            r8 = 0;
            goto L46
        L40:
            if ((e instanceof DownloadFileTooLargeException) == false) goto L43;
            r0 = "DownloadFileTooLargeException";
            goto L45
        L43:
            if ((e instanceof CdnCacheVerifyException) == false) goto L47;
            r0 = "CdnCacheVerifyException";
            goto L45
        L47:
            r0 = null;
            r6 = 0;
            goto L48
        L22:
            if ((e instanceof IllegalArgumentException) == true) goto L25;
            r3.d = 3;
            goto L26
        L4:
            if (t0.a(this.a, this.b, this.c) == true) goto L6;
        L10:
            long r2 = SystemClock.elapsedRealtime();     // Catch: Exception -> L18
            wi2.a<T> r4 = this.e.execute();     // Catch: Exception -> L18
            r4.f = SystemClock.elapsedRealtime() - r2;     // Catch: Exception -> L18
            this.d[0] = r4;     // Catch: Exception -> L18
            T r9 = r4.a;     // Catch: Exception -> L18
            if (r9 == null) goto L14;
            r11.onNext(r9);     // Catch: Exception -> L18
            return;
        L14:
            if (r4.d != 0) goto L16;
            r4.d = 2;     // Catch: Exception -> L18
        L16:
            r11.tryOnError(new Throwable("empty response or json syntax error"));     // Catch: Exception -> L18
            return;
        L6:
            if (RoomContextController.a.a().x() == false) goto L10;
            if (RoomContextController.a.a().M() == true) goto L10;
            wi2.a r10 = new wi2.a();     // Catch: Exception -> L18
            r10.d = 4;     // Catch: Exception -> L18
            this.d[0] = r10;     // Catch: Exception -> L18
            r11.tryOnError(new Throwable("request when not logged in"));     // Catch: Exception -> L18
        }

        public d(String r1, String r2, String r3, wi2.a[] r4, f r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public class e implements f<vj2.a> {
        public final /* synthetic */ Map a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ List l;
        public final /* synthetic */ String m;
        public final /* synthetic */ String n;

        @Override // vi2.h.f
        public final wi2.a<vj2.a> execute() throws Exception {
            FilterNullArrayList r0 = new FilterNullArrayList();
            Map r1 = this.a;
            if (r1 == null) goto L9;
            Iterator r2 = r1.entrySet().iterator();
        L6:
            if (r2.hasNext() == false) goto L9;
            Map.Entry r3 = (Map.Entry) r2.next();
            String r4 = (String) r3.getKey();
            String r5 = (String) r3.getValue();
            int r6 = si2.k.c;
            r0.add(si2.k.a.a(r4, r5));
        L9:
            if (hh2.f.g() == false) goto L11;
            String r7 = this.b;
            int r8 = si2.k.c;
            r0.add(si2.k.a.a("author_open_id", r7));
        L12:
            r0.add(si2.k.a.a("sec_author_id", this.c));
            r0.add(si2.k.a.a("room_id", this.d));
            r0.add(si2.k.a.a("room_unique_key", this.e));
            r0.add(si2.k.a.a("container_room_id", this.f));
            r0.add(si2.k.a.a("entrance_info", this.g));
            r0.add(si2.k.a.a("request_additions", this.h));
            r0.add(si2.k.a.a("use_promotion_v2", String.valueOf(this.i)));
            int r9 = this.j;
            if (r9 <= 0) goto L15;
            r0.add(si2.k.a.a("request_scene", String.valueOf(r9)));
        L15:
            r0.add(si2.k.a.a("height_percent", String.valueOf(this.k)));
            List r10 = this.l;
            if (r10 != null) goto L18;
        L41:
            r0.add(si2.k.a.a("enable_ab_opt", String.valueOf(EComABUtils.enableListAbOpt())));
            r0.add(si2.k.a.a("routine_optimize", String.valueOf(EComABUtils.enableServerRoutineOpt())));
            r0.add(si2.k.a.a("routine_optimize_reverse_step", String.valueOf(EComABUtils.serverRoutineReverseStep())));
            String r11 = this.d;
            String r12 = this.e;
            PromotionListController.T.getClass();
            String r13 = PromotionListController.a.c(r11, r12).Q;
            if (TextUtils.isEmpty(r13) == true) goto L44;
            r0.add(si2.k.a.a("header_callback", r13));
        L44:
            r0.add(si2.k.a.a("preferred_coupon", this.m));
            Map<String, String> r14 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r0);
            SsResponse r15 = h.h(this.n, r0);
            vj2.a r16 = (vj2.a) h.j(r15, vj2.a.class);
            if (r16 == null) goto L58;
        L55:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L58
        L47:
            if (r16.c() == null) goto L58;
            Iterator<ECPromotion> r17 = r16.c().values().iterator();     // Catch: Exception -> L55
        L50:
            if (r17.hasNext() == false) goto L58;
            ECPromotion r18 = r17.next();     // Catch: Exception -> L55
            int r19 = ECSdk.a;     // Catch: Exception -> L55
            IECAPTService r20 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Exception -> L55
            if (r20 == null) goto L50;
            String r21 = this.n;     // Catch: Exception -> L55
            String r22 = r18.promotionId;     // Catch: Exception -> L55
            String r23 = r16.a();     // Catch: Exception -> L55
            String r110 = r18.detailUrl;     // Catch: Exception -> L55
            int r24 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;     // Catch: Exception -> L55
            Gson r25 = com.bytedance.android.livesdk.livecommerce.utils.m0.a.a;     // Catch: Exception -> L55
            r20.record(new si2.l(r21, r22, r23, r110, null, r25.toJson(r18.jumpDestination), r25.toJson(r18.eventParams)));     // Catch: Exception -> L55
        L58:
            return h.f(r16, r14, r15);
        L18:
            if (r10.isEmpty() == true) goto L41;
            JSONArray r26 = new JSONArray();
            Iterator r27 = this.l.iterator();
        L21:
            if (r27.hasNext() == false) goto L40;
            vj2.d r28 = (vj2.d) r27.next();
            r28.getClass();
            Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L34
            JSONObject r30 = new JSONObject();     // Catch: Throwable -> L34
            String r31 = r28.a;     // Catch: Throwable -> L34
            if (r31 == null) goto L26;
            r30.put("product_id", r31);     // Catch: Throwable -> L34
        L26:
            String r32 = r28.b;     // Catch: Throwable -> L34
            if (r32 == null) goto L29;
            r30.put("promotion_id", r32);     // Catch: Throwable -> L34
        L29:
            String r33 = r28.c;     // Catch: Throwable -> L34
            if (r33 == null) goto L32;
            r30.put("sku_id", r33);     // Catch: Throwable -> L34
        L32:
            Object r34 = Result.constructor-impl(r30);     // Catch: Throwable -> L34
        L36:
            JSONObject r35 = new JSONObject();
            if (Result.isFailure-impl(r34) == false) goto L39;
            r34 = r35;
        L39:
            r26.put((JSONObject) r34);
        L34:
            th = move-exception;
            Result.Companion r36 = Result.Companion;
            r34 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L36
        L40:
            r0.add(si2.k.a.a("product_infos", r26.toString()));
            goto L41
        L11:
            String r37 = this.b;
            int r38 = si2.k.c;
            r0.add(si2.k.a.a("author_id", r37));
            goto L12
        }

        public e(Map r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, boolean r9, int r10, int r11, List r12, String r13, String r14) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.l = r12;
            this.m = r13;
            this.n = r14;
        }
    }

    public interface f<T> {
        wi2.a<T> execute() throws Exception;
    }

    static {
        String[] r0 = {"a3c2bdf4", "4c3e517d", "f0917b74", "df886f96"};
        a = r0[3] + r0[1] + r0[2] + r0[0];
    }

    public static String d(String r4) {
        Lazy r0 = ECSettingKeys.a;
        int r1 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r2 = 0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r5 = jj4.b.b;     // Catch: Throwable -> L7
        Object r6 = jj4.a.a("live_anchor_api_migrate_enable", Integer.class, r2, false);     // Catch: Throwable -> L7
        if (r6 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        if (((Number) r6).intValue() == 1) goto L16;
        return r4;
    L16:
        if (r4.endsWith("/") == false) goto L20;
        return r4.concat("v1/");
    L20:
        return r4.concat("/v1/");
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Object r8 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r8) == true) goto L12;
        r2 = r8;
    L12:
        r6 = r2;
        goto L14
    }

    public static String a(String r2, FilterNullArrayList r3) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r2, r3);
        String r4 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a(r2, r3);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r4, r3, "post");
        int r0 = zj2.a.a;
        Intrinsics.checkNotNullParameter(r4, "url");
        return zj2.a.b(r4, r3, true, null);
    }

    @Deprecated(message = "使用executeGetHttpWithMonitor")
    public static String g(String r2, FilterNullArrayList r3) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r2, r3);
        String r4 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a(r2, r3);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r4, r3, "get");
        int r0 = zj2.a.a;
        Intrinsics.checkNotNullParameter(r4, "url");
        return zj2.a.b(r4, r3, false, null);
    }

    public static SsResponse h(String r2, FilterNullArrayList r3) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r2, r3);
        String r4 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a(r2, r3);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r4, r3, "get");
        return zj2.a.c(r4, r3, false, null);
    }

    public static SsResponse i(String r2, FilterNullArrayList r3) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r2, r3);
        String r4 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a(r2, r3);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r4, r3, "post");
        return zj2.a.c(r4, r3, true, null);
    }

    public static <T> T j(SsResponse<String> r1, Class<T> r2) {
        String r3 = (String) r1.body();
        if (r3 != null) goto L5;
    L11:
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        if (EComABUtils.getApiDataCatchException() == true) goto L14;
        int r0 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return (T) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r3, r2);
    L14:
        int r4 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;     // Catch: Exception -> L13
        return (T) com.bytedance.android.livesdk.livecommerce.utils.m0.a.a.fromJson(r3, r2);
    }

    public static void b(FilterNullArrayList r1, String r2, boolean r3) {
        if (r3 == false) goto L4;
        String r4 = "author_open_id";
    L5:
        int r0 = si2.k.c;
        r1.add(si2.k.a.a(r4, r2));
        return;
    L4:
        r4 = "author_id";
        goto L5
    }

    public static <T extends com.bytedance.android.ec.model.g> wi2.a<T> f(T r8, Map<String, String> r9, SsResponse<String> r10) {
        if (r8 == null) goto L5;
        int r1 = ((com.bytedance.android.ec.model.g) r8).statusCode;
    L6:
        String r0 = "";
        if (r8 == null) goto L9;
        String r2 = ((com.bytedance.android.ec.model.g) r8).statusMessage;
    L10:
        if (r8 == null) goto L14;
        LogPbData r3 = ((com.bytedance.android.ec.model.g) r8).logPb;
        if (r3 == null) goto L14;
        r0 = r3.getImprId();
    L14:
        String r4 = r0;
        if (r8 != null) goto L17;
        boolean r6 = true;
    L18:
        wi2.a<T> r7 = new wi2.a(r1, r2, r4, r9, r10, r6);
        if (r8 == null) goto L21;
        r7.a = r8;
    L21:
        return r7;
    L17:
        r6 = false;
        goto L18
    L9:
        r2 = "";
        goto L10
    L5:
        r1 = -1;
        goto L6
    }

    public static xi2.u n(String r2, String r3, String r4) throws Exception {
        FilterNullArrayList r0 = new FilterNullArrayList();
        int r1 = si2.k.c;
        r0.add(si2.k.a.a("category_id", r2));
        r0.add(si2.k.a.a("shop_id", r3));
        r0.add(si2.k.a.a("prefix", r4));
        String r5 = g(d(si2.g.I), r0);
        int r6 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return (xi2.u) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r5, xi2.u.class);
    }

    public static String c(String r4, FilterNullArrayList r5, JSONObject r6, Map r7) throws Exception {
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r4, r5);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r4, r5, "post");
        int r0 = zj2.a.a;
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "paramList");
        Intrinsics.checkNotNullParameter(r6, "paramBody");
        LinkedHashMap r1 = new LinkedHashMap();
        zj2.a.a(r1);
        boolean r2 = true;
        if ((!r5.isEmpty()) == false) goto L8;
        Iterator<E> r8 = r5.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        si2.k r3 = (si2.k) r8.next();
        r1.put(((com.bytedance.android.ec.core.utils.i) r3).a, ((com.bytedance.android.ec.core.utils.i) r3).b);
    L8:
        LinkedHashSet r9 = new LinkedHashSet();
        Iterator<String> r10 = r6.keys();
        if (r10 != null) goto L11;
    L13:
        Iterator r11 = r1.entrySet().iterator();
    L15:
        if (r11.hasNext() == false) goto L23;
        Map.Entry r12 = (Map.Entry) r11.next();
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L15
    L18:
        if (r9.contains(r12.getKey()) == true) goto L15;
        r6.put((String) r12.getKey(), r12.getValue());     // Catch: JSONException -> L21
        goto L15
    L23:
        LiveCommerceApi.a.getClass();
        LiveCommerceApi r13 = LiveCommerceApi.a.a();
        if (r13 == null) goto L36;
        SsResponse r14 = r13.postBodyWithHeader(r4, RequestBody.create(MediaType.parse("application/json"), r6.toString()), r7).execute();
        com.bytedance.android.livesdk.livecommerce.utils.z.a(r4, r14);
        String r15 = (String) r14.body();
        if (r15 != null) goto L28;
    L31:
        if (r2 == true) goto L34;
        return r15;
    L34:
        throw new IllegalArgumentException("response body is null or empty");
    L28:
        if (r15.length() == 0) goto L31;
        r2 = false;
        goto L31
    L36:
        throw new IllegalArgumentException("LiveCommerceApi INSTANCE is null");
    L11:
        if (r10.hasNext() == false) goto L13;
        r9.add(r10.next());
        goto L11
    }

    public static <T> Observable<T> e(String r8, String r9, String r10, f<T> r11) {
        wi2.a[] r0 = new wi2.a[1];
        return Observable.create(new d(r8, r9, r10, r0, r11)).subscribeOn(Schedulers.io()).doOnError(new c(r0, r10)).doAfterNext(new b(r0, r10));
    }

    public static Observable<ECCurrentPromotion> m(final String r12, final String r13, final String r14, final String r15, final String r16, final String r17, final boolean r18, final String r19) {
        final String r10 = si2.g.r;
        OptCardUtil.b(null, "getPopPromotion");
        return e(r12, r13, r10, new g(r14, r15, r12, r13, r16, r17, r19, r10, r18));
    }

    public static Observable<vj2.a> k(String r17, String r18, String r19, String r20, String r21, String r22, List<vj2.d> r23, String r24, int r25, int r26, String r27, boolean r28, String r29, Map<String, String> r30) {
        if (r27 != null) goto L5;
    L8:
        String r0 = si2.g.k;
    L9:
        if (r30 != null) goto L11;
    L13:
        String r15 = r0;
        return e(r19, r20, r15, new e(r30, r17, r18, r19, r20, r21, r22, r24, r28, r25, r26, r23, r29, r15));
    L11:
        if (String.valueOf(42).equals(r30.get("request_scene")) == false) goto L13;
        r0 = "https://ecom5-normal-lq.ecombdapi.com/live/promotions/page/get/bottom/";
        goto L13
    L5:
        if (TextUtils.isEmpty(r27) == true) goto L8;
        r0 = si2.g.a + r27;
        goto L9
    }

    public static Observable<ECCurrentPromotion> l(String r18, String r19, String r20, String r21, String r22, String r23, boolean r24, boolean r25, boolean r26, boolean r27, com.bytedance.android.ec.model.response.s r28, String r29, boolean r30, Map<String, String> r31, uj2.c r32) {
        if (r24 == false) goto L11;
        if (r29 != null) goto L6;
    L9:
        String r0 = si2.g.q;
    L14:
        String r15 = r0;
        OptCardUtil.b(null, "getPopPromotion");
        return e(r20, r21, r15, new a(r30, r31, r21, r18, r19, r20, r22, r23, r27, r28, r32, r15, r24, r26, r25));
    L6:
        if (TextUtils.isEmpty(r29) == true) goto L9;
        r0 = si2.g.a + r29;
        goto L14
    L11:
        if (hh2.f.g() == false) goto L13;
        r0 = si2.g.p;
        goto L14
    L13:
        r0 = si2.g.o;
        goto L14
    }
}
