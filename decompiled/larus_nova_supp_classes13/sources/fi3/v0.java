package fi3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lfi3/v0;", "", "", "", "updateSchemaParams", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "", "updatePassThroughParams", "Ljava/util/List;", "c", "()Ljava/util/List;", "schema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/core/btm/a;", "btmFields", "Lcom/bytedance/android/ec/core/btm/a;", "a", "()Lcom/bytedance/android/ec/core/btm/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("btm_fields")
    private final com.bytedance.android.ec.core.btm.a btmFields;

    @SerializedName("sku_schema")
    private final String schema;

    @SerializedName("update_pass_through")
    private final List<Map<String, Object>> updatePassThroughParams;

    @SerializedName("update_params")
    private final Map<String, Object> updateSchemaParams;

    public static final class a {
    }

    static {
    }

    public v0() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof v0) == false) goto L14;
        v0 r4 = (v0) r3;
        if (Intrinsics.areEqual(this.updateSchemaParams, r4.updateSchemaParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.updatePassThroughParams, r4.updatePassThroughParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btmFields, r4.btmFields) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r0 = this.updateSchemaParams;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<Map<String, Object>> r4 = this.updatePassThroughParams;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.schema;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        com.bytedance.android.ec.core.btm.a r10 = this.btmFields;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SchemaUniqueParams2(updateSchemaParams=" + this.updateSchemaParams + ", updatePassThroughParams=" + this.updatePassThroughParams + ", schema=" + this.schema + ", btmFields=" + this.btmFields + ")";
    }

    public final com.bytedance.android.ec.core.btm.a a() {
        return this.btmFields;
    }

    public final String b() {
        return this.schema;
    }

    public final List<Map<String, Object>> c() {
        return this.updatePassThroughParams;
    }

    public final Map<String, Object> d() {
        return this.updateSchemaParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v0(Map<String, ? extends Object> r1, List<? extends Map<String, ? extends Object>> r2, String r3, com.bytedance.android.ec.core.btm.a r4) {
        this.updateSchemaParams = r1;
        this.updatePassThroughParams = r2;
        this.schema = r3;
        this.btmFields = r4;
    }
}
