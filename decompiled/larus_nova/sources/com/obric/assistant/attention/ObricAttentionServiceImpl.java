package com.obric.assistant.attention;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.hardware.camera2.CameraManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.assistant.util.m;
import com.obric.assistant.util.p;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import oba.e;
import oba.f;
import oba.g;
import oba.h;
import oba.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f*\u0001\u001b\b\u0007\u0018\u0000 A2\u00020\u0001:\u0003ABCB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u0014\u0010'\u001a\u00020\u001e2\n\u0010(\u001a\u00060\u000bR\u00020\u0000H\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\n\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0014H\u0002J\b\u0010.\u001a\u00020\u000fH\u0002J \u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0014H\u0002J\u0014\u00102\u001a\u00020\u001e2\n\u0010(\u001a\u00060\u000bR\u00020\u0000H\u0002J\u0018\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u0002052\u0006\u0010#\u001a\u00020\rH\u0002J-\u00106\u001a\u00020\u001e2\n\u0010(\u001a\u00060\u000bR\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u00108\u001a\u00020\u0019H\u0002¢\u0006\u0002\u00109J\u0014\u0010:\u001a\u00020\u001e2\n\u0010(\u001a\u00060\u000bR\u00020\u0000H\u0002J\u0014\u0010;\u001a\u00020\u001e2\n\u0010(\u001a\u00060\u000bR\u00020\u0000H\u0002J\b\u0010<\u001a\u00020\u001eH\u0002J\u001c\u0010=\u001a\u00020\u001e2\n\u0010(\u001a\u00060\u000bR\u00020\u00002\u0006\u0010>\u001a\u00020\u0019H\u0002J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0014H\u0002J\b\u0010@\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0018\u00010\u000bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006D"}, d2 = {"Lcom/obric/assistant/attention/ObricAttentionServiceImpl;", "Lcom/obric/assistant/attention/IObricAttentionService;", "<init>", "()V", "handler", "Landroid/os/Handler;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "activeRequest", "Lcom/obric/assistant/attention/ObricAttentionServiceImpl$AttentionRequest;", "remoteBinder", "Landroid/os/IBinder;", "activeConnection", "Landroid/content/ServiceConnection;", "bindTimeoutTask", "Ljava/lang/Runnable;", "frontCameraIds", "", "", "reportedFrontCameraIds", "", "availableFrontCameraIds", "cameraAvailabilityRegistered", "", "cameraAvailabilityCallback", "com/obric/assistant/attention/ObricAttentionServiceImpl$cameraAvailabilityCallback$1", "Lcom/obric/assistant/attention/ObricAttentionServiceImpl$cameraAvailabilityCallback$1;", "init", "", "checkAttention", "Lcom/obric/assistant/attention/AttentionCheckRequest;", "timeoutMillis", "", "callback", "Lcom/obric/assistant/attention/AttentionCheckCallback;", "calculateDeadlineUptimeMillis", "registerCameraAvailabilityCallback", "startRequest", "request", "continueRequestAfterCameraUpdate", "attentionServiceComponent", "Landroid/content/ComponentName;", "ensureBound", "reason", "createServiceConnection", "handleConnectionLoss", WsConstants.KEY_CONNECTION, "name", "dispatchCheck", "transact", "code", "", "finishRequest", "result", "cancelRemote", "(Lcom/obric/assistant/attention/ObricAttentionServiceImpl$AttentionRequest;Ljava/lang/Boolean;Z)V", "cancelRequest", "onRequestTimeout", "failActiveRequest", "deliverResult", "isAttentionPresent", "releaseBinding", "clearBindTimeout", "Companion", "AttentionRequest", "AttentionCallbackBinder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAttentionServiceImpl implements IObricAttentionService {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f385592k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f385593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f385594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IBinder f385595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f385596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public oba.c f385597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set<String> f385598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f385599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f385600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f385601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f385602j;

    /* JADX INFO: loaded from: classes32.dex */
    public final class a extends Binder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f385603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObricAttentionServiceImpl f385604b;

        public a(ObricAttentionServiceImpl r100, b r101) {
            Intrinsics.checkNotNullParameter(r101, "request");
            this.f385604b = r100;
            this.f385603a = r101;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, "data");
            final boolean r104 = false;
            if (r100 != 1) goto L5;
            r101.enforceInterface("android.service.attention.IAttentionCallback");
            if (r101.readInt() != 1) goto L17;
            r104 = true;
        L17:
            r101.readLong();
        L18:
            final ObricAttentionServiceImpl r105 = this.f385604b;
            r105.f385593a.post(new f(r105, this, r104));
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface("android.service.attention.IAttentionCallback");
            r101.readInt();
            goto L18
        L7:
            if (r100 != 1598968902) goto L9;
            if (r102 == null) goto L12;
            r102.writeString("android.service.attention.IAttentionCallback");
        L12:
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public final class b implements oba.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oba.a f385605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f385606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f385607c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f385608d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f385609e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final h f385610f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ObricAttentionServiceImpl f385611g;

        @Override // oba.b
        public final void cancel() {
            this.f385607c = true;
            final ObricAttentionServiceImpl r100 = this.f385611g;
            r100.f385593a.post(new g(r100, this));
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [oba.h] */
        public b(final ObricAttentionServiceImpl r100, m r101, long r102) {
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f385611g = r100;
            this.f385605a = r101;
            this.f385606b = r102;
            this.f385609e = new a(r100, this);
            this.f385610f = new h(r100, this);
        }
    }

    public static final class c {
    }

    public static final class d extends CameraManager.AvailabilityCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricAttentionServiceImpl f385612a;

        public d(ObricAttentionServiceImpl r100) {
            this.f385612a = r100;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAvailable(String r100) {
            Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_CAMERA_ID);
            if (this.f385612a.f385598f.contains(r100) == false) goto L6;
            this.f385612a.f385599g.add(r100);
            this.f385612a.f385600h.add(r100);
            FLogger.f375446a.i("ObricAttentionService", "front camera available, cameraId=" + r100);
            this.f385612a.d();
            return;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraUnavailable(String r100) {
            Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_CAMERA_ID);
            if (this.f385612a.f385598f.contains(r100) == false) goto L6;
            this.f385612a.f385599g.add(r100);
            this.f385612a.f385600h.remove(r100);
            FLogger.f375446a.i("ObricAttentionService", "front camera unavailable, cameraId=" + r100);
            this.f385612a.d();
            return;
        }
    }

    static {
    }

    public static Context h() {
        gd9.i r100 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r100);
        NovaApplication r101 = r100.getApplication();
        r101.getClass();
        return r101;
    }

    public final void d() {
        b r100 = this.f385594b;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f385607c == false) goto L8;
        return;
    L8:
        if (r100.f385608d == false) goto L11;
        return;
    L11:
        if (this.f385601i == true) goto L13;
        return;
    L13:
        if (this.f385599g.containsAll(this.f385598f) == true) goto L16;
        return;
    L16:
        if (this.f385600h.isEmpty() == false) goto L20;
        FLogger.f375446a.i("ObricAttentionService", "attention check skipped: front camera unavailable");
        g(r100, Boolean.FALSE, false);
        return;
    L20:
        if (this.f385595c != null) goto L22;
        f("check");
        return;
    L22:
        if (this.f385594b == r100) goto L24;
        return;
    L24:
        if (r100.f385607c == false) goto L26;
        return;
    L26:
        if (r100.f385608d == false) goto L29;
        return;
    L29:
        if (this.f385600h.isEmpty() == false) goto L31;
        FLogger.f375446a.i("ObricAttentionService", "attention check skipped: front camera unavailable");
        g(r100, Boolean.FALSE, false);
        return;
    L31:
        boolean r101 = j(1, r100.f385609e);
        r100.f385608d = r101;
        if (r101 == true) goto L40;
        i("check_transaction_failed");
        g(r100, Boolean.FALSE, false);
        return;
    }

    @Override // com.obric.assistant.attention.IObricAttentionService
    public final void init() {
        this.f385593a.post(new oba.d(this));
    }

    public ObricAttentionServiceImpl() {
        this.f385593a = new Handler(Looper.getMainLooper());
        this.f385598f = SetsKt.emptySet();
        this.f385599g = new LinkedHashSet();
        this.f385600h = new LinkedHashSet();
        this.f385602j = new d(this);
    }

    @Override // com.obric.assistant.attention.IObricAttentionService
    public final b a(m r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        long r100 = RangesKt.coerceAtLeast(2800, 1);
        long r101 = SystemClock.uptimeMillis();
        long r102 = Long.MAX_VALUE;
        if ((Long.MAX_VALUE - r101) < r100) goto L6;
        r102 = r101 + r100;
    L6:
        final b r103 = new b(this, r110, r102);
        this.f385593a.post(new e(this, r103));
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48, types: [java.lang.Runnable, oba.c] */
    public final void f(String r110) {
        if (this.f385595c == null) goto L5;
        return;
    L5:
        if (this.f385596d != null) goto L99;
        int r100 = h().getResources().getIdentifier("config_defaultAttentionService", "string", "android");
        if (r100 != 0) goto L92;
    L54:
        final ComponentName r101 = null;
    L56:
        if (r101 != null) goto L61;
        FLogger.f375446a.w("ObricAttentionService", "attention service unavailable, reason=".concat(r110));
        b r111 = this.f385594b;
        if (r111 == null) goto L96;
        g(r111, Boolean.FALSE, false);
        return;
    L96:
        return;
    L61:
        final i r102 = new i(this);
        this.f385596d = r102;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L64
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(h().bindService(new Intent("android.service.attention.AttentionService").setComponent(r101), r102, 67112961)));     // Catch: Throwable -> L64
    L66:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L69;
        FLogger.f375446a.e("ObricAttentionService", "bind attention service failed, reason=" + r110 + ", component=" + r101, r105);
    L69:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L73;
        r104 = r106;
    L73:
        if (((Boolean) r104).booleanValue() == true) goto L82;
        if (this.f385596d != r102) goto L77;
        this.f385596d = null;
    L77:
        b r112 = this.f385594b;
        if (r112 == null) goto L97;
        g(r112, r106, false);
        return;
    L97:
        return;
    L82:
        if (this.f385596d == r102) goto L84;
    L86:
        FLogger.f375446a.i("ObricAttentionService", "attention service binding requested, reason=" + r110 + ", component=" + r101);
        return;
    L84:
        if (this.f385595c != null) goto L86;
        ?? r107 = new oba.c(this, r102, r101);
        this.f385597e = r107;
        this.f385593a.postDelayed(r107, 5000);
    L64:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L66
    L92:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L12
        Object r113 = Result.m9449constructorimpl(h().getResources().getString(r100));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r113) == false) goto L17;
        r113 = null;
    L17:
        String r114 = (String) r113;
        if (r114 == null) goto L54;
        if ((!StringsKt.isBlank(r114)) == true) goto L23;
        r114 = null;
    L23:
        if (r114 == null) goto L54;
        ComponentName r115 = ComponentName.unflattenFromString(r114);
        if (r115 == null) goto L94;
        Object r116 = Result.m9449constructorimpl(h().getPackageManager().getServiceInfo(r115, 1048576));     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r116) == false) goto L33;
        r116 = null;
    L33:
        ServiceInfo r117 = (ServiceInfo) r116;
        if (r117 == null) goto L54;
    L51:
        if (Intrinsics.areEqual(r117.permission, "android.permission.BIND_ATTENTION_SERVICE") == true) goto L53;
        FLogger.f375446a.e("ObricAttentionService", "invalid attention service permission: " + r117.packageName + '/' + r117.name);
        goto L54
    L53:
        r101 = new ComponentName(r117.packageName, r117.name);
    L28:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L94:
        ResolveInfo r119 = h().getPackageManager().resolveService(new Intent("android.service.attention.AttentionService").setPackage(r114), 1048576);     // Catch: Throwable -> L42
        if (r119 == null) goto L39;
        ServiceInfo r120 = r119.serviceInfo;     // Catch: Throwable -> L42
    L40:
        Object r121 = Result.m9449constructorimpl(r120);     // Catch: Throwable -> L42
    L45:
        if (Result.m9455isFailureimpl(r121) == false) goto L47;
        r121 = null;
    L47:
        r117 = (ServiceInfo) r121;
        if (r117 != null) goto L51;
    L39:
        r120 = null;
    L42:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final void i(String r100) {
        oba.c r101 = this.f385597e;
        if (r101 == null) goto L5;
        this.f385593a.removeCallbacks(r101);
    L5:
        this.f385597e = null;
        this.f385595c = null;
        i r102 = this.f385596d;
        if (r102 != null) goto L8;
        return;
    L8:
        this.f385596d = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        h().unbindService(r102);     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L19;
        FLogger.f375446a.w("ObricAttentionService", "unbind attention service failed, reason=".concat(r100), r105);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static void e(b r100, final boolean r101) {
        if (r100.f385607c == false) goto L13;
        return;
    L13:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        m r103 = (m) r100.f385605a;     // Catch: Throwable -> L7
        final p r104 = r103.f393765a;     // Catch: Throwable -> L7
        final long r105 = r103.f393766b;     // Catch: Throwable -> L7
        final zga.e r106 = r103.f393767c;     // Catch: Throwable -> L7
        r104.f393797g.post(new com.obric.assistant.util.d(r104, r105, r106, r101));     // Catch: Throwable -> L7
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L15;
        FLogger.f375446a.e("ObricAttentionService", "deliver attention result failed", r108);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final boolean j(int r100, a r101) {
        IBinder r102 = this.f385595c;
        if (r102 != null) goto L24;
        return false;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Parcel r104 = Parcel.obtain();     // Catch: Throwable -> L12
        r104.writeInterfaceToken("android.service.attention.IAttentionService");     // Catch: Throwable -> L9
        r104.writeStrongBinder(r101);     // Catch: Throwable -> L9
        boolean r105 = b(r102, r100, r104);     // Catch: Throwable -> L9
        r104.recycle();     // Catch: Throwable -> L12
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L12
    L14:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        FLogger.f375446a.e("ObricAttentionService", "attention binder transaction failed, code=" + r100, r107);
    L17:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L21;
        r106 = r108;
    L21:
        return ((Boolean) r106).booleanValue();
    L9:
        th = move-exception;
        r104.recycle();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean b(IBinder r110, int r111, Parcel r112) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r100 = SystemClock.uptimeMillis();
        boolean r113 = r110.transact(r111, r112, null, 1);     // Catch: Throwable -> L12
        long r101 = SystemClock.uptimeMillis() - r100;
        if (r101 < 100) goto L11;
        BinderPerformanceReporter.report(r101, r110.getClass().getName(), r111, 1, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r113;
    L12:
        th = move-exception;
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L16;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, 1, new Throwable("Slow main-thread Binder transaction"));
    L16:
        throw th;
    L5:
        return r110.transact(r111, r112, null, 1);
    }

    public final void g(b r100, Boolean r101, boolean r102) {
        if (this.f385594b == r100) goto L5;
        return;
    L5:
        this.f385594b = null;
        this.f385593a.removeCallbacks(r100.f385610f);
        if (r102 == true) goto L8;
    L12:
        if (r101 == null) goto L15;
        e(r100, r101.booleanValue());
        return;
    L15:
        return;
    L8:
        if (r100.f385608d == false) goto L12;
        if (j(2, r100.f385609e) == true) goto L12;
        i("cancel_transaction_failed");
        goto L12
    }

    public static final void c(ObricAttentionServiceImpl r100, ServiceConnection r101, ComponentName r102, String r103) {
        if (r100.f385596d != r101) goto L10;
        FLogger.f375446a.w("ObricAttentionService", "attention service " + r103 + ", component=" + r102);
        r100.i(r103);
        b r104 = r100.f385594b;
        if (r104 == null) goto L9;
        r100.g(r104, Boolean.FALSE, false);
        return;
    L9:
        return;
    }
}
