package com.bytedance.bmf_mods.downloader.custom.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsBean;", "", "statusCode", "", "data", "Lcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsData;", "(ILcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsData;)V", "getData", "()Lcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsData;", "getStatusCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ArithmeticsBean {

    @SerializedName("data")
    private final ArithmeticsData data;

    @SerializedName("status_code")
    private final int statusCode;

    /* JADX WARN: Multi-variable type inference failed */
    public ArithmeticsBean() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ArithmeticsBean copy$default(ArithmeticsBean r100, int r101, ArithmeticsData r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.statusCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.data;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final ArithmeticsData component2() {
        return this.data;
    }

    public final ArithmeticsBean copy(int r100, ArithmeticsData r101) {
        return new ArithmeticsBean(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ArithmeticsBean) == true) goto L8;
        return false;
    L8:
        ArithmeticsBean r101 = (ArithmeticsBean) r100;
        if (this.statusCode == r101.statusCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.statusCode * 31;
        ArithmeticsData r101 = this.data;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ArithmeticsBean(statusCode=" + this.statusCode + ", data=" + this.data + ')';
    }

    public final ArithmeticsData getData() {
        return this.data;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public ArithmeticsBean(int r100, ArithmeticsData r101) {
        this.statusCode = r100;
        this.data = r101;
    }

    public /* synthetic */ ArithmeticsBean(int r100, ArithmeticsData r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
