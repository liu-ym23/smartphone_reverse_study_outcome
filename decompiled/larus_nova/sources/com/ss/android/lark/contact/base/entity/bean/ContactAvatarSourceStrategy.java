package com.ss.android.lark.contact.base.entity.bean;

import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum ContactAvatarSourceStrategy extends Enum<ContactAvatarSourceStrategy> {
    public static final ContactAvatarSourceStrategy FOREGROUND_USER = null;
    public static final ContactAvatarSourceStrategy LOGIN_CHATTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContactAvatarSourceStrategy[] f418873a = null;

    static {
        ContactAvatarSourceStrategy r100 = new ContactAvatarSourceStrategy("FOREGROUND_USER", 0);
        FOREGROUND_USER = r100;
        ContactAvatarSourceStrategy r101 = new ContactAvatarSourceStrategy("LOGIN_CHATTER", 1);
        LOGIN_CHATTER = r101;
        f418873a = new ContactAvatarSourceStrategy[]{r100, r101};
    }

    public static ContactAvatarSourceStrategy[] values() {
        return (ContactAvatarSourceStrategy[]) f418873a.clone();
    }

    public static ContactAvatarSourceStrategy valueOf(String r100) {
        return (ContactAvatarSourceStrategy) a.a(ContactAvatarSourceStrategy.class, r100);
    }

    public ContactAvatarSourceStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
