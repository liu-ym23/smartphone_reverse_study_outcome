package ea6;

import com.bytedance.kmp.ec.yata.common.platform.jsonadapter.YataFieldsAdapter;
import com.bytedance.kmp.ec.yata.common.platform.l;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lea6/c;", "Lcom/bytedance/kmp/ec/yata/common/platform/l;", "", "", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/p;", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "", "linkage", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "operatorType", "Ljava/lang/String;", "getOperatorType", "()Ljava/lang/String;", "setOperatorType", "(Ljava/lang/String;)V", OnekeyLoginConstants.CU_KEY_OPERATOR, "getOperator", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class c implements l {

    @SerializedName("data")
    private final Map<String, p> data;

    @SerializedName("linkage")
    @JsonAdapter(YataFieldsAdapter.class)
    private final Map<String, Object> linkage;

    @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
    private final String operator;

    @SerializedName("operator_type")
    private String operatorType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.linkage, r101.linkage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.operatorType, r101.operatorType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.operator, r101.operator) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Map<String, p> r100 = this.data;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.linkage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.operatorType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.operator;
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
        return "UplinkParam(data=" + this.data + ", linkage=" + this.linkage + ", operatorType=" + this.operatorType + ", operator=" + this.operator + ')';
    }

    public final Map<String, Object> a() {
        return this.linkage;
    }

    public c(Map<String, p> r100, Map<String, ? extends Object> r101, String r102, String r103) {
        this.data = r100;
        this.linkage = r101;
        this.operatorType = r102;
        this.operator = r103;
    }
}
