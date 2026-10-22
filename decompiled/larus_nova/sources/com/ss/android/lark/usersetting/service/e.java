package com.ss.android.lark.usersetting.service;

import aac.f;
import aac.g;
import aac.h;
import aac.i;
import aac.j;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.settings.v1.MessengerNotificationSetting;
import com.bytedance.lark.pb.settings.v1.SetUserSettingRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.flow.chat.setting.FlowHumansChatSettingsServiceImpl$syncSettings$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.usersetting.entity.DriveNotificationSetting;
import com.ss.android.lark.usersetting.entity.NotificationSettingV2;
import com.ss.android.lark.usersetting.entity.SpecialFocusSetting;
import com.ss.android.lark.usersetting.service.timeformat.TimeFormatSetting;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements com.ss.android.lark.usersetting.service.a {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f444639a = null;

        static {
            f444639a = new e();
        }
    }

    @Override // com.ss.android.lark.usersetting.service.a
    public final void c() {
        g r100 = g.d.f2395a;
        r100.getClass();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r100));
    }

    @Override // com.ss.android.lark.usersetting.service.a
    public final void d() {
        Object r100 = f.f2385c;
        f r101 = f.c.f2388a;
        r101.getClass();
        com.ss.android.lark.sdk.g.e.f439875a.b(Command.PUSH_USER_SETTING, new aac.d(r101));
    }

    public final TimeFormatSetting f() {
        Object r100 = com.ss.android.lark.usersetting.service.timeformat.b.f444648b;
        com.ss.android.lark.usersetting.service.timeformat.b.C5374b.f444651a.getClass();
        UserSetting r101 = g.d.f2395a.f2389a.a();
        if (r101 != null) goto L6;
        return com.ss.android.lark.usersetting.service.timeformat.b.a(null);
    L6:
        return com.ss.android.lark.usersetting.service.timeformat.b.a(r101.getTimeFormatSetting());
    }

    public e() {
        nzb.b r100 = new b(this);
        ozb.c r101 = new c(this);
        ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerLoginListener(r100);
        ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerLogoutListener(r101);
        qzb.a r102 = new d();
        ((xzb.a) ApiUtils.getApi(xzb.a.class)).registerUserSwitchListener(r102);
    }

    public static void g(boolean r100) {
        Log.i("UserSettingFacade", "handleLoginStatusChanged isLogin = " + r100);
        if (r100 == false) goto L5;
        g r101 = g.d.f2395a;
        r101.getClass();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r101));
        return;
    L5:
        g r102 = g.d.f2395a;
        r102.getClass();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new i(r102));
    }

    @Override // com.ss.android.lark.usersetting.service.a
    public final void a(IGetDataCallback<NotificationSettingV2> r100) {
        Object r101 = com.ss.android.lark.usersetting.service.notification.b.f444640b;
        com.ss.android.lark.usersetting.service.notification.b.C5373b.f444643a.a(r100);
    }

    @Override // com.ss.android.lark.usersetting.service.a
    public final void b(com.ss.android.lark.usersetting.service.notification.a r100) {
        Object r101 = com.ss.android.lark.usersetting.service.notification.b.f444640b;
        com.ss.android.lark.usersetting.service.notification.b r102 = com.ss.android.lark.usersetting.service.notification.b.C5373b.f444643a;
        if (r100 != null) goto L5;
        r102.getClass();
        return;
    L5:
        r102.f444641a.put(r100, com.ss.android.lark.usersetting.service.notification.b.f444640b);
    }

    @Override // com.ss.android.lark.usersetting.service.a
    public final void e(NotificationSettingV2 r100, FlowHumansChatSettingsServiceImpl$syncSettings$1 r101) {
        Object r102 = com.ss.android.lark.usersetting.service.notification.b.f444640b;
        com.ss.android.lark.usersetting.service.notification.b.C5373b.f444643a.getClass();
        SetUserSettingRequest.Builder r103 = new SetUserSettingRequest.Builder();
        SpecialFocusSetting r104 = r100.getSpecialFocusSetting();
        if (r104 == null) goto L5;
        MessengerNotificationSetting.SpecialFocus r105 = new MessengerNotificationSetting.SpecialFocus.Builder().notice_in_mute_chat(Boolean.valueOf(r104.isNoDisturbNotify())).notice_in_chat_box(Boolean.valueOf(r104.isChatBoxNotify())).notice_in_mute_mode(Boolean.valueOf(r104.isMuteNotify())).build();
    L6:
        MessengerNotificationSetting r106 = new MessengerNotificationSetting.Builder().switch_state(MessengerNotificationSetting.SwithState.fromValue(r100.getChatMsgState().getNumber())).buzz_open(Boolean.valueOf(r100.isBuzzOpen())).mention_open(Boolean.valueOf(r100.isMentionOpen())).user_p2p_chat_open(Boolean.valueOf(r100.isUserSingleChatOpen())).mention_all_open(Boolean.valueOf(r100.isMentionAllOpen())).special_focus_open(Boolean.valueOf(r100.isSpecialFocusOpen())).special_focus_setting(r105).build();
        com.bytedance.lark.pb.settings.v1.NotificationSettingV2.Builder r107 = new com.bytedance.lark.pb.settings.v1.NotificationSettingV2.Builder().messenger_notification_setting(r106);
        DriveNotificationSetting r108 = r100.getDriveNotificationSetting();
        SetUserSettingRequest.Builder r109 = r103.notification_setting_v2(r107.drive_notification_setting(new com.bytedance.lark.pb.settings.v1.DriveNotificationSetting.Builder().notify_open(Boolean.valueOf(r108.isDriveOpen())).build()).build());
        g.d.f2395a.getClass();
        SdkSender.asynSendRequestNonWrap(Command.SET_USER_SETTING, r109, r101, new j());
        return;
    L5:
        r105 = null;
        goto L6
    }
}
