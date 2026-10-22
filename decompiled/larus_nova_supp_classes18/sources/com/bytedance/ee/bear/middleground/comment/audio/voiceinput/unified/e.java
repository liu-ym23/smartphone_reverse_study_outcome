package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.voiceinput.api.data.config.asr.resultConfig.VoiceAsrMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final Fragment a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final VoiceAsrMode f;
    public final dbc.c g;
    public final b h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public final String toString() {
        return "CommentUnifiedVoiceComponentAdvancedProviderRequest(fragment=" + this.a + ", psdaToken=" + this.b + ", fileId=" + this.c + ", fileType=" + this.d + ", traceId=" + this.e + ", asrMode=" + this.f + ", voiceView=" + this.g + ", callbacks=" + this.h + ')';
    }

    public e(Fragment r2, String r3, String r4, String r5, String r6, VoiceAsrMode r7, ebc.b r8, b r9) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "psdaToken");
        Intrinsics.checkNotNullParameter(r4, "fileId");
        Intrinsics.checkNotNullParameter(r5, "fileType");
        Intrinsics.checkNotNullParameter(r6, "traceId");
        Intrinsics.checkNotNullParameter(r7, "asrMode");
        Intrinsics.checkNotNullParameter(r8, "voiceView");
        Intrinsics.checkNotNullParameter(r9, "callbacks");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
