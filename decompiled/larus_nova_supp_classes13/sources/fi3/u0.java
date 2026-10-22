package fi3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001a"}, d2 = {"Lfi3/u0;", "", "", "", "updateSchemaParams", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "", "updatePassThroughParams", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/ec/core/btm/a;", "btmFields", "Lcom/bytedance/android/ec/core/btm/a;", "a", "()Lcom/bytedance/android/ec/core/btm/a;", "optimizeType", "Ljava/lang/String;", "getOptimizeType", "()Ljava/lang/String;", "updateUltimateParams", "d", "diffSchema", "getDiffSchema", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("btm_fields")
    private final com.bytedance.android.ec.core.btm.a btmFields;

    @SerializedName("diff_schema")
    private final String diffSchema;

    @SerializedName("optimize_type")
    private final String optimizeType;

    @SerializedName("update_pass_through")
    private final List<Map<String, Object>> updatePassThroughParams;

    @SerializedName("update_params")
    private final Map<String, Object> updateSchemaParams;

    @SerializedName("update_ultimate_params")
    private final Map<String, String> updateUltimateParams;

    public static final class a {
        public static u0 a(Map r9) {
            Object r0 = null;
            if (r9 != null) goto L5;
            return null;
        L5:
            Object r1 = r9.get("update_params");
            if ((r1 instanceof Map) == true) goto L8;
            r1 = null;
        L8:
            Map r2 = (Map) r1;
            Object r3 = r9.get("btm_fields");
            if ((r3 instanceof Map) == true) goto L11;
            r3 = null;
        L11:
            Map r4 = (Map) r3;
            if (r4 == null) goto L14;
            com.bytedance.android.ec.core.btm.a r5 = com.bytedance.android.ec.core.btm.c.h(r4);
        L15:
            Object r6 = r9.get("update_pass_through");
            if ((r6 instanceof List) == true) goto L18;
            r6 = null;
        L18:
            List r7 = (List) r6;
            Object r8 = r9.get("optimize_type");
            if ((r8 instanceof String) == true) goto L21;
            r8 = null;
        L21:
            String r10 = (String) r8;
            Object r11 = r9.get("update_ultimate_params");
            if ((r11 instanceof Map) == true) goto L24;
            r11 = null;
        L24:
            Map r12 = (Map) r11;
            Object r13 = r9.get("diff_schema");
            if ((r13 instanceof String) == false) goto L29;
            r0 = r13;
        L29:
            return new u0(r2, r7, r5, r10, r12, (String) r0);
        L14:
            r5 = null;
            goto L15
        }
    }

    static {
    }

    public u0() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u0) == false) goto L18;
        u0 r4 = (u0) r3;
        if (Intrinsics.areEqual(this.updateSchemaParams, r4.updateSchemaParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.updatePassThroughParams, r4.updatePassThroughParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.btmFields, r4.btmFields) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.optimizeType, r4.optimizeType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.updateUltimateParams, r4.updateUltimateParams) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.diffSchema, r4.diffSchema) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
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
        com.bytedance.android.ec.core.btm.a r7 = this.btmFields;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.optimizeType;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.updateUltimateParams;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.diffSchema;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
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
        return "SchemaUniqueParams(updateSchemaParams=" + this.updateSchemaParams + ", updatePassThroughParams=" + this.updatePassThroughParams + ", btmFields=" + this.btmFields + ", optimizeType=" + this.optimizeType + ", updateUltimateParams=" + this.updateUltimateParams + ", diffSchema=" + this.diffSchema + ")";
    }

    public final boolean e() {
        return Intrinsics.areEqual(this.optimizeType, "1");
    }

    public final boolean f() {
        return Intrinsics.areEqual(this.optimizeType, "2");
    }

    public final com.bytedance.android.ec.core.btm.a a() {
        return this.btmFields;
    }

    public final List<Map<String, Object>> b() {
        return this.updatePassThroughParams;
    }

    public final Map<String, Object> c() {
        return this.updateSchemaParams;
    }

    public final Map<String, String> d() {
        return this.updateUltimateParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u0(Map<String, ? extends Object> r1, List<? extends Map<String, ? extends Object>> r2, com.bytedance.android.ec.core.btm.a r3, String r4, Map<String, String> r5, String r6) {
        this.updateSchemaParams = r1;
        this.updatePassThroughParams = r2;
        this.btmFields = r3;
        this.optimizeType = r4;
        this.updateUltimateParams = r5;
        this.diffSchema = r6;
    }
}
