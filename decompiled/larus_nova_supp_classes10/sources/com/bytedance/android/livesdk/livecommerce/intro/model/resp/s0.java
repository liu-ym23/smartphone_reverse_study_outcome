package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "", "", "duration", "J", "c", "()J", "", "showStyle", "I", "d", "()I", "commentHeight", "b", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r0;", "action", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r0;", "a", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r0;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("action")
    private final r0 action;

    @SerializedName("comment_height")
    private final int commentHeight;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("show_style")
    private final int showStyle;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof s0) == false) goto L14;
        s0 r7 = (s0) r6;
        if (this.duration == r7.duration) goto L8;
        return false;
    L8:
        if (this.showStyle == r7.showStyle) goto L10;
        return false;
    L10:
        if (this.commentHeight == r7.commentHeight) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r7.action) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = this.duration;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.showStyle) * 31) + this.commentHeight) * 31;
        r0 r2 = this.action;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "LiveIntroControlStrategy(duration=" + this.duration + ", showStyle=" + this.showStyle + ", commentHeight=" + this.commentHeight + ", action=" + this.action + ")";
    }

    public s0() {
        this.duration = 0;
        this.showStyle = 0;
        this.commentHeight = 0;
        this.action = null;
    }

    public final r0 a() {
        return this.action;
    }

    public final int b() {
        return this.commentHeight;
    }

    public final long c() {
        return this.duration;
    }

    public final int d() {
        return this.showStyle;
    }
}
