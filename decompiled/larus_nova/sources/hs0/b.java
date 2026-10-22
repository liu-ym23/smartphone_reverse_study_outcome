package hs0;

import android.view.View;
import com.bytedance.android.live.link.player.MultiPlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiPlayerScene f486939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f486940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486941c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f486939a, r101.f486939a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f486940b, r101.f486940b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f486941c, r101.f486941c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        MultiPlayerScene r100 = this.f486939a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f486940b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f486941c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RevMultiMonitorParam(playerScene=" + this.f486939a + ", playerView=" + this.f486940b + ", seiRaw=" + this.f486941c + ")";
    }

    public b(MultiPlayerScene r100, AbsLivePlayerView r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "playerScene");
        Intrinsics.checkNotNullParameter(r101, "playerView");
        Intrinsics.checkNotNullParameter(r102, "seiRaw");
        this.f486939a = r100;
        this.f486940b = r101;
        this.f486941c = r102;
    }
}
