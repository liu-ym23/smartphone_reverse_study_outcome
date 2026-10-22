package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lt06/x;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "jsScriptUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class x {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("js_script_url")
    private final String jsScriptUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jsScriptUrl, r101.jsScriptUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.jsScriptUrl;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "WebDomStrategyConfig(enable=" + this.enable + ", jsScriptUrl=" + this.jsScriptUrl + ')';
    }

    public x() {
        this.enable = false;
        this.jsScriptUrl = null;
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.jsScriptUrl;
    }
}
