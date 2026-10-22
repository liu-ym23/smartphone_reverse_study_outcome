package com.bytedance.unitm.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.unitm.core.BaseThermalStatusGenerator;
import com.bytedance.unitm.util.TLog;
import com.douyin.janna.api.CapabilityType;
import es7.a;
import fs7.b;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class OemThermalStatusAdapter extends BaseThermalStatusGenerator {
    private JannaAdapter mAdapter;

    public class JannaAdapter {
        private static final int Capability_GET_LIMITED = 2;
        private static final int Capability_GET_LIMITED_CHANGED = 4;
        private static final int Capability_GET_TEMP = 1;
        private int capability;
        private List<Integer> eventIdList;
        private a janna;
        private b listener;
        private MyHandler mHandler;
        private boolean mIsConnected;
        private boolean mIsConnecting;
        private boolean mIsRegisterNotifyAfterConnected;
        final /* synthetic */ OemThermalStatusAdapter this$0;

        public class EventListener implements b {
            final /* synthetic */ JannaAdapter this$1;

            public EventListener(JannaAdapter r100) {
                this.this$1 = r100;
            }

            @Override // fs7.b
            public void onEvent(fs7.a r100) {
                int r101 = r100.f478662a;
                if (r101 != 1) goto L22;
                OemThermalStatusAdapter r102 = this.this$1.this$0;
                float r103 = -99.0f;
                if (r101 != 1) goto L11;
                Bundle r104 = r100.f478663b;
                if (r104 == null) goto L11;
                r103 = r104.getFloat("thermal_temp", -99.0f);
            L11:
                OemThermalStatusAdapter.access$1902(r102, r103);
                OemThermalStatusAdapter r105 = this.this$1.this$0;
                int r106 = 0;
                if (r100.f478662a != 1) goto L17;
                Bundle r107 = r100.f478663b;
                if (r107 == null) goto L17;
                r106 = r107.getInt("thermal_status", 0);
            L17:
                OemThermalStatusAdapter.access$2002(r105, r106);
                if (OemThermalStatusAdapter.access$2100(this.this$1.this$0) == null) goto L21;
                OemThermalStatusAdapter.access$2400(this.this$1.this$0).onStatusGenerate(OemThermalStatusAdapter.access$2200(this.this$1.this$0), OemThermalStatusAdapter.access$2300(this.this$1.this$0));
                return;
            L21:
                return;
            }
        }

        public class MyHandler extends Handler {
            public static final int DELAY_ABILITY = 10000;
            public static final int DELAY_CHANGED = 60000;
            public static final int EVENT_CHECK_ABILITY = 1;
            public static final int EVENT_CHECK_CHANGED = 2;
            final /* synthetic */ JannaAdapter this$1;

            @Override // android.os.Handler
            public void handleMessage(Message r100) {
                int r101 = r100.what;
                boolean r102 = true;
                if (r101 != 1) goto L5;
                this.this$1.initCapability();
                JannaAdapter r103 = this.this$1;
                if (JannaAdapter.access$100(r103) != 0) goto L37;
                r102 = false;
            L37:
                JannaAdapter.access$002(r103, r102);
                JannaAdapter.access$202(this.this$1, false);
                if (JannaAdapter.access$300(this.this$1) == false) goto L42;
                this.this$1.registerListener(false);
                JannaAdapter.access$302(this.this$1, false);
                return;
            L42:
                return;
            L5:
                if (r101 != 2) goto L43;
                float r104 = OemThermalStatusAdapter.access$400(this.this$1.this$0);
                if ((JannaAdapter.access$100(this.this$1) & 1) <= 0) goto L11;
                JannaAdapter r105 = this.this$1;
                OemThermalStatusAdapter.access$502(r105.this$0, r105.getCurrentTemp());
            L11:
                if ((2 & JannaAdapter.access$100(this.this$1)) <= 0) goto L21;
                JannaAdapter r106 = this.this$1;
                OemThermalStatusAdapter r107 = r106.this$0;
                es7.b r108 = JannaAdapter.access$700(r106).f473775b;
                com.douyin.janna.platform.a r109 = r108.f473779b;
                if (r109 != null) goto L15;
            L18:
                int r110 = -1;
            L19:
                OemThermalStatusAdapter.access$602(r107, r110);
            L30:
                if (OemThermalStatusAdapter.access$1400(this.this$1.this$0) == null) goto L32;
                OemThermalStatusAdapter.access$1700(this.this$1.this$0).onStatusGenerate(OemThermalStatusAdapter.access$1500(this.this$1.this$0), OemThermalStatusAdapter.access$1600(this.this$1.this$0));
            L32:
                JannaAdapter.access$1800(this.this$1);
                return;
            L15:
                if (r109.d(CapabilityType.GET_THERMAL_STATUS_INFO) == false) goto L17;
                r110 = r108.f473779b.c();
                goto L19
            L17:
                boolean r111 = hq7.a.f486512a;
                goto L18
            L21:
                if (OemThermalStatusAdapter.access$800(this.this$1.this$0) == (-1.0f)) goto L30;
                if (OemThermalStatusAdapter.access$900(this.this$1.this$0) == (-99.0f)) goto L30;
                OemThermalStatusAdapter r112 = this.this$1.this$0;
                float r113 = OemThermalStatusAdapter.access$1100(r112);
                if (r104 < OemThermalStatusAdapter.access$1200(this.this$1.this$0)) goto L28;
                r102 = false;
            L28:
                OemThermalStatusAdapter.access$1002(r112, OemThermalStatusAdapter.access$1300(r112, r113, r102));
                goto L30
            }

            public MyHandler(JannaAdapter r100, Looper r101) {
                this.this$1 = r100;
                super(r101);
            }
        }

        public void removeListener() {
            this.mIsRegisterNotifyAfterConnected = false;
            removeListenerInner();
        }

        private void registerListenerInner() {
            if ((this.capability & 4) > 0) goto L5;
            return;
        L5:
            if (this.listener != null) goto L16;
            EventListener r100 = new EventListener(this);
            this.listener = r100;
            a r101 = this.janna;
            List<Integer> r102 = this.eventIdList;
            if (r101.f473774a == false) goto L13;
            com.douyin.janna.platform.a r103 = r101.f473775b.f473779b;
            if (r103 == null) goto L13;
            if (r102 == null) goto L13;
            r103.h(r100, r102);
        L13:
            TLog.i("registerListenerInner");
            return;
        }

        public float getCurrentTemp() {
            es7.b r100 = this.janna.f473775b;
            com.douyin.janna.platform.a r101 = r100.f473779b;
            if (r101 != null) goto L5;
        L8:
            return -99.0f;
        L5:
            if (r101.d(CapabilityType.GET_PHONE_TEMP) == true) goto L10;
            boolean r102 = hq7.a.f486512a;
            goto L8
        L10:
            return r100.f473779b.b();
        }

        public void initCapability() {
            if (this.janna.a(CapabilityType.GET_PHONE_TEMP) == false) goto L5;
            this.capability |= 1;
            OemThermalStatusAdapter.access$2502(this.this$0, getCurrentTemp());
        L5:
            a r100 = this.janna;
            CapabilityType r101 = CapabilityType.GET_THERMAL_STATUS_INFO;
            if (r100.a(r101) == false) goto L16;
            this.capability |= 2;
            OemThermalStatusAdapter r102 = this.this$0;
            es7.b r103 = this.janna.f473775b;
            com.douyin.janna.platform.a r104 = r103.f473779b;
            if (r104 != null) goto L10;
        L13:
            int r105 = -1;
        L14:
            OemThermalStatusAdapter.access$2602(r102, r105);
            goto L16
        L10:
            if (r104.d(r101) == false) goto L12;
            r105 = r103.f473779b.c();
            goto L14
        L12:
            boolean r106 = hq7.a.f486512a;
        L16:
            if (this.janna.a(CapabilityType.RECEIVE_THERMAL_STATUS_INFO) == false) goto L18;
            this.capability |= 4;
        L18:
            TLog.i("init oem capability " + this.capability);
        }

        private void removeListenerInner() {
            TLog.i("removeListenerInner");
            b r100 = this.listener;
            if (r100 == null) goto L14;
            a r101 = this.janna;
            List<Integer> r102 = this.eventIdList;
            if (r101.f473774a == false) goto L12;
            com.douyin.janna.platform.a r103 = r101.f473775b.f473779b;
            if (r103 == null) goto L12;
            if (r100 == null) goto L12;
            if (r102 == null) goto L12;
            r103.i(r100, r102);
        L12:
            this.listener = null;
            return;
        L14:
            this.mHandler.removeMessages(2);
        }

        private void triggerLoopCheck() {
            TLog.i("triggerLoopCheck");
            if (this.mHandler.hasMessages(2) == false) goto L5;
            this.mHandler.removeMessages(2);
        L5:
            this.mHandler.sendEmptyMessageDelayed(2, 60000);
        }

        public boolean isConnected() {
            return this.mIsConnected;
        }

        public boolean isConnecting() {
            return this.mIsConnecting;
        }

        public static /* synthetic */ int access$100(JannaAdapter r100) {
            return r100.capability;
        }

        public static /* synthetic */ void access$1800(JannaAdapter r100) {
            r100.triggerLoopCheck();
        }

        public static /* synthetic */ boolean access$300(JannaAdapter r100) {
            return r100.mIsRegisterNotifyAfterConnected;
        }

        public static /* synthetic */ a access$700(JannaAdapter r100) {
            return r100.janna;
        }

        public boolean registerListener(boolean r100) {
            if (this.mIsConnected == false) goto L6;
            registerListenerInner();
        L9:
            return true;
        L6:
            if (this.mIsConnecting == false) goto L9;
            if (r100 == false) goto L9;
            this.mIsRegisterNotifyAfterConnected = true;
            goto L9
        }

        public static /* synthetic */ boolean access$002(JannaAdapter r100, boolean r101) {
            r100.mIsConnected = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$202(JannaAdapter r100, boolean r101) {
            r100.mIsConnecting = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$302(JannaAdapter r100, boolean r101) {
            r100.mIsRegisterNotifyAfterConnected = r101;
            return r101;
        }

        public JannaAdapter(OemThermalStatusAdapter r100, Context r101, Looper r102) {
            this.this$0 = r100;
            this.mIsConnected = false;
            this.mIsConnecting = false;
            this.mIsRegisterNotifyAfterConnected = false;
            this.eventIdList = new AnonymousClass1(this);
            this.capability = 0;
            a r103 = a.C5812a.f473776a;
            this.janna = r103;
            monitor-enter(r103);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (r103.f473774a == true) goto L7;
            r103.f473774a = true;     // Catch: Throwable -> L10
            Context r104 = r101.getApplicationContext();     // Catch: Throwable -> L10
            r103.f473775b.a(r104);     // Catch: Throwable -> L10
        L7:
            monitor-exit(r103);
            MyHandler r105 = new MyHandler(this, r102);
            this.mHandler = r105;
            this.mIsConnecting = true;
            r105.sendEmptyMessageDelayed(1, 10000);
        }
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public boolean addStatusListener() {
        return this.mAdapter.registerListener(true);
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public float getCurrentTemp() {
        float r100 = this.mAdapter.getCurrentTemp();
        this.mTemp = r100;
        return r100;
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public boolean isEnable() {
        if (this.mAdapter.isConnected() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAdapter.isConnecting() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public void removeStatusListener() {
        this.mAdapter.removeListener();
    }

    @Override // com.bytedance.unitm.core.BaseThermalStatusGenerator
    public int getCurrentThermalStatus() {
        return this.mStatus;
    }

    public static /* synthetic */ float access$1100(OemThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ float access$1200(OemThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ BaseThermalStatusGenerator.IListener access$1400(OemThermalStatusAdapter r100) {
        return r100.mListener;
    }

    public static /* synthetic */ int access$1500(OemThermalStatusAdapter r100) {
        return r100.mStatus;
    }

    public static /* synthetic */ float access$1600(OemThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ BaseThermalStatusGenerator.IListener access$1700(OemThermalStatusAdapter r100) {
        return r100.mListener;
    }

    public static /* synthetic */ BaseThermalStatusGenerator.IListener access$2100(OemThermalStatusAdapter r100) {
        return r100.mListener;
    }

    public static /* synthetic */ int access$2200(OemThermalStatusAdapter r100) {
        return r100.mStatus;
    }

    public static /* synthetic */ float access$2300(OemThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ BaseThermalStatusGenerator.IListener access$2400(OemThermalStatusAdapter r100) {
        return r100.mListener;
    }

    public static /* synthetic */ float access$400(OemThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ float access$800(OemThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public static /* synthetic */ float access$900(OemThermalStatusAdapter r100) {
        return r100.mTemp;
    }

    public OemThermalStatusAdapter(Context r100, Looper r101) {
        super(r100, r101);
        this.mAdapter = new JannaAdapter(this, r100, r101);
    }

    public static /* synthetic */ int access$1002(OemThermalStatusAdapter r100, int r101) {
        r100.mStatus = r101;
        return r101;
    }

    public static /* synthetic */ float access$1902(OemThermalStatusAdapter r100, float r101) {
        r100.mTemp = r101;
        return r101;
    }

    public static /* synthetic */ int access$2002(OemThermalStatusAdapter r100, int r101) {
        r100.mStatus = r101;
        return r101;
    }

    public static /* synthetic */ float access$2502(OemThermalStatusAdapter r100, float r101) {
        r100.mTemp = r101;
        return r101;
    }

    public static /* synthetic */ int access$2602(OemThermalStatusAdapter r100, int r101) {
        r100.mStatus = r101;
        return r101;
    }

    public static /* synthetic */ float access$502(OemThermalStatusAdapter r100, float r101) {
        r100.mTemp = r101;
        return r101;
    }

    public static /* synthetic */ int access$602(OemThermalStatusAdapter r100, int r101) {
        r100.mStatus = r101;
        return r101;
    }

    public static /* synthetic */ int access$1300(OemThermalStatusAdapter r100, float r101, boolean r102) {
        return r100.getThermalStatusFromTemp(r101, r102);
    }
}
