package com.ss.android.lark.officesdk.contact.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/contact/api/model/DoubaoAddFriendSettingType;", "", "<init>", "(Ljava/lang/String;I)V", "GROUP_CHAT", "QR_CODE_AND_LINK", "NAME_CARD", "DOCUMENT", "contact-officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoAddFriendSettingType extends Enum<DoubaoAddFriendSettingType> {
    public static final DoubaoAddFriendSettingType DOCUMENT = null;
    public static final DoubaoAddFriendSettingType GROUP_CHAT = null;
    public static final DoubaoAddFriendSettingType NAME_CARD = null;
    public static final DoubaoAddFriendSettingType QR_CODE_AND_LINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoubaoAddFriendSettingType[] f433134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433135b = null;

    public static EnumEntries<DoubaoAddFriendSettingType> getEntries() {
        return f433135b;
    }

    static {
        DoubaoAddFriendSettingType r100 = new DoubaoAddFriendSettingType("GROUP_CHAT", 0);
        GROUP_CHAT = r100;
        DoubaoAddFriendSettingType r101 = new DoubaoAddFriendSettingType("QR_CODE_AND_LINK", 1);
        QR_CODE_AND_LINK = r101;
        DoubaoAddFriendSettingType r102 = new DoubaoAddFriendSettingType("NAME_CARD", 2);
        NAME_CARD = r102;
        DoubaoAddFriendSettingType r103 = new DoubaoAddFriendSettingType("DOCUMENT", 3);
        DOCUMENT = r103;
        DoubaoAddFriendSettingType[] r104 = {r100, r101, r102, r103};
        f433134a = r104;
        f433135b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoubaoAddFriendSettingType[] values() {
        return (DoubaoAddFriendSettingType[]) f433134a.clone();
    }

    public static DoubaoAddFriendSettingType valueOf(String r100) {
        return (DoubaoAddFriendSettingType) a.a(DoubaoAddFriendSettingType.class, r100);
    }

    public DoubaoAddFriendSettingType(String r100, int r101) {
        super(r100, r101);
    }
}
