package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailMoreInfo;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends VOIdentifier {
    public static final /* synthetic */ int h = 0;
    public final ECUrlModel b;
    public final int c;
    public final DetailMoreInfo d;
    public final Integer e;
    public final List<ECUrlModel> f;
    public final List<String> g;

    public static final class a {
        public static d a(ECUrlModel r8, int r9, DetailMoreInfo r10, Integer r11, List r12, List r13) {
            Intrinsics.checkNotNullParameter(r8, "urlModel");
            return new d(r8, r9, r10, r11, r12, r13);
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L18;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (this.c == r4.c) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.c) * 31;
        DetailMoreInfo r4 = this.d;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.e;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<ECUrlModel> r10 = this.f;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.g;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV4DetailImageVO(image=" + this.b + ", index=" + this.c + ", moreInfo=" + this.d + ", showHeight=" + this.e + ", allImages=" + this.f + ", picTypes=" + this.g + ")";
    }

    public d(ECUrlModel r2, int r3, DetailMoreInfo r4, Integer r5, List<? extends ECUrlModel> r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r2, "image");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
