package com.bytedance.locallife.live.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadItem;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.locallife.live.experiment.LiveLocalLifeShelfPreloadExperiment;
import com.bytedance.locallife.live.goodsshelves.manager.GoodsShelfCardPreloadManager;
import com.bytedance.locallife.live.settings.PoiOrderSettings;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.bean.DetailEnterPage;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f260717d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f260718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f260719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f260720c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.locallife.live.util.l$a$a, reason: collision with other inner class name */
        public static final class RunnableC3680a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ies.bullet.preloadv2.a f260721a;

            public RunnableC3680a(com.bytedance.ies.bullet.preloadv2.a r100) {
                this.f260721a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean r100 = PreloadV2.f247628a;     // Catch: Throwable -> L4
                PreloadV2.f(this.f260721a, "default_bid");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final String a(String r100) {
            int r101 = l.f260717d;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
            if (r100 != null) goto L6;
        L9:
            boolean r103 = true;
        L10:
            if (r103 == true) goto L26;
            Uri r104 = UriProtector.parse(r100);     // Catch: Throwable -> L21
            String r105 = UriProtector.getQueryParameter(r104, "bid");     // Catch: Throwable -> L21
            if (r105 != null) goto L15;
            r105 = "default_bid";
        L15:
            Lazy<SchemaService> r106 = SchemaService.f248116f;     // Catch: Throwable -> L21
            Uri r107 = (Uri) new y36.s(SchemaService.a.a().b(r105, r104), "url").f565862b;     // Catch: Throwable -> L21
            if (r107 == null) goto L19;
            r104 = r107;
        L19:
            return new a36.a(r104).b();
        L26:
            return null;
        L6:
            if (StringsKt.isBlank(r100) == true) goto L9;
            r103 = false;
        L21:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            Throwable r109 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
            if (r109 == null) goto L30;
            if (((Boolean) LiveLifeSaaSUtil.f260655d.getValue()).booleanValue() == false) goto L26;
            throw r109;
        L30:
            throw new KotlinNothingValueException();
        }

        public static final String b(Uri r100) {
            int r101 = l.f260717d;
            String r102 = a36.b.a(r100, "default_bid");
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            boolean r103 = false;
            if (r102.length() != 0) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L32;
            String r105 = a36.b.e(r100, "channel");
            String r106 = a36.b.e(r100, "bundle");
            if (r105 != null) goto L13;
        L16:
            boolean r107 = true;
        L17:
            if (r107 == true) goto L27;
            if (r106 != null) goto L20;
        L23:
            boolean r108 = true;
        L24:
            if (r108 == true) goto L27;
            return r105 + '_' + r106;
        L20:
            if (r106.length() == 0) goto L23;
            r108 = false;
        L27:
            if (r102.length() != 0) goto L29;
            r103 = true;
        L29:
            if (r103 == true) goto L35;
            return r102;
        L35:
            return r100.toString();
        L13:
            if (r105.length() == 0) goto L16;
            r107 = false;
            goto L17
        L32:
            return UriProtector.parse(r102).buildUpon().clearQuery().toString();
        L8:
            r104 = false;
            goto L9
        }

        public static void c(String r100) {
            com.bytedance.ies.bullet.preloadv2.a r101 = new com.bytedance.ies.bullet.preloadv2.a();
            r101.f247655c = false;
            r101.f247656d = true;
            r101.f247657e = true;
            List<PreloadItem> r102 = r101.f247654b;
            JSONObject r103 = new JSONObject();
            r103.put("type", ThumbGlideUrl.SOURCE_TEMPLATE);
            r103.put("url", r100);
            ArrayList r104 = (ArrayList) r102;
            r104.add(new com.bytedance.ies.bullet.preloadv2.cache.j(r103));
            Schedulers.io().scheduleDirect(new RunnableC3680a(r101));
        }

        public static void d(String r110) {
            Intrinsics.checkNotNullParameter(r110, "orderPageUrl");
            LiveLifeSaaSUtil.t().d("LiveLifePreloadUtil", "start preload " + r110);     // Catch: Exception -> L28
            if (Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r110), "page_type_opt"), "lite_page") == false) goto L6;
            Schedulers.io().scheduleDirect(new k(r110));     // Catch: Exception -> L28
        L7:
            boolean r100 = LiveLocalLifeUtil.f260684b;     // Catch: Exception -> L28
            LiveLifeSaaSUtil.g().isPPEEnable();     // Catch: Exception -> L28
            com.bytedance.locallife.live.settings.f r101 = (com.bytedance.locallife.live.settings.f) PoiOrderSettings.f260637a.getValue();     // Catch: Exception -> L28
            if (r101 == null) goto L12;
            com.bytedance.locallife.live.settings.a r102 = r101.a();     // Catch: Exception -> L28
            if (r102 == null) goto L12;
            List<String> r103 = r102.a();     // Catch: Exception -> L28
        L13:
            if (r103 == null) goto L18;
            List<String> r104 = r103;     // Catch: Exception -> L28
            ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));     // Catch: Exception -> L28
            Iterator<T> r106 = r104.iterator();     // Catch: Exception -> L28
        L16:
            if (r106.hasNext() == false) goto L19;
            r105.add(new com.bytedance.forest.model.p((String) r106.next(), null, new com.bytedance.ies.bullet.forest.w(null, 3), 28));     // Catch: Exception -> L28
        L19:
            PreloadType r107 = PreloadType.LYNX;     // Catch: Exception -> L28
            if (r105 == null) goto L22;
            Map r108 = MapsKt.mapOf(TuplesKt.to("script", r105));     // Catch: Exception -> L28
        L23:
            com.bytedance.forest.model.n r111 = new com.bytedance.forest.model.n(null, r107, r108);     // Catch: Exception -> L28
            com.bytedance.ies.bullet.forest.f<String, com.bytedance.forest.model.o> r109 = ForestLoader.f246728a;     // Catch: Exception -> L28
            Forest r112 = ForestLoader.d();     // Catch: Exception -> L28
            if (r112 == null) goto L26;
            Forest.preload$default(r112, r111, null, null, 6, null);     // Catch: Exception -> L28
        L26:
            int r113 = qv6.e.f534905a;     // Catch: Exception -> L28
            qv6.e.b("live_life_performance_pre_load_status", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("location", "preload_order"), TuplesKt.to("status", "success")}), false, null);     // Catch: Exception -> L28
            return;
        L22:
            r108 = null;
            goto L23
        L18:
            r105 = null;
        L12:
            r103 = null;
            goto L13
        L6:
            c(r110);     // Catch: Exception -> L28
        L28:
            e = move-exception;
            int r114 = qv6.e.f534905a;
            qv6.e.b("live_life_performance_pre_load_status", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("location", "preload_order"), TuplesKt.to("status", "fail"), TuplesKt.to("detail", e.getMessage())}), false, null);
        }
    }

    static {
        new a();
    }

    public l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        this.f260718a = r100;
    }

    public final void a(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LiveLocalLifeViewModel.Companion r101 = LiveLocalLifeViewModel.Companion;
        String r102 = this.f260718a;
        r101.getClass();
        LiveLocalLifeViewModel r103 = LiveLocalLifeViewModel.Companion.a(r102);
        boolean r104 = false;
        if (r103 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L10;
        return;
    L10:
        LiveLifeSaaSUtil.o().a("life_live_shelf_api_preload");
        LiveLifeSaaSUtil.t().i("LiveLifePreloadUtil", "secondaryPreload started notFistTime: " + this.f260719b);
        if (1 != ((Number) LiveLocalLifeShelfPreloadExperiment.f259496a.getValue()).intValue()) goto L13;
        r104 = true;
    L13:
        Object r106 = null;
        if (r104 == true) goto L24;
        LiveLifeSaaSUtil.o().b();
        if ((r106 instanceof Map) == false) goto L18;
        Map r107 = (Map) null;
    L18:
        LiveLocalLifeViewModel r108 = LiveLocalLifeViewModel.Companion.a(this.f260718a);
        if (r108 == null) goto L24;
        com.bytedance.locallife.live.goodsshelves.manager.l r109 = r108.getLiveLifeShelfCacheManager();
        if (r109 == null) goto L24;
        r109.d(null, this.f260718a);
    L24:
        if (this.f260719b == false) goto L26;
        return;
    L26:
        this.f260719b = true;
        if ((r100 instanceof FragmentActivity) == false) goto L30;
        ((FragmentActivity) r100).getLifecycle().addObserver(new LiveLifePreloadUtil$preloadGoodsDetail$1(r100));
        LiveLifeSaaSUtil.e().d((Activity) r100, DetailEnterPage.LIVE);
        n.a("goods_detail_preload", null);
    L30:
        if (com.bytedance.locallife.live.experiment.u.a() == true) goto L42;
        LiveLocalLifeViewModel r110 = LiveLocalLifeViewModel.Companion.a(this.f260718a);
        if (r110 == null) goto L36;
        kv6.e r111 = r110.getLynxViewPreloadManager();
        if (r111 == null) goto L36;
        r111.d(r100);
    L36:
        LiveLocalLifeViewModel r112 = LiveLocalLifeViewModel.Companion.a(this.f260718a);
        if (r112 == null) goto L43;
        GoodsShelfCardPreloadManager r113 = r112.getShelfCardPreloadManager();
        if (r113 == null) goto L44;
        r113.d(r100, this.f260718a);
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L5:
        if (r103.isPreview() != true) goto L7;
        r105 = true;
        goto L8
    }
}
