package w2a;

import com.larus.im.bean.bot.MixVoice;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MixVoice> f558054a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f558054a, ((a) r100).f558054a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f558054a.hashCode();
    }

    public final String toString() {
        return "MixedVoiceListUpdate(list=" + this.f558054a + ')';
    }

    public a(List<MixVoice> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f558054a = r100;
    }
}
