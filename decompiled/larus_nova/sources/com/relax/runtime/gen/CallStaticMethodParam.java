package com.relax.runtime.gen;

import com.alipay.sdk.m.p.e;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u0006HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JQ\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Lcom/relax/runtime/gen/CallStaticMethodParam;", "", e.f25671s, "", "params", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "signatures", PushClientConstants.TAG_CLASS_NAME, "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "getMethod", "setMethod", "getParams", "()Ljava/util/ArrayList;", "setParams", "(Ljava/util/ArrayList;)V", "getSignatures", "setSignatures", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallStaticMethodParam {
    private String className;
    private String method;
    private ArrayList<Object> params;
    private ArrayList<String> signatures;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallStaticMethodParam copy$default(CallStaticMethodParam r100, String r101, ArrayList r102, ArrayList r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.method;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.params;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.signatures;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.className;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.method;
    }

    public final ArrayList<Object> component2() {
        return this.params;
    }

    public final ArrayList<String> component3() {
        return this.signatures;
    }

    public final String component4() {
        return this.className;
    }

    public final CallStaticMethodParam copy(String r100, ArrayList<Object> r101, ArrayList<String> r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "signatures");
        Intrinsics.checkNotNullParameter(r103, PushClientConstants.TAG_CLASS_NAME);
        return new CallStaticMethodParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CallStaticMethodParam) == true) goto L8;
        return false;
    L8:
        CallStaticMethodParam r101 = (CallStaticMethodParam) r100;
        if (Intrinsics.areEqual(this.method, r101.method) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.signatures, r101.signatures) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.className, r101.className) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.method.hashCode() * 31) + this.params.hashCode()) * 31) + this.signatures.hashCode()) * 31) + this.className.hashCode();
    }

    public String toString() {
        return "CallStaticMethodParam(method=" + this.method + ", params=" + this.params + ", signatures=" + this.signatures + ", className=" + this.className + ')';
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

    public final ArrayList<String> getSignatures() {
        return this.signatures;
    }

    public final void setClassName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.className = r100;
    }

    public final void setMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.method = r100;
    }

    public final void setParams(ArrayList<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.params = r100;
    }

    public final void setSignatures(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.signatures = r100;
    }

    public CallStaticMethodParam(String r100, ArrayList<Object> r101, ArrayList<String> r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "signatures");
        Intrinsics.checkNotNullParameter(r103, PushClientConstants.TAG_CLASS_NAME);
        this.method = r100;
        this.params = r101;
        this.signatures = r102;
        this.className = r103;
    }
}
