package com.ss.android.ugc.aweme.poi.mob;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/mob/WriteActionRecord;", "", "currentVal", "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "Lcom/ss/android/ugc/aweme/poi/mob/TrackParamsSource;", "currentSource", "Lcom/ss/android/ugc/aweme/poi/mob/TrackParamsSource;", "getCurrentSource", "()Lcom/ss/android/ugc/aweme/poi/mob/TrackParamsSource;", "preValue", "b", "preSource", "getPreSource", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class WriteActionRecord {

    @SerializedName("currentSource")
    private final TrackParamsSource currentSource;

    @SerializedName("currentVal")
    private final Object currentVal;

    @SerializedName("preSource")
    private final TrackParamsSource preSource;

    @SerializedName("preValue")
    private final Object preValue;

    public WriteActionRecord() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WriteActionRecord) == true) goto L8;
        return false;
    L8:
        WriteActionRecord r101 = (WriteActionRecord) r100;
        if (Intrinsics.areEqual(this.currentVal, r101.currentVal) == true) goto L12;
        return false;
    L12:
        if (this.currentSource == r101.currentSource) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.preValue, r101.preValue) == true) goto L18;
        return false;
    L18:
        if (this.preSource == r101.preSource) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.currentVal;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        TrackParamsSource r104 = this.currentSource;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.preValue;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        TrackParamsSource r110 = this.preSource;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "WriteActionRecord(currentVal=" + this.currentVal + ", currentSource=" + this.currentSource + ", preValue=" + this.preValue + ", preSource=" + this.preSource + ')';
    }

    public final Object a() {
        return this.currentVal;
    }

    public final Object b() {
        return this.preValue;
    }

    public WriteActionRecord(Object r100, TrackParamsSource r101, Object r102, TrackParamsSource r103) {
        this.currentVal = r100;
        this.currentSource = r101;
        this.preValue = r102;
        this.preSource = r103;
    }
}
