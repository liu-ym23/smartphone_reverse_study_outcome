package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.lark.pb.im.v1.SpeechScene;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils$abortUploadAudio$1;
import com.ss.android.lark.keyboard.plugin.tool.voice.processor.RecognizeAudioData$process$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends c0c.b implements IAudioService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IAudioService f409425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f409426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<IAudioService> f409427d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void Jb(String r110, int r111, String r112, String r210, byte[] r211, int r212, String r213, boolean r214, boolean r215, boolean r216, boolean r217, SpeechScene r218, boolean r219, IGetDataCallback r310) {
        this.f409425b.Jb(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void Oc(String r110, int r111, String r112, String r113, byte[] r114, int r210, String r211, boolean r212, boolean r213, boolean r214, boolean r215, RecognizeAudioData$process$1 r216) {
        this.f409425b.Oc(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void S4(String r100, String r101, IGetDataCallback r102) {
        this.f409425b.S4(r100, r101, r102);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final boolean e3(String r100, String r101) {
        return this.f409425b.e3(r100, r101);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final String ec(String r100, String r101, String r102) {
        return this.f409425b.ec(r100, r101, r102);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void jc(String r100, int r101, byte[] r102, boolean r110, IGetDataCallback r111) {
        this.f409425b.jc(r100, r101, r102, r110, r111);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.IAudioService
    public final void xa(String r100, VoiceUtils$abortUploadAudio$1 r101) {
        this.f409425b.xa(r100, r101);
    }

    public j(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<IAudioService> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), IAudioService.class), IAudioService.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f409425b = r103.b();
        this.f409426c = r101;
        this.f409427d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("AudioServiceProxy", "preparing IAudioService");
        com.ss.android.lark.passportc.internal.v r102 = this.f409426c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        IAudioService r104 = (IAudioService) e0c.k.b(r102.c(r103), IAudioService.class);
        this.f409427d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
