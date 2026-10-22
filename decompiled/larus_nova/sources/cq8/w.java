package cq8;

import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.n f464982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f464983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f464984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f464985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f464986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TemplateInfo$TemplateInfo f464987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final z0 f464988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f464989m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f464979c, r101.f464979c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464980d, r101.f464980d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464981e, r101.f464981e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464982f, r101.f464982f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464983g, r101.f464983g) == true) goto L24;
        return false;
    L24:
        if (this.f464984h == r101.f464984h) goto L27;
        return false;
    L27:
        if (this.f464985i == r101.f464985i) goto L30;
        return false;
    L30:
        if (this.f464986j == r101.f464986j) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f464987k, r101.f464987k) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f464988l, r101.f464988l) == true) goto L39;
        return false;
    L39:
        if (this.f464989m == r101.f464989m) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464979c.hashCode() * 31) + this.f464980d.hashCode()) * 31) + this.f464981e.hashCode()) * 31;
        com.larus.bmhome.actionbar.model.n r101 = this.f464982f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f464983g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        int r108 = 1231;
        if (this.f464984h == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f464985i == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        if (this.f464986j == true) goto L22;
        r108 = 1237;
    L22:
        int r113 = (r112 + r108) * 31;
        TemplateInfo$TemplateInfo r114 = this.f464987k;
        if (r114 == null) goto L27;
        r102 = r114.hashCode();
    L27:
        return ((((r113 + r102) * 31) + this.f464988l.hashCode()) * 31) + this.f464989m;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageTemplateSelectorWithMoreDescriptor(widgetId=" + this.f464979c + ", actionChannel=" + this.f464980d + ", version=" + this.f464981e + ", template=" + this.f464982f + ", subTitle=" + this.f464983g + ", enableBottomLine=" + this.f464984h + ", isStyleRadio=" + this.f464985i + ", showCover=" + this.f464986j + ", selectedTemplate=" + this.f464987k + ", trackingContext=" + this.f464988l + ", scrollToPosition=" + this.f464989m + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464981e;
    }

    public w(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, com.larus.bmhome.actionbar.model.n r102, String r103, boolean r104, boolean r105, boolean r106, TemplateInfo$TemplateInfo r110, z0 r111, int r112) {
        String r107 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r107, "version");
        Intrinsics.checkNotNullParameter(r111, "trackingContext");
        super("ImageTemplateSelectorWithMoreDescriptor");
        this.f464979c = r100;
        this.f464980d = r101;
        this.f464981e = r107;
        this.f464982f = r102;
        this.f464983g = r103;
        this.f464984h = r104;
        this.f464985i = r105;
        this.f464986j = r106;
        this.f464987k = r110;
        this.f464988l = r111;
        this.f464989m = r112;
    }
}
