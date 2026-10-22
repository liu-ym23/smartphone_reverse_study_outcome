package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u000fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;", "Ljava/io/Serializable;", "shadowColor", "", "shadowBlur", "", "shadowOffset", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ShadowOffset;", "(Ljava/lang/String;Ljava/lang/Double;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ShadowOffset;)V", "getShadowBlur", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getShadowColor", "()Ljava/lang/String;", "shadowColorInt", "", "getShadowColorInt", "()Ljava/lang/Integer;", "shadowColorInt$delegate", "Lkotlin/Lazy;", "getShadowOffset", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ShadowOffset;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ShadowOffset;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontShadow;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FontShadow implements Serializable {

    @SerializedName("blur")
    private final Double shadowBlur;

    @SerializedName("color")
    private final String shadowColor;
    private final Lazy shadowColorInt$delegate;

    @SerializedName("offset")
    private final ShadowOffset shadowOffset;

    public FontShadow() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FontShadow copy$default(FontShadow r0, String r1, Double r2, ShadowOffset r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.shadowColor;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.shadowBlur;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.shadowOffset;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.shadowColor;
    }

    public final Double component2() {
        return this.shadowBlur;
    }

    public final ShadowOffset component3() {
        return this.shadowOffset;
    }

    public final FontShadow copy(String r2, Double r3, ShadowOffset r4) {
        return new FontShadow(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FontShadow) == false) goto L12;
        FontShadow r4 = (FontShadow) r3;
        if (Intrinsics.areEqual(this.shadowColor, r4.shadowColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shadowBlur, r4.shadowBlur) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shadowOffset, r4.shadowOffset) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final Integer getShadowColorInt() {
        return (Integer) this.shadowColorInt$delegate.getValue();
    }

    public int hashCode() {
        String r0 = this.shadowColor;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Double r4 = this.shadowBlur;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ShadowOffset r7 = this.shadowOffset;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "FontShadow(shadowColor=" + this.shadowColor + ", shadowBlur=" + this.shadowBlur + ", shadowOffset=" + this.shadowOffset + ")";
    }

    public final Double getShadowBlur() {
        return this.shadowBlur;
    }

    public final String getShadowColor() {
        return this.shadowColor;
    }

    public final ShadowOffset getShadowOffset() {
        return this.shadowOffset;
    }

    public FontShadow(String r1, Double r2, ShadowOffset r3) {
        this.shadowColor = r1;
        this.shadowBlur = r2;
        this.shadowOffset = r3;
        this.shadowColorInt$delegate = LazyKt.lazy(new FontShadow$shadowColorInt$2(this));
    }

    public /* synthetic */ FontShadow(String r2, Double r3, ShadowOffset r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
