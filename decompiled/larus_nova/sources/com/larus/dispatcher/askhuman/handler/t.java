package com.larus.dispatcher.askhuman.handler;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f330924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f330925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f330926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f330927f;

    public /* synthetic */ t() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f330922a, r101.f330922a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330923b, r101.f330923b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330924c, r101.f330924c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f330925d, r101.f330925d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f330926e, r101.f330926e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f330927f, r101.f330927f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f330922a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f330923b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f330924c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f330925d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        u r113 = this.f330926e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        f r116 = this.f330927f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "SchemaPayload(toolCallId=" + this.f330922a + ", sandboxId=" + this.f330923b + ", command=" + this.f330924c + ", folders=" + this.f330925d + ", serverOption=" + this.f330926e + ", browserTakeover=" + this.f330927f + ')';
    }

    public t(String r100, String r101, String r102, List<String> r103, u r104, f r105) {
        this.f330922a = r100;
        this.f330923b = r101;
        this.f330924c = r102;
        this.f330925d = r103;
        this.f330926e = r104;
        this.f330927f = r105;
    }
}
