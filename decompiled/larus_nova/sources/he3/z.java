package he3;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R0\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Lhe3/z;", "", "", "", ThumbGlideUrl.SOURCE_TEMPLATE, "Ljava/util/Map;", "b", "()Ljava/util/Map;", "", "", "Lhe3/x;", SlcCommonAction.KEY_ACTIONS, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final Map<String, List<x>> actions;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private final Map<String, String> template;

    public z() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L10;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.template, r101.template) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.template;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, List<x>> r104 = this.actions;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedSlcConfig(template=" + this.template + ", actions=" + this.actions + ")";
    }

    public final Map<String, List<x>> a() {
        return this.actions;
    }

    public final Map<String, String> b() {
        return this.template;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z(Map<String, String> r100, Map<String, ? extends List<x>> r101) {
        this.template = r100;
        this.actions = r101;
    }
}
