package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.s1;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/l0;", "", "", "buttonLabel", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "buttonStyle", "J", "c", "()J", "maskStyle", "e", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b;", "action", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b;", "a", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b;", "Lcom/bytedance/android/ec/model/response/s1;", "click", "Lcom/bytedance/android/ec/model/response/s1;", "d", "()Lcom/bytedance/android/ec/model/response/s1;", "show", "f", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l0 {

    @SerializedName("action")
    private final b action;

    @SerializedName("button_label")
    private final String buttonLabel;

    @SerializedName("style")
    private final long buttonStyle;

    @SerializedName("click")
    private final s1 click;

    @SerializedName("mask_style")
    private final long maskStyle;

    @SerializedName("show")
    private final s1 show;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof l0) == false) goto L18;
        l0 r7 = (l0) r6;
        if (Intrinsics.areEqual(this.buttonLabel, r7.buttonLabel) == true) goto L8;
        return false;
    L8:
        if (this.buttonStyle == r7.buttonStyle) goto L10;
        return false;
    L10:
        if (this.maskStyle == r7.maskStyle) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r7.action) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.click, r7.click) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.show, r7.show) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.buttonLabel;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.buttonStyle;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.maskStyle;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        b r7 = this.action;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        s1 r10 = this.click;
        if (r10 == null) goto L13;
        int r11 = r10.hashCode();
    L14:
        int r12 = (r9 + r11) * 31;
        s1 r13 = this.show;
        if (r13 == null) goto L18;
        r1 = r13.hashCode();
    L18:
        return r12 + r1;
    L13:
        r11 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroPurchaseButton(buttonLabel=" + this.buttonLabel + ", buttonStyle=" + this.buttonStyle + ", maskStyle=" + this.maskStyle + ", action=" + this.action + ", click=" + this.click + ", show=" + this.show + ")";
    }

    public l0() {
        this.buttonLabel = null;
        this.buttonStyle = 0;
        this.maskStyle = 0;
        this.action = null;
        this.click = null;
        this.show = null;
    }

    public final b a() {
        return this.action;
    }

    public final String b() {
        return this.buttonLabel;
    }

    public final long c() {
        return this.buttonStyle;
    }

    public final s1 d() {
        return this.click;
    }

    public final long e() {
        return this.maskStyle;
    }

    public final s1 f() {
        return this.show;
    }
}
