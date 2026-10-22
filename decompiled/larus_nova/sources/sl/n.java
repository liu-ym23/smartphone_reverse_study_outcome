package sl;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lsl/n;", "", "", "appendParamsType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "useHostRouter", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("append_params_type")
    private final int appendParamsType;

    @SerializedName("url")
    private final String url;

    @SerializedName("use_host_router")
    private final Boolean useHostRouter;

    public n() {
        this(0, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (this.appendParamsType == r101.appendParamsType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.useHostRouter, r101.useHostRouter) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.appendParamsType * 31;
        String r101 = this.url;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.useHostRouter;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ECJumpData(appendParamsType=" + this.appendParamsType + ", url=" + this.url + ", useHostRouter=" + this.useHostRouter + ")";
    }

    public final int a() {
        return this.appendParamsType;
    }

    public final String b() {
        return this.url;
    }

    public final Boolean c() {
        return this.useHostRouter;
    }

    public n(int r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        Boolean r103 = null;
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 4) == 0) goto L11;
        r103 = Boolean.FALSE;
    L11:
        this.appendParamsType = r100;
        this.url = r101;
        this.useHostRouter = r103;
    }
}
