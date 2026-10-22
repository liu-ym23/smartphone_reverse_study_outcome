package ihc;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f489928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Intent f489929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f489930d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f489927a, r101.f489927a) == true) goto L8;
        return false;
    L8:
        if (this.f489928b == r101.f489928b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f489929c, r101.f489929c) == true) goto L12;
        return false;
    L12:
        if (this.f489930d == r101.f489930d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f489927a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f489928b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Intent r105 = this.f489929c;
        if (r105 == null) goto L9;
        r101 = r105.hashCode();
    L9:
        int r106 = (r104 + r101) * 31;
        long r107 = this.f489930d;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AppBackData(appPackageName=" + this.f489927a + ", jumpTime=" + this.f489928b + ", jumpData=" + this.f489929c + ", backTime=" + this.f489930d + ")";
    }

    public a(String r100, long r101, Intent r102, long r103) {
        this.f489927a = r100;
        this.f489928b = r101;
        this.f489929c = r102;
        this.f489930d = r103;
    }
}
