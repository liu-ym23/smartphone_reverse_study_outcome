package com.bytedance.ee.permission.define.value;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/permission/define/value/TypeBlockConstraint;", "Lcom/bytedance/ee/permission/define/value/IPermissionValue;", "", "", "typeValue", "<init>", "(Ljava/lang/String;II)V", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", "NO_CONSTRAINTS", "CONSTRAINTS_BY_CONTAINER", "CONSTRAINTS_BY_PARENT", "CONSTRAINTS_BY_SELF", "CONSTRAINTS_BY_TENANT", "CONSTRAINTS_BY_SEC_LEVEL", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TypeBlockConstraint extends Enum<TypeBlockConstraint> {
    public static final TypeBlockConstraint CONSTRAINTS_BY_CONTAINER = null;
    public static final TypeBlockConstraint CONSTRAINTS_BY_PARENT = null;
    public static final TypeBlockConstraint CONSTRAINTS_BY_SEC_LEVEL = null;
    public static final TypeBlockConstraint CONSTRAINTS_BY_SELF = null;
    public static final TypeBlockConstraint CONSTRAINTS_BY_TENANT = null;
    public static final TypeBlockConstraint INVALID = null;
    public static final TypeBlockConstraint NO_CONSTRAINTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeBlockConstraint[] f243028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243029b = null;
    private final int typeValue;

    public static EnumEntries<TypeBlockConstraint> getEntries() {
        return f243029b;
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
        TypeBlockConstraint[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f243028a = r111;
        f243029b = EnumEntriesKt.enumEntries(r111);
    }

    public static TypeBlockConstraint[] values() {
        return (TypeBlockConstraint[]) f243028a.clone();
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8347getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8347getTypeValue();
    }

    public static TypeBlockConstraint valueOf(String r100) {
        return (TypeBlockConstraint) a.a(TypeBlockConstraint.class, r100);
    }

    public TypeBlockConstraint(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
