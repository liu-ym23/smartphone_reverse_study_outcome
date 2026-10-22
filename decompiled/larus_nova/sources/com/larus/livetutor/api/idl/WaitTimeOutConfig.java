package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/livetutor/api/idl/WaitTimeOutConfig;", "Ljava/io/Serializable;", "waitStrategyType", "", "timeoutStrategyV2", "Lcom/larus/livetutor/api/idl/TimeoutStrategyV2;", "<init>", "(Ljava/lang/Integer;Lcom/larus/livetutor/api/idl/TimeoutStrategyV2;)V", "getWaitStrategyType", "()Ljava/lang/Integer;", "setWaitStrategyType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTimeoutStrategyV2", "()Lcom/larus/livetutor/api/idl/TimeoutStrategyV2;", "setTimeoutStrategyV2", "(Lcom/larus/livetutor/api/idl/TimeoutStrategyV2;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/larus/livetutor/api/idl/TimeoutStrategyV2;)Lcom/larus/livetutor/api/idl/WaitTimeOutConfig;", "equals", "", "other", "", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WaitTimeOutConfig implements Serializable {

    @SerializedName("timeout_strategy_v2")
    private TimeoutStrategyV2 timeoutStrategyV2;

    @SerializedName("wait_strategy_type")
    private Integer waitStrategyType;

    /* JADX WARN: Multi-variable type inference failed */
    public WaitTimeOutConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WaitTimeOutConfig copy$default(WaitTimeOutConfig r100, Integer r101, TimeoutStrategyV2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.waitStrategyType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.timeoutStrategyV2;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.waitStrategyType;
    }

    public final TimeoutStrategyV2 component2() {
        return this.timeoutStrategyV2;
    }

    public final WaitTimeOutConfig copy(Integer r100, TimeoutStrategyV2 r101) {
        return new WaitTimeOutConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WaitTimeOutConfig) == true) goto L8;
        return false;
    L8:
        WaitTimeOutConfig r101 = (WaitTimeOutConfig) r100;
        if (Intrinsics.areEqual(this.waitStrategyType, r101.waitStrategyType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timeoutStrategyV2, r101.timeoutStrategyV2) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.waitStrategyType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        TimeoutStrategyV2 r104 = this.timeoutStrategyV2;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "WaitTimeOutConfig(waitStrategyType=" + this.waitStrategyType + ", timeoutStrategyV2=" + this.timeoutStrategyV2 + ')';
    }

    public final TimeoutStrategyV2 getTimeoutStrategyV2() {
        return this.timeoutStrategyV2;
    }

    public final Integer getWaitStrategyType() {
        return this.waitStrategyType;
    }

    public final void setTimeoutStrategyV2(TimeoutStrategyV2 r100) {
        this.timeoutStrategyV2 = r100;
    }

    public final void setWaitStrategyType(Integer r100) {
        this.waitStrategyType = r100;
    }

    public WaitTimeOutConfig(Integer r100, TimeoutStrategyV2 r101) {
        this.waitStrategyType = r100;
        this.timeoutStrategyV2 = r101;
    }

    public /* synthetic */ WaitTimeOutConfig(Integer r100, TimeoutStrategyV2 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
