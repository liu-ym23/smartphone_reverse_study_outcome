package com.bytedance.kmp.performance.platform;

import androidx.camera.video.AudioStats;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.performance.platform.CpuDump_androidKt", f = "CpuDump.android.kt", i = {0, 0}, l = {68}, m = "getCpuUsage", n = {"systemCpuTimes", "processCpuTimes"}, s = {"L$0", "L$1"})
final class CpuDump_androidKt$getCpuUsage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public CpuDump_androidKt$getCpuUsage$1(Continuation<? super CpuDump_androidKt$getCpuUsage$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        this.result = r210;
        int r100 = this.label | Integer.MIN_VALUE;
        this.label = r100;
        ConcurrentHashMap<String, Integer> r101 = i.f252787a;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        CpuDump_androidKt$getCpuUsage$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        x r106 = (x) r102.L$1;
        j r107 = (j) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L44
    L23:
        j r108 = i.b();     // Catch: Exception -> L44
        x r109 = i.a();     // Catch: Exception -> L26
    L27:
        long r110 = r108.f252798k - r107.f252798k;     // Catch: Exception -> L44
        long r111 = r108.f252799l - r107.f252799l;     // Catch: Exception -> L44
        if (r110 <= 0) goto L30;
        double r112 = RangesKt.coerceIn(((r110 - r111) * 1.0d) / r110, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);     // Catch: Exception -> L44
    L31:
        long r113 = r109.f252816e - r106.f252816e;     // Catch: Exception -> L44
        long r114 = r108.f252798k - r107.f252798k;     // Catch: Exception -> L44
        if (r113 > 0) goto L34;
    L41:
        double r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L42:
        md6.e r116 = new md6.e(r112, r115);     // Catch: Exception -> L44
    L46:
        return r116;
    L34:
        if (r114 <= 0) goto L41;
        double r117 = (r113 * 1.0d) / r114;     // Catch: Exception -> L44
        if (Double.isInfinite(r117) == true) goto L41;
        if (Double.isNaN(r117) == true) goto L41;
        r115 = RangesKt.coerceIn(r117, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);     // Catch: Exception -> L44
        goto L42
    L30:
        r112 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L31
    L26:
        r109 = new x(0, 0, 0, 0);     // Catch: Exception -> L44
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        j r118 = i.b();     // Catch: Exception -> L44
        x r119 = i.a();     // Catch: Exception -> L18
    L19:
        r102.L$0 = r118;     // Catch: Exception -> L44
        r102.L$1 = r119;     // Catch: Exception -> L44
        r102.label = 1;     // Catch: Exception -> L44
        if (DelayKt.delay(360, r102) == r104) goto L53;
        r107 = r118;
        r106 = r119;
        goto L23
    L53:
        return r104;
    L18:
        r119 = new x(0, 0, 0, 0);     // Catch: Exception -> L44
    L44:
        r116 = null;
        goto L46
    L5:
        r102 = new CpuDump_androidKt$getCpuUsage$1(this);
        goto L6
    }
}
