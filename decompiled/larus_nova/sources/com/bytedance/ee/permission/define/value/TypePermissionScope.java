package com.bytedance.ee.permission.define.value;

import com.obric.miniapp.alarm.AccountType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/permission/define/value/TypePermissionScope;", "Lcom/bytedance/ee/permission/define/value/IPermissionValue;", "", "", "typeValue", "<init>", "(Ljava/lang/String;II)V", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", AccountType.ALL, "CONTAINER", "SINGLE_PAGE", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TypePermissionScope extends Enum<TypePermissionScope> {
    public static final TypePermissionScope ALL = null;
    public static final TypePermissionScope CONTAINER = null;
    public static final TypePermissionScope INVALID = null;
    public static final TypePermissionScope SINGLE_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypePermissionScope[] f243038a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243039b = null;
    private final int typeValue;

    public static EnumEntries<TypePermissionScope> getEntries() {
        return f243039b;
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
        TypePermissionScope[] r104 = {r100, r101, r102, r103};
        f243038a = r104;
        f243039b = EnumEntriesKt.enumEntries(r104);
    }

    public static TypePermissionScope[] values() {
        return (TypePermissionScope[]) f243038a.clone();
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8352getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8352getTypeValue();
    }

    public static TypePermissionScope valueOf(String r100) {
        return (TypePermissionScope) a.a(TypePermissionScope.class, r100);
    }

    public TypePermissionScope(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
