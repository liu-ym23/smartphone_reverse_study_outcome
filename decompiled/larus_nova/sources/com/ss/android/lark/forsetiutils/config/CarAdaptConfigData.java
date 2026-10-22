package com.ss.android.lark.forsetiutils.config;

import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@AppConfig(key = "car_adapt_config")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigData;", "", DimLocationCheckUtil.XIAOMI, "Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigItem;", "xiaopeng", "nio", "<init>", "(Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigItem;Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigItem;Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigItem;)V", "getXiaomi", "()Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigItem;", "getXiaopeng", "getNio", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "forseti-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CarAdaptConfigData {

    @SerializedName("nio")
    private final a nio;

    @SerializedName(DimLocationCheckUtil.XIAOMI)
    private final a xiaomi;

    @SerializedName("xiaopeng")
    private final a xiaopeng;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CarAdaptConfigData) == true) goto L8;
        return false;
    L8:
        CarAdaptConfigData r101 = (CarAdaptConfigData) r100;
        if (Intrinsics.areEqual(this.xiaomi, r101.xiaomi) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.xiaopeng, r101.xiaopeng) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nio, r101.nio) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        a r100 = this.xiaomi;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        a r104 = this.xiaopeng;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.nio;
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

    public final String toString() {
        return "CarAdaptConfigData(xiaomi=" + this.xiaomi + ", xiaopeng=" + this.xiaopeng + ", nio=" + this.nio + ')';
    }

    public CarAdaptConfigData() {
        this.xiaomi = null;
        this.xiaopeng = null;
        this.nio = null;
    }

    public final a a() {
        return this.nio;
    }

    public final a b() {
        return this.xiaomi;
    }
}
