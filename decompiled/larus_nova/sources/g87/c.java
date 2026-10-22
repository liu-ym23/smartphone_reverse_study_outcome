package g87;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.push.log.ILogger;
import com.bytedance.push.settings.StatisticsSettings;
import com.ss.android.message.util.ToolUtils;
import j77.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Observer, Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f480420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f480421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ILogger f480422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f480423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f480424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f480425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f480426g;

    public final void b() {
        a r100 = new a();
        r100.f480410a = SystemClock.elapsedRealtime();
        r100.f480411b = ToolUtils.currentTimeMillis();
        r100.f480414e = ActivityLifecycleObserver.getIns().isBackGround();
        ((d) this.f480421b).getClass();
        long r101 = 60000;
        long r102 = 300000;
        if (this.f480424e == true) goto L7;
        if ((SystemClock.elapsedRealtime() - this.f480426g) > 60000) goto L7;
    L24:
        r100.f480416g = r102;
        if (TextUtils.isEmpty(((d) this.f480421b).b()) == true) goto L31;
        ((d) this.f480421b).getClass();
        r100.f480417h = com.ss.android.pushmanager.setting.a.b().d();
        d r103 = (d) this.f480421b;
        r103.getClass();
        boolean r104 = ((PowerManager) r103.f480427a.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).isInteractive();     // Catch: Exception -> L29
    L30:
        r100.f480418i = r104;
        r100.f480419j = ((d) this.f480421b).c();
    L29:
        r104 = true;
    L31:
        this.f480425f = r100;
        this.f480422c.d("push_proc_stat", "pollSample: start_ts = " + r100 + ", mIsBg = " + r100.f480414e + ", delay = " + r102);
        this.f480420a.removeMessages(10087);
        this.f480420a.sendEmptyMessageDelayed(10087, r102);
        return;
    L7:
        if (r100.f480414e == false) goto L15;
        d r105 = (d) this.f480421b;
        if (ToolUtils.isMainProcess(r105.f480427a) == false) goto L11;
        long r106 = ((StatisticsSettings) i.a(r105.f480427a, StatisticsSettings.class)).b();
    L13:
        if (r106 < 60000) goto L23;
    L22:
        r101 = r106;
    L23:
        r102 = r101;
        goto L24
    L11:
        r106 = r105.f480427a.getSharedPreferences("push_multi_process_config", 4).getLong("stats_back_interval", 300000);
        goto L13
    L15:
        d r107 = (d) this.f480421b;
        if (ToolUtils.isMainProcess(r107.f480427a) == false) goto L18;
        r106 = ((StatisticsSettings) i.a(r107.f480427a, StatisticsSettings.class)).a();
    L20:
        if (r106 >= 60000) goto L22;
    L18:
        r106 = r107.f480427a.getSharedPreferences("push_multi_process_config", 4).getLong("stats_fore_interval", 300000);
        goto L20
    }

    public final void a(boolean r100) {
        this.f480425f.f480412c = ToolUtils.currentTimeMillis();
        this.f480425f.f480413d = SystemClock.elapsedRealtime();
        a r101 = this.f480425f;
        this.f480422c.d("push_proc_stat", "save: aliveTs = " + r101 + ", duration = " + (r101.f480413d - r101.f480410a));
        b r102 = this.f480421b;
        if (r100 == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        d r104 = (d) r102;
        r104.getClass();
        ThreadPlus.submitRunnable(new f(r104, r101, r103));
        return;
    L5:
        if (this.f480424e == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r110) {
        if (r110 != null) goto L6;
        return false;
    L6:
        switch(r110.what) {
            case 10085: goto L12;
            case 10086: goto L11;
            case 10087: goto L10;
            case 10088: goto L9;
            case 10089: goto L8;
            default: goto L16;
        };
    L8:
        this.f480422c.d("push_proc_stat", "UPLOAD_LAST");
        this.f480424e = true;
        d r111 = (d) this.f480421b;
        r111.getClass();
        ThreadPlus.submitRunnable(new e(r111));
        goto L16
    L9:
        this.f480422c.d("push_proc_stat", "ZONE_TIME");
        a(true);
        b();
        goto L16
    L10:
        this.f480422c.d("push_proc_stat", "POLL");
        a(false);
        b();
        goto L16
    L11:
        this.f480422c.d("push_proc_stat", "APP_STATS_CHANGED");
        a(false);
        b();
        goto L16
    L12:
        this.f480422c.d("push_proc_stat", WidgetCostModule.TYPE_ON_START);
        this.f480426g = SystemClock.elapsedRealtime();
        ActivityLifecycleObserver.getIns().addObserver(this);
        long r100 = ToolUtils.currentTimeMillis();
        Calendar r112 = Calendar.getInstance();
        r112.set(11, 0);
        r112.set(12, 0);
        r112.set(13, 0);
        r112.add(5, 1);
        long r101 = r112.getTimeInMillis();
        if (this.f480422c.debug() == false) goto L15;
        SimpleDateFormat r113 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date r102 = new Date(r101);
        this.f480422c.d("push_proc_stat", "next zone time = " + r113.format(r102));
    L15:
        TimeUnit r114 = TimeUnit.MINUTES;
        this.f480420a.sendEmptyMessageDelayed(10088, ((r101 - r100) - r114.toMillis(15)) + ((long) new Random().nextInt((int) r114.toMillis(5))));
        b();
    L16:
        return false;
    }

    public c(d r100, ILogger r101) {
        this.f480421b = r100;
        this.f480422c = r101;
        this.f480420a = new Handler(Looper.getMainLooper(), this);
    }

    @Override // java.util.Observer
    public void update(Observable r100, Object r101) {
        if ((r101 instanceof Boolean) == false) goto L6;
        this.f480420a.sendEmptyMessage(10086);
        return;
    }
}
