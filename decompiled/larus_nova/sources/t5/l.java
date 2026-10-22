package t5;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/settings/provider/MtsAllowListSettings;", "", "enabled", "", "allowList", "", "", "<init>", "(ZLjava/util/List;)V", "getEnabled", "()Z", "getAllowList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("allow_list")
    private final List<String> allowList;

    @SerializedName("enabled")
    private final boolean enabled;

    public l() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.allowList, r101.allowList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.enabled == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.allowList.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "MtsAllowListSettings(enabled=" + this.enabled + ", allowList=" + this.allowList + ')';
    }

    public final List<String> a() {
        return this.allowList;
    }

    public final boolean b() {
        return this.enabled;
    }

    public l(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "allowList");
        this.enabled = false;
        this.allowList = r101;
    }
}
