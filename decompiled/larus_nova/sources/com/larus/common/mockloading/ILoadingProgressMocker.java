package com.larus.common.mockloading;

import androidx.camera.video.AudioStats;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes27.dex */
public interface ILoadingProgressMocker {

    public static final class DefaultImpls {
        public static Object a(ILoadingProgressMocker r110, Continuation<? super Unit> r111) {
            if ((r111 instanceof ILoadingProgressMocker$startProgress$1) == false) goto L7;
            ILoadingProgressMocker$startProgress$1 r100 = (ILoadingProgressMocker$startProgress$1) r111;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r112 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            if (r103 == 0) goto L14;
            if (r103 != 1) goto L13;
            int r113 = r100.I$0;
            double r104 = r100.D$0;
            ILoadingProgressMocker r105 = (ILoadingProgressMocker) r100.L$0;
            ResultKt.throwOnFailure(r112);
            int r114 = r113;
            r110 = r105;
        L16:
            if (r110.getProgress() > 99) goto L25;
            int r106 = (int) Math.floor(Math.pow(1.0d - (1.0d / ((r104 * 2.0d) + 1.0d)), 2.0d) * 100.0d);
            if (r106 < r114) goto L20;
            r110.setProgress(r106);
            FLogger.f375446a.i("ILoadingProgressMocker", r110.hashCode() + " update: Duration: " + r104 + ", Progress: " + r110.getProgress() + ", New Progress: " + r106);
            r114 = r106;
        L21:
            r104 = r104 + 0.1d;
            r100.L$0 = r110;
            r100.D$0 = r104;
            r100.I$0 = r114;
            r100.label = 1;
            if (DelayKt.delay(100, r100) != r102) goto L16;
            return r102;
        L20:
            FLogger.f375446a.i("ILoadingProgressMocker", "skipped update: Duration: " + r104 + ", Progress: " + r110.getProgress() + ", New Progress: " + r106);
            goto L21
        L25:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r112);
            r114 = r110.getProgress();
            r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L7:
            r100 = new ILoadingProgressMocker$startProgress$1(r111);
            goto L8
        }
    }

    int getProgress();

    void setProgress(int r100);
}
