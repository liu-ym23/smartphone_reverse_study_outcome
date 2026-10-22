package com.bytedance.ee.bear.bitable.homepage.chart.entity;

import com.bytedance.ee.bear.bitable.homepage.chart.ChartType;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rs4.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/ChartEntity;", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/BaseChartEntity;", "<init>", "()V", "baseName", "", "getBaseName", "()Ljava/lang/String;", "setBaseName", "(Ljava/lang/String;)V", "baseUrl", "getBaseUrl", "setBaseUrl", "chartName", "getChartName", "setChartName", "chartType", "getChartType", "setChartType", "chartData", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageChartData;", "getChartData", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageChartData;", "setChartData", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomepageChartData;)V", "hasExposed", "", "getHasExposed", "()Z", "setHasExposed", "(Z)V", "chartTypeEnum", "Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartType;", "getChartTypeEnum", "()Lcom/bytedance/ee/bear/bitable/homepage/chart/ChartType;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChartEntity extends BaseChartEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile transient d f212474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile transient boolean f212475b;

    @SerializedName("base_name")
    private String baseName;

    @SerializedName("dashboard_url")
    private String baseUrl;

    @SerializedName("name")
    private String chartName;

    @SerializedName("type")
    private String chartType;

    public final ChartType getChartTypeEnum() {
        ChartType.a r100 = ChartType.Companion;
        String r101 = this.chartType;
        ChartType r102 = ChartType.UNKNOWN;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "default");
        ChartType r103 = (ChartType) ((Map) ChartType.access$getChartTypeByValue$delegate$cp().getValue()).get(r101);
        if (r103 != null) goto L6;
        return r102;
    L6:
        return r103;
    }

    public ChartEntity() {
    }

    public final String getBaseName() {
        return this.baseName;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final d getChartData() {
        return this.f212474a;
    }

    public final String getChartName() {
        return this.chartName;
    }

    public final String getChartType() {
        return this.chartType;
    }

    public final boolean getHasExposed() {
        return this.f212475b;
    }

    public final void setBaseName(String r100) {
        this.baseName = r100;
    }

    public final void setBaseUrl(String r100) {
        this.baseUrl = r100;
    }

    public final void setChartData(d r100) {
        this.f212474a = r100;
    }

    public final void setChartName(String r100) {
        this.chartName = r100;
    }

    public final void setChartType(String r100) {
        this.chartType = r100;
    }

    public final void setHasExposed(boolean r100) {
        this.f212475b = r100;
    }
}
