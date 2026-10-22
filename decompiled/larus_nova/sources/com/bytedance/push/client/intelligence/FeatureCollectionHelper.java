package com.bytedance.push.client.intelligence;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.android.service.manager.push.client.intelligence.IFeatureCallBack;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.interfaze.SensorAbility;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.push.PushSupporter;
import com.larus.apm.impl.protector.RunnableProtector;
import faceverify.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FeatureCollectionHelper extends BaseJson implements SensorEventListener, IClientFeatureService {
    public static final String CLIENT_INTELLIGENCE_TAG = "CLIENT_INTELLIGENCE-";
    private static volatile FeatureCollectionHelper mInstance;
    private final float F_VALUE_UNKNOWN;
    private final String TAG;
    private final int VALUE_UNKNOWN;
    private boolean mAccelerometerCollectSuccess;
    private JSONObject mAccelerometerInfo;
    private Sensor mAccelerometerSensor;
    private ActivityManager mActivityManager;
    private boolean mAllowCollectClientFeature;
    private List<String> mAllowCollectClientFeatureScene;
    private AudioManager mAudioManager;
    private CountDownLatch mAudioManagerInitCountDownLatch;
    private BatteryManager mBatteryManager;
    private Context mContext;
    private float mDistance;
    private boolean mDistanceCollectSuccess;
    private Sensor mGyroScopeSensor;
    private boolean mGyroscopeCollectSuccess;
    private JSONObject mGyroscopeInfo;
    private Handler mHandler;
    private KeyguardManager mKeyguardManager;
    private long mLastBrightScreenTime;
    private long mLastRestScreenTime;
    private float mLight;
    private boolean mLightCollectSuccess;
    private Sensor mLightSensor;
    private PowerManager mPowerManager;
    private Sensor mProximitySensor;
    private CountDownLatch mPushShowCountDownLatch;
    private CountDownLatch mReportFeatureCountDownLatch;
    private SensorAbility mSensorAbility;
    private SensorManager mSensorManager;
    private float xAc;
    private float yAc;
    private float zAc;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeatureCollectionHelper f266834a;

        @Override // java.lang.Runnable
        public final void run() {
            FeatureCollectionHelper r100 = this.f266834a;     // Catch: Throwable -> L4
            FeatureCollectionHelper.access$002(r100, (AudioManager) FeatureCollectionHelper.access$100(r100).getSystemService("audio"));     // Catch: Throwable -> L4
            FeatureCollectionHelper.access$200(this.f266834a).countDown();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(FeatureCollectionHelper r100) {
            this.f266834a = r100;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.push.client.intelligence.e f266835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FeatureCollectionHelper f266836b;

        public final void a() {
            boolean r100 = true;
            FeatureCollectionHelper.access$402(this.f266836b, new CountDownLatch(1));     // Catch: InterruptedException -> L9
            FeatureCollectionHelper.access$500(this.f266836b);     // Catch: InterruptedException -> L9
            boolean r101 = FeatureCollectionHelper.access$400(this.f266836b).await(PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().f507801d, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L9
            StringBuilder r102 = new StringBuilder("finish getFeatureForPushShow, awaitTimeout is ");     // Catch: InterruptedException -> L9
            if (r101 == false) goto L7;
            r100 = false;
        L7:
            r102.append(r100);     // Catch: InterruptedException -> L9
            com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", r102.toString());     // Catch: InterruptedException -> L9
            com.bytedance.push.client.intelligence.e r103 = this.f266835a;     // Catch: InterruptedException -> L9
            ClientIntelligenceServiceImpl.b r104 = (ClientIntelligenceServiceImpl.b) r103;     // Catch: InterruptedException -> L9
            r104.a(FeatureCollectionHelper.access$600(this.f266836b), FeatureCollectionHelper.access$700(this.f266836b), FeatureCollectionHelper.access$800(this.f266836b), FeatureCollectionHelper.access$900(this.f266836b), FeatureCollectionHelper.access$1000(this.f266836b), FeatureCollectionHelper.access$1100(this.f266836b), FeatureCollectionHelper.access$1200(this.f266836b));     // Catch: InterruptedException -> L9
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            com.bytedance.push.utils.f.f("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "getFeatureForPushShow callback null because InterruptedException: ", e);
            ClientIntelligenceServiceImpl.b r105 = (ClientIntelligenceServiceImpl.b) this.f266835a;
            r105.getClass();
            com.bytedance.push.utils.f.e("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "cur is not low Ctr because onNullFeatureCallback");
            ClientIntelligenceServiceImpl.access$102(r105.f266823b, false);
            r105.f266822a.countDown();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(FeatureCollectionHelper r100, com.bytedance.push.client.intelligence.e r101) {
            this.f266836b = r100;
            this.f266835a = r101;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f266837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IFeatureCallBack f266838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FeatureCollectionHelper f266839c;

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r100 = this.f266839c.getClientFeatureSync(this.f266837a);     // Catch: Throwable -> L4
            this.f266838b.onFeatureCallBack(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(FeatureCollectionHelper r100, String r101, IFeatureCallBack r102) {
            this.f266839c = r100;
            this.f266837a = r101;
            this.f266838b = r102;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeatureCollectionHelper f266840a;

        @Override // java.lang.Runnable
        public final void run() {
            SensorAbility r100 = FeatureCollectionHelper.access$1500(this.f266840a);     // Catch: Throwable -> L4
            SensorManager r101 = FeatureCollectionHelper.access$1300(this.f266840a);     // Catch: Throwable -> L4
            FeatureCollectionHelper r102 = this.f266840a;     // Catch: Throwable -> L4
            r100.unregisterListener(r101, r102, FeatureCollectionHelper.access$1400(r102));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(FeatureCollectionHelper r100) {
            this.f266840a = r100;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeatureCollectionHelper f266841a;

        @Override // java.lang.Runnable
        public final void run() {
            SensorAbility r100 = FeatureCollectionHelper.access$1500(this.f266841a);     // Catch: Throwable -> L4
            SensorManager r101 = FeatureCollectionHelper.access$1300(this.f266841a);     // Catch: Throwable -> L4
            FeatureCollectionHelper r102 = this.f266841a;     // Catch: Throwable -> L4
            r100.unregisterListener(r101, r102, FeatureCollectionHelper.access$1600(r102));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(FeatureCollectionHelper r100) {
            this.f266841a = r100;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeatureCollectionHelper f266842a;

        @Override // java.lang.Runnable
        public final void run() {
            SensorAbility r100 = FeatureCollectionHelper.access$1500(this.f266842a);     // Catch: Throwable -> L4
            SensorManager r101 = FeatureCollectionHelper.access$1300(this.f266842a);     // Catch: Throwable -> L4
            FeatureCollectionHelper r102 = this.f266842a;     // Catch: Throwable -> L4
            r100.unregisterListener(r101, r102, FeatureCollectionHelper.access$1700(r102));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(FeatureCollectionHelper r100) {
            this.f266842a = r100;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeatureCollectionHelper f266843a;

        @Override // java.lang.Runnable
        public final void run() {
            SensorAbility r100 = FeatureCollectionHelper.access$1500(this.f266843a);     // Catch: Throwable -> L4
            SensorManager r101 = FeatureCollectionHelper.access$1300(this.f266843a);     // Catch: Throwable -> L4
            FeatureCollectionHelper r102 = this.f266843a;     // Catch: Throwable -> L4
            r100.unregisterListener(r101, r102, FeatureCollectionHelper.access$1800(r102));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(FeatureCollectionHelper r100) {
            this.f266843a = r100;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class h extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeatureCollectionHelper f266844a;

        public h(FeatureCollectionHelper r100) {
            this.f266844a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            String r102 = r101.getAction();
            if (TextUtils.equals("android.intent.action.SCREEN_ON", r102) == false) goto L6;
            com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "监听到亮屏");
            FeatureCollectionHelper.access$1902(this.f266844a, System.currentTimeMillis());
            return;
        L6:
            if (TextUtils.equals("android.intent.action.SCREEN_OFF", r102) == false) goto L10;
            com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "监听到息屏");
            FeatureCollectionHelper.access$2002(this.f266844a, System.currentTimeMillis());
            return;
        }
    }

    private void initPushShowFeatureSensor() {
        this.mAccelerometerCollectSuccess = false;
        this.mAccelerometerInfo = new JSONObject();
        this.xAc = -1.0f;
        this.yAc = -1.0f;
        this.zAc = -1.0f;
        Sensor r100 = this.mSensorAbility.getDefaultSensor(this.mSensorManager, 1);
        this.mAccelerometerSensor = r100;
        this.mSensorAbility.registerListener(this.mSensorManager, this, r100, 0);
        this.mDistanceCollectSuccess = false;
        this.mDistance = -1.0f;
        Sensor r101 = this.mSensorAbility.getDefaultSensor(this.mSensorManager, 8);
        this.mProximitySensor = r101;
        this.mSensorAbility.registerListener(this.mSensorManager, this, r101, 0);
    }

    private void initSensor() {
        this.mGyroscopeCollectSuccess = false;
        this.mGyroscopeInfo = new JSONObject();
        Sensor r100 = this.mSensorAbility.getDefaultSensor(this.mSensorManager, 4);
        this.mGyroScopeSensor = r100;
        this.mSensorAbility.registerListener(this.mSensorManager, this, r100, 0);
        this.mLightCollectSuccess = false;
        this.mLight = -1.0f;
        Sensor r101 = this.mSensorAbility.getDefaultSensor(this.mSensorManager, 5);
        this.mLightSensor = r101;
        this.mSensorAbility.registerListener(this.mSensorManager, this, r101, 0);
        initPushShowFeatureSensor();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r100, int r101) {
    }

    private JSONObject getAudioFeature() {
        JSONObject r100 = new JSONObject();
        AudioManager r101 = this.mAudioManager;
        if (r101 != null) goto L5;
        return r100;
    L5:
        add(r100, "cur_call_voice", r101.getStreamVolume(0));
        add(r100, "max_call_voice", this.mAudioManager.getStreamMaxVolume(0));
        add(r100, "cur_system_voice", this.mAudioManager.getStreamVolume(1));
        add(r100, "max_system_voice", this.mAudioManager.getStreamMaxVolume(1));
        add(r100, "cur_ring_voice", this.mAudioManager.getStreamVolume(2));
        add(r100, "max_ring_voice", this.mAudioManager.getStreamMaxVolume(2));
        add(r100, "cur_music_voice", this.mAudioManager.getStreamVolume(3));
        add(r100, "max_music_voice", this.mAudioManager.getStreamMaxVolume(3));
        add(r100, "cur_alarm_voice", this.mAudioManager.getStreamVolume(4));
        add(r100, "max_alarm_voice", this.mAudioManager.getStreamMaxVolume(4));
        return r100;
    }

    private int getBatteryCapacity() {
        BatteryManager r100 = this.mBatteryManager;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getIntProperty(4);
    }

    private int getBatteryStatus() {
        BatteryManager r100 = this.mBatteryManager;
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L8;
        return -1;
    L8:
        return r100.getIntProperty(6);
    }

    private int getNetWorkType() {
        NetworkUtils.NetworkType r100 = NetworkUtils.getNetworkType(this.mContext);
        if (r100.isAvailable() == true) goto L7;
        return 0;
    L7:
        if (r100.is4GOrHigher() == false) goto L11;
        return 4;
    L11:
        if (r100.is3GOrHigher() == false) goto L15;
        return 3;
    L15:
        if (r100.is2G() == false) goto L19;
        return 2;
    L19:
        if (r100.isWifi() == false) goto L22;
        return 1;
    L22:
        return -1;
    }

    private boolean isLockScreen() {
        return this.mKeyguardManager.inKeyguardRestrictedInputMode();
    }

    private boolean isMusicActive() {
        AudioManager r100 = this.mAudioManager;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isMusicActive() == false) goto L7;
        return true;
    }

    private boolean isScreenOn() {
        return this.mPowerManager.isScreenOn();
    }

    private FeatureCollectionHelper(Context r100) {
        this.TAG = "CLIENT_INTELLIGENCE-FeatureCollectionHelper";
        this.VALUE_UNKNOWN = -1;
        this.F_VALUE_UNKNOWN = -1.0f;
        this.xAc = -1.0f;
        this.yAc = -1.0f;
        this.zAc = -1.0f;
        this.mContext = r100;
        l77.b r101 = PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings();
        boolean r102 = r101.f507799b;
        this.mAllowCollectClientFeature = r102;
        if (r102 == true) goto L5;
        return;
    L5:
        List<String> r103 = r101.f507811n;
        this.mAllowCollectClientFeatureScene = r103;
        if (((ArrayList) r103).isEmpty() == false) goto L8;
        return;
    L8:
        this.mSensorAbility = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.getSensorAbility();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mGyroscopeInfo = new JSONObject();
        this.mAccelerometerInfo = new JSONObject();
        this.mSensorManager = (SensorManager) this.mContext.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        this.mBatteryManager = (BatteryManager) this.mContext.getSystemService("batterymanager");
        this.mAudioManagerInitCountDownLatch = new CountDownLatch(1);
        this.mHandler.post(new a(this));
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
        this.mActivityManager = (ActivityManager) this.mContext.getSystemService("activity");
        if (isScreenOn() == false) goto L11;
        this.mLastBrightScreenTime = System.currentTimeMillis();
    L12:
        IntentFilter r104 = new IntentFilter();
        r104.addAction("android.intent.action.SCREEN_ON");
        r104.addAction("android.intent.action.SCREEN_OFF");
        PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(this.mContext, new h(this), r104);
        return;
    L11:
        this.mLastRestScreenTime = System.currentTimeMillis();
        goto L12
    }

    public static /* synthetic */ Context access$100(FeatureCollectionHelper r100) {
        return r100.mContext;
    }

    public static /* synthetic */ float access$1000(FeatureCollectionHelper r100) {
        return r100.xAc;
    }

    public static /* synthetic */ float access$1100(FeatureCollectionHelper r100) {
        return r100.yAc;
    }

    public static /* synthetic */ float access$1200(FeatureCollectionHelper r100) {
        return r100.zAc;
    }

    public static /* synthetic */ SensorManager access$1300(FeatureCollectionHelper r100) {
        return r100.mSensorManager;
    }

    public static /* synthetic */ Sensor access$1400(FeatureCollectionHelper r100) {
        return r100.mGyroScopeSensor;
    }

    public static /* synthetic */ SensorAbility access$1500(FeatureCollectionHelper r100) {
        return r100.mSensorAbility;
    }

    public static /* synthetic */ Sensor access$1600(FeatureCollectionHelper r100) {
        return r100.mAccelerometerSensor;
    }

    public static /* synthetic */ Sensor access$1700(FeatureCollectionHelper r100) {
        return r100.mLightSensor;
    }

    public static /* synthetic */ Sensor access$1800(FeatureCollectionHelper r100) {
        return r100.mProximitySensor;
    }

    public static /* synthetic */ CountDownLatch access$200(FeatureCollectionHelper r100) {
        return r100.mAudioManagerInitCountDownLatch;
    }

    public static /* synthetic */ CountDownLatch access$400(FeatureCollectionHelper r100) {
        return r100.mPushShowCountDownLatch;
    }

    public static /* synthetic */ void access$500(FeatureCollectionHelper r100) {
        r100.initPushShowFeatureSensor();
    }

    public static /* synthetic */ boolean access$600(FeatureCollectionHelper r100) {
        return r100.isMusicActive();
    }

    public static /* synthetic */ boolean access$700(FeatureCollectionHelper r100) {
        return r100.mDistanceCollectSuccess;
    }

    public static /* synthetic */ float access$800(FeatureCollectionHelper r100) {
        return r100.mDistance;
    }

    public static /* synthetic */ boolean access$900(FeatureCollectionHelper r100) {
        return r100.mAccelerometerCollectSuccess;
    }

    public static FeatureCollectionHelper getInstance(Context r100) {
        if (mInstance != null) goto L15;
        monitor-enter(FeatureCollectionHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new FeatureCollectionHelper(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(FeatureCollectionHelper.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private boolean isUsingEarPhone(AudioManager r100) {
        if (r100.isWiredHeadsetOn() == false) goto L5;
        return true;
    L5:
        BluetoothAdapter r101 = BluetoothAdapter.getDefaultAdapter();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.isEnabled() == true) goto L11;
        return false;
    L11:
        if (Build.VERSION.SDK_INT >= 34) goto L13;
    L16:
        int r102 = r101.getProfileConnectionState(2);
        int r103 = r101.getProfileConnectionState(1);
        int r104 = r101.getProfileConnectionState(3);
    L18:
        if (r102 != 2) goto L20;
        r104 = r102;
    L25:
        if (r104 != (-1)) goto L30;
        return false;
    L30:
        return true;
    L20:
        if (r103 != 2) goto L22;
        r104 = r103;
        goto L25
    L22:
        if (r104 == 2) goto L25;
        r104 = -1;
        goto L25
    L13:
        if (com_bytedance_push_client_intelligence_FeatureCollectionHelper_android_content_Context_checkSelfPermission(this.mContext, "android.permission.BLUETOOTH_CONNECT") == 0) goto L16;
        r104 = 0;
        r102 = 0;
        r103 = 0;
        goto L18
    }

    @Override // com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService
    public JSONObject getClientFeatureSync(String r100) {
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getClientFeatureSync] allowCollectClientFeature is " + this.mAllowCollectClientFeature + " invokeScene is " + r100);
        if (this.mAllowCollectClientFeature == true) goto L6;
        return null;
    L6:
        if (this.mAllowCollectClientFeatureScene.contains(r100) == true) goto L9;
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getClientFeatureSync] return null because mAllowCollectClientFeatureScene not contains " + r100);
        return null;
    L9:
        boolean r101 = true;
        this.mReportFeatureCountDownLatch = new CountDownLatch(1);
        initSensor();
        boolean r102 = this.mReportFeatureCountDownLatch.await(PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().f507801d, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L16
        StringBuilder r103 = new StringBuilder("finish getClientFeatureSync, awaitTimeout is ");     // Catch: InterruptedException -> L16
        if (r102 == false) goto L14;
        r101 = false;
    L14:
        r103.append(r101);     // Catch: InterruptedException -> L16
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", r103.toString());     // Catch: InterruptedException -> L16
        JSONObject r104 = new JSONObject();     // Catch: InterruptedException -> L16
        add(r104, Constants.Keys.KEY_CLIENT_TIME, System.currentTimeMillis());     // Catch: InterruptedException -> L16
        add(r104, "voice", getAudioFeature());     // Catch: InterruptedException -> L16
        add(r104, "is_using_ear_phone", isUsingEarPhone(this.mAudioManager));     // Catch: InterruptedException -> L16
        add(r104, "is_music_active", isMusicActive());     // Catch: InterruptedException -> L16
        add(r104, "cur_battery_capacity", getBatteryCapacity());     // Catch: InterruptedException -> L16
        add(r104, "cur_battery_status", getBatteryStatus());     // Catch: InterruptedException -> L16
        add(r104, "is_screen_on", isScreenOn());     // Catch: InterruptedException -> L16
        add(r104, "last_screen_on_time", this.mLastBrightScreenTime);     // Catch: InterruptedException -> L16
        add(r104, "last_screen_off_time", this.mLastRestScreenTime);     // Catch: InterruptedException -> L16
        add(r104, "is_lock_screen", isLockScreen());     // Catch: InterruptedException -> L16
        add(r104, "network_type", getNetWorkType());     // Catch: InterruptedException -> L16
        add(r104, "gyroscope_info", this.mGyroscopeInfo);     // Catch: InterruptedException -> L16
        add(r104, "accelerometer_info", this.mAccelerometerInfo);     // Catch: InterruptedException -> L16
        add(r104, "lignt", this.mLight);     // Catch: InterruptedException -> L16
        add(r104, "distance", this.mDistance);     // Catch: InterruptedException -> L16
        return r104;
    L16:
        e = move-exception;
        com.bytedance.push.utils.f.f("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "error when await mReportFeatureCountDownLatch:", e);
        return null;
    }

    public synchronized void getFeatureForLocalPush(com.bytedance.push.client.intelligence.d r100) {
        monitor-enter(this);
        boolean r101 = PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().f507812o.f507813a;     // Catch: Throwable -> L21
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getFeatureForLocalPush] allowCollectClientFeature is " + this.mAllowCollectClientFeature + " enableClientIntelligenceLocalPush is " + r101);     // Catch: Throwable -> L21
        if (this.mAllowCollectClientFeature == false) goto L18;
        if (r101 == false) goto L18;
        if (this.mAudioManagerInitCountDownLatch.getCount() > 0) goto L25;
    L15:
        ((ClientIntelligenceServiceImpl.g) r100).a(isUsingEarPhone(this.mAudioManager), isScreenOn(), isMusicActive());     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L25:
        this.mAudioManagerInitCountDownLatch.await();     // Catch: InterruptedException -> L13 Throwable -> L21
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L18:
        com.bytedance.push.utils.f.i("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "getFeatureForLocalPush callback null because settings is not enable");     // Catch: Throwable -> L21
        ClientIntelligenceServiceImpl.g r102 = (ClientIntelligenceServiceImpl.g) r100;     // Catch: Throwable -> L21
        r102.getClass();     // Catch: Throwable -> L21
        com.bytedance.push.utils.f.e("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "cur is not low Ctr because onNullFeatureCallback");     // Catch: Throwable -> L21
        ClientIntelligenceServiceImpl.access$802(r102.f266833b, false);     // Catch: Throwable -> L21
        r102.f266832a.countDown();     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public synchronized void getFeatureForPushShow(com.bytedance.push.client.intelligence.e r100) {
        monitor-enter(this);
        boolean r101 = PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().f507800c;     // Catch: Throwable -> L14
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getFeatureForPushShow] allowCollectClientFeature is " + this.mAllowCollectClientFeature + " enableClientIntelligencePushShow is " + r101);     // Catch: Throwable -> L14
        if (this.mAllowCollectClientFeature == false) goto L11;
        if (r101 == false) goto L11;
        ThreadPlus.submitRunnable(new b(this, r100));     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        com.bytedance.push.utils.f.i("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "getFeatureForPushShow callback null because settings is not enable");     // Catch: Throwable -> L14
        ClientIntelligenceServiceImpl.b r102 = (ClientIntelligenceServiceImpl.b) r100;     // Catch: Throwable -> L14
        r102.getClass();     // Catch: Throwable -> L14
        com.bytedance.push.utils.f.e("CLIENT_INTELLIGENCE-ClientIntelligenceServiceImpl", "cur is not low Ctr because onNullFeatureCallback");     // Catch: Throwable -> L14
        ClientIntelligenceServiceImpl.access$102(r102.f266823b, false);     // Catch: Throwable -> L14
        r102.f266822a.countDown();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r100) {
        if (this.mGyroscopeCollectSuccess == true) goto L8;
        if (r100.sensor.getType() != 4) goto L8;
        add(this.mGyroscopeInfo, "xGy", r100.values[0]);
        add(this.mGyroscopeInfo, "yGy", r100.values[1]);
        add(this.mGyroscopeInfo, "zGy", r100.values[2]);
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "陀螺仪传感器更新：" + this.mGyroscopeInfo.toString());
        ThreadPlus.runOnChildThread(new d(this));
        this.mGyroscopeCollectSuccess = true;
    L23:
        if (this.mAccelerometerCollectSuccess == true) goto L25;
        return;
    L25:
        if (this.mDistanceCollectSuccess == true) goto L27;
        return;
    L27:
        if (this.mPushShowCountDownLatch == null) goto L30;
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "finish get push show feature,invoke mPushShowCountDownLatch.countDown()");
        this.mPushShowCountDownLatch.countDown();
    L30:
        if (this.mGyroscopeCollectSuccess == true) goto L32;
        return;
    L32:
        if (this.mLightCollectSuccess == true) goto L34;
        return;
    L34:
        if (this.mReportFeatureCountDownLatch == null) goto L41;
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "finish get report feature,invoke mReportFeatureCountDownLatch.countDown()");
        this.mReportFeatureCountDownLatch.countDown();
        return;
    L41:
        return;
    L8:
        if (this.mAccelerometerCollectSuccess == true) goto L13;
        if (r100.sensor.getType() != 1) goto L13;
        float[] r101 = r100.values;
        float r102 = r101[0];
        this.xAc = r102;
        this.yAc = r101[1];
        this.zAc = r101[2];
        add(this.mAccelerometerInfo, "xAc", r102);
        add(this.mAccelerometerInfo, "yAc", this.yAc);
        add(this.mAccelerometerInfo, "zAc", this.zAc);
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "加速度传感器更新：" + this.mAccelerometerInfo.toString());
        ThreadPlus.runOnChildThread(new e(this));
        this.mAccelerometerCollectSuccess = true;
    L13:
        if (this.mLightCollectSuccess == true) goto L18;
        if (r100.sensor.getType() != 5) goto L18;
        this.mLight = r100.values[0];
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "光线传感器更新：" + this.mLight);
        ThreadPlus.runOnChildThread(new f(this));
        this.mLightCollectSuccess = true;
    L18:
        if (this.mDistanceCollectSuccess == true) goto L23;
        if (r100.sensor.getType() != 8) goto L23;
        this.mDistance = r100.values[0];
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "距离传感器更新：" + this.mDistance);
        ThreadPlus.runOnChildThread(new g(this));
        this.mDistanceCollectSuccess = true;
        goto L23
    }

    public void setAllowCollectClientFeature(boolean r100) {
        this.mAllowCollectClientFeature = r100;
    }

    public static /* synthetic */ AudioManager access$002(FeatureCollectionHelper r100, AudioManager r101) {
        r100.mAudioManager = r101;
        return r101;
    }

    public static /* synthetic */ long access$1902(FeatureCollectionHelper r100, long r101) {
        r100.mLastBrightScreenTime = r101;
        return r101;
    }

    public static /* synthetic */ long access$2002(FeatureCollectionHelper r100, long r101) {
        r100.mLastRestScreenTime = r101;
        return r101;
    }

    public static /* synthetic */ CountDownLatch access$402(FeatureCollectionHelper r100, CountDownLatch r101) {
        r100.mPushShowCountDownLatch = r101;
        return r101;
    }

    private static int com_bytedance_push_client_intelligence_FeatureCollectionHelper_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_bytedance_push_client_intelligence_FeatureCollectionHelper_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService
    public void getClientFeatureAsync(IFeatureCallBack r100, String r101) {
        ThreadPlus.submitRunnable(new c(this, r101, r100));
    }

    public synchronized void getFeatureForEventReport(IFeatureCallBack r100, String r101) {
        monitor-enter(this);
        boolean r102 = PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().f507798a;     // Catch: Throwable -> L12
        com.bytedance.push.utils.f.b("CLIENT_INTELLIGENCE-FeatureCollectionHelper", "[getFeatureForEventReport] enableClientFeatureReport is " + r102);     // Catch: Throwable -> L12
        if (r102 == true) goto L9;
        r100.onFeatureCallBack(null);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        getClientFeatureAsync(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
