package com.larus.bmhome.chat.screenshot;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f308590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f308591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<WeakReference<d>> f308592c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f308593d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Activity.ScreenCaptureCallback f308594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C4068a f308595b = null;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.screenshot.i$a$a, reason: collision with other inner class name */
        public static final class C4068a implements f09.a.InterfaceC5845a {
            public C4068a() {
            }

            @Override // f09.a.InterfaceC5845a
            public final void onPaused(Activity r100) {
                Intrinsics.checkNotNullParameter(r100, "activity");
                Activity.ScreenCaptureCallback r101 = a.f308594a;
                Activity.ScreenCaptureCallback r102 = a.f308594a;
                if (r102 == null) goto L11;
                r100.unregisterScreenCaptureCallback(r102);     // Catch: Exception -> L6
                return;
            L6:
                e = move-exception;
                FLogger.f375446a.e("ScreenCaptureUtils", "unregisterScreenCaptureCallback error: ", e);
                return;
            }

            @Override // f09.a.InterfaceC5845a
            public final void onPreDestroyed(Activity r100) {
                Intrinsics.checkNotNullParameter(r100, "activity");
            }

            @Override // f09.a.InterfaceC5845a
            public final void onResumed(Activity r100) {
                Intrinsics.checkNotNullParameter(r100, "activity");
                Activity.ScreenCaptureCallback r101 = a.f308594a;
                if (a.f308594a != null) goto L12;
                a.f308594a = new h();
            L12:
                Activity.ScreenCaptureCallback r102 = a.f308594a;     // Catch: Exception -> L9
                if (r102 == null) goto L14;
                r100.registerScreenCaptureCallback(r100.getMainExecutor(), r102);     // Catch: Exception -> L9
                return;
            L14:
                return;
            L9:
                e = move-exception;
                FLogger.f375446a.e("ScreenCaptureUtils", "registerScreenCaptureCallback error: ", e);
            }

            @Override // f09.a.InterfaceC5845a
            public final void onStart(Activity r100) {
                Intrinsics.checkNotNullParameter(r100, "activity");
            }

            @Override // f09.a.InterfaceC5845a
            public final void onStopped(Activity r100) {
                Intrinsics.checkNotNullParameter(r100, "activity");
            }

            @Override // f09.a.InterfaceC5845a
            public final void onCreate(Activity r100, Bundle r101) {
                Intrinsics.checkNotNullParameter(r100, "activity");
            }
        }

        static {
            f308595b = new C4068a();
        }
    }

    static {
        f308592c = new CopyOnWriteArrayList();
        f308593d = new AtomicBoolean(false);
    }

    public static void a(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<WeakReference<d>> r102 = f308592c.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r102.next().get(), r101) == false) goto L7;
        return;
    L11:
        Context r103 = r100.getApplicationContext();
        AtomicBoolean r104 = f308593d;
        if (r104.get() == true) goto L48;
        int r105 = Build.VERSION.SDK_INT;
        if (r105 < 34) goto L29;
        Activity.ScreenCaptureCallback r106 = a.f308594a;
        f09.a r107 = AppHost.f326268a.a();
        Intrinsics.checkNotNullParameter(r107, "activityStackManager");
        r107.e(a.f308595b);
        Activity r108 = r107.getCurrentActivity();
        if (r108 != null) goto L19;
    L27:
        f308593d.set(true);
        goto L48
    L19:
        if (a.f308594a != null) goto L50;
        a.f308594a = new g();
    L50:
        Activity.ScreenCaptureCallback r109 = a.f308594a;     // Catch: Exception -> L25
        if (r109 == null) goto L27;
        r108.registerScreenCaptureCallback(r108.getMainExecutor(), r109);     // Catch: Exception -> L25
        Unit r110 = Unit.INSTANCE;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        FLogger.f375446a.e("ScreenCaptureUtils", "registerScreenCaptureCallback error: ", e);
        Unit r111 = Unit.INSTANCE;
        goto L27
    L29:
        if (f308590a != null) goto L32;
        f308590a = new c(MediaStore.Images.Media.INTERNAL_CONTENT_URI, new WeakReference(r103));
    L32:
        if (f308591b != null) goto L35;
        f308591b = new f(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new WeakReference(r103));
    L35:
        if (r105 <= 28) goto L37;
        boolean r112 = true;
    L52:
        c r113 = f308590a;     // Catch: Exception -> L46
        if (r113 == null) goto L41;
        r103.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, r112, r113);     // Catch: Exception -> L46
    L41:
        f r114 = f308591b;     // Catch: Exception -> L46
        if (r114 == null) goto L44;
        r103.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r112, r114);     // Catch: Exception -> L46
    L44:
        r104.set(true);     // Catch: Exception -> L46
    L46:
        e = move-exception;
        FLogger.f375446a.e("ScreenCaptureUtils", "registerScreenCaptureObserver error: ", e);
        goto L48
    L37:
        r112 = false;
    L48:
        f308592c.add(new WeakReference(r101));
        FLogger.f375446a.i("ScreenCaptureUtils", "addScreenCaptureListener...");
    }

    public static void b(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<WeakReference<d>> r102 = f308592c;
        Iterator<WeakReference<d>> r103 = r102.iterator();
    L6:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L17;
        WeakReference<d> r105 = r103.next();
        WeakReference<d> r106 = r105;
        Intrinsics.checkNotNullParameter(r106, "it");
        if (Intrinsics.areEqual(r106.get(), r101) == false) goto L11;
    L12:
        r104 = true;
    L14:
        if (Boolean.valueOf(r104).booleanValue() == false) goto L6;
        r102.remove(r105);
        goto L6
    L11:
        if (r106.get() != null) goto L14;
    L17:
        if (f308592c.size() != 0) goto L42;
        Context r107 = r100.getApplicationContext();
        if (f308593d.get() == false) goto L42;
        if (Build.VERSION.SDK_INT < 34) goto L46;
        Activity.ScreenCaptureCallback r108 = a.f308594a;
        f09.a r109 = AppHost.f326268a.a();
        Intrinsics.checkNotNullParameter(r109, "activityStackManager");
        r109.f(a.f308595b);
        Activity r110 = r109.getCurrentActivity();
        if (r110 == null) goto L31;
        Activity.ScreenCaptureCallback r111 = a.f308594a;
        if (r111 == null) goto L31;
        r110.unregisterScreenCaptureCallback(r111);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        FLogger.f375446a.e("ScreenCaptureUtils", "unregisterScreenCaptureCallback error: ", e);
    L31:
        f308593d.set(false);
        goto L42
    L46:
        c r112 = f308590a;     // Catch: Exception -> L39
        if (r112 == null) goto L35;
        r107.getContentResolver().unregisterContentObserver(r112);     // Catch: Exception -> L39
    L35:
        f r113 = f308591b;     // Catch: Exception -> L39
        if (r113 == null) goto L41;
        r107.getContentResolver().unregisterContentObserver(r113);     // Catch: Exception -> L39
    L41:
        f308593d.set(false);
    L39:
        e = move-exception;
        FLogger.f375446a.e("ScreenCaptureUtils", "unregisterScreenCaptureObserver error: ", e);
    L42:
        FLogger.f375446a.i("ScreenCaptureUtils", "removeScreenCaptureListener");
    }
}
