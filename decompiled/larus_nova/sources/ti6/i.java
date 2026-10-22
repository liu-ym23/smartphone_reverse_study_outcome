package ti6;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f546204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveWrappedMixedStreamVideoType f546205b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f546204a, r101.f546204a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f546205b, r101.f546205b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f546204a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LiveWrappedMixedStreamVideoType r104 = this.f546205b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiRoomMixRegionConfig(mutexRoomId=" + this.f546204a + ", mixStreamVideoType=" + this.f546205b + ")";
    }

    public i() {
        this("", LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_MAIN);
    }

    public i(String r100, LiveWrappedMixedStreamVideoType r101) {
        Intrinsics.checkNotNullParameter(r100, "mutexRoomId");
        Intrinsics.checkNotNullParameter(r101, "mixStreamVideoType");
        this.f546204a = r100;
        this.f546205b = r101;
    }
}
