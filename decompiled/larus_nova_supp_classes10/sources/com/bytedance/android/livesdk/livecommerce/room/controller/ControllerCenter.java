package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ControllerCenter {
    public static Application.ActivityLifecycleCallbacks a;
    public static final Map<Integer, b0> b = null;
    public static String c;
    public static String d;
    public static final Lazy e = null;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r9) {
            Intrinsics.checkNotNullParameter(r9, "activity");
            Class<? super Object> r0 = r9.getClass().getSuperclass();
            if (r0 == null) goto L7;
            Class<? super Object> r1 = r0.getSuperclass();
            if (r1 == null) goto L7;
            String r2 = r1.getSimpleName();
        L9:
            if (TextUtils.equals(r2, "GenerateProxyAppCompatActivity") == false) goto L11;
        L40:
            Object r3 = com.bytedance.android.livesdk.livecommerce.room.utils.b.a(r9);     // Catch: Exception -> L21
            if (r3 == null) goto L20;
        L18:
            r9 = (Activity) r3;     // Catch: Exception -> L21
            goto L22
        L20:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");     // Catch: Exception -> L21
        L22:
            int r4 = r9.hashCode();
            Map<Integer, b0> r5 = ControllerCenter.b;
            b0 r6 = (b0) ((LinkedHashMap) r5).get(Integer.valueOf(r4));
            if (r6 == null) goto L29;
            if (ControllerCenter.a() == true) goto L27;
            c r7 = new c();
            r7.n("clear controller cache of " + r9);
            r7.k();
        L27:
            Lazy r8 = LiveRoomProvider.a;
            LiveRoomProvider.c(r6.a, r6.b, true);
            b0 r10 = r5.remove(Integer.valueOf(r4));
        L29:
            if (r5.isEmpty() == false) goto L41;
            LiveRoomProvider.c.clear();
            LiveRoomProvider.c(null, null, true);
            Context r11 = r9.getApplicationContext();
            if ((r11 instanceof Application) == true) goto L33;
            r11 = null;
        L33:
            Application r12 = (Application) r11;
            if (r12 == null) goto L36;
            r12.unregisterActivityLifecycleCallbacks(ControllerCenter.a);
        L36:
            ControllerCenter.a = null;
            return;
        L41:
            return;
        L11:
            if (TextUtils.equals(r2, "GenerateProxyActivity") == false) goto L22;
        L7:
            r2 = null;
            goto L9
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            int r4 = r3.hashCode();
            Map<Integer, b0> r0 = ControllerCenter.b;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            b0 r5 = (b0) r1.get(Integer.valueOf(r4));
            if (r5 == null) goto L6;
            String r2 = r5.a;
            Lazy r6 = LiveRoomProvider.a;
            LiveRoomProvider.c(r2, r5.b, false);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r6) {
            Intrinsics.checkNotNullParameter(r6, "activity");
            int r7 = r6.hashCode();
            b0 r8 = (b0) ((LinkedHashMap) ControllerCenter.b).get(Integer.valueOf(r7));
            if (r8 == null) goto L18;
            Object r0 = r8.c.get();
            if (r0 != null) goto L7;
            return;
        L7:
            if ((r0 instanceof ILiveRoomController) == false) goto L12;
            Lazy r1 = LiveRoomProvider.a;
            String r2 = r8.a;
            String r9 = r8.b;
            ILiveRoomController r3 = (ILiveRoomController) r0;
            Intrinsics.checkNotNullParameter(r2, "roomId");
            Intrinsics.checkNotNullParameter(r9, "uniqueKey");
            Intrinsics.checkNotNullParameter(r3, "controller");
            if ((!StringsKt.isBlank(r2)) == false) goto L20;
            LiveRoomProvider.e.put(r2, r3);
            return;
        L20:
            return;
        L12:
            if ((r0 instanceof rd.a) == false) goto L17;
            Lazy r4 = LiveRoomProvider.a;
            String r5 = r8.a;
            String r10 = r8.b;
            rd.a r11 = (rd.a) r0;
            Intrinsics.checkNotNullParameter(r5, "roomId");
            Intrinsics.checkNotNullParameter(r10, "uniqueKey");
            Intrinsics.checkNotNullParameter(r11, "controller");
            if ((!StringsKt.isBlank(r5)) == false) goto L22;
            LiveRoomProvider.e.put(r5, r11);
            return;
        L22:
            return;
        L17:
            throw new IllegalStateException("unknown controller type");
        }
    }

    public static boolean a() {
        return ((Boolean) e.getValue()).booleanValue();
    }

    static {
        b = new LinkedHashMap();
        c = "";
        d = "";
        e = LazyKt.lazy(ControllerCenter$enterRoomMethodOpt$2.INSTANCE);
    }

    public static w b(RoomContextController r2) {
        if (r2 != null) goto L4;
    L6:
        int r3 = RoomContextController.h;
        Context r4 = RoomContextController.a.a().getContext();
    L7:
        if (r4 == null) goto L15;
        Map<Integer, b0> r0 = b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        b0 r5 = (b0) r1.get(Integer.valueOf(r4.hashCode()));
        if (r5 == null) goto L13;
        w r6 = r5.d;
        if (r6 == null) goto L13;
        return r6;
    L13:
        return new w();
    L15:
        return new w();
    L4:
        if (r2.v() != true) goto L6;
        r4 = r2.getContext();
        goto L7
    }

    @JvmStatic
    public static final RealRoomController c(String r4, String r5) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        String r3 = c;
    L12:
        com.bytedance.android.livesdk.livecommerce.room.api.b r6 = null;
        if (cg4.a.a(r4) == false) goto L20;
        if (r5 != null) goto L16;
    L17:
        r0 = true;
    L18:
        if (r0 == false) goto L20;
        r5 = null;
    L22:
        Lazy r7 = LiveRoomProvider.a;
        if (r3 != null) goto L25;
        String r1 = "";
    L26:
        if (r5 != null) goto L28;
        r5 = "";
    L28:
        com.bytedance.android.livesdk.livecommerce.room.api.b r8 = LiveRoomProvider.g(r1, r5);
        if ((r8 instanceof RealRoomController) == false) goto L32;
        r6 = r8;
    L32:
        RealRoomController r9 = (RealRoomController) r6;
        if (r9 == null) goto L36;
        return r9;
    L36:
        if (a() == true) goto L43;
        Log.getStackTraceString(new Throwable());
        c r10 = new c();
        r10.n("controller of " + r3 + " not in cache");
        if (r3 != null) goto L40;
        String r11 = "null";
    L41:
        Intrinsics.checkNotNullParameter(r11, "roomId");
        r10.f("c_invoke_room_id", r11);
        r10.k();
        goto L43
    L40:
        r11 = r3;
    L43:
        if (r3 != null) goto L46;
        r3 = "";
    L46:
        return new RealRoomController(r3, "", LiveRoomProvider.ECProviderSource.DEFAULT, true);
    L25:
        r1 = r3;
        goto L26
    L16:
        if (StringsKt.isBlank(r5) == false) goto L18;
    L20:
        if (r5 != null) goto L22;
        r5 = d;
        goto L22
    L11:
        r3 = r4;
        goto L12
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static void d(Context r3, WeakReference r4, String r5, String r6) {
        if ((r3.getApplicationContext() instanceof Application) == true) goto L5;
        return;
    L5:
        int r0 = r3.hashCode();
        Map<Integer, b0> r1 = b;
        if (r1.containsKey(Integer.valueOf(r0)) == false) goto L11;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        b0 r7 = (b0) r2.get(Integer.valueOf(r0));
        if (r7 == null) goto L19;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r7.a = r5;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r7.c = r4;
        return;
    L19:
        return;
    L11:
        r1.put(Integer.valueOf(r0), new b0(r5, r6, r4));
        if (a != null) goto L18;
        a r8 = new a();
        Context r9 = r3.getApplicationContext();
        if (r9 == null) goto L17;
        ((Application) r9).registerActivityLifecycleCallbacks(r8);
        a = r8;
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }
}
