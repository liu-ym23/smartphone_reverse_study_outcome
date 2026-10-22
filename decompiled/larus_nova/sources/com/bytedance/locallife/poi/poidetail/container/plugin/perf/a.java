package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/perf/a;", "", "", "", "Lcom/bytedance/locallife/poi/poidetail/container/plugin/perf/d;", "cardSizeChangeRecord", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "", "fmpTime", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "f", "(Ljava/lang/Long;)V", "fmpStartTime", "b", "e", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("card_detail_log")
    private final Map<String, d> cardSizeChangeRecord;

    @SerializedName("fmp_start_time")
    private Long fmpStartTime;

    @SerializedName("fmp_time")
    private Long fmpTime;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.cardSizeChangeRecord, r101.cardSizeChangeRecord) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fmpTime, r101.fmpTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fmpStartTime, r101.fmpStartTime) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.cardSizeChangeRecord.hashCode() * 31;
        Long r101 = this.fmpTime;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.fmpStartTime;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiAllCardDetailLogRecord(cardSizeChangeRecord=" + this.cardSizeChangeRecord + ", fmpTime=" + this.fmpTime + ", fmpStartTime=" + this.fmpStartTime + ')';
    }

    public final void d() {
        Iterator<T> r100 = this.cardSizeChangeRecord.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((d) r100.next()).a(this.fmpTime);
        goto L4
    }

    public final Map<String, d> a() {
        return this.cardSizeChangeRecord;
    }

    public final Long b() {
        return this.fmpStartTime;
    }

    public final Long c() {
        return this.fmpTime;
    }

    public a(Object r100) {
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        Intrinsics.checkNotNullParameter(r101, "cardSizeChangeRecord");
        this.cardSizeChangeRecord = r101;
        this.fmpTime = null;
        this.fmpStartTime = null;
    }

    public final void e(Long r100) {
        this.fmpStartTime = r100;
    }

    public final void f(Long r100) {
        this.fmpTime = r100;
    }
}
