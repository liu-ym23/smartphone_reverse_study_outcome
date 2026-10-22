package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.baidu.platform.comapi.map.MapController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingEncodedAudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingAudioService f434346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f434349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f434350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Channel<Object> f434351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f434352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f434353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f434354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f434355j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f434356k;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingEncodedAudioProcessor$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingEncodedAudioProcessor$1", f = "MmRecordingEncodedAudioProcessor.kt", i = {2}, l = {51, 53, 56}, m = "invokeSuspend", n = {MapController.ITEM_LAYER_TAG}, s = {"L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MmRecordingEncodedAudioProcessor this$0;

        public AnonymousClass1(MmRecordingEncodedAudioProcessor r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0073 -> B:37:0x00a2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0078 -> B:37:0x00a2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0082 -> B:34:0x0099). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0091 -> B:33:0x0095). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            Object r102 = this.L$1;
            ChannelIterator<Object> r103 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
            AnonymousClass1 r111 = this;
        L33:
            Object r112 = r100;
            AnonymousClass1 r104 = r111;
            Object r113 = r102;
            Object r105 = r112;
        L34:
            Function0<Unit> r114 = ((a) r113).f434357a;
            if (r114 == null) goto L37;
            r114.invoke();
        L37:
            AnonymousClass1 r115 = r104;
            r100 = r105;
            ChannelIterator<Object> r106 = r103;
        L14:
            r115.L$0 = r106;
            r115.L$1 = null;
            r115.label = 1;
            Object r107 = r106.hasNext(r115);
            if (r107 != r100) goto L17;
            return r100;
        L17:
            Object r116 = r100;
            r104 = r115;
            r110 = r107;
            r103 = r106;
            r105 = r116;
        L19:
            if (((Boolean) r110).booleanValue() == false) goto L39;
            r113 = r103.next();
            if ((r113 instanceof sub.a) == false) goto L26;
            r104.L$0 = r103;
            r104.label = 2;
            if (MmRecordingEncodedAudioProcessor.a(r104.this$0, (sub.a) r113, r104) != r105) goto L37;
            return r105;
        L26:
            if ((r113 instanceof a) == false) goto L37;
            MmRecordingEncodedAudioProcessor r108 = r104.this$0;
            if (r108.f434353h <= 0) goto L34;
            r104.L$0 = r103;
            r104.L$1 = r113;
            r104.label = 3;
            if (r108.b(r104) != r105) goto L32;
            return r105;
        L32:
            Object r117 = r105;
            r102 = r113;
            r111 = r104;
            r100 = r117;
            goto L33
        L39:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r106 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
        L13:
            r115 = this;
            goto L14
        L11:
            ChannelIterator<Object> r109 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
            r103 = r109;
            r105 = r100;
            r104 = this;
            goto L19
        L12:
            ResultKt.throwOnFailure(r110);
            r106 = this.this$0.f434351f.iterator();
            goto L13
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f434357a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f434357a, ((a) r100).f434357a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Function0<Unit> r100 = this.f434357a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "FlushSignal(callback=" + this.f434357a + ')';
        }

        public a(Function0<Unit> r100) {
            this.f434357a = r100;
        }
    }

    public final Unit b(Continuation r110) {
        if ((r110 instanceof MmRecordingEncodedAudioProcessor$muxAndSaveCurrentSlice$1) == false) goto L7;
        MmRecordingEncodedAudioProcessor$muxAndSaveCurrentSlice$1 r100 = (MmRecordingEncodedAudioProcessor$muxAndSaveCurrentSlice$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L30;
        if (r103 != 1) goto L29;
        long r104 = r100.J$0;
        int r105 = r100.I$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = ((Result) r102).m9458unboximpl();
        String r111 = "";
        if (Result.m9456isSuccessimpl(r106) == false) goto L19;
        ovb.a r107 = (ovb.a) r106;
        Object r112 = this.f434346a.f434327j.mo10962trySendJP2dKIU(r107);
        String r113 = this.f434348c;
        StringBuilder r114 = new StringBuilder("muxAndSaveCurrentSlice success, sliceIndex:");
        r114.append(r105);
        r114.append(", durationMs:");
        r114.append(r104);
        r114.append(", filePath:");
        r114.append(r107.f526980a);
        r114.append(", metaEnqueueSuccess:");
        g.c r108 = g.f504696b;
        r114.append(!(r112 instanceof g.c));
        lvb.a.e(r113, r114.toString());
        Throwable r109 = g.a(r112);
        if (r109 == null) goto L19;
        lvb.a.b(this.f434348c, "muxAndSaveCurrentSlice meta enqueue failed, sliceIndex:" + r105 + ", error:" + r109);
        qvb.a r115 = qvb.a.f534934a;
        String r116 = r109.getMessage();
        if (r116 != null) goto L18;
        r116 = "";
    L18:
        qvb.a.b(null, "encoded_meta_enqueue_failed:".concat(r116), r109.getClass().getSimpleName(), null, 9);
    L19:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r106);
        if (r117 == null) goto L26;
        lvb.a.b(this.f434348c, "muxAndSaveCurrentSlice failed, sliceIndex:" + r105 + ", error:" + r117);
        qvb.a r118 = qvb.a.f534934a;
        String r119 = r117.getMessage();
        if (r119 == null) goto L25;
        r111 = r119;
    L25:
        qvb.a.b(null, "encoded_ogg_mux_failed:".concat(r111), r117.getClass().getSimpleName(), null, 9);
    L26:
        this.f434353h = 0;
        this.f434352g++;
        return Unit.INSTANCE;
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L30:
        ResultKt.throwOnFailure(r102);
        int r120 = this.f434352g;
        lvb.a.b(this.f434348c, "muxAndSaveCurrentSlice failed, raw opus options is null, sliceIndex:" + r120);
        qvb.a.b(null, "encoded_ogg_mux_failed:raw_opus_options_null", "IllegalStateException", null, 9);
        this.f434353h = 0;
        this.f434352g++;
        return Unit.INSTANCE;
    L7:
        r100 = new MmRecordingEncodedAudioProcessor$muxAndSaveCurrentSlice$1(this, r110);
        goto L8
    }

    public MmRecordingEncodedAudioProcessor(MmRecordingAudioPersistent r100, MmRecordingAudioService r101, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r102) {
        Intrinsics.checkNotNullParameter(r100, "filePersistent");
        Intrinsics.checkNotNullParameter(r101, "audioService");
        Intrinsics.checkNotNullParameter(r102, "userComponentContext");
        this.f434346a = r101;
        this.f434347b = r102;
        this.f434348c = "MmRecordingEncodedAudioProcessor";
        this.f434349d = LazyKt.lazy(MmRecordingEncodedAudioProcessor$encodeDispatcher$2.INSTANCE);
        Lazy r103 = LazyKt.lazy(new MmRecordingEncodedAudioProcessor$encodeScope$2(this));
        this.f434350e = r103;
        this.f434351f = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.f434352g = 1;
        this.f434355j = LazyKt.lazy(new MmRecordingEncodedAudioProcessor$sliceDurationInSec$2(this));
        this.f434356k = LazyKt.lazy(new MmRecordingEncodedAudioProcessor$targetSliceDurationMs$2(this));
        BuildersKt.launch$default((CoroutineScope) r103.getValue(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final Object a(MmRecordingEncodedAudioProcessor r100, sub.a r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof MmRecordingEncodedAudioProcessor$processEncodedFrame$1) == false) goto L7;
        MmRecordingEncodedAudioProcessor$processEncodedFrame$1 r102 = (MmRecordingEncodedAudioProcessor$processEncodedFrame$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 != 0) goto L11;
        ResultKt.throwOnFailure(r111);
        r101.getClass();
        RangesKt.coerceAtLeast(0, 1);
        throw null;
    L11:
        if (r105 == 1) goto L16;
        if (r105 != 2) goto L15;
        ResultKt.throwOnFailure(r111);
    L22:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        sub.a r106 = (sub.a) r102.L$0;
        ResultKt.throwOnFailure(r111);
        long r107 = r100.f434353h;
        r106.getClass();
        long r108 = r107 + ((long) RangesKt.coerceAtLeast(0, 1));
        r100.f434353h = r108;
        if (r108 < ((Number) r100.f434356k.getValue()).longValue()) goto L22;
        r102.L$0 = null;
        r102.label = 2;
        if (r100.b(r102) != r104) goto L22;
        return r104;
    L7:
        r102 = new MmRecordingEncodedAudioProcessor$processEncodedFrame$1(r100, r110);
        goto L8
    }
}
