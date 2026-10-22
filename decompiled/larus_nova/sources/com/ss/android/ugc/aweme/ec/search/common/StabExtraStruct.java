package com.ss.android.ugc.aweme.ec.search.common;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/ec/search/common/StabExtraStruct;", "Ljava/io/Serializable;", "trafficIdentification", "", "nilInfoContext", "Lcom/ss/android/ugc/aweme/ec/search/common/NilInfoContextStruct;", "(Ljava/lang/String;Lcom/ss/android/ugc/aweme/ec/search/common/NilInfoContextStruct;)V", "getNilInfoContext", "()Lcom/ss/android/ugc/aweme/ec/search/common/NilInfoContextStruct;", "setNilInfoContext", "(Lcom/ss/android/ugc/aweme/ec/search/common/NilInfoContextStruct;)V", "getTrafficIdentification", "()Ljava/lang/String;", "setTrafficIdentification", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StabExtraStruct implements Serializable {

    @SerializedName("NilInfoContext")
    private NilInfoContextStruct nilInfoContext;

    @SerializedName("traffic_identification")
    private String trafficIdentification;

    /* JADX WARN: Multi-variable type inference failed */
    public StabExtraStruct() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ StabExtraStruct copy$default(StabExtraStruct r100, String r101, NilInfoContextStruct r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.trafficIdentification;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.nilInfoContext;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.trafficIdentification;
    }

    public final NilInfoContextStruct component2() {
        return this.nilInfoContext;
    }

    public final StabExtraStruct copy(String r100, NilInfoContextStruct r101) {
        return new StabExtraStruct(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StabExtraStruct) == false) goto L10;
        StabExtraStruct r101 = (StabExtraStruct) r100;
        if (Intrinsics.areEqual(this.trafficIdentification, r101.trafficIdentification) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nilInfoContext, r101.nilInfoContext) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.trafficIdentification;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        NilInfoContextStruct r104 = this.nilInfoContext;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "StabExtraStruct(trafficIdentification=" + this.trafficIdentification + ", nilInfoContext=" + this.nilInfoContext + ")";
    }

    public final NilInfoContextStruct getNilInfoContext() {
        return this.nilInfoContext;
    }

    public final String getTrafficIdentification() {
        return this.trafficIdentification;
    }

    public final void setNilInfoContext(NilInfoContextStruct r100) {
        this.nilInfoContext = r100;
    }

    public final void setTrafficIdentification(String r100) {
        this.trafficIdentification = r100;
    }

    public StabExtraStruct(String r100, NilInfoContextStruct r101) {
        this.trafficIdentification = r100;
        this.nilInfoContext = r101;
    }

    public /* synthetic */ StabExtraStruct(String r100, NilInfoContextStruct r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
