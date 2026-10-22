package com.bytedance.ee.permission.define.value;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/permission/define/value/TypeExternalAccess;", "Lcom/bytedance/ee/permission/define/value/IPermissionValue;", "", "", "typeValue", "<init>", "(Ljava/lang/String;II)V", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", "EXTERNAL_ACCESS_OPEN", "EXTERNAL_ACCESS_CLOSE", "EXTERNAL_ACCESS_PARTNER_TENANT", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TypeExternalAccess extends Enum<TypeExternalAccess> {
    public static final TypeExternalAccess EXTERNAL_ACCESS_CLOSE = null;
    public static final TypeExternalAccess EXTERNAL_ACCESS_OPEN = null;
    public static final TypeExternalAccess EXTERNAL_ACCESS_PARTNER_TENANT = null;
    public static final TypeExternalAccess INVALID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeExternalAccess[] f243034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243035b = null;
    private final int typeValue;

    public static EnumEntries<TypeExternalAccess> getEntries() {
        return f243035b;
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
        TypeExternalAccess[] r104 = {r100, r101, r102, r103};
        f243034a = r104;
        f243035b = EnumEntriesKt.enumEntries(r104);
    }

    public static TypeExternalAccess[] values() {
        return (TypeExternalAccess[]) f243034a.clone();
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8350getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8350getTypeValue();
    }

    public static TypeExternalAccess valueOf(String r100) {
        return (TypeExternalAccess) a.a(TypeExternalAccess.class, r100);
    }

    public TypeExternalAccess(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
