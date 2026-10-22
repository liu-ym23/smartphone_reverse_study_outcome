package jv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ljv6/f;", "", "", "staticImageUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "animImageUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "imageVersion", "I", "b", "()I", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("anim_image")
    private final String animImageUrl;

    @SerializedName("image_version")
    private final int imageVersion;

    @SerializedName("static_image")
    private final String staticImageUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.staticImageUrl, r101.staticImageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.animImageUrl, r101.animImageUrl) == true) goto L15;
        return false;
    L15:
        if (this.imageVersion == r101.imageVersion) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.staticImageUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.animImageUrl;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.imageVersion;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "IconStyleInfo(staticImageUrl=" + this.staticImageUrl + ", animImageUrl=" + this.animImageUrl + ", imageVersion=" + this.imageVersion + ')';
    }

    public f() {
        this.staticImageUrl = null;
        this.animImageUrl = null;
        this.imageVersion = 0;
    }

    public final String a() {
        return this.animImageUrl;
    }

    public final int b() {
        return this.imageVersion;
    }

    public final String c() {
        return this.staticImageUrl;
    }
}
