package com.larus.common_ui.widget.input.audiowave.amplitude;

import androidx.camera.video.AudioStats;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class AudioAmplitudeProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<Float> f328708c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.common_ui.widget.input.audiowave.amplitude.AudioAmplitudeProcessor$update$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common_ui.widget.input.audiowave.amplitude.AudioAmplitudeProcessor", f = "AudioAmplitudeProcessor.kt", i = {}, l = {28}, m = "update", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AudioAmplitudeProcessor this$0;

        public AnonymousClass1(AudioAmplitudeProcessor r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.update(null, this);
        }
    }

    static {
    }

    public AudioAmplitudeProcessor() {
        this(0, 3);
    }

    public static float a(AudioAmplitudeProcessor r100) {
        Float r101 = CollectionsKt.m9877maxOrNull(r100.f328708c);
        if (r101 == null) goto L5;
        float r102 = r101.floatValue();
    L6:
        FLogger.f375446a.i("AmpProcessor", "maxAmplitude: " + r102);
        return r102;
    L5:
        r102 = 0.0f;
        goto L6
    }

    public static float b(double r100) {
        if (r100 <= 0.5d) goto L5;
        double r101 = 1.0d;
    L7:
        return RangesKt.coerceAtMost(((float) r101) * 2.5f, 1.0f);
    L5:
        r101 = Math.sin(r100 * 3.141592653589793d);
        goto L7
    }

    public AudioAmplitudeProcessor(int r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = 45;
    L6:
        if ((r101 & 2) == 0) goto L8;
        int r102 = 10;
    L9:
        this.f328706a = r100;
        this.f328707b = r102;
        this.f328708c = new CopyOnWriteArrayList();
        return;
    L8:
        r102 = 0;
        goto L9
    }

    public final Object update(byte[] r100, Continuation<? super Float> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        Iterator r107 = ((ArrayList) r104).iterator();
        if (r107.hasNext() == true) goto L20;
        Double r108 = null;
    L25:
        if (r108 == null) goto L27;
        double r109 = r108.doubleValue();
    L28:
        float r110 = b(r109);
        if (this.f328708c.size() < this.f328707b) goto L31;
        this.f328708c.remove(0);
    L31:
        this.f328708c.add(Boxing.boxFloat(r110));
        return Boxing.boxFloat(r110);
    L27:
        r109 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L28
    L20:
        double r111 = Math.abs(((Number) r107.next()).doubleValue());
    L22:
        if (r107.hasNext() == false) goto L24;
        r111 = Math.max(r111, Math.abs(((Number) r107.next()).doubleValue()));
        goto L22
    L24:
        r108 = Boxing.boxDouble(r111);
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r112 = com.larus.common_ui.widget.input.a.f328681a;
        int r113 = this.f328706a;
        r102.label = 1;
        r104 = com.larus.common_ui.widget.input.a.a(r100, r113, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
