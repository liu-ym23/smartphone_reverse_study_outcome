package com.ss.android.lark.passport.flow.auth_type;

import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: classes37.dex */
public final enum ContactPointTypeEnum extends Enum<ContactPointTypeEnum> {
    public static final ContactPointTypeEnum IDP = null;
    public static final ContactPointTypeEnum MAIL = null;
    public static final ContactPointTypeEnum OTHERS = null;
    public static final ContactPointTypeEnum PHONE = null;
    public static final ContactPointTypeEnum QR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContactPointTypeEnum[] f437728a = null;
    private final int type;

    static {
        ContactPointTypeEnum r100 = new ContactPointTypeEnum("PHONE", 0, 1);
        PHONE = r100;
        ContactPointTypeEnum r101 = new ContactPointTypeEnum("MAIL", 1, 2);
        MAIL = r101;
        ContactPointTypeEnum r102 = new ContactPointTypeEnum("IDP", 2, 32);
        IDP = r102;
        ContactPointTypeEnum r103 = new ContactPointTypeEnum("QR", 3, 4);
        QR = r103;
        ContactPointTypeEnum r104 = new ContactPointTypeEnum(AccountType.OTHERS, 4, -1);
        OTHERS = r104;
        f437728a = new ContactPointTypeEnum[]{r100, r101, r102, r103, r104};
    }

    public static ContactPointTypeEnum[] values() {
        return (ContactPointTypeEnum[]) f437728a.clone();
    }

    public int value() {
        return this.type;
    }

    public static ContactPointTypeEnum fromValue(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 4) goto L15;
        if (r100 == 32) goto L13;
        return OTHERS;
    L13:
        return IDP;
    L15:
        return QR;
    L17:
        return MAIL;
    L19:
        return PHONE;
    }

    public static ContactPointTypeEnum valueOf(String r100) {
        return (ContactPointTypeEnum) r27.a.a(ContactPointTypeEnum.class, r100);
    }

    public ContactPointTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
