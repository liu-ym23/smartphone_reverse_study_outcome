package k0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f501271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f501272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f501273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UserCreation f501274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f501275f;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f501270a, r101.f501270a) == true) goto L12;
        return false;
    L12:
        if (this.f501271b == r101.f501271b) goto L15;
        return false;
    L15:
        if (this.f501272c == r101.f501272c) goto L18;
        return false;
    L18:
        if (this.f501273d == r101.f501273d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f501274e, r101.f501274e) == true) goto L24;
        return false;
    L24:
        if (this.f501275f == r101.f501275f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f501270a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f501271b == false) goto L9;
        int r105 = 1231;
    L10:
        long r106 = this.f501272c;
        int r107 = (((r103 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f501273d;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        UserCreation r110 = this.f501274e;
        if (r110 == null) goto L14;
        r101 = r110.hashCode();
    L14:
        int r111 = (r109 + r101) * 31;
        if (this.f501275f == true) goto L19;
        r104 = 1237;
    L19:
        return r111 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationDetailBottomToolsUiState(creationId=" + this.f501270a + ", liked=" + this.f501271b + ", likeCount=" + this.f501272c + ", commentCount=" + this.f501273d + ", creation=" + this.f501274e + ", showLikeAnimation=" + this.f501275f + ')';
    }

    public /* synthetic */ a(int r110) {
        this(null, false, 0, 0, null, false);
    }

    public a(String r100, boolean r101, long r102, long r103, UserCreation r104, boolean r105) {
        this.f501270a = r100;
        this.f501271b = r101;
        this.f501272c = r102;
        this.f501273d = r103;
        this.f501274e = r104;
        this.f501275f = r105;
    }

    public static a a(a r100, boolean r110, long r111, long r112, UserCreation r113, boolean r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r101 = r100.f501270a;
    L7:
        if ((r115 & 2) == 0) goto L9;
        boolean r102 = r100.f501271b;
    L11:
        if ((r115 & 4) == 0) goto L13;
        long r103 = r100.f501272c;
    L15:
        if ((r115 & 8) == 0) goto L17;
        long r104 = r100.f501273d;
    L19:
        if ((r115 & 16) == 0) goto L21;
        UserCreation r105 = r100.f501274e;
    L23:
        if ((r115 & 32) == 0) goto L25;
        boolean r106 = r100.f501275f;
    L26:
        r100.getClass();
        return new a(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r114;
        goto L26
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = null;
        goto L7
    }
}
