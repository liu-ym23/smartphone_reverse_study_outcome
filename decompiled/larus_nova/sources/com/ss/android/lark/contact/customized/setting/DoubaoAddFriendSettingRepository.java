package com.ss.android.lark.contact.customized.setting;

import com.bytedance.lark.pb.settings.v1.WayToAddFriendItem;
import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes35.dex */
public final class DoubaoAddFriendSettingRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f419431a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f419432a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f419433b = null;

        static {
            int[] r100 = new int[WayToAddFriendItem.values().length];
            r100[WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_CONTACT_TOKEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r100[WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_NAME_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[WayToAddFriendItem.WAY_TO_ADD_FRIEND_ITEM_DOCS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            f419432a = r100;
            int[] r101 = new int[DoubaoAddFriendSettingType.values().length];
            r101[DoubaoAddFriendSettingType.GROUP_CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r101[DoubaoAddFriendSettingType.QR_CODE_AND_LINK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r101[DoubaoAddFriendSettingType.NAME_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r101[DoubaoAddFriendSettingType.DOCUMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            f419433b = r101;
        }
    }

    static {
        f419431a = LazyKt.lazy(DoubaoAddFriendSettingRepository$listeners$2.INSTANCE);
    }
}
