package com.larus.voice.output.volume;

import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements com.larus.voice.output.volume.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f376043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f376044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f376045e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f376046b;

    public static final class a {
    }

    static {
        f376043c = "";
    }

    public i() {
        this.f376046b = LazyKt.lazy(new e());
    }

    @Override // com.larus.voice.output.volume.a
    public final void a(c r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeRaiseUpWithToastHandler][handle]: scene: " + r110.f376038c + ", lastShownScene = " + f376043c + ", isTTSAutoPlay=" + com.larus.voice.output.volume.a.b.a(r110) + ", hasShownAdjustStreamVolume=" + f376044d + ", hasShownTTSAutoPlayToast:" + f376045e + ", enableAutoPlayToast=" + r110.f376037b);
        if (f376044d == true) goto L8;
        if (com.larus.voice.output.volume.a.b.a(r110) == true) goto L8;
        f376044d = true;
        t0.d(new f(this), 300);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new IZeroVolumeHandlerKt$mobAutoAdjustVolumeToast$1(r110, null), 2, null);
    L18:
        f376043c = r110.f376038c;
        return;
    L8:
        if (f376045e == true) goto L15;
        if (com.larus.voice.output.volume.a.b.a(r110) == false) goto L15;
        if (r110.f376037b == false) goto L15;
        f376045e = true;
        t0.d(new g(), 300);
        IZeroVolumeHandlerKt.a(r110);
    L15:
        if (com.larus.voice.output.volume.a.b.a(r110) == true) goto L17;
        t0.d(new h(), 300);
        IZeroVolumeHandlerKt.a(r110);
        goto L18
    L17:
        FLogger.f375446a.i("ZeroVolumeAutoPlayHelper", "[ZeroVolumeRaiseUpWithToastHandler][handle]: cannot handle lastShownScene=" + f376043c + ", isTTSAutoPlay=" + com.larus.voice.output.volume.a.b.a(r110));
        goto L18
    }

    @Override // com.larus.voice.output.volume.a
    public final boolean b(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = false;
        if (r100.f376036a != 2) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L13;
        String r103 = r100.f376038c;
        com.larus.voice.output.volume.a.f376033a.getClass();
        if (com.larus.voice.output.volume.a.C4519a.f376035b.contains(r103) == false) goto L10;
        boolean r104 = !Intrinsics.areEqual(r103, f376043c);
    L11:
        if (r104 == false) goto L13;
        r101 = true;
        goto L13
    L10:
        r104 = true;
    L13:
        int r105 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeRaiseUpWithToastHandler][canHandle]: result = " + r101 + " strategyId = " + r100.f376036a + ", scene = " + r100.f376038c + ", lastShownScene = " + f376043c);
        return r101;
    L5:
        r102 = false;
        goto L6
    }
}
