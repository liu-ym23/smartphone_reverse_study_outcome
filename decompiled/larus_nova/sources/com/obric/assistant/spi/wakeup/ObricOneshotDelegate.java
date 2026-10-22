package com.obric.assistant.spi.wakeup;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u0005H\u0096\u0001J\t\u0010\r\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\"\u0010\u0014\u001a\u0002H\u0015\"\n\b\u0000\u0010\u0015*\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u001d\u001a\u00020\tH\u0096\u0001J\t\u0010\u001e\u001a\u00020\tH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0019\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0096\u0001J!\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u000fH\u0096\u0001¨\u0006)"}, d2 = {"Lcom/obric/assistant/spi/wakeup/ObricOneshotDelegate;", "Lcom/obric/assistant/spi/wakeup/IObricOneshotService;", "<init>", "()V", "addToCache", "", SpeechEngineDefines.RECORDER_ENGINE, "Landroid/media/AudioRecord;", "cached", "", "trigger", "Lkotlin/Function0;", "clearAudioRecord", "clearOneshotParam", "getBackTraceHistoryMs", "", "getCachedAudioRecorder", "mono", "bufSize", "", "getOneshotParam", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "", "(Ljava/lang/String;)Ljava/lang/Object;", "getWakeupTimeStamp", "isCachedAudioRecorder", "record", "isCurrentSessionUsingOneshot", "isSupportOneshotQuery", "onAsrInfoUpdate", "removeFromCache", "setAudioRecord", "setBackTraceParams", "historyLengthMs", "wakeupTimeStamp", "setOneshotParams", "sessionId", "keywords", InteractConst.WAKEUP_ONESHOT_OFFSET_TIME, "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneshotDelegate implements IObricOneshotService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricOneshotDelegate f392920b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricOneshotService f392921a;

    static {
        f392920b = new ObricOneshotDelegate();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final boolean a() {
        return this.f392921a.a();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void b(long r100, long r101) {
        this.f392921a.b(r100, r101);
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final boolean c() {
        return this.f392921a.c();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final long d() {
        return this.f392921a.d();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void e() {
        this.f392921a.e();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final <T> T f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return (T) this.f392921a.f(r100);
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void g() {
        this.f392921a.g();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final long h() {
        return this.f392921a.h();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void i(int r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "keywords");
        this.f392921a.i(r100, r101, r102);
    }

    private ObricOneshotDelegate() {
        IObricOneshotService r100 = (IObricOneshotService) ServiceManager.get().getService(IObricOneshotService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultOneshotServiceImpl();
    L5:
        this.f392921a = r100;
    }
}
