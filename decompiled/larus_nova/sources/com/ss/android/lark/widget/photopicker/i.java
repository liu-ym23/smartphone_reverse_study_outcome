package com.ss.android.lark.widget.photopicker;

import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Photo> f447539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f447540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f447541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f447542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f447543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f447544f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f447539a, r101.f447539a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f447540b, r101.f447540b) == true) goto L15;
        return false;
    L15:
        if (this.f447541c == r101.f447541c) goto L18;
        return false;
    L18:
        if (this.f447542d == r101.f447542d) goto L21;
        return false;
    L21:
        if (this.f447543e == r101.f447543e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f447544f, r101.f447544f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f447539a.hashCode() * 31) + this.f447540b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f447541c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f447542d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f447543e == true) goto L15;
        r101 = 1237;
    L15:
        return ((r105 + r101) * 31) + this.f447544f.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PhotoPickerSelectionRequest(selectedMedia=" + this.f447539a + ", selectedPhotoPaths=" + this.f447540b + ", keepOrigin=" + this.f447541c + ", hasVideo=" + this.f447542d + ", forSend=" + this.f447543e + ", chooseImageSource=" + this.f447544f + ')';
    }

    public i(List r100, List r101, boolean r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "selectedMedia");
        Intrinsics.checkNotNullParameter(r101, "selectedPhotoPaths");
        Intrinsics.checkNotNullParameter(r104, "chooseImageSource");
        this.f447539a = r100;
        this.f447540b = r101;
        this.f447541c = r102;
        this.f447542d = r103;
        this.f447543e = true;
        this.f447544f = r104;
    }
}
