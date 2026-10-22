package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB)\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J+\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBorderElement;", "Ljava/io/Serializable;", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "component1", "", "component2", "color", "borderWidth", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getColor", "()Ljava/util/List;", "F", "getBorderWidth", "()F", "<init>", "(Ljava/util/List;F)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinBorderElement implements Serializable {
    public static final a Companion = null;

    @SerializedName("border_width")
    private final float borderWidth;

    @SerializedName("color")
    private final List<String> color;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECLiveSkinBorderElement() {
        List r2 = null;
        this(r2, 0.0f, 3, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinBorderElement copy$default(ECLiveSkinBorderElement r0, List r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.color;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.borderWidth;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<String> component1() {
        return this.color;
    }

    public final float component2() {
        return this.borderWidth;
    }

    public final ECLiveSkinBorderElement copy(List<String> r2, float r3) {
        return new ECLiveSkinBorderElement(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECLiveSkinBorderElement) == false) goto L10;
        ECLiveSkinBorderElement r4 = (ECLiveSkinBorderElement) r3;
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.borderWidth, r4.borderWidth) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r0 = this.color;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + Float.floatToIntBits(this.borderWidth);
    L5:
        r1 = 0;
        goto L7
    }

    public String toString() {
        return "ECLiveSkinBorderElement(color=" + this.color + ", borderWidth=" + this.borderWidth + ")";
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final List<String> getColor() {
        return this.color;
    }

    public ECLiveSkinBorderElement(List<String> r1, float r2) {
        this.color = r1;
        this.borderWidth = r2;
    }

    public /* synthetic */ ECLiveSkinBorderElement(List r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0.3f;
    L8:
        this(r1, r2);
    }
}
