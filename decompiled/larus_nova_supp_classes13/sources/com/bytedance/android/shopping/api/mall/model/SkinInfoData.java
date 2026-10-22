package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinInfoData;", "", "config", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfig;", "configHashVal", "", "(Lcom/bytedance/android/shopping/api/mall/model/SkinConfig;Ljava/lang/String;)V", "getConfig", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfig;", "getConfigHashVal", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkinInfoData {

    @SerializedName("config")
    private final SkinConfig config;

    @SerializedName("configHashVal")
    private final String configHashVal;

    /* JADX WARN: Multi-variable type inference failed */
    public SkinInfoData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SkinInfoData copy$default(SkinInfoData r0, SkinConfig r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.config;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.configHashVal;
    L9:
        return r0.copy(r1, r2);
    }

    public final SkinConfig component1() {
        return this.config;
    }

    public final String component2() {
        return this.configHashVal;
    }

    public final SkinInfoData copy(SkinConfig r2, String r3) {
        return new SkinInfoData(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SkinInfoData) == false) goto L10;
        SkinInfoData r4 = (SkinInfoData) r3;
        if (Intrinsics.areEqual(this.config, r4.config) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.configHashVal, r4.configHashVal) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        SkinConfig r0 = this.config;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.configHashVal;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SkinInfoData(config=" + this.config + ", configHashVal=" + this.configHashVal + ")";
    }

    public final SkinConfig getConfig() {
        return this.config;
    }

    public final String getConfigHashVal() {
        return this.configHashVal;
    }

    public SkinInfoData(SkinConfig r1, String r2) {
        this.config = r1;
        this.configHashVal = r2;
    }

    public /* synthetic */ SkinInfoData(SkinConfig r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
