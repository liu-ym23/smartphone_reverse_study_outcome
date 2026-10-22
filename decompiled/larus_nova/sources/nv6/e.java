package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a¨\u0006\u001f"}, d2 = {"Lnv6/e;", "", "Lnv6/w;", "image", "Lnv6/w;", "c", "()Lnv6/w;", "", "text", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "count", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "", "type", "I", "getType", "()I", "", "textSize", "Ljava/lang/Float;", "e", "()Ljava/lang/Float;", "countSize", "b", "xSize", "f", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("count")
    private final Long count;

    @SerializedName("count_size")
    private final Float countSize;

    @SerializedName("image")
    private final w image;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_size")
    private final Float textSize;

    @SerializedName("type")
    private final int type;

    @SerializedName("x_size")
    private final Float xSize;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.count, r101.count) == true) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textSize, r101.textSize) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.countSize, r101.countSize) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.xSize, r101.xSize) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        w r100 = this.image;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.count;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.type) * 31;
        Float r110 = this.textSize;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.countSize;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.xSize;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "AtmosphereContent(image=" + this.image + ", text=" + this.text + ", count=" + this.count + ", type=" + this.type + ", textSize=" + this.textSize + ", countSize=" + this.countSize + ", xSize=" + this.xSize + ')';
    }

    public e() {
        this.image = null;
        this.text = null;
        this.count = null;
        this.type = 0;
        this.textSize = null;
        this.countSize = null;
        this.xSize = null;
    }

    public final Long a() {
        return this.count;
    }

    public final Float b() {
        return this.countSize;
    }

    public final w c() {
        return this.image;
    }

    public final String d() {
        return this.text;
    }

    public final Float e() {
        return this.textSize;
    }

    public final Float f() {
        return this.xSize;
    }

    public final int getType() {
        return this.type;
    }
}
