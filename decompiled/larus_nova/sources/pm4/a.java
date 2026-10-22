package pm4;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f529826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f529827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f529828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f529829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f529830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f529831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f529832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f529833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f529834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f529835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f529836k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f529837l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f529826a, r101.f529826a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f529827b, r101.f529827b) == true) goto L15;
        return false;
    L15:
        if (this.f529828c == r101.f529828c) goto L18;
        return false;
    L18:
        if (this.f529829d == r101.f529829d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Activity r100 = this.f529826a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Fragment r104 = this.f529827b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.f529828c) * 31) + this.f529829d;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FilePickerLaunchParams(activity=" + this.f529826a + ", fragment=" + this.f529827b + ", requestCode=" + this.f529828c + ", action=" + this.f529829d + ')';
    }

    public final Activity getActivity() {
        return this.f529826a;
    }

    public a(Fragment r100, int r101, int r102) {
        this.f529826a = null;
        this.f529827b = r100;
        this.f529828c = r101;
        this.f529829d = r102;
        this.f529830e = Long.MAX_VALUE;
        this.f529831f = Long.MAX_VALUE;
        this.f529832g = Integer.MAX_VALUE;
        this.f529833h = "";
        this.f529834i = "";
        this.f529837l = 202000;
    }
}
