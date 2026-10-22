package ym7;

import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f568382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f568383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f568384c;

    public n() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f568382a, r101.f568382a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f568383b, r101.f568383b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f568384c, r101.f568384c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        FrameLayout r100 = this.f568382a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f568383b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f568384c;
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
        return "LuckySceneExtra(frameLayout=" + this.f568382a + ", extraObj=" + this.f568383b + ", uniqueId=" + this.f568384c + ")";
    }

    public n(FrameLayout r100, JSONObject r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f568382a = r100;
        this.f568383b = r101;
        this.f568384c = null;
    }
}
