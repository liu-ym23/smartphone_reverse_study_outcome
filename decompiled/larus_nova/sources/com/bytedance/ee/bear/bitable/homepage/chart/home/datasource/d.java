package com.bytedance.ee.bear.bitable.homepage.chart.home.datasource;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/datasource/ChartListResponse;", "Lcom/bytedance/ee/bear/bitable/homepage/chart/base/ChartBaseResponse;", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/datasource/ChartListResponseData;", "<init>", "()V", "generateTimestamp", "", "getGenerateTimestamp", "()Ljava/lang/Long;", "setGenerateTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d extends js4.a<e> {

    @SerializedName("generateTimestamp")
    private volatile Long generateTimestamp;

    public d() {
    }

    public final Long h() {
        return this.generateTimestamp;
    }

    public final void i(Long r100) {
        this.generateTimestamp = r100;
    }
}
