package com.larus.kmp.voice_setting.platform;

import com.larus.audio.quality.AudioCheckerResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t implements p78.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<r0, Unit> f351730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f351731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<byte[], Unit> f351732c;

    @Override // p78.a
    public final void a(String r100) {
        this.f351731b.invoke(r100);
    }

    @Override // p78.a
    public final void b(p78.b r100) {
        Intrinsics.checkNotNullParameter(r100, "checkAudioQualityResult");
        Function1<r0, Unit> r101 = this.f351730a;
        AudioCheckerResult r102 = r100.f528048a;
        int r103 = -1;
        if (r102 != null) goto L5;
        int r104 = -1;
    L7:
        if (r104 != 1) goto L9;
        VoiceQualityStatus r105 = VoiceQualityStatus.PASSED;
    L13:
        AudioCheckerResult r106 = r100.f528048a;
        if (r106 == null) goto L17;
        String r107 = r106.name();
        if (r107 == null) goto L17;
    L18:
        String r108 = String.valueOf(r100.f528049b);
        AudioCheckerResult r109 = r100.f528048a;
        if (r109 == null) goto L22;
        r103 = o0.a.f351710a[r109.ordinal()];
    L22:
        switch(r103) {
            case -1: goto L33;
            case 0: goto L24;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            default: goto L24;
        };
    L25:
        String r110 = "SAMIInitMetricError_" + r100.f528049b;
    L34:
        r101.invoke(new r0(r105, r107, r108, r110));
        return;
    L26:
        r110 = "SAMIInitConfigError_" + r100.f528049b;
        goto L34
    L27:
        r110 = "SAMIWERFailed_" + r100.f528049b;
        goto L34
    L28:
        r110 = "SAMISNRFailed_" + r100.f528049b;
        goto L34
    L29:
        r110 = "SAMINetworkError_" + r100.f528049b;
        goto L34
    L30:
        r110 = "SAMIInternalError_" + r100.f528049b;
        goto L34
    L31:
        r110 = "AudioRecordSilenced";
        goto L34
    L32:
        r110 = "Passed";
        goto L34
    L33:
        r110 = "Unknown";
        goto L34
    L24:
        throw new NoWhenBranchMatchedException();
    L17:
        r107 = "null";
        goto L18
    L9:
        if (r104 == 2) goto L11;
        r105 = VoiceQualityStatus.OTHER_FAILURE;
        goto L13
    L11:
        r105 = VoiceQualityStatus.AUDIO_RECORD_SILENCED;
        goto L13
    L5:
        r104 = o0.a.f351710a[r102.ordinal()];
        goto L7
    }

    @Override // p78.a
    public final void c(byte[] r100) {
        this.f351732c.invoke(r100);
    }

    public t(com.larus.kmp.voice_setting.voice.component.k r100, com.larus.kmp.voice_setting.voice.component.l r101, com.larus.kmp.voice_setting.voice.component.m r102) {
        this.f351730a = r100;
        this.f351731b = r101;
        this.f351732c = r102;
    }
}
