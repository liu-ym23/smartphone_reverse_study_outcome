package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingLocationRepo extends MviRepository {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f434980s = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmRecordingRepo f434981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434982k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f434983l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f434984m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f434985n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f434986o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile String f434987p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile String f434988q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f434989r;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final Object a() {
        return new d(0);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a m() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a) this.f434989r.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f434983l;
    }

    public static final MmRecordingMapSaveHelper l(MmRecordingLocationRepo r100) {
        return (MmRecordingMapSaveHelper) r100.f434985n.getValue();
    }

    public MmRecordingLocationRepo(MmRecordingRepo r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingRepo");
        Intrinsics.checkNotNullParameter(r101, "mmUccApi");
        this.f434981j = r100;
        this.f434982k = r101;
        this.f434983l = "MmRecordingLocationRepo";
        this.f434984m = LazyKt.lazy(new MmRecordingLocationRepo$locationHelper$2(this));
        this.f434985n = LazyKt.lazy(new MmRecordingLocationRepo$mapHelper$2(this));
        this.f434987p = "";
        this.f434988q = "";
        this.f434989r = LazyKt.lazy(new MmRecordingLocationRepo$opt$2(this));
    }
}
