package com.bytedance.awemeopen.bizmodels.profile;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/profile/TrackerParams;", "Ljava/io/Serializable;", "iconType", "", "certType", "certificationNum", "(III)V", "getCertType", "()I", "getCertificationNum", "getIconType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TrackerParams implements Serializable {

    @SerializedName("cert_type")
    private final int certType;

    @SerializedName("certification_num")
    private final int certificationNum;

    @SerializedName("icon_type")
    private final int iconType;

    public TrackerParams() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ TrackerParams copy$default(TrackerParams r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.iconType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.certType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.certificationNum;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.iconType;
    }

    public final int component2() {
        return this.certType;
    }

    public final int component3() {
        return this.certificationNum;
    }

    public final TrackerParams copy(int r100, int r101, int r102) {
        return new TrackerParams(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TrackerParams) == true) goto L8;
        return false;
    L8:
        TrackerParams r101 = (TrackerParams) r100;
        if (this.iconType == r101.iconType) goto L12;
        return false;
    L12:
        if (this.certType == r101.certType) goto L15;
        return false;
    L15:
        if (this.certificationNum == r101.certificationNum) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.iconType * 31) + this.certType) * 31) + this.certificationNum;
    }

    public String toString() {
        return "TrackerParams(iconType=" + this.iconType + ", certType=" + this.certType + ", certificationNum=" + this.certificationNum + ')';
    }

    public final int getCertType() {
        return this.certType;
    }

    public final int getCertificationNum() {
        return this.certificationNum;
    }

    public final int getIconType() {
        return this.iconType;
    }

    public TrackerParams(int r100, int r101, int r102) {
        this.iconType = r100;
        this.certType = r101;
        this.certificationNum = r102;
    }

    public /* synthetic */ TrackerParams(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
