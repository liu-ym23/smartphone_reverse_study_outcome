package com.larus.office.card.urlpreview;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f361872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f361873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f361874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f361875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArtifactBlock f361876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OfficeUrlPreviewSourceKind f361877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f361878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Message f361879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f361880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f361881j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f361872a, r101.f361872a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f361873b, r101.f361873b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f361874c, r101.f361874c) == true) goto L18;
        return false;
    L18:
        if (this.f361875d == r101.f361875d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f361876e, r101.f361876e) == true) goto L24;
        return false;
    L24:
        if (this.f361877f == r101.f361877f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f361878g, r101.f361878g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f361879h, r101.f361879h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f361880i, r101.f361880i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f361881j, r101.f361881j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f361872a.hashCode() * 31) + this.f361873b.hashCode()) * 31) + this.f361874c.hashCode()) * 31) + this.f361875d) * 31) + this.f361876e.hashCode()) * 31) + this.f361877f.hashCode()) * 31;
        String r101 = this.f361878g;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f361879h.hashCode()) * 31;
        String r105 = this.f361880i;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f361881j;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeUrlPreviewActionTarget(messageId=" + this.f361872a + ", originalUrl=" + this.f361873b + ", resourceId=" + this.f361874c + ", resourceType=" + this.f361875d + ", artifact=" + this.f361876e + ", sourceKind=" + this.f361877f + ", fileName=" + this.f361878g + ", message=" + this.f361879h + ", botId=" + this.f361880i + ", previousPage=" + this.f361881j + ')';
    }

    public d(String r100, String r101, String r102, int r103, ArtifactBlock r104, OfficeUrlPreviewSourceKind r105, String r106, Message r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "originalUrl");
        Intrinsics.checkNotNullParameter(r102, "resourceId");
        Intrinsics.checkNotNullParameter(r104, "artifact");
        Intrinsics.checkNotNullParameter(r105, "sourceKind");
        Intrinsics.checkNotNullParameter(r107, "message");
        this.f361872a = r100;
        this.f361873b = r101;
        this.f361874c = r102;
        this.f361875d = r103;
        this.f361876e = r104;
        this.f361877f = r105;
        this.f361878g = r106;
        this.f361879h = r107;
        this.f361880i = r110;
        this.f361881j = r111;
    }
}
