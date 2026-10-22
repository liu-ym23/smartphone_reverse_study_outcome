package com.larus.audio.observer;

import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Map;
import kotlin.Metadata;
import o78.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J2\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\fH&J2\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\fH&J2\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\fH&J+\u0010\u0011\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/audio/observer/IGlobalAudioObserver;", "", MiPushClient.COMMAND_REGISTER, "", "callback", "Lcom/larus/audio/observer/IGlobalAudioObserveCallback;", MiPushClient.COMMAND_UNREGISTER, "sendPrePlayTriggeredEvent", "scene", "", "uniId", "bizExtra", "", "sendPlayTriggeredEvent", "sendPlaybackStateChangedEvent", "playbackState", "Lcom/larus/audio/controller/GlobalAudioStateEnum;", "sendErrorEvent", "code", "", "internalCode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IGlobalAudioObserver {
    void a(b r100);

    void b(b r100);

    void c(@GlobalAudioSceneEnum String r100, GlobalAudioStateEnum r101, Map<String, String> r102);

    void d(String r100, Map r101);

    void e(@GlobalAudioSceneEnum String r100, String r101, Map<String, String> r102);

    void f(@GlobalAudioSceneEnum String r100, Integer r101, Integer r102);
}
