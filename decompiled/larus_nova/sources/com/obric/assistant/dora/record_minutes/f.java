package com.obric.assistant.dora.record_minutes;

import com.larus.utils.logger.FLogger;
import com.mammon.speechaudiosdk.session.callback.SpeechRecorderAudioConsumerCallback;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerCallbackParam;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements SpeechRecorderAudioConsumerCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraRecordMinutesService.d f389187a;

    public f(DoraRecordMinutesService.d r100) {
        this.f389187a = r100;
    }

    @Override // com.mammon.speechaudiosdk.session.callback.SpeechRecorderAudioConsumerCallback
    public final void onCallback(SpeechRecorderAudioConsumerCallbackParam r100) {
        Integer r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.msgType);
    L6:
        boolean r103 = true;
        if (r102 != null) goto L10;
    L12:
        if (r102 != null) goto L15;
    L17:
        if (r102 != null) goto L20;
    L35:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("pcm capture consumer unknown msg, wakeId=");
        r105.append(this.f389187a.f389155a);
        r105.append(", msgType=");
        if (r100 == null) goto L38;
        r101 = Integer.valueOf(r100.msgType);
    L38:
        r105.append(r101);
        r104.w("DoraRecordMinutesService", r105.toString());
        return;
    L20:
        if (r102.intValue() != 5000) goto L35;
        DoraRecordMinutesService.d r106 = this.f389187a;
        byte[] r107 = r100.audioData;
        r106.getClass();
        if (r107 != null) goto L25;
        return;
    L25:
        if (r107.length == 0) goto L28;
        r103 = false;
    L28:
        if (r103 == false) goto L30;
        return;
    L30:
        if (r106.f389160f.get() == true) goto L32;
        return;
    L32:
        if (r106.f389161g.get() == true) goto L46;
        r106.f389157c.a(r107, r106.f389156b);
        return;
    L46:
        return;
    L15:
        if (r102.intValue() != 2) goto L17;
        FLogger.f375446a.i("DoraRecordMinutesService", "pcm capture consumer stop, wakeId=" + this.f389187a.f389155a + ", sessionId=" + r100.sessionId);
        this.f389187a.f389157c.onStopped();
        return;
    L10:
        if (r102.intValue() != 1) goto L12;
        FLogger.f375446a.i("DoraRecordMinutesService", "pcm capture consumer start, wakeId=" + this.f389187a.f389155a + ", sessionId=" + r100.sessionId);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
