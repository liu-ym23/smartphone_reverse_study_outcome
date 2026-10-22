package ra8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f536853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f536854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f536855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f536856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f536857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f536858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f536859g;

    public b() {
        this(null, null, null, false, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f536853a, r101.f536853a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f536854b, r101.f536854b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f536855c, r101.f536855c) == true) goto L18;
        return false;
    L18:
        if (this.f536856d == r101.f536856d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f536857e, r101.f536857e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f536858f, r101.f536858f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f536859g, r101.f536859g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f536853a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f536854b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f536855c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f536856d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        Boolean r112 = this.f536857e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (((r111 + r113) * 31) + this.f536858f.hashCode()) * 31;
        Integer r115 = this.f536859g;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
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
        return "BlockRenderContext(messageId=" + this.f536853a + ", senderId=" + this.f536854b + ", conversationId=" + this.f536855c + ", isTyping=" + this.f536856d + ", isFinished=" + this.f536857e + ", scene=" + this.f536858f + ", messageStatus=" + this.f536859g + ')';
    }

    public static b a(b r110, Boolean r111, String r112, int r113) {
        Integer r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f536853a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = r110.f536854b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r103 = r110.f536855c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        boolean r104 = r110.f536856d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        r111 = r110.f536857e;
    L21:
        Boolean r105 = r111;
        if ((r113 & 32) == 0) goto L24;
        r112 = r110.f536858f;
    L24:
        String r106 = r112;
        if ((r113 & 64) == 0) goto L27;
        r100 = r110.f536859g;
    L27:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r106, "scene");
        return new b(r101, r102, r103, r104, r105, r106, r100);
    L17:
        r104 = false;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ b(String r110, String r111, String r112, boolean r113, Boolean r114, String r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r116 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r116 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r116 & 16) == 0) goto L21;
        Boolean r104 = null;
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r105 = "default";
    L26:
        this(r100, r101, r102, r103, r104, r105, null);
        return;
    L25:
        r105 = r115;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, String r102, boolean r103, Boolean r104, String r105, Integer r106) {
        Intrinsics.checkNotNullParameter(r105, "scene");
        this.f536853a = r100;
        this.f536854b = r101;
        this.f536855c = r102;
        this.f536856d = r103;
        this.f536857e = r104;
        this.f536858f = r105;
        this.f536859g = r106;
    }
}
