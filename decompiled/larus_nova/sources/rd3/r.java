package rd3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lrd3/r;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", AppConstants.BUNDLE_TIP, "Ljava/lang/String;", "getTip", "()Ljava/lang/String;", "resultType", "getResultType", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("result_type")
    private final String resultType;

    @SerializedName(AppConstants.BUNDLE_TIP)
    private final String tip;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L12;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tip, r101.tip) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.resultType, r101.resultType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.icon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.tip;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.resultType;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RedPacketToast(icon=" + this.icon + ", tip=" + this.tip + ", resultType=" + this.resultType + ")";
    }

    public r() {
        this.icon = null;
        this.tip = null;
        this.resultType = null;
    }
}
