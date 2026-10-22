package com.ss.android.lark.keyboard.plugin.tool.voice.processor;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f430794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioContent f430795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f430796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f430797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f430798e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f430794a, r101.f430794a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f430795b, r101.f430795b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f430796c, r101.f430796c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f430797d, r101.f430797d) == true) goto L21;
        return false;
    L21:
        if (this.f430798e == r101.f430798e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f430794a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        AudioContent r104 = this.f430795b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((((r103 + r101) * 31) + this.f430796c.hashCode()) * 31) + this.f430797d.hashCode()) * 31) + this.f430798e;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioMsgInfo(audioMessage=" + this.f430794a + ", audioContent=" + this.f430795b + ", audioFileName=" + this.f430796c + ", audioCid=" + this.f430797d + ", audioDuration=" + this.f430798e + ')';
    }

    public b(Message r100, AudioContent r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "audioFileName");
        Intrinsics.checkNotNullParameter(r103, "audioCid");
        this.f430794a = r100;
        this.f430795b = r101;
        this.f430796c = r102;
        this.f430797d = r103;
        this.f430798e = 0;
    }
}
