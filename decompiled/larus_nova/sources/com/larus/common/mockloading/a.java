package com.larus.common.mockloading;

import androidx.camera.video.AudioStats;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.common.mockloading.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes27.dex */
    public static final class C4182a {
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01a7 -> B:53:0x01ad). Please report as a decompilation issue!!! */
        public static Object a(a r210, String r211, long r212, double r213, Continuation r214) {
            if ((r214 instanceof IMessageLoadingProgressMocker$startProgress$1) == false) goto L7;
            IMessageLoadingProgressMocker$startProgress$1 r100 = (IMessageLoadingProgressMocker$startProgress$1) r214;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            double r105 = 1.0d;
            if (r104 == 0) goto L16;
            if (r104 == 1) goto L15;
            if (r104 != 2) goto L14;
            double r110 = r100.D$1;
            double r111 = r100.D$0;
            Ref.IntRef r106 = (Ref.IntRef) r100.L$2;
            String r112 = (String) r100.L$1;
            a r113 = (a) r100.L$0;
            ResultKt.throwOnFailure(r102);
            double r107 = r110;
            a r108 = r113;
        L53:
            r105 = 1.0d;
        L39:
            Integer r109 = r108.getProgressMap().get(r112);
            if (r109 == null) goto L42;
            int r114 = r109.intValue();
        L44:
            if (r114 >= 99) goto L55;
            IMessageLoadingProgressMocker$startProgress$1 r115 = r100;
            Object r215 = r103;
            int r116 = (int) Math.floor(Math.pow(r105 - (r105 / ((r107 * 2.0d) + r105)), 2.0d) * 100.0d);
            Map r117 = MapsKt.toMutableMap(r108.getProgressMap());
            if (r116 < r106.element) goto L48;
            r117.put(r112, Boxing.boxInt(r116));
            r108.setProgressMap(MapsKt.toMap(r117));
            r106.element = r116;
            FLogger.f375446a.i("ILoadingProgressMocker", r108.hashCode() + " loadingTaskId-" + r112 + " update: Duration: " + r107 + ", Progress: " + r108.getProgressMap().get(r112) + ", New Progress: " + r116);
        L49:
            double r118 = r107 + r111;
            r115.L$0 = r108;
            r115.L$1 = r112;
            r115.L$2 = r106;
            r115.D$0 = r111;
            r115.D$1 = r118;
            r115.label = 2;
            if (DelayKt.delay(100, r115) != r215) goto L52;
            return r215;
        L52:
            r100 = r115;
            r103 = r215;
            r107 = r118;
            goto L53
        L48:
            FLogger.f375446a.i("ILoadingProgressMocker", "skipped update: Duration: " + r107 + ", Progress: " + r108.getProgressMap().get(r112) + ", New Progress: " + r116);
            goto L49
        L55:
            return Unit.INSTANCE;
        L42:
            r114 = 0;
            goto L44
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            double r119 = r100.D$0;
            String r120 = (String) r100.L$1;
            a r121 = (a) r100.L$0;
            ResultKt.throwOnFailure(r102);
        L20:
            Ref.IntRef r122 = new Ref.IntRef();
            Integer r123 = r121.getProgressMap().get(r120);
            if (r123 == null) goto L23;
            int r124 = r123.intValue();
        L24:
            r122.element = r124;
            Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L31
            double r216 = r119;
            Object r126 = Result.m9449constructorimpl(Boxing.boxDouble(((1.0d / (1.0d - Math.sqrt(((double) r124) / 100.0d))) - ((double) 1)) * 0.5d));     // Catch: Throwable -> L29
        L35:
            if (Result.m9452exceptionOrNullimpl(r126) == null) goto L38;
            r126 = Boxing.boxDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        L38:
            r107 = ((Number) r126).doubleValue();
            r108 = r121;
            r111 = r216;
            r112 = r120;
            r106 = r122;
        L29:
            th = th;
        L33:
            Result.Companion r127 = Result.Companion;
            r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L31:
            th = th;
            r216 = r119;
            goto L33
        L23:
            r124 = 0;
            goto L24
        L16:
            ResultKt.throwOnFailure(r102);
            r100.L$0 = r210;
            r120 = r211;
            r100.L$1 = r120;
            r119 = r213;
            r100.D$0 = r119;
            r100.label = 1;
            if (DelayKt.delay(r212, r100) != r103) goto L19;
            return r103;
        L19:
            r121 = r210;
        L7:
            r100 = new IMessageLoadingProgressMocker$startProgress$1(r214);
            goto L8
        }
    }

    Map<String, Integer> getProgressMap();

    void setProgressMap(Map<String, Integer> r100);
}
