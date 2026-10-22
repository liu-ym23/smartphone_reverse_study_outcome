package com.bytedance.ee.bear.bitable.homepage.chart;

import com.android.ttcjpaysdk.base.ui.Utils.CJPayDiscountTextUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartType;", "", "value", "", "loadingRes", "", "chartHeightPxInList", "<init>", "(Ljava/lang/String;ILjava/lang/String;II)V", "getValue", "()Ljava/lang/String;", "getLoadingRes", "()I", "COLUMN", CJPayDiscountTextUtils.CJ_PAY_STRIKE_THROUGH_TEXT_STYLE, "COMBO", "BAR", "SCATTER", "PIE", "STATISTICS", "WORD_CLOUD", "FUNNEL", "UNKNOWN", "calculateHeightPx", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChartType extends Enum<ChartType> {
    public static final ChartType BAR = null;
    public static final ChartType COLUMN = null;
    public static final ChartType COMBO = null;
    public static final a Companion = null;
    public static final ChartType FUNNEL = null;
    public static final ChartType LINE = null;
    public static final ChartType PIE = null;
    public static final ChartType SCATTER = null;
    public static final ChartType STATISTICS = null;
    public static final ChartType UNKNOWN = null;
    public static final ChartType WORD_CLOUD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<Map<String, ChartType>> f212336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ChartType[] f212337b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f212338c = null;
    private final int chartHeightPxInList;
    private final int loadingRes;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public ChartType() {
        throw null;
    }

    public static EnumEntries<ChartType> getEntries() {
        return f212338c;
    }

    static {
        ChartType r100 = new ChartType("COLUMN", 0, "column", 0, 0, 6, null);
        COLUMN = r100;
        ChartType r101 = new ChartType(CJPayDiscountTextUtils.CJ_PAY_STRIKE_THROUGH_TEXT_STYLE, 1, "line", 0, 0, 6, null);
        LINE = r101;
        ChartType r102 = new ChartType("COMBO", 2, "combo", 0, 0, 6, null);
        COMBO = r102;
        ChartType r103 = new ChartType("BAR", 3, "bar", 0, 0, 6, null);
        BAR = r103;
        ChartType r104 = new ChartType("SCATTER", 4, "scatter", 0, 0, 6, null);
        SCATTER = r104;
        ChartType r105 = new ChartType("PIE", 5, "pie", 0, 0, 6, null);
        PIE = r105;
        ChartType r106 = new ChartType("STATISTICS", 6, "statistics", 0, LarkContext.getApplication().getResources().getDimensionPixelSize(R.dimen.bitable_homepage_chart_height_statistic), 2, null);
        STATISTICS = r106;
        ChartType r107 = new ChartType("WORD_CLOUD", 7, "wordCloud", 0, 0, 6, null);
        WORD_CLOUD = r107;
        ChartType r108 = new ChartType("FUNNEL", 8, "funnel", 0, 0, 6, null);
        FUNNEL = r108;
        ChartType r109 = new ChartType("UNKNOWN", 9, "unknown", 0, 0, 6, null);
        UNKNOWN = r109;
        ChartType[] r110 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        f212337b = r110;
        f212338c = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
        f212336a = LazyKt.lazy(ChartType$Companion$chartTypeByValue$2.INSTANCE);
    }

    public static ChartType[] values() {
        return (ChartType[]) f212337b.clone();
    }

    public static final /* synthetic */ Lazy access$getChartTypeByValue$delegate$cp() {
        return f212336a;
    }

    public final int calculateHeightPx() {
        return this.chartHeightPxInList;
    }

    public final int getLoadingRes() {
        return this.loadingRes;
    }

    public final String getValue() {
        return this.value;
    }

    public static ChartType valueOf(String r100) {
        return (ChartType) r27.a.a(ChartType.class, r100);
    }

    public ChartType(String r100, int r101, String r102, int r103, int r104, int r105, DefaultConstructorMarker r106) {
        if ((r105 & 2) == 0) goto L6;
        r103 = R.drawable.bitable_homepage_chart_loading;
    L6:
        if ((r105 & 4) == 0) goto L8;
        r104 = LarkContext.getApplication().getResources().getDimensionPixelSize(R.dimen.bitable_homepage_chart_height_default);
    L8:
        super(r100, r101);
        this.value = r102;
        this.loadingRes = r103;
        this.chartHeightPxInList = r104;
    }
}
