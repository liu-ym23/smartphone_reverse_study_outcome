package wc9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f559236e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<l> f559237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f559238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f559239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f559240d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f559237a, r101.f559237a) == true) goto L12;
        return false;
    L12:
        if (this.f559238b == r101.f559238b) goto L15;
        return false;
    L15:
        if (this.f559239c == r101.f559239c) goto L18;
        return false;
    L18:
        if (this.f559240d == r101.f559240d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<l> r100 = this.f559237a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.f559238b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r102 + r104) * 31) + this.f559239c) * 31;
        if (this.f559240d == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationPagingData(data=" + this.f559237a + ", isPaging=" + this.f559238b + ", pageIndex=" + this.f559239c + ", done=" + this.f559240d + ')';
    }

    public i(List<l> r100, boolean r101, int r102, boolean r103) {
        this.f559237a = r100;
        this.f559238b = r101;
        this.f559239c = r102;
        this.f559240d = r103;
    }
}
