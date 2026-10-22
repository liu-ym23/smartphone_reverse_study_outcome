package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAISummary;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowMetaInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowSubtitle;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmSummaryShareInfo;", "Ljava/io/Serializable;", "metaInfo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowMetaInfo;", "aiSummary", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowAISummary;", "subtitle", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowSubtitle;", "config", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowConfig;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowMetaInfo;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowAISummary;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowSubtitle;Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowConfig;)V", "getMetaInfo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowMetaInfo;", "getAiSummary", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowAISummary;", "getSubtitle", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowSubtitle;", "getConfig", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmSummaryShareInfo implements Serializable {
    private final MmEndWindowAISummary aiSummary;
    private final MmEndWindowConfig config;
    private final MmEndWindowMetaInfo metaInfo;
    private final MmEndWindowSubtitle subtitle;

    public static /* synthetic */ MmSummaryShareInfo copy$default(MmSummaryShareInfo r100, MmEndWindowMetaInfo r101, MmEndWindowAISummary r102, MmEndWindowSubtitle r103, MmEndWindowConfig r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.metaInfo;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.aiSummary;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.subtitle;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.config;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final MmEndWindowMetaInfo component1() {
        return this.metaInfo;
    }

    public final MmEndWindowAISummary component2() {
        return this.aiSummary;
    }

    public final MmEndWindowSubtitle component3() {
        return this.subtitle;
    }

    public final MmEndWindowConfig component4() {
        return this.config;
    }

    public final MmSummaryShareInfo copy(MmEndWindowMetaInfo r100, MmEndWindowAISummary r101, MmEndWindowSubtitle r102, MmEndWindowConfig r103) {
        Intrinsics.checkNotNullParameter(r100, "metaInfo");
        Intrinsics.checkNotNullParameter(r101, "aiSummary");
        Intrinsics.checkNotNullParameter(r102, "subtitle");
        Intrinsics.checkNotNullParameter(r103, "config");
        return new MmSummaryShareInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmSummaryShareInfo) == true) goto L8;
        return false;
    L8:
        MmSummaryShareInfo r101 = (MmSummaryShareInfo) r100;
        if (Intrinsics.areEqual(this.metaInfo, r101.metaInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aiSummary, r101.aiSummary) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.metaInfo.hashCode() * 31) + this.aiSummary.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.config.hashCode();
    }

    public String toString() {
        return "MmSummaryShareInfo(metaInfo=" + this.metaInfo + ", aiSummary=" + this.aiSummary + ", subtitle=" + this.subtitle + ", config=" + this.config + ')';
    }

    public final MmEndWindowAISummary getAiSummary() {
        return this.aiSummary;
    }

    public final MmEndWindowConfig getConfig() {
        return this.config;
    }

    public final MmEndWindowMetaInfo getMetaInfo() {
        return this.metaInfo;
    }

    public final MmEndWindowSubtitle getSubtitle() {
        return this.subtitle;
    }

    public MmSummaryShareInfo(MmEndWindowMetaInfo r100, MmEndWindowAISummary r101, MmEndWindowSubtitle r102, MmEndWindowConfig r103) {
        Intrinsics.checkNotNullParameter(r100, "metaInfo");
        Intrinsics.checkNotNullParameter(r101, "aiSummary");
        Intrinsics.checkNotNullParameter(r102, "subtitle");
        Intrinsics.checkNotNullParameter(r103, "config");
        this.metaInfo = r100;
        this.aiSummary = r101;
        this.subtitle = r102;
        this.config = r103;
    }
}
