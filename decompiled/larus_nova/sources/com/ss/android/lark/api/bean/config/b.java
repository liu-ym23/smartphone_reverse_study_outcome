package com.ss.android.lark.api.bean.config;

import com.ss.android.lark.api.ui.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f408673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f408674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f408675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f408676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f408677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f408678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f408679g;

    public b() {
        this(false, false, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f408673a == r101.f408673a) goto L12;
        return false;
    L12:
        if (this.f408674b == r101.f408674b) goto L15;
        return false;
    L15:
        if (this.f408675c == r101.f408675c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f408676d, r101.f408676d) == true) goto L21;
        return false;
    L21:
        if (this.f408677e == r101.f408677e) goto L24;
        return false;
    L24:
        if (this.f408678f == r101.f408678f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f408679g, r101.f408679g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f408673a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f408674b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f408675c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.f408676d.hashCode()) * 31;
        if (this.f408677e == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f408678f == true) goto L22;
        r100 = 1237;
    L22:
        int r109 = (r108 + r100) * 31;
        k r110 = this.f408679g;
        if (r110 != null) goto L25;
        int r111 = 0;
    L27:
        return r109 + r111;
    L25:
        r111 = r110.hashCode();
        goto L27
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ForsetiChainExtraOptions(isDefaultSelectedChain=" + this.f408673a + ", alwaysShowPlaceHolderFragment=" + this.f408674b + ", draggingEnabled=" + this.f408675c + ", navTabKey=" + this.f408676d + ", isDynamicSplit=" + this.f408677e + ", isSplitWindowChain=" + this.f408678f + ", splitWindowManagerProxy=" + this.f408679g + ')';
    }

    public b(boolean r100, boolean r101, k r102, int r103) {
        boolean r104 = true;
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 4) != 0) goto L10;
        r104 = false;
    L10:
        if ((r103 & 8) == 0) goto L12;
        String r105 = "";
    L14:
        if ((r103 & 32) == 0) goto L17;
        r101 = false;
    L17:
        if ((r103 & 64) == 0) goto L19;
        r102 = null;
    L19:
        Intrinsics.checkNotNullParameter(r105, "navTabKey");
        this.f408673a = r100;
        this.f408674b = false;
        this.f408675c = r104;
        this.f408676d = r105;
        this.f408677e = false;
        this.f408678f = r101;
        this.f408679g = r102;
        return;
    L12:
        r105 = null;
        goto L14
    }
}
