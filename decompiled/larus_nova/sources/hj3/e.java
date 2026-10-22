package hj3;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.PageLoadStatus;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f485412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f485413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f485414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f485415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f485416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f485417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f485418g;

    public e(JSONObject r100) {
        this.f485418g = r100;
    }

    public final void b(long r100, di.d r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        int r102 = ECMonitorService.f45110b;
        JSONObject r103 = new JSONObject();
        r103.put(EffectConfiguration.KEY_CURSOR, r100);
        Iterator<Map.Entry<String, Object>> r104 = r101.f468711c.a().entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L12;
        Map.Entry<String, Object> r105 = r104.next();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L10
        Result.m9449constructorimpl(r103.put(r105.getKey(), r105.getValue()));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    L12:
        Unit r108 = Unit.INSTANCE;
        JSONObject r109 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r110 = r101.f468709a.a().entrySet().iterator();
    L14:
        if (r110.hasNext() == false) goto L20;
        Map.Entry<String, Object> r111 = r110.next();
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L18
        Result.m9449constructorimpl(r109.put(r111.getKey(), r111.getValue()));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L20:
        Iterator<Map.Entry<String, Object>> r114 = r101.f468710b.a().entrySet().iterator();
    L22:
        if (r114.hasNext() == false) goto L28;
        Map.Entry<String, Object> r115 = r114.next();
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L26
        Result.m9449constructorimpl(r109.put(r115.getKey(), r115.getValue()));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L28:
        Unit r118 = Unit.INSTANCE;
        ECMonitorService.a.a("ec_perf_duration_shop_net", r103, r109, this.f485418g);
    }

    public final void a(boolean r100, PageLoadStatus r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "loadStatus");
        int r103 = ECMonitorService.f45110b;
        JSONObject r104 = new JSONObject();
        String r105 = "1";
        if (r100 == false) goto L5;
        Object r106 = "1";
    L6:
        r104.put("is_first_screen", r106);
        r104.put(FrescoMonitorConst.LOAD_STATUS, r101.getValue());
        r104.put("error_code", r102);
        if (this.f485416e != null) goto L9;
        r105 = "0";
    L9:
        r104.put("flag_render_cache", r105);
        JSONObject r107 = new JSONObject();
        r107.put("t_tab_init_start", this.f485412a);
        r107.put(TabkitFirstFramePref.T_PAGE_INIT_START, this.f485413b);
        r107.put(TabkitFirstFramePref.T_REQUEST_START, this.f485414c);
        r107.put(TabkitFirstFramePref.T_REQUEST_END, this.f485415d);
        r107.put("t_page_show", this.f485417f);
        Long r108 = this.f485416e;
        if (r108 != null) goto L12;
        r108 = this.f485417f;
    L12:
        r107.put("t_page_cache_show", r108);
        if (ECAppInfoService.f48114e.i() == false) goto L34;
        Long r109 = this.f485417f;
        Long r110 = null;
        if (r109 == null) goto L17;
        Long r111 = Long.valueOf(r109.longValue() - k.h(this.f485412a));
    L18:
        r107.put("total_duration", r111);
        Long r112 = this.f485417f;
        if (r112 == null) goto L21;
        Long r113 = Long.valueOf(r112.longValue() - k.h(this.f485413b));
    L22:
        r107.put("total_tab_duration", r113);
        Long r114 = this.f485415d;
        if (r114 == null) goto L25;
        Long r115 = Long.valueOf(r114.longValue() - k.h(this.f485414c));
    L26:
        r107.put(com.bytedance.android.ec.core.event.a.KEY_API_DURATION, r115);
        Long r116 = this.f485417f;
        if (r116 == null) goto L29;
        Long r117 = Long.valueOf(r116.longValue() - k.h(this.f485415d));
    L30:
        r107.put("render_duration", r117);
        Long r118 = this.f485416e;
        if (r118 == null) goto L33;
        r110 = Long.valueOf(r118.longValue() - k.h(this.f485413b));
    L33:
        r107.put("cache_total_tab_duration", r110);
        goto L34
    L29:
        r117 = null;
        goto L30
    L25:
        r115 = null;
        goto L26
    L21:
        r113 = null;
        goto L22
    L17:
        r111 = null;
    L34:
        ECMonitorService.a.a("ec_perf_shop_follow", r104, r107, this.f485418g);
        return;
    L5:
        r106 = "0";
        goto L6
    }
}
