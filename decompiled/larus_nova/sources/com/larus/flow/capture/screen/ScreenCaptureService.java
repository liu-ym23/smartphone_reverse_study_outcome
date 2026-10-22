package com.larus.flow.capture.screen;

import android.R;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import ca9.c;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.flow.capture.model.StopReason;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import da9.b;
import ea9.e;
import ea9.i;
import ea9.j;
import ea9.k;
import ea9.m;
import ea9.n;
import f06.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0002J\u0014\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010(\u001a\u00020)H\u0016J\"\u0010*\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0010H\u0016J\u0010\u0010-\u001a\u00020)2\u0006\u0010'\u001a\u00020\tH\u0002J\u0010\u0010.\u001a\u00020)2\u0006\u0010'\u001a\u00020\tH\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020)2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020)H\u0016J\b\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020;H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/flow/capture/screen/ScreenCaptureService;", "Landroid/app/Service;", "<init>", "()V", "mediaProjection", "Landroid/media/projection/MediaProjection;", "captureSession", "Lcom/larus/flow/capture/screen/GlScreenCaptureSession;", "permissionData", "Landroid/content/Intent;", "isRunning", "", "isForegroundStarted", "currentSessionId", "", "baseWidth", "", "baseHeight", "currentWidth", "currentHeight", "currentDisplayRotationDegrees", "currentFps", "displayManager", "Landroid/hardware/display/DisplayManager;", "displayListener", "Landroid/hardware/display/DisplayManager$DisplayListener;", "mediaProjectionCallback", "Landroid/media/projection/MediaProjection$Callback;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "stopRequested", "structuredLogger", "Lcom/larus/flow/capture/log/ScreenCaptureStructuredLogger;", "onBind", "Landroid/os/IBinder;", "intent", WidgetCostModule.TYPE_ON_CREATE, "", "onStartCommand", "flags", "startId", "handleLaunch", "handleStart", "registerDisplayListenerIfNeeded", "unregisterDisplayListener", "updateCaptureSessionForCurrentDisplay", "force", "resolveCurrentCaptureDisplayInfo", "Lcom/larus/flow/capture/screen/ScreenCaptureService$CaptureDisplayInfo;", "handleStop", "reason", "Lcom/larus/flow/capture/model/StopReason;", LiveCommonConstants.REASON_ON_DEDTROY, "createNotificationChannel", "buildNotification", "Landroid/app/Notification;", "Companion", "CaptureDisplayInfo", "OApp.flowSDK.baseSDK.common.flow-capture"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenCaptureService extends Service {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static Function1<? super b, Unit> f343430r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static Function1<? super StopReason, Unit> f343431s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaProjection f343432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f343433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f343434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f343435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f343436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f343437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f343438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f343439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f343440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f343441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f343442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f343443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DisplayManager f343444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n f343445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f343446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f343447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f343448q;

    public static final class a {
        public static Intent a(Context r100, String r101, int r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "sessionId");
            Intent r105 = new Intent(r100, ScreenCaptureService.class);
            r105.setAction("action_start_capture");
            r105.putExtra("extra_session_id", r101);
            r105.putExtra("extra_width", r102);
            r105.putExtra("extra_height", r103);
            r105.putExtra("extra_fps", r104);
            return r105;
        }
    }

    static {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return null;
    }

    public final void d() {
        n r100 = this.f343445n;
        if (r100 == null) goto L7;
        DisplayManager r101 = this.f343444m;
        if (r101 == null) goto L7;
        r101.unregisterDisplayListener(r100);
    L7:
        this.f343445n = null;
        this.f343444m = null;
    }

    public ScreenCaptureService() {
        this.f343443l = 30;
        this.f343447p = LazyKt.lazy(new i(this));
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        c r100 = ca9.b.f22972a;
        c.a.a(ca9.b.f22972a, "ScreenShareCaptureServiceCreate", "ScreenCaptureService.onCreate", null, null, 12);
        if (Build.VERSION.SDK_INT < 26) goto L6;
        NotificationChannel r101 = new NotificationChannel("ScreenCaptureChannel", "Screen Share", 3);
        r101.setDescription("Running screen capture");
        Object r102 = getSystemService("notification");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) r102).createNotificationChannel(r101);
        return;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f343434c = null;
        c(StopReason.USER_STOP);
        c r100 = ca9.b.f22972a;
        c.a.a(ca9.b.f22972a, "ScreenShareCaptureServiceDestroy", "ScreenCaptureService.onDestroy", null, null, 12);
    }

    public final void b(Intent r100) {
        this.f343434c = (Intent) r100.getParcelableExtra("extra_permission_data");
        if (this.f343436e == true) goto L5;
        startForeground(1001, new NotificationCompat.Builder(this, "ScreenCaptureChannel").setContentTitle("Screen Sharing").setContentText("Your screen is currently being shared.").setSmallIcon(R.drawable.ic_menu_camera).setPriority(0).build());
        this.f343436e = true;
    L5:
        c r101 = ca9.b.f22972a;
        c r102 = ca9.b.f22972a;
        Pair[] r103 = new Pair[2];
        if (this.f343434c == null) goto L8;
        boolean r104 = true;
    L9:
        r103[0] = TuplesKt.to("permissionDataPresent", Boolean.valueOf(r104));
        r103[1] = TuplesKt.to("foregroundStarted", Boolean.valueOf(this.f343436e));
        c.a.a(r102, "ScreenShareCaptureServiceLaunch", "ScreenCaptureService.handleLaunch", null, MapsKt.mapOf(r103), 4);
        if (this.f343434c != null) goto L13;
        ca9.b.f22972a.b("ScreenShareCaptureServiceLaunchFailedNoPermissionData", "ScreenCaptureService.handleLaunch", null, MapsKt.emptyMap());
        return;
    L13:
        return;
    L8:
        r104 = false;
        goto L9
    }

    public final void c(StopReason r110) {
        if (this.f343448q == false) goto L6;
        return;
    L6:
        if (this.f343435d == false) goto L8;
    L15:
        boolean r100 = true;
    L16:
        if (r100 == true) goto L18;
        return;
    L18:
        this.f343448q = true;
        this.f343435d = false;
        Objects.toString(r110);
        c r101 = ca9.b.f22972a;
        c r102 = ca9.b.f22972a;
        String r103 = this.f343437f;
        if (r103 == null) goto L21;
        List<String> r104 = CollectionsKt.listOf(r103);
    L22:
        r102.a("ScreenShareStop", "ScreenCaptureService.handleStop", r104, MapsKt.mapOf(TuplesKt.to("reason", r110.name())));
        e r105 = this.f343433b;     // Catch: Throwable -> L50 Exception -> L52
        if (r105 == null) goto L26;
        r105.q();     // Catch: Throwable -> L50 Exception -> L52
    L26:
        this.f343433b = null;     // Catch: Throwable -> L50 Exception -> L52
        m r106 = this.f343446o;     // Catch: Throwable -> L50 Exception -> L52
        if (r106 != null) goto L85;
    L37:
        this.f343446o = null;     // Catch: Throwable -> L50 Exception -> L52
        MediaProjection r107 = this.f343432a;     // Catch: Throwable -> L50 Exception -> L52
        if (r107 == null) goto L40;
        r107.stop();     // Catch: Throwable -> L50 Exception -> L52
    L40:
        this.f343432a = null;     // Catch: Throwable -> L50 Exception -> L52
        d();
        Function1<? super StopReason, Unit> r108 = f343431s;
        if (r108 == null) goto L45;
        r108.invoke(r110);
    L45:
        if (this.f343436e == false) goto L47;
        stopForeground(true);
        this.f343436e = false;
    L47:
        stopSelf();
        c r109 = ca9.b.f22972a;
        c r111 = ca9.b.f22972a;
        String r112 = this.f343437f;
        if (r112 != null) goto L69;
    L70:
        c r113 = r111;
        List r114 = null;
    L71:
        c.a.a(r113, "ScreenShareStop", "ScreenCaptureService.handleStop", r114, null, 8);
        this.f343437f = null;
        this.f343438g = 0;
        this.f343439h = 0;
        this.f343440i = 0;
        this.f343441j = 0;
        this.f343442k = 0;
        this.f343443l = 30;
        this.f343448q = false;
        return;
    L69:
        r114 = CollectionsKt.listOf(r112);
        r113 = r111;
        goto L71
    L85:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L34
        MediaProjection r116 = this.f343432a;     // Catch: Throwable -> L34
        if (r116 == null) goto L31;
        r116.unregisterCallback(r106);     // Catch: Throwable -> L34
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L34
    L32:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L34
    L36:
        Result.m9448boximpl(r118);     // Catch: Throwable -> L50 Exception -> L52
        goto L37
    L31:
        r117 = null;
    L34:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L50 Exception -> L52
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L50 Exception -> L52
    L52:
        e = move-exception;
        c r120 = ca9.b.f22972a;     // Catch: Throwable -> L50
        c r121 = ca9.b.f22972a;     // Catch: Throwable -> L50
        String r122 = this.f343437f;     // Catch: Throwable -> L50
        if (r122 == null) goto L56;
        List<String> r123 = CollectionsKt.listOf(r122);     // Catch: Throwable -> L50
    L57:
        Pair[] r124 = new Pair[2];     // Catch: Throwable -> L50
        r124[0] = TuplesKt.to("error", e.getClass().getSimpleName());     // Catch: Throwable -> L50
        String r125 = e.getMessage();     // Catch: Throwable -> L50
        if (r125 != null) goto L60;
        r125 = "";
    L60:
        r124[1] = TuplesKt.to("error_msg", r125);     // Catch: Throwable -> L50
        r121.b("ScreenShareCaptureException", "ScreenCaptureService.handleStop", r123, MapsKt.mapOf(r124));     // Catch: Throwable -> L50
        d();
        Function1<? super StopReason, Unit> r126 = f343431s;
        if (r126 == null) goto L65;
        r126.invoke(r110);
    L65:
        if (this.f343436e == false) goto L67;
        stopForeground(true);
        this.f343436e = false;
    L67:
        stopSelf();
        r111 = ca9.b.f22972a;
        r112 = this.f343437f;
        if (r112 == null) goto L70;
    L56:
        r123 = null;
    L50:
        th = move-exception;
        d();
        Function1<? super StopReason, Unit> r127 = f343431s;
        if (r127 == null) goto L77;
        r127.invoke(r110);
    L77:
        if (this.f343436e == false) goto L79;
        stopForeground(true);
        this.f343436e = false;
    L79:
        stopSelf();
        c r128 = ca9.b.f22972a;
        c r129 = ca9.b.f22972a;
        String r130 = this.f343437f;
        if (r130 == null) goto L82;
        List r131 = CollectionsKt.listOf(r130);
    L83:
        c.a.a(r129, "ScreenShareStop", "ScreenCaptureService.handleStop", r131, null, 8);
        this.f343437f = null;
        this.f343438g = 0;
        this.f343439h = 0;
        this.f343440i = 0;
        this.f343441j = 0;
        this.f343442k = 0;
        this.f343443l = 30;
        this.f343448q = false;
        throw th;
    L82:
        r131 = null;
        goto L83
    L21:
        r104 = null;
        goto L22
    L8:
        if (this.f343433b != null) goto L15;
        if (this.f343432a != null) goto L15;
        if (this.f343445n != null) goto L15;
        r100 = false;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [ea9.j] */
    /* JADX WARN: Type inference failed for: r4v11, types: [ea9.k] */
    public final void e(boolean r210) {
        Object r100 = getSystemService(LiveEndPageData.TAG_WINDOW);
        List<String> r101 = null;
        if ((r100 instanceof WindowManager) == false) goto L5;
        WindowManager r102 = (WindowManager) r100;
    L7:
        if (r102 == null) goto L11;
        Display r103 = r102.getDefaultDisplay();
        if (r103 == null) goto L11;
        int r104 = r103.getRotation();
    L12:
        Resources r105 = getResources();
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());
        int r107 = r106.widthPixels;
        int r108 = r106.heightPixels;
        if (r104 == 0) goto L15;
        if (r104 == 2) goto L15;
    L16:
        if (r104 == 1) goto L18;
        if (r104 == 3) goto L18;
    L20:
        boolean r109 = false;
    L22:
        int r110 = 90;
        int r111 = r104 * 90;
        if (r109 == false) goto L25;
        r110 = 0;
    L25:
        int r112 = (r111 + r110) % 360;
        if (r112 != 180) goto L28;
        final int r113 = 0;
    L29:
        int r114 = Math.max(this.f343438g, this.f343439h);
        int r115 = Math.min(this.f343438g, this.f343439h);
        if (r113 != 0) goto L32;
        boolean r116 = true;
    L33:
        if (r116 == false) goto L35;
        int r117 = r115;
    L36:
        if (r116 == false) goto L38;
        int r118 = r114;
    L39:
        if (r210 == false) goto L41;
    L47:
        c r119 = ca9.b.f22972a;
        c r120 = ca9.b.f22972a;
        String r121 = this.f343437f;
        if (r121 == null) goto L50;
        r101 = CollectionsKt.listOf(r121);
    L50:
        r120.a("ScreenShareCaptureResolutionUpdateRequest", "ScreenCaptureService.updateCaptureSessionForCurrentDisplay", r101, MapsKt.mapOf(new Pair[]{TuplesKt.to("fromWidth", Integer.valueOf(this.f343440i)), TuplesKt.to("fromHeight", Integer.valueOf(this.f343441j)), TuplesKt.to("fromRotation", Integer.valueOf(this.f343442k)), TuplesKt.to("toWidth", Integer.valueOf(r117)), TuplesKt.to("toHeight", Integer.valueOf(r118)), TuplesKt.to("toRotation", Integer.valueOf(r113)), TuplesKt.to("force", Boolean.valueOf(r210))}));
        final e r122 = this.f343433b;
        if (r122 != null) goto L64;
        String r123 = this.f343437f;
        if (r123 != null) goto L55;
        r123 = "default_session";
    L55:
        String r124 = r123;
        MediaProjection r125 = this.f343432a;
        if (r125 == null) goto L63;
        int r126 = r118;
        int r211 = r117;
        final e r127 = new e(this, r124, r125, r117, r118, r113, this.f343443l, new j(), new k(this));
        if (r127.f471695o == true) goto L61;
        r127.f471695o = true;
        ca9.b.f22972a.a("ScreenShareStartRequest", "GlScreenCaptureSession.start", CollectionsKt.listOf(r127.f471682b), MapsKt.mapOf(new Pair[]{TuplesKt.to("width", Integer.valueOf(r127.f471696p)), TuplesKt.to("height", Integer.valueOf(r127.f471697q)), TuplesKt.to("rotation", Integer.valueOf(r127.f471684d)), TuplesKt.to("fps", Integer.valueOf(r127.f471685e))}));
        r127.f471705y.post(new ea9.a(r127));
    L61:
        this.f343433b = r127;
    L66:
        final int r128 = r126;
        final int r129 = r211;
    L76:
        this.f343440i = r129;
        this.f343441j = r128;
        this.f343442k = r113;
        return;
    L63:
        throw new IllegalStateException("MediaProjection is null when starting capture session".toString());
    L64:
        r126 = r118;
        r211 = r117;
        if (r122.f471695o == false) goto L66;
        r129 = r211;
        if (r122.f471696p != r129) goto L74;
        r128 = r126;
        if (r122.f471697q == r128) goto L72;
    L75:
        r122.f471705y.post(new ea9.c(r122, r129, r128, r113));
        goto L76
    L72:
        if (r122.f471684d != r113) goto L75;
    L74:
        r128 = r126;
        goto L75
    L41:
        if (r117 != this.f343440i) goto L47;
        if (r118 != this.f343441j) goto L47;
        if (r113 != this.f343442k) goto L47;
        return;
    L38:
        r118 = r115;
        goto L39
    L35:
        r117 = r114;
        goto L36
    L32:
        r116 = false;
        goto L33
    L28:
        r113 = r112;
    L18:
        if (r107 <= r108) goto L20;
    L21:
        r109 = true;
    L15:
        if (r108 > r107) goto L21;
    L11:
        r104 = 0;
        goto L12
    L5:
        r102 = null;
        goto L7
    }

    public static MediaProjection a(MediaProjectionManager r210, Intent r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {-1, r211};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102101);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        d r107 = r106.preInvoke(102101, "android/media/projection/MediaProjectionManager", "getMediaProjection", r210, r101, "android.media.projection.MediaProjection", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (MediaProjection) r107.f474983b;
    L21:
        return r210.getMediaProjection(-1, r211);
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r210, int r211, int r212) {
        if (r210 == null) goto L65;
        String r100 = r210.getAction();
        if (r100 == null) goto L65;
        int r101 = r100.hashCode();
        if (r101 == (-309622926)) goto L62;
        if (r101 == (-223007773)) goto L58;
        if (r101 != 1644816928) goto L65;
        if (r100.equals("action_start_capture") == false) goto L65;
        DisplayManager r102 = null;
        List r103 = null;
        if (this.f343435d == false) goto L22;
        c r104 = ca9.b.f22972a;
        c r105 = ca9.b.f22972a;
        String r106 = this.f343437f;
        if (r106 == null) goto L21;
        r103 = CollectionsKt.listOf(r106);
    L21:
        c.a.b(r105, "ScreenShareCaptureServiceStartIgnoredAlreadyRunning", "ScreenCaptureService.handleStart", r103);
        goto L65
    L22:
        String r107 = r210.getStringExtra("extra_session_id");
        if (r107 != null) goto L25;
        r107 = "default_session";
    L25:
        int r108 = r210.getIntExtra("extra_width", 720);
        int r109 = r210.getIntExtra("extra_height", 1280);
        int r110 = r210.getIntExtra("extra_fps", 30);
        this.f343437f = r107;
        this.f343438g = r108;
        this.f343439h = r109;
        this.f343443l = r110;
        c r111 = ca9.b.f22972a;
        ca9.b.f22972a.a("ScreenShareStartRequest", "ScreenCaptureService.handleStart", CollectionsKt.listOf(r107), MapsKt.mapOf(new Pair[]{TuplesKt.to("width", Integer.valueOf(r108)), TuplesKt.to("height", Integer.valueOf(r109)), TuplesKt.to("fps", Integer.valueOf(r110)), TuplesKt.to("foregroundStarted", Boolean.valueOf(this.f343436e))}));
        if (this.f343436e == true) goto L28;
        b(r210);
    L28:
        Intent r112 = this.f343434c;
        if (r112 != null) goto L66;
        ca9.b.f22972a.b("ScreenShareStartResult", "ScreenCaptureService.handleStart", CollectionsKt.listOf(r107), MapsKt.emptyMap());
        Function1<? super StopReason, Unit> r113 = f343431s;
        if (r113 == null) goto L33;
        r113.invoke(StopReason.RUNTIME_ERROR);
    L33:
        stopSelf();
        goto L65
    L66:
        Object r114 = getSystemService("media_projection");     // Catch: Exception -> L52
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.media.projection.MediaProjectionManager");     // Catch: Exception -> L52
        this.f343432a = a((MediaProjectionManager) r114, r112);     // Catch: Exception -> L52
        c r115 = ca9.b.f22972a;     // Catch: Exception -> L52
        List<String> r116 = CollectionsKt.listOf(r107);     // Catch: Exception -> L52
        if (this.f343432a != null) goto L37;
        boolean r117 = true;
    L38:
        r115.a("ScreenShareCaptureServiceMediaProjectionCreated", "ScreenCaptureService.handleStart", r116, MapsKt.mapOf(TuplesKt.to("mediaProjectionNull", Boolean.valueOf(r117))));     // Catch: Exception -> L52
        m r118 = new m(this, r107);     // Catch: Exception -> L52
        MediaProjection r119 = this.f343432a;     // Catch: Exception -> L52
        if (r119 == null) goto L41;
        r119.registerCallback(r118, null);     // Catch: Exception -> L52
    L41:
        this.f343446o = r118;     // Catch: Exception -> L52
        if (this.f343445n != null) goto L50;
        Object r120 = getSystemService("display");     // Catch: Exception -> L52
        if ((r120 instanceof DisplayManager) == false) goto L47;
        r102 = (DisplayManager) r120;     // Catch: Exception -> L52
    L47:
        if (r102 == null) goto L50;
        this.f343444m = r102;     // Catch: Exception -> L52
        n r121 = new n(this);     // Catch: Exception -> L52
        r102.registerDisplayListener(r121, new Handler(getMainLooper()));     // Catch: Exception -> L52
        this.f343445n = r121;     // Catch: Exception -> L52
    L50:
        e(true);     // Catch: Exception -> L52
        this.f343435d = true;     // Catch: Exception -> L52
        c.a.a(ca9.b.f22972a, "ScreenShareStartResult", "ScreenCaptureService.handleStart", CollectionsKt.listOf(r107), null, 8);     // Catch: Exception -> L52
        goto L65
    L37:
        r117 = false;
    L52:
        e = move-exception;
        c r122 = ca9.b.f22972a;
        c r123 = ca9.b.f22972a;
        List<String> r124 = CollectionsKt.listOf(r107);
        Pair[] r125 = new Pair[2];
        r125[0] = TuplesKt.to("error", e.getClass().getSimpleName());
        String r126 = e.getMessage();
        if (r126 != null) goto L56;
        r126 = "";
    L56:
        r125[1] = TuplesKt.to("error_msg", r126);
        r123.b("ScreenShareStartResult", "ScreenCaptureService.handleStart", r124, MapsKt.mapOf(r125));
        c(StopReason.RUNTIME_ERROR);
        goto L65
    L58:
        if (r100.equals("action_launch_capture") == false) goto L65;
        b(r210);
        goto L65
    L62:
        if (r100.equals("action_stop_capture") == false) goto L65;
        c(StopReason.USER_STOP);
    L65:
        return 2;
    }
}
