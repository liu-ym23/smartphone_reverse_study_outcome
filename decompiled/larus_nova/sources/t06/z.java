package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lt06/z;", "Lt06/a;", "", "injectJsUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "injectProjectId", "c", "", "Lt06/y;", "enableRulesList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class z extends a {

    @SerializedName("enable_rules")
    private final List<y> enableRulesList;

    @SerializedName("inject_js_url")
    private final String injectJsUrl;

    @SerializedName("inject_project_id")
    private final String injectProjectId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.injectJsUrl, r101.injectJsUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.injectProjectId, r101.injectProjectId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableRulesList, r101.enableRulesList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.injectJsUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.injectProjectId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<y> r107 = this.enableRulesList;
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
        return "WebInjectJSStrategyConfig(injectJsUrl=" + this.injectJsUrl + ", injectProjectId=" + this.injectProjectId + ", enableRulesList=" + this.enableRulesList + ')';
    }

    public z() {
        this.injectJsUrl = null;
        this.injectProjectId = null;
        this.enableRulesList = null;
    }

    public final List<y> a() {
        return this.enableRulesList;
    }

    public final String b() {
        return this.injectJsUrl;
    }

    public final String c() {
        return this.injectProjectId;
    }
}
