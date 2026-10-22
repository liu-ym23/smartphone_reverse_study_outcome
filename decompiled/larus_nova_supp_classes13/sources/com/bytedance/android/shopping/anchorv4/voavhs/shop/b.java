package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv3.repository.dto.RecommendInShopProductStruct;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.monitor.ImageMonitorMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends VOIdentifier {
    public static final /* synthetic */ int f = 0;
    public AnchorV4ShopAndStoreDisplay b;
    public AnchorV4ShopAndStoreMeta c;
    public final List<RecommendInShopProductStruct> d;
    public ComponentDTO e;

    public static final class a {
        public static b a(ComponentDTO r5) {
            Intrinsics.checkNotNullParameter(r5, "componentDTO");
            Object r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
            b r2 = new b(null, null, null, null);     // Catch: Throwable -> L20
            VO r3 = r5.getVo();     // Catch: Throwable -> L20
            if (r3 == null) goto L6;
            JsonObject r4 = r3.getDisplay();     // Catch: Throwable -> L20
        L7:
            r2.b = (AnchorV4ShopAndStoreDisplay) u0.a(r4, AnchorV4ShopAndStoreDisplay.class);     // Catch: Throwable -> L20
            VO r6 = r5.getVo();     // Catch: Throwable -> L20
            if (r6 == null) goto L10;
            JsonObject r7 = r6.getMeta();     // Catch: Throwable -> L20
        L11:
            r2.c = (AnchorV4ShopAndStoreMeta) u0.a(r7, AnchorV4ShopAndStoreMeta.class);     // Catch: Throwable -> L20
            r2.e = r5;     // Catch: Throwable -> L20
            AnchorV4ShopAndStoreDisplay r8 = r2.b;     // Catch: Throwable -> L20
            if (r8 == null) goto L18;
            MediaBoxElement r9 = r8.getShopAvatar();     // Catch: Throwable -> L20
            if (r9 == null) goto L18;
            ImageModel r10 = r9.getImageModel();     // Catch: Throwable -> L20
            if (r10 == null) goto L18;
            r10.setImageMonitorMeta(new ImageMonitorMeta("ec_detail", "ec_store_logo_image"));     // Catch: Throwable -> L20
        L18:
            Object r11 = Result.constructor-impl(r2);     // Catch: Throwable -> L20
        L23:
            if (Result.isFailure-impl(r11) == true) goto L27;
            r0 = r11;
        L27:
            return (b) r0;
        L10:
            r7 = null;
            goto L11
        L6:
            r4 = null;
        L20:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L23
        }
    }

    static {
    }

    public b() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L14;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        AnchorV4ShopAndStoreDisplay r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AnchorV4ShopAndStoreMeta r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<RecommendInShopProductStruct> r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ComponentDTO r10 = this.e;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "AnchorV4ShopAndStoreVO(display=" + this.b + ", meta=" + this.c + ", shopRecommends=" + this.d + ", component=" + this.e + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r0 = this.e;
        if (r0 == null) goto L5;
        String r1 = r0.getComponentId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public static b a(b r3, List r4) {
        return new b(r3.b, r3.c, r4, r3.e);
    }

    public b(AnchorV4ShopAndStoreDisplay r1, AnchorV4ShopAndStoreMeta r2, List<RecommendInShopProductStruct> r3, ComponentDTO r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
