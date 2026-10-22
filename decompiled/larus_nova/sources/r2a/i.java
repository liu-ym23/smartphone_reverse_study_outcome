package r2a;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f535844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SpeakerVoice> f535845b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f535844a == r101.f535844a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535845b, r101.f535845b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f535844a * 31) + this.f535845b.hashCode();
    }

    public final String toString() {
        return "VoiceListResponse(status=" + this.f535844a + ", list=" + this.f535845b + ')';
    }

    public i(int r100, List<SpeakerVoice> r101) {
        Intrinsics.checkNotNullParameter(r101, "list");
        this.f535844a = r100;
        this.f535845b = r101;
    }
}
