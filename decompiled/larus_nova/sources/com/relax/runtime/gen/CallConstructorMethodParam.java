package com.relax.runtime.gen;

import com.alipay.sdk.m.p.e;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00020\u0006`\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004HÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00020\u0006`\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0001HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003Je\u0010&\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u00042\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00020\u0006`\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00020\u0006`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006,"}, d2 = {"Lcom/relax/runtime/gen/CallConstructorMethodParam;", "", "params", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "signatures", "", "rtsObject", PushClientConstants.TAG_CLASS_NAME, "isInterface", "", e.f25671s, "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Object;Ljava/lang/String;ZLjava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "()Z", "setInterface", "(Z)V", "getMethod", "setMethod", "getParams", "()Ljava/util/ArrayList;", "setParams", "(Ljava/util/ArrayList;)V", "getRtsObject", "()Ljava/lang/Object;", "setRtsObject", "(Ljava/lang/Object;)V", "getSignatures", "setSignatures", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallConstructorMethodParam {
    private String className;
    private boolean isInterface;
    private String method;
    private ArrayList<Object> params;
    private Object rtsObject;
    private ArrayList<String> signatures;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallConstructorMethodParam copy$default(CallConstructorMethodParam r100, ArrayList r101, ArrayList r102, Object r103, String r104, boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.params;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.signatures;
    L8:
        ArrayList r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.rtsObject;
    L11:
        Object r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.className;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.isInterface;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.method;
    L20:
        ArrayList r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final ArrayList<Object> component1() {
        return this.params;
    }

    public final ArrayList<String> component2() {
        return this.signatures;
    }

    public final Object component3() {
        return this.rtsObject;
    }

    public final String component4() {
        return this.className;
    }

    public final boolean component5() {
        return this.isInterface;
    }

    public final String component6() {
        return this.method;
    }

    public final CallConstructorMethodParam copy(ArrayList<Object> r100, ArrayList<String> r110, Object r111, String r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "signatures");
        Intrinsics.checkNotNullParameter(r111, "rtsObject");
        Intrinsics.checkNotNullParameter(r112, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r114, e.f25671s);
        return new CallConstructorMethodParam(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CallConstructorMethodParam) == true) goto L8;
        return false;
    L8:
        CallConstructorMethodParam r101 = (CallConstructorMethodParam) r100;
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.signatures, r101.signatures) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rtsObject, r101.rtsObject) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.className, r101.className) == true) goto L21;
        return false;
    L21:
        if (this.isInterface == r101.isInterface) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.method, r101.method) == true) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public int hashCode() {
        int r100 = ((((((this.params.hashCode() * 31) + this.signatures.hashCode()) * 31) + this.rtsObject.hashCode()) * 31) + this.className.hashCode()) * 31;
        boolean r101 = this.isInterface;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return ((r100 + r102) * 31) + this.method.hashCode();
    }

    public String toString() {
        return "CallConstructorMethodParam(params=" + this.params + ", signatures=" + this.signatures + ", rtsObject=" + this.rtsObject + ", className=" + this.className + ", isInterface=" + this.isInterface + ", method=" + this.method + ')';
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getMethod() {
        return this.method;
    }

    public final ArrayList<Object> getParams() {
        return this.params;
    }

    public final Object getRtsObject() {
        return this.rtsObject;
    }

    public final ArrayList<String> getSignatures() {
        return this.signatures;
    }

    public final boolean isInterface() {
        return this.isInterface;
    }

    public final void setClassName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.className = r100;
    }

    public final void setInterface(boolean r100) {
        this.isInterface = r100;
    }

    public final void setMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.method = r100;
    }

    public final void setParams(ArrayList<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.params = r100;
    }

    public final void setRtsObject(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rtsObject = r100;
    }

    public final void setSignatures(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.signatures = r100;
    }

    public CallConstructorMethodParam(ArrayList<Object> r100, ArrayList<String> r101, Object r102, String r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "signatures");
        Intrinsics.checkNotNullParameter(r102, "rtsObject");
        Intrinsics.checkNotNullParameter(r103, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r105, e.f25671s);
        this.params = r100;
        this.signatures = r101;
        this.rtsObject = r102;
        this.className = r103;
        this.isInterface = r104;
        this.method = r105;
    }
}
