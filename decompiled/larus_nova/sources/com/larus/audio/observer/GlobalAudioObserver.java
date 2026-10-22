package com.larus.audio.observer;

import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o78.a;
import o78.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J.\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0016J.\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0016J.\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013H\u0016J+\u0010\u0018\u001a\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001cR\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/larus/audio/observer/GlobalAudioObserver;", "Lcom/larus/audio/observer/IGlobalAudioObserver;", "<init>", "()V", "mGlobalAudioObserverImpl", "getMGlobalAudioObserverImpl", "()Lcom/larus/audio/observer/IGlobalAudioObserver;", "mGlobalAudioObserverImpl$delegate", "Lkotlin/Lazy;", MiPushClient.COMMAND_REGISTER, "", "callback", "Lcom/larus/audio/observer/IGlobalAudioObserveCallback;", MiPushClient.COMMAND_UNREGISTER, "sendPrePlayTriggeredEvent", "scene", "", "uniId", "bizExtra", "", "sendPlayTriggeredEvent", "sendPlaybackStateChangedEvent", "playbackState", "Lcom/larus/audio/controller/GlobalAudioStateEnum;", "sendErrorEvent", "code", "", "internalCode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlobalAudioObserver implements IGlobalAudioObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GlobalAudioObserver f289772a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f289773b = null;

    private GlobalAudioObserver() {
    }

    static {
        f289772a = new GlobalAudioObserver();
        f289773b = LazyKt.lazy(new a());
    }

    public static IGlobalAudioObserver g() {
        return (IGlobalAudioObserver) f289773b.getValue();
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IGlobalAudioObserver r101 = g();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IGlobalAudioObserver r101 = g();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void d(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(GlobalAudioSceneEnum.TTS_IM, "scene");
        Intrinsics.checkNotNullParameter(r100, "uniId");
        IGlobalAudioObserver r102 = g();
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void c(String r100, GlobalAudioStateEnum r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "playbackState");
        IGlobalAudioObserver r103 = g();
        if (r103 == null) goto L6;
        r103.c(r100, r101, r102);
        return;
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void e(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "uniId");
        IGlobalAudioObserver r103 = g();
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }

    @Override // com.larus.audio.observer.IGlobalAudioObserver
    public final void f(@GlobalAudioSceneEnum String r100, Integer r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IGlobalAudioObserver r103 = g();
        if (r103 == null) goto L6;
        r103.f(r100, r101, r102);
        return;
    }
}
