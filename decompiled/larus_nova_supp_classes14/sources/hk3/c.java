package hk3;

import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lhk3/c;", "", "Lcom/google/gson/JsonObject;", "allowList", "Lcom/google/gson/JsonObject;", "a", "()Lcom/google/gson/JsonObject;", "", CommentConstants$CmtLongPanelStrategy.DEFAULT, "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("allow_list")
    private final JsonObject allowList;

    /* JADX INFO: renamed from: default, reason: not valid java name */
    @SerializedName(CommentConstants$CmtLongPanelStrategy.DEFAULT)
    private final Integer f0default;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.allowList, r4.allowList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f0default, r4.f0default) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        JsonObject r0 = this.allowList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f0default;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TabSetting(allowList=" + this.allowList + ", default=" + this.f0default + ")";
    }

    public c() {
        this.allowList = null;
        this.f0default = null;
    }

    public final JsonObject a() {
        return this.allowList;
    }

    public final Integer b() {
        return this.f0default;
    }
}
