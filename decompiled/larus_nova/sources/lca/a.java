package lca;

import android.net.Uri;
import com.facebook.drawee.generic.RoundingParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f508616d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f508617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f508618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoundingParams f508619c;

    /* JADX INFO: renamed from: lca.a$a, reason: collision with other inner class name */
    public static final class C6676a {
        public static a a(Integer r100) {
            return new a(r100, null, 6);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f508617a, r101.f508617a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508618b, r101.f508618b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508619c, r101.f508619c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f508617a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Uri r104 = this.f508618b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        RoundingParams r107 = this.f508619c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "HybridResource(resId=" + this.f508617a + ", uri=" + this.f508618b + ", roundingParams=" + this.f508619c + ')';
    }

    public /* synthetic */ a(Integer r100, Uri r101, int r102) {
        RoundingParams r103 = null;
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 4) == 0) goto L11;
        r103 = RoundingParams.asCircle();
    L11:
        this(r100, r101, r103);
    }

    public a(Integer r100, Uri r101, RoundingParams r102) {
        this.f508617a = r100;
        this.f508618b = r101;
        this.f508619c = r102;
    }
}
