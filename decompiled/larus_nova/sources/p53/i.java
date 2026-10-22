package p53;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECUrlModel f527783c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f527781a, r101.f527781a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527782b, r101.f527782b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f527783c, r101.f527783c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f527781a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f527782b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.f527783c;
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
        return "TagsVO(tagType=" + this.f527781a + ", tagText=" + this.f527782b + ", tagIcon=" + this.f527783c + ")";
    }

    public i(String r100, String r101, ECUrlModel r102) {
        this.f527781a = r100;
        this.f527782b = r101;
        this.f527783c = r102;
    }
}
