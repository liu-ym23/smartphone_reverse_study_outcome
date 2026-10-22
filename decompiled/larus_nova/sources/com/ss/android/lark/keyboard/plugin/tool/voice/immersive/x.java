package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chat.api.service.IChatService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAudioService f430714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.service.l f430715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.service.o f430716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f430717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Fragment f430718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IChatService f430719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qob.a f430720g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f430714a, r101.f430714a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f430715b, r101.f430715b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f430716c, r101.f430716c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f430717d, r101.f430717d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f430718e, r101.f430718e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f430719f, r101.f430719f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(null, null) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f430720g, r101.f430720g) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f430714a.hashCode() * 31) + this.f430715b.hashCode()) * 31) + this.f430716c.hashCode()) * 31;
        Activity r101 = this.f430717d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Fragment r105 = this.f430718e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        IChatService r108 = this.f430719f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + 0) * 31;
        qob.a r111 = this.f430720g;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImmersiveVoiceInputDependency(audioService=" + this.f430714a + ", newAudio2TextPush=" + this.f430715b + ", speechRecognitionEventPush=" + this.f430716c + ", hostActivity=" + this.f430717d + ", hostFragment=" + this.f430718e + ", chatService=" + this.f430719f + ", mentionDependency=null, oldIAudioDataProcessorDependency=" + this.f430720g + ')';
    }

    public /* synthetic */ x(IAudioService r100, com.ss.android.lark.audio.voiceinput.service.l r110, com.ss.android.lark.audio.voiceinput.service.o r111, Activity r112, Fragment r113) {
        this(r100, r110, r111, r112, r113, null, null);
    }

    public x(IAudioService r100, com.ss.android.lark.audio.voiceinput.service.l r101, com.ss.android.lark.audio.voiceinput.service.o r102, Activity r103, Fragment r104, IChatService r105, qob.a r106) {
        Intrinsics.checkNotNullParameter(r100, "audioService");
        Intrinsics.checkNotNullParameter(r101, "newAudio2TextPush");
        Intrinsics.checkNotNullParameter(r102, "speechRecognitionEventPush");
        this.f430714a = r100;
        this.f430715b = r101;
        this.f430716c = r102;
        this.f430717d = r103;
        this.f430718e = r104;
        this.f430719f = r105;
        this.f430720g = r106;
    }
}
