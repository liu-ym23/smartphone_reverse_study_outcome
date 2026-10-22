package com.larus.audioplayer.api.news;

import b88.a;
import b88.d;
import com.larus.platform.api.l0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J-\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\fJ/\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J-\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\u0005H&J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0014\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\tH&J\b\u0010\u001f\u001a\u00020\u0005H&JA\u0010 \u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H&¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u001dH&J\b\u0010&\u001a\u00020\u001dH&J\b\u0010'\u001a\u00020\u0011H&J\b\u0010(\u001a\u00020\u0016H&¨\u0006)"}, d2 = {"Lcom/larus/audioplayer/api/news/INewsUrlAudioManager;", "", "getCurrentUrlData", "Lcom/larus/audioplayer/api/news/NewsAudioData;", "getCurrentAudioStatus", "", "getAudioStatus", "Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "targetUrl", "", "sourceType", "videoModel", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "getAudioPausedReason", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "getCurrentScene", "playAudio", "", "urlData", "callback", "Lcom/larus/audioplayer/api/news/IUrlAudioPlayCallback;", "pauseAudio", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Z", "stopAudio", "getAudioDuration", "setAudioPlaySpeed", "scene", "speed", "", "getAudioPlaySpeed", "getAudioCurrentPlaybackTime", "setAudioCurrentPlaybackTime", "playbackTime", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/larus/platform/api/IFlowSeekCompletionListener;)Z", "getSystemVolume", "getSystemMaxVolume", "dismissPlayService", "isLoadStalled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INewsUrlAudioManager {
    String a(String r100, Integer r101, String r102);

    boolean b(String r100, Integer r101, String r102, int r103, l0 r104);

    d c();

    boolean d(String r100, Integer r101, String r102);

    boolean e(String r100, float r101);

    int f();

    boolean g(String r100, Integer r101, String r102);

    int getAudioDuration();

    UrlAudioPlayStatus h(String r100, Integer r101, String r102);

    void i(d r100, a r101);

    float j(String r100);
}
