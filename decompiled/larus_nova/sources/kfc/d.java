package kfc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.log.PushLog;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile d f503313t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f503314u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f503315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yfc.b f503316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f503317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHandler f503318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f503319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f503320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f503321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f503322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f503323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f503324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f503325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f503326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f503327m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f503328n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f503329o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f503330p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f503331q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a f503332r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f503333s;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f503334a;

        public a(d r100) {
            this.f503334a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r100 == null) goto L18;
            if (r101 == null) goto L22;
        L13:
            th = move-exception;
            th.printStackTrace();
            return;
        L6:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == true) goto L8;
            return;
        L8:
            if (NetworkUtils.isNetworkAvailable(r100) == false) goto L20;
            d r102 = this.f503334a;     // Catch: Throwable -> L13
            if (r102.f503315a == false) goto L21;
            r102.f503318d.sendEmptyMessage(0);     // Catch: Throwable -> L13
            return;
        L21:
            return;
        L20:
            return;
        L22:
            return;
        }
    }

    public class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f503335a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            if (com.bytedance.push.utils.f.f267065a == false) goto L5;
            com.bytedance.push.utils.f.b("RedBadgeController", "KEY_IS_DESKTOP_RED_BADGE_SHOW");
        L5:
            d r101 = this.f503335a;
            r101.e(r101.f503317c);
        }

        public b(d r100, WeakHandler r101) {
            this.f503335a = r100;
            super(r101);
        }
    }

    public class c extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f503336a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            if (com.bytedance.push.utils.f.f267065a == false) goto L5;
            com.bytedance.push.utils.f.b("RedBadgeController", "KEY_DESKTOP_RED_BADGE_ARGS");
        L5:
            d r101 = this.f503336a;
            r101.e(r101.f503317c);
        }

        public c(d r100, WeakHandler r101) {
            this.f503336a = r100;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: kfc.d$d, reason: collision with other inner class name */
    public class C6549d extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f503337a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            if (com.bytedance.push.utils.f.f267065a == false) goto L5;
            com.bytedance.push.utils.f.b("RedBadgeController", "KEY_LAST_TIME_PARAS");
        L5:
            d r101 = this.f503337a;
            r101.f(r101.f503317c);
        }

        public C6549d(d r100, WeakHandler r101) {
            this.f503337a = r100;
            super(r101);
        }
    }

    public final void c() {
        if (this.f503319e == true) goto L5;
        return;
    L5:
        if (this.f503331q == false) goto L8;
        return;
    L8:
        if (com.bytedance.push.utils.f.f267065a == false) goto L51;
        com.bytedance.push.utils.f.b("RedBadgeController", "handleOnSchedule");
    L51:
        this.f503318d.removeMessages(0);     // Catch: Throwable -> L48
        long r100 = ToolUtils.currentTimeMillis();     // Catch: Throwable -> L48
        if (r100 >= this.f503328n) goto L15;
        this.f503328n = r100 - ((long) (this.f503329o * 1000));     // Catch: Throwable -> L48
        mfc.a.a(this.f503317c).c(this.f503328n);     // Catch: Throwable -> L48
    L15:
        if (com.ss.android.pushmanager.setting.a.b().d() == false) goto L23;
        if (zfc.a.a().n0() == false) goto L23;
        if (com.bytedance.push.utils.f.f267065a == false) goto L21;
        com.bytedance.push.utils.f.b("RedBadgeController", "isApplicationForeground = true now = " + r100 + " mIsForeground = " + this.f503330p);     // Catch: Throwable -> L48
    L21:
        WeakHandler r101 = this.f503318d;     // Catch: Throwable -> L48
        r101.sendMessage(r101.obtainMessage(4, Long.valueOf(r100)));     // Catch: Throwable -> L48
        return;
    L23:
        if (com.bytedance.push.utils.f.f267065a == false) goto L26;
        com.bytedance.push.utils.f.b("RedBadgeController", "isApplicationForeground = false now = " + r100 + " mIsForeground = " + this.f503330p);     // Catch: Throwable -> L48
    L26:
        if (com.bytedance.push.utils.f.f267065a == false) goto L28;
        com.bytedance.push.utils.f.b("RedBadgeController", "mLastLeaveTime = " + this.f503326l + " mLastLaunchTime = " + this.f503325k);     // Catch: Throwable -> L48
    L28:
        long r102 = this.f503326l;     // Catch: Throwable -> L48
        long r103 = this.f503325k;     // Catch: Throwable -> L48
        if (r102 >= r103) goto L31;
        long r104 = (r100 - r103) - 900000;     // Catch: Throwable -> L48
    L33:
        if (com.bytedance.push.utils.f.f267065a == false) goto L36;
        com.bytedance.push.utils.f.b("RedBadgeController", "duration = " + (r104 / 1000) + " mQueryWaitingDuration = " + this.f503321g + " mNextQueryInterval = " + this.f503329o + " mLastRequestTime = " + this.f503328n);     // Catch: Throwable -> L48
    L36:
        if (r104 >= (this.f503321g * 1000)) goto L38;
    L46:
        WeakHandler r105 = this.f503318d;     // Catch: Throwable -> L48
        r105.sendMessage(r105.obtainMessage(4, Long.valueOf(r100)));     // Catch: Throwable -> L48
        return;
    L38:
        if ((r100 - this.f503328n) < (this.f503329o * 1000)) goto L46;
        if (com.bytedance.push.utils.f.f267065a == false) goto L43;
        com.bytedance.push.utils.f.b("RedBadgeController", "doSendRequest");     // Catch: Throwable -> L48
    L43:
        if (this.f503333s.get() == true) goto L54;
        this.f503333s.getAndSet(true);     // Catch: Throwable -> L48
        ThreadPlus.submitRunnable(new e(this, r100));     // Catch: Throwable -> L48
        return;
    L54:
        return;
    L31:
        r104 = r100 - r102;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
    }

    public d(yfc.b r110) {
        this.f503315a = false;
        WeakHandler r100 = new WeakHandler(PushThreadHandlerManager.inst().getLooper(), this);
        this.f503318d = r100;
        this.f503330p = false;
        this.f503332r = new a(this);
        this.f503333s = new AtomicBoolean(false);
        b r101 = new b(this, r100);
        c r102 = new c(this, r100);
        C6549d r103 = new C6549d(this, r100);
        this.f503316b = r110;
        Context r111 = r110.getContext().getApplicationContext();
        this.f503317c = r111;
        e(r111);
        if (r111 != null) goto L20;
    L8:
        com.bytedance.push.utils.f.b("RedBadgeController", "init on RedBadgeController");
        if (this.f503319e == false) goto L11;
    L12:
        PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.registerReceiver(this.f503317c, this.f503332r, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        f(this.f503317c);
    L13:
        boolean r104 = PushServiceManager.get().getPullExternalService().isUseNewOnlineRedBadgeApi();
        this.f503331q = r104;
        if (this.f503319e == false) goto L17;
        if (r104 == true) goto L17;
        com.bytedance.push.utils.f.b("RedBadgeController", "init on RedBadgeController:start red badge pull");
        this.f503318d.sendEmptyMessageDelayed(0, 10000);
    L18:
        this.f503315a = true;
        return;
    L17:
        com.bytedance.push.utils.f.b("RedBadgeController", "init on RedBadgeController:not start red badge pull because mIsAllowRedBadgeShow:" + this.f503319e + " mUseNewOnlineRedBadgeApi:" + r104);
        goto L18
    L11:
        if (PushServiceManager.get().getPullExternalService().isUseNewApi() == false) goto L13;
    L20:
        r111.getContentResolver().registerContentObserver(PushMultiProcessSharedProvider.c(r111, "is_desktop_red_badge_show", "boolean"), true, r101);     // Catch: Throwable -> L7
        r111.getContentResolver().registerContentObserver(PushMultiProcessSharedProvider.c(r111, "desktop_red_badge_args", "string"), true, r102);     // Catch: Throwable -> L7
        r111.getContentResolver().registerContentObserver(PushMultiProcessSharedProvider.c(r111, "red_badge_last_time_paras", "string"), true, r103);     // Catch: Throwable -> L7
        goto L8
    }

    public static d d(yfc.b r100) {
        if (f503313t != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f503313t != null) goto L9;
        f503313t = new d(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f503313t;
    }

    public static JSONObject h(String r100) {
        JSONObject r101 = new JSONObject();
        if (StringUtils.isEmpty(r100) == false) goto L15;
        return r101;
    L15:
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L10
        a(r102, EventVerify.TYPE_LAUNCH);     // Catch: Throwable -> L8
        a(r102, "leave");     // Catch: Throwable -> L8
        a(r102, IAllianceService.CONTENT_TYPE_BADGE);     // Catch: Throwable -> L8
        return r102;
    L8:
        th = th;
        r101 = r102;
    L11:
        th.printStackTrace();
        return r101;
    L10:
        th = th;
        goto L11
    }

    public final void e(Context r100) {
        if (r100 != null) goto L16;
        return;
    L16:
        this.f503319e = mfc.a.a(this.f503317c).f513691a.c("is_desktop_red_badge_show", false);     // Catch: Throwable -> L13
        String r101 = mfc.a.a(this.f503317c).f513691a.e("desktop_red_badge_args");     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        JSONObject r102 = new JSONObject(r101);     // Catch: Throwable -> L13
        this.f503320f = r102.optInt("max_show_times", 5);     // Catch: Throwable -> L13
        this.f503321g = r102.optInt("query_waiting_duration", 30);     // Catch: Throwable -> L13
        this.f503322h = r102.optString(BdpAppEventConstant.PARAMS_STRATEGY_NAME);     // Catch: Throwable -> L13
        if (this.f503319e == true) goto L10;
    L11:
        this.f503318d.removeMessages(0);     // Catch: Throwable -> L13
        this.f503318d.removeMessages(1);     // Catch: Throwable -> L13
        this.f503318d.removeMessages(2);     // Catch: Throwable -> L13
        return;
    L10:
        if (this.f503331q == true) goto L11;
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public final void f(Context r100) {
        if (r100 != null) goto L12;
        return;
    L12:
        this.f503328n = mfc.a.a(this.f503317c).b();     // Catch: Throwable -> L9
        this.f503329o = mfc.a.a(this.f503317c).f513691a.d("red_badge_next_query_interval", 600);     // Catch: Throwable -> L9
        this.f503323i = mfc.a.a(this.f503317c).f513691a.e("red_badge_last_time_paras");     // Catch: Throwable -> L9
        this.f503324j = mfc.a.a(this.f503317c).f513691a.e("red_badge_last_last_time_paras");     // Catch: Throwable -> L9
        if (StringUtils.isEmpty(this.f503323i) == false) goto L7;
        return;
    L7:
        JSONObject r101 = new JSONObject(this.f503323i);     // Catch: Throwable -> L9
        this.f503325k = r101.optLong(EventVerify.TYPE_LAUNCH);     // Catch: Throwable -> L9
        this.f503326l = r101.optLong("leave");     // Catch: Throwable -> L9
        this.f503327m = r101.optLong(IAllianceService.CONTENT_TYPE_BADGE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r110) {
        if (r110 != null) goto L52;
        return;
    L52:
        int r100 = r110.what;     // Catch: Throwable -> L49
        if (r100 != 0) goto L8;
        c();     // Catch: Throwable -> L49
        return;
    L8:
        if (r100 == 1) goto L37;
        if (r100 == 2) goto L28;
        if (r100 != 3) goto L14;
        long r101 = ((Long) r110.obj).longValue();     // Catch: Throwable -> L49
        long r102 = this.f503329o * 1000;     // Catch: Throwable -> L49
        if (com.bytedance.push.utils.f.f267065a == false) goto L26;
        com.bytedance.push.utils.f.b("RedBadgeController", "next schedule time = " + DateFormat.getDateTimeInstance().format(new Date(r101 + r102)));     // Catch: Throwable -> L49
    L26:
        this.f503318d.sendEmptyMessageDelayed(0, r102);     // Catch: Throwable -> L49
        return;
    L14:
        if (r100 != 4) goto L62;
        long r103 = ((Long) r110.obj).longValue();     // Catch: Throwable -> L49
        int r111 = this.f503329o;     // Catch: Throwable -> L49
        long r104 = r111 * 1000;     // Catch: Throwable -> L49
        long r105 = this.f503328n + ((long) (r111 * 1000));     // Catch: Throwable -> L49
        if (r103 > r105) goto L20;
        r104 = r105 - r103;     // Catch: Throwable -> L49
    L20:
        if (com.bytedance.push.utils.f.f267065a == false) goto L22;
        com.bytedance.push.utils.f.b("RedBadgeController", "now=" + r103 + "mNextQueryInterval=" + this.f503329o + ",mLastRequestTime=" + this.f503328n + "next schedule time = " + DateFormat.getDateTimeInstance().format(new Date(r103 + r104)));     // Catch: Throwable -> L49
    L22:
        this.f503318d.sendEmptyMessageDelayed(0, r104);     // Catch: Throwable -> L49
        return;
    L62:
        return;
    L28:
        if (com.bytedance.push.utils.f.f267065a == false) goto L31;
        com.bytedance.push.utils.f.b("RedBadgeController", "handleOnAppExit");     // Catch: Throwable -> L49
    L31:
        if (this.f503319e == true) goto L33;
        return;
    L33:
        if (this.f503331q == true) goto L56;
        this.f503330p = false;     // Catch: Throwable -> L49
        this.f503318d.removeMessages(0);     // Catch: Throwable -> L49
        this.f503318d.sendEmptyMessageDelayed(0, this.f503321g * 1000);     // Catch: Throwable -> L49
        return;
    L56:
        return;
    L37:
        if (com.bytedance.push.utils.f.f267065a == false) goto L40;
        com.bytedance.push.utils.f.b("RedBadgeController", "handleOnAppEntrance");     // Catch: Throwable -> L49
    L40:
        if (this.f503319e == true) goto L42;
        return;
    L42:
        if (this.f503331q == true) goto L59;
        this.f503330p = true;     // Catch: Throwable -> L49
        if (this.f503318d.hasMessages(0) == true) goto L60;
        this.f503318d.sendEmptyMessageDelayed(0, this.f503329o * 1000);     // Catch: Throwable -> L49
        return;
    L60:
        return;
    L59:
        return;
    L49:
        th = move-exception;
        th.printStackTrace();
    }

    public final void i(String r110) {
        String r100 = mfc.a.a(this.f503317c).f513691a.e("red_badge_last_valid_response");
        com.bytedance.push.utils.f.b("RedBadgeController", "tryUseLastValidResponse: lastRes = " + r100 + "  isUseRedBadgeLastValidResponse() = " + mfc.a.a(this.f503317c).f513691a.c("red_badge_is_use_last_valid_response", true));
        if (mfc.a.a(this.f503317c).f513691a.c("red_badge_is_use_last_valid_response", true) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L40;
        int r101 = mfc.a.a(this.f503317c).f513691a.d("red_badge_show_times", 0);     // Catch: Exception -> L32
        if (DateUtils.isToday(this.f503327m) == true) goto L11;
        if (r101 <= 0) goto L11;
        r101 = 0;
    L11:
        if (r101 >= this.f503320f) goto L13;
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L32
        if ("success".equals(JSONObjectProtectorUtils.getString(r102, "reason")) == false) goto L30;
        r102.put("content", r102.optInt("content", 0) + 1);     // Catch: Exception -> L32
        com.bytedance.push.utils.f.b("RedBadgeController", "tryUseLastValidResponse: res = " + r102);     // Catch: Exception -> L32
        PushLog.onEvent(this.f503317c, "red_badge", "use_last_valid_response", new JSONObject[]{r102});     // Catch: Exception -> L32
        this.f503328n = ToolUtils.currentTimeMillis();     // Catch: Exception -> L32
        this.f503329o = r102.optInt("next_query_interval", 0) + 600;     // Catch: Exception -> L32
        mfc.a r103 = mfc.a.a(this.f503317c);     // Catch: Throwable -> L27
        String r104 = r102.toString();     // Catch: Throwable -> L27
        PushMultiProcessSharedProvider.a r105 = r103.f513691a.b();     // Catch: Throwable -> L27
        r105.f449558b.put("red_badge_last_valid_response", r104);     // Catch: Throwable -> L27
        r105.a();     // Catch: Throwable -> L27
        Intent r106 = new Intent("com.ss.android.redbadge.message");     // Catch: Throwable -> L27
        r106.putExtra("message_data", r102.toString());     // Catch: Throwable -> L27
        r106.setPackage(this.f503317c.getPackageName());     // Catch: Throwable -> L27
        r106.putExtra("red_data_from", "last_valid_response");     // Catch: Throwable -> L27
        r106.putExtra("use_last_resp_reason", r110);     // Catch: Throwable -> L27
        if (Build.VERSION.SDK_INT >= 26) goto L23;
    L25:
        this.f503317c.startService(r106);     // Catch: Throwable -> L27
    L35:
    L29:
        mfc.a.a(this.f503317c).c(this.f503328n);     // Catch: Exception -> L32
        mfc.a r111 = mfc.a.a(this.f503317c);     // Catch: Exception -> L32
        int r107 = this.f503329o;     // Catch: Exception -> L32
        PushMultiProcessSharedProvider.a r112 = r111.f513691a.b();     // Catch: Exception -> L32
        r112.f449558b.put("red_badge_next_query_interval", Integer.valueOf(r107));     // Catch: Exception -> L32
        r112.a();     // Catch: Exception -> L32
        goto L30
    L23:
        if (AppProvider.getTargetSdkVersion() < 26) goto L25;
        Context r113 = this.f503317c;     // Catch: Throwable -> L27
        r113.bindService(r106, new g(r106, r113), 1);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L32
    L30:
        mfc.a.a(this.f503317c).c(this.f503328n);     // Catch: Exception -> L32
        return;
    L13:
        if (com.bytedance.push.utils.f.f267065a == false) goto L15;
        com.bytedance.push.utils.f.b("RedBadgeController", "badge_show_times = " + r101);     // Catch: Exception -> L32
    L15:
        PushLog.onEvent(this.f503317c, PushLog.CATEGORY, "red_badge", "outdo_max_show_times", r101, this.f503320f);     // Catch: Exception -> L32
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void a(JSONObject r100, String r101) {
        if (StringUtils.isEmpty(r101) == true) goto L10;
        r100.put(r101, r100.optLong(r101) / 1000);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public final JSONObject b(Context r110, boolean r111) {
        JSONObject r100 = new JSONObject();
        int r101 = 0;
        int r102 = mfc.a.a(r110).f513691a.d("red_badge_launch_times", 0);     // Catch: Throwable -> L31
        long r103 = this.f503325k;     // Catch: Throwable -> L31
        long r104 = this.f503327m;     // Catch: Throwable -> L31
        String r105 = this.f503323i;     // Catch: Throwable -> L31
        String r106 = this.f503324j;     // Catch: Throwable -> L31
        String r107 = this.f503322h;     // Catch: Throwable -> L31
        if (r111 == false) goto L12;
        r105 = mfc.a.a(r110).f513691a.e("red_badge_last_time_paras");     // Catch: Throwable -> L31
        r106 = mfc.a.a(r110).f513691a.e("red_badge_last_last_time_paras");     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r105) == true) goto L8;
        JSONObject r112 = new JSONObject(r105);     // Catch: Throwable -> L31
        r103 = r112.optLong(EventVerify.TYPE_LAUNCH);     // Catch: Throwable -> L31
        r104 = r112.optLong(IAllianceService.CONTENT_TYPE_BADGE);     // Catch: Throwable -> L31
    L8:
        String r113 = mfc.a.a(this.f503317c).f513691a.e("desktop_red_badge_args");     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r113) == true) goto L12;
        r107 = new JSONObject(r113).optString(BdpAppEventConstant.PARAMS_STRATEGY_NAME);     // Catch: Throwable -> L31
    L12:
        if (DateUtils.isToday(r103) == true) goto L15;
        if (r102 <= 0) goto L15;
        r102 = 0;
    L15:
        int r114 = mfc.a.a(r110).f513691a.d("red_badge_show_times", 0);     // Catch: Throwable -> L31
        if (DateUtils.isToday(r104) == true) goto L19;
        if (r114 <= 0) goto L19;
    L20:
        r100.put("launch_times", r102);     // Catch: Throwable -> L31
        r100.put("badge_show_times", r101);     // Catch: Throwable -> L31
        r100.put("last_time_paras", h(r105));     // Catch: Throwable -> L31
        r100.put("last_last_time_paras", h(r106));     // Catch: Throwable -> L31
        r100.put("desktop_red_badge_strategy", r107);     // Catch: Throwable -> L31
        r100.put("client_current_time", ToolUtils.currentTimeMillis() / 1000);     // Catch: Throwable -> L31
        r100.put("device_id", com.ss.android.pushmanager.setting.a.b().a());     // Catch: Throwable -> L31
        yfc.b r115 = this.f503316b;     // Catch: Throwable -> L31
        if (r115 == null) goto L32;
        r100.put("app_id", r115.getAid());     // Catch: Throwable -> L31
    L32:
        r100.put("rom", ToolUtils.getRomInfo());     // Catch: Throwable -> L25
        r100.put("brand", Build.BRAND);     // Catch: Throwable -> L25
        r100.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);     // Catch: Throwable -> L25
        r100.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L25
    L27:
        yfc.b r116 = this.f503316b;     // Catch: Throwable -> L31
        if (r116 == null) goto L30;
        r100.put("ver", r116.getVersionCode());     // Catch: Throwable -> L31
        goto L30
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L31
    L19:
        r101 = r114;
    L30:
        return r100;
    }

    public final void g(String r110, Bundle r111) {
        if (StringUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        JSONObject r100 = new JSONObject();
        r100.optString("");
        r100.put("_event_v3", 1);     // Catch: Throwable -> L11
        r100.put("has_app_foreground", f503314u);     // Catch: Throwable -> L11
        Iterator<String> r101 = r111.keySet().iterator();     // Catch: Throwable -> L11
    L8:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();     // Catch: Throwable -> L11
        r100.put(r102, r111.get(r102));     // Catch: Throwable -> L11
    L13:
        PushLog.onEvent(this.f503317c, "event_v3", r110, null, 0, 0, r100);
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }
}
