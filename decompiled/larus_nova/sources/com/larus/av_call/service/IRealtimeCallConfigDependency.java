package com.larus.av_call.service;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u000eH&J\b\u0010\u0013\u001a\u00020\u000eH&J\b\u0010\u0014\u001a\u00020\u000eH&J\b\u0010\u0015\u001a\u00020\u000eH&J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH&J\b\u0010\u0018\u001a\u00020\u000eH&J\b\u0010\u0019\u001a\u00020\u000eH&J\b\u0010\u001a\u001a\u00020\u000eH&J\b\u0010\u001b\u001a\u00020\u000eH&J\b\u0010\u001c\u001a\u00020\u000eH&J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH&J\b\u0010\u001f\u001a\u00020\u0010H&J\b\u0010 \u001a\u00020\u000eH&J\b\u0010!\u001a\u00020\u000eH&J\b\u0010\"\u001a\u00020\u000eH&J\b\u0010#\u001a\u00020\u000eH&J\n\u0010$\u001a\u0004\u0018\u00010\u0007H&¨\u0006%"}, d2 = {"Lcom/larus/av_call/service/IRealtimeCallConfigDependency;", "", "createRealtimeCallParam", "Lcom/larus/audio/call/RealtimeCallParam;", "argumentData", "Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "localCallId", "", DBDefinition.TASK_ID, "avSessionType", "Lcom/larus/im/service/audio/AudioSessionType;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "isMainBotType", "", "type", "", "isRtcEnable", "isRtcNewConnEnable", "isSupportScene", "subtitleUseCC", "enableAudioBgSimpleColor", "enableRealtimeCallTakePhoto", "isMainBot", "isVideoEnable", "isScreenShareEnable", "enableRecord", "isAutoInterrupt", "useNewTitleBarUI", "useDoubleLineCallUI", "showThinkingStatus", "audioAnimRenderFps", "isTakePhotoEnable", "isRealtimeDowngradeEnable", "useSpringSceneIcon", "isInScene", "trafficDegradationCallDisableCn", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IRealtimeCallConfigDependency {
    int d();

    boolean e();

    boolean enableAudioBgSimpleColor();

    boolean enableRecord();

    boolean f();

    boolean g();

    boolean h();

    boolean i();

    boolean j();

    String k();

    boolean l(boolean r100);

    boolean m();

    boolean n();

    boolean o();

    boolean p();

    boolean q();

    boolean r();

    boolean s();
}
