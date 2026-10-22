package com.larus.voice_setting.voice.editvoice;

/* JADX INFO: loaded from: classes32.dex */
public final class x0 implements com.larus.common_ui.dialog.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpeakerVoiceEditModel f376823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f376824b;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        this.f376823a.e(this.f376824b);
    }

    public x0(SpeakerVoiceEditModel r100) {
        this.f376823a = r100;
        this.f376824b = "from_mix";
    }
}
