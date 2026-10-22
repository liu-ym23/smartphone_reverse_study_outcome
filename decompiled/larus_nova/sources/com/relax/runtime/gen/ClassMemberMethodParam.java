package com.relax.runtime.gen;

import com.alipay.sdk.m.p.e;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\bHÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b2\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/relax/runtime/gen/ClassMemberMethodParam;", "", PickerReporterConstants.KEY.TARGET, "", e.f25671s, "", "params", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "signatures", PushClientConstants.TAG_CLASS_NAME, "(JLjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "getMethod", "setMethod", "getParams", "()Ljava/util/ArrayList;", "setParams", "(Ljava/util/ArrayList;)V", "getSignatures", "setSignatures", "getTarget", "()J", "setTarget", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClassMemberMethodParam {
    private String className;
    private String method;
    private ArrayList<Object> params;
    private ArrayList<String> signatures;
    private long target;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClassMemberMethodParam copy$default(ClassMemberMethodParam r100, long r101, String r110, ArrayList r111, ArrayList r112, String r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.target;
    L5:
        long r102 = r101;
        if ((r114 & 2) == 0) goto L8;
        r110 = r100.method;
    L8:
        String r103 = r110;
        if ((r114 & 4) == 0) goto L11;
        r111 = r100.params;
    L11:
        ArrayList r104 = r111;
        if ((r114 & 8) == 0) goto L14;
        r112 = r100.signatures;
    L14:
        ArrayList r105 = r112;
        if ((r114 & 16) == 0) goto L18;
        r113 = r100.className;
    L18:
        return r100.copy(r102, r103, r104, r105, r113);
    }

    public final long component1() {
        return this.target;
    }

    public final String component2() {
        return this.method;
    }

    public final ArrayList<Object> component3() {
        return this.params;
    }

    public final ArrayList<String> component4() {
        return this.signatures;
    }

    public final String component5() {
        return this.className;
    }

    public final ClassMemberMethodParam copy(long r100, String r110, ArrayList<Object> r111, ArrayList<String> r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, e.f25671s);
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "signatures");
        Intrinsics.checkNotNullParameter(r113, PushClientConstants.TAG_CLASS_NAME);
        return new ClassMemberMethodParam(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClassMemberMethodParam) == true) goto L8;
        return false;
    L8:
        ClassMemberMethodParam r101 = (ClassMemberMethodParam) r100;
        if (this.target == r101.target) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.method, r101.method) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.signatures, r101.signatures) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.className, r101.className) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        long r100 = this.target;
        return (((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.method.hashCode()) * 31) + this.params.hashCode()) * 31) + this.signatures.hashCode()) * 31) + this.className.hashCode();
    }

    public String toString() {
        return "ClassMemberMethodParam(target=" + this.target + ", method=" + this.method + ", params=" + this.params + ", signatures=" + this.signatures + ", className=" + this.className + ')';
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

    public final long getTarget() {
        return this.target;
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

    public final void setTarget(long r100) {
        this.target = r100;
    }

    public ClassMemberMethodParam(long r100, String r101, ArrayList<Object> r102, ArrayList<String> r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "signatures");
        Intrinsics.checkNotNullParameter(r104, PushClientConstants.TAG_CLASS_NAME);
        this.target = r100;
        this.method = r101;
        this.params = r102;
        this.signatures = r103;
        this.className = r104;
    }
}
