package com.obric.assistant.interaction.base.util;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u001dJ\u0006\u0010#\u001a\u00020\u001dJ\u0006\u0010$\u001a\u00020\u001dJ\u0010\u0010%\u001a\u00020\u00112\b\b\u0001\u0010&\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u001dJ\u0018\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0011J\u001e\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00072\u0006\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0011J&\u00105\u001a\u00020\u00112\b\b\u0001\u0010&\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\t2\b\b\u0002\u00103\u001a\u00020\u0011H\u0002J \u00106\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00072\u0006\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010)\u001a\n +*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-¨\u00067"}, d2 = {"Lcom/obric/assistant/interaction/base/util/SoundEffectHelper;", "", "<init>", "()V", "TAG", "", "SOUND_NOT_LOADED", "", "DEFAULT_VOLUME", "", "playingSoundId", "NUM_MEDIA_SOUND_STREAMS", "defaultRawResIds", "", "soundIdToPlayVolume", "loopingStreamId", "shouldLoopToPlay", "", "rawResToSoundId", "Ljava/util/concurrent/ConcurrentHashMap;", "SOUND_EFFECT_WAKE_UP", "SOUND_EFFECT_THINKING", "SOUND_EFFECT_DEACTIVATE", "SOUND_EFFECT_WARNING", "SOUND_EFFECT_RELEASE", "SOUND_EFFECT_LISTENING", "SOUND_EFFECT_EXIT", "SOUND_EFFECT_CALLUSER_CLARIFY_NOTIFY", "playActivate", "", "playRelease", "playSendMessage", "playDeactivate", "playWarning", "playListening", "playExit", "playCallUserClarifyNotify", "playWakeupRaw", "resId", "loadCompleteListener", "Landroid/media/SoundPool$OnLoadCompleteListener;", "soundPool", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "getSoundPool", "()Landroid/media/SoundPool;", "soundPool$delegate", "Lkotlin/Lazy;", "stopAsync", "play", "soundId", "loop", ITTVideoEngineEventSource.KEY_VOLUME, "playRawRes", "playSound", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SoundEffectHelper {
    private static final float DEFAULT_VOLUME = 1.0f;
    public static final SoundEffectHelper INSTANCE = null;
    private static final int NUM_MEDIA_SOUND_STREAMS = 2;
    private static final int SOUND_EFFECT_CALLUSER_CLARIFY_NOTIFY = 7;
    private static final int SOUND_EFFECT_DEACTIVATE = 2;
    private static final int SOUND_EFFECT_EXIT = 6;
    private static final int SOUND_EFFECT_LISTENING = 5;
    private static final int SOUND_EFFECT_RELEASE = 4;
    private static final int SOUND_EFFECT_THINKING = 1;
    private static final int SOUND_EFFECT_WAKE_UP = 0;
    private static final int SOUND_EFFECT_WARNING = 3;
    private static final int SOUND_NOT_LOADED = -1;
    private static final String TAG = "SoundEffectHelper";
    private static final List<Integer> defaultRawResIds = null;
    private static final SoundPool.OnLoadCompleteListener loadCompleteListener = null;
    private static int loopingStreamId;
    private static int playingSoundId;
    private static final ConcurrentHashMap<Integer, Integer> rawResToSoundId = null;
    private static boolean shouldLoopToPlay;
    private static volatile float soundIdToPlayVolume;
    private static final Lazy soundPool$delegate = null;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.base.util.SoundEffectHelper$stopAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.base.util.SoundEffectHelper$stopAsync$1", f = "SoundEffectHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            if (SoundEffectHelper.access$getLoopingStreamId$p() == 0) goto L8;
            SoundEffectHelper.access$getSoundPool(SoundEffectHelper.INSTANCE).stop(SoundEffectHelper.access$getLoopingStreamId$p());
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private SoundEffectHelper() {
    }

    public static /* synthetic */ void a(SoundPool r100, int r101, int r102) {
        loadCompleteListener$lambda$2(r100, r101, r102);
    }

    public static /* synthetic */ SoundPool b() {
        return soundPool_delegate$lambda$3();
    }

    public final void stopAsync() {
        playingSoundId = -1;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    static {
        SoundEffectHelper r100 = new SoundEffectHelper();
        INSTANCE = r100;
        playingSoundId = -1;
        defaultRawResIds = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.raw.sound_effect_assistant_wake_up), Integer.valueOf(R.raw.sound_effect_assistant_thinking), Integer.valueOf(R.raw.sound_effect_assistant_deactivate), Integer.valueOf(R.raw.sound_effect_assistant_warning), Integer.valueOf(R.raw.sound_effect_assistant_release), Integer.valueOf(R.raw.sound_effect_assistant_listening), Integer.valueOf(R.raw.sound_effect_assistant_exit), Integer.valueOf(R.raw.sound_effect_calluser_clarify_notify)});
        soundIdToPlayVolume = 1.0f;
        rawResToSoundId = new ConcurrentHashMap();
        SoundPool.OnLoadCompleteListener r101 = new a();
        loadCompleteListener = r101;
        soundPool$delegate = LazyKt.lazy(new b());
        r100.getSoundPool().setOnLoadCompleteListener(r101);
    }

    private final SoundPool getSoundPool() {
        return (SoundPool) soundPool$delegate.getValue();
    }

    private static final SoundPool soundPool_delegate$lambda$3() {
        SoundPool.Builder r100 = new SoundPool.Builder().setMaxStreams(2);
        AudioAttributes.Builder r101 = new AudioAttributes.Builder();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r102 = 16;
    L7:
        return r100.setAudioAttributes(r101.setUsage(r102).setContentType(1).build()).build();
    L5:
        r102 = 5;
        goto L7
    }

    public final void playActivate() {
        FLogger.f375446a.d(TAG, "play sound:playActivate");
        play$default(this, 0, false, 2, null);
    }

    public final void playCallUserClarifyNotify() {
        FLogger.f375446a.d(TAG, "play sound:playCallUserClarifyNotify");
        play$default(this, 7, false, 2, null);
    }

    public final void playDeactivate() {
        FLogger.f375446a.d(TAG, "play sound:playDeactivate");
        play$default(this, 2, false, 2, null);
    }

    public final void playExit() {
        FLogger.f375446a.d(TAG, "play sound:playExit");
        play$default(this, 6, false, 2, null);
    }

    public final void playListening() {
        FLogger.f375446a.d(TAG, "play sound:playListening");
        play$default(this, 5, false, 2, null);
    }

    public final void playRelease() {
        FLogger.f375446a.d(TAG, "play sound:playRelease");
        play$default(this, 4, false, 2, null);
    }

    public final void playSendMessage() {
        FLogger.f375446a.d(TAG, "play sound:playSendMessage");
        play$default(this, 1, false, 2, null);
    }

    public final void playWarning() {
        FLogger.f375446a.d(TAG, "play sound:playWarning");
        play$default(this, 3, false, 2, null);
    }

    public static final /* synthetic */ int access$getLoopingStreamId$p() {
        return loopingStreamId;
    }

    public static final /* synthetic */ SoundPool access$getSoundPool(SoundEffectHelper r100) {
        return r100.getSoundPool();
    }

    public final boolean playWakeupRaw(int r110) {
        FLogger.f375446a.d(TAG, "play sound:playWakeupRaw resId=" + r110);
        return playRawRes$default(this, r110, 0.0f, false, 6, null);
    }

    public final synchronized void play(int r100, boolean r101) {
        monitor-enter(this);
        play(r100, 1.0f, r101);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static final void loadCompleteListener$lambda$2(SoundPool r100, int r101, int r102) {
        FLogger r103 = FLogger.f375446a;
        r103.e(TAG, "OnLoadCompleteListener sampleId = " + r101 + " status = " + r102 + ", playingSoundId = " + playingSoundId);
        if (r102 == 0) goto L5;
        r103.e(TAG, "Unable to load sound for playback (status: " + r102 + ')');
        ConcurrentHashMap<Integer, Integer> r104 = rawResToSoundId;
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Integer>> r106 = r104.entrySet().iterator();
    L9:
        if (r106.hasNext() == false) goto L16;
        Map.Entry<Integer, Integer> r107 = r106.next();
        if (r107.getValue().intValue() != r101) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L9;
        r105.put(r107.getKey(), r107.getValue());
        goto L9
    L13:
        r108 = false;
        goto L14
    L16:
        Iterator r109 = r105.keySet().iterator();
    L18:
        if (r109.hasNext() == false) goto L28;
        rawResToSoundId.remove(Integer.valueOf(((Number) r109.next()).intValue()));
        goto L18
    L28:
        return;
    L5:
        if (playingSoundId != r101) goto L20;
        INSTANCE.playSound(r101, soundIdToPlayVolume, shouldLoopToPlay);
        soundIdToPlayVolume = 1.0f;
        return;
    }

    private final synchronized boolean playRawRes(int r110, float r111, boolean r112) {
        monitor-enter(this);
        ConcurrentHashMap<Integer, Integer> r100 = rawResToSoundId;     // Catch: Throwable -> L20
        Integer r101 = r100.get(Integer.valueOf(r110));     // Catch: Throwable -> L20
        if (r101 == null) goto L7;
        int r102 = r101.intValue();     // Catch: Throwable -> L20
    L9:
        if (r102 != (-1)) goto L17;
        FLogger r103 = FLogger.f375446a;     // Catch: Throwable -> L20
        r103.i(TAG, "raw res " + r110 + " not loaded");     // Catch: Throwable -> L20
        int r104 = getSoundPool().load(AppHost.f326268a.getApplication(), r110, 1);     // Catch: Throwable -> L20
        playingSoundId = r104;     // Catch: Throwable -> L20
        if (r104 != 0) goto L16;
        r103.e(TAG, "soundPool load failed, resId=" + r110);     // Catch: Throwable -> L20
        playingSoundId = -1;     // Catch: Throwable -> L20
        monitor-exit(this);
        return false;
    L16:
        r100.put(Integer.valueOf(r110), Integer.valueOf(playingSoundId));     // Catch: Throwable -> L20
        soundIdToPlayVolume = r111;     // Catch: Throwable -> L20
        shouldLoopToPlay = r112;     // Catch: Throwable -> L20
        r103.e(TAG, "sound id to play with not loaded , need wait load complete = " + playingSoundId);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return true;
    L17:
        playingSoundId = r102;     // Catch: Throwable -> L20
        FLogger.f375446a.i(TAG, "sound id to play with loaded = " + playingSoundId);     // Catch: Throwable -> L20
        playSound(r102, r111, r112);     // Catch: Throwable -> L20
        goto L18
    L7:
        r102 = -1;
    L20:
        th = move-exception;
        throw th;
    }

    private final synchronized void playSound(int r110, float r111, boolean r112) {
        monitor-enter(this);
        FLogger r100 = FLogger.f375446a;     // Catch: Throwable -> L18
        r100.i(TAG, "playSound soundId = " + r110 + ", playingSoundId = " + playingSoundId + ", loop = " + r112);     // Catch: Throwable -> L18
        if (r110 == playingSoundId) goto L8;
        monitor-exit(this);
        return;
    L8:
        r100.i(TAG, "do play sound id = " + r110);     // Catch: Throwable -> L18
        SoundPool r101 = getSoundPool();     // Catch: Throwable -> L18
        int r102 = 0;
        if (r112 == false) goto L11;
        int r103 = -1;
    L12:
        int r113 = r101.play(r110, r111, r111, 0, r103, 1.0f);     // Catch: Throwable -> L18
        if (r112 == false) goto L15;
        r102 = r113;
    L15:
        loopingStreamId = r102;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L11:
        r103 = 0;
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized void play(int r100, float r101, boolean r102) {
        monitor-enter(this);
        Integer r103 = (Integer) CollectionsKt.getOrNull(defaultRawResIds, r100);     // Catch: Throwable -> L11
        if (r103 == null) goto L10;
        playRawRes(r103.intValue(), r101, r102);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L10:
        throw new RuntimeException("Unknown sound requested: " + r100);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void play$default(SoundEffectHelper r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        r100.play(r101, r102);
    }

    public static /* synthetic */ boolean playRawRes$default(SoundEffectHelper r100, int r101, float r102, boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 1.0f;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        return r100.playRawRes(r101, r102, r103);
    }
}
