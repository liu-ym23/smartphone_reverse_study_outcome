package com.ss.android.lark.usersetting.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.flow.chat.setting.FlowHumansChatSettingsServiceImpl$syncSettings$1;
import com.ss.android.lark.usersetting.entity.NotificationSettingV2;

/* JADX INFO: loaded from: classes38.dex */
public interface a {
    void a(IGetDataCallback<NotificationSettingV2> r100);

    void b(com.ss.android.lark.usersetting.service.notification.a r100);

    void c();

    void d();

    void e(NotificationSettingV2 r100, FlowHumansChatSettingsServiceImpl$syncSettings$1 r101);
}
