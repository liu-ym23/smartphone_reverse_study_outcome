package du4;

import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.bitable.loading.loadingview.GlobalShareRecordLoadingFactory;
import com.bytedance.ee.bear.bitable.loading.loadingview.ViewContentLoadingFactory;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<ELoadingType, d> f470041a = null;

    static {
        f470041a = MapsKt.mapOf(new Pair[]{TuplesKt.to(ELoadingType.VIEW_CONTAINER, new ViewContentLoadingFactory()), TuplesKt.to(ELoadingType.HEADER, new fu4.b()), TuplesKt.to(ELoadingType.VIEW_CATALOG, new fu4.d()), TuplesKt.to(ELoadingType.TOOL_BAR, new fu4.c()), TuplesKt.to(ELoadingType.GLOBAL_SHARE_RECORD, new GlobalShareRecordLoadingFactory()), TuplesKt.to(ELoadingType.GLOBAL_BASE_ADD, new fu4.a())});
    }
}
