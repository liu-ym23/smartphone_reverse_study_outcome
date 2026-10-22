package x71;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f562794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f562795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f562796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f562797d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f562794a, r101.f562794a) == true) goto L8;
        return false;
    L8:
        if (this.f562795b == r101.f562795b) goto L10;
        return false;
    L10:
        if (this.f562796c == r101.f562796c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562797d, r101.f562797d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final int hashCode() {
        IBaseUser r100 = this.f562794a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f562795b) * 31;
        boolean r104 = this.f562796c;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f562797d;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RankItem(user=" + this.f562794a + ", rank=" + this.f562795b + ", isHidden=" + this.f562796c + ", exactlyScore=" + this.f562797d + ")";
    }

    public a(IBaseUser r100, int r101, boolean r102, String r103) {
        this.f562794a = r100;
        this.f562795b = r101;
        this.f562796c = r102;
        this.f562797d = r103;
    }
}
