package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000bHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\rHÆ\u0003Jk\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\rHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\nHÖ\u0001R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\r8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinPriceUIConfig;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/AbsECLiveSkinBaseUIConfig;", "yuanTagFontSize", "", "integerFontSize", "decimalFontSize", "prefixFontSize", "suffixFontSize", "color", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "radius", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinRadius;", "(IIIIILjava/util/List;Ljava/util/List;)V", "getColor", "()Ljava/util/List;", "getDecimalFontSize", "()I", "getIntegerFontSize", "getPrefixFontSize", "getRadius", "getSuffixFontSize", "getYuanTagFontSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinPriceUIConfig extends AbsECLiveSkinBaseUIConfig {

    @SerializedName("color")
    private final List<String> color;

    @SerializedName("decimal_font_size")
    private final int decimalFontSize;

    @SerializedName("integer_font_size")
    private final int integerFontSize;

    @SerializedName("prefix_font_size")
    private final int prefixFontSize;

    @SerializedName("radius")
    private final List<Integer> radius;

    @SerializedName("suffix_font_size")
    private final int suffixFontSize;

    @SerializedName("dollar_tag_font_size")
    private final int yuanTagFontSize;

    public ECLiveSkinPriceUIConfig() {
        this(0, 0, 0, 0, 0, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinPriceUIConfig copy$default(ECLiveSkinPriceUIConfig r5, int r6, int r7, int r8, int r9, int r10, List r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.yuanTagFontSize;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.integerFontSize;
    L8:
        int r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.decimalFontSize;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.prefixFontSize;
    L14:
        int r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.suffixFontSize;
    L17:
        int r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.color;
    L20:
        List r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.getRadius();
    L23:
        int r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final int component1() {
        return this.yuanTagFontSize;
    }

    public final int component2() {
        return this.integerFontSize;
    }

    public final int component3() {
        return this.decimalFontSize;
    }

    public final int component4() {
        return this.prefixFontSize;
    }

    public final int component5() {
        return this.suffixFontSize;
    }

    public final List<String> component6() {
        return this.color;
    }

    public final List<Integer> component7() {
        return getRadius();
    }

    public final ECLiveSkinPriceUIConfig copy(int r10, int r11, int r12, int r13, int r14, List<String> r15, List<Integer> r16) {
        return new ECLiveSkinPriceUIConfig(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECLiveSkinPriceUIConfig) == false) goto L20;
        ECLiveSkinPriceUIConfig r4 = (ECLiveSkinPriceUIConfig) r3;
        if (this.yuanTagFontSize == r4.yuanTagFontSize) goto L8;
        return false;
    L8:
        if (this.integerFontSize == r4.integerFontSize) goto L10;
        return false;
    L10:
        if (this.decimalFontSize == r4.decimalFontSize) goto L12;
        return false;
    L12:
        if (this.prefixFontSize == r4.prefixFontSize) goto L14;
        return false;
    L14:
        if (this.suffixFontSize == r4.suffixFontSize) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getRadius(), r4.getRadius()) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = ((((((((this.yuanTagFontSize * 31) + this.integerFontSize) * 31) + this.decimalFontSize) * 31) + this.prefixFontSize) * 31) + this.suffixFontSize) * 31;
        List<String> r1 = this.color;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        List<Integer> r5 = getRadius();
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "ECLiveSkinPriceUIConfig(yuanTagFontSize=" + this.yuanTagFontSize + ", integerFontSize=" + this.integerFontSize + ", decimalFontSize=" + this.decimalFontSize + ", prefixFontSize=" + this.prefixFontSize + ", suffixFontSize=" + this.suffixFontSize + ", color=" + this.color + ", radius=" + getRadius() + ")";
    }

    public final List<String> getColor() {
        return this.color;
    }

    public final int getDecimalFontSize() {
        return this.decimalFontSize;
    }

    public final int getIntegerFontSize() {
        return this.integerFontSize;
    }

    public final int getPrefixFontSize() {
        return this.prefixFontSize;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig
    public List<Integer> getRadius() {
        return this.radius;
    }

    public final int getSuffixFontSize() {
        return this.suffixFontSize;
    }

    public final int getYuanTagFontSize() {
        return this.yuanTagFontSize;
    }

    public ECLiveSkinPriceUIConfig(int r1, int r2, int r3, int r4, int r5, List<String> r6, List<Integer> r7) {
        this.yuanTagFontSize = r1;
        this.integerFontSize = r2;
        this.decimalFontSize = r3;
        this.prefixFontSize = r4;
        this.suffixFontSize = r5;
        this.color = r6;
        this.radius = r7;
    }

    public /* synthetic */ ECLiveSkinPriceUIConfig(int r6, int r7, int r8, int r9, int r10, List r11, List r12, int r13, DefaultConstructorMarker r14) {
        int r0 = 0;
        if ((r13 & 1) == 0) goto L5;
        int r15 = 0;
    L7:
        if ((r13 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r13 & 4) == 0) goto L13;
        int r2 = 0;
    L15:
        if ((r13 & 8) == 0) goto L17;
        int r3 = 0;
    L19:
        if ((r13 & 16) != 0) goto L23;
        r0 = r10;
    L23:
        if ((r13 & 32) == 0) goto L25;
        List r4 = null;
    L27:
        if ((r13 & 64) == 0) goto L29;
        List r16 = null;
    L30:
        this(r15, r1, r2, r3, r0, r4, r16);
        return;
    L29:
        r16 = r12;
        goto L30
    L25:
        r4 = r11;
        goto L27
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r15 = r6;
        goto L7
    }
}
