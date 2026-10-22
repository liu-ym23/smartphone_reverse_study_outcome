package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BannerMeta;", "Ljava/io/Serializable;", "bannerType", "", "bannerUrl", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getBannerType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBannerUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BannerMeta;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4BannerMeta implements Serializable {

    @SerializedName("banner_type")
    private final Integer bannerType;

    @SerializedName("banner_url")
    private final String bannerUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4BannerMeta() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4BannerMeta copy$default(AnchorV4BannerMeta r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.bannerType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.bannerUrl;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.bannerType;
    }

    public final String component2() {
        return this.bannerUrl;
    }

    public final AnchorV4BannerMeta copy(Integer r2, String r3) {
        return new AnchorV4BannerMeta(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4BannerMeta) == false) goto L10;
        AnchorV4BannerMeta r4 = (AnchorV4BannerMeta) r3;
        if (Intrinsics.areEqual(this.bannerType, r4.bannerType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bannerUrl, r4.bannerUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.bannerType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.bannerUrl;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4BannerMeta(bannerType=" + this.bannerType + ", bannerUrl=" + this.bannerUrl + ")";
    }

    public final Integer getBannerType() {
        return this.bannerType;
    }

    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    public AnchorV4BannerMeta(Integer r1, String r2) {
        this.bannerType = r1;
        this.bannerUrl = r2;
    }

    public /* synthetic */ AnchorV4BannerMeta(Integer r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
