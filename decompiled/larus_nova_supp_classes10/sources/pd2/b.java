package pd2;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final MusicPanel a;
    public final HashMap<String, String> b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        MusicPanel r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HashMap<String, String> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AddSongParam(musicPanel=" + this.a + ", extra=" + this.b + ")";
    }

    public b(MusicPanel r2, HashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        this.a = r2;
        this.b = r3;
    }
}
