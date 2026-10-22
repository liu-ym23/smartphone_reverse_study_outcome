package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/api/image/a;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "ignoreMatch", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "matchersType", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "", "minBitmapSizeBytes", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "maxBitmapSizeBytes", "a", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a implements d.b {

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("max_bitmap_size_bytes")
    private final Integer maxBitmapSizeBytes;

    @SerializedName("min_bitmap_size_bytes")
    private final Integer minBitmapSizeBytes;

    @SerializedName("support_mather")
    private final List<d> supportMather;

    public a() {
        this(null);
    }

    public final int hashCode() {
        Boolean r0 = this.ignoreMatch;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<d> r4 = this.supportMather;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.matchersType;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.minBitmapSizeBytes;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.maxBitmapSizeBytes;
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
        return "ECImageBitmapPrepareToDrawModel(ignoreMatch=" + this.ignoreMatch + ", supportMather=" + this.supportMather + ", matchersType=" + this.matchersType + ", minBitmapSizeBytes=" + this.minBitmapSizeBytes + ", maxBitmapSizeBytes=" + this.maxBitmapSizeBytes + ")";
    }

    public final Integer a() {
        return this.maxBitmapSizeBytes;
    }

    public final Integer b() {
        return this.minBitmapSizeBytes;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final Boolean c() {
        return this.ignoreMatch;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final List<d> e() {
        return this.supportMather;
    }

    @Override // com.bytedance.android.shopping.api.image.d.b
    public final String g() {
        return this.matchersType;
    }

    public a(Object r1) {
        this.ignoreMatch = null;
        this.supportMather = null;
        this.matchersType = null;
        this.minBitmapSizeBytes = null;
        this.maxBitmapSizeBytes = null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L16;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.ignoreMatch, r4.ignoreMatch) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.supportMather, r4.supportMather) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.matchersType, r4.matchersType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minBitmapSizeBytes, r4.minBitmapSizeBytes) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.maxBitmapSizeBytes, r4.maxBitmapSizeBytes) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }
}
