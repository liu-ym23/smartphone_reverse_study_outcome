package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.oggopus_rust_android.OggOpusEncoderInputInfo;
import com.bytedance.lark.oggopus_rust_android.Oggopus_rustKt;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRecordingRemoteAudioSetting;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingAudioProcessor {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f434300q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingAudioPersistent f434301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingAudioService f434302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f434304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f434305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f434306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f434307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f434308h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ByteBuffer f434309i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f434310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f434311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f434312l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Channel<Object> f434313m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f434314n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f434315o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f434316p;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor$1", f = "MmRecordingAudioProcessor.kt", i = {2}, l = {66, 68, 72}, m = "invokeSuspend", n = {MapController.ITEM_LAYER_TAG}, s = {"L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MmRecordingAudioProcessor this$0;

        public AnonymousClass1(MmRecordingAudioProcessor r100, Continuation<? super AnonymousClass1> r101) {
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

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0075 -> B:37:0x00a2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007a -> B:37:0x00a2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0084 -> B:34:0x0099). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0093 -> B:33:0x0096). Please report as a decompilation issue!!! */
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
            ChannelIterator<Object> r111 = r103;
            AnonymousClass1 r104 = this;
        L33:
            Object r112 = r102;
            ChannelIterator<Object> r105 = r111;
            Object r113 = r112;
        L34:
            Function0<Unit> r114 = ((b) r113).f434317a;
            if (r114 == null) goto L37;
            r114.invoke();
        L37:
            ChannelIterator<Object> r115 = r105;
            AnonymousClass1 r106 = r104;
        L14:
            r106.L$0 = r115;
            r106.L$1 = null;
            r106.label = 1;
            Object r107 = r115.hasNext(r106);
            if (r107 != r100) goto L17;
            return r100;
        L17:
            AnonymousClass1 r116 = r106;
            r105 = r115;
            r110 = r107;
            r104 = r116;
        L19:
            if (((Boolean) r110).booleanValue() == false) goto L39;
            r113 = r105.next();
            if ((r113 instanceof byte[]) == false) goto L26;
            r104.L$0 = r105;
            r104.label = 2;
            int r108 = MmRecordingAudioProcessor.f434300q;
            if (r104.this$0.f((byte[]) r113, false, r104) != r100) goto L37;
            return r100;
        L26:
            if ((r113 instanceof b) == false) goto L37;
            MmRecordingAudioProcessor r109 = r104.this$0;
            if (r109.f434311k <= 0) goto L34;
            r104.L$0 = r105;
            r104.L$1 = r113;
            r104.label = 3;
            if (r109.b(r104) != r100) goto L32;
            return r100;
        L32:
            ChannelIterator<Object> r117 = r105;
            r102 = r113;
            r111 = r117;
            goto L33
        L39:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ChannelIterator<Object> r118 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
            r115 = r118;
        L13:
            r106 = this;
            goto L14
        L11:
            r105 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
            r104 = this;
            goto L19
        L12:
            ResultKt.throwOnFailure(r110);
            r115 = this.this$0.f434313m.iterator();
            goto L13
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f434317a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f434317a, ((b) r100).f434317a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Function0<Unit> r100 = this.f434317a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "FlushSignal(callback=" + this.f434317a + ')';
        }

        public b(Function0<Unit> r100) {
            this.f434317a = r100;
        }
    }

    static {
    }

    public final byte[] a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        if (this.f434309i.position() != 0) goto L6;
        return null;
    L6:
        this.f434309i.flip();     // Catch: Throwable -> L8
        byte[] r101 = new byte[this.f434309i.limit()];     // Catch: Throwable -> L8
        this.f434309i.get(r101);     // Catch: Throwable -> L8
        this.f434309i.clear();     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Throwable r103 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r103 == null) goto L12;
        lvb.a.b(this.f434305e, "drainPcmBuffer: " + r103.getMessage());
    L12:
        return null;
    }

    public final int d() {
        return ((Number) this.f434314n.getValue()).intValue();
    }

    public final int e() {
        return ((Number) this.f434316p.getValue()).intValue();
    }

    public final void c() {
        byte[] r100 = a();
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = this.f434313m.mo10962trySendJP2dKIU(r100);
        g.c r102 = g.f504696b;
        if ((r101 instanceof g.c) == false) goto L15;
        lvb.a.b(this.f434305e, "flushPcmBuffer: failed to send pcmData to channel, size=" + r100.length);
        qvb.a r103 = qvb.a.f534934a;
        Throwable r104 = g.a(r101);
        if (r104 == null) goto L10;
        String r105 = r104.getClass().getSimpleName();
    L11:
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        qvb.a.b(null, "pcm_channel_send_failed", r105, null, 9);
        return;
    L10:
        r105 = null;
        goto L11
    }

    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1) == false) goto L7;
        MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1 r100 = (MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        ResultKt.throwOnFailure(r102);
    L64:
        this.f434311k = 0;
        this.f434312l++;
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
    L54:
        boolean r105 = ((Boolean) r102).booleanValue();
    L57:
        if (r105 == false) goto L64;
        MmRecordingAudioPersistent r106 = this.f434301a;
        int r107 = this.f434312l;
        int r108 = e();
        r100.label = 3;
        Object r109 = BuildersKt.withContext(r106.f434295d, new MmRecordingAudioPersistent$deletePcmFile$2(r106, r107, r108, null), r100);
        if (r109 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        r109 = Unit.INSTANCE;
    L62:
        if (r109 != r103) goto L64;
        return r103;
    L17:
        ResultKt.throwOnFailure(r102);
    L21:
        byte[] r111 = (byte[]) r102;
        lvb.a.e(this.f434305e, "encodeAndSaveCurrentSlice size: " + r111.length);
        r105 = false;
        if (r111.length != 0) goto L24;
        boolean r112 = true;
    L26:
        if ((!r112) == false) goto L56;
        String r113 = "";
        MmRecordingRemoteAudioSetting r114 = this.f434303c.getSettingsService().f434071b;
        String r115 = this.f434305e;
        StringBuilder r116 = new StringBuilder("[audioFormat][sliceEncode] sliceIndex=");
        r116.append(this.f434312l);
        r116.append(", pcmSize=");
        r116.append(r111.length);
        r116.append(", formatId=");
        r116.append(System.identityHashCode(this.f434304d));
        r116.append(", sampleRate=");
        r116.append(this.f434304d.f434366a);
        r116.append(", channelCount=");
        r116.append(this.f434304d.f434367b);
        r116.append(", encodeConfigId=");
        String r117 = (String) this.f434315o.getValue();
        if (r117 != null) goto L30;
        r117 = "default";
    L30:
        r116.append(r117);
        r116.append(", currentSampleRate=");
        r116.append(r114.getMmAudioSampleRate());
        r116.append(", currentChannelCount=");
        r116.append(r114.getMmAudioChannel());
        lvb.a.e(r115, r116.toString());
        f r118 = this.f434304d;     // Catch: Exception -> L33 OutOfMemoryError -> L39
        byte[] r119 = Oggopus_rustKt.encodeDataToOpus(r111, new OggOpusEncoderInputInfo(r118.f434366a, r118.f434367b), (String) this.f434315o.getValue());     // Catch: Exception -> L33 OutOfMemoryError -> L39
    L46:
        if (r119.length != 0) goto L48;
        boolean r120 = true;
    L50:
        if ((!r120) == false) goto L55;
        int r121 = this.f434312l;
        int r122 = e();
        r100.label = 2;
        r102 = g(r119, r121, r122, r100);
        if (r102 != r103) goto L54;
        return r103;
    L55:
        lvb.a.b(this.f434305e, "encodeAndSaveCurrentSlice failed, keep pcm file, sliceIndex:" + this.f434312l);
        goto L57
    L48:
        r120 = false;
    L33:
        e = move-exception;
        lvb.a.b(this.f434305e, "encodePcmToOgg failed: " + e);
        qvb.a r123 = qvb.a.f534934a;
        String r124 = e.getMessage();
        if (r124 == null) goto L38;
        r113 = r124;
    L38:
        qvb.a.b(null, "encode_pcm_to_ogg_failed:".concat(r113), e.getClass().getSimpleName(), null, 9);
        r119 = new byte[0];
    L39:
        e = move-exception;
        lvb.a.b(this.f434305e, "encodePcmToOgg oom, pcmSize:" + r111.length + ", sampleRate:" + this.f434304d.f434366a + ", channel:" + this.f434304d.f434367b);
        qvb.a r125 = qvb.a.f534934a;
        String r126 = e.getMessage();
        if (r126 == null) goto L44;
        r113 = r126;
    L44:
        qvb.a.b(null, "encode_pcm_to_ogg_oom:".concat(r113), e.getClass().getSimpleName(), null, 9);
        r119 = new byte[0];
        goto L46
    L56:
        lvb.a.h(this.f434305e, "encodeAndSaveCurrentSlice, pcmData is empty, sliceIndex:" + this.f434312l);
        r105 = true;
        goto L57
    L24:
        r112 = false;
        goto L26
    L18:
        ResultKt.throwOnFailure(r102);
        MmRecordingAudioPersistent r127 = this.f434301a;
        int r128 = this.f434312l;
        int r129 = e();
        r100.label = 1;
        r102 = BuildersKt.withContext(r127.f434295d, new MmRecordingAudioPersistent$readPcmFile$2(r127, r128, r129, null), r100);
        if (r102 != r103) goto L21;
        return r103;
    L7:
        r100 = new MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1(this, r110);
        goto L8
    }

    public final Object f(byte[] r110, boolean r111, Continuation<? super Unit> r112) {
        byte[] r100 = r110;
        if ((r112 instanceof MmRecordingAudioProcessor$processPcmDataChunk$1) == false) goto L7;
        MmRecordingAudioProcessor$processPcmDataChunk$1 r101 = (MmRecordingAudioProcessor$processPcmDataChunk$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultKt.throwOnFailure(r103);
    L47:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r107 = r101.Z$0;
        byte[] r108 = (byte[]) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L37:
        this.f434311k += (long) r108.length;
        lvb.a.e(this.f434305e, "processPcmDataChunk currentSliceAccumulatedBytes: " + this.f434311k);
        if (this.f434311k >= (((long) e()) * ((long) d()))) goto L43;
        if (r107 == true) goto L43;
        return Unit.INSTANCE;
    L43:
        r101.L$0 = null;
        r101.label = 3;
        if (b(r101) != r104) goto L47;
        return r104;
    L17:
        boolean r109 = r101.Z$0;
        byte[] r113 = (byte[]) r101.L$0;
        ResultKt.throwOnFailure(r103);
        boolean r114 = r109;
        r100 = r113;
    L30:
        MmRecordingAudioPersistent r115 = this.f434301a;
        int r116 = this.f434312l;
        int r117 = e();
        r101.L$0 = r100;
        r101.Z$0 = r114;
        r101.label = 2;
        Object r118 = BuildersKt.withContext(r115.f434295d, new MmRecordingAudioPersistent$appendPcmToFile$2(r115, r116, r117, r100, null), r101);
        if (r118 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        r118 = Unit.INSTANCE;
    L34:
        if (r118 != r104) goto L36;
        return r104;
    L36:
        boolean r119 = r114;
        r108 = r100;
        r107 = r119;
        goto L37
    L18:
        ResultKt.throwOnFailure(r103);
        MmRecordingAudioPersistent r120 = this.f434301a;
        r101.L$0 = r100;
        r114 = r111;
        r101.Z$0 = r114;
        r101.label = 1;
        r120.getClass();
        if (r100.length == 0) goto L22;
        r106 = false;
    L22:
        if (r106 == false) goto L24;
        Object r121 = Unit.INSTANCE;
    L28:
        if (r121 != r104) goto L30;
        return r104;
    L24:
        r121 = BuildersKt.withContext(r120.f434295d, new MmRecordingAudioPersistent$appendPcmToFullFile$2(r120, r100, null), r101);
        if (r121 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        r121 = Unit.INSTANCE;
    L7:
        r101 = new MmRecordingAudioProcessor$processPcmDataChunk$1(this, r112);
        goto L8
    }

    public MmRecordingAudioProcessor(MmRecordingAudioPersistent r100, MmRecordingAudioService r101, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r102, f r110) {
        Intrinsics.checkNotNullParameter(r100, "filePersistent");
        Intrinsics.checkNotNullParameter(r101, "audioService");
        Intrinsics.checkNotNullParameter(r102, "userComponentContext");
        Intrinsics.checkNotNullParameter(r110, "audioFormat");
        this.f434301a = r100;
        this.f434302b = r101;
        this.f434303c = r102;
        this.f434304d = r110;
        this.f434305e = "MmRecordingAudioProcessor";
        this.f434306f = LazyKt.lazy(MmRecordingAudioProcessor$captureScope$2.INSTANCE);
        this.f434307g = LazyKt.lazy(MmRecordingAudioProcessor$encodeDispatcher$2.INSTANCE);
        Lazy r103 = LazyKt.lazy(new MmRecordingAudioProcessor$encodeScope$2(this));
        this.f434308h = r103;
        this.f434309i = ByteBuffer.allocateDirect(98304);
        this.f434312l = 1;
        this.f434313m = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt.launch$default((CoroutineScope) r103.getValue(), null, null, new AnonymousClass1(this, null), 3, null);
        this.f434314n = LazyKt.lazy(new MmRecordingAudioProcessor$audioBytesPerSecond$2(this));
        this.f434315o = LazyKt.lazy(new MmRecordingAudioProcessor$encodeConfigId$2(this));
        this.f434316p = LazyKt.lazy(new MmRecordingAudioProcessor$sliceDurationInSec$2(this));
    }

    public final Object g(byte[] r110, int r111, int r112, Continuation<? super Boolean> r113) {
        if ((r113 instanceof MmRecordingAudioProcessor$saveOggFile$1) == false) goto L7;
        MmRecordingAudioProcessor$saveOggFile$1 r100 = (MmRecordingAudioProcessor$saveOggFile$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r112 = r100.I$1;
        r111 = r100.I$0;
        r110 = (byte[]) r100.L$0;
        ResultKt.throwOnFailure(r114);
        Object r115 = ((Result) r114).m9458unboximpl();
    L17:
        String r104 = "";
        if (Result.m9456isSuccessimpl(r115) == false) goto L25;
        ovb.a r105 = (ovb.a) r115;
        Object r106 = this.f434302b.f434327j.mo10962trySendJP2dKIU(r105);
        String r107 = this.f434305e;
        StringBuilder r108 = new StringBuilder("saveOggFile success, sliceIndex:");
        r108.append(r111);
        r108.append(", durationSec:");
        r108.append(r112);
        r108.append(", oggSize:");
        r108.append(r110.length);
        r108.append(", filePath:");
        r108.append(r105.f526980a);
        r108.append(", metaEnqueueSuccess:");
        g.c r116 = g.f504696b;
        r108.append(!(r106 instanceof g.c));
        lvb.a.e(r107, r108.toString());
        Throwable r117 = g.a(r106);
        if (r117 == null) goto L25;
        lvb.a.b(this.f434305e, "saveOggFile meta enqueue failed, sliceIndex:" + r111 + ", error:" + r117);
        qvb.a r118 = qvb.a.f534934a;
        String r119 = r117.getMessage();
        if (r119 != null) goto L24;
        r119 = "";
    L24:
        qvb.a.b(null, "meta_enqueue_failed:".concat(r119), r117.getClass().getSimpleName(), null, 9);
    L25:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r115);
        if (r120 == null) goto L33;
        lvb.a.b(this.f434305e, "saveOggFile failed, sliceIndex:" + r111 + ", error:" + r120);
        qvb.a r121 = qvb.a.f534934a;
        String r122 = r120.getMessage();
        if (r122 == null) goto L31;
        r104 = r122;
    L31:
        qvb.a.b(null, "save_ogg_failed:".concat(r104), r120.getClass().getSimpleName(), null, 9);
    L33:
        return Boxing.boxBoolean(Result.m9456isSuccessimpl(r115));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        MmRecordingAudioPersistent r123 = this.f434301a;
        r100.L$0 = r110;
        r100.I$0 = r111;
        r100.I$1 = r112;
        r100.label = 1;
        r115 = r123.d(r110, r111, r112, r100);
        if (r115 != r102) goto L17;
        return r102;
    L7:
        r100 = new MmRecordingAudioProcessor$saveOggFile$1(this, r113);
        goto L8
    }
}
