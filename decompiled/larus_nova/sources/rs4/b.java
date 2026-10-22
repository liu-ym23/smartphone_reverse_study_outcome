package rs4;

import com.bytedance.ee.bear.bitable.homepage.chart.entity.ChartEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageAddDashboard;", "", "<init>", "()V", "dashboardName", "", "getDashboardName", "()Ljava/lang/String;", "dashboardToken", "getDashboardToken", "dashboardUrl", "getDashboardUrl", "charts", "", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/ChartEntity;", "getCharts", "()Ljava/util/List;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("charts")
    private final List<ChartEntity> charts;

    @SerializedName("name")
    private final String dashboardName;

    @SerializedName("token")
    private final String dashboardToken;

    @SerializedName("dashboard_url")
    private final String dashboardUrl;

    public b() {
        this.dashboardToken = "";
        this.dashboardUrl = "";
        this.charts = CollectionsKt.emptyList();
    }

    public final List<ChartEntity> a() {
        return this.charts;
    }

    public final String b() {
        return this.dashboardName;
    }

    public final String c() {
        return this.dashboardToken;
    }

    public final String d() {
        return this.dashboardUrl;
    }
}
