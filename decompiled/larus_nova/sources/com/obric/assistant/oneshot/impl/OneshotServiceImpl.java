package com.obric.assistant.oneshot.impl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.oneshot.api.IOneshotService;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u0012\u0010 \u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J \u0010$\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\u001b\u0010*\u001a\u0002H+\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/oneshot/impl/OneshotServiceImpl;", "Lcom/obric/assistant/oneshot/api/IOneshotService;", "<init>", "()V", "sessionId", "", "keywords", "", InteractConst.WAKEUP_ONESHOT_OFFSET_TIME, "", "backTraceHistoryMs", "wakeupTimeStamp", "currentAudioRecord", "Landroid/media/AudioRecord;", "lruCache", "Ljava/util/HashMap;", "Lcom/obric/assistant/oneshot/impl/OneshotServiceImpl$RecorderIdentity;", "Lkotlin/collections/HashMap;", "getCachedAudioRecorder", "mono", "", "bufSize", "isCachedAudioRecorder", "record", "removeFromCache", "", "addToCache", SpeechEngineDefines.RECORDER_ENGINE, "cached", "trigger", "Lkotlin/Function0;", "onAsrInfoUpdate", "setAudioRecord", "clearAudioRecord", "isSupportOneshotQuery", "isCurrentSessionUsingOneshot", "setOneshotParams", "setBackTraceParams", "historyLengthMs", "getBackTraceHistoryMs", "getWakeupTimeStamp", "clearOneshotParam", "getOneshotParam", ExifInterface.GPS_DIRECTION_TRUE, "name", "(Ljava/lang/String;)Ljava/lang/Object;", "Companion", "RecorderIdentity", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OneshotServiceImpl implements IOneshotService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f390961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f390962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f390963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f390964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f390965e;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.oneshot.api.IOneshotService
    public final void c() {
    }

    @Override // com.obric.assistant.oneshot.api.IOneshotService
    public final boolean a() {
        if (wna.a.f560482b == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.f390961a != (-1)) goto L8;
        return false;
    }

    @Override // com.obric.assistant.oneshot.api.IOneshotService
    public final void e() {
        FLogger.f375446a.i("OneshotServiceImpl", "onAsrInfo....need restart audio recorder");
    }

    @Override // com.obric.assistant.oneshot.api.IOneshotService
    public final void g() {
        FLogger.f375446a.i("OneshotServiceImpl", "clearOneshotParam");
        this.f390961a = -1;
        this.f390962b = "";
        this.f390963c = 0;
        this.f390964d = 0;
        this.f390965e = 0;
    }

    public OneshotServiceImpl() {
        this.f390961a = -1;
        this.f390962b = "";
        new HashMap(20);
    }

    @Override // com.obric.assistant.oneshot.api.IOneshotService
    public final long d() {
        return this.f390965e;
    }

    @Override // com.obric.assistant.oneshot.api.IOneshotService
    public final long h() {
        return this.f390964d;
    }

    @Override // com.obric.assistant.oneshot.api.IOneshotService
    public final <T> T f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        int r101 = r100.hashCode();
        if (r101 == (-1019779949)) goto L18;
        if (r101 == (-814408215)) goto L14;
        if (r101 == 1984987798) goto L10;
    L19:
        return "";
    L10:
        if (r100.equals(AppbrandHostConstants.SCHEMA_INSPECT.SESSION) == false) goto L19;
        return (T) Integer.valueOf(this.f390961a);
    L14:
        if (r100.equals("keyword") == false) goto L19;
        return (T) this.f390962b;
    L18:
        if (r100.equals("offset") == false) goto L19;
        return (T) Long.valueOf(this.f390963c);
    }

    @Override // com.obric.assistant.oneshot.api.IOneshotService
    public final void b(long r100, long r101) {
        this.f390964d = r100;
        this.f390965e = r101;
    }

    @Override // com.obric.assistant.oneshot.api.IOneshotService
    public final void i(int r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "keywords");
        FLogger.f375446a.i("OneshotServiceImpl", "setOneshotParams -> " + r100 + ' ' + r101 + ' ' + r102);
        this.f390961a = r100;
        this.f390962b = r101;
        this.f390963c = r102;
    }
}
