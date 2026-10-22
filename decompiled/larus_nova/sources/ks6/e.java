package ks6;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lks6/e;", "", "", "triggerType", "Ljava/lang/String;", "getTriggerType", "()Ljava/lang/String;", "", "triggerSource", "Ljava/util/List;", "getTriggerSource", "()Ljava/util/List;", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("trigger_source")
    private final List<String> triggerSource;

    @SerializedName("trigger_type")
    private final String triggerType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.triggerType, r101.triggerType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.triggerSource, r101.triggerSource) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.triggerType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.triggerSource;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TriggerExpressionData(triggerType=" + this.triggerType + ", triggerSource=" + this.triggerSource + ')';
    }

    public e() {
        this.triggerType = "";
        this.triggerSource = null;
    }
}
