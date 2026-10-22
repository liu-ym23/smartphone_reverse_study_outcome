package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/i0;", "", "", "progressPercent", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "setProgressPercent", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/ec/model/response/k;", "countDown", "Lcom/bytedance/android/ec/model/response/k;", "b", "()Lcom/bytedance/android/ec/model/response/k;", "setCountDown", "(Lcom/bytedance/android/ec/model/response/k;)V", "", "leftText", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setLeftText", "(Ljava/lang/String;)V", "rightText", "e", "setRightText", "rightTextColor", "f", "setRightTextColor", "backgroundColor", "a", "setBackgroundColor", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 {

    @SerializedName("bg_color")
    private String backgroundColor;

    @SerializedName("count_down")
    private com.bytedance.android.ec.model.response.k countDown;

    @SerializedName("left_text")
    private String leftText;

    @SerializedName("progress_percent")
    private Long progressPercent;

    @SerializedName("right_text")
    private String rightText;

    @SerializedName("right_text_color")
    private String rightTextColor;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i0) == false) goto L18;
        i0 r4 = (i0) r3;
        if (Intrinsics.areEqual(this.progressPercent, r4.progressPercent) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.countDown, r4.countDown) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftText, r4.leftText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightText, r4.rightText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.rightTextColor, r4.rightTextColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.backgroundColor, r4.backgroundColor) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.progressPercent;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        com.bytedance.android.ec.model.response.k r4 = this.countDown;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.leftText;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.rightText;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.rightTextColor;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.backgroundColor;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
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
        return "IntroProgressBar(progressPercent=" + this.progressPercent + ", countDown=" + this.countDown + ", leftText=" + this.leftText + ", rightText=" + this.rightText + ", rightTextColor=" + this.rightTextColor + ", backgroundColor=" + this.backgroundColor + ")";
    }

    public i0() {
        this.progressPercent = null;
        this.countDown = null;
        this.leftText = null;
        this.rightText = null;
        this.rightTextColor = null;
        this.backgroundColor = null;
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final com.bytedance.android.ec.model.response.k b() {
        return this.countDown;
    }

    public final String c() {
        return this.leftText;
    }

    public final Long d() {
        return this.progressPercent;
    }

    public final String e() {
        return this.rightText;
    }

    public final String f() {
        return this.rightTextColor;
    }
}
