package com.larus.common_ui.widget.input;

import androidx.camera.video.AudioStats;
import com.larus.platform.service.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common_ui.widget.input.AudioUtils$getAudioWave$2", f = "AudioUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AudioUtils$getAudioWave$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Double>>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ int $density;
    final /* synthetic */ int $recordChannel;
    int label;

    public AudioUtils$getAudioWave$2(byte[] r100, int r101, int r102, Continuation<? super AudioUtils$getAudioWave$2> r103) {
        this.$bytes = r100;
        this.$recordChannel = r101;
        this.$density = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AudioUtils$getAudioWave$2(this.$bytes, this.$recordChannel, this.$density, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ArrayList<Double>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ArrayList<Double>> r101) {
        return ((AudioUtils$getAudioWave$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r110);
        int r111 = a.f328681a;
        byte[] r112 = this.$bytes;
        int r100 = this.$recordChannel;
        int r101 = this.$density;
        ArrayList r102 = new ArrayList();
        int r103 = r112.length;
        if (r100 != 12) goto L7;
        int r104 = 4;
    L8:
        int r105 = r103 / r104;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L17;
        if ((r106 % 2) != 0) goto L16;
        r102.add(new BigDecimal(r112[r106] | (r112[r106 + 1] << 8)).divide(new BigDecimal(32768), 3, RoundingMode.HALF_UP));
        if (r100 != 12) goto L16;
        r102.add(new BigDecimal((r112[r106 + 2] << 16) | (r112[r106 + 3] << 24)).divide(new BigDecimal(32768), 6, RoundingMode.HALF_UP));
    L16:
        r106 = r106 + 1;
        goto L10
    L17:
        BigDecimal r113 = new BigDecimal(AudioStats.AUDIO_AMPLITUDE_NONE);
        ArrayList r107 = new ArrayList();
        int r108 = Math.max(r102.size() / r101, 2);
        Iterator r109 = r102.iterator();
    L18:
        int r114 = 0;
    L20:
        if (r109.hasNext() == false) goto L33;
        BigDecimal r115 = (BigDecimal) r109.next();
        if (r114 >= (r108 - 1)) goto L24;
        r113 = r113.add(r115.abs());
        r114 = r114 + 1;
        goto L20
    L24:
        double r116 = r113.doubleValue();
        BigDecimal r117 = new BigDecimal(r114);     // Catch: ArithmeticException -> L29
        if (r117.compareTo(BigDecimal.ZERO) == 0) goto L31;
        r116 = r113.divide(r117, 6, RoundingMode.HALF_UP).doubleValue();     // Catch: ArithmeticException -> L29
    L31:
        r107.add(Double.valueOf(r116));
        r113 = new BigDecimal(AudioStats.AUDIO_AMPLITUDE_NONE);
        r107.size();
    L29:
        e = move-exception;
        g.f365738a.ensureNotReachHere(e);
    L33:
        if (r107.size() >= r101) goto L35;
        r107.add(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        goto L33
    L35:
        return r107;
    L7:
        r104 = 2;
        goto L8
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
