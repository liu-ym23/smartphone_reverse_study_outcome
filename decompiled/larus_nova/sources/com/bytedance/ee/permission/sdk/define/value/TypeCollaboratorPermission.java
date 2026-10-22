package com.bytedance.ee.permission.sdk.define.value;

import java.io.Serializable;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/permission/sdk/define/value/TypeCollaboratorPermission;", "", "", "", "typeValue", "I", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", "READ_PERM", "EDIT_PERM", "FULL_ACCESS_PERM", "permission-model_release"}, k = 1, mv = {1, 7, 1})
public final enum TypeCollaboratorPermission extends Enum<TypeCollaboratorPermission> {
    public static final TypeCollaboratorPermission EDIT_PERM = null;
    public static final TypeCollaboratorPermission FULL_ACCESS_PERM = null;
    public static final TypeCollaboratorPermission INVALID = null;
    public static final TypeCollaboratorPermission READ_PERM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeCollaboratorPermission[] f243048a = null;
    private final int typeValue;

    public static TypeCollaboratorPermission valueOf(String r100) {
        return (TypeCollaboratorPermission) a.a(TypeCollaboratorPermission.class, r100);
    }

    public static TypeCollaboratorPermission[] values() {
        return (TypeCollaboratorPermission[]) f243048a.clone();
    }

    static {
        TypeCollaboratorPermission r100 = new TypeCollaboratorPermission("INVALID", 0, 0);
        INVALID = r100;
        TypeCollaboratorPermission r101 = new TypeCollaboratorPermission("READ_PERM", 1, 1);
        READ_PERM = r101;
        TypeCollaboratorPermission r102 = new TypeCollaboratorPermission("EDIT_PERM", 2, 2);
        EDIT_PERM = r102;
        TypeCollaboratorPermission r103 = new TypeCollaboratorPermission("FULL_ACCESS_PERM", 3, 3);
        FULL_ACCESS_PERM = r103;
        f243048a = new TypeCollaboratorPermission[]{r100, r101, r102, r103};
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8355getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8355getTypeValue();
    }

    public TypeCollaboratorPermission(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
