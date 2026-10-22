package com.bytedance.android.livesdk.livecommerce.intro.controller;

import com.bytedance.android.ec.core.utils.ECLifecycleOwnerAdapter;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ RoomContextController a;

        public a(RoomContextController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = g.a;     // Catch: Throwable -> L4
            RoomContextController r1 = this.a;     // Catch: Throwable -> L4
            OptCardUtil.b(null, "call onCardLoadFinish isShow=true");     // Catch: Throwable -> L4
            r1.A().t.Y();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r0 = (String) this.a.invoke();     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            int r1 = ECSdk.a;     // Catch: Throwable -> L8
            ca3.c r2 = (ca3.c) ECSdk.a(ca3.c.class);     // Catch: Throwable -> L8
            if (r2 == null) goto L15;
            r2.b("live", CollectionsKt.mutableListOf(new String[]{r0}), "card");     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    public static ECLivePerformanceMonitor a(RoomContextController r1) {
        Intrinsics.checkNotNullParameter(r1, "roomContextController");
        ECContext r2 = r1.r();
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r3 = r2.getEcLivePerformanceMonitor();
        if (r3 == null) goto L7;
        return (ECLivePerformanceMonitor) r3.getValue();
    L7:
        return null;
    }

    public static ECLifecycleOwnerAdapter b(RoomContextController r1) {
        Intrinsics.checkNotNullParameter(r1, "roomContextController");
        ECContext r2 = r1.r();
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.i<LiveRoomLifecycleOwner> r3 = r2.getLifecycleOwner();
        if (r3 == null) goto L10;
        LiveRoomLifecycleOwner r4 = (LiveRoomLifecycleOwner) r3.getValue();
        if (r4 == null) goto L10;
        return r4;
    L10:
        return ECQuickUtilKt.b;
    }

    public static void c(boolean r1, Function0 r2, RoomContextController r3) {
        Intrinsics.checkNotNullParameter(r2, "schemeProvider");
        Intrinsics.checkNotNullParameter(r3, "roomContextController");
        if (r1 == true) goto L5;
        UtilityKotlinExtentionsKt.b.post(new a(r3));
    L5:
        UtilityKotlinExtentionsKt.b.post(new b(r2));
    }
}
