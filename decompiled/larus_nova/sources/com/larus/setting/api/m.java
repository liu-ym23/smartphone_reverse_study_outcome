package com.larus.setting.api;

import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;

/* JADX INFO: loaded from: classes31.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f367913a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367914a = null;

        static {
            int[] r100 = new int[DoubaoAddFriendSettingType.values().length];
            r100[DoubaoAddFriendSettingType.GROUP_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[DoubaoAddFriendSettingType.QR_CODE_AND_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[DoubaoAddFriendSettingType.NAME_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[DoubaoAddFriendSettingType.DOCUMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f367914a = r100;
        }
    }

    static {
    }
}
