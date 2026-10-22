package h88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f484282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f484284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f484285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f484286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f484287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f484288g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f484282a == r101.f484282a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484283b, r101.f484283b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f484284c, r101.f484284c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f484285d, r101.f484285d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f484286e, r101.f484286e) == true) goto L24;
        return false;
    L24:
        if (this.f484287f == r101.f484287f) goto L27;
        return false;
    L27:
        if (this.f484288g == r101.f484288g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f484282a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.f484283b;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Boolean r107 = this.f484284c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f484285d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f484286e;
        if (r113 == null) goto L22;
        r104 = r113.hashCode();
    L22:
        int r114 = (r112 + r104) * 31;
        if (this.f484287f == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.f484288g == true) goto L31;
        r100 = 1237;
    L31:
        return r116 + r100;
    L25:
        r115 = 1237;
        goto L26
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CallSceneDisplayModel(sceneLoading=" + this.f484282a + ", sceneIconShowOutSide=" + this.f484283b + ", sceneUseOriginalIcon=" + this.f484284c + ", sceneModelName=" + this.f484285d + ", clickTraceId=" + this.f484286e + ", disableExit=" + this.f484287f + ", disableChange=" + this.f484288g + ')';
    }

    public c(boolean r100, String r101, Boolean r102, String r103, Integer r104, boolean r105, boolean r106) {
        this.f484282a = r100;
        this.f484283b = r101;
        this.f484284c = r102;
        this.f484285d = r103;
        this.f484286e = r104;
        this.f484287f = r105;
        this.f484288g = r106;
    }
}
