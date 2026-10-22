package nv6;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lnv6/w;", "", "", "height", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "width", "c", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("height")
    private final float height;

    @SerializedName("url")
    private final String url;

    @SerializedName("width")
    private final float width;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Float.compare(this.height, r101.height) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.width, r101.width) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.height) * 31;
        String r101 = this.url;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + Float.floatToIntBits(this.width);
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ImageStruct(height=" + this.height + ", url=" + this.url + ", width=" + this.width + ')';
    }

    public w() {
        this.height = 0.0f;
        this.url = "";
        this.width = 0.0f;
    }

    public final float a() {
        return this.height;
    }

    public final String b() {
        return this.url;
    }

    public final float c() {
        return this.width;
    }
}
