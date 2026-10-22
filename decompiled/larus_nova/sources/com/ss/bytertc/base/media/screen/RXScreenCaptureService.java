package com.ss.bytertc.base.media.screen;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class RXScreenCaptureService extends Service {
    private static final String ACTION = "ACTION";
    public static final int COMMAND_AUDIO_DISPOSE = 8;
    public static final int COMMAND_AUDIO_START = 6;
    public static final int COMMAND_AUDIO_STOP = 7;
    public static final int COMMAND_CHANGE_CAPTURE_FORMAT = 3;
    public static final int COMMAND_DISPOSE = 5;
    public static final int COMMAND_INVALID = -1;
    public static final int COMMAND_LAUNCH = 0;
    public static final int COMMAND_ON_FRAME = 4;
    public static final int COMMAND_START = 1;
    public static final int COMMAND_STOP = 2;
    public static final int COMMAND_STOP_SERVICE = 9;
    private static final String DATA = "DATA";
    public static final String KEY_CONTENT_TEXT = "contentText";
    public static final String KEY_HASHCODE = "hc";
    public static final String KEY_HEIGHT = "h";
    public static final String KEY_IFRAMERATE = "if";
    public static final String KEY_INDEX = "i";
    public static final String KEY_LARGE_ICON = "largei";
    public static final String KEY_LAUNCH_ACTIVITY = "activity";
    public static final String KEY_MIN_FRAMERATE = "minfr";
    public static final String KEY_PICO_CREATE_MEDIA_PROJECTION = "pico_create_media_projection";
    public static final String KEY_PICO_NEED_CAPTURE_2D_TEXTURE = "pico_need_capture_2d_texture";
    public static final String KEY_PICO_NOT_CHECK_ORIENTATION = "pico_not_check_orientation";
    public static final String KEY_PICO_VIRTUAL_DISPLAY_DPI = "pico_virtual_display_dpi";
    public static final String KEY_PICO_VIRTUAL_DISPLAY_FLAG = "pico_virtual_display_flags";
    public static final String KEY_PICO_VIRTUAL_DISPLAY_NAME = "pico_virtual_display_name";
    public static final String KEY_RESULT_DATA = "PermissionResult";
    public static final String KEY_SMALL_ICON = "largei";
    public static final String KEY_WIDTH = "w";
    public static final String METHOD_PICO_CREATE_MEDIA_PROJECTION = "createMediaProjection";
    private static final String TAG = "RXScreenCaptureService";
    public static AtomicBoolean serviceStarted;
    String mContentText;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    int mLargeIcon;
    String mLaunchActivity;
    private MediaProjection mMediaProjection;
    private MediaProjectionManager mMediaProjectionManager;
    private Intent mPermissionReulstData;
    private boolean mPicoCreateMediaProjection;
    int mSmallIcon;

    public static /* synthetic */ void a(RXScreenCaptureService r100) {
        r100.lambda$stop$7();
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ void b() {
        lambda$audioDispose$6();
    }

    public static /* synthetic */ void c(RXScreenCaptureService r100) {
        r100.lambda$startAudioCapture$4();
    }

    public static /* synthetic */ void d(int r100, int r101, int r102) {
        lambda$changeCaptureFormat$2(r100, r101, r102);
    }

    public static /* synthetic */ void e() {
        lambda$stopAudioCapture$5();
    }

    public static /* synthetic */ void f(RXScreenCaptureService r100, int r101, int r102, int r103, int r104) {
        r100.lambda$startCapture$0(r101, r102, r103, r104);
    }

    public static /* synthetic */ void g(int r100) {
        lambda$dispose$3(r100);
    }

    public static /* synthetic */ void h() {
        lambda$stopCapture$1();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    static {
        serviceStarted = new AtomicBoolean(false);
    }

    private void audioDispose() {
        if (this.mHandlerThread == null) goto L6;
        this.mHandler.post(new e());
        return;
    }

    private void createNotificationChannel() {
        Class r100 = INVOKESTATIC_com_ss_bytertc_base_media_screen_RXScreenCaptureService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(this.mLaunchActivity);     // Catch: ClassNotFoundException -> L4
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        Notification.Builder r101 = new Notification.Builder(getApplicationContext());
        Intent r102 = new Intent(this, r100);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 <= 30) goto L11;
        int r104 = 201326592;
    L12:
        r101.setContentIntent(PendingIntent.getActivity(this, 0, r102, r104)).setLargeIcon(BitmapFactory.decodeResource(getResources(), this.mLargeIcon)).setSmallIcon(this.mSmallIcon).setContentText(this.mContentText).setWhen(System.currentTimeMillis());
        if (r103 < 26) goto L15;
        r101.setChannelId("notification_id");
    L15:
        if (r103 < 26) goto L17;
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("notification_id", "notification_name", 2));
    L17:
        Notification r105 = r101.build();
        r105.defaults = 1;
        if (r103 < 33) goto L20;
        startForeground(110, r105, 32);
        return;
    L20:
        startForeground(110, r105);
        return;
    L11:
        r104 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L4:
        e = move-exception;
        e.printStackTrace();
        r100 = null;
        goto L6
    }

    private void stop() {
        serviceStarted.compareAndSet(true, false);
        if (this.mHandlerThread == null) goto L6;
        this.mHandler.post(new h(this));
        return;
    }

    private void stopAudioCapture() {
        if (this.mHandlerThread == null) goto L6;
        this.mHandler.post(new f());
        return;
    }

    private void stopMediaProjection() {
        if (this.mMediaProjection == null) goto L6;
        RXLogging.w(TAG, String.format("[ScreenCapture] stopMediaProjection!", new Object[0]));
        this.mMediaProjection.stop();
        this.mMediaProjection = null;
        return;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        serviceStarted.compareAndSet(false, true);
        RXLogging.w(TAG, String.format("[ScreenCapture] RXScreenCaptureService::onCreate success!", new Object[0]));     // Catch: UnsatisfiedLinkError -> L6
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(TAG);
        this.mHandlerThread = r100;
        ThreadMethodProxy.start(r100);
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        stopMediaProjection();
        stopForeground(true);
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        serviceStarted.compareAndSet(true, false);
        HandlerThread r100 = this.mHandlerThread;
        if (r100 == null) goto L6;
        r100.quitSafely();
        return;
    }

    public RXScreenCaptureService() {
        this.mLargeIcon = -1;
        this.mSmallIcon = -1;
        this.mPicoCreateMediaProjection = false;
    }

    private void createOrGetMediaProjection() {
        Context r100 = ContextUtils.getApplicationContext();
        if (this.mMediaProjection == null) goto L5;
        return;
    L5:
        if (this.mMediaProjectionManager != null) goto L8;
        if (r100 == null) goto L8;
        this.mMediaProjectionManager = (MediaProjectionManager) r100.getSystemService("media_projection");
    L8:
        MediaProjectionManager r101 = this.mMediaProjectionManager;
        if (r101 == null) goto L12;
        this.mMediaProjection = com_ss_bytertc_base_media_screen_RXScreenCaptureService_android_media_projection_MediaProjectionManager_getMediaProjection(r101, -1, this.mPermissionReulstData);
    L12:
        if (this.mMediaProjection == null) goto L14;
        return;
    L14:
        if (this.mPicoCreateMediaProjection == false) goto L23;
        this.mMediaProjection = (MediaProjection) MediaProjectionManager.class.getMethod(METHOD_PICO_CREATE_MEDIA_PROJECTION, new Class[0]).invoke(this.mMediaProjectionManager, new Object[0]);     // Catch: Exception -> L17
        return;
    L17:
        this.mMediaProjection = null;
        return;
    }

    private static /* synthetic */ void lambda$audioDispose$6() {
        ScreenAudioCaptureAndroidManager.INSTANCE().dispose();
    }

    private /* synthetic */ void lambda$startAudioCapture$4() {
        ScreenAudioCaptureAndroidManager.INSTANCE().startAudioCapture(this.mMediaProjection);
    }

    private /* synthetic */ void lambda$stop$7() {
        stopMediaProjection();
        stopForeground(true);
        stopSelf();
    }

    private static /* synthetic */ void lambda$stopAudioCapture$5() {
        ScreenAudioCaptureAndroidManager.INSTANCE().stopAudioCapture();
    }

    private static /* synthetic */ void lambda$stopCapture$1() {
        ScreenCaptureAndroidManager.INSTANCE().stopCapture();
    }

    private void startAudioCapture() {
        createOrGetMediaProjection();
        if (this.mHandlerThread == null) goto L6;
        this.mHandler.post(new c(this));
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_bytertc_base_media_screen_RXScreenCaptureService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private void changeCaptureFormat(Intent r100) {
        Intent r101 = getData(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        final int r102 = r101.getIntExtra("w", 0);
        final int r103 = r101.getIntExtra("h", 0);
        final int r104 = r101.getIntExtra("if", 0);
        if (this.mHandlerThread == null) goto L9;
        this.mHandler.post(new d(r102, r103, r104));
        return;
    }

    private void dispose(Intent r100) {
        Intent r101 = getData(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        final int r102 = r101.getIntExtra("hc", 0);
        if (this.mHandlerThread == null) goto L9;
        this.mHandler.post(new b(r102));
        return;
    }

    private static int getCommand(Intent r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getIntExtra(ACTION, -1);
    }

    private static Intent getData(Intent r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (Intent) r100.getParcelableExtra(DATA);
    }

    private static /* synthetic */ void lambda$dispose$3(int r100) {
        ScreenCaptureAndroidManager.INSTANCE().dispose(r100);
    }

    private void startCapture(Intent r100) {
        Intent r101 = getData(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        createOrGetMediaProjection();
        final int r102 = r101.getIntExtra("w", 0);
        final int r103 = r101.getIntExtra("h", 0);
        final int r104 = r101.getIntExtra("if", 0);
        final int r105 = r101.getIntExtra(KEY_MIN_FRAMERATE, 0);
        if (this.mHandlerThread == null) goto L9;
        this.mHandler.post(new g(this, r102, r103, r104, r105));
        return;
    }

    private void startLaunch(Intent r100) {
        Intent r101 = getData(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        this.mLargeIcon = r101.getIntExtra("largei", -1);
        this.mSmallIcon = r101.getIntExtra("largei", -1);
        this.mLaunchActivity = r101.getStringExtra("activity");
        this.mContentText = r101.getStringExtra(KEY_CONTENT_TEXT);
        this.mPicoCreateMediaProjection = r101.getBooleanExtra(KEY_PICO_CREATE_MEDIA_PROJECTION, false);
        if (TextUtils.isEmpty(this.mLaunchActivity) == true) goto L19;
        int r102 = this.mLargeIcon;
        if (r102 != (-1)) goto L13;
        if (this.mSmallIcon != (-1)) goto L13;
        return;
    L13:
        if (this.mSmallIcon != (-1)) goto L15;
        this.mSmallIcon = r102;
    L15:
        if (r102 != (-1)) goto L17;
        this.mLargeIcon = this.mSmallIcon;
    L17:
        this.mPermissionReulstData = (Intent) r101.getParcelableExtra(KEY_RESULT_DATA);
        createNotificationChannel();
        return;
    }

    private void stopCapture(Intent r100) {
        if (this.mHandlerThread == null) goto L6;
        this.mHandler.post(new a());
        return;
    }

    private static MediaProjection com_ss_bytertc_base_media_screen_RXScreenCaptureService_android_media_projection_MediaProjectionManager_getMediaProjection(MediaProjectionManager r110, int r111, Intent r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111), r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102101);
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
        f06.d r107 = r106.preInvoke(102101, "android/media/projection/MediaProjectionManager", "getMediaProjection", r110, r101, "android.media.projection.MediaProjection", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (MediaProjection) r107.f474983b;
    L21:
        return r110.getMediaProjection(r111, r210);
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

    public static Intent getServiceIntent(Context r100, int r101, Intent r102) {
        Intent r103 = new Intent(r100, RXScreenCaptureService.class);
        r103.putExtra(ACTION, r101);
        if (r102 == null) goto L5;
        r103.putExtra(DATA, r102);
    L5:
        return r103;
    }

    private static /* synthetic */ void lambda$changeCaptureFormat$2(int r100, int r101, int r102) {
        ScreenCaptureAndroidManager.INSTANCE().changeCaptureFormat(r100, r101, r102);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        switch(getCommand(r100)) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L24;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L24;
        };
    L5:
        stop();
        return 2;
    L6:
        audioDispose();
        return 2;
    L7:
        stopAudioCapture();
        return 2;
    L8:
        startAudioCapture();
        return 2;
    L9:
        dispose(r100);
        return 2;
    L10:
        changeCaptureFormat(r100);
        return 2;
    L11:
        stopCapture(r100);
        return 2;
    L12:
        startCapture(r100);
        return 2;
    L13:
        startLaunch(r100);
        return 2;
    L24:
        return 2;
    }

    private /* synthetic */ void lambda$startCapture$0(int r100, int r101, int r102, int r110) {
        ScreenCaptureAndroidManager.INSTANCE().startCapture(r100, r101, r102, r110, this.mMediaProjection);
    }
}
