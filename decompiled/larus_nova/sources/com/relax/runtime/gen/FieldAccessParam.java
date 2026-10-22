package com.relax.runtime.gen;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0005j\b\u0012\u0004\u0012\u00020\b`\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u0006HÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0005j\b\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0005j\b\u0012\u0004\u0012\u00020\b`\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0005j\b\u0012\u0004\u0012\u00020\b`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lcom/relax/runtime/gen/FieldAccessParam;", "", PickerReporterConstants.KEY.TARGET, "", "params", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "signatures", "", "field", "fieldSign", PushClientConstants.TAG_CLASS_NAME, "(JLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "getField", "setField", "getFieldSign", "setFieldSign", "getParams", "()Ljava/util/ArrayList;", "setParams", "(Ljava/util/ArrayList;)V", "getSignatures", "setSignatures", "getTarget", "()J", "setTarget", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FieldAccessParam {
    private String className;
    private String field;
    private String fieldSign;
    private ArrayList<Object> params;
    private ArrayList<String> signatures;
    private long target;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FieldAccessParam copy$default(FieldAccessParam r100, long r101, ArrayList r110, ArrayList r111, String r112, String r113, String r114, int r115, Object r116) {
        if ((r115 & 1) == 0) goto L5;
        long r102 = r100.target;
    L7:
        if ((r115 & 2) == 0) goto L9;
        ArrayList r103 = r100.params;
    L11:
        if ((r115 & 4) == 0) goto L13;
        ArrayList r104 = r100.signatures;
    L15:
        if ((r115 & 8) == 0) goto L17;
        String r105 = r100.field;
    L19:
        if ((r115 & 16) == 0) goto L21;
        String r106 = r100.fieldSign;
    L23:
        if ((r115 & 32) == 0) goto L25;
        String r107 = r100.className;
    L27:
        return r100.copy(r102, r103, r104, r105, r106, r107);
    L25:
        r107 = r114;
        goto L27
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.target;
    }

    public final ArrayList<Object> component2() {
        return this.params;
    }

    public final ArrayList<String> component3() {
        return this.signatures;
    }

    public final String component4() {
        return this.field;
    }

    public final String component5() {
        return this.fieldSign;
    }

    public final String component6() {
        return this.className;
    }

    public final FieldAccessParam copy(long r110, ArrayList<Object> r111, ArrayList<String> r112, String r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "signatures");
        Intrinsics.checkNotNullParameter(r113, "field");
        Intrinsics.checkNotNullParameter(r114, "fieldSign");
        Intrinsics.checkNotNullParameter(r115, PushClientConstants.TAG_CLASS_NAME);
        return new FieldAccessParam(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FieldAccessParam) == true) goto L8;
        return false;
    L8:
        FieldAccessParam r101 = (FieldAccessParam) r100;
        if (this.target == r101.target) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.signatures, r101.signatures) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.field, r101.field) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fieldSign, r101.fieldSign) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.className, r101.className) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        long r100 = this.target;
        return (((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.params.hashCode()) * 31) + this.signatures.hashCode()) * 31) + this.field.hashCode()) * 31) + this.fieldSign.hashCode()) * 31) + this.className.hashCode();
    }

    public String toString() {
        return "FieldAccessParam(target=" + this.target + ", params=" + this.params + ", signatures=" + this.signatures + ", field=" + this.field + ", fieldSign=" + this.fieldSign + ", className=" + this.className + ')';
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

    public final long getTarget() {
        return this.target;
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

    public final void setTarget(long r100) {
        this.target = r100;
    }

    public FieldAccessParam(long r100, ArrayList<Object> r101, ArrayList<String> r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "signatures");
        Intrinsics.checkNotNullParameter(r103, "field");
        Intrinsics.checkNotNullParameter(r104, "fieldSign");
        Intrinsics.checkNotNullParameter(r105, PushClientConstants.TAG_CLASS_NAME);
        this.target = r100;
        this.params = r101;
        this.signatures = r102;
        this.field = r103;
        this.fieldSign = r104;
        this.className = r105;
    }
}
