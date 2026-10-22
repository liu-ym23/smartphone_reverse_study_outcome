package com.bytedance.ee.permission.sdk.define.value;

import java.io.Serializable;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/permission/sdk/define/value/TypeCollaboratorManager;", "", "", "", "typeValue", "I", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", "IN_TENANT", "ANYONE", "permission-model_release"}, k = 1, mv = {1, 7, 1})
public final enum TypeCollaboratorManager extends Enum<TypeCollaboratorManager> {
    public static final TypeCollaboratorManager ANYONE = null;
    public static final TypeCollaboratorManager INVALID = null;
    public static final TypeCollaboratorManager IN_TENANT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeCollaboratorManager[] f243047a = null;
    private final int typeValue;

    public static TypeCollaboratorManager valueOf(String r100) {
        return (TypeCollaboratorManager) a.a(TypeCollaboratorManager.class, r100);
    }

    public static TypeCollaboratorManager[] values() {
        return (TypeCollaboratorManager[]) f243047a.clone();
    }

    static {
        TypeCollaboratorManager r100 = new TypeCollaboratorManager("INVALID", 0, 0);
        INVALID = r100;
        TypeCollaboratorManager r101 = new TypeCollaboratorManager("IN_TENANT", 1, 1);
        IN_TENANT = r101;
        TypeCollaboratorManager r102 = new TypeCollaboratorManager("ANYONE", 2, 2);
        ANYONE = r102;
        f243047a = new TypeCollaboratorManager[]{r100, r101, r102};
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8354getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8354getTypeValue();
    }

    public TypeCollaboratorManager(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
