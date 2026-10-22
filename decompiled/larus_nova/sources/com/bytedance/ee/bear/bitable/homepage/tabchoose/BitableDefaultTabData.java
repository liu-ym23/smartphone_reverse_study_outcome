package com.bytedance.ee.bear.bitable.homepage.tabchoose;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/tabchoose/BitableDefaultTabData;", "Ljava/io/Serializable;", "default", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getDefault", "()Ljava/lang/String;", "setDefault", "(Ljava/lang/String;)V", "getExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ee/bear/bitable/homepage/tabchoose/BitableDefaultTabData;", "equals", "", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDefaultTabData implements Serializable {

    /* JADX INFO: renamed from: default, reason: not valid java name */
    @SerializedName("default")
    private String f99default;

    @SerializedName("expire_time")
    private final Long expireTime;

    public static /* synthetic */ BitableDefaultTabData copy$default(BitableDefaultTabData r100, String r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f99default;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.expireTime;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.f99default;
    }

    public final Long component2() {
        return this.expireTime;
    }

    public final BitableDefaultTabData copy(String r100, Long r101) {
        return new BitableDefaultTabData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitableDefaultTabData) == true) goto L8;
        return false;
    L8:
        BitableDefaultTabData r101 = (BitableDefaultTabData) r100;
        if (Intrinsics.areEqual(this.f99default, r101.f99default) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expireTime, r101.expireTime) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.f99default;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.expireTime;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BitableDefaultTabData(default=" + this.f99default + ", expireTime=" + this.expireTime + ')';
    }

    public final String getDefault() {
        return this.f99default;
    }

    public final Long getExpireTime() {
        return this.expireTime;
    }

    public final void setDefault(String r100) {
        this.f99default = r100;
    }

    public BitableDefaultTabData(String r100, Long r101) {
        this.f99default = r100;
        this.expireTime = r101;
    }
}
