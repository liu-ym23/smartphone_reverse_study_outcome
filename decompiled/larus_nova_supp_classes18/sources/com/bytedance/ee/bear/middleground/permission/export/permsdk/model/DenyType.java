package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenyType;", "", "<init>", "(Ljava/lang/String;I)V", "DLP_DETECTING", "DLP_SENSATIVE", "ADMIN", "FILE_STRATEGY", "USER_PERMISSION", "DEFAULT_NONE", "TT_BLOCK", "AUDIT_CONTROL", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DenyType extends Enum<DenyType> {
    public static final DenyType ADMIN = null;
    public static final DenyType AUDIT_CONTROL = null;
    public static final DenyType DEFAULT_NONE = null;
    public static final DenyType DLP_DETECTING = null;
    public static final DenyType DLP_SENSATIVE = null;
    public static final DenyType FILE_STRATEGY = null;
    public static final DenyType TT_BLOCK = null;
    public static final DenyType USER_PERMISSION = null;
    public static final /* synthetic */ DenyType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DenyType> getEntries() {
        return b;
    }

    static {
        DenyType r0 = new DenyType("DLP_DETECTING", 0);
        DLP_DETECTING = r0;
        DenyType r1 = new DenyType("DLP_SENSATIVE", 1);
        DLP_SENSATIVE = r1;
        DenyType r3 = new DenyType("ADMIN", 2);
        ADMIN = r3;
        DenyType r5 = new DenyType("FILE_STRATEGY", 3);
        FILE_STRATEGY = r5;
        DenyType r7 = new DenyType("USER_PERMISSION", 4);
        USER_PERMISSION = r7;
        DenyType r9 = new DenyType("DEFAULT_NONE", 5);
        DEFAULT_NONE = r9;
        DenyType r11 = new DenyType("TT_BLOCK", 6);
        TT_BLOCK = r11;
        DenyType r13 = new DenyType("AUDIT_CONTROL", 7);
        AUDIT_CONTROL = r13;
        DenyType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static DenyType[] values() {
        return (DenyType[]) a.clone();
    }

    public static DenyType valueOf(String r1) {
        return (DenyType) a.a(DenyType.class, r1);
    }

    public DenyType(String r1, int r2) {
        super(r1, r2);
    }
}
