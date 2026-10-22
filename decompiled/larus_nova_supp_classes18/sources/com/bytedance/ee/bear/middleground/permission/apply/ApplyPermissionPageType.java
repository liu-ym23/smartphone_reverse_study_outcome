package com.bytedance.ee.bear.middleground.permission.apply;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "BITABLE_PRO", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ApplyPermissionPageType extends Enum<ApplyPermissionPageType> {
    public static final ApplyPermissionPageType BITABLE_PRO = null;
    public static final ApplyPermissionPageType NORMAL = null;
    public static final /* synthetic */ ApplyPermissionPageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ApplyPermissionPageType> getEntries() {
        return b;
    }

    static {
        ApplyPermissionPageType r0 = new ApplyPermissionPageType("NORMAL", 0);
        NORMAL = r0;
        ApplyPermissionPageType r1 = new ApplyPermissionPageType("BITABLE_PRO", 1);
        BITABLE_PRO = r1;
        ApplyPermissionPageType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ApplyPermissionPageType[] values() {
        return (ApplyPermissionPageType[]) a.clone();
    }

    public static ApplyPermissionPageType valueOf(String r1) {
        return (ApplyPermissionPageType) r27.a.a(ApplyPermissionPageType.class, r1);
    }

    public ApplyPermissionPageType(String r1, int r2) {
        super(r1, r2);
    }
}
