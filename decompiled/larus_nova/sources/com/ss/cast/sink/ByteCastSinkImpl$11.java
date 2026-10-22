package com.ss.cast.sink;

import com.byted.cast.common.Logger;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.api.CodecType;
import com.byted.cast.common.sink.CastInfo;
import com.byted.cast.common.sink.IMirrorListener;
import com.byted.cast.common.sink.Statistics;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class ByteCastSinkImpl$11 implements IMirrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IMirrorListener f456418a;

    public ByteCastSinkImpl$11(com.larus.dora.dorag.res.k r100) {
        this.f456418a = r100;
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onInviteResult(boolean r100) {
        this.f456418a.onInviteResult(r100);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onStatistics(Statistics r100) {
        this.f456418a.onStatistics(r100);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onCast(int r100, CastInfo r101) {
        this.f456418a.onCast(r100, r101);
        if (r101 != null) goto L5;
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.castType == 2) goto L13;
        return;
    L13:
        if (r101.infoType != 108) goto L18;
        TeaEventTrack.getInstance().trackSinkReceiverPlay(r101.protocol, "success");
        return;
    L18:
        return;
    L5:
        if (r101.castType != 2) goto L9;
        if (r101.infoType != 100) goto L9;
        TeaEventTrack.getInstance().trackSinkReceiverCast(Boolean.FALSE, r101.protocol);
        TeaEventTrack.getInstance().trackSinkReceiverPlay(r101.protocol, "start");
        goto L9
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onVolume(String r100, int r101) {
        this.f456418a.onVolume(r100, r101);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onError(String r100, final int r101, final String r102) {
        this.f456418a.onError(r100, r101, r102);
        TeaEventTrack.getInstance().trackSinkEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_PLAY_PROTOCOL, new Map[]{new AnonymousClass1(this, r102, r101)});
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onNotifyLatency(String r100, Long r101, HashMap<String, Long> r102) {
        this.f456418a.onNotifyLatency(r100, r101, r102);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onSinkLatencyStat(int r100, String r101, String r102) {
        this.f456418a.onSinkStuckStat(r100, r101, r102);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onSinkStuckStat(int r100, String r101, String r102) {
        this.f456418a.onSinkStuckStat(r100, r101, r102);
        final JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L5
        TeaEventTrack.getInstance().trackSinkEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_LATENCY_TIME, new Map[]{new AnonymousClass2(this, r103)});     // Catch: JSONException -> L5
        TeaEventTrack.getInstance().trackSinkEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_MINUTE_CATON, new Map[]{new AnonymousClass3(this, r103)});     // Catch: JSONException -> L5
        TeaEventTrack.getInstance().trackSinkEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_MINUTE_CATON_TIME, new Map[]{new AnonymousClass4(this, r103)});     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        Logger.d("ByteCastSinkImpl", "onSinkStuckStat JSONException:" + e.getMessage());
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onVideoOutput(String r110, CodecType.VCODEC_ID r111, byte[] r112, int r113, int r114, long r115, int r116) {
        this.f456418a.onVideoOutput(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.byted.cast.common.sink.IMirrorListener
    public final void onAudioOutput(String r110, CodecType.ACODEC_ID r111, byte[] r112, int r113, int r114, int r115, int r116, long r117) {
        this.f456418a.onAudioOutput(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
