package com.bytedance.helios.api.consumer;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/helios/api/consumer/FrequencyLog;", "", "name", "", "callCount", "", "callThreshold", "apiCallCountMap", "", "(Ljava/lang/String;IILjava/util/Map;)V", "getApiCallCountMap", "()Ljava/util/Map;", "getCallCount", "()I", "getCallThreshold", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {1, 1, 16})
public final class FrequencyLog {
    private final Map<String, Integer> apiCallCountMap;
    private final int callCount;
    private final int callThreshold;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FrequencyLog copy$default(FrequencyLog r100, String r101, int r102, int r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.callCount;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.callThreshold;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.apiCallCountMap;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.callCount;
    }

    public final int component3() {
        return this.callThreshold;
    }

    public final Map<String, Integer> component4() {
        return this.apiCallCountMap;
    }

    public final FrequencyLog copy(String r100, int r101, int r102, Map<String, Integer> r103) {
        return new FrequencyLog(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FrequencyLog) == false) goto L14;
        FrequencyLog r101 = (FrequencyLog) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (this.callCount == r101.callCount) goto L10;
        return false;
    L10:
        if (this.callThreshold == r101.callThreshold) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.apiCallCountMap, r101.apiCallCountMap) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.callCount) * 31) + this.callThreshold) * 31;
        Map<String, Integer> r104 = this.apiCallCountMap;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FrequencyLog(name=" + this.name + ", callCount=" + this.callCount + ", callThreshold=" + this.callThreshold + ", apiCallCountMap=" + this.apiCallCountMap + ")";
    }

    public final Map<String, Integer> getApiCallCountMap() {
        return this.apiCallCountMap;
    }

    public final int getCallCount() {
        return this.callCount;
    }

    public final int getCallThreshold() {
        return this.callThreshold;
    }

    public final String getName() {
        return this.name;
    }

    public FrequencyLog(String r100, int r101, int r102, Map<String, Integer> r103) {
        this.name = r100;
        this.callCount = r101;
        this.callThreshold = r102;
        this.apiCallCountMap = r103;
    }

    public /* synthetic */ FrequencyLog(String r100, int r101, int r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = new LinkedHashMap();
    L5:
        this(r100, r101, r102, r103);
    }
}
