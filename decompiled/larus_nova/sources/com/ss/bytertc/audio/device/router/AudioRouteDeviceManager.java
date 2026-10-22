package com.ss.bytertc.audio.device.router;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.camera.core.RetryPolicy;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.media.LossFocusType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class AudioRouteDeviceManager extends BroadcastReceiver {
    private static final String ACTION_BT_A2DP_CONNECTION_STATE_CHANGED = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
    private static final String ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
    private static final String ACTION_BT_SCO_AUDIO_STATE_UPDATED = "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
    private static final String ACTION_BT_STATE_CHANGED = "android.bluetooth.adapter.action.STATE_CHANGED";
    private static final String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";
    private static final String ACTION_USB_DEVICE_ATTACHED = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    private static final String ACTION_USB_DEVICE_DETACHED = "android.hardware.usb.action.USB_DEVICE_DETACHED";
    private static final int BLUETOOTH_SCO_CONNECT_CHECK_MAX_RETRY_TIMES = 3;
    private static final int BLUETOOTH_SCO_CONNECT_CHECK_TIME_GAP = 3000;
    private static final int BLUETOOTH_SCO_DISCONNECT_CHECK_TIME_GAP = 6000;
    private static final int BLUETOOTH_SCO_RESTART_MAX_TIMES = 3;
    private static final int BLUETOOTH_SCO_RESTART_TIME_GAP = 3000;
    private static final String TAG = "AudioRouteDeviceManager";
    private final Object bluetoothLock;
    private final Runnable bluetoothScoConnectionCheckRunnable;
    private int currentRouting;
    private boolean mAudioRouteEnable;
    private BluetoothAdapter mBluetoothAdapter;
    private MyBluetoothDevice mBluetoothDevice;
    private AudioDeviceCallback mBluetoothDeviceCallback;
    private String mBluetoothPermissionDesp;
    private int mBluetoothScoConnectCheckTimes;
    private int mBluetoothScoRestartTimes;
    private IAudioRouteCallback mCallback;
    private boolean mEnableUseAudioDeviceCallback;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private int mInitDeviceState;
    private IntentFilter mIntentFilter;
    private boolean mScoHasStarted;
    private UsbDevice mUsbHeadsetDevice;
    private boolean mUseAudioDeviceCallback;
    private String mWiredHeadsetDevice;
    private volatile boolean registered;

    public class BluetoothConnectCallback extends AudioDeviceCallback {
        final /* synthetic */ AudioRouteDeviceManager this$0;

        private BluetoothConnectCallback(AudioRouteDeviceManager r100) {
            this.this$0 = r100;
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] r110) {
            int r100 = r110.length;
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L37;
            AudioDeviceInfo r102 = r110[r101];
            if (r102.isSource() == true) goto L36;
            int r103 = r102.getType();
            if (r103 == 7) goto L10;
        L22:
            if (r103 != 8) goto L36;
            if (AudioRouteDeviceManager.access$200(this.this$0) == null) goto L36;
            String r104 = r102.getProductName().toString();
            RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: addedDevices: " + r103 + ", name: " + r104);
            Object r105 = AudioRouteDeviceManager.access$300(this.this$0);
            monitor-enter(r105);
            if (AudioRouteDeviceManager.access$400(this.this$0) != null) goto L30;
            AudioRouteDeviceManager r106 = this.this$0;     // Catch: Throwable -> L33
            AudioRouteDeviceManager.access$402(r106, new MyBluetoothDevice(r106, "bluetooth-headset"));     // Catch: Throwable -> L33
        L30:
            AudioRouteDeviceManager.access$400(this.this$0).appendDeviceInfo("callback", "[device:" + r104 + "] ");     // Catch: Throwable -> L33
            AudioRouteDeviceManager.access$400(this.this$0).setBluetoothConnected(2, true);     // Catch: Throwable -> L33
            String r107 = AudioRouteDeviceManager.access$400(this.this$0).getAttrsString();     // Catch: Throwable -> L33
            monitor-exit(r105);     // Catch: Throwable -> L33
            AudioRouteDeviceManager.access$200(this.this$0).onDeviceEvent(16, true, r107);
        L33:
            th = move-exception;
            throw th;
        L10:
            if (AudioRouteDeviceManager.access$200(this.this$0) == null) goto L22;
            String r108 = r102.getProductName().toString();
            RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: addedDevices: " + r103 + ", name: " + r108);
            Object r109 = AudioRouteDeviceManager.access$300(this.this$0);
            monitor-enter(r109);
            if (AudioRouteDeviceManager.access$400(this.this$0) != null) goto L16;
            AudioRouteDeviceManager r111 = this.this$0;     // Catch: Throwable -> L19
            AudioRouteDeviceManager.access$402(r111, new MyBluetoothDevice(r111, "bluetooth-headset"));     // Catch: Throwable -> L19
        L16:
            AudioRouteDeviceManager.access$400(this.this$0).appendDeviceInfo("callback", "[device:" + r108 + "] ");     // Catch: Throwable -> L19
            AudioRouteDeviceManager.access$400(this.this$0).setBluetoothConnected(1, true);     // Catch: Throwable -> L19
            String r112 = AudioRouteDeviceManager.access$400(this.this$0).getAttrsString();     // Catch: Throwable -> L19
            monitor-exit(r109);     // Catch: Throwable -> L19
            AudioRouteDeviceManager.access$502(this.this$0, 0);
            AudioRouteDeviceManager.access$200(this.this$0).onDeviceEvent(8, true, r112);
        L19:
            th = move-exception;
            throw th;
        L36:
            r101 = r101 + 1;
            goto L3
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] r110) {
            int r100 = r110.length;
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L56;
            AudioDeviceInfo r102 = r110[r101];
            if (r102.isSource() == true) goto L43;
            int r103 = r102.getType();
            if (r103 == 7) goto L10;
        L26:
            if (r103 != 8) goto L43;
            if (AudioRouteDeviceManager.access$200(this.this$0) == null) goto L43;
            RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: removedDevices: " + r103 + ", name: " + r102.getProductName());
            String r111 = "";
            Object r104 = AudioRouteDeviceManager.access$300(this.this$0);
            monitor-enter(r104);
        L40:
            th = move-exception;
            throw th;
        L32:
            if (AudioRouteDeviceManager.access$400(this.this$0) == null) goto L38;
            AudioRouteDeviceManager.access$400(this.this$0).setBluetoothConnected(2, false);     // Catch: Throwable -> L40
            r111 = AudioRouteDeviceManager.access$400(this.this$0).getAttrsString();     // Catch: Throwable -> L40
            if (AudioRouteDeviceManager.access$400(this.this$0).getBluetoothConnected(1) == true) goto L38;
            if (AudioRouteDeviceManager.access$400(this.this$0).getBluetoothConnected(2) == true) goto L38;
            RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected");     // Catch: Throwable -> L40
            AudioRouteDeviceManager.access$402(this.this$0, null);     // Catch: Throwable -> L40
        L38:
            monitor-exit(r104);     // Catch: Throwable -> L40
            AudioRouteDeviceManager.access$200(this.this$0).onDeviceEvent(16, false, r111);
            return;
        L10:
            if (AudioRouteDeviceManager.access$200(this.this$0) == null) goto L26;
            RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: removedDevices: " + r103 + ", name: " + r102.getProductName());
            String r112 = "";
            Object r105 = AudioRouteDeviceManager.access$300(this.this$0);
            monitor-enter(r105);
        L23:
            th = move-exception;
            throw th;
        L14:
            if (AudioRouteDeviceManager.access$400(this.this$0) == null) goto L20;
            AudioRouteDeviceManager.access$400(this.this$0).setBluetoothConnected(1, false);     // Catch: Throwable -> L23
            r112 = AudioRouteDeviceManager.access$400(this.this$0).getAttrsString();     // Catch: Throwable -> L23
            if (AudioRouteDeviceManager.access$400(this.this$0).getBluetoothConnected(1) == true) goto L20;
            if (AudioRouteDeviceManager.access$400(this.this$0).getBluetoothConnected(2) == true) goto L20;
            RXLogging.w(AudioRouteDeviceManager.TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected");     // Catch: Throwable -> L23
            AudioRouteDeviceManager.access$402(this.this$0, null);     // Catch: Throwable -> L23
        L20:
            AudioRouteDeviceManager.access$402(this.this$0, null);     // Catch: Throwable -> L23
            monitor-exit(r105);     // Catch: Throwable -> L23
            AudioRouteDeviceManager.access$200(this.this$0).onDeviceEvent(8, false, r112);
            return;
        L43:
            r101 = r101 + 1;
            goto L3
        }

        public /* synthetic */ BluetoothConnectCallback(AudioRouteDeviceManager r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public class MyBluetoothDevice {
        private boolean a2dpConnected;
        private BluetoothDevice bluetoothDevice;
        private String extraInfo;
        private boolean headsetConnected;
        private String name;
        final /* synthetic */ AudioRouteDeviceManager this$0;

        public String getAttrsString() {
            String r100 = "name:" + getName();
            StringBuilder r101 = new StringBuilder();
            r101.append(r100);
            r101.append(", headset:");
            String r102 = "true";
            if (this.headsetConnected == false) goto L5;
            String r103 = "true";
        L6:
            r101.append(r103);
            String r104 = r101.toString();
            StringBuilder r105 = new StringBuilder();
            r105.append(r104);
            r105.append(", a2dp:");
            if (this.a2dpConnected == true) goto L10;
            r102 = "false";
        L10:
            r105.append(r102);
            return r105.toString() + this.extraInfo;
        L5:
            r103 = "false";
            goto L6
        }

        public String getName() {
            if (this.bluetoothDevice == null) goto L5;
            return "bluetooth-headset";
        L5:
            return this.name;
        }

        public String toString() {
            return getName();
        }

        public boolean getBluetoothConnected(int r100) {
            if (r100 != 1) goto L7;
            return this.headsetConnected;
        L7:
            if (r100 == 2) goto L9;
            return false;
        L9:
            return this.a2dpConnected;
        }

        public MyBluetoothDevice(AudioRouteDeviceManager r100, BluetoothDevice r101) {
            this.this$0 = r100;
            this.extraInfo = "";
            this.headsetConnected = false;
            this.a2dpConnected = false;
            this.bluetoothDevice = r101;
        }

        public void appendDeviceInfo(String r100, String r101) {
            String r102 = " ,from:" + r100 + " " + r101;
            if (this.extraInfo.contains(r102) == true) goto L6;
            this.extraInfo += r102;
            return;
        }

        public void setBluetoothConnected(int r100, boolean r101) {
            if (r100 != 1) goto L6;
            this.headsetConnected = r101;
            return;
        L6:
            if (r100 != 2) goto L10;
            this.a2dpConnected = r101;
            return;
        }

        public MyBluetoothDevice(AudioRouteDeviceManager r100, String r101) {
            this.this$0 = r100;
            this.extraInfo = "";
            this.headsetConnected = false;
            this.a2dpConnected = false;
            this.name = r101;
        }
    }

    public @interface RoutingDeviceType {
        public static final int BLUETOOTH_A2DP = 16;
        public static final int BLUETOOTH_HEADSET = 8;
        public static final int BLUETOOTH_SCO = 64;
        public static final int BUILT_IN_EARPIECE = 1;
        public static final int BUILT_IN_SPEAKER = 2;
        public static final int UNKNOWN = -1;
        public static final int USB_HEADSET = 32;
        public static final int WIRED_HEADSET = 4;
    }

    public static /* synthetic */ void a(AudioRouteDeviceManager r100) {
        r100.restartBluetoothScoAsynTask();
    }

    public static /* synthetic */ void b(AudioRouteDeviceManager r100) {
        r100.bluetoothScoConnectionCheck();
    }

    public static /* synthetic */ void c(AudioRouteDeviceManager r100) {
        r100.bluetoothScoDisconnectionForNormalMode();
    }

    private String routingDeviceType2Text(int r100) {
        if (r100 != (-1)) goto L5;
        return "device-unknown";
    L5:
        if (r100 != 4) goto L7;
        return "device-wired-headset";
    L7:
        if (r100 != 8) goto L9;
        return "device-bt-headset";
    L9:
        if (r100 != 16) goto L11;
        return "device-bt-a2dp";
    L11:
        if (r100 != 32) goto L13;
        return "device-usb-headset";
    L13:
        if (r100 != 64) goto L15;
        return "device-bt-sco";
    L15:
        if (r100 != 1) goto L17;
        return "device-earpiece";
    L17:
        if (r100 == 2) goto L20;
        return "device-NA";
    L20:
        return "device-speaker";
    }

    public int release() {
        this.mCallback = null;
        Context r100 = AudioRouteUtil.getContext();
        if (r100 == null) goto L14;
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");
        if (r101 == null) goto L14;
        if (this.mAudioRouteEnable == false) goto L14;
        if (r101.isBluetoothScoOn() == false) goto L11;
    L12:
        stopSystemBluetoothSco(r101);
        goto L14
    L11:
        if (this.mScoHasStarted == true) goto L12;
    L14:
        if (unregisterReceiver() == 0) goto L16;
        RXLogging.e(TAG, "AudioRouteDeviceManager: unregisterReceiver failed.");
        int r102 = -1;
    L18:
        if (this.mHandler == null) goto L20;
        this.mHandler = null;
    L20:
        HandlerThread r103 = this.mHandlerThread;
        if (r103 == null) goto L23;
        r103.quit();
        this.mHandlerThread = null;
    L23:
        this.mBluetoothAdapter = null;
        this.mIntentFilter = null;
        this.mInitDeviceState = 0;
        Object r104 = this.bluetoothLock;
        monitor-enter(r104);
        this.mBluetoothDevice = null;     // Catch: Throwable -> L29
        monitor-exit(r104);     // Catch: Throwable -> L29
        this.mUsbHeadsetDevice = null;
        this.mWiredHeadsetDevice = null;
        this.currentRouting = -1;
        this.mEnableUseAudioDeviceCallback = false;
        this.mUseAudioDeviceCallback = false;
        return r102;
    L29:
        th = move-exception;
        throw th;
    L16:
        r102 = 0;
        goto L18
    }

    private void bluetoothScoConnectionCheck() {
        if (this.mCallback != null) goto L5;
        return;
    L5:
        Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L9;
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck failed. Context is null.");
        return;
    L9:
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");
        if (r101 != null) goto L14;
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck failed. AudioManager is null.");
        return;
    L14:
        if (this.mBluetoothScoConnectCheckTimes < 3) goto L21;
        if (this.mScoHasStarted == false) goto L18;
        stopSystemBluetoothSco(r101);
    L18:
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck timeout, time: " + this.mBluetoothScoConnectCheckTimes);
        this.mBluetoothScoConnectCheckTimes = -1;
        this.mHandler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
        this.mCallback.onError(AudioRouteController.EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE, "change to normal mode due to sco started timeout");
        return;
    L21:
        if (r101.isBluetoothScoOn() == false) goto L23;
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck success.");
        this.mBluetoothScoConnectCheckTimes = -1;
        this.mHandler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
        return;
    L23:
        this.mBluetoothScoConnectCheckTimes++;
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoConnectionCheck failed. retry again, time: " + this.mBluetoothScoConnectCheckTimes);
        startSystemBluetoothSco(r101);
        Handler r102 = this.mHandler;
        if (r102 == null) goto L28;
        r102.postDelayed(this.bluetoothScoConnectionCheckRunnable, 3000);
        return;
    }

    private boolean bluetoothScoIsStarting() {
        if (this.mHandler != null) goto L6;
        return false;
    L6:
        if (this.mBluetoothScoConnectCheckTimes < 0) goto L9;
        return true;
    L9:
        return false;
    }

    private void initBluetooth() {
        String[] r100 = {""};
        Object r101 = this.bluetoothLock;
        monitor-enter(r101);
        this.mBluetoothDevice = null;     // Catch: Throwable -> L63
        monitor-exit(r101);     // Catch: Throwable -> L63
        if (checkPermission() == false) goto L10;
        BluetoothAdapter r102 = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = r102;
        if (r102 != null) goto L66;
        return;
    L66:
    L46:
        th = th;
        boolean r103 = false;
    L48:
        RXLogging.e(TAG, "AudioRouteDeviceManager: getProfileConnectionState failed.", th);
        boolean r104 = r103;
        boolean r105 = false;
    L50:
        if (this.mUseAudioDeviceCallback == true) goto L52;
        this.mIntentFilter.addAction(ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED);
        this.mIntentFilter.addAction(ACTION_BT_A2DP_CONNECTION_STATE_CHANGED);
    L52:
        this.mIntentFilter.addAction(ACTION_BT_SCO_AUDIO_STATE_UPDATED);
    L53:
        if (r104 == true) goto L55;
        if (r105 == true) goto L55;
        return;
    L55:
        Object r106 = this.bluetoothLock;
        monitor-enter(r106);
        MyBluetoothDevice r107 = new MyBluetoothDevice(this, "bluetooth-headset[init]");     // Catch: Throwable -> L60
        this.mBluetoothDevice = r107;     // Catch: Throwable -> L60
        r107.appendDeviceInfo("init", r100[0]);     // Catch: Throwable -> L60
        this.mBluetoothDevice.setBluetoothConnected(1, r104);     // Catch: Throwable -> L60
        this.mBluetoothDevice.setBluetoothConnected(2, r105);     // Catch: Throwable -> L60
        monitor-exit(r106);     // Catch: Throwable -> L60
        return;
    L60:
        th = move-exception;
        throw th;
    L34:
        if (2 != r102.getProfileConnectionState(1)) goto L38;
        if (hasValidBtDeviceMajor(1, r100) == false) goto L38;
        boolean r108 = true;
    L70:
        if (2 != this.mBluetoothAdapter.getProfileConnectionState(2)) goto L42;
        boolean r109 = true;
    L43:
        r104 = r108;
        r105 = r109;
        goto L50
    L42:
        r109 = false;
    L44:
        th = move-exception;
        r103 = r108;
        th = th;
    L38:
        r108 = false;
        goto L70
    L10:
        if (this.mUseAudioDeviceCallback == false) goto L29;
        Context r110 = AudioRouteUtil.getContext();
        if (r110 != null) goto L14;
        return;
    L14:
        AudioManager r111 = (AudioManager) r110.getSystemService("audio");
        if (r111 != null) goto L17;
        return;
    L17:
        AudioDeviceInfo[] r112 = r111.getDevices(2);
        int r113 = r112.length;
        int r114 = 0;
        r104 = false;
        r105 = false;
    L18:
        if (r114 >= r113) goto L53;
        AudioDeviceInfo r115 = r112[r114];
        if (r115.isSource() == true) goto L28;
        if (7 != r115.getType()) goto L26;
        r104 = true;
        goto L28
    L26:
        if (8 != r115.getType()) goto L28;
        r105 = true;
    L28:
        r114 = r114 + 1;
        goto L18
    L29:
        r104 = false;
        r105 = false;
    L63:
        th = move-exception;
        throw th;
    }

    private void initHandler() {
        HandlerThread r100 = this.mHandlerThread;     // Catch: Exception -> L8
        if (r100 == null) goto L6;
        r100.quit();     // Catch: Exception -> L8
    L6:
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("AudioRouteDeviceManagerThread");     // Catch: Exception -> L8
        this.mHandlerThread = r101;     // Catch: Exception -> L8
        ThreadMethodProxy.start(r101);     // Catch: Exception -> L8
        Looper r102 = this.mHandlerThread.getLooper();     // Catch: Exception -> L8
    L13:
        if (r102 != null) goto L18;
        r102 = Looper.getMainLooper();
        if (r102 != null) goto L18;
        RXLogging.e(TAG, "AudioRouteDeviceManager: initHandler failed");
        return;
    L18:
        Handler r103 = new Handler(r102);
        this.mHandler = r103;
        r103.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
        RXLogging.e(TAG, "AudioRouteDeviceManager: initHandler success");
        return;
    L8:
        e = move-exception;
        RXLogging.e(TAG, "AudioRouteDeviceManager: AudioRouteDeviceManagerThread init failed, ", e);
        HandlerThread r104 = this.mHandlerThread;
        if (r104 == null) goto L12;
        r104.quit();
        this.mHandlerThread = null;
    L12:
        r102 = null;
        goto L13
    }

    private boolean initUsbHeadset() {
        Context r100 = AudioRouteUtil.getContext();     // Catch: Throwable -> L17
        if (r100 != null) goto L6;
        return false;
    L6:
        UsbManager r101 = (UsbManager) r100.getSystemService("usb");     // Catch: Throwable -> L17
        if (r101 != null) goto L9;
        return false;
    L9:
        HashMap<String, UsbDevice> r102 = r101.getDeviceList();     // Catch: Throwable -> L17
        Iterator<String> r103 = r102.keySet().iterator();     // Catch: Throwable -> L17
    L11:
        if (r103.hasNext() == false) goto L19;
        UsbDevice r104 = r102.get(r103.next());     // Catch: Throwable -> L17
        if (hasAudioForUsbDevice(r104) == false) goto L11;
        this.mUsbHeadsetDevice = r104;     // Catch: Throwable -> L17
        RXLogging.e(TAG, "AudioRouteDeviceManager: initUsbHeadset finished.");     // Catch: Throwable -> L17
        return true;
    L19:
        return false;
    L17:
        th = move-exception;
        RXLogging.e(TAG, "AudioRouteDeviceManager: initUsbHeadset failed.", th);
        goto L19
    }

    private int unregisterReceiver() {
        Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L7;
        return -1;
    L7:
        if (this.registered == true) goto L9;
        return 0;
    L9:
        this.registered = false;
        INVOKEVIRTUAL_com_ss_bytertc_audio_device_router_AudioRouteDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100, this);     // Catch: Exception -> L12
    L14:
        clearAbortBroadcast();
        if (this.mUseAudioDeviceCallback == false) goto L21;
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");
        if (r101 != null) goto L20;
        return -2;
    L20:
        r101.unregisterAudioDeviceCallback(this.mBluetoothDeviceCallback);
        this.mBluetoothDeviceCallback = null;
    L21:
        RXLogging.w(TAG, "AudioRouteDeviceManager: unregisterReceiver SkipBluetooth:" + this.mUseAudioDeviceCallback);
        return 0;
    L12:
        e = move-exception;
        RXLogging.e(TAG, "AudioRouteDeviceManager: unregisterReceiver failed", e);
        goto L14
    }

    public String getRenderDeviceName() {
        int r100 = this.currentRouting;
        if (r100 != 1) goto L5;
        return "earpiece";
    L5:
        if (r100 != 2) goto L7;
        return "built-in speaker";
    L7:
        if (r100 != 4) goto L9;
        String r101 = this.mWiredHeadsetDevice;
        if (r101 == null) goto L37;
        return r101;
    L37:
        return "failed_wired-headset";
    L9:
        if (r100 != 8) goto L11;
        MyBluetoothDevice r102 = this.mBluetoothDevice;
        if (r102 != null) goto L31;
        return "failed_bluetooth-headset";
    L31:
        return r102.getName();
    L11:
        if (r100 != 16) goto L13;
        MyBluetoothDevice r103 = this.mBluetoothDevice;
        if (r103 != null) goto L25;
        return "failed_bluetooth-a2dp";
    L25:
        return r103.getName();
    L13:
        if (r100 == 32) goto L16;
        return "failed_device_name";
    L16:
        UsbDevice r104 = this.mUsbHeadsetDevice;
        if (r104 != null) goto L19;
        return "failed_usb-headset";
    L19:
        return r104.getDeviceName();
    }

    public String getSessionInfo() {
        Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L6;
        return "Context is null";
    L6:
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");
        if (r101 != null) goto L11;
        return "AudioManager is null";
    L11:
        if (this.mCallback != null) goto L14;
        return "mCallback is null";
    L14:
        boolean r102 = true;
        boolean r103 = false;
        boolean r104 = r100.getPackageManager().hasSystemFeature("android.hardware.microphone");     // Catch: Exception -> L21
        if (ContextCompat.checkSelfPermission(r100, "android.permission.RECORD_AUDIO") != 0) goto L24;
        boolean r105 = true;
    L25:
        int r106 = r100.getApplicationInfo().targetSdkVersion;
        if (30 > r106) goto L31;
        if (r106 >= 34) goto L31;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.FOREGROUND_SERVICE") == 0) goto L38;
    L37:
        r102 = false;
    L38:
        r103 = r102;
    L46:
        return "{ Audio State: audio_mode:" + AudioRouteUtil.modeString(r101.getMode()) + ", has_mic:" + r104 + ", mic_muted:" + r101.isMicrophoneMute() + ", speakerphone:" + r101.isSpeakerphoneOn() + ", headset:" + r101.isWiredHeadsetOn() + ", bt_sco:" + r101.isBluetoothScoOn() + ", permission:" + r105 + ", foregroundServiceMic:" + r103 + ", bluetoothPermission:" + this.mBluetoothPermissionDesp + " }";
    L41:
        e = move-exception;
        String r107 = "getSessionInfo failed, exception: " + e.toString();
        RXLogging.e(TAG, "AudioRouteDeviceManager: " + r107);
        return r107;
    L31:
        if (34 > r106) goto L46;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.FOREGROUND_SERVICE") != 0) goto L37;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.FOREGROUND_SERVICE_MICROPHONE") != 0) goto L37;
    L24:
        r105 = false;
    L19:
        e = e;
    L23:
        RXLogging.e(TAG, "getSessionInfo failed to determine the availability of microphone " + e.toString());
    L21:
        e = e;
        r104 = false;
        goto L23
    }

    public int init() {
        IntentFilter r100 = new IntentFilter();
        this.mIntentFilter = r100;
        r100.addAction(ACTION_BT_STATE_CHANGED);
        this.mIntentFilter.addAction(ACTION_USB_DEVICE_ATTACHED);
        this.mIntentFilter.addAction(ACTION_USB_DEVICE_DETACHED);
        initHandler();
        if (initHeadset() == false) goto L6;
        this.mInitDeviceState += 4;
    L6:
        if (initUsbHeadset() == false) goto L8;
        this.mInitDeviceState += 32;
    L8:
        initBluetooth();
        MyBluetoothDevice r101 = this.mBluetoothDevice;
        if (r101 == null) goto L17;
        if (r101.getBluetoothConnected(1) == false) goto L14;
        this.mInitDeviceState += 8;
    L14:
        if (this.mBluetoothDevice.getBluetoothConnected(2) == false) goto L17;
        this.mInitDeviceState += 16;
    L17:
        if (registerReceiver() == 0) goto L20;
        release();
        return -2;
    L20:
        return 0;
    }

    public void stopBluetoothSco() {
        RXLogging.w(TAG, "AudioRouteDeviceManager: stopBluetoothSco begin.");
        if (this.mScoHasStarted == false) goto L9;
        Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L8;
        RXLogging.e(TAG, "stopBluetoothSco failed. Context is null.");
        return;
    L8:
        stopSystemBluetoothSco((AudioManager) r100.getSystemService("audio"));
    L9:
        this.mBluetoothScoConnectCheckTimes = -1;
        this.mHandler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
        RXLogging.w(TAG, "AudioRouteDeviceManager: stopBluetoothSco end, mBluetoothScoConnectCheckTimes: " + this.mBluetoothScoConnectCheckTimes);
    }

    private void bluetoothScoDisconnectionForNormalMode() {
        Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L6;
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoDisconnectionForNormalMode failed. Context is null.");
        return;
    L6:
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");
        if (r101 != null) goto L10;
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoDisconnectionForNormalMode failed. AudioManager is null.");
        return;
    L10:
        int r102 = r101.getMode();
        boolean r103 = r101.isBluetoothScoOn();
        RXLogging.e(TAG, "AudioRouteDeviceManager: bluetoothScoDisconnectionForNormalMode mode(" + r102 + "), bluetoothScoOn(" + r103 + ")");
        if (r102 != 0) goto L17;
        if (r103 == false) goto L14;
    L15:
        stopSystemBluetoothSco(r101);
        return;
    L14:
        if (this.mScoHasStarted == true) goto L15;
        return;
    }

    private boolean checkPermission() {
        Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        int r102 = r100.getApplicationInfo().targetSdkVersion;
        if (r101 < 23) goto L10;
        if (r102 < 23) goto L10;
        this.mUseAudioDeviceCallback = this.mEnableUseAudioDeviceCallback;
        RXLogging.w(TAG, "AudioRouteDeviceManager: mUseAudioDeviceCallback: " + this.mUseAudioDeviceCallback);
    L10:
        if (r101 < 31) goto L19;
        if (r102 < 31) goto L19;
        if (r100.checkCallingOrSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0) goto L16;
        this.mBluetoothPermissionDesp = "[permission android.permission.BLUETOOTH_CONNECT not be granted. osVersion:" + r101 + ", targetVersion:" + r102 + " ]";
        StringBuilder r103 = new StringBuilder("AudioRouteDeviceManager: ");
        r103.append(this.mBluetoothPermissionDesp);
        RXLogging.e(TAG, r103.toString());
        return false;
    L16:
        this.mBluetoothPermissionDesp = "[permission android.permission.BLUETOOTH_CONNECT granted. osVersion:" + r101 + ", targetVersion:" + r102 + " ]";
        StringBuilder r104 = new StringBuilder("AudioRouteDeviceManager: ");
        r104.append(this.mBluetoothPermissionDesp);
        RXLogging.w(TAG, r104.toString());
        return true;
    L19:
        if (r100.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0) goto L22;
        String r105 = "[permission android.permission.BLUETOOTH not be granted. osVersion:" + r101 + ", targetVersion:" + r102 + " ]";
        this.mBluetoothPermissionDesp = r105;
        RXLogging.e(TAG, r105);
        return false;
    L22:
        this.mBluetoothPermissionDesp = "[permission android.permission.BLUETOOTH granted. osVersion:" + r101 + ", targetVersion:" + r102 + " ]";
        StringBuilder r106 = new StringBuilder("AudioRouteDeviceManager: ");
        r106.append(this.mBluetoothPermissionDesp);
        RXLogging.w(TAG, r106.toString());
        return true;
    }

    private boolean initHeadset() {
        Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L17;
        return false;
    L17:
        Intent r101 = INVOKEVIRTUAL_com_ss_bytertc_audio_device_router_AudioRouteDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, this, new IntentFilter(ACTION_HEADSET_PLUG));     // Catch: Exception -> L7
    L9:
        if (r101 != null) goto L12;
        return false;
    L12:
        if (headsetPlugActionIsFromUsbHeadset(r101) == false) goto L14;
        return false;
    L14:
        if (1 != r101.getIntExtra("state", -99)) goto L20;
        return true;
    L20:
        return false;
    L7:
        e = move-exception;
        RXLogging.e(TAG, "AudioRouteDeviceManager: registerReceiver failed for ACTION_HEADSET_PLUG", e);
        r101 = null;
        goto L9
    }

    private int registerReceiver() {
        Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L7;
        return -1;
    L7:
        if (this.registered == false) goto L10;
        RXLogging.i(TAG, "registerReceiver registered");
        return 0;
    L10:
        this.registered = true;
        INVOKEVIRTUAL_com_ss_bytertc_audio_device_router_AudioRouteDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, this, this.mIntentFilter);     // Catch: Exception -> L13
    L16:
        if (this.mUseAudioDeviceCallback == false) goto L22;
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");
        if (r101 != null) goto L21;
        return -2;
    L21:
        BluetoothConnectCallback r102 = new BluetoothConnectCallback(this, null);
        this.mBluetoothDeviceCallback = r102;
        r101.registerAudioDeviceCallback(r102, null);
    L22:
        RXLogging.w(TAG, "AudioRouteDeviceManager: registerReceiver SkipBluetooth:" + this.mUseAudioDeviceCallback);
        return 0;
    L13:
        e = move-exception;
        RXLogging.e(TAG, "AudioRouteDeviceManager: registerReceiver failed", e);
        this.registered = false;
        goto L16
    }

    private void restartBluetoothScoAsynTask() {
        RXLogging.w(TAG, "restartBluetoothScoAsynTask enter.");
        if (this.mBluetoothDevice == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L10;
        RXLogging.w(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask skip, no bluetooth device now.");
        return;
    L10:
        if (bluetoothScoIsStarting() == false) goto L13;
        RXLogging.w(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask skip. sco is starting.");
        return;
    L13:
        Context r101 = AudioRouteUtil.getContext();
        if (r101 != null) goto L17;
        RXLogging.e(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask failed. Context is null.");
        return;
    L17:
        AudioManager r102 = (AudioManager) r101.getSystemService("audio");
        if (r102 != null) goto L21;
        RXLogging.e(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask failed. AudioManager is null.");
        return;
    L21:
        startSystemBluetoothSco(r102);
        RXLogging.w(TAG, "AudioRouteDeviceManager: restartBluetoothScoAsynTask has start bluetooth.");
        return;
    L5:
        r100 = false;
        goto L6
    }

    public String getCaptureDeviceName() {
        return getRenderDeviceName();
    }

    public void restartBluetoothSco() {
        RXLogging.w(TAG, "restartBluetoothSco enter.");
        if (this.mBluetoothDevice == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        RXLogging.w(TAG, "restartBluetoothSco skip, no bluetooth device now.");
        this.mHandler.removeCallbacks(new c(this));
        return;
    L9:
        Context r101 = AudioRouteUtil.getContext();
        if (r101 != null) goto L13;
        RXLogging.e(TAG, "restartBluetoothSco failed. Context is null.");
        return;
    L13:
        AudioManager r102 = (AudioManager) r101.getSystemService("audio");
        if (r102 != null) goto L18;
        RXLogging.e(TAG, "restartBluetoothSco failed. AudioManager is null.");
        return;
    L18:
        if (3 == r102.getMode()) goto L22;
        RXLogging.e(TAG, "restartBluetoothSco failed. Not in communication mode.");
        return;
    L22:
        if (bluetoothScoIsStarting() == false) goto L25;
        RXLogging.w(TAG, "restartBluetoothSco skip. sco is starting.");
        return;
    L25:
        int r103 = this.mBluetoothScoRestartTimes + 1;
        this.mBluetoothScoRestartTimes = r103;
        if (r103 > 3) goto L33;
        RXLogging.w(TAG, "restartBluetoothScoAsynTask, restart time: " + this.mBluetoothScoRestartTimes);
        if (r102.isBluetoothScoOn() == true) goto L38;
        Handler r104 = this.mHandler;
        if (r104 == null) goto L38;
        r104.postDelayed(new c(this), 3000);
    L38:
        RXLogging.w(TAG, "restartBluetoothSco leave.");
        return;
    L33:
        if (this.mScoHasStarted == false) goto L35;
        stopSystemBluetoothSco(r102);
    L35:
        IAudioRouteCallback r105 = this.mCallback;
        if (r105 == null) goto L38;
        r105.onError(AudioRouteController.EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE, "change to normal mode due to sco restart timeout");
        goto L38
    L5:
        r100 = false;
        goto L6
    }

    public int getDeviceState() {
        return this.mInitDeviceState;
    }

    public AudioRouteDeviceManager(IAudioRouteCallback r100) {
        this.registered = false;
        this.mAudioRouteEnable = true;
        this.mInitDeviceState = 0;
        this.mBluetoothScoConnectCheckTimes = -1;
        this.mBluetoothScoRestartTimes = 0;
        this.mScoHasStarted = false;
        this.bluetoothScoConnectionCheckRunnable = new a(this);
        this.mBluetoothPermissionDesp = "NULL";
        this.currentRouting = -1;
        this.mEnableUseAudioDeviceCallback = false;
        this.mUseAudioDeviceCallback = false;
        this.bluetoothLock = new Object();
        this.mCallback = r100;
    }

    public static /* synthetic */ IAudioRouteCallback access$200(AudioRouteDeviceManager r100) {
        return r100.mCallback;
    }

    public static /* synthetic */ Object access$300(AudioRouteDeviceManager r100) {
        return r100.bluetoothLock;
    }

    public static /* synthetic */ MyBluetoothDevice access$400(AudioRouteDeviceManager r100) {
        return r100.mBluetoothDevice;
    }

    private boolean hasAudioForUsbDevice(UsbDevice r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r100.getConfigurationCount()) goto L22;
        UsbConfiguration r102 = r100.getConfiguration(r101);
        if (r102 == null) goto L21;
        int r103 = 0;
    L13:
        if (r103 >= r102.getInterfaceCount()) goto L21;
        UsbInterface r104 = r102.getInterface(r103);
        if (r104 == null) goto L20;
        if (r104.getInterfaceClass() != 1) goto L20;
        return true;
    L20:
        r103 = r103 + 1;
    L21:
        r101 = r101 + 1;
        goto L7
    L22:
        return false;
    }

    private boolean headsetPlugActionIsFromUsbHeadset(Intent r100) {
        String r101 = r100.getStringExtra("address");
        String r102 = r100.getStringExtra("portName");
        RXLogging.w(TAG, "ACTION_HEADSET_PLUG info, address: " + r101 + ", portName: " + r102 + ", connected: " + r100.getIntExtra("state", -99) + ", hasMic: " + r100.getIntExtra("microphone", -99));
        if ("".equals(r101) == false) goto L5;
        return false;
    L5:
        if ("".equals(r102) == true) goto L15;
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.startsWith("USB") == false) goto L10;
    L11:
        RXLogging.e(TAG, "AudioRouteDeviceManager: received ACTION_HEADSET_PLUG, may be is a usb device");
        return true;
    L10:
        if (r102.startsWith("usb") == true) goto L11;
        return false;
    L15:
        return false;
    }

    private void startSystemBluetoothSco(AudioManager r100) {
        if (r100 != null) goto L10;
        RXLogging.e(TAG, "AudioRouteDeviceManager: startSystemBluetoothSco skipped, audioManager is null");
        return;
    L10:
        r100.startBluetoothSco();     // Catch: Exception -> L6
        this.mScoHasStarted = true;     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        RXLogging.e(TAG, "AudioRouteDeviceManager: startSystemBluetoothSco failed, Exception: " + e.toString());
    }

    private void stopSystemBluetoothSco(AudioManager r100) {
        if (r100 != null) goto L10;
        RXLogging.e(TAG, "AudioRouteDeviceManager: stopSystemBluetoothSco skipped, audioManager is null");
        return;
    L10:
        r100.stopBluetoothSco();     // Catch: Exception -> L6
        r100.setBluetoothScoOn(false);     // Catch: Exception -> L6
        this.mScoHasStarted = false;     // Catch: Exception -> L6
        RXLogging.i(TAG, "AudioRouteDeviceManager: stopSystemBluetoothSco begin.");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        RXLogging.e(TAG, "AudioRouteDeviceManager: stopSystemBluetoothSco failed, Exception: " + e.toString());
    }

    public void setAudioRouteEnable(boolean r100) {
        this.mAudioRouteEnable = r100;
        RXLogging.w(TAG, "AudioRouteDeviceManager: setAudioRouteEnable:" + r100);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_bytertc_audio_device_router_AudioRouteDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ MyBluetoothDevice access$402(AudioRouteDeviceManager r100, MyBluetoothDevice r101) {
        r100.mBluetoothDevice = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(AudioRouteDeviceManager r100, int r101) {
        r100.mBluetoothScoRestartTimes = r101;
        return r101;
    }

    private boolean hasValidBtDeviceMajor(int r110, final String[] r111) {
        if (this.mBluetoothAdapter != null) goto L5;
        return false;
    L5:
        final Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L8;
        return false;
    L8:
        final Object r101 = new Object();
        final boolean[] r102 = {true};
        if (r110 != 1) goto L22;
        this.mBluetoothAdapter.getProfileProxy(r100, new AnonymousClass1(this, r100, r111, r102, r101), r110);     // Catch: Throwable -> L19
        monitor-enter(r101);     // Catch: Throwable -> L19
        r101.wait(300);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        RXLogging.e(TAG, "AudioRouteDeviceManager: hasValidBtDeviceMajor failed.", th);
    L22:
        return r102[0];
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r110, Intent r111) {
        if (r111 != null) goto L5;
        return;
    L5:
        String r100 = r111.getAction();
        if (r100 != null) goto L9;
        RXLogging.e(TAG, "AudioRouteDeviceManager: action is null");
        return;
    L9:
        String r101 = "";
        int r102 = 16;
        boolean r112 = false;
        if (r100.equals(ACTION_BT_STATE_CHANGED) == false) goto L32;
        int r103 = r111.getIntExtra("android.bluetooth.adapter.extra.STATE", -99);
        BluetoothDevice r104 = (BluetoothDevice) r111.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r103 != 10) goto L14;
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_STATE_CHANGED:STATE_OFF:" + this.mBluetoothDevice);
        IAudioRouteCallback r105 = this.mCallback;
        if (r105 == null) goto L21;
        r105.onDeviceEvent(8, false, "");
        this.mCallback.onDeviceEvent(16, false, "");
    L21:
        Object r106 = this.bluetoothLock;
        monitor-enter(r106);
    L28:
        th = move-exception;
        throw th;
    L24:
        if (this.mBluetoothDevice == null) goto L26;
        RXLogging.w(TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to bluetooth adapter is closed: " + r104);     // Catch: Throwable -> L28
        this.mBluetoothDevice = null;     // Catch: Throwable -> L28
    L26:
        monitor-exit(r106);     // Catch: Throwable -> L28
        return;
    L14:
        if (r103 != 12) goto L17;
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_STATE_CHANGED:STATE_ON:" + r104);
    L17:
        boolean r107 = false;
        boolean r108 = false;
        r102 = 8;
    L170:
        StringBuilder r109 = new StringBuilder("AudioRouteDeviceManager: received action:");
        r109.append(r100);
        r109.append(" state:");
        r109.append(r103);
        r109.append(" needReport:");
        r109.append(r108);
        r109.append(", mCallback:");
        if (this.mCallback == null) goto L173;
        r112 = true;
    L173:
        r109.append(r112);
        r109.append(", deviceType:");
        r109.append(r102);
        r109.append(", connectedStatus:");
        r109.append(r107);
        RXLogging.w(TAG, r109.toString());
        if (r108 == false) goto L193;
        IAudioRouteCallback r113 = this.mCallback;
        if (r113 == null) goto L194;
        r113.onDeviceEvent(r102, r107, r101);
        return;
    L194:
        return;
    L193:
        return;
    L32:
        if (r100.equals(ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED) == false) goto L72;
        int r114 = r111.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
        BluetoothDevice r115 = (BluetoothDevice) r111.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r114 == 0) goto L55;
        if (r114 == 1) goto L54;
        if (r114 == 2) goto L39;
        if (r114 == 3) goto L54;
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED, unknown state: " + r114);
        goto L54
    L39:
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED:STATE_CONNECTED:" + r115);
        String[] r116 = {""};
        if (r115 == null) goto L54;
        if (isBtDeviceMajorValid(r110, 1, r115, r116) == false) goto L54;
        Object r117 = this.bluetoothLock;
        monitor-enter(r117);
    L51:
        th = move-exception;
        throw th;
    L46:
        if (this.mBluetoothDevice != null) goto L48;
        this.mBluetoothDevice = new MyBluetoothDevice(this, r115);     // Catch: Throwable -> L51
    L48:
        this.mBluetoothDevice.appendDeviceInfo("broadcast", r116[0]);     // Catch: Throwable -> L51
        this.mBluetoothDevice.setBluetoothConnected(1, true);     // Catch: Throwable -> L51
        String r118 = this.mBluetoothDevice.getAttrsString();     // Catch: Throwable -> L51
        monitor-exit(r117);     // Catch: Throwable -> L51
        this.mBluetoothScoRestartTimes = 0;
        r101 = r118;
        boolean r119 = true;
    L66:
        boolean r120 = true;
    L67:
        r102 = 8;
        boolean r121 = r120;
        r107 = r119;
        r103 = r114;
        r108 = r121;
    L54:
        r119 = false;
        r120 = false;
        goto L67
    L55:
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_HEADSET_CONNECTION_STATE_CHANGED:STATE_DISCONNECTED:" + r115);
        Object r122 = this.bluetoothLock;
        monitor-enter(r122);
        MyBluetoothDevice r123 = this.mBluetoothDevice;     // Catch: Throwable -> L68
        if (r123 == null) goto L64;
        r123.setBluetoothConnected(1, false);     // Catch: Throwable -> L68
        r101 = this.mBluetoothDevice.getAttrsString();     // Catch: Throwable -> L68
        if (this.mBluetoothDevice.getBluetoothConnected(1) == true) goto L64;
        if (this.mBluetoothDevice.getBluetoothConnected(2) == true) goto L64;
        RXLogging.w(TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected" + r115);     // Catch: Throwable -> L68
        this.mBluetoothDevice = null;     // Catch: Throwable -> L68
    L64:
        monitor-exit(r122);     // Catch: Throwable -> L68
        r119 = false;
    L68:
        th = move-exception;
        throw th;
    L72:
        if (r100.equals(ACTION_BT_A2DP_CONNECTION_STATE_CHANGED) == false) goto L110;
        int r124 = r111.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
        BluetoothDevice r125 = (BluetoothDevice) r111.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r124 == 0) goto L93;
        if (r124 == 1) goto L92;
        if (r124 == 2) goto L79;
        if (r124 == 3) goto L92;
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_A2DP_CONNECTION_STATE_CHANGED, unknown state: " + r124);
        goto L92
    L79:
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_A2DP_CONNECTION_STATE_CHANGED:STATE_CONNECTED:" + r125);
        String[] r126 = {""};
        Object r127 = this.bluetoothLock;
        monitor-enter(r127);
        if (r125 != null) goto L181;
        boolean r128 = false;
        boolean r129 = false;
    L87:
        monitor-exit(r127);     // Catch: Throwable -> L89
    L105:
        r108 = r129;
        r107 = r128;
        r103 = r124;
    L89:
        th = move-exception;
        throw th;
    L181:
        if (this.mBluetoothDevice != null) goto L85;
        this.mBluetoothDevice = new MyBluetoothDevice(this, r125);     // Catch: Throwable -> L89
    L85:
        isBtDeviceMajorValid(r110, 2, r125, r126);     // Catch: Throwable -> L89
        this.mBluetoothDevice.appendDeviceInfo("broadcast", r126[0]);     // Catch: Throwable -> L89
        this.mBluetoothDevice.setBluetoothConnected(2, true);     // Catch: Throwable -> L89
        String r130 = this.mBluetoothDevice.getAttrsString();     // Catch: Throwable -> L89
        this.mBluetoothScoRestartTimes = 0;     // Catch: Throwable -> L89
        r101 = r130;
        r128 = true;
        r129 = true;
    L92:
        r128 = false;
        r129 = false;
        goto L105
    L93:
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_BT_A2DP_CONNECTION_STATE_CHANGED:STATE_DISCONNECTED:" + r125);
        Object r131 = this.bluetoothLock;
        monitor-enter(r131);
        MyBluetoothDevice r132 = this.mBluetoothDevice;     // Catch: Throwable -> L106
        if (r132 == null) goto L103;
        r132.setBluetoothConnected(2, false);     // Catch: Throwable -> L106
        String r133 = this.mBluetoothDevice.getAttrsString();     // Catch: Throwable -> L106
        if (this.mBluetoothDevice.getBluetoothConnected(1) == false) goto L100;
    L102:
        r101 = r133;
        goto L103
    L100:
        if (this.mBluetoothDevice.getBluetoothConnected(2) == true) goto L102;
        RXLogging.w(TAG, "AudioRouteDeviceManager: destroy mBluetoothDevice due to headset & a2dp disconncected" + r125);     // Catch: Throwable -> L106
        this.mBluetoothDevice = null;     // Catch: Throwable -> L106
    L103:
        monitor-exit(r131);     // Catch: Throwable -> L106
        r128 = false;
        r129 = true;
    L106:
        th = move-exception;
        throw th;
    L110:
        if (r100.equals(ACTION_BT_SCO_AUDIO_STATE_UPDATED) == false) goto L137;
        r103 = r111.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -99);
        if (r103 == 0) goto L125;
        if (r103 == 1) goto L115;
        r107 = false;
        r108 = false;
    L133:
        r102 = 64;
        goto L170
    L115:
        RXLogging.w(TAG, "AudioRouteDeviceManager: SCO_AUDIO_STATE_CONNECTED");
        Object r134 = this.bluetoothLock;
        monitor-enter(r134);
        MyBluetoothDevice r135 = this.mBluetoothDevice;     // Catch: Throwable -> L122
        if (r135 == null) goto L120;
        r101 = r135.getAttrsString();     // Catch: Throwable -> L122
    L120:
        monitor-exit(r134);     // Catch: Throwable -> L122
        r107 = true;
    L132:
        r108 = true;
    L122:
        th = move-exception;
        throw th;
    L125:
        RXLogging.w(TAG, "AudioRouteDeviceManager: SCO_AUDIO_STATE_DISCONNECTED");
        Object r136 = this.bluetoothLock;
        monitor-enter(r136);
        MyBluetoothDevice r137 = this.mBluetoothDevice;     // Catch: Throwable -> L134
        if (r137 == null) goto L130;
        r101 = r137.getAttrsString();     // Catch: Throwable -> L134
    L130:
        monitor-exit(r136);     // Catch: Throwable -> L134
        r107 = false;
    L134:
        th = move-exception;
        throw th;
    L137:
        r102 = 32;
        if (r100.equals(ACTION_USB_DEVICE_ATTACHED) == false) goto L145;
        UsbDevice r138 = (UsbDevice) r111.getParcelableExtra("device");
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_USB_DEVICE_ATTACHED:" + r138);
        if (hasAudioForUsbDevice(r138) == false) goto L142;
        this.mUsbHeadsetDevice = r138;
        boolean r139 = true;
    L143:
        r108 = r139;
        r103 = LossFocusType.UNKNOWN_FOCUS_CHANGE;
        r107 = true;
        goto L170
    L142:
        r139 = false;
        goto L143
    L145:
        if (r100.equals(ACTION_USB_DEVICE_DETACHED) == false) goto L152;
        UsbDevice r140 = (UsbDevice) r111.getParcelableExtra("device");
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_USB_DEVICE_DETACHED:" + r140);
        if (hasAudioForUsbDevice(r140) == false) goto L149;
        this.mUsbHeadsetDevice = null;
        boolean r141 = true;
    L150:
        r108 = r141;
        r103 = LossFocusType.UNKNOWN_FOCUS_CHANGE;
        r107 = false;
        goto L170
    L149:
        r141 = false;
        goto L150
    L152:
        if (r100.equals(ACTION_HEADSET_PLUG) == true) goto L154;
        r102 = -1;
        r103 = LossFocusType.UNKNOWN_FOCUS_CHANGE;
        r107 = false;
        r108 = false;
        goto L170
    L154:
        if (headsetPlugActionIsFromUsbHeadset(r111) == false) goto L157;
        return;
    L157:
        if (r111.getIntExtra("state", -99) != 1) goto L159;
        boolean r142 = true;
    L161:
        if (r142 == false) goto L163;
        String r143 = PTYSocketStateCallback.CONNECTED;
    L164:
        RXLogging.w(TAG, "AudioRouteDeviceManager: ACTION_HEADSET_PLUG:".concat(r143));
        if (r142 == false) goto L167;
        this.mWiredHeadsetDevice = "wired-headset";
    L168:
        r102 = 4;
        r107 = r142;
        r103 = LossFocusType.UNKNOWN_FOCUS_CHANGE;
        r108 = true;
        goto L170
    L167:
        this.mWiredHeadsetDevice = null;
        goto L168
    L163:
        r143 = "disconnected";
        goto L164
    L159:
        r142 = false;
        goto L161
    }

    public int setAudioRoute(int r110, boolean r111) {
        Context r100 = AudioRouteUtil.getContext();
        if (r100 != null) goto L6;
        RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. Context is null.");
        return -1;
    L6:
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");
        if (r101 != null) goto L11;
        RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. AudioManager is null.");
        return -2;
    L11:
        if (this.mCallback != null) goto L14;
        RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. mCallback is null.");
        return -6;
    L14:
        int r102 = r101.getMode();
        if (r111 == false) goto L17;
        int r103 = 0;
    L19:
        if (r103 == r102) goto L21;
        RXLogging.e(TAG, "AudioRouteDeviceManager: isMediaMode:" + r111 + ", cacheMode:" + r103 + ", systemMode: " + r102 + " not matched with system!!!");
        r101.setMode(r103);
        r102 = r101.getMode();
    L21:
        boolean r112 = r101.isSpeakerphoneOn();
        boolean r104 = r101.isBluetoothScoOn();
        RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute, deviceType: " + routingDeviceType2Text(r110) + ", cacheMode:" + r103 + ", systemMode: " + r102 + ", speakerPhoneOn: " + r112 + ", bluetoothScoOn: " + r104);
        if (r102 == 3) goto L24;
        if (r102 != 0) goto L73;
        if (r104 == false) goto L61;
    L62:
        RXLogging.w(TAG, "AudioRouteDeviceManager: MODE_NORMAL,but BluetoothScoOn is true, force to close sco.");
        stopSystemBluetoothSco(r101);
    L63:
        Handler r105 = this.mHandler;
        if (r105 == null) goto L66;
        r105.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
        this.mHandler.removeCallbacks(new b(this));
        this.mHandler.postDelayed(new b(this), RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
    L66:
        if (r110 != 2) goto L69;
        if (r112 == true) goto L72;
        r101.setSpeakerphoneOn(true);
    L72:
        return 0;
    L69:
        if (r110 != 1) goto L72;
        if (r112 == false) goto L72;
        r101.setSpeakerphoneOn(false);
        goto L72
    L61:
        if (this.mScoHasStarted == false) goto L63;
    L73:
        RXLogging.e(TAG, "AudioRouteDeviceManager: mode(" + r102 + ") is not support to setAudioRoute");
        return -4;
    L24:
        if (r110 != 8) goto L35;
        boolean r113 = bluetoothScoIsStarting();
        StringBuilder r106 = new StringBuilder("AudioRouteDeviceManager: need to start bluetooth sco in communication mode, sco is starting: ");
        r106.append(r113);
        if (r113 == false) goto L28;
        String r107 = ", skip start sco";
    L29:
        r106.append(r107);
        RXLogging.w(TAG, r106.toString());
        if (r104 == true) goto L56;
        if (r113 == true) goto L56;
        RXLogging.w(TAG, "AudioRouteDeviceManager: ready to start sco");
        this.mBluetoothScoConnectCheckTimes = 0;
        startSystemBluetoothSco(r101);
        Handler r114 = this.mHandler;
        if (r114 == null) goto L56;
        r114.removeCallbacks(new b(this));
        this.mHandler.removeCallbacks(this.bluetoothScoConnectionCheckRunnable);
        this.mHandler.postDelayed(this.bluetoothScoConnectionCheckRunnable, 3000);
    L56:
        this.currentRouting = r110;
        return 0;
    L28:
        r107 = ", continue start sco";
        goto L29
    L35:
        if (r104 == false) goto L37;
    L38:
        stopSystemBluetoothSco(r101);
    L39:
        if (r110 != 2) goto L42;
        if (r112 == true) goto L56;
        r101.setSpeakerphoneOn(true);
        goto L56
    L42:
        if (r110 != 1) goto L44;
    L54:
        if (r112 == false) goto L56;
        r101.setSpeakerphoneOn(false);
        goto L56
    L44:
        if (r110 == 4) goto L54;
        if (r110 == 32) goto L54;
        if (r110 != 16) goto L52;
        RXLogging.e(TAG, "AudioRouteDeviceManager: Error: setAudioRoute to a2dp in communication mode");
        return -7;
    L52:
        RXLogging.e(TAG, "AudioRouteDeviceManager: setAudioRoute failed. deviceType(" + routingDeviceType2Text(r110) + ") invalid.");
        return -3;
    L37:
        if (this.mScoHasStarted == false) goto L39;
    L17:
        r103 = 3;
        goto L19
    }

    public void setUseAudioDeviceCallback(boolean r100, IAudioRouteCallback r101) {
        this.mEnableUseAudioDeviceCallback = r100;
        this.mCallback = r101;
        RXLogging.w(TAG, "AudioRouteDeviceManager: setUseAudioDeviceCallback:" + r100);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_bytertc_audio_device_router_AudioRouteDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    private boolean isBtDeviceMajorValid(Context r100, int r101, BluetoothDevice r102, String[] r103) {
        if (r100 == null) goto L31;
        if (r102 == null) goto L31;
        int r104 = Build.VERSION.SDK_INT;
        int r105 = r100.getApplicationInfo().targetSdkVersion;
        if (r104 < 31) goto L14;
        if (r105 < 31) goto L14;
        if (r100.checkCallingOrSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) goto L12;
    L11:
        boolean r106 = true;
    L16:
        if (r106 == true) goto L32;
    L30:
        return true;
    L32:
        String r107 = r102.getName();     // Catch: Throwable -> L28
        BluetoothClass r108 = r102.getBluetoothClass();     // Catch: Throwable -> L28
        if (r108 != null) goto L20;
        return false;
    L20:
        int r109 = r108.getMajorDeviceClass();     // Catch: Throwable -> L28
        r103[0] = r103[0] + "[device:" + r107 + ", majorClass:" + r109 + "] ";     // Catch: Throwable -> L28
        if (r101 != 1) goto L30;
        if (r109 != 1792) goto L25;
        return false;
    L25:
        if (r109 == 7936) goto L35;
        return true;
    L35:
        return false;
    L28:
        th = move-exception;
        RXLogging.e(TAG, "AudioRouteDeviceManager: isBtDeviceMajorValid failed.", th);
    L12:
        r106 = false;
    L14:
        if (r100.checkCallingOrSelfPermission("android.permission.BLUETOOTH") != 0) goto L12;
    L31:
        return false;
    }

    public static /* synthetic */ boolean access$000(AudioRouteDeviceManager r100, Context r101, int r102, BluetoothDevice r103, String[] r104) {
        return r100.isBtDeviceMajorValid(r101, r102, r103, r104);
    }
}
