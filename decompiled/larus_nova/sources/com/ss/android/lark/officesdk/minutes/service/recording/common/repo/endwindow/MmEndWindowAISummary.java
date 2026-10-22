package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowAISummary;", "Ljava/io/Serializable;", "hasQuota", "", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;", "content", "", "<init>", "(ZLcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;Ljava/lang/String;)V", "getHasQuota", "()Z", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;", "getContent", "()Ljava/lang/String;", "toString", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmEndWindowAISummary implements Serializable {
    private final String content;
    private final boolean hasQuota;
    private final MmEndWindowUnavailableReason unavailableReason;

    public MmEndWindowAISummary() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ MmEndWindowAISummary copy$default(MmEndWindowAISummary r100, boolean r101, MmEndWindowUnavailableReason r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.hasQuota;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.unavailableReason;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.content;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.hasQuota;
    }

    public final MmEndWindowUnavailableReason component2() {
        return this.unavailableReason;
    }

    public final String component3() {
        return this.content;
    }

    public final MmEndWindowAISummary copy(boolean r100, MmEndWindowUnavailableReason r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "unavailableReason");
        Intrinsics.checkNotNullParameter(r102, "content");
        return new MmEndWindowAISummary(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmEndWindowAISummary) == true) goto L8;
        return false;
    L8:
        MmEndWindowAISummary r101 = (MmEndWindowAISummary) r100;
        if (this.hasQuota == r101.hasQuota) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.unavailableReason, r101.unavailableReason) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.hasQuota == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.unavailableReason.hashCode()) * 31) + this.content.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "MmEndWindowAISummary(hasQuota=" + this.hasQuota + ", unavailableReason=" + this.unavailableReason + ", content='" + this.content.length() + "')";
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getHasQuota() {
        return this.hasQuota;
    }

    public final MmEndWindowUnavailableReason getUnavailableReason() {
        return this.unavailableReason;
    }

    public MmEndWindowAISummary(boolean r100, MmEndWindowUnavailableReason r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "unavailableReason");
        Intrinsics.checkNotNullParameter(r102, "content");
        this.hasQuota = r100;
        this.unavailableReason = r101;
        this.content = r102;
    }

    public /* synthetic */ MmEndWindowAISummary(boolean r100, MmEndWindowUnavailableReason r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new MmEndWindowUnavailableReason(0, null, 3, null);
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
