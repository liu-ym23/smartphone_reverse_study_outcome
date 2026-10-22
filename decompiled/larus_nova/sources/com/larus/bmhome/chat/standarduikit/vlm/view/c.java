package com.larus.bmhome.chat.standarduikit.vlm.view;

import com.larus.im.bean.message.MixerMedia;
import com.larus.im.bean.message.VLMImage;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VLMImage f309903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MixerMedia f309904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f309905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f309906d;

    public c() {
        this(null, null, 0, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f309903a, r101.f309903a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309904b, r101.f309904b) == true) goto L15;
        return false;
    L15:
        if (this.f309905c == r101.f309905c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309906d, r101.f309906d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        VLMImage r100 = this.f309903a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        MixerMedia r104 = this.f309904b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.f309905c) * 31) + this.f309906d.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OriginalMediaData(image=" + this.f309903a + ", mixedMedia=" + this.f309904b + ", indexInOriginList=" + this.f309905c + ", moreImageIndexListInOriginList=" + this.f309906d + ')';
    }

    public c(VLMImage r100, MixerMedia r101, int r102, List r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = CollectionsKt.emptyList();
    L14:
        Intrinsics.checkNotNullParameter(r103, "moreImageIndexListInOriginList");
        this.f309903a = r100;
        this.f309904b = r101;
        this.f309905c = r102;
        this.f309906d = r103;
    }
}
