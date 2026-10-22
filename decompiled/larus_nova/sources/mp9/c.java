package mp9;

import android.net.Uri;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f514732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f514733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaType f514734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f514735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f514736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f514737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f514738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f514739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f514740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f514741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f514742k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f514743l;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f514732a == r101.f514732a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514733b, r101.f514733b) == true) goto L15;
        return false;
    L15:
        if (this.f514734c == r101.f514734c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f514735d, r101.f514735d) == true) goto L21;
        return false;
    L21:
        if (this.f514736e == r101.f514736e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f514737f, r101.f514737f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f514738g, r101.f514738g) == true) goto L30;
        return false;
    L30:
        if (this.f514739h == r101.f514739h) goto L33;
        return false;
    L33:
        if (this.f514740i == r101.f514740i) goto L36;
        return false;
    L36:
        if (this.f514741j == r101.f514741j) goto L39;
        return false;
    L39:
        if (this.f514742k == r101.f514742k) goto L42;
        return false;
    L42:
        if (this.f514743l == r101.f514743l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f514732a;
        int r101 = ((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f514733b.hashCode()) * 31) + this.f514734c.hashCode()) * 31) + this.f514735d.hashCode()) * 31;
        long r102 = this.f514736e;
        int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f514737f.hashCode()) * 31) + this.f514738g.hashCode()) * 31;
        long r104 = this.f514739h;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f514740i;
        int r107 = (((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f514741j) * 31) + this.f514742k) * 31;
        long r108 = this.f514743l;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    }

    public final String toString() {
        return "MediaItem(id=" + this.f514732a + ", uri=" + this.f514733b + ", type=" + this.f514734c + ", name=" + this.f514735d + ", folderId=" + this.f514736e + ", folderName=" + this.f514737f + ", mimeType=" + this.f514738g + ", dateAdded=" + this.f514739h + ", duration=" + this.f514740i + ", width=" + this.f514741j + ", height=" + this.f514742k + ", size=" + this.f514743l + ')';
    }

    public final MediaType getType() {
        return this.f514734c;
    }

    public /* synthetic */ c(int r110) {
        this(0, Uri.EMPTY, MediaType.IMAGE, "", -1, "", "", 0, 0, 0, 0, 0);
    }

    public c(long r100, Uri r110, MediaType r111, String r112, long r113, String r114, String r115, long r116, long r210, int r211, int r212, long r213) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "name");
        Intrinsics.checkNotNullParameter(r114, "folderName");
        Intrinsics.checkNotNullParameter(r115, DBDefinition.MIME_TYPE);
        this.f514732a = r100;
        this.f514733b = r110;
        this.f514734c = r111;
        this.f514735d = r112;
        this.f514736e = r113;
        this.f514737f = r114;
        this.f514738g = r115;
        this.f514739h = r116;
        this.f514740i = r210;
        this.f514741j = r211;
        this.f514742k = r212;
        this.f514743l = r213;
    }
}
