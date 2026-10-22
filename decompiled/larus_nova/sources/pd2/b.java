package pd2;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MusicPanel f528644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f528645b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f528644a, r101.f528644a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f528645b, r101.f528645b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        MusicPanel r100 = this.f528644a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashMap<String, String> r104 = this.f528645b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AddSongParam(musicPanel=" + this.f528644a + ", extra=" + this.f528645b + ")";
    }

    public b(MusicPanel r100, HashMap<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        this.f528644a = r100;
        this.f528645b = r101;
    }
}
