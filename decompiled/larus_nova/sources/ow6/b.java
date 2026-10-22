package ow6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Low6/b;", "", "", "allowMode", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "", "whiteNodesList", "Ljava/util/List;", "c", "()Ljava/util/List;", "blackNodesList", "b", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("allow_mode")
    private final int allowMode;

    @SerializedName("black_nodes_list")
    private final List<String> blackNodesList;

    @SerializedName("white_nodes_list")
    private final List<String> whiteNodesList;

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.allowMode == r101.allowMode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.whiteNodesList, r101.whiteNodesList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.blackNodesList, r101.blackNodesList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.allowMode * 31;
        List<String> r101 = this.whiteNodesList;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<String> r105 = this.blackNodesList;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeliveryGoodsDetailPresetSizeSettingInfo(allowMode=" + this.allowMode + ", whiteNodesList=" + this.whiteNodesList + ", blackNodesList=" + this.blackNodesList + ')';
    }

    public final int a() {
        return this.allowMode;
    }

    public final List<String> b() {
        return this.blackNodesList;
    }

    public final List<String> c() {
        return this.whiteNodesList;
    }

    public b(Object r100) {
        this.allowMode = 1;
        this.whiteNodesList = null;
        this.blackNodesList = null;
    }
}
