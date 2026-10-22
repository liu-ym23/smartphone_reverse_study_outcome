package com.ss.android.lark.contact.base.entity.api;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum ContactMobileApi$ContactType extends Enum<ContactMobileApi$ContactType> {
    public static final ContactMobileApi$ContactType EMAIL = null;
    public static final ContactMobileApi$ContactType PHONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContactMobileApi$ContactType[] f418871a = null;

    static {
        ContactMobileApi$ContactType r100 = new ContactMobileApi$ContactType(CommonConstant.RETKEY.EMAIL, 0);
        EMAIL = r100;
        ContactMobileApi$ContactType r101 = new ContactMobileApi$ContactType("PHONE", 1);
        PHONE = r101;
        f418871a = new ContactMobileApi$ContactType[]{r100, r101};
    }

    public static ContactMobileApi$ContactType[] values() {
        return (ContactMobileApi$ContactType[]) f418871a.clone();
    }

    public static ContactMobileApi$ContactType valueOf(String r100) {
        return (ContactMobileApi$ContactType) a.a(ContactMobileApi$ContactType.class, r100);
    }

    public ContactMobileApi$ContactType(String r100, int r101) {
        super(r100, r101);
    }
}
