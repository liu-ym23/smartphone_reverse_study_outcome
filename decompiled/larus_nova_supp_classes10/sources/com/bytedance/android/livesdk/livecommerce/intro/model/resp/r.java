package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r;", "", "Lcom/bytedance/android/ec/model/response/k;", "countDown", "Lcom/bytedance/android/ec/model/response/k;", "c", "()Lcom/bytedance/android/ec/model/response/k;", "setCountDown", "(Lcom/bytedance/android/ec/model/response/k;)V", "", "color", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "borderColor", "a", "setBorderColor", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("bg_color")
    private String backgroundColor;

    @SerializedName("border_color")
    private String borderColor;

    @SerializedName("color")
    private String color;

    @SerializedName("count_down")
    private com.bytedance.android.ec.model.response.k countDown;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r) == false) goto L14;
        r r4 = (r) r3;
        if (Intrinsics.areEqual(this.countDown, r4.countDown) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.backgroundColor, r4.backgroundColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.borderColor, r4.borderColor) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.ec.model.response.k r0 = this.countDown;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.color;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.backgroundColor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.borderColor;
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
        return "IntroElasticTitleCountDown(countDown=" + this.countDown + ", color=" + this.color + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ")";
    }

    public r() {
        this.countDown = null;
        this.color = null;
        this.backgroundColor = null;
        this.borderColor = null;
    }

    public final String a() {
        return this.borderColor;
    }

    public final String b() {
        return this.color;
    }

    public final com.bytedance.android.ec.model.response.k c() {
        return this.countDown;
    }
}
