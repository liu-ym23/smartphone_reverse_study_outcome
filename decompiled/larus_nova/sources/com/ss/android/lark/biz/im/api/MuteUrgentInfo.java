package com.ss.android.lark.biz.im.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/MuteUrgentInfo;", "Ljava/io/Serializable;", "rankTime", "", "displayTime", "urgentContent", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getRankTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDisplayTime", "getUrgentContent", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/ss/android/lark/biz/im/api/MuteUrgentInfo;", "equals", "", "other", "", "hashCode", "", "toString", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MuteUrgentInfo implements Serializable {
    private final Long displayTime;
    private final Long rankTime;
    private final String urgentContent;

    public static /* synthetic */ MuteUrgentInfo copy$default(MuteUrgentInfo r100, Long r101, Long r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.rankTime;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.displayTime;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.urgentContent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Long component1() {
        return this.rankTime;
    }

    public final Long component2() {
        return this.displayTime;
    }

    public final String component3() {
        return this.urgentContent;
    }

    public final MuteUrgentInfo copy(Long r100, Long r101, String r102) {
        return new MuteUrgentInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MuteUrgentInfo) == true) goto L8;
        return false;
    L8:
        MuteUrgentInfo r101 = (MuteUrgentInfo) r100;
        if (Intrinsics.areEqual(this.rankTime, r101.rankTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayTime, r101.displayTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.urgentContent, r101.urgentContent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r100 = this.rankTime;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.displayTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.urgentContent;
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

    public String toString() {
        return "MuteUrgentInfo(rankTime=" + this.rankTime + ", displayTime=" + this.displayTime + ", urgentContent=" + this.urgentContent + ')';
    }

    public final Long getDisplayTime() {
        return this.displayTime;
    }

    public final Long getRankTime() {
        return this.rankTime;
    }

    public final String getUrgentContent() {
        return this.urgentContent;
    }

    public MuteUrgentInfo(Long r100, Long r101, String r102) {
        this.rankTime = r100;
        this.displayTime = r101;
        this.urgentContent = r102;
    }
}
