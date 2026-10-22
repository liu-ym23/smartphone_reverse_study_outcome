package com.bytedance.locallife.poi.dito.container.api;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.common.request.k;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.model.response.BaseResponse;
import com.bytedance.locallife.poi.experiment.o;
import com.bytedance.locallife.poi.settings.IPoiSetting;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.Path;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.settings.PoiSetting;
import com.ss.android.ugc.aweme.prefetch.newsdk.PrefetchType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoPoiApi implements lp6.b, gy6.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f262360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Function6<? super DitoResponse, ? super Boolean, ? super Integer, ? super Long, ? super Long, ? super String, Unit> f262361g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f262362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f262363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DitoViewModel f262364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f262365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f262366e;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000fJQ\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0003\u0010\u0003\u001a\u00020\u00022\u0019\b\u0001\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u00050\u00042\u0016\b\u0003\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'JQ\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0003\u0010\u0003\u001a\u00020\u00022\u0019\b\u0001\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u00050\u00042\u0016\b\u0003\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'JQ\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\b2\b\b\u0003\u0010\u0003\u001a\u00020\u00022\u0019\b\u0001\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u00050\u00042\u0016\b\u0003\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H'¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/poi/dito/container/api/DitoPoiApi$DitoPoiRequestApi;", "", "", "path", "", "Lkotlin/jvm/JvmSuppressWildcards;", "requestMap", "headers", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "Lcom/bytedance/locallife/dito/common/request/k;", "getDitoChunkDataNoPathEncode", "getDitoChunkDataPrefetchPrePageNoPathEncode", "Lcom/bytedance/locallife/poi/dito/container/api/DitoPoiApi$DitoResponse;", "getDitoData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public interface DitoPoiRequestApi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f262367a = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f262368a = null;

            static {
                f262368a = new a();
            }

            public a() {
            }
        }

        public static final class b {
            public static /* synthetic */ Observable a(DitoPoiRequestApi r100, Map r101, Map r102) {
                return r100.getDitoData("/aweme/v1/dito/", r101, r102);
            }
        }

        static {
            f262367a = a.f262368a;
        }

        @Headers({"Dito-Use-Chunk:1"})
        @Streaming
        @GET("{path}")
        Observable<SsResponse<k>> getDitoChunkDataNoPathEncode(@Path(encode = false, value = "path") String r100, @QueryMap Map<String, Object> r101, @HeaderMap Map<String, String> r102);

        @Headers({"Dito-Use-Chunk:1"})
        @Streaming
        @GET("{path}")
        Observable<SsResponse<k>> getDitoChunkDataPrefetchPrePageNoPathEncode(@Path(encode = false, value = "path") String r100, @QueryMap Map<String, Object> r101, @HeaderMap Map<String, String> r102);

        @GET("{path}")
        Observable<SsResponse<DitoResponse>> getDitoData(@Path("path") String r100, @QueryMap Map<String, Object> r101, @HeaderMap Map<String, String> r102);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/poi/dito/container/api/DitoPoiApi$DitoResponse;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "Ljava/io/Serializable;", "ditoPage", "Lcom/bytedance/locallife/dito/data/DitoPage;", "totalCost", "", "serverTrace", "", "", "(Lcom/bytedance/locallife/dito/data/DitoPage;ILjava/util/Map;)V", "getDitoPage", "()Lcom/bytedance/locallife/dito/data/DitoPage;", "getServerTrace", "()Ljava/util/Map;", "getTotalCost", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class DitoResponse extends BaseResponse implements Serializable {

        @SerializedName("dito_data")
        private final DitoPage ditoPage;

        @SerializedName("server_trace")
        private final Map<String, Integer> serverTrace;

        @SerializedName("total_cost")
        private final int totalCost;

        public DitoResponse() {
            this(null, 0, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DitoResponse copy$default(DitoResponse r100, DitoPage r101, int r102, Map r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.ditoPage;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.totalCost;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.serverTrace;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final DitoPage component1() {
            return this.ditoPage;
        }

        public final int component2() {
            return this.totalCost;
        }

        public final Map<String, Integer> component3() {
            return this.serverTrace;
        }

        public final DitoResponse copy(DitoPage r100, int r101, Map<String, Integer> r102) {
            return new DitoResponse(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof DitoResponse) == true) goto L8;
            return false;
        L8:
            DitoResponse r101 = (DitoResponse) r100;
            if (Intrinsics.areEqual(this.ditoPage, r101.ditoPage) == true) goto L12;
            return false;
        L12:
            if (this.totalCost == r101.totalCost) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.serverTrace, r101.serverTrace) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            DitoPage r100 = this.ditoPage;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.totalCost) * 31;
            Map<String, Integer> r104 = this.serverTrace;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        @Override // com.bytedance.locallife.model.response.BaseResponse
        public String toString() {
            return "DitoResponse(ditoPage=" + this.ditoPage + ", totalCost=" + this.totalCost + ", serverTrace=" + this.serverTrace + ')';
        }

        public final DitoPage getDitoPage() {
            return this.ditoPage;
        }

        public final Map<String, Integer> getServerTrace() {
            return this.serverTrace;
        }

        public final int getTotalCost() {
            return this.totalCost;
        }

        public DitoResponse(DitoPage r100, int r101, Map<String, Integer> r102) {
            this.ditoPage = r100;
            this.totalCost = r101;
            this.serverTrace = r102;
        }

        public /* synthetic */ DitoResponse(DitoPage r100, int r101, Map r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f262369a = null;

        static {
            f262369a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SsResponse r101 = (SsResponse) r100;
            com.bytedance.locallife.poi.perf.timing.a.a("预请求", new Pair[0]);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f262370a = null;

        static {
            f262370a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f262371a = null;

        static {
            f262371a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SsResponse r101 = (SsResponse) r100;
            com.bytedance.locallife.poi.perf.timing.a.a("预请求", new Pair[0]);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f262372a = null;

        static {
            f262372a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f<T> f262373a = null;

        static {
            f262373a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SsResponse r101 = (SsResponse) r100;
            com.bytedance.locallife.poi.perf.timing.a.a("预请求", new Pair[0]);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T> f262374a = null;

        static {
            f262374a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h<T> f262375a = null;

        static {
            f262375a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class i<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPoiApi f262376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f262377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<String, Object> f262378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f262379d;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter<lp6.a> f262380a;

            public a(ObservableEmitter<lp6.a> r100) {
                this.f262380a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                ObservableEmitter<lp6.a> r102 = this.f262380a;
                if (r101 != null) goto L5;
                r101 = new Throwable();
            L5:
                r102.onError(r101);
                this.f262380a.onComplete();
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DitoPoiApi f262381a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter<lp6.a> f262382b;

            public b(DitoPoiApi r100, ObservableEmitter<lp6.a> r101) {
                this.f262381a = r100;
                this.f262382b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                SsResponse r101 = (SsResponse) r100;
                long r102 = System.currentTimeMillis();
                com.bytedance.locallife.poi.perf.timing.a.b("请求返回", new Pair[0]);
                DitoViewModel r103 = this.f262381a.f262364c;
                if (r103 == null) goto L12;
                ConcurrentHashMap<String, String> r104 = r103.C;
                r104.put("network_status_code", String.valueOf(r101.code()));
                String r105 = r101.message();
                if (r105 != null) goto L7;
                r105 = "";
            L7:
                String r106 = r104.put("network_status_message", r105);
                List<Header> r107 = r101.headers();
                LinkedHashMap r108 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r107, 10)), 16));
                Iterator<T> r109 = r107.iterator();
            L9:
                if (r109.hasNext() == false) goto L11;
                Header r110 = (Header) r109.next();
                Pair r111 = TuplesKt.to(r110.getName(), r110.getValue());
                r108.put(r111.getFirst(), r111.getSecond());
                goto L9
            L11:
                Intrinsics.checkNotNullParameter(r108, "headers");
                r103.F.putAll(r108);
            L12:
                ((k) r101.body()).a(new com.bytedance.locallife.poi.dito.container.api.a(r101, this.f262382b, this.f262381a, r102));
            }
        }

        public i(DitoPoiApi r100, Ref.ObjectRef<String> r101, Map<String, ? extends Object> r102, Map<String, String> r103) {
            this.f262376a = r100;
            this.f262377b = r101;
            this.f262378c = r102;
            this.f262379d = r103;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<lp6.a> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            ((DitoPoiRequestApi) this.f262376a.f262365d.getValue()).getDitoChunkDataNoPathEncode(this.f262377b.element, this.f262378c, this.f262379d).doOnError(new a(r100)).subscribe(new b(this.f262376a, r100));
        }
    }

    public static final class j<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j<T, R> f262383a = null;

        static {
            f262383a = new j();
        }

        public j() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            SsResponse r101 = (SsResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            DitoResponse r102 = (DitoResponse) r101.body();
            DitoPage r103 = r102.getDitoPage();
            if (r103 == null) goto L15;
            DitoPageInfo r104 = r103.getPageInfo();
            if (r104 == null) goto L15;
            Map<String, Object> r105 = r104.getData();
            if (r105 == null) goto L15;
            BaseResponse.ServerTimeExtra r106 = r102.extra;
            if (r106 == null) goto L12;
            String r107 = r106.logid;
            if (r107 == null) goto L12;
        L13:
            r105.put("extraLogId", r107);
        L12:
            r107 = "";
        L15:
            return aq6.c.a(r101, r102.getDitoPage());
        }
    }

    static {
        f262361g = DitoPoiApi$Companion$chunkCallback$1.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.CharSequence] */
    @Override // lp6.b
    public final Observable<lp6.a> b(com.bytedance.locallife.dito.data.k r100) {
        Intrinsics.checkNotNullParameter(r100, "requestData");
        if (RxJavaPlugins.getErrorHandler() != null) goto L5;
    L6:
        RxJavaPlugins.setErrorHandler(h.f262375a);
    L7:
        qt6.b r101 = HostServiceUtilsKt.S();
        r100.f258209b.get("poi_id");
        r101.m();
        String r102 = oy6.c.f527138a;
        int r103 = com.bytedance.locallife.common.utils.j.f257151a;
        if (com.bytedance.locallife.common.utils.j.a(oy6.c.f527138a) == false) goto L10;
        r100.f258209b.put("router_params", oy6.c.f527138a);
    L10:
        Map r104 = com.bytedance.locallife.dito.common.request.i.a(r100, HostServiceUtilsKt.M().j());
        Ref.ObjectRef r105 = new Ref.ObjectRef();
        Object r106 = r100.f258211d.get("downgrade_url");
        if ((r106 instanceof String) == false) goto L13;
        ?? r107 = (String) r106;
    L14:
        r105.element = r107;
        if (r107 != 0) goto L17;
    L20:
        boolean r108 = true;
    L21:
        if (r108 == false) goto L23;
        r105.element = "/aweme/v1/dito/";
    L23:
        Map r109 = r101.k();
        Map<String, String> r110 = HostServiceUtilsKt.h().a();
        if ((true ^ r110.isEmpty()) == true) goto L26;
    L30:
        int r111 = com.bytedance.locallife.dito.common.request.a.f257658a;
        if (com.bytedance.locallife.dito.common.request.a.a(Intrinsics.areEqual(r100.f258209b.get("dito_retry"), BdpAppEventConstant.YES)) == false) goto L35;
        return Observable.create(new i(this, r105, r104, r109));
    L35:
        return DitoPoiRequestApi.b.a((DitoPoiRequestApi) this.f262366e.getValue(), r104, r109).map(j.f262383a);
    L26:
        if (r110.containsKey("ability_info") == false) goto L30;
        if (com.bytedance.locallife.dito.utils.j.i(r110.get("ability_info")) == false) goto L30;
        r100.f258209b.putAll(r110);
        goto L30
    L17:
        if (r107.length() == 0) goto L20;
        r108 = false;
        goto L21
    L13:
        r107 = 0;
        goto L14
    L5:
        if (HostServiceUtilsKt.u().a() == false) goto L7;
        goto L6
    }

    @Override // gy6.a
    public final void a(com.bytedance.locallife.dito.data.k r100, PrefetchType r101) {
        Intrinsics.checkNotNullParameter(r100, "requestData");
        Intrinsics.checkNotNullParameter(r101, "prefetchType");
        com.bytedance.locallife.poi.perf.timing.a.c("预请求", new Pair[0]);
        String r102 = oy6.c.f527138a;
        if (r100 == null) goto L7;
        int r103 = com.bytedance.locallife.common.utils.j.f257151a;
        if (com.bytedance.locallife.common.utils.j.a(oy6.c.f527138a) == false) goto L7;
        r100.f258209b.put("router_params", oy6.c.f527138a);
    L7:
        Map<String, String> r104 = HostServiceUtilsKt.S().k();
        Map<String, String> r105 = HostServiceUtilsKt.h().a();
        if ((!r105.isEmpty()) == true) goto L10;
    L14:
        Map<String, Object> r106 = com.bytedance.locallife.dito.common.request.i.a(r100, HostServiceUtilsKt.M().j());
        int r107 = com.bytedance.locallife.dito.common.request.a.f257658a;
        if (com.bytedance.locallife.dito.common.request.a.a(Intrinsics.areEqual(r100.f258209b.get("dito_retry"), BdpAppEventConstant.YES)) == true) goto L17;
        DitoPoiRequestApi.b.a((DitoPoiRequestApi) this.f262366e.getValue(), r106, r104).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(f.f262373a, g.f262374a);
        return;
    L17:
        if (r101 != PrefetchType.PRE_PAGE_PREFETCH) goto L26;
        int r108 = o.f262596a;
        if (Intrinsics.areEqual(HostServiceUtilsKt.y().a("poi_smart_prefetch_new_path", Boolean.TYPE, Boolean.FALSE), Boolean.TRUE) == false) goto L26;
        PoiSetting r109 = IPoiSetting.a();
        if (r109 == null) goto L24;
        String r110 = r109.t();
        if (r110 == null) goto L24;
    L25:
        ((DitoPoiRequestApi) this.f262365d.getValue()).getDitoChunkDataPrefetchPrePageNoPathEncode(r110, r106, r104).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(b.f262369a, c.f262370a);
        return;
    L24:
        r110 = "/aweme/v1/dito/prefetch/";
    L26:
        ((DitoPoiRequestApi) this.f262365d.getValue()).getDitoChunkDataNoPathEncode("/aweme/v1/dito/", r106, r104).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(d.f262371a, e.f262372a);
        return;
    L10:
        if (r105.containsKey("ability_info") == false) goto L14;
        if (com.bytedance.locallife.dito.utils.j.i(r105.get("ability_info")) == false) goto L14;
        r100.f258209b.putAll(r105);
        goto L14
    }

    public DitoPoiApi(final String r100, boolean r101, Map<String, String> r102, DitoViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        this.f262362a = r101;
        this.f262363b = r102;
        this.f262364c = r103;
        this.f262365d = LazyKt.lazy(new DitoPoiApi$ditoChunkApi$2(r100, this));
        this.f262366e = LazyKt.lazy(new DitoPoiApi$ditoNormalApi$2(r100, this));
    }
}
