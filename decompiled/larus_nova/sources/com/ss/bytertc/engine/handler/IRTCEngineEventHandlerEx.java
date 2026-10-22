package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.type.FirstFramePlayState;
import com.ss.bytertc.engine.type.FirstFrameSendState;
import com.ss.bytertc.engine.type.LocalStreamStats;
import com.ss.bytertc.engine.type.PerformanceAlarmMode;
import com.ss.bytertc.engine.type.PerformanceAlarmReason;
import com.ss.bytertc.engine.type.RemoteStreamStats;
import com.ss.bytertc.engine.type.RemoteStreamSwitch;
import com.ss.bytertc.engine.type.SourceWantedData;

/* JADX INFO: loaded from: classes40.dex */
public abstract class IRTCEngineEventHandlerEx {
    public IRTCEngineEventHandlerEx() {
    }

    public void onAudioFramePlayStateChanged(StreamKey r100, String r101, FirstFramePlayState r102) {
    }

    public void onAudioFrameSendStateChanged(StreamKey r100, String r101, FirstFrameSendState r102) {
    }

    public void onLocalStreamStats(StreamIndex r100, LocalStreamStats r101) {
    }

    public void onPerformanceAlarms(StreamIndex r100, PerformanceAlarmMode r101, PerformanceAlarmReason r102, SourceWantedData r103) {
    }

    public void onRemoteStreamStats(StreamKey r100, RemoteStreamStats r101) {
    }

    public void onSimulcastSubscribeFallback(StreamKey r100, RemoteStreamSwitch r101) {
    }

    public void onVideoFramePlayStateChanged(StreamKey r100, String r101, FirstFramePlayState r102) {
    }

    public void onVideoFrameSendStateChanged(StreamKey r100, String r101, FirstFrameSendState r102) {
    }
}
