package com.bytedance.android.livesdk.livecommerce.room;

import android.app.Application;
import android.util.LruCache;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements h {
    public final ConcurrentHashMap<Pair<String, String>, Object> a;
    public final C0099a b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.a$a, reason: collision with other inner class name */
    public static final class C0099a extends LruCache<String, Object> {
        public final /* synthetic */ a a;

        public C0099a(a r1, int r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r1, String r2, Object r3, Object r4) {
            final String r5 = r2;
            super.entryRemoved(r1, r5, r3, r4);
            ConcurrentHashMap<Pair<String, String>, Object> r6 = this.a.a;
            Function1<Map.Entry<? extends Pair<? extends String, ? extends String>, ? extends Object>, Boolean> r7 = new ControllerCache$roomIdCache$1$entryRemoved$1(r5);
            CollectionsKt.removeAll(r6.entrySet(), r7);
            if (r3 == null) goto L6;
            Lazy r8 = LiveRoomProvider.a;
            LiveRoomProvider.b(r3);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.h
    public final void clear() {
        this.b.evictAll();
        this.a.clear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.h
    public final Map<String, Object> snapshot() {
        return this.b.snapshot();
    }

    public a() {
        this.a = new ConcurrentHashMap();
        Lazy r1 = LiveRoomProvider.a;
        this.b = new C0099a(this, ((Number) LiveRoomProvider.a.getValue()).intValue());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.h
    public final Object getController(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "roomId");
        Intrinsics.checkNotNullParameter(r9, "uniqueKey");
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        Iterator<T> r1 = this.a.entrySet().iterator();
    L10:
        Object r4 = null;
        if (r1.hasNext() == false) goto L20;
        Object r3 = r1.next();
        Map.Entry r5 = (Map.Entry) r3;
        if (Intrinsics.areEqual((String) ((Pair) r5.getKey()).getFirst(), r8) == true) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L10;
    L21:
        Map.Entry r7 = (Map.Entry) r3;
        if (r7 == null) goto L24;
        r4 = r7.getValue();
    L24:
        if (r4 == null) goto L26;
    L31:
        return r4;
    L26:
        if (this.b.get(r8) == null) goto L31;
        Application.ActivityLifecycleCallbacks r10 = ControllerCenter.a;
        if (ControllerCenter.b.size() > 1) goto L31;
        return this.b.get(r8);
    L15:
        if (Intrinsics.areEqual((String) ((Pair) r5.getKey()).getSecond(), r9) == false) goto L17;
        r6 = true;
        goto L18
    L20:
        r3 = null;
        goto L21
    L8:
        return this.b.get(r8);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.h
    public final void a(String r3, String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "uniqueKey");
        Intrinsics.checkNotNullParameter(r5, "controller");
        this.b.put(r3, r5);
        this.a.put(new Pair(r3, r4), r5);
    }
}
