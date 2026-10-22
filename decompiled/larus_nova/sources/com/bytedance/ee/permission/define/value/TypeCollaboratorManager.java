package com.bytedance.ee.permission.define.value;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/permission/define/value/TypeCollaboratorManager;", "Lcom/bytedance/ee/permission/define/value/IPermissionValue;", "", "", "typeValue", "<init>", "(Ljava/lang/String;II)V", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", "IN_TENANT", "ANYONE", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TypeCollaboratorManager extends Enum<TypeCollaboratorManager> {
    public static final TypeCollaboratorManager ANYONE = null;
    public static final TypeCollaboratorManager INVALID = null;
    public static final TypeCollaboratorManager IN_TENANT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeCollaboratorManager[] f243030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243031b = null;
    private final int typeValue;

    public static EnumEntries<TypeCollaboratorManager> getEntries() {
        return f243031b;
    }

    static {
        TypeCollaboratorManager r100 = new TypeCollaboratorManager("INVALID", 0, 0);
        INVALID = r100;
        TypeCollaboratorManager r101 = new TypeCollaboratorManager("IN_TENANT", 1, 1);
        IN_TENANT = r101;
        TypeCollaboratorManager r102 = new TypeCollaboratorManager("ANYONE", 2, 2);
        ANYONE = r102;
        TypeCollaboratorManager[] r103 = {r100, r101, r102};
        f243030a = r103;
        f243031b = EnumEntriesKt.enumEntries(r103);
    }

    public static TypeCollaboratorManager[] values() {
        return (TypeCollaboratorManager[]) f243030a.clone();
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8348getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8348getTypeValue();
    }

    public static TypeCollaboratorManager valueOf(String r100) {
        return (TypeCollaboratorManager) a.a(TypeCollaboratorManager.class, r100);
    }

    public TypeCollaboratorManager(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
