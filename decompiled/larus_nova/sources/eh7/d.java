package eh7;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f472665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f472666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f472668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function3<Boolean, String[], String[], Unit> f472669e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f472665a, r101.f472665a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472666b, r101.f472666b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f472667c, r101.f472667c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f472668d, r101.f472668d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f472669e, r101.f472669e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Activity r100 = this.f472665a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Fragment r104 = this.f472666b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f472667c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f472668d.hashCode()) * 31;
        Function3<Boolean, String[], String[], Unit> r110 = this.f472669e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TimonPermissionRequest(activity=" + this.f472665a + ", fragment=" + this.f472666b + ", cert=" + this.f472667c + ", permissionList=" + this.f472668d + ", resultListener=" + this.f472669e + ')';
    }

    public final Activity getActivity() {
        return this.f472665a;
    }

    public d(Activity r100, String r101, List r102, Function3 r103) {
        Intrinsics.checkNotNullParameter(r102, "permissionList");
        this.f472665a = r100;
        this.f472666b = null;
        this.f472667c = r101;
        this.f472668d = r102;
        this.f472669e = r103;
    }
}
