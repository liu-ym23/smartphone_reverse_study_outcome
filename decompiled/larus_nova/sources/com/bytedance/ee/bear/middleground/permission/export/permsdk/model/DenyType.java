package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DenyType[] f233871a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233872b = null;

    public static EnumEntries<DenyType> getEntries() {
        return f233872b;
    }

    static {
        DenyType r100 = new DenyType("DLP_DETECTING", 0);
        DLP_DETECTING = r100;
        DenyType r101 = new DenyType("DLP_SENSATIVE", 1);
        DLP_SENSATIVE = r101;
        DenyType r102 = new DenyType("ADMIN", 2);
        ADMIN = r102;
        DenyType r103 = new DenyType("FILE_STRATEGY", 3);
        FILE_STRATEGY = r103;
        DenyType r104 = new DenyType("USER_PERMISSION", 4);
        USER_PERMISSION = r104;
        DenyType r105 = new DenyType("DEFAULT_NONE", 5);
        DEFAULT_NONE = r105;
        DenyType r110 = new DenyType("TT_BLOCK", 6);
        TT_BLOCK = r110;
        DenyType r111 = new DenyType("AUDIT_CONTROL", 7);
        AUDIT_CONTROL = r111;
        DenyType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f233871a = r112;
        f233872b = EnumEntriesKt.enumEntries(r112);
    }

    public static DenyType[] values() {
        return (DenyType[]) f233871a.clone();
    }

    public static DenyType valueOf(String r100) {
        return (DenyType) a.a(DenyType.class, r100);
    }

    public DenyType(String r100, int r101) {
        super(r100, r101);
    }
}
