package com.larus.platform.api;

import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006\""}, d2 = {"Lcom/larus/platform/api/SocialIMData;", "Ljava/io/Serializable;", UserInfo.UPDATE_TIME, "", SocialConstants.PARAM_APP_DESC, "", "redBadge", "", "redBadgeWithoutDoubao", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getUpdateTime", "()Ljava/lang/Long;", "setUpdateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDesc", "()Ljava/lang/String;", "getRedBadge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRedBadgeWithoutDoubao", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/platform/api/SocialIMData;", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialIMData implements Serializable {
    private final String desc;
    private final Integer redBadge;
    private final Integer redBadgeWithoutDoubao;
    private Long updateTime;

    public SocialIMData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SocialIMData copy$default(SocialIMData r100, Long r101, String r102, Integer r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.updateTime;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.desc;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.redBadge;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.redBadgeWithoutDoubao;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.updateTime;
    }

    public final String component2() {
        return this.desc;
    }

    public final Integer component3() {
        return this.redBadge;
    }

    public final Integer component4() {
        return this.redBadgeWithoutDoubao;
    }

    public final SocialIMData copy(Long r100, String r101, Integer r102, Integer r103) {
        return new SocialIMData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SocialIMData) == true) goto L8;
        return false;
    L8:
        SocialIMData r101 = (SocialIMData) r100;
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.redBadge, r101.redBadge) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.redBadgeWithoutDoubao, r101.redBadgeWithoutDoubao) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Long r100 = this.updateTime;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.desc;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.redBadge;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.redBadgeWithoutDoubao;
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

    public String toString() {
        return "SocialIMData(updateTime=" + this.updateTime + ", desc=" + this.desc + ", redBadge=" + this.redBadge + ", redBadgeWithoutDoubao=" + this.redBadgeWithoutDoubao + ')';
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Integer getRedBadge() {
        return this.redBadge;
    }

    public final Integer getRedBadgeWithoutDoubao() {
        return this.redBadgeWithoutDoubao;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(Long r100) {
        this.updateTime = r100;
    }

    public SocialIMData(Long r100, String r101, Integer r102, Integer r103) {
        this.updateTime = r100;
        this.desc = r101;
        this.redBadge = r102;
        this.redBadgeWithoutDoubao = r103;
    }

    public /* synthetic */ SocialIMData(Long r100, String r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
