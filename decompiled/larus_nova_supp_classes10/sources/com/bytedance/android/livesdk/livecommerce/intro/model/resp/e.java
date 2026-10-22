package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/f;", "stroke", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/f;", "getStroke", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/f;", "", "showArrow", "Z", "getShowArrow", "()Z", "animateImage", "getAnimateImage", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("animate_image")
    private final ECUrlModel animateImage;

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName("show_arrow")
    private final boolean showArrow;

    @SerializedName("stroke")
    private final f stroke;

    public e() {
        this(0);
    }

    public final ECUrlModel a() {
        return this.image;
    }

    public final f b() {
        return this.stroke;
    }

    public final boolean c() {
        return this.showArrow;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.stroke, r4.stroke) == true) goto L10;
        return false;
    L10:
        if (this.showArrow == r4.showArrow) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.animateImage, r4.animateImage) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        ECUrlModel r0 = this.image;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        f r4 = this.stroke;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.showArrow;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        int r9 = (r6 + r8) * 31;
        ECUrlModel r10 = this.animateImage;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        return r9 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroBackground(image=" + this.image + ", stroke=" + this.stroke + ", showArrow=" + this.showArrow + ", animateImage=" + this.animateImage + ")";
    }

    public e(int r2) {
        this.image = null;
        this.stroke = null;
        this.showArrow = false;
        this.animateImage = null;
    }
}
