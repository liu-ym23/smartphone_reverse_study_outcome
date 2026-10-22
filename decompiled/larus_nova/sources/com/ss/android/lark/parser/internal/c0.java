package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.TopicGroupRole;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.thread.TopicGroup;

/* JADX INFO: loaded from: classes37.dex */
public final class c0 {
    public static TopicGroup a(com.bytedance.lark.pb.basic.v1.TopicGroup r100, Chat r101) {
        TopicGroup r102 = new TopicGroup();
        r102.setId(r100.f253579id);
        r102.setType(TopicGroup.Type.fromValue(r100.type.getValue()));
        if (r100.user_setting == null) goto L8;
        TopicGroup.UserSetting r103 = new TopicGroup.UserSetting();
        r103.setFavorite(r100.user_setting.is_favorite.booleanValue());
        r103.setUpdateTime(r100.user_setting.update_time.longValue());
        TopicGroupRole r104 = r100.user_setting.topic_group_role;
        if (r104 == null) goto L7;
        r103.setTopicGroupRole(TopicGroup.TopicGroupRole.fromValue(r104.getValue()));
    L7:
        r102.setUserSetting(r103);
    L8:
        if (r101 == null) goto L10;
        r102.setChat(r101);
    L10:
        return r102;
    }
}
