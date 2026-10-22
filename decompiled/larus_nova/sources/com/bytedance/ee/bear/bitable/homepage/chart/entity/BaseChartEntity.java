package com.bytedance.ee.bear.bitable.homepage.chart.entity;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B7\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0002\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/BaseChartEntity;", "Ljava/io/Serializable;", "<init>", "()V", "baseToken", "", "dashboardToken", "chartToken", "isTemplate", "", "status", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getBaseToken", "()Ljava/lang/String;", "setBaseToken", "(Ljava/lang/String;)V", "getDashboardToken", "setDashboardToken", "getChartToken", "setChartToken", "getStatus", "()I", "setStatus", "(I)V", "()Z", "setTemplate", "(Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseChartEntity implements Serializable {

    @SerializedName(BitableResourceData.KEY_BASE_TOKEN)
    private String baseToken;

    @SerializedName("token")
    private String chartToken;

    @SerializedName("dashboard_token")
    private String dashboardToken;

    @SerializedName("is_template")
    private boolean isTemplate;

    @SerializedName("status")
    private int status;

    public BaseChartEntity() {
    }

    public final String getBaseToken() {
        return this.baseToken;
    }

    public final String getChartToken() {
        return this.chartToken;
    }

    public final String getDashboardToken() {
        return this.dashboardToken;
    }

    public final int getStatus() {
        return this.status;
    }

    public final boolean isTemplate() {
        return this.isTemplate;
    }

    public final void setBaseToken(String r100) {
        this.baseToken = r100;
    }

    public final void setChartToken(String r100) {
        this.chartToken = r100;
    }

    public final void setDashboardToken(String r100) {
        this.dashboardToken = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTemplate(boolean r100) {
        this.isTemplate = r100;
    }

    public BaseChartEntity(String r100, String r101, String r102, boolean r103, int r104) {
        this();
        this.baseToken = r100;
        this.dashboardToken = r101;
        this.chartToken = r102;
        this.isTemplate = r103;
        this.status = r104;
    }
}
