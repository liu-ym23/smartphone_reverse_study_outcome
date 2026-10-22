package el;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lel/a;", "", "", "data", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "schema", "b", "setSchema", "", "showDuration", "J", "getShowDuration", "()J", "setShowDuration", "(J)V", "showTime", "c", "setShowTime", "", "popupTypeInt", "I", "getPopupTypeInt", "()I", "setPopupTypeInt", "(I)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("data")
    private String data;

    @SerializedName("popup_type")
    private int popupTypeInt;

    @SerializedName("schema")
    private String schema;

    @SerializedName("show_duration")
    private long showDuration;

    @SerializedName("show_time")
    private long showTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L10;
        return false;
    L10:
        if (this.showDuration == r101.showDuration) goto L12;
        return false;
    L12:
        if (this.showTime == r101.showTime) goto L14;
        return false;
    L14:
        if (this.popupTypeInt == r101.popupTypeInt) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.data;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.schema;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.showDuration;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.showTime;
        return ((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + this.popupTypeInt;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FullLynxPageCouponPopup(data=" + this.data + ", schema=" + this.schema + ", showDuration=" + this.showDuration + ", showTime=" + this.showTime + ", popupTypeInt=" + this.popupTypeInt + ")";
    }

    public a() {
        this.data = null;
        this.schema = null;
        this.showDuration = -1;
        this.showTime = -1;
        this.popupTypeInt = -1;
    }

    public final String a() {
        return this.data;
    }

    public final String b() {
        return this.schema;
    }

    public final long c() {
        return this.showTime;
    }
}
