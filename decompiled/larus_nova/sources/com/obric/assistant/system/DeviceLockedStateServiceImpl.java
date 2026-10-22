package com.obric.assistant.system;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lha.b;
import lha.c;
import lha.d;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0002J\u001c\u0010!\u001a\u00020\b2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#2\u0006\u0010$\u001a\u00020\rH\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\bH\u0003J\b\u0010)\u001a\u00020*H\u0003J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020'H\u0002J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\n2\u0006\u0010,\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\nH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/assistant/system/DeviceLockedStateServiceImpl;", "Lcom/obric/assistant/system/IDeviceLockedStateService;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/system/IDeviceLockedStateListener;", "stateLock", "", "hasInit", "", "deviceLockedStateListener", "deviceLockedStateListenerBinder", "Landroid/os/IBinder;", "keyGuardManager", "Landroid/app/KeyguardManager;", "getKeyGuardManager", "()Landroid/app/KeyguardManager;", "keyGuardManager$delegate", "Lkotlin/Lazy;", "isDeviceLocked", "deviceLockedTime", "", "init", "", "getDeviceLockedTime", "registerDeviceLockedStateListener", "listener", "unregisterDeviceLockedStateListener", "registerSystemDeviceLockedStateListener", "findRegisterDeviceLockedStateListenerMethod", "Ljava/lang/reflect/Method;", "trustManager", "createDeviceLockedStateListener", "listenerClass", "Ljava/lang/Class;", "binder", "createDeviceLockedStateListenerBinder", "listenerDescriptor", "", "getTrustManager", "resolveDeviceId", "", "refreshDeviceLockedState", "reason", "updateDeviceLockedState", "currentState", "queryDeviceLockedState", "fallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceLockedStateServiceImpl implements IDeviceLockedStateService {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f393339h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f393340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f393341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f393342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Object f393343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f393344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f393345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f393346g;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public final int g() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L20
        Field r101 = d().getClass().getDeclaredField("mContext");     // Catch: Throwable -> L20
        r101.setAccessible(true);     // Catch: Throwable -> L20
        Object r102 = r101.get(d());     // Catch: Throwable -> L20
        Integer r103 = null;
        if ((r102 instanceof Context) == false) goto L6;
        Context r104 = (Context) r102;     // Catch: Throwable -> L20
    L7:
        if (r104 == null) goto L11;
        Method r105 = r104.getClass().getMethod("getDeviceId", new Class[0]);     // Catch: Throwable -> L20
        if (r105 == null) goto L11;
        Object r106 = r105.invoke(r104, new Object[0]);     // Catch: Throwable -> L20
    L13:
        if ((r106 instanceof Integer) == false) goto L15;
        r103 = (Integer) r106;     // Catch: Throwable -> L20
    L15:
        if (r103 == null) goto L17;
        int r107 = r103.intValue();     // Catch: Throwable -> L20
    L18:
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(r107));     // Catch: Throwable -> L20
    L22:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L26;
        FLogger.f375446a.w("DeviceLockedStateService", "resolveDeviceId failed: " + r109.getMessage(), r109);
    L26:
        if (Result.m9455isFailureimpl(r108) == false) goto L29;
        r108 = 0;
    L29:
        return ((Number) r108).intValue();
    L17:
        r107 = 0;
    L11:
        r106 = null;
        goto L13
    L6:
        r104 = null;
    L20:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public final KeyguardManager d() {
        return (KeyguardManager) this.f393344e.getValue();
    }

    public final Object e() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService("trust");
        if (r100 == null) goto L5;
        return r100;
    L5:
        Field r101 = d().getClass().getDeclaredField("mTrustManager");
        r101.setAccessible(true);
        Object r102 = r101.get(d());
        if (r102 == null) goto L9;
        return r102;
    L9:
        throw new IllegalStateException("TrustManager is null".toString());
    }

    @Override // com.obric.assistant.system.IDeviceLockedStateService
    public final void init() {
        if (this.f393342c == false) goto L6;
        FLogger.f375446a.i("DeviceLockedStateService", "init ignored, already initialized");
        return;
    L6:
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L8:
        if (this.f393342c == false) goto L10;
        boolean r100 = false;
    L12:
        monitor-exit(this);
        if (r100 == true) goto L15;
        return;
    L15:
        FLogger r101 = FLogger.f375446a;
        r101.i("DeviceLockedStateService", "init");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        Object r103 = e();     // Catch: Throwable -> L21
        Method r104 = c(r103);     // Catch: Throwable -> L21
        Class r105 = (Class) ArraysKt.first(r104.getParameterTypes());     // Catch: Throwable -> L21
        String r106 = r105.getName();     // Catch: Throwable -> L21
        if (StringsKt.isBlank(r106) == false) goto L19;
        r106 = "com.android.internal.policy.IDeviceLockedStateListener";
    L19:
        final c r107 = new c(r106, this);     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L21
        Object r108 = Proxy.newProxyInstance(r105.getClassLoader(), new Class[]{r105}, new b(this, r107));     // Catch: Throwable -> L21
        int r109 = g();     // Catch: Throwable -> L21
        r104.invoke(r103, new Object[]{r108, Integer.valueOf(r109)});     // Catch: Throwable -> L21
        this.f393343d = r108;     // Catch: Throwable -> L21
        r101.i("DeviceLockedStateService", "registerDeviceLockedStateListener success, method=" + r104 + ", deviceId=" + r109);     // Catch: Throwable -> L21
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L26;
        FLogger.f375446a.w("DeviceLockedStateService", "registerDeviceLockedStateListener failed: " + r111.getMessage(), r111);
    L26:
        boolean r112 = f(this.f393345f);
        FLogger.f375446a.i("DeviceLockedStateService", "refreshDeviceLockedState reason=init, currentState=" + r112);
        h(r112, "init");
        return;
    L21:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L10:
        this.f393342c = true;     // Catch: Throwable -> L28
        r100 = true;
        goto L12
    }

    public DeviceLockedStateServiceImpl() {
        this.f393340a = new CopyOnWriteArrayList();
        this.f393341b = new Object();
        this.f393344e = LazyKt.lazy(new lha.a());
        boolean r100 = f(false);
        FLogger.f375446a.i("DeviceLockedStateService", "init isDeviceLocked=" + r100);
        this.f393345f = r100;
        if (this.f393345f == false) goto L5;
        long r101 = AppHost.f326268a.getAppClock().currentTimeMillis() / ((long) 1000);
    L6:
        this.f393346g = r101;
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.obric.assistant.system.IDeviceLockedStateService
    public final long b() {
        return this.f393346g;
    }

    @Override // com.obric.assistant.system.IDeviceLockedStateService
    public final boolean isDeviceLocked() {
        return this.f393345f;
    }

    public static Method c(Object r100) {
        Method[] r101 = r100.getClass().getMethods();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        Method r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getName(), "registerDeviceLockedStateListener") == true) goto L7;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L16;
        r103 = r103 + 1;
    L16:
        if (r104 == null) goto L19;
        return r104;
    L19:
        throw new IllegalStateException("method registerDeviceLockedStateListener not found in ".concat(r100.getClass().getName()).toString());
    L7:
        if (r104.getParameterTypes().length != 2) goto L11;
        r105 = true;
        if (Intrinsics.areEqual(r104.getParameterTypes()[1], Integer.TYPE) == false) goto L11;
    L15:
        r104 = null;
        goto L16
    }

    @Override // com.obric.assistant.system.IDeviceLockedStateService
    public final void a(ClearContextInKeyguardServiceImpl.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f393340a.addIfAbsent(r100);
    }

    public final boolean f(boolean r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (Build.VERSION.SDK_INT < 22) goto L5;
        boolean r102 = d().isDeviceLocked();     // Catch: Throwable -> L8
    L6:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L15;
        FLogger.f375446a.w("DeviceLockedStateService", "queryDeviceLockedState failed: " + r104.getMessage(), r104);
        r103 = Boolean.valueOf(r100);
    L15:
        return ((Boolean) r103).booleanValue();
    L5:
        r102 = d().isKeyguardLocked();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void h(boolean r100, String r110) {
        Object r101 = this.f393341b;
        monitor-enter(r101);
        boolean r102 = this.f393345f;     // Catch: Throwable -> L27
        if (r100 != r102) goto L7;
        FLogger.f375446a.i("DeviceLockedStateService", "deviceLockedStateUnchanged reason=" + r110 + ", state=" + r100);     // Catch: Throwable -> L27
        boolean r111 = false;
    L12:
        monitor-exit(r101);
        if (r111 == true) goto L15;
        return;
    L15:
        Iterator<d> r112 = this.f393340a.iterator();
    L17:
        if (r112.hasNext() == false) goto L26;
        d r103 = r112.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L21
        r103.onChange(r100);     // Catch: Throwable -> L21
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L17;
        FLogger.f375446a.w("DeviceLockedStateService", "notifyDeviceLockedStateChanged failed: " + r106.getMessage(), r106);
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L26:
        return;
    L7:
        this.f393345f = r100;     // Catch: Throwable -> L27
        if (r100 == false) goto L10;
        this.f393346g = AppHost.f326268a.getAppClock().currentTimeMillis() / ((long) 1000);     // Catch: Throwable -> L27
    L10:
        FLogger.f375446a.i("DeviceLockedStateService", "deviceLockedStateChanged reason=" + r110 + ", previous=" + r102 + ", current=" + r100);     // Catch: Throwable -> L27
        r111 = true;
    L27:
        th = move-exception;
        throw th;
    }
}
