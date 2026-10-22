package g2a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.platform.api.f2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f479757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f479758b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f479759c = null;

    static {
        Lazy r100 = LazyKt.lazy(new g());
        f479757a = r100;
        f2 r101 = (f2) r100.getValue();
        if (r101 == null) goto L8;
        List<String> r102 = r101.p();
        if (r102 == null) goto L8;
        List<String> r103 = CollectionsKt.filterNotNull(r102);
        if (r103 == null) goto L8;
    L9:
        FLogger r104 = FLogger.f375446a;
        r104.d("SensitiveConstant", "sensitiveKey -> " + r103);
        f479758b = r103;
        String r105 = "\"(" + CollectionsKt.joinToString$default(r103, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null) + ")\"\\s*:\\s*\"(.*?)\"";
        r104.d("SensitiveConstant", "sensitivePatternString -> " + r105);
        f479759c = r105;
        return;
    L8:
        r103 = CollectionsKt.emptyList();
        goto L9
    }
}
