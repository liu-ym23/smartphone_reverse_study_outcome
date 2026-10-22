package com.ss.android.lark.audio.voiceinput.processor;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f409356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f409357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f409358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f409359d;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f409356a, r101.f409356a) == true) goto L12;
        return false;
    L12:
        if (this.f409357b == r101.f409357b) goto L15;
        return false;
    L15:
        if (this.f409358c == r101.f409358c) goto L18;
        return false;
    L18:
        if (this.f409359d == r101.f409359d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        ByteBuffer r100 = this.f409356a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.f409357b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f409358c == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f409359d == true) goto L19;
        r103 = 1237;
    L19:
        return r107 + r103;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceDataProcessEntity(data=" + this.f409356a + ", isFinish=" + this.f409357b + ", needUploadAudioData=" + this.f409358c + ", isNeedUsePush=" + this.f409359d + ')';
    }

    public g(int r100) {
        this.f409356a = null;
        this.f409357b = false;
        this.f409358c = false;
        this.f409359d = true;
    }
}
