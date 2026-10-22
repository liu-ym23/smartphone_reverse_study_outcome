package com.ss.android.lark.batterymonitor.stragety;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.batterymonitor.api.ConditionState;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import wwa.c;
import wwa.d;
import xwa.a;
import xwa.b;

/* JADX INFO: loaded from: classes34.dex */
public abstract class AbsBatteryStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Integer> f409787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f409788b;

    public @interface AppBg5mCombination {
        public static final String APP_BG_5M__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_OFF = "2011";
        public static final String APP_BG_5M__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_OFF_3M = "2012";
        public static final String APP_BG_5M__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_ON = "2010";
        public static final String APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF = "2001";
        public static final String APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M = "2002";
        public static final String APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_ON = "2000";
        public static final String APP_BG_5M__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_OFF = "2111";
        public static final String APP_BG_5M__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_OFF_3M = "2112";
        public static final String APP_BG_5M__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_ON = "2110";
        public static final String APP_BG_5M__CHARGE_OUT__NETWORK_WIFI__SCREEN_OFF = "2101";
        public static final String APP_BG_5M__CHARGE_OUT__NETWORK_WIFI__SCREEN_OFF_3M = "2102";
        public static final String APP_BG_5M__CHARGE_OUT__NETWORK_WIFI__SCREEN_ON = "2100";
    }

    public @interface AppBgCombination {
        public static final String APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_OFF = "1011";
        public static final String APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_OFF_3M = "1012";
        public static final String APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_ON = "1010";
        public static final String APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF = "1001";
        public static final String APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M = "1002";
        public static final String APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_ON = "1000";
        public static final String APP_BG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_OFF = "1111";
        public static final String APP_BG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_OFF_3M = "1112";
        public static final String APP_BG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_ON = "1110";
        public static final String APP_BG__CHARGE_OUT__NETWORK_WIFI__SCREEN_OFF = "1101";
        public static final String APP_BG__CHARGE_OUT__NETWORK_WIFI__SCREEN_OFF_3M = "1102";
        public static final String APP_BG__CHARGE_OUT__NETWORK_WIFI__SCREEN_ON = "1100";
    }

    public @interface AppFgCombination {
        public static final String APP_FG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_ON = "0010";
        public static final String APP_FG__CHARGE_IN__NETWORK_WIFI__SCREEN_ON = "0000";
        public static final String APP_FG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_ON = "0110";
        public static final String APP_FG__CHARGE_OUT__NETWORK_WIFI__SCREEN_ON = "0100";
    }

    public @interface Strategy {
        public static final int BACKGROUND_MODE = 1;
        public static final int FOREGROUND_MODE = 0;
        public static final int NETLESS_MODE = 2;
    }

    public abstract boolean b();

    public AbsBatteryStrategy() {
        this.f409788b = 0;
    }

    public final void a(ConditionState r100) {
        Log.i("BatteryMonitor", AbsBatteryStrategy.class.getSimpleName() + " battery strategy, getStrategy called, ConditionState:" + r100.toString());
        if (CollectionUtils.isEmpty(this.f409787a) == true) goto L5;
    L8:
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.f409777a);
        r101.append(r100.f409779c);
        r101.append(r100.f409780d);
        r101.append(r100.f409778b);
        Integer r102 = (Integer) ((HashMap) this.f409787a).get(r101.toString());
        if (r102 != null) goto L11;
        Log.i("BatteryMonitor", AbsBatteryStrategy.class.getSimpleName().concat(" battery strategy, getStrategy called, no match, so init default strategy:0"));
        int r103 = 0;
    L12:
        Log.i("BatteryMonitor", "new  battery strategy is " + r103);
        int r104 = this.f409788b;
        if (r103 != r104) goto L17;
        Log.i("BatteryMonitor", "battery strategy equals lastStrategy, so do noting.");
        return;
    L17:
        if (r103 != 2) goto L29;
        List<b.a> r105 = wwa.b.f561740i;
        d r106 = wwa.b.c.f561750a.f561741b;
        if (r106 == null) goto L27;
        Iterator r107 = ((ArrayList) r106.f561753b).iterator();
    L22:
        if (r107.hasNext() == false) goto L27;
        a r108 = (a) r107.next();
        if (r108 == null) goto L22;
        r108.a();
    L27:
        if (wwa.b.f561740i == null) goto L41;
        CoreThreadPool.getSerialTaskHandler().post(new c(Boolean.TRUE));
    L41:
        this.f409788b = r103;
        return;
    L29:
        if (r104 != 2) goto L41;
        List<b.a> r109 = wwa.b.f561740i;
        d r110 = wwa.b.c.f561750a.f561741b;
        if (r110 == null) goto L39;
        Iterator r111 = ((ArrayList) r110.f561753b).iterator();
    L34:
        if (r111.hasNext() == false) goto L39;
        a r112 = (a) r111.next();
        if (r112 == null) goto L34;
        r112.b();
    L39:
        if (wwa.b.f561740i == null) goto L41;
        CoreThreadPool.getSerialTaskHandler().post(new c(Boolean.FALSE));
        goto L41
    L11:
        r103 = r102.intValue();
        goto L12
    L5:
        if (CollectionUtils.isEmpty(this.f409787a) == true) goto L7;
        Log.i("BatteryMonitor", "MainProcessBatteryStrategy newStrategyMap called. strategyMap isn't null.");
        goto L8
    L7:
        final int r113 = 30;
        this.f409787a = new AnonymousClass1(this, r113);
        goto L8
    }
}
