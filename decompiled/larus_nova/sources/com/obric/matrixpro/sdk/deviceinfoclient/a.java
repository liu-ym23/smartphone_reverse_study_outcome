package com.obric.matrixpro.sdk.deviceinfoclient;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.aiagent.product.platform.impl.rom.PublicRomInfoImpl$getOSDeviceIdAsync$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HandlerThread f397034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f397035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f397036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f397037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f397038e = null;

    /* JADX INFO: renamed from: com.obric.matrixpro.sdk.deviceinfoclient.a$a, reason: collision with other inner class name */
    public interface InterfaceC4654a {
        void onError(String r100);

        void onSuccess(String r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f397039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC4654a f397040b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f397039a, r101.f397039a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f397040b, r101.f397040b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Context r100 = this.f397039a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            InterfaceC4654a r104 = this.f397040b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "OsDidRequest(context=" + this.f397039a + ", callback=" + this.f397040b + ")";
        }

        public final Context getContext() {
            return this.f397039a;
        }

        public b(Context r100, PublicRomInfoImpl$getOSDeviceIdAsync$1.a r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f397039a = r100;
            this.f397040b = r101;
        }
    }

    public a() {
    }

    static {
        f397038e = new a();
        new CopyOnWriteArrayList();
    }

    public static Cursor a(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    public static void b(Context r100, PublicRomInfoImpl$getOSDeviceIdAsync$1.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (f397037d != null) goto L6;
        f397037d = r100.getApplicationContext();
    L6:
        if (f397034a != null) goto L11;
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("DeviceInfoGetter-Worker");
        f397034a = r102;
        ThreadMethodProxy.start(r102);
        HandlerThread r103 = f397034a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
    L10:
        f397035b = new f(r103.getLooper());
        f397036c = new Handler(Looper.getMainLooper());
    L11:
        b r104 = new b(r100.getApplicationContext(), r101);
        f r105 = f397035b;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("workerHandler");
    L14:
        Message r106 = Message.obtain(r105, 1, r104);
        f r107 = f397035b;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("workerHandler");
    L17:
        r107.sendMessage(r106);
    }
}
