package vua;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f557367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f557368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f557369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f557370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f557371e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f557367a, r101.f557367a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f557368b, r101.f557368b) == true) goto L15;
        return false;
    L15:
        if (this.f557369c == r101.f557369c) goto L18;
        return false;
    L18:
        if (this.f557370d == r101.f557370d) goto L21;
        return false;
    L21:
        if (this.f557371e == r101.f557371e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        View r100 = this.f557367a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Rect r104 = this.f557368b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((((r103 + r101) * 31) + this.f557369c) * 31) + this.f557370d) * 31;
        if (this.f557371e == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ForsetiPopoverParams(anchorView=" + this.f557367a + ", anchorViewGlobalVisibleRect=" + this.f557368b + ", popoverWidthInDp=" + this.f557369c + ", popoverHeightInDp=" + this.f557370d + ", openWithNewChain=" + this.f557371e + ')';
    }

    public a(Rect r100, int r101, int r102, boolean r103) {
        this.f557367a = null;
        this.f557368b = r100;
        this.f557369c = r101;
        this.f557370d = r102;
        this.f557371e = r103;
    }
}
