package com.bytedance.awemeopen.domain.series;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/n;", "", "", "seriesId", "J", "getSeriesId", "()J", "setSeriesId", "(J)V", "unitPrice", "getUnitPrice", "setUnitPrice", "", "segmentUnlock", "Z", "getSegmentUnlock", "()Z", "setSegmentUnlock", "(Z)V", "", "Lcom/bytedance/awemeopen/domain/series/k;", "packagePrice", "Ljava/util/List;", "getPackagePrice", "()Ljava/util/List;", "setPackagePrice", "(Ljava/util/List;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class n implements Cloneable {

    @SerializedName("package_price")
    private List<k> packagePrice;

    @SerializedName("segment_unlock")
    private boolean segmentUnlock;

    @SerializedName("series_id")
    private long seriesId;

    @SerializedName("unit_price")
    private long unitPrice;

    public n() {
    }

    public final Object clone() {
        return super.clone();
    }
}
