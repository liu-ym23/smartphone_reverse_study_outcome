package com.bytedance.ee.bear.middleground.permission.apply;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyPermissionPageMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "AUDIT_CONTROL", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ApplyPermissionPageMode extends Enum<ApplyPermissionPageMode> {
    public static final ApplyPermissionPageMode AUDIT_CONTROL = null;
    public static final ApplyPermissionPageMode NORMAL = null;
    public static final /* synthetic */ ApplyPermissionPageMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ApplyPermissionPageMode> getEntries() {
        return b;
    }

    static {
        ApplyPermissionPageMode r0 = new ApplyPermissionPageMode("NORMAL", 0);
        NORMAL = r0;
        ApplyPermissionPageMode r1 = new ApplyPermissionPageMode("AUDIT_CONTROL", 1);
        AUDIT_CONTROL = r1;
        ApplyPermissionPageMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ApplyPermissionPageMode[] values() {
        return (ApplyPermissionPageMode[]) a.clone();
    }

    public static ApplyPermissionPageMode valueOf(String r1) {
        return (ApplyPermissionPageMode) r27.a.a(ApplyPermissionPageMode.class, r1);
    }

    public ApplyPermissionPageMode(String r1, int r2) {
        super(r1, r2);
    }
}
