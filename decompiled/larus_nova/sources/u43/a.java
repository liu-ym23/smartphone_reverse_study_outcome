package u43;

import android.content.Context;
import com.bytedance.android.ec.model.abscontainer.ISchemaModel;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.shopping.model.abscontainer.PerformancePointType;
import com.bytedance.android.shopping.model.abscontainer.PrePerformancePointType;
import com.bytedance.android.shopping.skubuy.platform.schema.PlatformSkuBuySchemaModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a<T extends ISchemaModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f548693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f548694b;

    public abstract void a(Context r100);

    public final T c() {
        T r100 = this.f548694b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("schemaModel");
    L5:
        return r100;
    }

    public a() {
        this.f548693a = new LinkedHashMap();
    }

    public static void e(a r100, PerformancePointType r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "type");
        r100.f548693a.put(r101.getValue(), Long.valueOf(System.currentTimeMillis()));
    }

    public final void d(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        PrePerformancePointType[] r102 = PrePerformancePointType.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        PrePerformancePointType r105 = r102[r104];
        if (Intrinsics.areEqual(r105.getValue(), r100) == true) goto L9;
        r104 = r104 + 1;
    L9:
        if (r105 == null) goto L18;
        Map<String, Long> r106 = this.f548693a;
        if (r101 == null) goto L13;
        long r107 = r101.longValue();
    L14:
        r106.put(r100, Long.valueOf(r107));
        return;
    L13:
        r107 = System.currentTimeMillis();
        goto L14
    L18:
        return;
    L8:
        r105 = null;
        goto L9
    }

    public final void b(Context r100, String r101, EntranceInfoScene r102, Function1<? super T, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "entranceInfoScene");
        e(this, PerformancePointType.C_PAGE_START);
        e(this, PerformancePointType.PARSE_SCHEMA_START);
        d(PrePerformancePointType.CREATE_SCHEMA_START.getValue(), null);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "entranceInfoScene");
        PlatformSkuBuySchemaModel r104 = new PlatformSkuBuySchemaModel(r101, r102);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        ((com.bytedance.android.shopping.skubuy.start_flow.a) this).f548694b = r104;
        T r105 = this.f548694b;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("schemaModel");
    L5:
        Unit r106 = r103.invoke(r105);
        d(PrePerformancePointType.CREATE_SCHEMA_END.getValue(), null);
        a(r100);
    }
}
