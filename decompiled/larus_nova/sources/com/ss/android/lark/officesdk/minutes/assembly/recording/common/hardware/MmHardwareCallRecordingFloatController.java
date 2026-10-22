package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes37.dex */
public final class MmHardwareCallRecordingFloatController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hub.a f433646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tub.a f433647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f433648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f433649d;

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "trigger");
        if (StringsKt.isBlank(r100) == false) goto L6;
        lvb.a.h(this.f433649d, "[tryShow] skip blank recordingId, trigger=" + r101);
        return;
    L6:
        CoroutineScope r102 = this.f433648c;
        Lazy r103 = MMCoroutines.f433826a;
        BuildersKt.launch$default(r102, Dispatchers.getMain().getImmediate(), null, new MmHardwareCallRecordingFloatController$tryShow$1(this, r101, r100, null), 2, null);
    }

    public MmHardwareCallRecordingFloatController(hub.a r100, tub.a r101, CoroutineScope r102) {
        Intrinsics.checkNotNullParameter(r100, "capacity");
        Intrinsics.checkNotNullParameter(r101, "priorityCapacity");
        Intrinsics.checkNotNullParameter(r102, "scope");
        this.f433646a = r100;
        this.f433647b = r101;
        this.f433648c = r102;
        this.f433649d = "MmHardwareCallRecordingFloatController_" + hashCode();
    }
}
