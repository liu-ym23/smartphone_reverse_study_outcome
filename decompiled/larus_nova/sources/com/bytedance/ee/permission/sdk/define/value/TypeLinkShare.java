package com.bytedance.ee.permission.sdk.define.value;

import java.io.Serializable;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/permission/sdk/define/value/TypeLinkShare;", "", "", "", "typeValue", "I", "getTypeValue", "()Ljava/lang/Integer;", "INVALID", "LINK_SHARE_CLOSE", "LINK_SHARE_INTERNAL_READ", "LINK_SHARE_INTERNAL_EDIT", "LINK_SHARE_ANYONE_READ", "LINK_SHARE_ANYONE_EDIT", "LINK_SHARE_PARTNER_TENANT_READ", "LINK_SHARE_PARTNER_TENANT_EDIT", "permission-model_release"}, k = 1, mv = {1, 7, 1})
public final enum TypeLinkShare extends Enum<TypeLinkShare> {
    public static final TypeLinkShare INVALID = null;
    public static final TypeLinkShare LINK_SHARE_ANYONE_EDIT = null;
    public static final TypeLinkShare LINK_SHARE_ANYONE_READ = null;
    public static final TypeLinkShare LINK_SHARE_CLOSE = null;
    public static final TypeLinkShare LINK_SHARE_INTERNAL_EDIT = null;
    public static final TypeLinkShare LINK_SHARE_INTERNAL_READ = null;
    public static final TypeLinkShare LINK_SHARE_PARTNER_TENANT_EDIT = null;
    public static final TypeLinkShare LINK_SHARE_PARTNER_TENANT_READ = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeLinkShare[] f243050a = null;
    private final int typeValue;

    public static TypeLinkShare valueOf(String r100) {
        return (TypeLinkShare) a.a(TypeLinkShare.class, r100);
    }

    public static TypeLinkShare[] values() {
        return (TypeLinkShare[]) f243050a.clone();
    }

    static {
        TypeLinkShare r100 = new TypeLinkShare("INVALID", 0, 0);
        INVALID = r100;
        TypeLinkShare r101 = new TypeLinkShare("LINK_SHARE_CLOSE", 1, 1);
        LINK_SHARE_CLOSE = r101;
        TypeLinkShare r102 = new TypeLinkShare("LINK_SHARE_INTERNAL_READ", 2, 2);
        LINK_SHARE_INTERNAL_READ = r102;
        TypeLinkShare r103 = new TypeLinkShare("LINK_SHARE_INTERNAL_EDIT", 3, 3);
        LINK_SHARE_INTERNAL_EDIT = r103;
        TypeLinkShare r104 = new TypeLinkShare("LINK_SHARE_ANYONE_READ", 4, 4);
        LINK_SHARE_ANYONE_READ = r104;
        TypeLinkShare r105 = new TypeLinkShare("LINK_SHARE_ANYONE_EDIT", 5, 5);
        LINK_SHARE_ANYONE_EDIT = r105;
        TypeLinkShare r110 = new TypeLinkShare("LINK_SHARE_PARTNER_TENANT_READ", 6, 6);
        LINK_SHARE_PARTNER_TENANT_READ = r110;
        TypeLinkShare r111 = new TypeLinkShare("LINK_SHARE_PARTNER_TENANT_EDIT", 7, 7);
        LINK_SHARE_PARTNER_TENANT_EDIT = r111;
        f243050a = new TypeLinkShare[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    /* JADX INFO: renamed from: getTypeValue, reason: collision with other method in class */
    public Integer m8357getTypeValue() {
        return Integer.valueOf(this.typeValue);
    }

    public /* bridge */ /* synthetic */ Serializable getTypeValue() {
        return m8357getTypeValue();
    }

    public TypeLinkShare(String r100, int r101, int r102) {
        super(r100, r101);
        this.typeValue = r102;
    }
}
