package i5;

import android.net.Uri;
import com.bytedance.ai.model.widgets.g0;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f488268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f488269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super String[], Unit> f488270c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f488268a, r101.f488268a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f488269b, r101.f488269b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f488270c, r101.f488270c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = Arrays.hashCode(this.f488268a) * 31;
        Uri r101 = this.f488269b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f488270c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "RequestPermission(resources=" + Arrays.toString(this.f488268a) + ", origin=" + this.f488269b + ", onGrantResult=" + this.f488270c + ')';
    }

    public final String[] getResources() {
        return this.f488268a;
    }

    public i(String[] r100, Uri r101, g0 r102) {
        Intrinsics.checkNotNullParameter(r100, "resources");
        Intrinsics.checkNotNullParameter(r102, "onGrantResult");
        this.f488268a = r100;
        this.f488269b = r101;
        this.f488270c = r102;
    }
}
