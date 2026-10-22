package com.bytedance.android.shopping.slice.action.entity;

import com.bytedance.android.ec.core.btm.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0019\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003JG\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/Fields;", "Ljava/io/Serializable;", "", "component1", "component2", "", "", "component3", "Lcom/bytedance/android/ec/core/btm/a;", "component4", "text", "schema", "clickActions", "btmFields", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "getSchema", "Ljava/util/Map;", "getClickActions", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/core/btm/a;", "getBtmFields", "()Lcom/bytedance/android/ec/core/btm/a;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/ec/core/btm/a;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Fields implements Serializable {

    @SerializedName("btm_fields")
    private final a btmFields;

    @SerializedName("click_actions")
    private final Map<String, Object> clickActions;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("text")
    private final String text;

    public Fields() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Fields copy$default(Fields r0, String r1, String r2, Map r3, a r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.schema;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.clickActions;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.btmFields;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.schema;
    }

    public final Map<String, Object> component3() {
        return this.clickActions;
    }

    public final a component4() {
        return this.btmFields;
    }

    public final Fields copy(String r2, String r3, Map<String, ? extends Object> r4, a r5) {
        return new Fields(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Fields) == false) goto L14;
        Fields r4 = (Fields) r3;
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clickActions, r4.clickActions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btmFields, r4.btmFields) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.schema;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Object> r7 = this.clickActions;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        a r10 = this.btmFields;
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

    public String toString() {
        return "Fields(text=" + this.text + ", schema=" + this.schema + ", clickActions=" + this.clickActions + ", btmFields=" + this.btmFields + ")";
    }

    public final a getBtmFields() {
        return this.btmFields;
    }

    public final Map<String, Object> getClickActions() {
        return this.clickActions;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getText() {
        return this.text;
    }

    public Fields(String r1, String r2, Map<String, ? extends Object> r3, a r4) {
        this.text = r1;
        this.schema = r2;
        this.clickActions = r3;
        this.btmFields = r4;
    }

    public /* synthetic */ Fields(String r2, String r3, Map r4, a r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
