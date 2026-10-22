package com.bytedance.helios.api.consumer;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/helios/api/consumer/FrequencyExtra;", "", "frequencyNames", "", "", "frequencyLogs", "Lcom/bytedance/helios/api/consumer/FrequencyLog;", "(Ljava/util/Set;Ljava/util/Set;)V", "getFrequencyLogs", "()Ljava/util/Set;", "setFrequencyLogs", "(Ljava/util/Set;)V", "getFrequencyNames", "setFrequencyNames", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 1, 16})
public final class FrequencyExtra {
    private Set<FrequencyLog> frequencyLogs;
    private Set<String> frequencyNames;

    /* JADX WARN: Multi-variable type inference failed */
    public FrequencyExtra() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FrequencyExtra copy$default(FrequencyExtra r100, Set r101, Set r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.frequencyNames;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.frequencyLogs;
    L9:
        return r100.copy(r101, r102);
    }

    public final Set<String> component1() {
        return this.frequencyNames;
    }

    public final Set<FrequencyLog> component2() {
        return this.frequencyLogs;
    }

    public final FrequencyExtra copy(Set<String> r100, Set<FrequencyLog> r101) {
        return new FrequencyExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FrequencyExtra) == false) goto L10;
        FrequencyExtra r101 = (FrequencyExtra) r100;
        if (Intrinsics.areEqual(this.frequencyNames, r101.frequencyNames) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.frequencyLogs, r101.frequencyLogs) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Set<String> r100 = this.frequencyNames;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Set<FrequencyLog> r104 = this.frequencyLogs;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FrequencyExtra(frequencyNames=" + this.frequencyNames + ", frequencyLogs=" + this.frequencyLogs + ")";
    }

    public final Set<FrequencyLog> getFrequencyLogs() {
        return this.frequencyLogs;
    }

    public final Set<String> getFrequencyNames() {
        return this.frequencyNames;
    }

    public final void setFrequencyLogs(Set<FrequencyLog> r100) {
        this.frequencyLogs = r100;
    }

    public final void setFrequencyNames(Set<String> r100) {
        this.frequencyNames = r100;
    }

    public FrequencyExtra(Set<String> r100, Set<FrequencyLog> r101) {
        this.frequencyNames = r100;
        this.frequencyLogs = r101;
    }

    public /* synthetic */ FrequencyExtra(Set r100, Set r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new LinkedHashSet();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new LinkedHashSet();
    L8:
        this(r100, r101);
    }
}
