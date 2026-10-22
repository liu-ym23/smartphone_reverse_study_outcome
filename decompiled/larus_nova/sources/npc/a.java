package npc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f520070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f520071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f520072e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f520068a, r101.f520068a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520069b, r101.f520069b) == true) goto L15;
        return false;
    L15:
        if (this.f520070c == r101.f520070c) goto L18;
        return false;
    L18:
        if (this.f520071d == r101.f520071d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f520072e, r101.f520072e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f520068a.hashCode() * 31) + this.f520069b.hashCode()) * 31) + this.f520070c) * 31;
        long r101 = this.f520071d;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f520072e.hashCode();
    }

    public final String toString() {
        return "DoubaoFileForwardRequest(resourceUri=" + this.f520068a + ", fileName=" + this.f520069b + ", storageType=" + this.f520070c + ", fileSize=" + this.f520071d + ", mimeType=" + this.f520072e + ')';
    }

    public final boolean a() {
        if ((!StringsKt.isBlank(this.f520068a)) == true) goto L5;
    L9:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.f520069b)) == false) goto L9;
        if (this.f520070c <= 0) goto L9;
        return true;
    }

    public a(String r100, String r101, int r102, long r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "resourceUri");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r104, DBDefinition.MIME_TYPE);
        this.f520068a = r100;
        this.f520069b = r101;
        this.f520070c = r102;
        this.f520071d = r103;
        this.f520072e = r104;
    }
}
