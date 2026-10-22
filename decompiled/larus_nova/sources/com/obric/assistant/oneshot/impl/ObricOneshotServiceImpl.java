package com.obric.assistant.oneshot.impl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.obric.assistant.oneshot.api.IOneshotService;
import com.obric.assistant.spi.wakeup.IObricOneshotService;
import com.obric.sva.sdk.utils.InteractConst;
import kfa.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u001b\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0012\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010%\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J&\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0*H\u0016J\b\u0010+\u001a\u00020\u000eH\u0016J\u0012\u0010,\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J\b\u0010-\u001a\u00020\u000eH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006."}, d2 = {"Lcom/obric/assistant/oneshot/impl/ObricOneshotServiceImpl;", "Lcom/obric/assistant/spi/wakeup/IObricOneshotService;", "<init>", "()V", "service", "Lcom/obric/assistant/oneshot/api/IOneshotService;", "getService", "()Lcom/obric/assistant/oneshot/api/IOneshotService;", "service$delegate", "Lkotlin/Lazy;", "isSupportOneshotQuery", "", "isCurrentSessionUsingOneshot", "setOneshotParams", "", "sessionId", "", "keywords", "", InteractConst.WAKEUP_ONESHOT_OFFSET_TIME, "", "setBackTraceParams", "historyLengthMs", "wakeupTimeStamp", "getBackTraceHistoryMs", "getWakeupTimeStamp", "clearOneshotParam", "getOneshotParam", ExifInterface.GPS_DIRECTION_TRUE, "name", "(Ljava/lang/String;)Ljava/lang/Object;", "getCachedAudioRecorder", "Landroid/media/AudioRecord;", "mono", "bufSize", "isCachedAudioRecorder", "record", "removeFromCache", "addToCache", SpeechEngineDefines.RECORDER_ENGINE, "cached", "trigger", "Lkotlin/Function0;", "onAsrInfoUpdate", "setAudioRecord", "clearAudioRecord", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneshotServiceImpl implements IObricOneshotService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f390960a;

    public final IOneshotService j() {
        return (IOneshotService) this.f390960a.getValue();
    }

    public ObricOneshotServiceImpl() {
        this.f390960a = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final boolean a() {
        IOneshotService r100 = j();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final boolean c() {
        IOneshotService r100 = j();
        if (r100 == null) goto L5;
        r100.c();
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final long d() {
        IOneshotService r100 = j();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.d();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void e() {
        IOneshotService r100 = j();
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void g() {
        IOneshotService r100 = j();
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final long h() {
        IOneshotService r100 = j();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.h();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final <T> T f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        IOneshotService r101 = j();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.f(r100);
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void b(long r100, long r101) {
        IOneshotService r102 = j();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void i(int r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "keywords");
        IOneshotService r103 = j();
        if (r103 == null) goto L6;
        r103.i(r100, r101, r102);
        return;
    }
}
