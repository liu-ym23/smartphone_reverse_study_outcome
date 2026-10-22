package fi3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001a"}, d2 = {"Lfi3/u0;", "", "", "", "updateSchemaParams", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "", "updatePassThroughParams", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/ec/core/btm/a;", "btmFields", "Lcom/bytedance/android/ec/core/btm/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/core/btm/a;", "optimizeType", "Ljava/lang/String;", "getOptimizeType", "()Ljava/lang/String;", "updateUltimateParams", "d", "diffSchema", "getDiffSchema", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477328a = 0;

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
        public static u0 a(Map r100) {
            Object r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            Object r102 = r100.get("update_params");
            if ((r102 instanceof Map) == true) goto L8;
            r102 = null;
        L8:
            Map r103 = (Map) r102;
            Object r104 = r100.get("btm_fields");
            if ((r104 instanceof Map) == true) goto L11;
            r104 = null;
        L11:
            Map r105 = (Map) r104;
            if (r105 == null) goto L14;
            com.bytedance.android.ec.core.btm.a r106 = com.bytedance.android.ec.core.btm.c.h(r105);
        L15:
            Object r107 = r100.get("update_pass_through");
            if ((r107 instanceof List) == true) goto L18;
            r107 = null;
        L18:
            List r108 = (List) r107;
            Object r109 = r100.get("optimize_type");
            if ((r109 instanceof String) == true) goto L21;
            r109 = null;
        L21:
            String r110 = (String) r109;
            Object r111 = r100.get("update_ultimate_params");
            if ((r111 instanceof Map) == true) goto L24;
            r111 = null;
        L24:
            Map r112 = (Map) r111;
            Object r113 = r100.get("diff_schema");
            if ((r113 instanceof String) == false) goto L29;
            r101 = r113;
        L29:
            return new u0(r103, r108, r106, r110, r112, (String) r101);
        L14:
            r106 = null;
            goto L15
        }
    }

    static {
    }

    public u0() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u0) == false) goto L18;
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.updateSchemaParams, r101.updateSchemaParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.updatePassThroughParams, r101.updatePassThroughParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.btmFields, r101.btmFields) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.optimizeType, r101.optimizeType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.updateUltimateParams, r101.updateUltimateParams) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.diffSchema, r101.diffSchema) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
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
        com.bytedance.android.ec.core.btm.a r107 = this.btmFields;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.optimizeType;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.updateUltimateParams;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.diffSchema;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
    public u0(Map<String, ? extends Object> r100, List<? extends Map<String, ? extends Object>> r101, com.bytedance.android.ec.core.btm.a r102, String r103, Map<String, String> r104, String r105) {
        this.updateSchemaParams = r100;
        this.updatePassThroughParams = r101;
        this.btmFields = r102;
        this.optimizeType = r103;
        this.updateUltimateParams = r104;
        this.diffSchema = r105;
    }
}
