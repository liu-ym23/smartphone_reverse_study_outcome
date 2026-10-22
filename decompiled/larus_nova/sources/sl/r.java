package sl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lsl/r;", "", "", "jumpUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "", "type", "I", "getType", "()I", "setType", "(I)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("url")
    private String jumpUrl;

    @SerializedName("type")
    private int type;

    public static final class a {
    }

    static {
    }

    public r() {
        this(null, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L10;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L8;
        return false;
    L8:
        if (this.type == r101.type) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.jumpUrl;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.type;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "ECSkuAction(jumpUrl=" + this.jumpUrl + ", type=" + this.type + ")";
    }

    public final String a() {
        return this.jumpUrl;
    }

    public final int getType() {
        return this.type;
    }

    public r(String r100, int r101) {
        this.jumpUrl = r100;
        this.type = r101;
    }
}
