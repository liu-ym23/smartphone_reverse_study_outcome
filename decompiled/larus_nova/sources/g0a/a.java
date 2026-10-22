package g0a;

import com.larus.ugc.feed.api.model.UserCreationKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UserCreationKmp f479505d;

    public a() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f479502a, r101.f479502a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479503b, r101.f479503b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479504c, r101.f479504c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479505d, r101.f479505d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f479502a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f479503b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f479504c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        UserCreationKmp r110 = this.f479505d;
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
        return "BundleDataKmp(relatedRecommendation=" + this.f479502a + ", relatedCreationId=" + this.f479503b + ", enterMethod=" + this.f479504c + ", userCreation=" + this.f479505d + ')';
    }

    public a(String r100, String r101, String r102, UserCreationKmp r103) {
        this.f479502a = r100;
        this.f479503b = r101;
        this.f479504c = r102;
        this.f479505d = r103;
    }
}
