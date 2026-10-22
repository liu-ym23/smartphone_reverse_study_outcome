package com.bytedance.ee.permission.define.value;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/permission/define/value/TypeCollaboratorPermission;", "Lcom/bytedance/ee/permission/define/value/IPermissionValue;", "", "", "typeValue", "<init>", "(Ljava/lang/String;II)V", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", "READ_PERM", "EDIT_PERM", "FULL_ACCESS_PERM", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TypeCollaboratorPermission extends Enum<TypeCollaboratorPermission> {
    public static final TypeCollaboratorPermission EDIT_PERM = null;
    public static final TypeCollaboratorPermission FULL_ACCESS_PERM = null;
    public static final TypeCollaboratorPermission INVALID = null;
    public static final TypeCollaboratorPermission READ_PERM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeCollaboratorPermission[] f243032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243033b = null;
    private final int typeValue;

    public static EnumEntries<TypeCollaboratorPermission> getEntries() {
        return f243033b;
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
        TypeCollaboratorPermission[] r104 = {r100, r101, r102, r103};
        f243032a = r104;
        f243033b = EnumEntriesKt.enumEntries(r104);
    }

    public static TypeCollaboratorPermission[] values() {
        return (TypeCollaboratorPermission[]) f243032a.clone();
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8349getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8349getTypeValue();
    }

    public static TypeCollaboratorPermission valueOf(String r100) {
        return (TypeCollaboratorPermission) a.a(TypeCollaboratorPermission.class, r100);
    }

    public TypeCollaboratorPermission(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
