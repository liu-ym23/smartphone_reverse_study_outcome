package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f406729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AINoteScene f406730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f406731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AINoteType f406732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f406733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RichText f406734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f406735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f406736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AINoteCreateSource f406737i;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f406729a, r101.f406729a) == true) goto L12;
        return false;
    L12:
        if (this.f406730b == r101.f406730b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f406731c, r101.f406731c) == true) goto L18;
        return false;
    L18:
        if (this.f406732d == r101.f406732d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f406733e, r101.f406733e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f406734f, r101.f406734f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f406735g, r101.f406735g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f406736h, r101.f406736h) == true) goto L33;
        return false;
    L33:
        if (this.f406737i == r101.f406737i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f406729a.hashCode() * 31) + this.f406730b.hashCode()) * 31) + this.f406731c.hashCode()) * 31) + this.f406732d.hashCode()) * 31;
        String r101 = this.f406733e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        RichText r105 = this.f406734f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f406735g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f406736h.hashCode()) * 31;
        AINoteCreateSource r111 = this.f406737i;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "AINoteBlock(bizIds=" + this.f406729a + ", scene=" + this.f406730b + ", createTime=" + this.f406731c + ", noteType=" + this.f406732d + ", markId=" + this.f406733e + ", contentRichText=" + this.f406734f + ", contentText=" + this.f406735g + ", imagePaths=" + this.f406736h + ", createSource=" + this.f406737i + ')';
    }

    public e(d r100, AINoteScene r101, h r102, AINoteType r103, String r104, String r105, List r106, int r110) {
        if ((r110 & 16) == 0) goto L6;
        r104 = null;
    L6:
        if ((r110 & 64) == 0) goto L9;
        r105 = null;
    L9:
        if ((r110 & 128) == 0) goto L11;
        r106 = CollectionsKt.emptyList();
    L11:
        Intrinsics.checkNotNullParameter(r100, "bizIds");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "createTime");
        Intrinsics.checkNotNullParameter(r103, "noteType");
        Intrinsics.checkNotNullParameter(r106, "imagePaths");
        this.f406729a = r100;
        this.f406730b = r101;
        this.f406731c = r102;
        this.f406732d = r103;
        this.f406733e = r104;
        this.f406734f = null;
        this.f406735g = r105;
        this.f406736h = r106;
        this.f406737i = null;
    }
}
