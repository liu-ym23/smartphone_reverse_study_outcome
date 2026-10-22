package com.ss.android.lark.audio.voiceinput.processor;

import com.ss.android.lark.audio.voiceinput.VoiceInputSpeechScene;
import com.ss.android.lark.audio.voiceinput.i;
import com.ss.android.lark.audio.voiceinput.j;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.l;
import com.ss.android.lark.audio.voiceinput.service.o;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.VoiceInputDelegate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f409360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IAudioService f409361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f409362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f409363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.h f409364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f409365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f409366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f409367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f409368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f409369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f409370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f409371l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f409372m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f409373n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i f409374o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final VoiceInputSpeechScene f409375p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f409376q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f409360a, r101.f409360a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409361b, r101.f409361b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409362c, r101.f409362c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f409363d, r101.f409363d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f409364e, r101.f409364e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f409365f, r101.f409365f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f409366g, r101.f409366g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f409367h, r101.f409367h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f409368i, r101.f409368i) == true) goto L36;
        return false;
    L36:
        if (this.f409369j == r101.f409369j) goto L39;
        return false;
    L39:
        if (this.f409370k == r101.f409370k) goto L42;
        return false;
    L42:
        if (this.f409371l == r101.f409371l) goto L45;
        return false;
    L45:
        if (this.f409372m == r101.f409372m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f409373n, r101.f409373n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f409374o, r101.f409374o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(null, null) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f409375p, r101.f409375p) == true) goto L60;
        return false;
    L60:
        if (this.f409376q == r101.f409376q) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f409360a.hashCode() * 31) + this.f409361b.hashCode()) * 31) + this.f409362c.hashCode()) * 31) + this.f409363d.hashCode()) * 31) + this.f409364e.hashCode()) * 31;
        String r101 = this.f409365f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f409366g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + this.f409367h.hashCode()) * 31) + this.f409368i.hashCode()) * 31;
        int r108 = 1231;
        if (this.f409369j == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f409370k == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        if (this.f409371l == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.f409372m == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        j r117 = this.f409373n;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        i r120 = this.f409374o;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (((r119 + r121) * 31) + 0) * 31;
        VoiceInputSpeechScene r123 = this.f409375p;
        if (r123 == null) goto L38;
        r102 = r123.hashCode();
    L38:
        int r124 = (r122 + r102) * 31;
        if (this.f409376q == true) goto L43;
        r108 = 1237;
    L43:
        return r124 + r108;
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceInputContext(coroutineScope=" + this.f409360a + ", audioService=" + this.f409361b + ", newAudio2TextPush=" + this.f409362c + ", speechRecognitionEventPush=" + this.f409363d + ", audioResourceMutex=" + this.f409364e + ", appLocale=" + this.f409365f + ", chatId=" + this.f409366g + ", scene=" + this.f409367h + ", psdaToken=" + this.f409368i + ", isAsrEnable=" + this.f409369j + ", isAsrNerEnable=" + this.f409370k + ", enableFormat=" + this.f409371l + ", isSupportPartialUpload=" + this.f409372m + ", voiceRecordListener=" + this.f409373n + ", voiceDataAsrListener=" + this.f409374o + ", voiceDataUploadListener=null, speechScene=" + this.f409375p + ", enableMarkdown=" + this.f409376q + ')';
    }

    public h(CoroutineScope r110, IAudioService r111, l r112, o r113, com.ss.android.lark.audio.voiceinput.h r114, String r115, String r116, String r117, String r118, boolean r119, boolean r210, boolean r211, boolean r212, VoiceInputDelegate.c r213, i r214, VoiceInputSpeechScene r215, boolean r216) {
        Intrinsics.checkNotNullParameter(r110, "coroutineScope");
        Intrinsics.checkNotNullParameter(r111, "audioService");
        Intrinsics.checkNotNullParameter(r112, "newAudio2TextPush");
        Intrinsics.checkNotNullParameter(r113, "speechRecognitionEventPush");
        Intrinsics.checkNotNullParameter(r114, "audioResourceMutex");
        Intrinsics.checkNotNullParameter(r117, "scene");
        Intrinsics.checkNotNullParameter(r118, "psdaToken");
        this.f409360a = r110;
        this.f409361b = r111;
        this.f409362c = r112;
        this.f409363d = r113;
        this.f409364e = r114;
        this.f409365f = r115;
        this.f409366g = r116;
        this.f409367h = r117;
        this.f409368i = r118;
        this.f409369j = r119;
        this.f409370k = r210;
        this.f409371l = r211;
        this.f409372m = r212;
        this.f409373n = r213;
        this.f409374o = r214;
        this.f409375p = r215;
        this.f409376q = r216;
    }
}
