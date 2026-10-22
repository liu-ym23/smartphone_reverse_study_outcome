package fy6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lfy6/f;", "", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "picLarge", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "picMedium", "b", "picSmall", "c", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("pic_large")
    private final PoiImageUrlModel picLarge;

    @SerializedName("pic_medium")
    private final PoiImageUrlModel picMedium;

    @SerializedName("pic_small")
    private final PoiImageUrlModel picSmall;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.picLarge, r101.picLarge) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picMedium, r101.picMedium) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.picSmall, r101.picSmall) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        PoiImageUrlModel r100 = this.picLarge;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiImageUrlModel r104 = this.picMedium;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PoiImageUrlModel r107 = this.picSmall;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiNavigationCoverImage(picLarge=" + this.picLarge + ", picMedium=" + this.picMedium + ", picSmall=" + this.picSmall + ')';
    }

    public f() {
        this.picLarge = null;
        this.picMedium = null;
        this.picSmall = null;
    }

    public final PoiImageUrlModel a() {
        return this.picLarge;
    }

    public final PoiImageUrlModel b() {
        return this.picMedium;
    }

    public final PoiImageUrlModel c() {
        return this.picSmall;
    }
}
