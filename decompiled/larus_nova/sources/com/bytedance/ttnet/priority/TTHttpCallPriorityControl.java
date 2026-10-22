package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.util.h;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import com.xiaomi.mipush.sdk.Constants;
import hx5.a;
import hx5.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTHttpCallPriorityControl implements IHttpCallThrottleControl {
    private static String TAG = "TTHttpCallPriorityControl";
    private static volatile TTHttpCallPriorityControl mInstance;
    private BaseModeControl mCurrentModeControl;
    private final ReadWriteLock mCurrentModeRWLock;
    private final Map<String, BaseModeControl> mModeControlMap;
    private final AtomicBoolean mTncModeControlEnabled;

    public static abstract class BaseModeControl implements IHttpCallThrottleControl {
        private a mClearSelfTask;
        private int mDelayDisableTimeMs;
        private boolean mLifeIsValid;
        private Date mLifeTimeBegin;
        private Date mLifeTimeEnd;
        protected final RequestDelayController mRequestDelayController;
        private int mStateId;
        protected String mStateName;

        @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
        public /* synthetic */ Request setOriginalRequestProperties(Request r100) {
            return IHttpCallThrottleControl.CC.$default$setOriginalRequestProperties(this, r100);
        }

        public void modeStart() {
            final long r100 = this.mDelayDisableTimeMs;
            final long r101 = 0;
            this.mClearSelfTask = new AnonymousClass1(this, r100, r101);
            b.a(NetworkAsyncTaskType.NETWORK).b(this.mClearSelfTask);
        }

        public void modeStop() {
            if (this.mClearSelfTask == null) goto L17;
            b r100 = b.a(NetworkAsyncTaskType.NETWORK);
            a r101 = this.mClearSelfTask;
            r100.getClass();
            Runnable r102 = r100.f487500b.remove(r101);     // Catch: Throwable -> L12
            if (r102 == null) goto L8;
            r100.f487502d.remove(r102);     // Catch: Throwable -> L12
        L8:
            ScheduledFuture r103 = r100.f487499a.remove(r101);     // Catch: Throwable -> L12
            if (r103 == null) goto L18;
            r103.cancel(true);     // Catch: Throwable -> L12
            return;
        L18:
            return;
        L12:
            th = move-exception;
            Logger.e(b.f487497e, "removeTask failed", th);
            return;
        }

        public BaseModeControl() {
            this.mRequestDelayController = new RequestDelayController();
            this.mStateName = "";
            this.mStateId = -1;
            this.mLifeTimeBegin = null;
            this.mLifeTimeEnd = null;
            this.mLifeIsValid = true;
            this.mDelayDisableTimeMs = 1000;
            this.mClearSelfTask = null;
        }

        private boolean isInLifecycle() {
            if (Logger.debug() == false) goto L6;
            Logger.d(TTHttpCallPriorityControl.access$000(), "isInLifecycle, stateName: " + this.mStateName + ", beginTime: " + this.mLifeTimeBegin + ", endTime: " + this.mLifeTimeEnd);
        L6:
            if (this.mLifeIsValid == true) goto L9;
            return false;
        L9:
            if (this.mLifeTimeBegin != null) goto L11;
        L19:
            return true;
        L11:
            if (this.mLifeTimeEnd == null) goto L19;
            Date r100 = new Date();
            if (r100.after(this.mLifeTimeBegin) == true) goto L16;
            return false;
        L16:
            if (r100.before(this.mLifeTimeEnd) == false) goto L21;
            return true;
        L21:
            return false;
        }

        public ModeType modeType() {
            return ModeType.NOT_REACHED;
        }

        public String stateName() {
            return this.mStateName;
        }

        public static /* synthetic */ boolean access$100(BaseModeControl r100) {
            return r100.isInLifecycle();
        }

        private void initLifecycle(JSONObject r110) {
            if (r110 != null) goto L4;
            return;
        L4:
            String r111 = r110.optString(NewBroadcastMonitor.STAGE.LIFECYCLE);
            if ("".equals(r111) == false) goto L7;
            return;
        L7:
            ArrayList r100 = new ArrayList();
            String r101 = h.f244791a;
            if (TextUtils.isEmpty(r111) == false) goto L11;
        L9:
            boolean r112 = false;
        L29:
            if (r112 == false) goto L38;
            if (r100.size() != 2) goto L38;
            this.mLifeIsValid = true;
            this.mLifeTimeBegin = (Date) ListProtector.get(r100, 0);
            this.mLifeTimeEnd = (Date) ListProtector.get(r100, 1);
            if (Logger.debug() == false) goto L42;
            Logger.d(TTHttpCallPriorityControl.access$000(), "initLifecycle, stateName: " + this.mStateName + ", beginTime: " + this.mLifeTimeBegin.toString() + ", endTime: " + this.mLifeTimeEnd.toString());
            return;
        L42:
            return;
        L38:
            if (Logger.debug() == false) goto L40;
            Logger.d(TTHttpCallPriorityControl.access$000(), "initLifecycle, parse lifecycle failed");
        L40:
            this.mLifeIsValid = false;
            return;
        L11:
            if (r111.contains(Constants.WAVE_SEPARATOR) == false) goto L9;
            String[] r113 = r111.split(Constants.WAVE_SEPARATOR);
            if (r113.length != 2) goto L9;
            if (TextUtils.isEmpty(r113[0]) == true) goto L9;
            if (TextUtils.isEmpty(r113[1]) == true) goto L9;
            Date r102 = h.a(r113[0]);
            Date r103 = h.a(r113[1]);
            if (r102 == null) goto L9;
            if (r103 == null) goto L9;
            if (Logger.debug() == false) goto L28;
            String r104 = h.f244791a;
            Logger.d(r104, "parse dateTime " + r113[0] + " to " + r102);
            Logger.d(r104, "parse dateTime " + r113[1] + " to " + r103);
        L28:
            r100.add(r102);
            r100.add(r103);
            r112 = true;
            goto L29
        }

        public boolean initWithTncConfig(JSONObject r100) {
            String r101 = r100.optString("state_name", "");
            this.mStateName = r101;
            if (TextUtils.isEmpty(r101) == false) goto L6;
            return false;
        L6:
            this.mStateId = r100.optInt("state", -1);
            int r102 = 1000;
            int r103 = r100.optInt("delay_disable_time_ms", 1000);
            this.mDelayDisableTimeMs = r103;
            if (r103 <= 0) goto L10;
            r102 = r103;
        L10:
            this.mDelayDisableTimeMs = r102;
            initLifecycle(r100);
            return true;
        }

        @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
        public void notifyRequestCompleted(Request r100) {
            this.mRequestDelayController.notifyRequestCompleted(r100);
        }

        public void setDelayDisableTimeMs(int r100) {
            this.mDelayDisableTimeMs = r100;
        }

        public void setStateName(String r100) {
            this.mStateName = r100;
            this.mRequestDelayController.setOwnerStateName(r100);
        }
    }

    public static final enum ModeType extends Enum<ModeType> {
        private static final /* synthetic */ ModeType[] $VALUES = null;
        public static final ModeType DEFAULT = null;
        public static final ModeType NORMAL_DELAY = null;
        public static final ModeType NOT_REACHED = null;
        public static final ModeType PRIORITY = null;
        public static final ModeType RUNTIME_DELAY = null;
        private final int value;

        static {
            ModeType r100 = new ModeType("DEFAULT", 0, 0);
            DEFAULT = r100;
            ModeType r101 = new ModeType("NORMAL_DELAY", 1, 1);
            NORMAL_DELAY = r101;
            ModeType r102 = new ModeType("RUNTIME_DELAY", 2, 2);
            RUNTIME_DELAY = r102;
            ModeType r103 = new ModeType("PRIORITY", 3, 3);
            PRIORITY = r103;
            ModeType r104 = new ModeType("NOT_REACHED", 4, 4);
            NOT_REACHED = r104;
            $VALUES = new ModeType[]{r100, r101, r102, r103, r104};
        }

        public static ModeType[] values() {
            return (ModeType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ModeType fromValue(int r100) {
            ModeType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            ModeType r104 = r101[r103];
            if (r104.getValue() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Invalid value: " + r100);
        }

        public static ModeType valueOf(String r100) {
            return (ModeType) r27.a.a(ModeType.class, r100);
        }

        private ModeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public void resetToDefaultState() {
        startMode(null);
    }

    public static TTHttpCallPriorityControl getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(TTHttpCallThrottleControl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new TTHttpCallPriorityControl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTHttpCallThrottleControl.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public BaseModeControl getCurrentMode() {
        this.mCurrentModeRWLock.writeLock().lock();
        BaseModeControl r100 = this.mCurrentModeControl;     // Catch: Throwable -> L6
        this.mCurrentModeRWLock.writeLock().unlock();
        return r100;
    L6:
        th = move-exception;
        this.mCurrentModeRWLock.writeLock().unlock();
        throw th;
    }

    public ModeType getCurrentModeType() {
        this.mCurrentModeRWLock.writeLock().lock();
        ModeType r100 = this.mCurrentModeControl.modeType();     // Catch: Throwable -> L6
        this.mCurrentModeRWLock.writeLock().unlock();
        return r100;
    L6:
        th = move-exception;
        this.mCurrentModeRWLock.writeLock().unlock();
        throw th;
    }

    public TTHttpCallPriorityControl() {
        this.mTncModeControlEnabled = new AtomicBoolean(false);
        this.mModeControlMap = new ConcurrentHashMap();
        this.mCurrentModeControl = new ModeDefault();
        this.mCurrentModeRWLock = new ReentrantReadWriteLock();
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    private boolean checkRequest(Request r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r100.getPath()) == true) goto L6;
        return true;
    }

    private void startMode(BaseModeControl r100) {
        if (r100 != null) goto L5;
    L7:
        this.mCurrentModeRWLock.writeLock().lock();
        this.mCurrentModeControl.modeStop();     // Catch: Throwable -> L16
        if (r100 != null) goto L11;
        r100 = new ModeDefault();     // Catch: Throwable -> L16
    L11:
        this.mCurrentModeControl = r100;     // Catch: Throwable -> L16
        r100.modeStart();     // Catch: Throwable -> L16
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "set mode " + this.mCurrentModeControl.modeType());     // Catch: Throwable -> L16
    L14:
        this.mCurrentModeRWLock.writeLock().unlock();
        return;
    L16:
        th = move-exception;
        this.mCurrentModeRWLock.writeLock().unlock();
        throw th;
    L5:
        if (BaseModeControl.access$100(r100) == true) goto L7;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r100) throws Exception {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "current mode is " + getCurrentModeType());
    L6:
        if (this.mTncModeControlEnabled.get() == true) goto L11;
        if (this.mCurrentModeControl.modeType() == ModeType.DEFAULT) goto L11;
        return;
    L11:
        if (checkRequest(r100) == true) goto L14;
        return;
    L14:
        if (BaseModeControl.access$100(this.mCurrentModeControl) == true) goto L16;
        return;
    L16:
        this.mCurrentModeControl.maybeDropRequestOrBlockingDelay(r100);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(Request r100) {
        if (this.mTncModeControlEnabled.get() == false) goto L8;
        if (r100 == null) goto L9;
        this.mCurrentModeControl.notifyRequestCompleted(r100);
        return;
    L9:
        return;
    }

    public void onServerConfigChangedFromTNCHandler(JSONObject r100) {
        int r101 = 0;
        this.mTncModeControlEnabled.set(false);
        this.mModeControlMap.clear();
        JSONArray r102 = r100.optJSONArray("tt_req_delay_config");
        if (r100.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r103 = true;
    L7:
        if (r100.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r104 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r104 == false) goto L14;
        boolean r105 = true;
    L15:
        if (r103 == false) goto L48;
        if (r102 == null) goto L48;
        if (r105 == false) goto L48;
        ConcurrentHashMap r106 = new ConcurrentHashMap();
    L21:
        if (r101 >= r102.length()) goto L44;
        JSONObject r107 = r102.optJSONObject(r101);
        String r108 = r107.optString("state_name", "");
        if (TextUtils.isEmpty(r108) == true) goto L42;
        ModeType r109 = ModeType.fromValue(r107.optInt("type", ModeType.NOT_REACHED.getValue()));
        if (r109 != ModeType.NORMAL_DELAY) goto L29;
        BaseModeControl r110 = new ModeNormalDelay();
    L35:
        if (r110 == null) goto L42;
        if (r110.initWithTncConfig(r107) == false) goto L42;
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "mode name is " + r108);
    L41:
        r106.put(r108, r110);
        goto L42
    L29:
        if (r109 != ModeType.RUNTIME_DELAY) goto L32;
        r110 = new ModeRuntimeDelay();
        goto L35
    L32:
        if (r109 != ModeType.PRIORITY) goto L34;
        r110 = new ModePriorityManagement();
        goto L35
    L34:
        r110 = null;
    L42:
        r101 = r101 + 1;
        goto L21
    L44:
        if (Logger.debug() == false) goto L46;
        Logger.d(TAG, "mode size is " + r106.size());
    L46:
        this.mModeControlMap.putAll(r106);
        this.mTncModeControlEnabled.set(true);
        return;
    L48:
        resetToDefaultState();
        return;
    L14:
        r105 = false;
        goto L15
    L9:
        r104 = false;
        goto L11
    L5:
        r103 = false;
        goto L7
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public Request setOriginalRequestProperties(Request r100) {
        if (this.mTncModeControlEnabled.get() == false) goto L8;
        if (r100 != null) goto L7;
        return r100;
    L7:
        return this.mCurrentModeControl.setOriginalRequestProperties(r100);
    L8:
        return r100;
    }

    public void startAppStateFromCustom(ModePriorityManagement r100) {
        startMode(r100);
    }

    public void startAppStateFromTNC(String r100) {
        startMode(this.mModeControlMap.get(r100));
    }

    public static Integer getMapValueIfMatch(Map<String, Integer> r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        Iterator<String> r102 = r100.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();
        if (r101.startsWith(r103) == false) goto L7;
        return r100.get(r103);
    L12:
        return null;
    }

    public static Set<String> getSetFromJSONArray(JSONObject r100, String r101) {
        CopyOnWriteArraySet r102 = new CopyOnWriteArraySet();
        if (r100 != null) goto L5;
        return r102;
    L5:
        JSONArray r103 = r100.optJSONArray(r101);
        if (r103 != null) goto L8;
        return r102;
    L8:
        int r104 = 0;
    L10:
        if (r104 >= r103.length()) goto L15;
        String r105 = r103.optString(r104);
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r102.add(r105);
    L14:
        r104 = r104 + 1;
        goto L10
    L15:
        return r102;
    }

    public static boolean isMatch(Set<String> r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        Iterator<String> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        if (r101.startsWith(r102.next()) == false) goto L9;
        return true;
    L14:
        return false;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r100, Executor r101, Runnable r102) throws Exception {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "current mode is " + getCurrentModeType());
    L6:
        if (this.mTncModeControlEnabled.get() == true) goto L11;
        if (this.mCurrentModeControl.modeType() == ModeType.DEFAULT) goto L11;
        return false;
    L11:
        if (checkRequest(r100) == true) goto L14;
        return false;
    L14:
        if (BaseModeControl.access$100(this.mCurrentModeControl) == true) goto L17;
        return false;
    L17:
        return this.mCurrentModeControl.maybeDropRequestOrAsyncDelay(r100, r101, r102);
    }
}
