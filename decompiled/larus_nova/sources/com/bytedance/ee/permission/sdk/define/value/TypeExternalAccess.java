package com.bytedance.ee.permission.sdk.define.value;

import java.io.Serializable;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/permission/sdk/define/value/TypeExternalAccess;", "", "", "", "typeValue", "I", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", "EXTERNAL_ACCESS_OPEN", "EXTERNAL_ACCESS_CLOSE", "EXTERNAL_ACCESS_PARTNER_TENANT", "permission-model_release"}, k = 1, mv = {1, 7, 1})
public final enum TypeExternalAccess extends Enum<TypeExternalAccess> {
    public static final TypeExternalAccess EXTERNAL_ACCESS_CLOSE = null;
    public static final TypeExternalAccess EXTERNAL_ACCESS_OPEN = null;
    public static final TypeExternalAccess EXTERNAL_ACCESS_PARTNER_TENANT = null;
    public static final TypeExternalAccess INVALID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeExternalAccess[] f243049a = null;
    private final int typeValue;

    public static TypeExternalAccess valueOf(String r100) {
        return (TypeExternalAccess) a.a(TypeExternalAccess.class, r100);
    }

    public static TypeExternalAccess[] values() {
        return (TypeExternalAccess[]) f243049a.clone();
    }

    static {
        TypeExternalAccess r100 = new TypeExternalAccess("INVALID", 0, 0);
        INVALID = r100;
        TypeExternalAccess r101 = new TypeExternalAccess("EXTERNAL_ACCESS_OPEN", 1, 1);
        EXTERNAL_ACCESS_OPEN = r101;
        TypeExternalAccess r102 = new TypeExternalAccess("EXTERNAL_ACCESS_CLOSE", 2, 2);
        EXTERNAL_ACCESS_CLOSE = r102;
        TypeExternalAccess r103 = new TypeExternalAccess("EXTERNAL_ACCESS_PARTNER_TENANT", 3, 3);
        EXTERNAL_ACCESS_PARTNER_TENANT = r103;
        f243049a = new TypeExternalAccess[]{r100, r101, r102, r103};
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8356getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8356getTypeValue();
    }

    public TypeExternalAccess(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
