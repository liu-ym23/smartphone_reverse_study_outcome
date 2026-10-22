package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/slice/viewmanagers/s;", "", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "height", "I", "a", "()I", "width", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("height")
    private final int height;

    @SerializedName("url")
    private final String url;

    @SerializedName("width")
    private final int width;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s) == false) goto L12;
        s r4 = (s) r3;
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L8;
        return false;
    L8:
        if (this.height == r4.height) goto L10;
        return false;
    L10:
        if (this.width == r4.width) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.url;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((r1 * 31) + this.height) * 31) + this.width;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "ImgStruct(url=" + this.url + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public s() {
        this.url = null;
        this.height = 0;
        this.width = 0;
    }

    public final int a() {
        return this.height;
    }

    public final String b() {
        return this.url;
    }

    public final int c() {
        return this.width;
    }
}
