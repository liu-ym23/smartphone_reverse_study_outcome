package com.relax.runtime.gen;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0001HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/relax/runtime/gen/RTSClosureParam;", "", "rtsObject", "signatures", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "getRtsObject", "()Ljava/lang/Object;", "setRtsObject", "(Ljava/lang/Object;)V", "getSignatures", "()Ljava/util/ArrayList;", "setSignatures", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RTSClosureParam {
    private Object rtsObject;
    private ArrayList<String> signatures;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RTSClosureParam copy$default(RTSClosureParam r100, Object r101, ArrayList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.rtsObject;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.signatures;
    L9:
        return r100.copy(r101, r102);
    }

    public final Object component1() {
        return this.rtsObject;
    }

    public final ArrayList<String> component2() {
        return this.signatures;
    }

    public final RTSClosureParam copy(Object r100, ArrayList<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "rtsObject");
        Intrinsics.checkNotNullParameter(r101, "signatures");
        return new RTSClosureParam(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RTSClosureParam) == true) goto L8;
        return false;
    L8:
        RTSClosureParam r101 = (RTSClosureParam) r100;
        if (Intrinsics.areEqual(this.rtsObject, r101.rtsObject) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.signatures, r101.signatures) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.rtsObject.hashCode() * 31) + this.signatures.hashCode();
    }

    public String toString() {
        return "RTSClosureParam(rtsObject=" + this.rtsObject + ", signatures=" + this.signatures + ')';
    }

    public final Object getRtsObject() {
        return this.rtsObject;
    }

    public final ArrayList<String> getSignatures() {
        return this.signatures;
    }

    public final void setRtsObject(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rtsObject = r100;
    }

    public final void setSignatures(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.signatures = r100;
    }

    public RTSClosureParam(Object r100, ArrayList<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "rtsObject");
        Intrinsics.checkNotNullParameter(r101, "signatures");
        this.rtsObject = r100;
        this.signatures = r101;
    }
}
