package com.larus.audioplayer.impl.observer;

import com.larus.apm.api.IApmTrace;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.IGlobalAudioObserver;
import com.larus.utils.logger.FLogger;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o78.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J.\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016J.\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016J.\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016J)\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/audioplayer/impl/observer/GlobalAudioObserverImpl;", "Lcom/larus/audio/observer/IGlobalAudioObserver;", "<init>", "()V", "mObserveCallbackList", "", "Lcom/larus/audio/observer/IGlobalAudioObserveCallback;", MiPushClient.COMMAND_REGISTER, "", "callback", MiPushClient.COMMAND_UNREGISTER, "sendPrePlayTriggeredEvent", "scene", "", "uniId", "bizExtra", "", "sendPlayTriggeredEvent", "sendPlaybackStateChangedEvent", "playbackState", "Lcom/larus/audio/controller/GlobalAudioStateEnum;", "sendErrorEvent", "code", "", "internalCode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlobalAudioObserverImpl implements IGlobalAudioObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f290368a;

    public GlobalAudioObserverImpl() {
        this.f290368a = new ArrayList();
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final synchronized void a(b r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "callback");     // Catch: Throwable -> L6
        ((ArrayList) this.f290368a).remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final synchronized void b(b r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "callback");     // Catch: Throwable -> L10
        if (((ArrayList) this.f290368a).contains(r100) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        ((ArrayList) this.f290368a).add(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void d(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(GlobalAudioSceneEnum.TTS_IM, "scene");
        Intrinsics.checkNotNullParameter(r100, "uniId");
        FLogger.f375446a.j("GlobalAudioObserverImpl", "Music play onPrePlayTriggered: scene=tts_im");
        Iterator r102 = new CopyOnWriteArrayList(this.f290368a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((b) r102.next()).c(r100, r101);
        goto L4
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void c(String r100, GlobalAudioStateEnum r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "playbackState");
        FLogger.f375446a.j("GlobalAudioObserverImpl", "Music play onPlayTriggered: scene=" + r100 + ",playbackState=" + r101);
        if (r101 != GlobalAudioStateEnum.PLAYING) goto L5;
        IApmTrace.f286937a.g("MUSIC_PLAY");
    L6:
        Iterator r103 = new CopyOnWriteArrayList(this.f290368a).iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((b) r103.next()).a(r100, r101, r102);
        goto L8
    L10:
        return;
    L5:
        IApmTrace.f286937a.e("MUSIC_PLAY");
        goto L6
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void e(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "uniId");
        FLogger.f375446a.j("GlobalAudioObserverImpl", "Music play onPlayTriggered: scene=" + r100);
        Iterator r103 = new CopyOnWriteArrayList(this.f290368a).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((b) r103.next()).d(r100, r101, r102);
        goto L4
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void f(String r100, Integer r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        FLogger.f375446a.j("GlobalAudioObserverImpl", "Music play onError: scene=" + r100 + ", code=" + r101 + ", internalCode=" + r102);
        Iterator r103 = new CopyOnWriteArrayList(this.f290368a).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((b) r103.next()).b(r100, r101, r102);
        goto L4
    }
}
