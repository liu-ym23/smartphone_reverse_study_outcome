package jx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ljx6/a;", "", "Ljx6/g;", "defaultAction", "Ljx6/g;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljx6/g;", "Ljx6/h;", "foodBigImageAction", "Ljx6/h;", "b", "()Ljx6/h;", "Ljx6/r;", "previewImageDetailPageAction", "Ljx6/r;", "c", "()Ljx6/r;", "Ljx6/h0;", "videoAction", "Ljx6/h0;", "d", "()Ljx6/h0;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("defaultAction")
    private final g defaultAction;

    @SerializedName("foodBigImage")
    private final h foodBigImageAction;

    @SerializedName("previewImageDetailPage")
    private final r previewImageDetailPageAction;

    @SerializedName("videoAction")
    private final h0 videoAction;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.defaultAction, r101.defaultAction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.foodBigImageAction, r101.foodBigImageAction) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewImageDetailPageAction, r101.previewImageDetailPageAction) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoAction, r101.videoAction) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        g r100 = this.defaultAction;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        h r104 = this.foodBigImageAction;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        r r107 = this.previewImageDetailPageAction;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        h0 r110 = this.videoAction;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionCommonParams(defaultAction=" + this.defaultAction + ", foodBigImageAction=" + this.foodBigImageAction + ", previewImageDetailPageAction=" + this.previewImageDetailPageAction + ", videoAction=" + this.videoAction + ')';
    }

    public a() {
        this.defaultAction = null;
        this.foodBigImageAction = null;
        this.previewImageDetailPageAction = null;
        this.videoAction = null;
    }

    public final g a() {
        return this.defaultAction;
    }

    public final h b() {
        return this.foodBigImageAction;
    }

    public final r c() {
        return this.previewImageDetailPageAction;
    }

    public final h0 d() {
        return this.videoAction;
    }
}
