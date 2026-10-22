package k73;

import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.AudioState;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.PlayState;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayState f501988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioState f501989b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f501988a, r101.f501988a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f501989b, r101.f501989b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        PlayState r100 = this.f501988a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AudioState r104 = this.f501989b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PlayerCompositeState(playState=" + this.f501988a + ", audioState=" + this.f501989b + ")";
    }

    public a(PlayState r100, AudioState r101) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_STATE);
        Intrinsics.checkNotNullParameter(r101, "audioState");
        this.f501988a = r100;
        this.f501989b = r101;
    }
}
