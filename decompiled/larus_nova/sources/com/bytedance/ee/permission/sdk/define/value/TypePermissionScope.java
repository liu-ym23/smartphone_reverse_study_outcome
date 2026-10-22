package com.bytedance.ee.permission.sdk.define.value;

import com.obric.miniapp.alarm.AccountType;
import java.io.Serializable;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/permission/sdk/define/value/TypePermissionScope;", "", "", "", "typeValue", "I", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", AccountType.ALL, "CONTAINER", "SINGLE_PAGE", "permission-model_release"}, k = 1, mv = {1, 7, 1})
public final enum TypePermissionScope extends Enum<TypePermissionScope> {
    public static final TypePermissionScope ALL = null;
    public static final TypePermissionScope CONTAINER = null;
    public static final TypePermissionScope INVALID = null;
    public static final TypePermissionScope SINGLE_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypePermissionScope[] f243051a = null;
    private final int typeValue;

    public static TypePermissionScope valueOf(String r100) {
        return (TypePermissionScope) a.a(TypePermissionScope.class, r100);
    }

    public static TypePermissionScope[] values() {
        return (TypePermissionScope[]) f243051a.clone();
    }

    static {
        TypePermissionScope r100 = new TypePermissionScope("INVALID", 0, -99);
        INVALID = r100;
        TypePermissionScope r101 = new TypePermissionScope(AccountType.ALL, 1, 0);
        ALL = r101;
        TypePermissionScope r102 = new TypePermissionScope("CONTAINER", 2, 1);
        CONTAINER = r102;
        TypePermissionScope r103 = new TypePermissionScope("SINGLE_PAGE", 3, 2);
        SINGLE_PAGE = r103;
        f243051a = new TypePermissionScope[]{r100, r101, r102, r103};
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8358getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8358getTypeValue();
    }

    public TypePermissionScope(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
