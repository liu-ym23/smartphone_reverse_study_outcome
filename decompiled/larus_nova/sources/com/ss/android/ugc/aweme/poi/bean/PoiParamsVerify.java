package com.ss.android.ugc.aweme.poi.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiParamsVerify;", "", "", "switch", "I", "getSwitch", "()I", "", "downloadUrl", "Ljava/lang/String;", "getDownloadUrl", "()Ljava/lang/String;", "version", "getVersion", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiParamsVerify {

    @SerializedName("download_url")
    private final String downloadUrl;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f121switch;

    @SerializedName("version")
    private final String version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiParamsVerify) == true) goto L8;
        return false;
    L8:
        PoiParamsVerify r101 = (PoiParamsVerify) r100;
        if (this.f121switch == r101.f121switch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downloadUrl, r101.downloadUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f121switch * 31;
        String r101 = this.downloadUrl;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.version;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiParamsVerify(switch=" + this.f121switch + ", downloadUrl=" + this.downloadUrl + ", version=" + this.version + ')';
    }

    public PoiParamsVerify() {
        this.f121switch = 0;
        this.downloadUrl = "";
        this.version = "";
    }
}
