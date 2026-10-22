package com.bytedance.ee.bear.middleground.audio;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements com.ss.android.lark.audio.voiceinput.h {
    public f() {
    }

    @Override // com.ss.android.lark.audio.voiceinput.h
    public final void a() {
        tt5.a.h("AudioRecordSdk", "initAudioRecord(), releaseMediaResource()");
    }

    @Override // com.ss.android.lark.audio.voiceinput.h
    public final boolean b() {
        tt5.a.h("AudioRecordSdk", "initAudioRecord(),tryOccupyResource()");
        return true;
    }
}
