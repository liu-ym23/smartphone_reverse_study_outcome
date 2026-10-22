package xi2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lxi2/f;", "", "", "jumpUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/model/live/b;", "elementBlocks", "Ljava/util/List;", "a", "()Ljava/util/List;", "schemaParamsType", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("element_blocks")
    private final List<com.bytedance.android.ec.model.live.b> elementBlocks;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("schema_params_type")
    private final String schemaParamsType;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L12;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.jumpUrl, r4.jumpUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.elementBlocks, r4.elementBlocks) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schemaParamsType, r4.schemaParamsType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.jumpUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<com.bytedance.android.ec.model.live.b> r4 = this.elementBlocks;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.schemaParamsType;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECBackgroundContent(jumpUrl=" + this.jumpUrl + ", elementBlocks=" + this.elementBlocks + ", schemaParamsType=" + this.schemaParamsType + ")";
    }

    public f() {
        this.jumpUrl = null;
        this.elementBlocks = null;
        this.schemaParamsType = null;
    }

    public final List<com.bytedance.android.ec.model.live.b> a() {
        return this.elementBlocks;
    }

    public final String b() {
        return this.jumpUrl;
    }

    public final String c() {
        return this.schemaParamsType;
    }
}
