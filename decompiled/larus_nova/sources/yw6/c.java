package yw6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lyw6/c;", "", "", "height", "I", "getHeight", "()I", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "width", "getWidth", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("height")
    private final int height;

    @SerializedName("url")
    private final String url;

    @SerializedName("width")
    private final int width;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.height == r101.height) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (this.width == r101.width) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.height * 31;
        String r101 = this.url;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.width;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BubbleIcon(height=" + this.height + ", url=" + this.url + ", width=" + this.width + ')';
    }

    public c() {
        this.height = 0;
        this.url = null;
        this.width = 0;
    }
}
