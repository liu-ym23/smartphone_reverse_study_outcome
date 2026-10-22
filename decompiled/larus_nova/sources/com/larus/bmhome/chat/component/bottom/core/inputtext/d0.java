package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f298715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f298716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputReferenceType f298717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f298718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f298719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i0 f298720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f298721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.bmhome.chat.referenceicon.b f298722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f298723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f298724j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f298715a, r101.f298715a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298716b, r101.f298716b) == true) goto L15;
        return false;
    L15:
        if (this.f298717c == r101.f298717c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f298718d, r101.f298718d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f298719e, r101.f298719e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f298720f, r101.f298720f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f298721g, r101.f298721g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f298722h, r101.f298722h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f298723i, r101.f298723i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f298724j, r101.f298724j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f298715a.hashCode() * 31) + this.f298716b.hashCode()) * 31) + this.f298717c.hashCode()) * 31;
        String r101 = this.f298718d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f298719e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        i0 r108 = this.f298720f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f298721g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        com.larus.bmhome.chat.referenceicon.b r114 = this.f298722h;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f298723i;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f298724j;
        if (r120 == null) goto L31;
        r102 = r120.hashCode();
    L31:
        return r119 + r102;
    L25:
        r118 = r117.hashCode();
        goto L26
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
        return "InputReference(id=" + this.f298715a + ", name=" + this.f298716b + ", type=" + this.f298717c + ", protocolDestination=" + this.f298718d + ", iconUrl=" + this.f298719e + ", documentIcon=" + this.f298720f + ", rawProtocolText=" + this.f298721g + ", attachmentVisual=" + this.f298722h + ", avatarKey=" + this.f298723i + ", avatarEntityId=" + this.f298724j + ')';
    }

    public final InputReferenceType getType() {
        return this.f298717c;
    }

    public static d0 a(d0 r110, String r111, String r112, int r113) {
        String r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f298715a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = r110.f298716b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        InputReferenceType r103 = r110.f298717c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r104 = r110.f298718d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r105 = r110.f298719e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        i0 r114 = r110.f298720f;
    L27:
        if ((r113 & 64) == 0) goto L29;
        String r115 = r110.f298721g;
    L31:
        if ((r113 & 128) == 0) goto L33;
        com.larus.bmhome.chat.referenceicon.b r116 = r110.f298722h;
    L35:
        if ((r113 & 256) == 0) goto L37;
        String r117 = r110.f298723i;
    L39:
        if ((r113 & 512) == 0) goto L41;
        r100 = r110.f298724j;
    L41:
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "type");
        return new d0(r101, r102, r103, r104, r105, r114, r115, r116, r117, r100);
    L37:
        r117 = null;
        goto L39
    L33:
        r116 = null;
        goto L35
    L29:
        r115 = null;
        goto L31
    L25:
        r114 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public d0(String r100, String r101, InputReferenceType r102, String r103, String r104, i0 r105, String r106, com.larus.bmhome.chat.referenceicon.b r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f298715a = r100;
        this.f298716b = r101;
        this.f298717c = r102;
        this.f298718d = r103;
        this.f298719e = r104;
        this.f298720f = r105;
        this.f298721g = r106;
        this.f298722h = r107;
        this.f298723i = r110;
        this.f298724j = r111;
    }

    public /* synthetic */ d0(String r110, String r111, InputReferenceType r112, String r113, String r114, i0 r210, String r211, com.larus.bmhome.chat.referenceicon.b r212, String r213, String r214, int r215) {
        if ((r215 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 32) == 0) goto L13;
        i0 r102 = null;
    L15:
        if ((r215 & 64) == 0) goto L17;
        String r115 = null;
    L19:
        if ((r215 & 128) == 0) goto L21;
        com.larus.bmhome.chat.referenceicon.b r116 = null;
    L23:
        if ((r215 & 256) == 0) goto L25;
        String r117 = null;
    L27:
        if ((r215 & 512) == 0) goto L29;
        String r118 = null;
    L30:
        this(r110, r111, r112, r100, r101, r102, r115, r116, r117, r118);
        return;
    L29:
        r118 = r214;
        goto L30
    L25:
        r117 = r213;
        goto L27
    L21:
        r116 = r212;
        goto L23
    L17:
        r115 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
