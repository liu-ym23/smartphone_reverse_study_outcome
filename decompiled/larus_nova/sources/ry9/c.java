package ry9;

import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentSource;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentState;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f539914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CreationReferenceAttachmentType f539915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CreationReferenceAttachmentSource f539916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CreationReferenceAttachmentState f539917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f539918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f539919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f539920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f539921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Double f539922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f539923k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f539913a, r101.f539913a) == true) goto L12;
        return false;
    L12:
        if (this.f539914b == r101.f539914b) goto L15;
        return false;
    L15:
        if (this.f539915c == r101.f539915c) goto L18;
        return false;
    L18:
        if (this.f539916d == r101.f539916d) goto L21;
        return false;
    L21:
        if (this.f539917e == r101.f539917e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f539918f, r101.f539918f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f539919g, r101.f539919g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f539920h, r101.f539920h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f539921i, r101.f539921i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f539922j, r101.f539922j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f539923k, r101.f539923k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f539913a.hashCode() * 31) + this.f539914b) * 31) + this.f539915c.hashCode()) * 31) + this.f539916d.hashCode()) * 31) + this.f539917e.hashCode()) * 31;
        String r101 = this.f539918f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f539919g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f539920h;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f539921i;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Double r114 = this.f539922j;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.f539923k;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationReferenceAttachment(resourceKey=" + this.f539913a + ", order=" + this.f539914b + ", type=" + this.f539915c + ", source=" + this.f539916d + ", state=" + this.f539917e + ", mimeType=" + this.f539918f + ", fileSuffix=" + this.f539919g + ", width=" + this.f539920h + ", height=" + this.f539921i + ", duration=" + this.f539922j + ", fileSize=" + this.f539923k + ')';
    }

    public final CreationReferenceAttachmentType getType() {
        return this.f539915c;
    }

    public c(String r100, int r101, CreationReferenceAttachmentType r102, CreationReferenceAttachmentSource r103, CreationReferenceAttachmentState r104, String r105, String r106, Integer r107, Integer r110, Double r111, Long r112) {
        Intrinsics.checkNotNullParameter(r100, "resourceKey");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "source");
        Intrinsics.checkNotNullParameter(r104, "state");
        this.f539913a = r100;
        this.f539914b = r101;
        this.f539915c = r102;
        this.f539916d = r103;
        this.f539917e = r104;
        this.f539918f = r105;
        this.f539919g = r106;
        this.f539920h = r107;
        this.f539921i = r110;
        this.f539922j = r111;
        this.f539923k = r112;
    }
}
