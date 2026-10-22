package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingSummaryRepo extends MviRepository<c, a, d> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmRecordingRepo f435312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f435314l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f435315m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final c a() {
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r100 = this.f435313k.getFeatureService();
        int r101 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.f433800a;
        Intrinsics.checkNotNullParameter(r100, "featureService");
        boolean r102 = !r100.h(MmOfficeSdkFeature.RecordingNoAiNotes);
        Intrinsics.checkNotNullParameter(r100, "featureService");
        boolean r103 = r100.h(MmOfficeSdkFeature.RecordAiLayout);
        boolean r104 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a(r100);
        Intrinsics.checkNotNullParameter(r100, "featureService");
        if (r100.h(MmOfficeSdkFeature.RecordingHideSwitchTab) == true) goto L7;
        if (r104 == true) goto L7;
        boolean r105 = false;
    L9:
        if (r102 == false) goto L12;
        if (r103 == false) goto L12;
        boolean r106 = true;
    L13:
        if (r102 == false) goto L17;
        if (r105 == true) goto L17;
        if (r103 == false) goto L17;
        boolean r107 = true;
    L18:
        if (r102 == false) goto L21;
        if (r103 == false) goto L21;
        MmSummaryViewType r108 = MmSummaryViewType.FishBone;
    L23:
        return new c(r102, r106, r107, r108, 8176);
    L21:
        r108 = MmSummaryViewType.Markdown;
    L17:
        r107 = false;
    L12:
        r106 = false;
    L7:
        r105 = true;
        goto L9
    }

    public final a l() {
        return (a) this.f435315m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f435314l;
    }

    public MmRecordingSummaryRepo(MmRecordingRepo r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingRepo");
        Intrinsics.checkNotNullParameter(r101, "mmUccApi");
        this.f435312j = r100;
        this.f435313k = r101;
        this.f435314l = "MmSummaryRepo_" + hashCode();
        this.f435315m = LazyKt.lazy(new MmRecordingSummaryRepo$opt$2(this));
    }
}
