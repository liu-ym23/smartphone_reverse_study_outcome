package xy8;

import com.larus.im.bean.message.UplinkFileEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f565455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f565456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f565458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<UplinkFileEntity> f565459f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f565454a, r101.f565454a) == true) goto L12;
        return false;
    L12:
        if (this.f565455b == r101.f565455b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565456c, r101.f565456c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f565457d, r101.f565457d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f565458e, r101.f565458e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f565459f, r101.f565459f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f565454a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f565455b) * 31;
        Integer r104 = this.f565456c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f565457d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f565458e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.f565459f.hashCode();
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
        return "SendMetadata(messageId=" + this.f565454a + ", contentType=" + this.f565455b + ", upLinkState=" + this.f565456c + ", localResPath=" + this.f565457d + ", fileIdentifier=" + this.f565458e + ", attachmentEntities=" + this.f565459f + ')';
    }

    public f(String r100, int r101, Integer r102, String r103, String r104, List<UplinkFileEntity> r105) {
        Intrinsics.checkNotNullParameter(r105, "attachmentEntities");
        this.f565454a = r100;
        this.f565455b = r101;
        this.f565456c = r102;
        this.f565457d = r103;
        this.f565458e = r104;
        this.f565459f = r105;
    }
}
