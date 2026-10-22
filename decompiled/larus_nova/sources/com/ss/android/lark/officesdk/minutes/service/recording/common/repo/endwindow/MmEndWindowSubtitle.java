package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowSubtitle;", "Ljava/io/Serializable;", "hasQuota", "", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;", "content", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowSubtitleItem;", "Lkotlin/collections/ArrayList;", "<init>", "(ZLcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;Ljava/util/ArrayList;)V", "getHasQuota", "()Z", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;", "getContent", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmEndWindowSubtitle implements Serializable {
    private final ArrayList<MmEndWindowSubtitleItem> content;
    private final boolean hasQuota;
    private final MmEndWindowUnavailableReason unavailableReason;

    public MmEndWindowSubtitle() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmEndWindowSubtitle copy$default(MmEndWindowSubtitle r100, boolean r101, MmEndWindowUnavailableReason r102, ArrayList r103, int r104, Object r105) {
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

    public final ArrayList<MmEndWindowSubtitleItem> component3() {
        return this.content;
    }

    public final MmEndWindowSubtitle copy(boolean r100, MmEndWindowUnavailableReason r101, ArrayList<MmEndWindowSubtitleItem> r102) {
        Intrinsics.checkNotNullParameter(r101, "unavailableReason");
        Intrinsics.checkNotNullParameter(r102, "content");
        return new MmEndWindowSubtitle(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmEndWindowSubtitle) == true) goto L8;
        return false;
    L8:
        MmEndWindowSubtitle r101 = (MmEndWindowSubtitle) r100;
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
        return "MmEndWindowSubtitle(hasQuota=" + this.hasQuota + ", unavailableReason=" + this.unavailableReason + ", content=" + this.content + ')';
    }

    public final ArrayList<MmEndWindowSubtitleItem> getContent() {
        return this.content;
    }

    public final boolean getHasQuota() {
        return this.hasQuota;
    }

    public final MmEndWindowUnavailableReason getUnavailableReason() {
        return this.unavailableReason;
    }

    public MmEndWindowSubtitle(boolean r100, MmEndWindowUnavailableReason r101, ArrayList<MmEndWindowSubtitleItem> r102) {
        Intrinsics.checkNotNullParameter(r101, "unavailableReason");
        Intrinsics.checkNotNullParameter(r102, "content");
        this.hasQuota = r100;
        this.unavailableReason = r101;
        this.content = r102;
    }

    public /* synthetic */ MmEndWindowSubtitle(boolean r100, MmEndWindowUnavailableReason r101, ArrayList r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new MmEndWindowUnavailableReason(0, null, 3, null);
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new ArrayList();
    L11:
        this(r100, r101, r102);
    }
}
