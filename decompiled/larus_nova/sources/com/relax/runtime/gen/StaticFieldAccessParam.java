package com.relax.runtime.gen;

import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00020\u0006`\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00020\u0006`\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J[\u0010\u001e\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u00042\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00020\u0006`\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00020\u0006`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006%"}, d2 = {"Lcom/relax/runtime/gen/StaticFieldAccessParam;", "", "params", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "signatures", "", "field", "fieldSign", PushClientConstants.TAG_CLASS_NAME, "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "getField", "setField", "getFieldSign", "setFieldSign", "getParams", "()Ljava/util/ArrayList;", "setParams", "(Ljava/util/ArrayList;)V", "getSignatures", "setSignatures", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StaticFieldAccessParam {
    private String className;
    private String field;
    private String fieldSign;
    private ArrayList<Object> params;
    private ArrayList<String> signatures;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StaticFieldAccessParam copy$default(StaticFieldAccessParam r100, ArrayList r101, ArrayList r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.params;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.signatures;
    L8:
        ArrayList r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.field;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.fieldSign;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.className;
    L17:
        ArrayList r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final ArrayList<Object> component1() {
        return this.params;
    }

    public final ArrayList<String> component2() {
        return this.signatures;
    }

    public final String component3() {
        return this.field;
    }

    public final String component4() {
        return this.fieldSign;
    }

    public final String component5() {
        return this.className;
    }

    public final StaticFieldAccessParam copy(ArrayList<Object> r100, ArrayList<String> r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "signatures");
        Intrinsics.checkNotNullParameter(r110, "field");
        Intrinsics.checkNotNullParameter(r111, "fieldSign");
        Intrinsics.checkNotNullParameter(r112, PushClientConstants.TAG_CLASS_NAME);
        return new StaticFieldAccessParam(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StaticFieldAccessParam) == true) goto L8;
        return false;
    L8:
        StaticFieldAccessParam r101 = (StaticFieldAccessParam) r100;
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.signatures, r101.signatures) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.field, r101.field) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fieldSign, r101.fieldSign) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.className, r101.className) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.params.hashCode() * 31) + this.signatures.hashCode()) * 31) + this.field.hashCode()) * 31) + this.fieldSign.hashCode()) * 31) + this.className.hashCode();
    }

    public String toString() {
        return "StaticFieldAccessParam(params=" + this.params + ", signatures=" + this.signatures + ", field=" + this.field + ", fieldSign=" + this.fieldSign + ", className=" + this.className + ')';
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getField() {
        return this.field;
    }

    public final String getFieldSign() {
        return this.fieldSign;
    }

    public final ArrayList<Object> getParams() {
        return this.params;
    }

    public final ArrayList<String> getSignatures() {
        return this.signatures;
    }

    public final void setClassName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.className = r100;
    }

    public final void setField(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.field = r100;
    }

    public final void setFieldSign(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldSign = r100;
    }

    public final void setParams(ArrayList<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.params = r100;
    }

    public final void setSignatures(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.signatures = r100;
    }

    public StaticFieldAccessParam(ArrayList<Object> r100, ArrayList<String> r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "signatures");
        Intrinsics.checkNotNullParameter(r102, "field");
        Intrinsics.checkNotNullParameter(r103, "fieldSign");
        Intrinsics.checkNotNullParameter(r104, PushClientConstants.TAG_CLASS_NAME);
        this.params = r100;
        this.signatures = r101;
        this.field = r102;
        this.fieldSign = r103;
        this.className = r104;
    }
}
