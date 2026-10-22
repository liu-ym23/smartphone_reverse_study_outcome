package x79;

import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.select.ChatRecentFileSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f562840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f562841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DriveFileType f562842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f562843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f562844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f562845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ChatRecentFileSource f562846i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f562838a, r101.f562838a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562839b, r101.f562839b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f562840c, r101.f562840c) == true) goto L18;
        return false;
    L18:
        if (this.f562841d == r101.f562841d) goto L21;
        return false;
    L21:
        if (this.f562842e == r101.f562842e) goto L24;
        return false;
    L24:
        if (this.f562843f == r101.f562843f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f562844g, r101.f562844g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f562845h, r101.f562845h) == true) goto L33;
        return false;
    L33:
        if (this.f562846i == r101.f562846i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f562838a.hashCode() * 31) + this.f562839b.hashCode()) * 31) + this.f562840c.hashCode()) * 31;
        long r101 = this.f562841d;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f562842e.hashCode()) * 31;
        long r103 = this.f562843f;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f562844g;
        int r106 = 0;
        if (r105 != null) goto L5;
        int r107 = 0;
    L6:
        int r108 = (r104 + r107) * 31;
        Integer r109 = this.f562845h;
        if (r109 == null) goto L11;
        r106 = r109.hashCode();
    L11:
        return ((r108 + r106) * 31) + this.f562846i.hashCode();
    L5:
        r107 = r105.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatRecentFileItem(name=" + this.f562838a + ", uri=" + this.f562839b + ", url=" + this.f562840c + ", size=" + this.f562841d + ", fileType=" + this.f562842e + ", createTime=" + this.f562843f + ", driveUplinkInfo=" + this.f562844g + ", baseBizType=" + this.f562845h + ", source=" + this.f562846i + ')';
    }

    public b(String r100, String r101, String r102, long r103, DriveFileType r104, long r105, String r110, Integer r111, ChatRecentFileSource r112) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r104, "fileType");
        Intrinsics.checkNotNullParameter(r112, "source");
        this.f562838a = r100;
        this.f562839b = r101;
        this.f562840c = r102;
        this.f562841d = r103;
        this.f562842e = r104;
        this.f562843f = r105;
        this.f562844g = r110;
        this.f562845h = r111;
        this.f562846i = r112;
    }
}
