package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class k {
    public static String a(Chat r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        return r100.getName();
    }

    public static Chat.MessagePosition c(Chat r100) {
        if (r100 == null) goto L4;
        Long r101 = ChatCoreModule.a().getAppConfigDependency().a().int_value;
        if (r101 == null) goto L9;
        return Chat.MessagePosition.forNumber(r101.intValue());
    L9:
        return ChatCoreModule.a().getSettingDependency().b();
    L4:
        return Chat.MessagePosition.UNKNOWN;
    }

    public static boolean d(Chat r100) {
        if (r100 != null) goto L5;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L17;
        if (r100 != null) goto L13;
    L15:
        return false;
    L13:
        if (r100.isAdmin() == false) goto L15;
        return true;
    L17:
        return true;
    L5:
        if (r100.isP2PChat() == true) goto L9;
        if (TextUtils.equals(r100.getOwnerId(), ChatCoreModule.a().getLoginDependency().getUserId()) == false) goto L9;
        r101 = true;
        goto L10
    }

    public static ChatType b(Chat r100, ChatChatter r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 == null) goto L10;
        if (r101.isBot() == false) goto L10;
        return ChatType.SINGLE_BOT;
    L10:
        if (r100.isP2PChat() == false) goto L13;
        return ChatType.SINGLE;
    L13:
        if (r100.isMeeting() == false) goto L16;
        return ChatType.MEETING;
    L16:
        if (r100.getType() != Chat.Type.GROUP) goto L19;
        return ChatType.GROUP;
    L19:
        if (r100.getType() != Chat.Type.TOPIC_GROUP) goto L26;
        ChatType r102 = ChatType.THREAD;
        Log.e("unknow chat type for statitics chatName = " + r100.getName());
        return r102;
    L26:
        return null;
    }
}
