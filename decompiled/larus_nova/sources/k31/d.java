package k31;

import android.view.View;
import com.bytedance.android.live.link.player.MultiPlayerScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiPlayerScene f501642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f501643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f501644c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f501642a, r101.f501642a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f501643b, r101.f501643b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f501644c, r101.f501644c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        MultiPlayerScene r100 = this.f501642a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f501643b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        j r107 = this.f501644c;
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
        return "MultiMonitorParam(playerScene=" + this.f501642a + ", playerView=" + this.f501643b + ", seiLayouts=" + this.f501644c + ")";
    }

    public d(MultiPlayerScene r100, View r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, "playerScene");
        Intrinsics.checkNotNullParameter(r101, "playerView");
        Intrinsics.checkNotNullParameter(r102, "seiLayouts");
        this.f501642a = r100;
        this.f501643b = r101;
        this.f501644c = r102;
    }
}
