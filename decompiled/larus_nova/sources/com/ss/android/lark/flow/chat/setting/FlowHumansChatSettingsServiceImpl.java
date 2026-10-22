package com.ss.android.lark.flow.chat.setting;

import com.baidu.platform.comapi.map.MapController;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.nova.R;
import com.larus.setting.api.LarkSocialSettingUtils$toSettingsItem$2$1$1;
import com.larus.setting.api.q;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.usersetting.entity.NotificationSettingV2;
import com.ss.android.lark.usersetting.entity.NotificationSettingWrapper;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class FlowHumansChatSettingsServiceImpl implements aza.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f423015d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<aza.a> f423016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f423017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile NotificationSettingV2.ChatMsgNotificationState f423018c;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.usersetting.service.notification.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowHumansChatSettingsServiceImpl f423019a;

        public b(FlowHumansChatSettingsServiceImpl r100) {
            this.f423019a = r100;
        }

        @Override // com.ss.android.lark.usersetting.service.notification.a
        public final void a(NotificationSettingWrapper r100) {
            Intrinsics.checkNotNullParameter(r100, "settingWrapper");
            NotificationSettingV2 r101 = r100.getNotificationSettingV2();
            if (r101 == null) goto L5;
            NotificationSettingV2.ChatMsgNotificationState r102 = r101.getChatMsgState();
        L6:
            if (r102 != null) goto L8;
            return;
        L8:
            if (this.f423019a.f423018c == r102) goto L10;
            Log.i("FlowHumansChatSettingsServiceImpl", "onPushNotificationSetting: old=" + this.f423019a.f423018c + ", new=" + r102);
        L10:
            FlowHumansChatSettingsServiceImpl.d(this.f423019a, r102);
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        f423015d = new AtomicBoolean(false);
    }

    public final com.ss.android.lark.usersetting.service.a f() {
        return (com.ss.android.lark.usersetting.service.a) this.f423017b.getValue();
    }

    @Inject
    public FlowHumansChatSettingsServiceImpl() {
        this.f423016a = new CopyOnWriteArraySet();
        this.f423017b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, FlowHumansChatSettingsServiceImpl$userSettingFacade$2.INSTANCE);
        AtomicBoolean r100 = new AtomicBoolean(false);
        AtomicBoolean r101 = new AtomicBoolean(false);
        b r102 = new b(this);
        if (r101.compareAndSet(false, true) == false) goto L11;
        Log.i("FlowHumansChatSettingsServiceImpl", "ensureInitFetch start");
        f().c();
        if (f423015d.compareAndSet(false, true) == false) goto L8;
        Log.i("FlowHumansChatSettingsServiceImpl", "registerPushOnce");
        f().d();
    L9:
        Log.i("FlowHumansChatSettingsServiceImpl", "ensureInitFetch fetch initial NotificationSettingV2");
        f().a(new FlowHumansChatSettingsServiceImpl$ensureInitFetch$1(this));
        goto L11
    L8:
        Log.i("FlowHumansChatSettingsServiceImpl", "registerPushOnce skipped: already registered");
    L11:
        if (r100.compareAndSet(false, true) == false) goto L14;
        Log.i("FlowHumansChatSettingsServiceImpl", "registerNotificationSettingObserver");
        f().b(r102);
        return;
    }

    public static pza.b e(boolean r100) {
        return new pza.b(UIHelper.getString(R.string.LarkIM_Notifications_UserChats_Switch), r100);
    }

    @Override // aza.b
    public final void a(final q r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Log.i("FlowHumansChatSettingsServiceImpl", "getHumansChatSettings called, cachedState=" + this.f423018c);
        NotificationSettingV2.ChatMsgNotificationState r101 = this.f423018c;
        if (r101 == null) goto L10;
        Log.i("FlowHumansChatSettingsServiceImpl", "getHumansChatSettings cache hit: " + r101);
        if (r101 != NotificationSettingV2.ChatMsgNotificationState.OPEN) goto L7;
        boolean r102 = true;
    L8:
        r100.a(e(r102));
        return;
    L7:
        r102 = false;
        goto L8
    L10:
        Log.i("FlowHumansChatSettingsServiceImpl", "getHumansChatSettings cache miss, fetch from userSettingFacade");
        f().a(new FlowHumansChatSettingsServiceImpl$getHumansChatSettings$2(r100, this));
    }

    public static final void d(FlowHumansChatSettingsServiceImpl r100, NotificationSettingV2.ChatMsgNotificationState r101) {
        r100.getClass();
        Log.i("FlowHumansChatSettingsServiceImpl", "updateCacheAndDispatch: old=" + r100.f423018c + ", new=" + r101 + ", listeners=" + r100.f423016a.size());
        r100.f423018c = r101;
        if (r101 != NotificationSettingV2.ChatMsgNotificationState.OPEN) goto L5;
        boolean r102 = true;
    L6:
        pza.b r103 = e(r102);
        Iterator<aza.a> r104 = r100.f423016a.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r104.next().a(r103);
        goto L8
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // aza.b
    public final void b(pza.b r100, final LarkSocialSettingUtils$toSettingsItem$2$1$1 r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        boolean r102 = r100.f531144d;
        if (r102 == false) goto L5;
        final NotificationSettingV2.ChatMsgNotificationState r103 = NotificationSettingV2.ChatMsgNotificationState.OPEN;
    L6:
        Log.i("FlowHumansChatSettingsServiceImpl", "updateHumansChatSettings called: enabled=" + r102 + ", targetState=" + r103 + ", cachedState=" + this.f423018c);
        if (this.f423018c != r103) goto L10;
        Log.i("FlowHumansChatSettingsServiceImpl", "updateHumansChatSettings no-op: cachedState already equals targetState");
        r101.onSuccess(Unit.INSTANCE);
        return;
    L10:
        f().a(new FlowHumansChatSettingsServiceImpl$updateHumansChatSettings$1(r103, this, r101));
        return;
    L5:
        r103 = NotificationSettingV2.ChatMsgNotificationState.CLOSED;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.ss.android.lark.flow.chat.setting.FlowHumansChatSettingsServiceImpl$syncSettings$1] */
    public static final void c(final FlowHumansChatSettingsServiceImpl r100, NotificationSettingV2 r101, final NotificationSettingV2.ChatMsgNotificationState r102, final IGetDataCallback r103) {
        r100.getClass();
        Log.i("FlowHumansChatSettingsServiceImpl", "persist setNotificationSettingV2: targetState=" + r102);
        r100.f().e(r101, new FlowHumansChatSettingsServiceImpl$syncSettings$1(r102, r100, r103));
    }
}
