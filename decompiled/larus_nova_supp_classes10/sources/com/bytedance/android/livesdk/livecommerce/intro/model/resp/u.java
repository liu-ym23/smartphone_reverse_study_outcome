package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/u;", "", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/t;", "icons", "Ljava/util/List;", "d", "()Ljava/util/List;", "setIcons", "(Ljava/util/List;)V", "", "borderUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "cover", "c", "f", "(Ljava/lang/String;)V", "maskHint", "e", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroImageBottom;", "bottom", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroImageBottom;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroImageBottom;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("border_url")
    private final String borderUrl;

    @SerializedName("bottom")
    private final IntroImageBottom bottom;

    @SerializedName("cover")
    private String cover;

    @SerializedName("icons")
    private List<t> icons;

    @SerializedName("mask_hint")
    private final String maskHint;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u) == false) goto L16;
        u r4 = (u) r3;
        if (Intrinsics.areEqual(this.icons, r4.icons) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.borderUrl, r4.borderUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cover, r4.cover) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maskHint, r4.maskHint) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bottom, r4.bottom) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        List<t> r0 = this.icons;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.borderUrl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.cover;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.maskHint;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        IntroImageBottom r13 = this.bottom;
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
        return "IntroImage(icons=" + this.icons + ", borderUrl=" + this.borderUrl + ", cover=" + this.cover + ", maskHint=" + this.maskHint + ", bottom=" + this.bottom + ")";
    }

    public u() {
        this.icons = null;
        this.borderUrl = null;
        this.cover = null;
        this.maskHint = null;
        this.bottom = null;
    }

    public final String a() {
        return this.borderUrl;
    }

    public final IntroImageBottom b() {
        return this.bottom;
    }

    public final String c() {
        return this.cover;
    }

    public final List<t> d() {
        return this.icons;
    }

    public final String e() {
        return this.maskHint;
    }

    public final void f(String r1) {
        this.cover = r1;
    }
}
