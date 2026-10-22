package p68;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<SpeakerVoice> f527932b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f527931a, r101.f527931a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527932b, r101.f527932b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f527931a.hashCode() * 31) + this.f527932b.hashCode();
    }

    public final String toString() {
        return "TtsSpeakerGroup(language=" + this.f527931a + ", speakerVoices=" + this.f527932b + ')';
    }

    public h(String r100, ArrayList<SpeakerVoice> r101) {
        Intrinsics.checkNotNullParameter(r100, "language");
        Intrinsics.checkNotNullParameter(r101, "speakerVoices");
        this.f527931a = r100;
        this.f527932b = r101;
    }
}
