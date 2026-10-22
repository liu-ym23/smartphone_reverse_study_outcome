package com.obric.audio.continuous_talk;

import com.obric.assistant.spi.audio.IObricVadService;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/obric/audio/continuous_talk/ObricVadServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricVadService;", "<init>", "()V", "obricVadModel", "Lcom/obric/audio/continuous_talk/ObricVadModel;", "getObricVadModel", "()Lcom/obric/audio/continuous_talk/ObricVadModel;", "obricVadModel$delegate", "Lkotlin/Lazy;", "preload", "", "isVoiceActive", "buffer", "", "offsetInBytes", "", "sizeInBytes", "release", "", "getFeatureValues", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVadServiceImpl implements IObricVadService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f395148a;

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final float[] a() {
        s0 r100 = (s0) this.f395148a.getValue();
        Object r101 = r100.f395223c;
        monitor-enter(r101);
        float[] r102 = r100.f395228h;     // Catch: Throwable -> L11
        if (r102 == null) goto L8;
        float[] r103 = Arrays.copyOf(r102, r102.length);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);
        return r103;
    L8:
        r103 = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final boolean preload() {
        return ((s0) this.f395148a.getValue()).c();
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final void release() {
        ((s0) this.f395148a.getValue()).d();
    }

    public ObricVadServiceImpl() {
        this.f395148a = LazyKt.lazy(new t0());
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final boolean b(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        return ((s0) this.f395148a.getValue()).b(r100, 0, r101);
    }
}
