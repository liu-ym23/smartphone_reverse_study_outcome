package com.bytedance.android.livesdk.livecommerce.room;

import android.os.Process;
import android.util.Log;
import android.util.LruCache;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.s;
import com.bytedance.android.livesdk.livecommerce.room.controller.t;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveRoomProvider {
    public static final Lazy a = null;
    public static final Map<String, String> b = null;
    public static final h c = null;
    public static final Map<String, Object> d = null;
    public static final Map<String, Object> e = null;
    public static Object f;
    public static final g g = null;
    public static final LiveRoomProvider h = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/LiveRoomProvider$ECProviderSource;", "", "PREVIEW", "DEFAULT", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ECProviderSource extends Enum<ECProviderSource> {
        public static final ECProviderSource DEFAULT = null;
        public static final ECProviderSource PREVIEW = null;
        public static final /* synthetic */ ECProviderSource[] a = null;

        static {
            ECProviderSource r1 = new ECProviderSource("PREVIEW", 0);
            PREVIEW = r1;
            ECProviderSource r2 = new ECProviderSource("DEFAULT", 1);
            DEFAULT = r2;
            a = new ECProviderSource[]{r1, r2};
        }

        public static ECProviderSource valueOf(String r1) {
            return (ECProviderSource) r27.a.a(ECProviderSource.class, r1);
        }

        public static ECProviderSource[] values() {
            return (ECProviderSource[]) a.clone();
        }

        public ECProviderSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a extends LruCache<String, Object> implements h {
        @Override // com.bytedance.android.livesdk.livecommerce.room.h
        public final void clear() {
            evictAll();
        }

        public a(int r1) {
            super(r1);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.h
        public final Object getController(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "roomId");
            Intrinsics.checkNotNullParameter(r3, "uniqueKey");
            Lazy r0 = LiveRoomProvider.a;
            if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L14;
            if (r3.length() != 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == false) goto L12;
            r2 = (String) ((LinkedHashMap) LiveRoomProvider.b).get(r2);
            if (r2 != null) goto L14;
            r2 = "";
            goto L14
        L12:
            r2 = r3;
            goto L14
        L7:
            r1 = false;
        L14:
            return get(r2);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.h
        public final void a(String r2, String r3, Object r4) {
            Intrinsics.checkNotNullParameter(r2, "roomId");
            Intrinsics.checkNotNullParameter(r3, "uniqueKey");
            Intrinsics.checkNotNullParameter(r4, "controller");
            if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L5;
            Lazy r0 = LiveRoomProvider.a;
            LiveRoomProvider.b.put(r2, r3);
            r2 = r3;
        L5:
            put(r2, r4);
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r5, String r6, Object r7, Object r8) {
            String r9 = r6;
            super.entryRemoved(r5, r9, r7, r8);
            Map<String, String> r10 = LiveRoomProvider.b;
            Iterator r0 = ((LinkedHashMap) r10).entrySet().iterator();
        L3:
            String r2 = null;
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual((String) ((Map.Entry) r1).getValue(), r9) == false) goto L3;
        L9:
            Map.Entry r3 = (Map.Entry) r1;
            if (r3 == null) goto L12;
            r2 = (String) r3.getKey();
        L12:
            if (r10 == null) goto L25;
            TypeIntrinsics.asMutableMap(r10).remove(r2);
            if (r5 == false) goto L21;
            int r11 = com.bytedance.android.livesdk.livecommerce.room.controller.d.a;
            com.bytedance.android.livesdk.livecommerce.room.controller.d.a("out of cache capacity, roomId = " + r9);
            if (ControllerCenter.a() == true) goto L21;
            com.bytedance.android.livesdk.livecommerce.room.controller.c r12 = new com.bytedance.android.livesdk.livecommerce.room.controller.c();
            r12.n("remove controller from cache");
            if (r9 != null) goto L20;
            r9 = "null";
        L20:
            Intrinsics.checkNotNullParameter(r9, "roomId");
            r12.f("c_invoke_room_id", r9);
            Intrinsics.checkNotNullParameter("DEFAULT", "env");
            r12.f("env", "DEFAULT");
        L21:
            if (r7 == null) goto L29;
            Lazy r13 = LiveRoomProvider.a;
            LiveRoomProvider.b(r7);
            return;
        L29:
            return;
        L25:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        L8:
            r1 = null;
            goto L9
        }
    }

    public LiveRoomProvider() {
    }

    public static String e() {
        String r0 = null;
        String r1 = String.valueOf(Process.myPid());     // Catch: Exception -> L8
        String r2 = null;
        r0 = com.bytedance.frameworks.baselib.network.http.util.i.b(ECAppInfoService.e.getApplicationContext());     // Catch: Exception -> L6
    L12:
        return "pid = " + r1 + ", process_name = " + r0 + ", exception = " + r2;
    L6:
        Exception e2 = e;
    L10:
        r2 = Log.getStackTraceString(e2);
    L8:
        e = move-exception;
        e2 = e;
        r1 = null;
        goto L10
    }

    static {
        h = new LiveRoomProvider();
        Lazy r0 = LazyKt.lazy(LiveRoomProvider$MAX_CACHE_SIZE$2.INSTANCE);
        a = r0;
        b = new LinkedHashMap();
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L5;
        h r1 = new com.bytedance.android.livesdk.livecommerce.room.a();
    L6:
        c = r1;
        d = new LinkedHashMap();
        e = new LinkedHashMap();
        g = new g(0);
        return;
    L5:
        r1 = new a(((Number) r0.getValue()).intValue());
        goto L6
    }

    public static String a() {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, Object>> r1 = c.snapshot().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<String, Object> r2 = r1.next();
        r0.append(r2.getKey());
        r0.append("_");
        r0.append(r2.getValue().hashCode());
        r0.append(",");
        goto L4
    L7:
        return StringsKt.removeSuffix(r0.toString(), ",");
    }

    public final String f() {
        StringBuilder r0 = new StringBuilder("provider = ");
        r0.append(hashCode());
        r0.append(", cache = ");
        h r1 = c;
        r0.append(r1.hashCode());
        r0.append(", cache_size = ");
        r0.append(r1.snapshot().size());
        return r0.toString();
    }

    public static void b(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        dm.a.a("LiveRoomProvider").i("clearController");
        if ((r2 instanceof rd.a) == false) goto L6;
        rd.a r3 = (rd.a) r2;
        r3.onExitRoom();
        r3.onDestroy();
        return;
    L6:
        if ((r2 instanceof ILiveRoomController) == false) goto L10;
        ILiveRoomController r4 = (ILiveRoomController) r2;
        r4.onExitRoom();
        r4.onDestroy();
        return;
    }

    public static com.bytedance.android.livesdk.livecommerce.room.api.b g(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "roomId");
        Intrinsics.checkNotNullParameter(r2, "uniqueKey");
        Object r3 = c.getController(r1, r2);
        if ((r3 instanceof s) == false) goto L7;
        return ((s) r3).b;
    L7:
        if ((r3 instanceof t) == true) goto L9;
        return null;
    L9:
        return ((t) r3).b;
    }

    public static void c(String r0, String r1, boolean r2) {
        if (r0 == null) goto L11;
        if (r1 == null) goto L11;
        Object r3 = e.remove(r0);
        if (r2 == true) goto L9;
        r3 = null;
    L9:
        if (r3 == null) goto L18;
        b(r3);
        return;
    L18:
        return;
    L11:
        Iterator r4 = ((LinkedHashMap) e).entrySet().iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        b(((Map.Entry) r4.next()).getValue());
        goto L13
    L15:
        ((LinkedHashMap) e).clear();
    }

    public static Object d(String r8, String r9, ECProviderSource r10, i r11) {
        Intrinsics.checkNotNullParameter(r8, "roomId");
        Intrinsics.checkNotNullParameter(r9, "uniqueKey");
        Intrinsics.checkNotNullParameter(r10, "env");
        Intrinsics.checkNotNullParameter(r11, "factory");
        ECProviderSource r1 = ECProviderSource.PREVIEW;
        if (r10 != r1) goto L14;
        Map<String, Object> r12 = d;
        Object r4 = ((LinkedHashMap) r12).get(r8);
        if (r4 != null) goto L12;
        int r5 = com.bytedance.android.livesdk.livecommerce.room.controller.d.a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = PREVIEW miss cache, generate new controller, roomId = " + r8 + ", uniqueKey = " + r9);
        r4 = r11.b(r8, r9, r1);
        if ((!StringsKt.isBlank(r8)) == false) goto L9;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = PREVIEW put into cache, roomId = " + r8 + ", uniqueKey = " + r9);
        r12.put(r8, r4);
    L13:
        return r4;
    L9:
        String r13 = LiveRoomProvider.class.getSimpleName();
        Intrinsics.checkNotNullParameter("env = PREVIEW illegal roomId", "msg");
        com.bytedance.android.livesdk.livecommerce.room.controller.d.b(r13);
        if (ControllerCenter.a() == true) goto L13;
        com.bytedance.android.livesdk.livecommerce.room.controller.c r14 = new com.bytedance.android.livesdk.livecommerce.room.controller.c();
        r14.n("env = PREVIEW get controller with a blank roomId");
        Intrinsics.checkNotNullParameter("PREVIEW", "env");
        r14.f("env", "PREVIEW");
        r14.k();
        goto L13
    L12:
        int r15 = com.bytedance.android.livesdk.livecommerce.room.controller.d.a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = PREVIEW hit cache, roomId = " + r8 + ", uniqueKey = " + r9);
        goto L13
    L14:
        h r2 = c;
        Object r6 = r2.getController(r8, r9);
        if (r6 != null) goto L20;
        r6 = ((LinkedHashMap) e).get(r8);
        if (r6 == null) goto L20;
        int r7 = com.bytedance.android.livesdk.livecommerce.room.controller.d.a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = " + r10 + " put into cache, roomId = " + r8 + ", uniqueKey = " + r9);
        r2.a(r8, r9, r6);
    L20:
        if ((r6 instanceof Object) == true) goto L22;
        r6 = null;
    L22:
        if (r6 != null) goto L29;
        int r16 = com.bytedance.android.livesdk.livecommerce.room.controller.d.a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = " + r10 + " miss cache, generate new controller, roomId = " + r8 + ", uniqueKey = " + r9);
        r6 = r11.b(r8, r9, r10);
        if ((!StringsKt.isBlank(r8)) == false) goto L26;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = " + r10 + " put into cache, roomId = " + r8 + ", uniqueKey = " + r9);
        r2.a(r8, r9, r6);
    L30:
        return r6;
    L26:
        String r17 = LiveRoomProvider.class.getSimpleName();
        Intrinsics.checkNotNullParameter("env = " + r10 + " illegal roomId", "msg");
        com.bytedance.android.livesdk.livecommerce.room.controller.d.b(r17);
        if (ControllerCenter.a() == true) goto L30;
        com.bytedance.android.livesdk.livecommerce.room.controller.c r18 = new com.bytedance.android.livesdk.livecommerce.room.controller.c();
        r18.n("env = " + r10 + " get controller with a blank roomId");
        String r19 = r10.name();
        Intrinsics.checkNotNullParameter(r19, "env");
        r18.f("env", r19);
        r18.k();
        goto L30
    L29:
        int r110 = com.bytedance.android.livesdk.livecommerce.room.controller.d.a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("hit cache, roomId = " + r8 + ", uniqueKey = " + r9);
        goto L30
    }
}
