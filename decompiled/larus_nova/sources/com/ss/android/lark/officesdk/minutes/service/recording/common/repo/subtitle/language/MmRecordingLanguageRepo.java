package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingLanguageRepo extends MviRepository<f, a, g> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmRecordingSession f435267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f435269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f435270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f435271n;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final f a() {
        return new f(0);
    }

    public final a l() {
        return (a) this.f435271n.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f435270m;
    }

    public /* synthetic */ MmRecordingLanguageRepo(MmRecordingSession r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101) {
        this(r100, r101, AnonymousClass1.INSTANCE);
    }

    public MmRecordingLanguageRepo(MmRecordingSession r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "mmUccApi");
        Intrinsics.checkNotNullParameter(r102, "onManualSettingIntent");
        this.f435267j = r100;
        this.f435268k = r101;
        this.f435269l = r102;
        this.f435270m = "MmRecordingLanguageRepo";
        this.f435271n = LazyKt.lazy(new MmRecordingLanguageRepo$opt$2(this));
    }
}
