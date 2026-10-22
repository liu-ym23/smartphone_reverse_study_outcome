package com.larus.settings.provider.im;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J1\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/provider/im/FlowIMApmEventConfig;", "", "allowEventList", "", "", "businessAllowEventList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getAllowEventList", "()Ljava/util/List;", "getBusinessAllowEventList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowIMApmEventConfig {

    @SerializedName("allow_event_name_list")
    private final List<String> allowEventList;

    @SerializedName("business_allow_event_list")
    private final List<String> businessAllowEventList;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowIMApmEventConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FlowIMApmEventConfig copy$default(FlowIMApmEventConfig r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.allowEventList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.businessAllowEventList;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.allowEventList;
    }

    public final List<String> component2() {
        return this.businessAllowEventList;
    }

    public final FlowIMApmEventConfig copy(List<String> r100, List<String> r101) {
        return new FlowIMApmEventConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowIMApmEventConfig) == true) goto L8;
        return false;
    L8:
        FlowIMApmEventConfig r101 = (FlowIMApmEventConfig) r100;
        if (Intrinsics.areEqual(this.allowEventList, r101.allowEventList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.businessAllowEventList, r101.businessAllowEventList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.allowEventList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.businessAllowEventList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FlowIMApmEventConfig(allowEventList=" + this.allowEventList + ", businessAllowEventList=" + this.businessAllowEventList + ')';
    }

    public final List<String> getAllowEventList() {
        return this.allowEventList;
    }

    public final List<String> getBusinessAllowEventList() {
        return this.businessAllowEventList;
    }

    public FlowIMApmEventConfig(List<String> r100, List<String> r101) {
        this.allowEventList = r100;
        this.businessAllowEventList = r101;
    }

    public /* synthetic */ FlowIMApmEventConfig(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
