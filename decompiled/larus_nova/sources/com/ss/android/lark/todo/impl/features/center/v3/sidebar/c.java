package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import com.bytedance.lark.pb.todo.v1.IconInfo;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewType f441695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f441697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ContainerType f441698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f441699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f441700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f441701g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f441702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BgType f441703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IconInfo f441704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f441705k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f441695a == r101.f441695a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f441696b, r101.f441696b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f441697c, r101.f441697c) == true) goto L18;
        return false;
    L18:
        if (this.f441698d == r101.f441698d) goto L21;
        return false;
    L21:
        if (this.f441699e == r101.f441699e) goto L24;
        return false;
    L24:
        if (this.f441700f == r101.f441700f) goto L27;
        return false;
    L27:
        if (this.f441701g == r101.f441701g) goto L30;
        return false;
    L30:
        if (this.f441702h == r101.f441702h) goto L33;
        return false;
    L33:
        if (this.f441703i == r101.f441703i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f441704j, r101.f441704j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f441705k, r101.f441705k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f441695a.hashCode() * 31;
        String r101 = this.f441696b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f441697c.hashCode()) * 31;
        ContainerType r105 = this.f441698d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f441699e) * 31;
        int r108 = 1231;
        if (this.f441700f == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f441701g == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        if (this.f441702h == true) goto L22;
        r108 = 1237;
    L22:
        int r113 = (((r112 + r108) * 31) + this.f441703i.hashCode()) * 31;
        IconInfo r114 = this.f441704j;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f441705k;
        if (r117 == null) goto L31;
        r102 = r117.hashCode();
    L31:
        return r116 + r102;
    L25:
        r115 = r114.hashCode();
        goto L26
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
        return "ContainerItemData(viewType=" + this.f441695a + ", id=" + this.f441696b + ", name=" + this.f441697c + ", containerType=" + this.f441698d + ", badge=" + this.f441699e + ", isSelected=" + this.f441700f + ", isExpand=" + this.f441701g + ", isArchive=" + this.f441702h + ", bgType=" + this.f441703i + ", iconInfo=" + this.f441704j + ", sectionGuid=" + this.f441705k + ')';
    }

    public c(ViewType r100, String r101, String r102, ContainerType r103, int r104, boolean r105, boolean r110, BgType r111, IconInfo r112, String r113, int r114) {
        if ((r114 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r114 & 16) == 0) goto L9;
        r104 = 0;
    L9:
        if ((r114 & 64) == 0) goto L12;
        r105 = true;
    L12:
        if ((r114 & 128) == 0) goto L15;
        r110 = false;
    L15:
        if ((r114 & 256) == 0) goto L18;
        r111 = BgType.NO_BG;
    L18:
        if ((r114 & 512) == 0) goto L21;
        r112 = null;
    L21:
        if ((r114 & 1024) == 0) goto L23;
        r113 = null;
    L23:
        Intrinsics.checkNotNullParameter(r100, "viewType");
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r111, "bgType");
        this.f441695a = r100;
        this.f441696b = r101;
        this.f441697c = r102;
        this.f441698d = r103;
        this.f441699e = r104;
        this.f441700f = false;
        this.f441701g = r105;
        this.f441702h = r110;
        this.f441703i = r111;
        this.f441704j = r112;
        this.f441705k = r113;
    }
}
