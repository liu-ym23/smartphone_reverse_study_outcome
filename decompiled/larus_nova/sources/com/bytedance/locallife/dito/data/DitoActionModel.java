package com.bytedance.locallife.dito.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cBC\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0017\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0017\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003JE\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/bytedance/locallife/dito/data/DitoActionModel;", "Ljava/io/Serializable;", "", "component1", "", "", "component2", "component3", "type", "params", "ditoParams", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "getDitoParams", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoActionModel implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 0;

    @SerializedName("dito_params")
    private final Map<String, Object> ditoParams;

    @SerializedName("params")
    private final Map<String, Object> params;

    @SerializedName("type")
    private final String type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DitoActionModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DitoActionModel copy$default(DitoActionModel r100, String r101, Map r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.params;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ditoParams;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.type;
    }

    public final Map<String, Object> component2() {
        return this.params;
    }

    public final Map<String, Object> component3() {
        return this.ditoParams;
    }

    public final DitoActionModel copy(String r100, Map<String, Object> r101, Map<String, Object> r102) {
        return new DitoActionModel(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoActionModel) == true) goto L8;
        return false;
    L8:
        DitoActionModel r101 = (DitoActionModel) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ditoParams, r101.ditoParams) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.params;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.ditoParams;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DitoActionModel(type=" + this.type + ", params=" + this.params + ", ditoParams=" + this.ditoParams + ')';
    }

    public final Map<String, Object> getDitoParams() {
        return this.ditoParams;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final String getType() {
        return this.type;
    }

    public DitoActionModel(String r100, Map<String, Object> r101, Map<String, Object> r102) {
        this.type = r100;
        this.params = r101;
        this.ditoParams = r102;
    }

    public /* synthetic */ DitoActionModel(String r100, Map r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
