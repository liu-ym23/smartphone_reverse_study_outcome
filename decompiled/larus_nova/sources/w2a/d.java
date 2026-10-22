package w2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.voice.mix.res.VoiceAuditState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpeakerVoice f558063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f558065c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f558063a, r101.f558063a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558064b, r101.f558064b) == true) goto L15;
        return false;
    L15:
        if (this.f558065c == r101.f558065c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        SpeakerVoice r100 = this.f558063a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f558064b.hashCode()) * 31) + this.f558065c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceAuditionUpdate(voice=" + this.f558063a + ", from=" + this.f558064b + ", action=" + this.f558065c + ')';
    }

    public d(SpeakerVoice r100, String r101, @VoiceAuditState int r102) {
        Intrinsics.checkNotNullParameter(r101, "from");
        this.f558063a = r100;
        this.f558064b = r101;
        this.f558065c = r102;
    }
}
