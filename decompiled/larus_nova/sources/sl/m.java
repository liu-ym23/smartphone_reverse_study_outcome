package sl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lsl/m;", "", "", "appendParamsType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "jumpUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("append_params_type")
    private final int appendParamsType;

    @SerializedName("url")
    private String jumpUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L10;
        m r101 = (m) r100;
        if (this.appendParamsType == r101.appendParamsType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.appendParamsType * 31;
        String r101 = this.jumpUrl;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ECJumpAction(appendParamsType=" + this.appendParamsType + ", jumpUrl=" + this.jumpUrl + ")";
    }

    public m() {
        this.appendParamsType = 0;
        this.jumpUrl = null;
    }

    public final int a() {
        return this.appendParamsType;
    }

    public final String b() {
        return this.jumpUrl;
    }

    public final void c(String r100) {
        this.jumpUrl = r100;
    }
}
