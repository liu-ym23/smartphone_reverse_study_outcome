package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.setting;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJD\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/mallSessionmonitor/setting/DeliveryParamsExtraRule;", "Ljava/io/Serializable;", "addParams", "", "", "paramsInconsistentReport", "", "disableDefaultParamsReport", "addTimestamp", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAddParams", "()Ljava/util/List;", "getAddTimestamp", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDisableDefaultParamsReport", "getParamsInconsistentReport", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/android/shopping/api/mall/common/homepage/mallSessionmonitor/setting/DeliveryParamsExtraRule;", "equals", "other", "", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeliveryParamsExtraRule implements Serializable {

    @SerializedName("add_params")
    private final List<String> addParams;

    @SerializedName("add_timestamp")
    private final Boolean addTimestamp;

    @SerializedName("disable_default_params_report")
    private final Boolean disableDefaultParamsReport;

    @SerializedName("params_inconsistent_report")
    private final Boolean paramsInconsistentReport;

    public DeliveryParamsExtraRule() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeliveryParamsExtraRule copy$default(DeliveryParamsExtraRule r0, List r1, Boolean r2, Boolean r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.addParams;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.paramsInconsistentReport;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.disableDefaultParamsReport;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.addTimestamp;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final List<String> component1() {
        return this.addParams;
    }

    public final Boolean component2() {
        return this.paramsInconsistentReport;
    }

    public final Boolean component3() {
        return this.disableDefaultParamsReport;
    }

    public final Boolean component4() {
        return this.addTimestamp;
    }

    public final DeliveryParamsExtraRule copy(List<String> r2, Boolean r3, Boolean r4, Boolean r5) {
        return new DeliveryParamsExtraRule(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof DeliveryParamsExtraRule) == false) goto L14;
        DeliveryParamsExtraRule r4 = (DeliveryParamsExtraRule) r3;
        if (Intrinsics.areEqual(this.addParams, r4.addParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.paramsInconsistentReport, r4.paramsInconsistentReport) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.disableDefaultParamsReport, r4.disableDefaultParamsReport) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.addTimestamp, r4.addTimestamp) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<String> r0 = this.addParams;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.paramsInconsistentReport;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.disableDefaultParamsReport;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.addTimestamp;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "DeliveryParamsExtraRule(addParams=" + this.addParams + ", paramsInconsistentReport=" + this.paramsInconsistentReport + ", disableDefaultParamsReport=" + this.disableDefaultParamsReport + ", addTimestamp=" + this.addTimestamp + ")";
    }

    public final List<String> getAddParams() {
        return this.addParams;
    }

    public final Boolean getAddTimestamp() {
        return this.addTimestamp;
    }

    public final Boolean getDisableDefaultParamsReport() {
        return this.disableDefaultParamsReport;
    }

    public final Boolean getParamsInconsistentReport() {
        return this.paramsInconsistentReport;
    }

    public DeliveryParamsExtraRule(List<String> r1, Boolean r2, Boolean r3, Boolean r4) {
        this.addParams = r1;
        this.paramsInconsistentReport = r2;
        this.disableDefaultParamsReport = r3;
        this.addTimestamp = r4;
    }

    public /* synthetic */ DeliveryParamsExtraRule(List r2, Boolean r3, Boolean r4, Boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
