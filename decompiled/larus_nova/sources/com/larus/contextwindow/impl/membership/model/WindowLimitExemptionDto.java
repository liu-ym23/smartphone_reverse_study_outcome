package com.larus.contextwindow.impl.membership.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;", "", "active", "", "endTime", "Lcom/google/gson/JsonElement;", "<init>", "(Ljava/lang/Boolean;Lcom/google/gson/JsonElement;)V", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEndTime", "()Lcom/google/gson/JsonElement;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Lcom/google/gson/JsonElement;)Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowLimitExemptionDto {

    @SerializedName("active")
    private final Boolean active;

    @SerializedName("end_time")
    private final JsonElement endTime;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowLimitExemptionDto() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WindowLimitExemptionDto copy$default(WindowLimitExemptionDto r100, Boolean r101, JsonElement r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.active;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.endTime;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.active;
    }

    public final JsonElement component2() {
        return this.endTime;
    }

    public final WindowLimitExemptionDto copy(Boolean r100, JsonElement r101) {
        return new WindowLimitExemptionDto(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WindowLimitExemptionDto) == true) goto L8;
        return false;
    L8:
        WindowLimitExemptionDto r101 = (WindowLimitExemptionDto) r100;
        if (Intrinsics.areEqual(this.active, r101.active) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.active;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonElement r104 = this.endTime;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "WindowLimitExemptionDto(active=" + this.active + ", endTime=" + this.endTime + ')';
    }

    public final Boolean getActive() {
        return this.active;
    }

    public final JsonElement getEndTime() {
        return this.endTime;
    }

    public WindowLimitExemptionDto(Boolean r100, JsonElement r101) {
        this.active = r100;
        this.endTime = r101;
    }

    public /* synthetic */ WindowLimitExemptionDto(Boolean r100, JsonElement r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
