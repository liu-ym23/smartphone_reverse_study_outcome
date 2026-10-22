package com.bytedance.locallife.biz.screenshot;

import android.content.Context;
import android.os.Build;
import android.provider.MediaStore;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.core.DitoLifecycleOwner;
import com.ss.android.ugc.aweme.screenshot.OnScreenShotListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tn6.d;

/* JADX INFO: loaded from: classes21.dex */
public final class ScreenShotHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.locallife.biz.screenshot.a f256974a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f256975b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f256976c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WeakReference<OnScreenShotListener>> f256977d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f256978e = null;

    public static final class a implements DitoLifecycleOwner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LifecycleRegistry f256979a;

        public a() {
            this.f256979a = new LifecycleRegistry(this);
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public final Lifecycle getLifecycle() {
            return getLifecycleRegistry();
        }

        @Override // com.bytedance.locallife.dito.core.DitoLifecycleOwner
        public final LifecycleRegistry getLifecycleRegistry() {
            return this.f256979a;
        }
    }

    static {
        new String[]{"tmp.png"};
        new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "截屏", "截屏录屏"};
        f256974a = new com.bytedance.locallife.biz.screenshot.a(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        f256975b = new b(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        f256976c = new AtomicBoolean(false);
        f256977d = new CopyOnWriteArrayList();
        f256978e = LazyKt.lazy(ScreenShotHelper$fakeLifecycleOwner$2.INSTANCE);
    }

    public static void a(OnScreenShotListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        HostServiceUtilsKt.c().log(5, "ScreenShotObserver", "local life addScreenCaptureObserver = ".concat(r100.getClass().getName()));
        int r101 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r102 = new mq6.c();
        String r103 = r100.getClass().getName();
        mq6.a r104 = mq6.c.a.f514894a;
        r102.g("listener", r103);
        r102.g("local_life", "1");
        com.bytedance.locallife.biz.mob.a.C3646a.c("poi_screenshot_add_observer", r102.f514893a);
        ScreenShotModel r105 = c.f256980a;
        cu6.a r106 = HostServiceUtilsKt.g0();
        ScreenShotModel r107 = c.f256980a;
        ScreenShotModel r108 = (ScreenShotModel) r106.a("poi_screenshot_share_settings", ScreenShotModel.class, r107);
        if (r108 == null) goto L7;
        r107 = r108;
    L7:
        if (r107.getDisableScreenshotObserver() == false) goto L10;
        HostServiceUtilsKt.c().log(4, "ScreenShotHelper", "register content observer failed! Disable by poi_screenshot_share_settings");
    L25:
        Iterator<WeakReference<OnScreenShotListener>> r109 = f256977d.iterator();
    L27:
        if (r109.hasNext() == false) goto L35;
        WeakReference<OnScreenShotListener> r110 = r109.next();
        if (r110 == null) goto L31;
        OnScreenShotListener r111 = r110.get();
    L33:
        if (Intrinsics.areEqual(r111, r100) == false) goto L27;
        return;
    L31:
        r111 = null;
        goto L33
    L35:
        f256977d.add(new WeakReference(r100));
        return;
    L10:
        if (f256976c.get() == true) goto L25;
        if (Build.VERSION.SDK_INT <= 28) goto L15;
        boolean r112 = true;
    L16:
        Context r113 = HostServiceUtilsKt.E().getApplicationContext();
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L19
        r113.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, r112, f256974a);     // Catch: Throwable -> L19
        Lazy r115 = f256978e;     // Catch: Throwable -> L19
        a r116 = (a) r115.getValue();     // Catch: Throwable -> L19
        r116.f256979a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);     // Catch: Throwable -> L19
        r116.f256979a.handleLifecycleEvent(Lifecycle.Event.ON_START);     // Catch: Throwable -> L19
        r116.f256979a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);     // Catch: Throwable -> L19
        ConcurrentHashMap<Class<?>, Object> r117 = LifeServiceManager.f162660a;     // Catch: Throwable -> L19
        d r118 = (d) LifeServiceManager.b(d.class);     // Catch: Throwable -> L19
        b r119 = f256975b;     // Catch: Throwable -> L19
        a r120 = (a) r115.getValue();     // Catch: Throwable -> L19
        r118.a(r113, r112, r119);     // Catch: Throwable -> L19
        Object r121 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L24;
        HostServiceUtilsKt.c().log(6, "ScreenShotHelper", "register content observer failed! " + r122.getMessage());
    L24:
        f256976c.set(true);
    L19:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L15:
        r112 = false;
        goto L16
    }

    public static void b(final OnScreenShotListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<WeakReference<OnScreenShotListener>> r101 = f256977d;
        Function1<WeakReference<OnScreenShotListener>, Boolean> r102 = new ScreenShotHelper$removeScreenCaptureObserver$1(r100);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r102, "predicate");
        Iterator<WeakReference<OnScreenShotListener>> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        WeakReference<OnScreenShotListener> r104 = r103.next();
        if (r102.invoke(r104).booleanValue() == false) goto L4;
        r101.remove(r104);
        goto L4
    L9:
        if (f256977d.size() == 0) goto L11;
        return;
    L11:
        if (f256976c.get() == false) goto L28;
        Context r105 = HostServiceUtilsKt.E().getApplicationContext();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L16
        r105.getContentResolver().unregisterContentObserver(f256974a);     // Catch: Throwable -> L16
        ConcurrentHashMap<Class<?>, Object> r107 = LifeServiceManager.f162660a;     // Catch: Throwable -> L16
        ((d) LifeServiceManager.b(d.class)).b(r105, f256975b);     // Catch: Throwable -> L16
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        f256976c.set(false);
        a r108 = (a) f256978e.getValue();
        r108.f256979a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        r108.f256979a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r108.f256979a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        return;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
