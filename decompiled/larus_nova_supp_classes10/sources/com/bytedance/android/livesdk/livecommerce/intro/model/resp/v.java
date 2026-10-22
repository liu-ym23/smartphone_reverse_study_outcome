package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.t1;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/v;", "", "Lcom/bytedance/android/ec/model/response/t1;", TraceCons.METRIC_BACKGROUND, "Lcom/bytedance/android/ec/model/response/t1;", "a", "()Lcom/bytedance/android/ec/model/response/t1;", "leftIcon", "c", "rightIcon", "d", "", "text", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "textSize", "I", "f", "()I", "jumpUrl", "b", "Lcom/bytedance/android/ec/model/response/s1;", "track", "Lcom/bytedance/android/ec/model/response/s1;", "g", "()Lcom/bytedance/android/ec/model/response/s1;", "setTrack", "(Lcom/bytedance/android/ec/model/response/s1;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName(TraceCons.METRIC_BACKGROUND)
    private final t1 background;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("left_icon")
    private final t1 leftIcon;

    @SerializedName("right_icon")
    private final t1 rightIcon;

    @SerializedName("text")
    private final String text;

    @SerializedName("font_size")
    private final int textSize;

    @SerializedName("track")
    private s1 track;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof v) == false) goto L20;
        v r4 = (v) r3;
        if (Intrinsics.areEqual(this.background, r4.background) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.leftIcon, r4.leftIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rightIcon, r4.rightIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L14;
        return false;
    L14:
        if (this.textSize == r4.textSize) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.jumpUrl, r4.jumpUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.track, r4.track) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        t1 r0 = this.background;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        t1 r4 = this.leftIcon;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        t1 r7 = this.rightIcon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.text;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (((r9 + r11) * 31) + this.textSize) * 31;
        String r13 = this.jumpUrl;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        s1 r16 = this.track;
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
        return "IntroImageBottomBanner(background=" + this.background + ", leftIcon=" + this.leftIcon + ", rightIcon=" + this.rightIcon + ", text=" + this.text + ", textSize=" + this.textSize + ", jumpUrl=" + this.jumpUrl + ", track=" + this.track + ")";
    }

    public v() {
        this.background = null;
        this.leftIcon = null;
        this.rightIcon = null;
        this.text = null;
        this.textSize = 0;
        this.jumpUrl = null;
        this.track = null;
    }

    public final t1 a() {
        return this.background;
    }

    public final String b() {
        return this.jumpUrl;
    }

    public final t1 c() {
        return this.leftIcon;
    }

    public final t1 d() {
        return this.rightIcon;
    }

    public final String e() {
        return this.text;
    }

    public final int f() {
        return this.textSize;
    }

    public final s1 g() {
        return this.track;
    }
}
