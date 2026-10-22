package fo9;

import com.bytedance.lark.pb.search.v2.DocMeta;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f478175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f478176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f478177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f478178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f478179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<DocMeta> f478180h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f478173a, r101.f478173a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478174b, r101.f478174b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f478175c, r101.f478175c) == true) goto L18;
        return false;
    L18:
        if (this.f478176d == r101.f478176d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f478177e, r101.f478177e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f478178f, r101.f478178f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f478179g, r101.f478179g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f478180h, r101.f478180h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f478173a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f478174b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f478175c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f478176d;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.f478177e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f478178f;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f478179g;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        ArrayList<DocMeta> r121 = this.f478180h;
        if (r121 == null) goto L31;
        r101 = r121.hashCode();
    L31:
        return r120 + r101;
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
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
        return "NoPermissionBundleData(docId=" + this.f478173a + ", docTitle=" + this.f478174b + ", ownerName=" + this.f478175c + ", objType=" + this.f478176d + ", enterFrom=" + this.f478177e + ", applyPermissionMessageId=" + this.f478178f + ", applyPermissionConversationId=" + this.f478179g + ", docListToApplyPermission=" + this.f478180h + ')';
    }

    public c(String r100, String r101, String r102, long r103, String r104, String r105, String r106, ArrayList<DocMeta> r107) {
        this.f478173a = r100;
        this.f478174b = r101;
        this.f478175c = r102;
        this.f478176d = r103;
        this.f478177e = r104;
        this.f478178f = r105;
        this.f478179g = r106;
        this.f478180h = r107;
    }
}
