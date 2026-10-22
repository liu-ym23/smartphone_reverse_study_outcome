package r2a;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpeakerVoice f535833b;

    public d() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f535832a, r101.f535832a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535833b, r101.f535833b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f535832a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        SpeakerVoice r104 = this.f535833b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeleteVoiceResponse(voiceId=" + this.f535832a + ", voice=" + this.f535833b + ')';
    }

    public d(String r100, SpeakerVoice r101) {
        this.f535832a = r100;
        this.f535833b = r101;
    }
}
