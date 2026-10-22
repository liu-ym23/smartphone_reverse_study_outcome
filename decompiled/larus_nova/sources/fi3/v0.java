package fi3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lfi3/v0;", "", "", "", "updateSchemaParams", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "", "updatePassThroughParams", "Ljava/util/List;", "c", "()Ljava/util/List;", "schema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/core/btm/a;", "btmFields", "Lcom/bytedance/android/ec/core/btm/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/core/btm/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477336a = 0;

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

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v0) == false) goto L14;
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.updateSchemaParams, r101.updateSchemaParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.updatePassThroughParams, r101.updatePassThroughParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btmFields, r101.btmFields) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.updateSchemaParams;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Map<String, Object>> r104 = this.updatePassThroughParams;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.android.ec.core.btm.a r110 = this.btmFields;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
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
    public v0(Map<String, ? extends Object> r100, List<? extends Map<String, ? extends Object>> r101, String r102, com.bytedance.android.ec.core.btm.a r103) {
        this.updateSchemaParams = r100;
        this.updatePassThroughParams = r101;
        this.schema = r102;
        this.btmFields = r103;
    }
}
