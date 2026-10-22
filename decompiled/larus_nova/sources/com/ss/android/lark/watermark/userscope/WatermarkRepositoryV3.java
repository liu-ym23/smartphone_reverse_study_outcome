package com.ss.android.lark.watermark.userscope;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.passport.v1.GetHiddenWaterMarkImageRequest;
import com.bytedance.lark.pb.passport.v1.GetHiddenWaterMarkImageResponse;
import com.bytedance.lark.pb.passport.v1.GetWaterMarkConfigResponse;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.android.lark.watermark.dto.WatermarkDensity;
import com.tencent.connect.common.Constants;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class WatermarkRepositoryV3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.storage.a f445391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f445392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<u0> f445393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f445394d;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WatermarkData f445395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SyncDataStrategy f445396b;

        public b(WatermarkData r100, SyncDataStrategy r101) {
            this.f445395a = r100;
            this.f445396b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            com.bytedance.lark.rustclient.api.s r100 = (com.bytedance.lark.rustclient.api.s) r210;
            Intrinsics.checkNotNullParameter(r100, "result");
            String r110 = null;
            if ((r100 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L22;
            WatermarkData r111 = this.f445395a;
            GetHiddenWaterMarkImageResponse r101 = (GetHiddenWaterMarkImageResponse) ((com.bytedance.lark.rustclient.api.x) r100).f253935c;
            if (r101 == null) goto L7;
            String r112 = r101.water_mark_url;
        L8:
            WatermarkData r102 = WatermarkData.copy$default(r111, false, null, false, r112, 0, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 2039, null);
            Pair[] r103 = new Pair[2];
            r103[0] = TuplesKt.to("event", "fetch_url");
            SyncDataStrategy r104 = this.f445396b;
            if (r104 != SyncDataStrategy.FORCE_SERVER) goto L12;
            String r105 = BenefitStore.FROM_SERVER;
        L18:
            r103[1] = TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r105);
            ToolsV3Kt.c("scs_watermark_refactor", MapsKt.mapOf(r103), 0, 12);
            StringBuilder r106 = new StringBuilder("fetch ");
            r106.append(this.f445396b);
            r106.append(" dark watermark success data is: ");
            if (r102 == null) goto L21;
            r110 = r102.getInfo();
        L21:
            r106.append(r110);
            Log.i("watermarkV3", r106.toString());
            return r102;
        L12:
            if (r104 != SyncDataStrategy.LOCAL) goto L15;
            r105 = "local";
            goto L18
        L15:
            if (r104 != SyncDataStrategy.TRY_LOCAL) goto L17;
            r105 = "try_local";
            goto L18
        L17:
            r105 = "unknown";
            goto L18
        L7:
            r112 = null;
            goto L8
        L22:
            Log.e("watermarkV3", "fetch " + this.f445396b + " dark watermark Error, data is null");
            Pair[] r107 = new Pair[3];
            r107[0] = TuplesKt.to("event", "fetch_url");
            boolean r108 = r100 instanceof com.bytedance.lark.rustclient.api.c;
            if (r108 == false) goto L27;
            LarkError r109 = ((com.bytedance.lark.rustclient.api.c) r100).f253907c.f253922b;
            if (r109 == null) goto L27;
            Integer r113 = r109.code;
        L28:
            r107[1] = TuplesKt.to("error_code", r113);
            if (r108 == false) goto L35;
            LarkError r114 = ((com.bytedance.lark.rustclient.api.c) r100).f253907c.f253922b;
            if (r114 == null) goto L35;
            LarkError.ErrorDetails r115 = r114.details;
            if (r115 == null) goto L35;
            r110 = r115.debug_message;
        L35:
            r107[2] = TuplesKt.to("error_msg", r110);
            ToolsV3Kt.c("scs_watermark_refactor", MapsKt.mapOf(r107), 1, 12);
            return this.f445395a;
        L27:
            r113 = null;
            goto L28
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WatermarkData f445397a;

        public c(WatermarkData r100) {
            this.f445397a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "error");
            Log.e("watermarkV3", "fetch dark error: " + r101.getMessage());
            return this.f445397a;
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f445398a = null;

        static {
            f445398a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Log.i("watermarkV3", "fetch dark watermark dispose");
            ToolsV3Kt.c("scs_watermark_network_dispose", null, 1, 14);
        }
    }

    static {
    }

    public final KVRepo b() {
        return (KVRepo) this.f445394d.getValue();
    }

    public static WatermarkData d(GetWaterMarkConfigResponse.Builder r210) {
        String r100 = "0.12";
        String r101 = r210.content;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L43:
        String r103 = r210.clear_style.get(GXTemplateKey.STYLE_OPACITY);     // Catch: Exception -> L12
        if (r103 != null) goto L10;
        r103 = "0.12";
    L10:
        float r110 = CastFloatProtector.parseFloat(r103);     // Catch: Exception -> L12
    L47:
        String r104 = r210.clear_style.get("dark_opacity");     // Catch: Exception -> L19
        if (r104 == null) goto L17;
        r100 = r104;
    L17:
        float r111 = CastFloatProtector.parseFloat(r100);     // Catch: Exception -> L19
    L41:
        String r105 = r210.clear_style.get("font_size");     // Catch: Exception -> L25
        if (r105 != null) goto L23;
        r105 = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
    L23:
        Integer r106 = CastIntegerProtector.valueOf(r105);     // Catch: Exception -> L25
    L45:
        String r107 = r210.clear_style.get("rotate_angle");     // Catch: Exception -> L31
        if (r107 != null) goto L29;
        r107 = "-15";
    L29:
        Integer r108 = CastIntegerProtector.valueOf(r107);     // Catch: Exception -> L31
    L32:
        WatermarkDensity r109 = WatermarkDensity.Companion.getWatermarkDensity(r210.clear_style.get("density"));
        boolean r112 = r210.obvious_enabled.booleanValue();
        String r113 = r210.content;
        if (r113 != null) goto L35;
        r113 = "";
    L35:
        String r114 = StringsKt.trim(r113).toString();
        boolean r115 = r210.hidden_enabled.booleanValue();
        if (r102 == false) goto L38;
        long r116 = TimeUnit.SECONDS.toMillis(60);
    L39:
        Intrinsics.checkNotNull(r106);
        int r117 = r106.intValue();
        Intrinsics.checkNotNull(r108);
        return new WatermarkData(r112, r114, r115, null, r116, r110, r111, r117, r108.intValue(), r109.getHorizontalInterval(), r109.getVerticalInterval(), 8, null);
    L38:
        r116 = 0;
    L31:
        r108 = -15;
    L25:
        r106 = 14;
    L19:
        r111 = 0.08f;
    L12:
        r110 = 0.12f;
        goto L47
    L5:
        if (StringsKt.contains$default(r101, "{{.timestamp}}", false, 2, null) != true) goto L43;
        r102 = true;
        goto L43
    }

    public final boolean c(String r100) {
        boolean r101 = false;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.security.watermark_osdk_skip_request_disabled") == false) goto L5;
        return false;
    L5:
        LarkAppContext.Companion.getClass();
        boolean r102 = LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
        Set<u0> r103 = this.f445393c;
        if ((r103 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L9;
        u0 r105 = (u0) r104.next();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L16
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(r105.isDoubaoEnterpriseUser()));     // Catch: Throwable -> L16
    L18:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r107) == false) goto L22;
        r107 = r108;
    L22:
        if (((Boolean) r107).booleanValue() == false) goto L12;
        boolean r109 = true;
    L24:
        if (r102 == false) goto L27;
        if (r109 == true) goto L27;
        r101 = true;
    L27:
        if (r101 == false) goto L29;
        Log.i("watermarkV3", "skip " + r100 + " for non-enterprise officesdk");
    L29:
        return r101;
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L9:
        r109 = false;
        goto L24
    L8:
        if (r103.isEmpty() == false) goto L10;
        goto L9
    }

    public final Single<WatermarkData> a(WatermarkData r110, SyncDataStrategy r111) {
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        if (r110 != null) goto L7;
        Log.i("watermarkV3", "fetch " + r111 + " dark, data is null");
        return Single.just(r110);
    L7:
        if (r110.getMysteriousEnabled() == true) goto L11;
        Log.i("watermarkV3", "fetch " + r111 + " dark, watermarkData.mysteriousEnabled is false return");
        return Single.just(r110);
    L11:
        if (c("fetch " + r111 + " dark watermark image") == true) goto L13;
        GetHiddenWaterMarkImageRequest.Builder r100 = new GetHiddenWaterMarkImageRequest.Builder();
        r100.alpha_flag = 1;
        r100.color_rgba8 = -241;
        r100.size_option = GetHiddenWaterMarkImageRequest.ImgSizeOption.ImgSizeOption_SIZE_192_192;
        r100.sync_data_strategy = r111;
        return this.f445392b.h(new com.bytedance.lark.rustclient.api.d(r100, GetHiddenWaterMarkImageResponse.ADAPTER, Command.GET_HIDDEN_WATER_MARK_IMAGE, null, null, null, null, 248)).a().firstOrError().map(new b(r110, r111)).onErrorReturn(new c(r110)).doOnDispose(d.f445398a);
    L13:
        return Single.just(r110);
    }

    @Inject
    public WatermarkRepositoryV3(com.ss.android.lark.storage.kv.storage.a r100, com.bytedance.lark.rustclient.api.l r101, Set<u0> r102) {
        Intrinsics.checkNotNullParameter(r100, "userKV");
        Intrinsics.checkNotNullParameter(r101, "userRustClient");
        Intrinsics.checkNotNullParameter(r102, "runtimeInfoProviders");
        this.f445391a = r100;
        this.f445392b = r101;
        this.f445393c = r102;
        this.f445394d = LazyKt.lazy(new WatermarkRepositoryV3$userSP$2(this));
    }
}
