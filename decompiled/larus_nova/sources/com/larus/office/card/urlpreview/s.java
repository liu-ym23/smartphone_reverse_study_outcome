package com.larus.office.card.urlpreview;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f362018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f362019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f362020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Block f362021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArtifactBlock f362022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f362023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f362024g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f362018a, r101.f362018a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f362019b, r101.f362019b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f362020c, r101.f362020c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f362021d, r101.f362021d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f362022e, r101.f362022e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f362023f, r101.f362023f) == true) goto L27;
        return false;
    L27:
        if (this.f362024g == r101.f362024g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f362018a.hashCode() * 31) + this.f362019b.hashCode()) * 31) + this.f362020c.hashCode()) * 31) + this.f362021d.hashCode()) * 31) + this.f362022e.hashCode()) * 31;
        String r101 = this.f362023f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f362024g == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeUrlPreviewBlockSnapshot(key=" + this.f362018a + ", persistenceKey=" + this.f362019b + ", message=" + this.f362020c + ", block=" + this.f362021d + ", artifact=" + this.f362022e + ", url=" + this.f362023f + ", compact=" + this.f362024g + ')';
    }

    public s(r r100, String r101, Message r102, Block r103, ArtifactBlock r104, String r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "persistenceKey");
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r103, "block");
        Intrinsics.checkNotNullParameter(r104, "artifact");
        this.f362018a = r100;
        this.f362019b = r101;
        this.f362020c = r102;
        this.f362021d = r103;
        this.f362022e = r104;
        this.f362023f = r105;
        this.f362024g = r106;
    }
}
