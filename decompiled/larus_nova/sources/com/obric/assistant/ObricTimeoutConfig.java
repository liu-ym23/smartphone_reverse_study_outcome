package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/ObricTimeoutConfig;", "", "obricOAutoTimeout", "", "obricComplexTaskTimeout", "obricSimpleTaskTimeout", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getObricOAutoTimeout", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getObricComplexTaskTimeout", "getObricSimpleTaskTimeout", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/obric/assistant/ObricTimeoutConfig;", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTimeoutConfig {

    @SerializedName("obric_complex_task_timeout")
    private final Long obricComplexTaskTimeout;

    @SerializedName("obric_o_auto_timeout")
    private final Long obricOAutoTimeout;

    @SerializedName("obric_simple_task_timeout")
    private final Long obricSimpleTaskTimeout;

    public ObricTimeoutConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ObricTimeoutConfig copy$default(ObricTimeoutConfig r100, Long r101, Long r102, Long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.obricOAutoTimeout;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.obricComplexTaskTimeout;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.obricSimpleTaskTimeout;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Long component1() {
        return this.obricOAutoTimeout;
    }

    public final Long component2() {
        return this.obricComplexTaskTimeout;
    }

    public final Long component3() {
        return this.obricSimpleTaskTimeout;
    }

    public final ObricTimeoutConfig copy(Long r100, Long r101, Long r102) {
        return new ObricTimeoutConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricTimeoutConfig) == true) goto L8;
        return false;
    L8:
        ObricTimeoutConfig r101 = (ObricTimeoutConfig) r100;
        if (Intrinsics.areEqual(this.obricOAutoTimeout, r101.obricOAutoTimeout) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.obricComplexTaskTimeout, r101.obricComplexTaskTimeout) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.obricSimpleTaskTimeout, r101.obricSimpleTaskTimeout) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r100 = this.obricOAutoTimeout;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.obricComplexTaskTimeout;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.obricSimpleTaskTimeout;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricTimeoutConfig(obricOAutoTimeout=" + this.obricOAutoTimeout + ", obricComplexTaskTimeout=" + this.obricComplexTaskTimeout + ", obricSimpleTaskTimeout=" + this.obricSimpleTaskTimeout + ')';
    }

    public final Long getObricComplexTaskTimeout() {
        return this.obricComplexTaskTimeout;
    }

    public final Long getObricOAutoTimeout() {
        return this.obricOAutoTimeout;
    }

    public final Long getObricSimpleTaskTimeout() {
        return this.obricSimpleTaskTimeout;
    }

    public ObricTimeoutConfig(Long r100, Long r101, Long r102) {
        this.obricOAutoTimeout = r100;
        this.obricComplexTaskTimeout = r101;
        this.obricSimpleTaskTimeout = r102;
    }

    public /* synthetic */ ObricTimeoutConfig(Long r100, Long r101, Long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 900000L;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 1200000L;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 120000L;
    L11:
        this(r100, r101, r102);
    }
}
