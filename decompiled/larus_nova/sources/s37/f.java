package s37;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Message;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.notification.activity.BannerActivity;
import com.bytedance.notification.activity.PushBannerActivity;
import com.bytedance.notification.activity.SmpBannerActivity;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.supporter.impl.g;
import com.ss.android.message.util.ToolUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends a {
    @Override // s37.a
    public final void d(Message r100) {
    }

    @Override // t37.a
    public final PendingIntent a(Context r110) {
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIsDebugMode == false) goto L5;
        com.bytedance.push.utils.f.b("WindowBannerNotification", "cur is debug mode,not filter");
    L12:
        if (((g) ((v37.a) v37.a.b()).e()).f266104c.inKeyguardRestrictedInputMode() == false) goto L16;
        ((v37.a) v37.a.b()).f(this.f540483d.f164103id, false, "screen_off", TeaEventTrack.ACTION_DRAMA_PRE);
        com.bytedance.push.utils.f.b("WindowBannerNotification", "not show banner because cur screen is off");
        return null;
    L16:
        if (com.bytedance.notification.helper.a.a().f266073f == false) goto L20;
        ((v37.a) v37.a.b()).f(this.f540483d.f164103id, false, "is_showing", TeaEventTrack.ACTION_DRAMA_PRE);
        com.bytedance.push.utils.f.b("WindowBannerNotification", "not show banner because cur is showing");
        return null;
    L20:
        if (ToolUtils.isMainProcess(r110) == false) goto L23;
        Class r100 = BannerActivity.class;
        BannerActivity.a(this.f540484e, this.f540487h, (long) (this.f540482c.f266062v * 1000.0d), this.f540483d.f164103id);
    L29:
        com.bytedance.push.utils.f.b("WindowBannerNotification", "try show banner, cur process is " + ToolUtils.getCurProcessNameSuffix(r110) + " targetClass is " + r100);
        if (r100 != null) goto L32;
        return null;
    L32:
        Intent r101 = new Intent(r110, r100);
        r101.setFlags(268435456);
        if (Build.VERSION.SDK_INT < 23) goto L35;
        int r102 = 201326592;
    L36:
        ((v37.a) v37.a.b()).f(this.f540483d.f164103id, true, "success", TeaEventTrack.ACTION_DRAMA_PRE);
        return PendingIntent.getActivity(r110, 0, r101, r102);
    L35:
        r102 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L36
    L23:
        if (ToolUtils.isSmpProcess(r110) == false) goto L26;
        r100 = SmpBannerActivity.class;
        BannerActivity.a(this.f540484e, this.f540487h, (long) (this.f540482c.f266062v * 1000.0d), this.f540483d.f164103id);
        goto L29
    L26:
        if (ToolUtils.isMessageProcess(r110) == false) goto L28;
        r100 = PushBannerActivity.class;
        BannerActivity.a(this.f540484e, this.f540487h, (long) (this.f540482c.f266062v * 1000.0d), this.f540483d.f164103id);
        goto L29
    L28:
        r100 = null;
        goto L29
    L5:
        if ((System.currentTimeMillis() - PushCommonSupport.getInstance().getPushConfigurationService().getCurProcessStartTimeStamp()) >= 3000) goto L7;
    L8:
        ((v37.a) v37.a.b()).f(this.f540483d.f164103id, false, "background", TeaEventTrack.ACTION_DRAMA_PRE);
        com.bytedance.push.utils.f.b("WindowBannerNotification", "not show banner because cur is in foreground");
        return null;
    L7:
        if (m67.a.d() == true) goto L12;
        goto L8
    }

    @Override // s37.a
    public final void c(boolean r100, int r101) {
        WeakReference<BannerActivity> r102 = com.bytedance.notification.helper.a.a().f266068a;
        if (r102 == null) goto L10;
        BannerActivity r103 = r102.get();
        if (r103 == null) goto L11;
        r103.f266025a = r100;
        r103.f266026b = r101;
        if (com.bytedance.notification.helper.a.a().f266073f == false) goto L12;
        r103.finish();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // s37.a
    public final void f(String r100, int r101) {
        this.f540485f = r100;
        this.f540486g = r101;
    }

    public f(Context r100, Notification.Builder r101, Intent r102, PushNotificationExtra r103, NotificationBody r104) {
        super(r100, r101, r102, r103, r104);
    }
}
