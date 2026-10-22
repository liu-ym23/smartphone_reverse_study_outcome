package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/w;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/m;", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "imageList", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "moreHintText", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "d", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.m {

    @SerializedName("image_list")
    private final List<ImageModel> imageList;

    @SerializedName("more_hint_text")
    private final TextWithOneIconElement moreHintText;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof w) == false) goto L10;
        w r4 = (w) r3;
        if (Intrinsics.areEqual(this.imageList, r4.imageList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.moreHintText, r4.moreHintText) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return null;
    }

    public final int hashCode() {
        List<ImageModel> r0 = this.imageList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TextWithOneIconElement r4 = this.moreHintText;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "FeaturedShow(imageList=" + this.imageList + ", moreHintText=" + this.moreHintText + ")";
    }

    public w() {
        this.imageList = null;
        this.moreHintText = null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return CollectionsKt.emptyList();
    }

    public final List<ImageModel> c() {
        return this.imageList;
    }

    public final TextWithOneIconElement d() {
        return this.moreHintText;
    }
}
