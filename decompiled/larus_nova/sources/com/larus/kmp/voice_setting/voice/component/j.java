package com.larus.kmp.voice_setting.voice.component;

/* JADX INFO: loaded from: classes30.dex */
public final class j implements com.larus.kmp.voice_setting.platform.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f352303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.larus.kmp.voice_setting.platform.q0 f352304b;

    @Override // com.larus.kmp.voice_setting.platform.p0
    public final void onBegin() {
        i r100 = this.f352303a;
        String r101 = this.f352304b.f351718a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.b("[preview] begin style=".concat(r101));
    }

    @Override // com.larus.kmp.voice_setting.platform.p0
    public final void onEnd() {
        i r100 = this.f352303a;
        String r101 = this.f352304b.f351718a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.b("[preview] end style=".concat(r101));
        i.c(this.f352303a, VoiceDialogActionKind.PREVIEW_PLAYBACK_ENDED, 0, false, null, null, null, null, null, 254);
    }

    @Override // com.larus.kmp.voice_setting.platform.p0
    public final void onError() {
        i r100 = this.f352303a;
        String r101 = this.f352304b.f351718a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.b("[preview] error style=".concat(r101));
        i.c(this.f352303a, VoiceDialogActionKind.PREVIEW_PLAYBACK_ENDED, 0, false, null, null, null, null, null, 254);
    }

    public j(i r100, com.larus.kmp.voice_setting.platform.q0 r101) {
        this.f352303a = r100;
        this.f352304b = r101;
    }
}
