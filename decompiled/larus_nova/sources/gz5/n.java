package gz5;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lgz5/n;", "", "", "enabled", "Z", "getEnabled", "()Z", "", "detectDelay", "J", "getDetectDelay", "()J", "", "", "disabledCaseId", "[Ljava/lang/String;", "getDisabledCaseId", "()[Ljava/lang/String;", "api_release"}, k = 1, mv = {1, 4, 0})
public final class n {

    @SerializedName("DetectDelay")
    private final long detectDelay;

    @SerializedName("DisabledCaseIds")
    private final String[] disabledCaseId;

    @SerializedName("Enabled")
    private final boolean enabled;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (this.enabled == r101.enabled) goto L8;
        return false;
    L8:
        if (this.detectDelay == r101.detectDelay) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.disabledCaseId, r101.disabledCaseId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.enabled;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.detectDelay;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String[] r104 = this.disabledCaseId;
        if (r104 == null) goto L8;
        int r105 = Arrays.hashCode(r104);
    L10:
        return r103 + r105;
    L8:
        r105 = 0;
        goto L10
    }

    public final String toString() {
        return "CustomAnchorConfig(enabled=" + this.enabled + ", detectDelay=" + this.detectDelay + ", disabledCaseId=" + Arrays.toString(this.disabledCaseId) + ")";
    }

    public n(int r100) {
        this.enabled = true;
        this.detectDelay = 2000;
        this.disabledCaseId = new String[0];
    }
}
