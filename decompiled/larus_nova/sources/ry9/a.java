package ry9;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ResourceItemBean> f539910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f539911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f539912c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f539910a, r101.f539910a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f539911b, r101.f539911b) == true) goto L15;
        return false;
    L15:
        if (this.f539912c == r101.f539912c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f539910a.hashCode() * 31) + this.f539911b.hashCode()) * 31) + this.f539912c;
    }

    public final String toString() {
        return "AlbumResourceConfig(resourceList=" + this.f539910a + ", albumPathList=" + this.f539911b + ", replaceIndex=" + this.f539912c + ')';
    }

    public a(ArrayList<ResourceItemBean> r100, ArrayList<String> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "resourceList");
        Intrinsics.checkNotNullParameter(r101, "albumPathList");
        this.f539910a = r100;
        this.f539911b = r101;
        this.f539912c = r102;
    }
}
