package com.obric.assistant.audio.service;

import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H&J\b\u0010\u0006\u001a\u00020\u0003H&J8\u0010\u0007\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J8\u0010\r\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH&¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/audio/service/IObricRealtimeCallStateService;", "", "onRealtimeCallStateChanged", "", "prev", "current", "start", "init", ITTVideoEngineEventSource.KEY_MUTE, "Lkotlin/Function0;", "unMute", "endCall", "stop", "release", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricRealtimeCallStateService {
    void R1();

    void a(Function0<Unit> r100, Function0<Unit> r101, Function0<Unit> r102);

    void b(Function0<Unit> r100, Function0<Unit> r101, Function0<Unit> r102);

    void c(Object r100, Object r101);

    void endCall();

    void mute();

    void start();

    void stop();
}
