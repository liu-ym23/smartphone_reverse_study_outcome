package ef;

import com.bytedance.android.ec.common.api.card.CardType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f472405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f472406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CardType f472407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f472408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f472409e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (this.f472405a == r101.f472405a) goto L8;
        return false;
    L8:
        if (this.f472406b == r101.f472406b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f472407c, r101.f472407c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472408d, r101.f472408d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f472409e, r101.f472409e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    public final int hashCode() {
        int r100 = this.f472405a * 31;
        boolean r101 = this.f472406b;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        CardType r104 = this.f472407c;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        Runnable r108 = this.f472408d;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        Runnable r111 = this.f472409e;
        if (r111 == null) goto L17;
        r105 = r111.hashCode();
    L17:
        return r110 + r105;
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "RequestCardParams(priority=" + this.f472405a + ", interrupt=" + this.f472406b + ", cardType=" + this.f472407c.name() + ')';
    }

    public d(int r100, CardType r101, Runnable r102, Runnable r103) {
        Intrinsics.checkNotNullParameter(r101, "cardType");
        Intrinsics.checkNotNullParameter(r102, "showCard");
        Intrinsics.checkNotNullParameter(r103, "hideCard");
        this.f472405a = r100;
        this.f472406b = true;
        this.f472407c = r101;
        this.f472408d = r102;
        this.f472409e = r103;
    }
}
