package hq9;

import com.larus.platform.model.LarkSocialFeedPresentationMode;
import com.larus.platform.model.LarkSocialSnapshotState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f486751a = 0;

    static {
    }

    public static r2 a(r2 r100, m2 r101) {
        Intrinsics.checkNotNullParameter(r100, "previous");
        Intrinsics.checkNotNullParameter(r101, "capability");
        v2 r102 = r100.f486762b;
        if (r102 != null) goto L5;
    L7:
        r102 = null;
    L9:
        if (r101.f486674c == false) goto L16;
        v2 r103 = r101.f486673b;
        if (r103 == null) goto L16;
        if (Intrinsics.areEqual(r101.f486679h, r103) == false) goto L16;
        r102 = r101.f486673b;
    L16:
        if (r101.f486672a == LarkSocialSnapshotState.READY) goto L18;
    L27:
        LarkSocialFeedPresentationMode r104 = LarkSocialFeedPresentationMode.NATIVE;
    L29:
        return new r2(r104, r102);
    L18:
        if (r101.f486674c == false) goto L27;
        if (Intrinsics.areEqual(r102, r101.f486673b) == false) goto L24;
        r104 = LarkSocialFeedPresentationMode.NATIVE;
        goto L29
    L24:
        if (r101.f486675d == false) goto L26;
        r104 = LarkSocialFeedPresentationMode.MIXED_ACTIVE;
        goto L29
    L26:
        r104 = LarkSocialFeedPresentationMode.MIXED_PENDING;
        goto L29
    L5:
        if (Intrinsics.areEqual(r102, r101.f486673b) == false) goto L7;
        goto L7
    }
}
