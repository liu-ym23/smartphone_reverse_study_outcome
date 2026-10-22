package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes6.dex */
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public KDeclarationContainer getOwner() {
        Class r100 = this.owner;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.isTopLevel == false) goto L9;
        return Reflection.getOrCreateKotlinPackage(r100);
    L9:
        return Reflection.getOrCreateKotlinClass(r100);
    }

    public int hashCode() {
        Object r100 = this.receiver;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Class r104 = this.owner;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (((((r103 + r101) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31;
        if (this.isTopLevel == false) goto L12;
        int r106 = 1231;
    L14:
        return ((((r105 + r106) * 31) + this.arity) * 31) + this.flags;
    L12:
        r106 = 1237;
        goto L14
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return Reflection.renderLambdaToString(this);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AdaptedFunctionReference) == true) goto L8;
        return false;
    L8:
        AdaptedFunctionReference r101 = (AdaptedFunctionReference) r100;
        if (this.isTopLevel == r101.isTopLevel) goto L11;
    L23:
        return false;
    L11:
        if (this.arity != r101.arity) goto L23;
        if (this.flags != r101.flags) goto L23;
        if (Intrinsics.areEqual(this.receiver, r101.receiver) == false) goto L23;
        if (Intrinsics.areEqual(this.owner, r101.owner) == false) goto L23;
        if (this.name.equals(r101.name) == false) goto L23;
        if (this.signature.equals(r101.signature) == false) goto L23;
        return true;
    }

    public AdaptedFunctionReference(int r100, Class r101, String r110, String r111, int r112) {
        this(r100, CallableReference.NO_RECEIVER, r101, r110, r111, r112);
    }

    public AdaptedFunctionReference(int r100, Object r101, Class r102, String r103, String r104, int r105) {
        this.receiver = r101;
        this.owner = r102;
        this.name = r103;
        this.signature = r104;
        if ((r105 & 1) != 1) goto L5;
        boolean r106 = true;
    L6:
        this.isTopLevel = r106;
        this.arity = r100;
        this.flags = r105 >> 1;
        return;
    L5:
        r106 = false;
        goto L6
    }
}
