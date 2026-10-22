package com.obric.assistant.spi.wakeup;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.obric.sva.sdk.utils.InteractConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H&J\u001b\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\nH&¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00032\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016¨\u0006&"}, d2 = {"Lcom/obric/assistant/spi/wakeup/IObricOneshotService;", "", "isSupportOneshotQuery", "", "isCurrentSessionUsingOneshot", "setOneshotParams", "", "sessionId", "", "keywords", "", InteractConst.WAKEUP_ONESHOT_OFFSET_TIME, "", "setBackTraceParams", "historyLengthMs", "wakeupTimeStamp", "getBackTraceHistoryMs", "getWakeupTimeStamp", "clearOneshotParam", "getOneshotParam", ExifInterface.GPS_DIRECTION_TRUE, "name", "(Ljava/lang/String;)Ljava/lang/Object;", "getCachedAudioRecorder", "Landroid/media/AudioRecord;", "mono", "bufSize", "isCachedAudioRecorder", "record", "removeFromCache", "addToCache", SpeechEngineDefines.RECORDER_ENGINE, "cached", "trigger", "Lkotlin/Function0;", "onAsrInfoUpdate", "setAudioRecord", "clearAudioRecord", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricOneshotService {
    boolean a();

    void b(long r100, long r101);

    boolean c();

    long d();

    void e();

    <T> T f(String r100);

    void g();

    long h();

    void i(int r100, String r101, long r102);
}
