package com.bytedance.ee.bear.bitable.card.model.enums;

import com.obric.miniapp.alarm.AccountType;
import cu5.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum EFieldUneditableReason extends Enum<EFieldUneditableReason> {
    public static final EFieldUneditableReason ATTACHMENT_FORBIDDEN_IN_PRO = null;
    public static final EFieldUneditableReason BITABLE_IS_NOT_READY = null;
    public static final EFieldUneditableReason DRILL_DOWN_NOT_SUPPORT_EDIT = null;
    public static final EFieldUneditableReason EDIT_AFTER_SUBMIT = null;
    public static final EFieldUneditableReason FIELD_NOT_SUPPORT_EDIT = null;
    public static final EFieldUneditableReason IS_EXTEND_FIELD = null;
    public static final EFieldUneditableReason IS_SYNC_TABLE = null;
    public static final EFieldUneditableReason LANDSCAPE_READONLY = null;
    public static final EFieldUneditableReason OTHERS = null;
    public static final EFieldUneditableReason SUITE_NO_EDIT_PERM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EFieldUneditableReason[] f207088a = null;

    static {
        EFieldUneditableReason r100 = new EFieldUneditableReason("FIELD_NOT_SUPPORT_EDIT", 0);
        FIELD_NOT_SUPPORT_EDIT = r100;
        EFieldUneditableReason r101 = new EFieldUneditableReason("SUITE_NO_EDIT_PERM", 1);
        SUITE_NO_EDIT_PERM = r101;
        EFieldUneditableReason r102 = new EFieldUneditableReason("LANDSCAPE_READONLY", 2);
        LANDSCAPE_READONLY = r102;
        EFieldUneditableReason r103 = new EFieldUneditableReason("ATTACHMENT_FORBIDDEN_IN_PRO", 3);
        ATTACHMENT_FORBIDDEN_IN_PRO = r103;
        EFieldUneditableReason r104 = new EFieldUneditableReason("BITABLE_IS_NOT_READY", 4);
        BITABLE_IS_NOT_READY = r104;
        EFieldUneditableReason r105 = new EFieldUneditableReason("DRILL_DOWN_NOT_SUPPORT_EDIT", 5);
        DRILL_DOWN_NOT_SUPPORT_EDIT = r105;
        EFieldUneditableReason r110 = new EFieldUneditableReason("IS_SYNC_TABLE", 6);
        IS_SYNC_TABLE = r110;
        EFieldUneditableReason r111 = new EFieldUneditableReason("IS_EXTEND_FIELD", 7);
        IS_EXTEND_FIELD = r111;
        EFieldUneditableReason r112 = new EFieldUneditableReason("EDIT_AFTER_SUBMIT", 8);
        EDIT_AFTER_SUBMIT = r112;
        EFieldUneditableReason r113 = new EFieldUneditableReason(AccountType.OTHERS, 9);
        OTHERS = r113;
        f207088a = new EFieldUneditableReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static EFieldUneditableReason[] values() {
        return (EFieldUneditableReason[]) f207088a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return a.a(name().toLowerCase());
    }

    public static EFieldUneditableReason valueOf(String r100) {
        return (EFieldUneditableReason) r27.a.a(EFieldUneditableReason.class, r100);
    }

    public EFieldUneditableReason(String r100, int r101) {
        super(r100, r101);
    }
}
