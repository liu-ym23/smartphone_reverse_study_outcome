package com.obric.sva.sdk.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0002'(B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u0012H\u0003J\u0018\u0010\u001d\u001a\u00020\u00192\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0003J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\rH\u0003J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u001a\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u0017H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/sva/sdk/audio/WakeupAudioRecordingGuard;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "callback", "Lcom/obric/sva/sdk/audio/WakeupAudioRecordingGuard$Callback;", "callbackDispatcher", "Landroid/os/Handler;", "<init>", "(Landroid/content/Context;Lcom/obric/sva/sdk/audio/WakeupAudioRecordingGuard$Callback;Landroid/os/Handler;)V", "appContext", "kotlin.jvm.PlatformType", "audioManager", "Landroid/media/AudioManager;", "callbackThread", "Landroid/os/HandlerThread;", "callbackHandler", "recordingCallback", "Landroid/media/AudioManager$AudioRecordingCallback;", "pendingSmFullNames", "Ljava/util/LinkedHashSet;", "", "released", "", "waitUntilRecordingReleased", "", "smFullName", "release", "createRecordingCallback", "notifyIfAllRecordersReleased", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "", "Landroid/media/AudioRecordingConfiguration;", "checkCurrentRecordingConfigurations", "manager", "dispatchAllRecordersReleased", "unregisterRecordingCallback", "callbackToUnregister", "quitAfter", "Callback", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupAudioRecordingGuard {
    public static final Companion Companion = null;
    private static final String TAG = "WakeupAudioRecordingGuard";
    private final Context appContext;
    private final AudioManager audioManager;
    private final Callback callback;
    private final Handler callbackDispatcher;
    private final Handler callbackHandler;
    private final HandlerThread callbackThread;
    private final LinkedHashSet<String> pendingSmFullNames;
    private AudioManager.AudioRecordingCallback recordingCallback;
    private volatile boolean released;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/audio/WakeupAudioRecordingGuard$Callback;", "", "onAllRecordersReleased", "", "smFullName", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Callback {
        void onAllRecordersReleased(String r100);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/audio/WakeupAudioRecordingGuard$Companion;", "", "<init>", "()V", "TAG", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(WakeupAudioRecordingGuard r100, boolean r101, AudioManager.AudioRecordingCallback r102) {
        unregisterRecordingCallback$lambda$18(r100, r101, r102);
    }

    public static /* synthetic */ void b(WakeupAudioRecordingGuard r100, String r101) {
        dispatchAllRecordersReleased$lambda$15(r100, r101);
    }

    public final void release() {
        monitor-enter(this);
        this.released = true;     // Catch: Throwable -> L10
        this.pendingSmFullNames.clear();     // Catch: Throwable -> L10
        AudioManager.AudioRecordingCallback r100 = this.recordingCallback;     // Catch: Throwable -> L10
        this.recordingCallback = null;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r100 == null) goto L8;
        unregisterRecordingCallback(r100, true);
        return;
    L8:
        this.callbackThread.quitSafely();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final AudioManager.AudioRecordingCallback createRecordingCallback() {
        return new AnonymousClass1(this);
    }

    private final void checkCurrentRecordingConfigurations(AudioManager r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(r100.getActiveRecordingConfigurations());     // Catch: Throwable -> L4
    L7:
        if (Result.m9456isSuccessimpl(r102) == false) goto L9;
        notifyIfAllRecordersReleased((List) r102);
    L9:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L15;
        LogUtils.e(TAG, "check activeRecordingConfigurations failed: " + r103.getMessage(), new Object[0]);
        return;
    L15:
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void dispatchAllRecordersReleased(final String r100) {
        if (this.callbackDispatcher.post(new c(this, r100)) == true) goto L6;
        LogUtils.w(TAG, "post onAllRecordersReleased failed, smFullName=" + r100, new Object[0]);
        return;
    }

    private final void notifyIfAllRecordersReleased(List<AudioRecordingConfiguration> r100) {
        List<AudioRecordingConfiguration> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L13:
        if (this.pendingSmFullNames.isEmpty() == false) goto L16;
        monitor-exit(this);
        return;
    L16:
        List r103 = CollectionsKt.toList(this.pendingSmFullNames);     // Catch: Throwable -> L26
        this.pendingSmFullNames.clear();     // Catch: Throwable -> L26
        AudioManager.AudioRecordingCallback r104 = this.recordingCallback;     // Catch: Throwable -> L26
        this.recordingCallback = null;     // Catch: Throwable -> L26
        Pair r105 = TuplesKt.to(r104, r103);     // Catch: Throwable -> L26
        monitor-exit(this);
        AudioManager.AudioRecordingCallback r106 = (AudioManager.AudioRecordingCallback) r105.component1();
        List r107 = (List) r105.component2();
        if (r106 == null) goto L21;
        unregisterRecordingCallback$default(this, r106, false, 2, null);
    L21:
        Iterator r108 = r107.iterator();
    L23:
        if (r108.hasNext() == false) goto L25;
        dispatchAllRecordersReleased((String) r108.next());
        goto L23
    L25:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void waitUntilRecordingReleased(String r100) {
        Intrinsics.checkNotNullParameter(r100, "smFullName");
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        LogUtils.d(TAG, "waitUntilRecordingReleased ignored below Android N", new Object[0]);
        return;
    L6:
        AudioManager r101 = this.audioManager;
        if (r101 != null) goto L10;
        LogUtils.d(TAG, "waitUntilRecordingReleased ignored, audioManager is null", new Object[0]);
        return;
    L10:
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L12:
        if (this.released == false) goto L16;
        LogUtils.d(TAG, "waitUntilRecordingReleased ignored, guard released", new Object[0]);     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L16:
        this.pendingSmFullNames.add(r100);     // Catch: Throwable -> L37
        if (this.recordingCallback != null) goto L33;
        AudioManager.AudioRecordingCallback r102 = createRecordingCallback();     // Catch: Throwable -> L37
        this.recordingCallback = r102;     // Catch: Throwable -> L37
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L21
        r101.registerAudioRecordingCallback(r102, this.callbackHandler);     // Catch: Throwable -> L21
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);     // Catch: Throwable -> L37
        if (r105 == null) goto L27;
        LogUtils.e(TAG, "registerAudioRecordingCallback failed: " + r105.getMessage(), new Object[0]);     // Catch: Throwable -> L37
    L27:
        if (Result.m9456isSuccessimpl(r104) == true) goto L33;
        this.pendingSmFullNames.remove(r100);     // Catch: Throwable -> L37
        if (this.recordingCallback != r102) goto L31;
        this.recordingCallback = null;     // Catch: Throwable -> L37
    L31:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L37
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L37
    L33:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(this);
        checkCurrentRecordingConfigurations(r101);
    }

    public static final /* synthetic */ void access$notifyIfAllRecordersReleased(WakeupAudioRecordingGuard r100, List r101) {
        r100.notifyIfAllRecordersReleased(r101);
    }

    private static final void dispatchAllRecordersReleased$lambda$15(WakeupAudioRecordingGuard r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        r100.callback.onAllRecordersReleased(r101);     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L12;
        LogUtils.e(TAG, "onAllRecordersReleased failed: " + r104.getMessage(), new Object[0]);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void unregisterRecordingCallback(final AudioManager.AudioRecordingCallback r100, final boolean r101) {
        Runnable r102 = new b(this, r101, r100);
        if (ThreadMethodProxy.getLooperThread(this.callbackThread.getLooper()) != ThreadMethodProxy.currentThread()) goto L6;
        r102.run();
        return;
    L6:
        if (this.callbackHandler.post(r102) == true) goto L12;
        LogUtils.w(TAG, "post unregisterAudioRecordingCallback failed", new Object[0]);
        if (r101 == false) goto L13;
        this.callbackThread.quitSafely();
        return;
    L13:
        return;
    }

    public WakeupAudioRecordingGuard(Context r100, Callback r101, Handler r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "callbackDispatcher");
        this.callback = r101;
        this.callbackDispatcher = r102;
        Context r103 = r100.getApplicationContext();
        this.appContext = r103;
        Object r104 = r103.getSystemService("audio");
        if ((r104 instanceof AudioManager) == false) goto L5;
        AudioManager r105 = (AudioManager) r104;
    L6:
        this.audioManager = r105;
        PthreadHandlerThreadV2 r106 = new PthreadHandlerThreadV2(TAG);
        ThreadMethodProxy.start(r106);
        this.callbackThread = r106;
        this.callbackHandler = new Handler(r106.getLooper());
        this.pendingSmFullNames = new LinkedHashSet();
        return;
    L5:
        r105 = null;
        goto L6
    }

    private static final void unregisterRecordingCallback$lambda$18(WakeupAudioRecordingGuard r100, boolean r101, AudioManager.AudioRecordingCallback r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        AudioManager r104 = r100.audioManager;     // Catch: Throwable -> L8
        if (r104 == null) goto L5;
        r104.unregisterAudioRecordingCallback(r102);     // Catch: Throwable -> L8
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L8
    L10:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L13;
        LogUtils.e(TAG, "unregisterAudioRecordingCallback failed: " + r107.getMessage(), new Object[0]);
    L13:
        if (r101 == false) goto L18;
        r100.callbackThread.quitSafely();
        return;
    L18:
        return;
    L5:
        r105 = null;
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public /* synthetic */ WakeupAudioRecordingGuard(Context r100, Callback r101, Handler r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = new Handler(Looper.getMainLooper());
    L5:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void unregisterRecordingCallback$default(WakeupAudioRecordingGuard r100, AudioManager.AudioRecordingCallback r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.unregisterRecordingCallback(r101, r102);
    }
}
