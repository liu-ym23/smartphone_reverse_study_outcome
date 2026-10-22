package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/n;", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;", "headerVideoInteractor", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;", "b", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;", "galleryVideoInteractor", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("gallery")
    private final HeaderPendantLynx galleryVideoInteractor;

    @SerializedName("header")
    private final HeaderPendantLynx headerVideoInteractor;

    public n() {
        this(null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L10;
        n r4 = (n) r3;
        if (Intrinsics.areEqual(this.headerVideoInteractor, r4.headerVideoInteractor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.galleryVideoInteractor, r4.galleryVideoInteractor) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        HeaderPendantLynx r0 = this.headerVideoInteractor;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HeaderPendantLynx r4 = this.galleryVideoInteractor;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "HeaderVideoCtrModel(headerVideoInteractor=" + this.headerVideoInteractor + ", galleryVideoInteractor=" + this.galleryVideoInteractor + ")";
    }

    public final HeaderPendantLynx a() {
        return this.galleryVideoInteractor;
    }

    public final HeaderPendantLynx b() {
        return this.headerVideoInteractor;
    }

    public n(HeaderPendantLynx r1, HeaderPendantLynx r2) {
        this.headerVideoInteractor = r1;
        this.galleryVideoInteractor = r2;
    }
}
