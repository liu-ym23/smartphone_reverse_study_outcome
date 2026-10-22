package h31;

import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayMode f483680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f483681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f483682c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f483680a, r101.f483680a) == true) goto L8;
        return false;
    L8:
        if (this.f483681b == r101.f483681b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f483682c, r101.f483682c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        PlayMode r100 = this.f483680a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f483681b) * 31;
        List<String> r104 = this.f483682c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FirstPkData(playMode=" + this.f483680a + ", anchorListSize=" + this.f483681b + ", selectAnchorIds=" + this.f483682c + ")";
    }

    public d(PlayMode r100, int r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
        Intrinsics.checkNotNullParameter(r102, "selectAnchorIds");
        this.f483680a = r100;
        this.f483681b = r101;
        this.f483682c = r102;
    }
}
