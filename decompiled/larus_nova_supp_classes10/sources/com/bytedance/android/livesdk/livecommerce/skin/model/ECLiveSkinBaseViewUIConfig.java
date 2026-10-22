package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.bytedance.bdlocation.trace.TraceCons;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\rHÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\rHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\fHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0004\u0018\u0001`\r8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBaseViewUIConfig;", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/AbsECLiveSkinBaseUIConfig;", "text", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinTextElement;", "image", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", TraceCons.METRIC_BACKGROUND, "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBackgroundElement;", "border", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBorderElement;", "radius", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinRadius;", "(Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinTextElement;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBackgroundElement;Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBorderElement;Ljava/util/List;)V", "getBackground", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBackgroundElement;", "getBorder", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBorderElement;", "getImage", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinImageElement;", "getRadius", "()Ljava/util/List;", "getText", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinTextElement;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinBaseViewUIConfig extends AbsECLiveSkinBaseUIConfig {

    @SerializedName("bg")
    private final ECLiveSkinBackgroundElement background;

    @SerializedName("border")
    private final ECLiveSkinBorderElement border;

    @SerializedName("image")
    private final ECLiveSkinImageElement image;

    @SerializedName("radius")
    private final List<Integer> radius;

    @SerializedName("text")
    private final ECLiveSkinTextElement text;

    public ECLiveSkinBaseViewUIConfig() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinBaseViewUIConfig copy$default(ECLiveSkinBaseViewUIConfig r3, ECLiveSkinTextElement r4, ECLiveSkinImageElement r5, ECLiveSkinBackgroundElement r6, ECLiveSkinBorderElement r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.text;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.image;
    L8:
        ECLiveSkinImageElement r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.background;
    L11:
        ECLiveSkinBackgroundElement r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.border;
    L14:
        ECLiveSkinBorderElement r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.getRadius();
    L17:
        ECLiveSkinTextElement r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final ECLiveSkinTextElement component1() {
        return this.text;
    }

    public final ECLiveSkinImageElement component2() {
        return this.image;
    }

    public final ECLiveSkinBackgroundElement component3() {
        return this.background;
    }

    public final ECLiveSkinBorderElement component4() {
        return this.border;
    }

    public final List<Integer> component5() {
        return getRadius();
    }

    public final ECLiveSkinBaseViewUIConfig copy(ECLiveSkinTextElement r8, ECLiveSkinImageElement r9, ECLiveSkinBackgroundElement r10, ECLiveSkinBorderElement r11, List<Integer> r12) {
        return new ECLiveSkinBaseViewUIConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECLiveSkinBaseViewUIConfig) == false) goto L16;
        ECLiveSkinBaseViewUIConfig r4 = (ECLiveSkinBaseViewUIConfig) r3;
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.background, r4.background) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.border, r4.border) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(getRadius(), r4.getRadius()) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        ECLiveSkinTextElement r0 = this.text;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECLiveSkinImageElement r4 = this.image;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECLiveSkinBackgroundElement r7 = this.background;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECLiveSkinBorderElement r10 = this.border;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<Integer> r13 = getRadius();
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
        return "ECLiveSkinBaseViewUIConfig(text=" + this.text + ", image=" + this.image + ", background=" + this.background + ", border=" + this.border + ", radius=" + getRadius() + ")";
    }

    public final ECLiveSkinBackgroundElement getBackground() {
        return this.background;
    }

    public final ECLiveSkinBorderElement getBorder() {
        return this.border;
    }

    public final ECLiveSkinImageElement getImage() {
        return this.image;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig
    public List<Integer> getRadius() {
        return this.radius;
    }

    public final ECLiveSkinTextElement getText() {
        return this.text;
    }

    public ECLiveSkinBaseViewUIConfig(ECLiveSkinTextElement r1, ECLiveSkinImageElement r2, ECLiveSkinBackgroundElement r3, ECLiveSkinBorderElement r4, List<Integer> r5) {
        this.text = r1;
        this.image = r2;
        this.background = r3;
        this.border = r4;
        this.radius = r5;
    }

    public /* synthetic */ ECLiveSkinBaseViewUIConfig(ECLiveSkinTextElement r5, ECLiveSkinImageElement r6, ECLiveSkinBackgroundElement r7, ECLiveSkinBorderElement r8, List r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        ECLiveSkinTextElement r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        ECLiveSkinImageElement r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        ECLiveSkinBackgroundElement r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        ECLiveSkinBorderElement r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        List r13 = null;
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
