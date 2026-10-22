package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/QualityEmphasizeElement;", "Ljava/io/Serializable;", "backgroundImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "title", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "desc", "radius", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", "padding", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "(Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;)V", "getBackgroundImg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getDesc", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getPadding", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "getRadius", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class QualityEmphasizeElement implements Serializable {

    @SerializedName("background_img")
    private final ECUrlModel backgroundImg;

    @SerializedName("desc")
    private final TextElement desc;

    @SerializedName("padding")
    private final Padding padding;

    @SerializedName("radius")
    private final Radius radius;

    @SerializedName("title")
    private final TextElement title;

    public QualityEmphasizeElement() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ QualityEmphasizeElement copy$default(QualityEmphasizeElement r3, ECUrlModel r4, TextElement r5, TextElement r6, Radius r7, Padding r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.backgroundImg;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.title;
    L8:
        TextElement r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.desc;
    L11:
        TextElement r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.radius;
    L14:
        Radius r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.padding;
    L17:
        ECUrlModel r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final ECUrlModel component1() {
        return this.backgroundImg;
    }

    public final TextElement component2() {
        return this.title;
    }

    public final TextElement component3() {
        return this.desc;
    }

    public final Radius component4() {
        return this.radius;
    }

    public final Padding component5() {
        return this.padding;
    }

    public final QualityEmphasizeElement copy(ECUrlModel r8, TextElement r9, TextElement r10, Radius r11, Padding r12) {
        return new QualityEmphasizeElement(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof QualityEmphasizeElement) == false) goto L16;
        QualityEmphasizeElement r4 = (QualityEmphasizeElement) r3;
        if (Intrinsics.areEqual(this.backgroundImg, r4.backgroundImg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.desc, r4.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.radius, r4.radius) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.padding, r4.padding) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        ECUrlModel r0 = this.backgroundImg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TextElement r4 = this.title;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        TextElement r7 = this.desc;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Radius r10 = this.radius;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Padding r13 = this.padding;
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

    public String toString() {
        return "QualityEmphasizeElement(backgroundImg=" + this.backgroundImg + ", title=" + this.title + ", desc=" + this.desc + ", radius=" + this.radius + ", padding=" + this.padding + ")";
    }

    public final ECUrlModel getBackgroundImg() {
        return this.backgroundImg;
    }

    public final TextElement getDesc() {
        return this.desc;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final Radius getRadius() {
        return this.radius;
    }

    public final TextElement getTitle() {
        return this.title;
    }

    public QualityEmphasizeElement(ECUrlModel r1, TextElement r2, TextElement r3, Radius r4, Padding r5) {
        this.backgroundImg = r1;
        this.title = r2;
        this.desc = r3;
        this.radius = r4;
        this.padding = r5;
    }

    public /* synthetic */ QualityEmphasizeElement(ECUrlModel r5, TextElement r6, TextElement r7, Radius r8, Padding r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        ECUrlModel r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        TextElement r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        TextElement r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Radius r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Padding r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
