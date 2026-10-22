package com.bytedance.ee.permission.sdk.define.value;

import java.io.Serializable;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/permission/sdk/define/value/TypeBlockConstraint;", "", "", "", "typeValue", "I", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", "NO_CONSTRAINTS", "CONSTRAINTS_BY_CONTAINER", "CONSTRAINTS_BY_PARENT", "CONSTRAINTS_BY_SELF", "CONSTRAINTS_BY_TENANT", "CONSTRAINTS_BY_SEC_LEVEL", "permission-model_release"}, k = 1, mv = {1, 7, 1})
public final enum TypeBlockConstraint extends Enum<TypeBlockConstraint> {
    public static final TypeBlockConstraint CONSTRAINTS_BY_CONTAINER = null;
    public static final TypeBlockConstraint CONSTRAINTS_BY_PARENT = null;
    public static final TypeBlockConstraint CONSTRAINTS_BY_SEC_LEVEL = null;
    public static final TypeBlockConstraint CONSTRAINTS_BY_SELF = null;
    public static final TypeBlockConstraint CONSTRAINTS_BY_TENANT = null;
    public static final TypeBlockConstraint INVALID = null;
    public static final TypeBlockConstraint NO_CONSTRAINTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeBlockConstraint[] f243046a = null;
    private final int typeValue;

    public static TypeBlockConstraint valueOf(String r100) {
        return (TypeBlockConstraint) a.a(TypeBlockConstraint.class, r100);
    }

    public static TypeBlockConstraint[] values() {
        return (TypeBlockConstraint[]) f243046a.clone();
    }

    static {
        TypeBlockConstraint r100 = new TypeBlockConstraint("INVALID", 0, -1);
        INVALID = r100;
        TypeBlockConstraint r101 = new TypeBlockConstraint("NO_CONSTRAINTS", 1, 0);
        NO_CONSTRAINTS = r101;
        TypeBlockConstraint r102 = new TypeBlockConstraint("CONSTRAINTS_BY_CONTAINER", 2, 1);
        CONSTRAINTS_BY_CONTAINER = r102;
        TypeBlockConstraint r103 = new TypeBlockConstraint("CONSTRAINTS_BY_PARENT", 3, 2);
        CONSTRAINTS_BY_PARENT = r103;
        TypeBlockConstraint r104 = new TypeBlockConstraint("CONSTRAINTS_BY_SELF", 4, 3);
        CONSTRAINTS_BY_SELF = r104;
        TypeBlockConstraint r105 = new TypeBlockConstraint("CONSTRAINTS_BY_TENANT", 5, 4);
        CONSTRAINTS_BY_TENANT = r105;
        TypeBlockConstraint r110 = new TypeBlockConstraint("CONSTRAINTS_BY_SEC_LEVEL", 6, 5);
        CONSTRAINTS_BY_SEC_LEVEL = r110;
        f243046a = new TypeBlockConstraint[]{r100, r101, r102, r103, r104, r105, r110};
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8353getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8353getTypeValue();
    }

    public TypeBlockConstraint(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
