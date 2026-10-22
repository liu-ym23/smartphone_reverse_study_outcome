package com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view;

import com.larus.im.bean.message.SearchImageInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SearchImageInfo> f309281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f309282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f309283c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f309281a, r101.f309281a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309282b, r101.f309282b) == true) goto L15;
        return false;
    L15:
        if (this.f309283c == r101.f309283c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f309281a.hashCode() * 31;
        Integer r101 = this.f309282b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f309283c == false) goto L9;
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
        return "ImagesData(images=" + this.f309281a + ", imageShowType=" + this.f309282b + ", isTopImageStyle=" + this.f309283c + ')';
    }

    public x(List<SearchImageInfo> r100, Integer r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "images");
        this.f309281a = r100;
        this.f309282b = r101;
        this.f309283c = r102;
    }
}
