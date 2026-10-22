package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesComponent;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailTagCard;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormatGroup;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends VOIdentifier {
    public final ECUrlModel b;
    public final List<ProductFormatGroup> c;
    public final h53.a d;
    public final v63.b e;
    public final DetailCombinePropertiesComponent f;
    public final String g;
    public final DetailTagCard h;

    public d() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L20;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
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
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<ProductFormatGroup> r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        h53.a r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        v63.b r10 = this.e;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        DetailCombinePropertiesComponent r13 = this.f;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.g;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        DetailTagCard r19 = this.h;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
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
        return "AnchorV4DetailHeadVO(headerImage=" + this.b + ", productFormatGroup=" + this.c + ", categoryStyle=" + this.d + ", detailTopTagComponent=" + this.e + ", combineProperties=" + this.f + ", jumpUrl=" + this.g + ", tagCard=" + this.h + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        return ComponentIDs.DETAIL_HEAD.getId();
    }

    public d(ECUrlModel r4, List r5, v63.b r6, DetailCombinePropertiesComponent r7, String r8, DetailTagCard r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r5 = CollectionsKt.emptyList();
    L9:
        if ((r10 & 4) == 0) goto L11;
        h53.a.a r0 = h53.a.a.a;
    L13:
        if ((r10 & 8) == 0) goto L16;
        r6 = null;
    L16:
        if ((r10 & 16) == 0) goto L19;
        r7 = null;
    L19:
        if ((r10 & 32) == 0) goto L22;
        r8 = null;
    L22:
        if ((r10 & 64) == 0) goto L24;
        r9 = null;
    L24:
        Intrinsics.checkNotNullParameter(r5, "productFormatGroup");
        Intrinsics.checkNotNullParameter(r0, "categoryStyle");
        this.b = r4;
        this.c = r5;
        this.d = r0;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        scrollConfig("id_detail", AnchorV4TabArea.j);
        return;
    L11:
        r0 = null;
        goto L13
    }
}
