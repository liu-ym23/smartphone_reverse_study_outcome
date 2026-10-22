package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmAIInterpretationRepo extends MviRepository<d, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a, i> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f434728r = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f434729j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f434730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final KVRepo f434731l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<MmRecordingSource> f434732m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f434733n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MmAudioSaveType f434734o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Long f434735p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f434736q;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final d a() {
        return new d(0);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a n() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a) this.f434736q.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f434733n;
    }

    public final Object m(Continuation<? super Unit> r100) {
        lvb.a.e(this.f434733n, "[clearLocalStateForRecordingEnd]");
        MmAIInterpretationRepo$clearLocalStateForRecordingEnd$2 r101 = new MmAIInterpretationRepo$clearLocalStateForRecordingEnd$2(this, null);
        Object r102 = this.f433819e.b(r101, r100);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static final void l(MmAIInterpretationRepo r100, g r101) {
        r100.f434731l.putString("minutes_ai_interpretation_last_selected_language", r101.f434765a);
        lvb.a.e(r100.f434733n, "[saveSelectedLanguage] language=" + r101.f434765a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v6, types: [android.content.BroadcastReceiver, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAudioRouteDetector$registerVolumeReceiver$1] */
    public MmAIInterpretationRepo(RustMmAIInterpretationGateway r100, b r101, KVRepo r110, Function0 r111) {
        Intrinsics.checkNotNullParameter(r100, "gateway");
        Intrinsics.checkNotNullParameter(r101, "audioController");
        Intrinsics.checkNotNullParameter(r110, "kvRepo");
        Intrinsics.checkNotNullParameter(r111, "recordingSourceProvider");
        this.f434729j = r100;
        this.f434730k = r101;
        this.f434731l = r110;
        this.f434732m = r111;
        this.f434733n = "MmAIInterpretationRepo";
        this.f434734o = MmAudioSaveType.SAVE;
        this.f434736q = LazyKt.lazy(new MmAIInterpretationRepo$opt$2(this));
        lvb.a.e("MmAIInterpretationAudioController", "[start]");
        final q r102 = r101.f434743b;
        if (r102.f434794g != null) goto L36;
        ?? r103 = new MmAudioRouteDetector$registerVolumeReceiver$1(r102);
        r102.f434794g = r103;
        Context r112 = r102.f434791d;
        IntentFilter r113 = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L46;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L46:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L44;
        ReceiverRegisterCrashOptimizer.registerReceiver(r103, r113);
        goto L36
    L44:
        throw e;
    L9:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r113) == false) goto L22;
        int r104 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r103, r113, 0, null, null, 2, r112).result;     // Catch: Exception -> L31
        if (r104 != 1) goto L15;
        r112.registerReceiver(r103, r113);     // Catch: Exception -> L31
    L45:
        goto L36
    L15:
        if (r104 != 2) goto L17;
        new Intent();     // Catch: Exception -> L31
        goto L45
    L17:
        if (r104 == 3) goto L45;
        r112.registerReceiver(r103, r113);     // Catch: Exception -> L31
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r112.registerReceiver(r103, r113, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        goto L45
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r112.registerReceiver(r103, r113);     // Catch: Exception -> L31
        goto L45
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r113) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r112, r103, r113, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L31
    L36:
        if (Build.VERSION.SDK_INT >= 23) goto L38;
        return;
    L38:
        if (r102.f434792e != null) goto L40;
        return;
    L40:
        if (r102.f434793f != null) goto L50;
        r r105 = new r(r102);
        r102.f434793f = r105;
        r102.f434792e.registerAudioDeviceCallback(r105, r102.f434788a);
        return;
    }
}
