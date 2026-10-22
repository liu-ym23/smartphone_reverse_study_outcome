package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lnv6/h0;", "", "", "isAutoLoadShelf", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", "", "requestParams", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "shelfFromPosition", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class h0 {

    @SerializedName("is_auto_load_shelf")
    private final Boolean isAutoLoadShelf;

    @SerializedName("request_params")
    private final Map<String, String> requestParams;

    @SerializedName("shelf_from_position")
    private final String shelfFromPosition;

    public h0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.isAutoLoadShelf, r101.isAutoLoadShelf) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestParams, r101.requestParams) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.shelfFromPosition, r101.shelfFromPosition) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.isAutoLoadShelf;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.requestParams;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shelfFromPosition;
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
        return "PackConfig(isAutoLoadShelf=" + this.isAutoLoadShelf + ", requestParams=" + this.requestParams + ", shelfFromPosition=" + this.shelfFromPosition + ')';
    }

    public final Map<String, String> a() {
        return this.requestParams;
    }

    public final String b() {
        return this.shelfFromPosition;
    }

    public final Boolean c() {
        return this.isAutoLoadShelf;
    }

    public h0(Object r100) {
        this.isAutoLoadShelf = null;
        this.requestParams = null;
        this.shelfFromPosition = null;
    }
}
