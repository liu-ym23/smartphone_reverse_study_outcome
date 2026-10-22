package com.ss.android.lark.audio.voiceinput;

import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes34.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f409276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IAudioService f409277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.service.l f409278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.service.o f409279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f409280e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f409276a, r101.f409276a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409277b, r101.f409277b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409278c, r101.f409278c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f409279d, r101.f409279d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f409280e, r101.f409280e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f409276a.hashCode() * 31) + this.f409277b.hashCode()) * 31) + this.f409278c.hashCode()) * 31) + this.f409279d.hashCode()) * 31) + this.f409280e.hashCode();
    }

    public final String toString() {
        return "VoiceInputDependency(coroutineScope=" + this.f409276a + ", audioService=" + this.f409277b + ", newAudio2TextPush=" + this.f409278c + ", speechRecognitionEventPush=" + this.f409279d + ", audioResourceMutex=" + this.f409280e + ')';
    }

    public n(CoroutineScope r100, IAudioService r101, com.ss.android.lark.audio.voiceinput.service.l r102, com.ss.android.lark.audio.voiceinput.service.o r103, com.bytedance.ee.bear.middleground.audio.f r104) {
        Intrinsics.checkNotNullParameter(r100, "coroutineScope");
        Intrinsics.checkNotNullParameter(r101, "audioService");
        Intrinsics.checkNotNullParameter(r102, "newAudio2TextPush");
        Intrinsics.checkNotNullParameter(r103, "speechRecognitionEventPush");
        Intrinsics.checkNotNullParameter(r104, "audioResourceMutex");
        this.f409276a = r100;
        this.f409277b = r101;
        this.f409278c = r102;
        this.f409279d = r103;
        this.f409280e = r104;
    }
}
