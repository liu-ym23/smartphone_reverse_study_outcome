package com.bytedance.unitm.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.bytedance.unitm.api.IThermalStatusDetailListener;
import com.bytedance.unitm.api.IThermalStatusListener;
import com.bytedance.unitm.api.IThermalStatusManager;
import com.bytedance.unitm.api.IThermalSurgeListener;
import com.bytedance.unitm.api.ThermalStatus;
import com.bytedance.unitm.api.ThermalStatusConfig;
import com.bytedance.unitm.util.TLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class ThermalStatusManager implements IThermalStatusManager {
    private static final long FIRST_NOTIFY_DELAY_TIME = 60000;
    private AospThermalStatusListener aospThermalStatusListener;
    private CommonThermalStatusListener commonThermalStatusListener;
    private ThermalStatusConfig config;
    private Context context;
    private long lastNotifyTime;
    private BaseThermalStatusGenerator mAosp;
    private BaseThermalStatusGenerator mCommon;
    private Handler mHandler;
    private Object mLock;
    private BaseThermalStatusGenerator mOem;
    private OemThermalStatusListener oemThermalStatusListener;
    private ThermalStatus thermalStatus;
    private List<IThermalStatusDetailListener> thermalStatusDetailListeners;
    private List<IThermalStatusListener> thermalStatusListeners;
    private Map<IThermalSurgeListener, SurgeConfig> thermalSurgeListenerMap;

    public class AospThermalStatusListener extends BaseThermalStatusListener {
        final /* synthetic */ ThermalStatusManager this$0;

        public AospThermalStatusListener(ThermalStatusManager r100) {
            this.this$0 = r100;
            super(r100, 1);
        }

        @Override // com.bytedance.unitm.core.ThermalStatusManager.BaseThermalStatusListener, com.bytedance.unitm.core.BaseThermalStatusGenerator.IListener
        public void onStatusGenerate(int r100, float r101) {
            if (ThermalStatusManager.access$000(this.this$0) == null) goto L6;
            ThermalStatusManager.access$000(this.this$0).aospStatus = r100;
            super.onStatusGenerate(r100, r101);
            return;
        }
    }

    public class BaseThermalStatusListener implements BaseThermalStatusGenerator.IListener {
        protected int statusSource;
        final /* synthetic */ ThermalStatusManager this$0;

        public BaseThermalStatusListener(ThermalStatusManager r100, int r101) {
            this.this$0 = r100;
            this.statusSource = r101;
        }

        @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator.IListener
        public void onStatusGenerate(int r100, float r101) {
            if (this.statusSource == ThermalStatusManager.access$400(this.this$0).statusSource) goto L5;
            return;
        L5:
            if (ThermalStatusManager.access$000(this.this$0) != null) goto L7;
            return;
        L7:
            if (ThermalStatusManager.access$000(this.this$0).status == r100) goto L9;
        L14:
            ThermalStatusManager.access$000(this.this$0).status = r100;
            ThermalStatusManager.access$900(this.this$0, 3000);
            return;
        L9:
            if (ThermalStatusManager.access$400(this.this$0).NO_STATUS_CHANGE_NOTIFY_DELTA_TIME >= 0) goto L11;
            return;
        L11:
            if ((System.currentTimeMillis() - ThermalStatusManager.access$300(this.this$0)) < ThermalStatusManager.access$400(this.this$0).NO_STATUS_CHANGE_NOTIFY_DELTA_TIME) goto L16;
            TLog.i("trigger no status changed notify");
            goto L14
        }
    }

    public class CommonThermalStatusListener extends BaseThermalStatusListener {
        final /* synthetic */ ThermalStatusManager this$0;

        public CommonThermalStatusListener(ThermalStatusManager r100) {
            this.this$0 = r100;
            super(r100, 0);
        }

        @Override // com.bytedance.unitm.core.ThermalStatusManager.BaseThermalStatusListener, com.bytedance.unitm.core.BaseThermalStatusGenerator.IListener
        public void onStatusGenerate(int r100, float r101) {
            if (ThermalStatusManager.access$000(this.this$0) == null) goto L9;
            ThermalStatusManager.access$000(this.this$0).batteryStatus = r100;
            ThermalStatusManager.access$000(this.this$0).batteryTemp = r101;
            if (ThermalStatusManager.access$500(this.this$0) == null) goto L7;
            ThermalStatus r102 = ThermalStatusManager.access$000(this.this$0);
            r102.borderTemp = ThermalStatusManager.access$500(this.this$0).getCurrentTemp();
        L7:
            super.onStatusGenerate(r100, r101);
            ThermalStatusManager.access$1000(this.this$0, r101, SystemClock.elapsedRealtime());
            return;
        }
    }

    public class OemThermalStatusListener extends BaseThermalStatusListener {
        final /* synthetic */ ThermalStatusManager this$0;

        public OemThermalStatusListener(ThermalStatusManager r100) {
            this.this$0 = r100;
            super(r100, 2);
        }

        @Override // com.bytedance.unitm.core.ThermalStatusManager.BaseThermalStatusListener, com.bytedance.unitm.core.BaseThermalStatusGenerator.IListener
        public void onStatusGenerate(int r100, float r101) {
            if (ThermalStatusManager.access$000(this.this$0) == null) goto L6;
            ThermalStatusManager.access$000(this.this$0).oemStatus = r100;
            ThermalStatusManager.access$000(this.this$0).borderTemp = r101;
            ThermalStatusManager.access$900(this.this$0, 3000);
            return;
        }
    }

    public class SurgeConfig {
        float baseTemp;
        long baseTime;
        boolean needNotify;
        float nowTemp;
        long nowTime;
        float targetDeltaTemp;
        long targetDuration;
        float targetSpeed;
        final /* synthetic */ ThermalStatusManager this$0;

        public String toString() {
            return "SurgeConfig{baseTemp=" + this.baseTemp + ", baseTime=" + this.baseTime + ", targetDeltaTemp=" + this.targetDeltaTemp + ", targetDuration=" + this.targetDuration + ", targetSpeed=" + this.targetSpeed + ", needNotify=" + this.needNotify + ", nowTemp=" + this.nowTemp + ", nowTime=" + this.nowTime + '}';
        }

        public SurgeConfig(ThermalStatusManager r100, float r101, long r102) {
            this.this$0 = r100;
            this.baseTemp = r100.getCurrentBatteryTemp();
            this.baseTime = SystemClock.elapsedRealtime();
            this.targetDeltaTemp = r101;
            this.targetDuration = r102;
            this.targetSpeed = r101 / r102;
            this.needNotify = false;
        }
    }

    public class ThermalHandler extends Handler {
        public static final int DELAY_CHECK_OEM = 30000;
        public static final int DELAY_NOTIFY = 3000;
        public static final int DELAY_NOTIFY_SURGE = 5000;
        public static final int EVENT_CHECK_OEM_SUCCESS = 2;
        public static final int EVENT_NOTIFY = 1;
        public static final int EVENT_NOTIFY_SURGE = 3;
        final /* synthetic */ ThermalStatusManager this$0;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            ThermalStatusManager r102 = this.this$0;
            ThermalStatusManager.access$100(r102, ThermalStatusManager.access$000(r102));
            ThermalStatusManager r103 = this.this$0;
            ThermalStatusManager.access$200(r103, ThermalStatusManager.access$000(r103));
            ThermalStatusManager.access$302(this.this$0, System.currentTimeMillis());
            return;
        L5:
            if (r101 == 2) goto L11;
            if (r101 != 3) goto L31;
            ThermalStatusManager.access$800(this.this$0);
            return;
        L31:
            return;
        L11:
            if (ThermalStatusManager.access$400(this.this$0).enableStatusSourceOem == true) goto L13;
            return;
        L13:
            if (ThermalStatusManager.access$500(this.this$0) != null) goto L15;
            return;
        L15:
            if (ThermalStatusManager.access$500(this.this$0).isEnable() == false) goto L17;
            ThermalStatus r104 = ThermalStatusManager.access$000(this.this$0);
            r104.borderTemp = ThermalStatusManager.access$500(this.this$0).getCurrentTemp();
            ThermalStatus r105 = ThermalStatusManager.access$000(this.this$0);
            r105.oemStatus = ThermalStatusManager.access$500(this.this$0).getCurrentThermalStatus();
            return;
        L17:
            int r106 = 0;
            ThermalStatusManager.access$400(this.this$0).enableStatusSourceOem = false;
            if (ThermalStatusManager.access$400(this.this$0).statusSource != 2) goto L23;
            ThermalStatusConfig r107 = ThermalStatusManager.access$400(this.this$0);
            if (ThermalStatusManager.access$600(this.this$0) != null) goto L22;
            r106 = -1;
        L22:
            r107.statusSource = r106;
        L23:
            ThermalStatusManager.access$700(this.this$0);
        }

        public ThermalHandler(ThermalStatusManager r100, Looper r101) {
            this.this$0 = r100;
            super(r101);
        }
    }

    private ThermalStatus getCurrentThermalStatusFromGenerator() {
        ThermalStatus r100 = new ThermalStatus();
        Object r101 = this.mLock;
        monitor-enter(r101);
        ThermalStatusConfig r102 = this.config;     // Catch: Throwable -> L29
        if (r102 != null) goto L7;
    L27:
        monitor-exit(r101);     // Catch: Throwable -> L29
        return r100;
    L7:
        if (r102.enableStatusSourceBattery == false) goto L14;
        BaseThermalStatusGenerator r103 = this.mCommon;     // Catch: Throwable -> L29
        if (r103 == null) goto L14;
        r100.batteryTemp = r103.getCurrentTemp();     // Catch: Throwable -> L29
        int r104 = this.mCommon.getCurrentThermalStatus();     // Catch: Throwable -> L29
        r100.batteryStatus = r104;     // Catch: Throwable -> L29
        if (this.config.statusSource != 0) goto L14;
        r100.status = r104;     // Catch: Throwable -> L29
    L14:
        if (this.config.enableStatusSourceAosp == false) goto L21;
        BaseThermalStatusGenerator r105 = this.mAosp;     // Catch: Throwable -> L29
        if (r105 == null) goto L21;
        int r106 = r105.getCurrentThermalStatus();     // Catch: Throwable -> L29
        r100.aospStatus = r106;     // Catch: Throwable -> L29
        if (this.config.statusSource != 1) goto L21;
        r100.status = r106;     // Catch: Throwable -> L29
    L21:
        if (this.config.enableStatusSourceOem == false) goto L27;
        BaseThermalStatusGenerator r107 = this.mOem;     // Catch: Throwable -> L29
        if (r107 == null) goto L27;
        r100.borderTemp = r107.getCurrentTemp();     // Catch: Throwable -> L29
        int r108 = this.mOem.getCurrentThermalStatus();     // Catch: Throwable -> L29
        r100.oemStatus = r108;     // Catch: Throwable -> L29
        if (this.config.statusSource != 2) goto L27;
        r100.status = r108;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    private void notifyThermalSurge() {
        Map<IThermalSurgeListener, SurgeConfig> r100 = this.thermalSurgeListenerMap;
        monitor-enter(r100);
        Iterator<Map.Entry<IThermalSurgeListener, SurgeConfig>> r101 = this.thermalSurgeListenerMap.entrySet().iterator();     // Catch: Throwable -> L16
    L6:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<IThermalSurgeListener, SurgeConfig> r102 = r101.next();     // Catch: Throwable -> L16
        SurgeConfig r103 = r102.getValue();     // Catch: Throwable -> L16
        if (r103 == null) goto L6;
        if (r103.needNotify == false) goto L6;
        IThermalSurgeListener r104 = r102.getKey();     // Catch: Throwable -> L16
        if (r104 == null) goto L6;
        r104.onThermalSurge(r103.baseTemp, r103.nowTemp, r103.nowTime - r103.baseTime);     // Catch: Throwable -> L16
        r103.baseTemp = r103.nowTemp;     // Catch: Throwable -> L16
        r103.baseTime = r103.nowTime;     // Catch: Throwable -> L16
        r103.needNotify = false;     // Catch: Throwable -> L16
        TLog.i("notify thermal surge");     // Catch: Throwable -> L16
        goto L6
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void triggerNotifySurge() {
        if (this.mHandler.hasMessages(3) == false) goto L5;
        this.mHandler.removeMessages(3);
    L5:
        this.mHandler.sendEmptyMessageDelayed(3, 5000);
    }

    private void updateAOSPThermalStatusGenerator() {
        if (this.config.enableStatusSourceAosp == true) goto L5;
        BaseThermalStatusGenerator r100 = this.mAosp;
        if (r100 == null) goto L31;
        r100.reset();
        this.mAosp = null;
        this.aospThermalStatusListener = null;
        return;
    L31:
        return;
    L5:
        if (this.mAosp != null) goto L28;
        BaseThermalStatusGenerator r101 = ThermalStatusGeneratorFactory.create(1, this.context);
        this.mAosp = r101;
        int r102 = 0;
        if (r101 != null) goto L9;
        boolean r103 = false;
    L13:
        if (r103 == true) goto L29;
        ThermalStatusConfig r104 = this.config;
        r104.enableStatusSourceAosp = false;
        if (r104.statusSource == 1) goto L17;
    L20:
        BaseThermalStatusGenerator r105 = this.mAosp;
        if (r105 == null) goto L23;
        r105.reset();
        this.mAosp = null;
        this.aospThermalStatusListener = null;
    L23:
        TLog.i("enable aosp thermal generator fail");
        return;
    L17:
        if (this.mCommon != null) goto L19;
        r102 = -1;
    L19:
        r104.statusSource = r102;
        goto L20
    L29:
        return;
    L9:
        if (this.aospThermalStatusListener != null) goto L11;
        this.aospThermalStatusListener = new AospThermalStatusListener(this);
    L11:
        r103 = this.mAosp.setListener(this.aospThermalStatusListener);
        goto L13
    }

    private void updateCommonThermalStatusGenerator() {
        if (this.config.enableStatusSourceBattery == true) goto L5;
        BaseThermalStatusGenerator r100 = this.mCommon;
        if (r100 == null) goto L28;
        r100.reset();
        this.mCommon = null;
        this.commonThermalStatusListener = null;
        return;
    L28:
        return;
    L5:
        if (this.mCommon != null) goto L25;
        BaseThermalStatusGenerator r101 = ThermalStatusGeneratorFactory.create(0, this.context);
        this.mCommon = r101;
        if (r101 != null) goto L9;
        boolean r102 = false;
    L13:
        if (r102 == true) goto L26;
        ThermalStatusConfig r103 = this.config;
        r103.enableStatusSourceBattery = false;
        if (r103.statusSource != 0) goto L17;
        r103.statusSource = -1;
    L17:
        BaseThermalStatusGenerator r104 = this.mCommon;
        if (r104 == null) goto L20;
        r104.reset();
        this.mCommon = null;
        this.commonThermalStatusListener = null;
    L20:
        TLog.i("enable common thermal generator fail");
        return;
    L26:
        return;
    L9:
        if (this.commonThermalStatusListener != null) goto L11;
        this.commonThermalStatusListener = new CommonThermalStatusListener(this);
    L11:
        r102 = this.mCommon.setListener(this.commonThermalStatusListener);
        goto L13
    }

    private void updateOemThermalStatusGenerator() {
        if (this.config.enableStatusSourceOem == true) goto L5;
        BaseThermalStatusGenerator r100 = this.mOem;
        if (r100 == null) goto L31;
        r100.reset();
        this.mOem = null;
        this.oemThermalStatusListener = null;
        return;
    L31:
        return;
    L5:
        if (this.mOem != null) goto L28;
        BaseThermalStatusGenerator r101 = ThermalStatusGeneratorFactory.create(2, this.context);
        this.mOem = r101;
        int r102 = 0;
        if (r101 != null) goto L9;
        boolean r103 = false;
    L13:
        if (r103 == true) goto L29;
        ThermalStatusConfig r104 = this.config;
        r104.enableStatusSourceOem = false;
        if (r104.statusSource == 2) goto L17;
    L20:
        BaseThermalStatusGenerator r105 = this.mOem;
        if (r105 == null) goto L23;
        r105.reset();
        this.mOem = null;
        this.oemThermalStatusListener = null;
    L23:
        TLog.i("enable oem thermal generator fail");
        return;
    L17:
        if (this.mCommon != null) goto L19;
        r102 = -1;
    L19:
        r104.statusSource = r102;
        goto L20
    L29:
        return;
    L9:
        if (this.oemThermalStatusListener != null) goto L11;
        this.oemThermalStatusListener = new OemThermalStatusListener(this);
    L11:
        r103 = this.mOem.setListener(this.oemThermalStatusListener);
        triggerCheckOem(30000);
        goto L13
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public float getCurrentBatteryTemp() {
        return this.thermalStatus.batteryTemp;
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public int getCurrentThermalStatus() {
        return this.thermalStatus.status;
    }

    private void updateThermalStatusGenerator() {
        updateCommonThermalStatusGenerator();
        updateAOSPThermalStatusGenerator();
        updateOemThermalStatusGenerator();
        TLog.i("after update config:" + this.config + ", battery:" + this.mCommon + ", aosp:" + this.mAosp + ", oem:" + this.mOem);
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public ThermalStatusConfig getCurrentConfig() {
        return this.config;
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public ThermalStatus getCurrentThermalStatusDetail() {
        return this.thermalStatus;
    }

    public ThermalStatusManager(Context r100) {
        this.mLock = new Object();
        this.lastNotifyTime = -1;
        this.thermalStatusListeners = new ArrayList();
        this.thermalStatusDetailListeners = new ArrayList();
        this.thermalSurgeListenerMap = new HashMap();
        this.context = r100;
        this.config = ThermalStatusConfig.DEFAULT;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("thermal_status");
        ThreadMethodProxy.start(r101);
        this.mHandler = new ThermalHandler(this, r101.getLooper());
        ThermalStatusGeneratorFactory.setLooper(r101.getLooper());
        updateThermalStatusGenerator();
        this.thermalStatus = getCurrentThermalStatusFromGenerator();
        triggerNotify(60000);
    }

    public static /* synthetic */ ThermalStatus access$000(ThermalStatusManager r100) {
        return r100.thermalStatus;
    }

    public static /* synthetic */ long access$300(ThermalStatusManager r100) {
        return r100.lastNotifyTime;
    }

    public static /* synthetic */ ThermalStatusConfig access$400(ThermalStatusManager r100) {
        return r100.config;
    }

    public static /* synthetic */ BaseThermalStatusGenerator access$500(ThermalStatusManager r100) {
        return r100.mOem;
    }

    public static /* synthetic */ BaseThermalStatusGenerator access$600(ThermalStatusManager r100) {
        return r100.mCommon;
    }

    public static /* synthetic */ void access$700(ThermalStatusManager r100) {
        r100.updateOemThermalStatusGenerator();
    }

    public static /* synthetic */ void access$800(ThermalStatusManager r100) {
        r100.notifyThermalSurge();
    }

    private void notifyThermalStatusChanged(ThermalStatus r100) {
        List<IThermalStatusDetailListener> r101 = this.thermalStatusDetailListeners;
        monitor-enter(r101);
        Iterator<IThermalStatusListener> r102 = this.thermalStatusListeners.iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().onThermalStatusChanged(r100.status);     // Catch: Throwable -> L11
        goto L6
    L8:
        TLog.i("notify thermal status changed : " + r100.status);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void notifyThermalStatusDetailedChanged(ThermalStatus r100) {
        List<IThermalStatusDetailListener> r101 = this.thermalStatusDetailListeners;
        monitor-enter(r101);
        Iterator<IThermalStatusDetailListener> r102 = this.thermalStatusDetailListeners.iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().onThermalStatusChanged(r100);     // Catch: Throwable -> L11
        goto L6
    L8:
        TLog.i("notify thermal status detailed changed : " + r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void triggerCheckOem(long r100) {
        if (this.mHandler.hasMessages(2) == false) goto L5;
        this.mHandler.removeMessages(2);
    L5:
        this.mHandler.sendEmptyMessageDelayed(2, r100);
    }

    private void triggerNotify(long r100) {
        if (this.mHandler.hasMessages(1) == false) goto L5;
        this.mHandler.removeMessages(1);
    L5:
        this.mHandler.sendEmptyMessageDelayed(1, r100);
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public void addThermalStatusDetailListener(IThermalStatusDetailListener r100) {
        List<IThermalStatusDetailListener> r101 = this.thermalStatusDetailListeners;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.thermalStatusDetailListeners.contains(r100) == true) goto L7;
        this.thermalStatusDetailListeners.add(r100);     // Catch: Throwable -> L9
        TLog.i("add thermal detail status listener : " + r100.getDescription());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public void addThermalStatusListener(IThermalStatusListener r100) {
        List<IThermalStatusListener> r101 = this.thermalStatusListeners;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.thermalStatusListeners.contains(r100) == true) goto L7;
        this.thermalStatusListeners.add(r100);     // Catch: Throwable -> L9
        TLog.i("add thermal status listener : " + r100.getDescription());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public void removeThermalStatusDetailListener(IThermalStatusDetailListener r100) {
        List<IThermalStatusDetailListener> r101 = this.thermalStatusDetailListeners;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.thermalStatusDetailListeners.contains(r100) == false) goto L7;
        this.thermalStatusDetailListeners.remove(r100);     // Catch: Throwable -> L9
        TLog.i("remove thermal detail status listener : " + r100.getDescription());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public void removeThermalStatusListener(IThermalStatusListener r100) {
        List<IThermalStatusDetailListener> r101 = this.thermalStatusDetailListeners;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.thermalStatusListeners.contains(r100) == false) goto L7;
        this.thermalStatusListeners.remove(r100);     // Catch: Throwable -> L9
        TLog.i("remove thermal status listener : " + r100.getDescription());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public void removeThermalSurgeListener(IThermalSurgeListener r100) {
        Map<IThermalSurgeListener, SurgeConfig> r101 = this.thermalSurgeListenerMap;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.thermalSurgeListenerMap.get(r100) == null) goto L7;
        this.thermalSurgeListenerMap.remove(r100);     // Catch: Throwable -> L9
        TLog.i("remove thermal surge listener");     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public void setBatteryThermalThresholdList(List<Pair<Float, Float>> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() != 7) goto L10;
        BaseThermalStatusGenerator r101 = this.mCommon;
        if (r101 == null) goto L11;
        r101.setThermalThresholdList(r100);
        TLog.i("set thermal threshold list" + r100);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public void setDebugTemp(float r100) {
        BaseThermalStatusGenerator r101 = this.mCommon;
        if (r101 == null) goto L6;
        r101.setDebugTemp(r100);
        return;
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public void updateConfig(ThermalStatusConfig r100) {
        if (r100 == null) goto L12;
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.config = r100;     // Catch: Throwable -> L9
        TLog.i("update config:" + r100);     // Catch: Throwable -> L9
        updateThermalStatusGenerator();     // Catch: Throwable -> L9
        this.thermalStatus = getCurrentThermalStatusFromGenerator();     // Catch: Throwable -> L9
        triggerNotify(60000);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$100(ThermalStatusManager r100, ThermalStatus r101) {
        r100.notifyThermalStatusChanged(r101);
    }

    public static /* synthetic */ void access$200(ThermalStatusManager r100, ThermalStatus r101) {
        r100.notifyThermalStatusDetailedChanged(r101);
    }

    public static /* synthetic */ long access$302(ThermalStatusManager r100, long r101) {
        r100.lastNotifyTime = r101;
        return r101;
    }

    public static /* synthetic */ void access$900(ThermalStatusManager r100, long r101) {
        r100.triggerNotify(r101);
    }

    private void checkThermalSurge(float r110, long r210) {
        Map<IThermalSurgeListener, SurgeConfig> r100 = this.thermalSurgeListenerMap;
        monitor-enter(r100);
        Iterator<Map.Entry<IThermalSurgeListener, SurgeConfig>> r101 = this.thermalSurgeListenerMap.entrySet().iterator();     // Catch: Throwable -> L29
        boolean r102 = false;
    L6:
        if (r101.hasNext() == false) goto L25;
        SurgeConfig r103 = r101.next().getValue();     // Catch: Throwable -> L29
        if (r103 == null) goto L6;
        if (r103.needNotify == true) goto L6;
        float r104 = r110 - r103.baseTemp;     // Catch: Throwable -> L29
        long r105 = r210 - r103.baseTime;     // Catch: Throwable -> L29
        float r111 = r104 / r105;     // Catch: Throwable -> L29
        if (r104 < r103.targetDeltaTemp) goto L19;
        if (r105 <= r103.targetDuration) goto L17;
        if (r111 <= r103.targetSpeed) goto L19;
    L17:
        TLog.i("deltaSpeed ok, need notify surge, deltaTemp:" + r104 + ", deltaDuration:" + r105 + ", deltaSpeed:" + r111 + ",targetSpeed:" + r103.targetSpeed);     // Catch: Throwable -> L29
        r102 = true;
        r103.needNotify = true;     // Catch: Throwable -> L29
        r103.nowTemp = r110;     // Catch: Throwable -> L29
        r103.nowTime = r210;     // Catch: Throwable -> L29
    L19:
        if (r104 < 0.0f) goto L24;
        if (r111 < (((double) r103.targetSpeed) * 0.5d)) goto L24;
        TLog.i("deltaSpeed ok, need continue watch, deltaTemp:" + r104 + ", deltaDuration:" + r105 + ",deltaSpeed:" + r111 + ",targetSpeed:" + r103.targetSpeed);     // Catch: Throwable -> L29
    L24:
        TLog.i("deltaSpeed not ok, need rebase surge config, deltaTemp:" + r104 + ", deltaDuration:" + r105 + ", deltaSpeed:" + r111 + ",targetSpeed:" + r103.targetSpeed);     // Catch: Throwable -> L29
        r103.baseTime = r210;     // Catch: Throwable -> L29
        r103.baseTemp = r110;     // Catch: Throwable -> L29
        goto L6
    L25:
        monitor-exit(r100);     // Catch: Throwable -> L29
        if (r102 == false) goto L50;
        triggerNotifySurge();
        return;
    L50:
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$1000(ThermalStatusManager r100, float r101, long r102) {
        r100.checkThermalSurge(r101, r102);
    }

    @Override // com.bytedance.unitm.api.IThermalStatusManager
    public void addThermalSurgeListener(IThermalSurgeListener r100, float r101, long r102) {
        if (r102 > 0) goto L6;
        TLog.w("add thermal surge listener error, targetDeltaTemp:" + r101 + ",targetDuration:" + r102);
        return;
    L6:
        Map<IThermalSurgeListener, SurgeConfig> r103 = this.thermalSurgeListenerMap;
        monitor-enter(r103);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.thermalSurgeListenerMap.get(r100) != null) goto L11;
        this.thermalSurgeListenerMap.put(r100, new SurgeConfig(this, r101, r102));     // Catch: Throwable -> L13
        TLog.i("add thermal surge listener, targetDeltaTemp:" + r101 + ",targetDuration:" + r102);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r103);     // Catch: Throwable -> L13
    }
}
