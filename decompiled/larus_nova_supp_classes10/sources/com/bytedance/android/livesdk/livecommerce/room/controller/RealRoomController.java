package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.event.v1;
import com.bytedance.android.livesdk.livecommerce.kmp.ECLiveKmpABUtils;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RealRoomController extends com.bytedance.android.livesdk.livecommerce.room.controller.a {
    public boolean A;
    public boolean B;
    public boolean C;
    public ECContext D;
    public final Lazy E;
    public final List<z> F;
    public final boolean G;
    public final String H;
    public final String I;
    public final LiveRoomProvider.ECProviderSource J;
    public final boolean K;
    public boolean g;
    public boolean h;
    public LiveRoomParams i;
    public final MutableLiveData<LiveRoomParams> j;
    public final RealRoomController$roomResources$1 k;
    public final LinkedList<com.bytedance.android.livesdk.livecommerce.room.api.b> l;
    public final RoomContextController m;
    public final com.bytedance.android.livesdk.livecommerce.messagev2.a n;
    public final com.bytedance.android.livesdk.livecommerce.room.controller.business.c o;
    public final FlashController p;
    public final com.bytedance.android.livesdk.livecommerce.room.controller.business.n q;
    public final PromotionListController r;
    public final com.bytedance.android.livesdk.livecommerce.room.controller.business.x s;
    public final EntryController t;
    public final ExtraController u;
    public final com.bytedance.android.livesdk.livecommerce.room.controller.business.u v;
    public final com.bytedance.android.livesdk.livecommerce.kmp.b w;
    public final com.bytedance.android.livesdk.livecommerce.room.controller.business.q x;
    public final com.bytedance.android.livesdk.livecommerce.room.controller.business.a y;
    public boolean z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ RealRoomController a;

        public b(RealRoomController r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if ((!Intrinsics.areEqual(r3, (Boolean) ((MutableLiveData) this.a.k.a.getValue()).getValue())) == false) goto L6;
            ((MutableLiveData) this.a.k.a.getValue()).setValue(r3);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ RealRoomController a;

        public c(RealRoomController r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if ((!Intrinsics.areEqual(r3, (Boolean) ((MutableLiveData) this.a.k.a.getValue()).getValue())) == false) goto L6;
            ((MutableLiveData) this.a.k.a.getValue()).setValue(r3);
            return;
        }
    }

    public static final class d implements com.bytedance.android.livesdk.livecommerce.room.j {
        public final /* synthetic */ RealRoomController a;

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final String a() {
            return this.a.m.D();
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final RoomContextController b() {
            return this.a.m;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final com.bytedance.android.livesdk.livecommerce.room.model.g c() {
            return new com.bytedance.android.livesdk.livecommerce.room.model.g(this.a.k.k(), this.a.m);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final com.bytedance.android.livesdk.livecommerce.messagev2.b d() {
            return this.a.n.h;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final com.bytedance.android.ec.adapter.api.state.a e() {
            RealRoomController r0 = this.a;
            if (r0.c == null) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L10;
            return null;
        L10:
            return r0.k.i();
        L5:
            r1 = false;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final EntryController f() {
            return this.a.t;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final EntryController g() {
            return this.a.t;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public Context getContext() {
            return this.a.k.context();
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final EntryController h() {
            return this.a.t;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final boolean isAnchor() {
            return this.a.m.s();
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final com.bytedance.android.livesdk.livecommerce.room.api.c k() {
            RealRoomController r0 = this.a;
            if (r0.d == null) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L10;
            return null;
        L10:
            return r0.k.e();
        L5:
            r1 = false;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final boolean l() {
            return this.a.t.K;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final String roomId() {
            return this.a.m.B();
        }

        public d(RealRoomController r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c i(String r3) {
            if (r3 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L15;
            if ((!Intrinsics.areEqual(r3, roomId())) == false) goto L15;
            return null;
        L15:
            return this.a.q.e;
        L5:
            if (r3.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final void j(String r3) {
            if (r3 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
        L13:
            this.a.q.getClass();
            return;
        L11:
            if ((!Intrinsics.areEqual(r3, roomId())) == false) goto L13;
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final oj2.a m(String r8) {
            Iterator<T> r0 = this.a.r.d.iterator();
        L4:
            if (r0.hasNext() == false) goto L27;
            Object r1 = r0.next();
            PromotionListController.b r3 = (PromotionListController.b) r1;
            boolean r4 = false;
            if (r8 != null) goto L8;
        L11:
            boolean r6 = true;
        L12:
            if (r6 == true) goto L14;
        L15:
            if (r8 != null) goto L17;
        L20:
            boolean r7 = true;
        L21:
            if (r7 == true) goto L25;
            if (Intrinsics.areEqual(r8, r3.c) == false) goto L25;
        L24:
            r4 = true;
        L25:
            if (r4 == false) goto L4;
        L28:
            PromotionListController.b r2 = (PromotionListController.b) r1;
            if (r2 != null) goto L31;
            return null;
        L31:
            return r2.b;
        L17:
            if (r8.length() == 0) goto L20;
            r7 = false;
            goto L21
        L14:
            if (r3.d == true) goto L24;
        L8:
            if (r8.length() == 0) goto L11;
            r6 = false;
            goto L12
        L27:
            r1 = null;
            goto L28
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o n(String r3) {
            if (r3 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L15;
            if ((!Intrinsics.areEqual(r3, roomId())) == false) goto L15;
            return null;
        L15:
            return this.a.q.f;
        L5:
            if (r3.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final lj2.a o(String r8) {
            Iterator<T> r0 = this.a.r.d.iterator();
        L4:
            if (r0.hasNext() == false) goto L27;
            Object r1 = r0.next();
            PromotionListController.b r3 = (PromotionListController.b) r1;
            boolean r4 = false;
            if (r8 != null) goto L8;
        L11:
            boolean r6 = true;
        L12:
            if (r6 == true) goto L14;
        L15:
            if (r8 != null) goto L17;
        L20:
            boolean r7 = true;
        L21:
            if (r7 == true) goto L25;
            if (Intrinsics.areEqual(r8, r3.c) == false) goto L25;
        L24:
            r4 = true;
        L25:
            if (r4 == false) goto L4;
        L28:
            PromotionListController.b r2 = (PromotionListController.b) r1;
            if (r2 != null) goto L31;
            return null;
        L31:
            return r2.a;
        L17:
            if (r8.length() == 0) goto L20;
            r7 = false;
            goto L21
        L14:
            if (r3.d == true) goto L24;
        L8:
            if (r8.length() == 0) goto L11;
            r6 = false;
            goto L12
        L27:
            r1 = null;
            goto L28
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final fh2.a p(String r3) {
            if (r3 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L15;
            if ((!Intrinsics.areEqual(r3, roomId())) == false) goto L15;
            return null;
        L15:
            return this.a.r.c;
        L5:
            if (r3.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.j
        public final com.bytedance.android.livesdk.livecommerce.intro.message.a q(String r3) {
            if (r3 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L15;
            if ((!Intrinsics.areEqual(r3, roomId())) == false) goto L15;
            return null;
        L15:
            return this.a.q.g;
        L5:
            if (r3.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onActivityCreated() {
        this.B = true;
        ECLiveEntranceMonitor.trace$default("onActivityCreated roomId: " + this.H, "RealRoomController", false, 4, null);
        q("onActivityCreated");
        o(AnonymousClass1.INSTANCE);
        int r1 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onActivityCreated", new JSONObject());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        this.e = null;
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        ECLiveEntranceMonitor.trace$default("onDestroy roomId: " + this.H, "RealRoomController", false, 4, null);
        q("onDestroy");
        LiveRoomLifecycleOwner r2 = (LiveRoomLifecycleOwner) this.k.k().getLifecycleOwner().getValue();
        if (r2.a.getCurrentState().isAtLeast(Lifecycle.State.CREATED) == true) goto L28;
    L11:
        h();
        o(AnonymousClass2.INSTANCE);
        int r3 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onDestroy", new JSONObject());
        ECContext r1 = this.D;
        if (r1 == null) goto L18;
        com.bytedance.live.datacontext.i<bk2.b> r4 = r1.getDisposableContext();
        if (r4 == null) goto L18;
        bk2.b r5 = (bk2.b) r4.getValue();
        if (r5 == null) goto L18;
        r5.clearDisposable();
    L18:
        ECContextContainer r6 = (ECContextContainer) this.E.getValue();
        Pair<ECContext, ? extends Disposable> r7 = r6.a;
        if (r7 == null) goto L24;
        Disposable r8 = (Disposable) r7.getSecond();
        if (r8 == null) goto L24;
        r8.dispose();
        r6.a = null;
    L24:
        this.C = false;
        this.A = false;
        this.B = false;
        if (l() == false) goto L30;
        Lazy r0 = LiveRoomProvider.a;
        String r9 = this.H;
        String r10 = this.I;
        Intrinsics.checkNotNullParameter(r9, "roomId");
        Intrinsics.checkNotNullParameter(r10, "uniqueKey");
        LiveRoomProvider.d.remove(r9);
        return;
    L30:
        return;
    L28:
        r2.a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        this.e = null;
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        ECLiveEntranceMonitor.trace$default("onExitRoom roomId: " + this.H, "RealRoomController", false, 4, null);
        q("onExitRoom");
        o(C03141.INSTANCE);
        int r1 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onExitRoom", new JSONObject());
        h();
        CoreRequests.a.clear();
        n();
        WeakReference<com.bytedance.android.livesdk.livecommerce.room.api.c> r0 = yj2.b.a;
        if (r0 == null) goto L8;
        r0.clear();
    L8:
        ECContext r2 = this.D;
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.i<bk2.b> r3 = r2.getDisposableContext();
        if (r3 == null) goto L15;
        bk2.b r4 = (bk2.b) r3.getValue();
        if (r4 == null) goto L15;
        r4.clearDisposable();
    L15:
        com.bytedance.android.ec.core.opt.ab.d.a();
    }

    public final void h() {
        if (this.b == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
        Context r2 = getContext();
        r1.getClass();
        if (r2 == null) goto L11;
        Activity r3 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r2);
        ShoppingAsyncInflater.d.remove(r3);
    L11:
        Map r4 = ShoppingAsyncCacheInflater.d;
        Context r5 = getContext();
        if (r5 == null) goto L20;
        Activity r6 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r5);
        if (r6 == null) goto L19;
        ShoppingAsyncCacheInflater.d.remove(r6);
        return;
    L19:
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean l() {
        if (this.J != LiveRoomProvider.ECProviderSource.PREVIEW) goto L5;
        return true;
    L5:
        return false;
    }

    public final void n() {
        Iterator<T> r0 = this.F.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((z) r0.next()).onLiveEnd();
        goto L4
    L6:
        ((ArrayList) this.F).clear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
        ECLiveEntranceMonitor.trace$default("onCreate roomId: " + this.H, "RealRoomController", false, 4, null);
        this.C = true;
        ECContext r0 = this.D;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        if (r0.isCleared() == true) goto L6;
    L7:
        ECContextContainer r1 = (ECContextContainer) this.E.getValue();
        ECContext r2 = this.D;
        Intrinsics.checkNotNull(r2);
        r1.a(r2);
        if (this.z == false) goto L10;
        ((ECContextContainer) this.E.getValue()).b(b());
    L10:
        q("onCreate");
        LiveRoomLifecycleOwner r3 = (LiveRoomLifecycleOwner) this.k.k().getLifecycleOwner().getValue();
        r3.getClass();
        r3.a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);     // Catch: Exception -> L13
    L15:
        o(C03111.INSTANCE);
        int r4 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onCreate", new JSONObject());
        this.g = false;
        this.h = false;
        return;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L6:
        this.D = new ECContext(l());
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroyView() {
        q("onDestroyView");
        o(C03121.INSTANCE);
        int r1 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onDestroyView", new JSONObject());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onEnterRoomPrepared() {
        q("onEnterRoomPrepared");
        o(C03131.INSTANCE);
        int r1 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onEnterRoomPrepared", new JSONObject());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onPause() {
        o(C03151.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onResume() {
        o(C03161.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onRoomVisible() {
        q("onRoomVisible");
        o(C03171.INSTANCE);
        if (this.c == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        Application.ActivityLifecycleCallbacks r2 = ControllerCenter.a;
        String r3 = this.H;
        String r4 = this.I;
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "roomUniqueKey");
        ControllerCenter.c = r3;
        ControllerCenter.d = r4;
    L8:
        int r5 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onRoomVisible", new JSONObject());
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStart() {
        q("onStart");
        LiveRoomLifecycleOwner r1 = (LiveRoomLifecycleOwner) this.k.k().getLifecycleOwner().getValue();
        r1.getClass();
        r1.a.handleLifecycleEvent(Lifecycle.Event.ON_START);     // Catch: Exception -> L5
    L7:
        o(C03221.INSTANCE);
        int r2 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onStart", new JSONObject());
        if (this.c == null) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
        return;
    L13:
        if ((!Intrinsics.areEqual(ControllerCenter.c, this.H)) == false) goto L19;
        a(b());
        return;
    L19:
        return;
    L10:
        r0 = false;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStop() {
        q("onStop");
        LiveRoomLifecycleOwner r1 = (LiveRoomLifecycleOwner) this.k.k().getLifecycleOwner().getValue();
        r1.getClass();
        r1.a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);     // Catch: Exception -> L5
    L7:
        o(C03231.INSTANCE);
        int r2 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onStop", new JSONObject());
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onWidgetLoadFinished() {
        boolean r2 = false;
        ECLiveEntranceMonitor.trace$default("onWidgetLoadFinished roomId: " + this.H, "RealRoomController", false, 4, null);
        boolean r0 = this.A;
        if (r0 == true) goto L5;
    L10:
        new v1(MapsKt.mapOf(new Pair[]{TuplesKt.to("contextAttached", String.valueOf(r0)), TuplesKt.to("activityCreated", String.valueOf(this.B)), TuplesKt.to("dataContextAvailable", String.valueOf(this.C))}), this.H).k();
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        q("onWidgetLoadFinished");
        o(C03241.INSTANCE);
        int r1 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onWidgetLoadFinished", new JSONObject());
        return;
    L5:
        if (this.B == false) goto L10;
        if (this.C == false) goto L10;
        r2 = true;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void a(final com.bytedance.android.ec.adapter.api.state.a r4) {
        Intrinsics.checkNotNullParameter(r4, BaseCoreViewModel.CORE_TAG_STATE);
        super.a(r4);
        k(r4);
        q("onRoomStatusChanged");
        o(new RealRoomController$onRoomStatusChanged$1(r4));
        Bundle r1 = r4.n;
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.getInt("EXTRA_INT_SHOW_CART") != 1) goto L7;
    L8:
        if (r2 == false) goto L11;
        int r3 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onRoomStatusChanged", com.bytedance.android.ec.adapter.api.state.b.a(r4));
        return;
    L11:
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void d(final com.bytedance.android.livesdk.livecommerce.room.api.e r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.a = r3;
        q("onViewHandlerAttached");
        o(new RealRoomController$onViewHandlerAttached$1(r3));
        int r4 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onViewHandlerAttached", new JSONObject());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void e(final com.bytedance.android.livesdk.livecommerce.room.api.f r4) {
        Intrinsics.checkNotNullParameter(r4, "eventHub");
        Intrinsics.checkNotNullParameter(r4, "eventHub");
        this.e = r4;
        if (this.k.a.isInitialized() == true) goto L5;
    L14:
        q("onRoomEventHubAttached");
        o(new RealRoomController$onRoomEventHubAttached$2(r4));
        int r5 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onRoomEventHubAttached", new JSONObject());
        return;
    L5:
        if ((!Intrinsics.areEqual((Boolean) r4.getPlaying().getValue(), (Boolean) ((MutableLiveData) this.k.a.getValue()).getValue())) == false) goto L8;
        ((MutableLiveData) this.k.a.getValue()).setValue(r4.getPlaying().getValue());
    L8:
        if ((getContext() instanceof LifecycleOwner) == false) goto L14;
        MutableLiveData<Boolean> r0 = r4.getPlaying();
        LifecycleOwner r1 = getContext();
        if (r1 == null) goto L13;
        r0.observe(r1, new b(this));
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public final LiveRoomParams f(com.bytedance.android.ec.adapter.api.state.a r19) {
        if (r19 == null) goto L5;
        com.bytedance.android.ec.adapter.api.state.a r5 = r19;
    L12:
        if (r5 == null) goto L15;
        com.bytedance.android.ec.common.api.jump.model.b r1 = com.bytedance.android.ec.common.api.jump.model.b.a;
        KClass r2 = Reflection.getOrCreateKotlinClass(LiveRoomParams.class);
        String r4 = this.I;
        Function0<Boolean> r6 = new RealRoomController$buildLiveRoomParams$1(this);
        int r3 = w.h;
        RoomContextController r7 = this.m;
        Intrinsics.checkNotNullParameter(r7, "roomContextController");
        return r1.buildParams(r2, new LiveRoomParamsFactory(r4, r5, r6, ControllerCenter.b(r7).a(), this.u.H(), new RealRoomController$buildLiveRoomParams$2(this), new RealRoomController$buildLiveRoomParams$3(this), new RealRoomController$buildLiveRoomParams$4(this), new RealRoomController$buildLiveRoomParams$5(this), new RealRoomController$buildLiveRoomParams$6(this), new RealRoomController$buildLiveRoomParams$7(this), w.a.a(this.m), new RealRoomController$buildLiveRoomParams$8(this)));
    L15:
        return null;
    L5:
        if (this.c == null) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == false) goto L10;
        r5 = b();
        goto L12
    L10:
        r5 = null;
        goto L12
    L7:
        r8 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void g(final com.bytedance.android.livesdk.livecommerce.room.api.d r3) {
        Intrinsics.checkNotNullParameter(r3, "messageHandler");
        Intrinsics.checkNotNullParameter(r3, "messageHandler");
        q("onMessageHandlerAttached");
        o(new RealRoomController$onMessageHandlerAttached$1(r3));
        int r4 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onMessageHandlerAttached", new JSONObject());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void i(final com.bytedance.android.livesdk.livecommerce.room.api.c r3) {
        Intrinsics.checkNotNullParameter(r3, "functionHandler");
        Intrinsics.checkNotNullParameter(r3, "functionHandler");
        this.d = r3;
        WeakReference<com.bytedance.android.livesdk.livecommerce.room.api.c> r0 = yj2.b.a;
        Intrinsics.checkNotNullParameter(r3, "controller");
        WeakReference<com.bytedance.android.livesdk.livecommerce.room.api.c> r1 = yj2.b.a;
        if (r1 == null) goto L5;
        r1.clear();
    L5:
        yj2.b.a = new WeakReference(r3);
        q("onFunctionHandlerAttached");
        o(new RealRoomController$onFunctionHandlerAttached$1(r3));
        int r4 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onFunctionHandlerAttached", new JSONObject());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void j(final com.bytedance.android.livesdk.livecommerce.room.api.h r4) {
        Intrinsics.checkNotNullParameter(r4, "eventHub");
        Intrinsics.checkNotNullParameter(r4, "eventHub");
        this.f = r4;
        if (this.k.a.isInitialized() == true) goto L5;
    L14:
        q("onVideoEventHubAttached");
        o(new RealRoomController$onVideoEventHubAttached$2(r4));
        int r5 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onVideoEventHubAttached", new JSONObject());
        return;
    L5:
        if ((!Intrinsics.areEqual((Boolean) r4.getPlaying().getValue(), (Boolean) ((MutableLiveData) this.k.a.getValue()).getValue())) == false) goto L8;
        ((MutableLiveData) this.k.a.getValue()).setValue(r4.getPlaying().getValue());
    L8:
        if ((getContext() instanceof LifecycleOwner) == false) goto L14;
        MutableLiveData<Boolean> r0 = r4.getPlaying();
        LifecycleOwner r1 = getContext();
        if (r1 == null) goto L13;
        r0.observe(r1, new c(this));
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public final void k(com.bytedance.android.ec.adapter.api.state.a r9) {
        String r0 = this.I;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r9.e = r0;
        Application.ActivityLifecycleCallbacks r1 = ControllerCenter.a;
        if (this.b == null) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        Context r3 = getContext();
    L10:
        Intrinsics.checkNotNullParameter(r9, "roomState");
        if (com.bytedance.android.livesdk.livecommerce.room.controller.b.a(r9) == false) goto L13;
        String r5 = r9.f;
        String r6 = r9.e;
        Intrinsics.checkNotNullParameter(r5, "roomId");
        Intrinsics.checkNotNullParameter(r6, "roomUniqueKey");
        ControllerCenter.c = r5;
        ControllerCenter.d = r6;
    L13:
        if (r3 == null) goto L36;
        b0 r4 = (b0) ((LinkedHashMap) ControllerCenter.b).get(Integer.valueOf(r3.hashCode()));
        if (r4 == null) goto L36;
        w r7 = r4.d;
        if (r7 == null) goto L36;
        if (Intrinsics.areEqual(r7.e, r9.f) == true) goto L36;
        r7.e = r9.f;
        if (com.bytedance.android.livesdk.livecommerce.room.model.h.a(r9) == false) goto L34;
        String r8 = r7.f;
        if (r8 != null) goto L26;
        r7.g = true;
        r7.a = r9.p;
        r7.c = null;
        r7.d = null;
    L31:
        if (r7.b != null) goto L34;
        r7.b = r9.p;
        goto L34
    L26:
        if ((!Intrinsics.areEqual(r8, r9.f)) == false) goto L28;
        r7.g = false;
        r7.a = r9.p;
        r7.c = null;
        r7.d = null;
        goto L31
    L28:
        r7.g = true;
        r7.a = r7.b;
        r7.c = null;
        r7.d = null;
    L34:
        if (r7.g == false) goto L36;
        r7.f = r9.f;
    L36:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.c = r9;
        this.z = true;
        ((ECContextContainer) this.E.getValue()).b(r9);
        LiveRoomParams r10 = f(r9);
        Lazy r11 = UIUtils.a;
        if (UIUtils.d() == false) goto L39;
        this.j.setValue(r10);
    L40:
        Unit r12 = Unit.INSTANCE;
        this.i = r10;
        return;
    L39:
        this.j.postValue(r10);
        goto L40
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    public final void m(String r9) {
        int r0 = hashCode();
        String r1 = null;
        StackTraceElement r2 = ThreadMethodProxy.currentThread().getStackTrace()[9];     // Catch: Exception -> L23
        String r3 = r2.getClassName() + '#' + r2.getMethodName();     // Catch: Exception -> L23
        String r4 = b().f;     // Catch: Exception -> L21
        b().getClass();     // Catch: Exception -> L19
        String r5 = String.valueOf(0);     // Catch: Exception -> L19
        ECContext r6 = this.D;     // Catch: Exception -> L36
        if (r6 == null) goto L12;
        com.bytedance.live.datacontext.i<String> r7 = r6.getRoomId();     // Catch: Exception -> L36
        if (r7 == null) goto L12;
        r1 = (String) r7.getValue();     // Catch: Exception -> L36
    L12:
        if ((!Intrinsics.areEqual(r4, r1)) == false) goto L25;
        ECContext r8 = this.D;     // Catch: Exception -> L36
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.i<String> r10 = r8.getRoomId();     // Catch: Exception -> L36
        if (r10 == null) goto L25;
        String r11 = (String) r10.getValue();     // Catch: Exception -> L36
    L25:
        Intrinsics.areEqual("onDestroy", r9);
        e r12 = new e();
        if (r3 != null) goto L28;
        r3 = "null";
    L28:
        Intrinsics.checkNotNullParameter(r3, "where");
        r12.f("c_where", r3);
        Intrinsics.checkNotNullParameter(r9, "method");
        r12.f("c_method", r9);
        String r13 = String.valueOf(r0);
        Intrinsics.checkNotNullParameter(r13, "hashCode");
        r12.f("c_hash_code", r13);
        if (r4 != null) goto L31;
        r4 = "null";
    L31:
        Intrinsics.checkNotNullParameter(r4, "roomId");
        r12.f("c_room_id", r4);
        if (r5 != null) goto L34;
        r5 = "null";
    L34:
        Intrinsics.checkNotNullParameter(r5, "episodeId");
        r12.f("c_episode_id", r5);
        r12.k();
        return;
    L20:
        r1 = r4;
    L22:
        String r14 = r1;
        r1 = r3;
    L24:
        r4 = r14;
        r3 = r1;
    L19:
        r5 = null;
    L21:
        r5 = null;
    L23:
        r14 = null;
        r5 = null;
        goto L24
    }

    public final void o(Function1<? super com.bytedance.android.livesdk.livecommerce.room.api.b, Unit> r3) {
        Iterator<T> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke((com.bytedance.android.livesdk.livecommerce.room.api.b) r0.next());
        goto L4
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onContextAttached(final Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r6, "context");
        this.b = r6;
        ECLiveEntranceMonitor.trace$default("onContextAttached roomId: " + this.H, "RealRoomController", false, 4, null);
        this.A = true;
        q("onContextAttached");
        o(new C03101(r6));
        int r7 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onContextAttached", new JSONObject());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificViewAttached(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "viewClassName");
        Intrinsics.checkNotNullParameter(r5, "viewClassName");
        Intrinsics.checkNotNullParameter(r5, "viewClassName");
        q("onSpecificViewAttached");
        o(new C03201(r5));
        int r2 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        String r3 = this.H;
        JSONObject r4 = new JSONObject();
        r4.put("viewClassName", r5);
        Unit r6 = Unit.INSTANCE;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(r3, "onSpecificViewAttached", r4);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificWidgetLoadFinished(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetClassName");
        Intrinsics.checkNotNullParameter(r5, "widgetClassName");
        Intrinsics.checkNotNullParameter(r5, "widgetClassName");
        q("onSpecificWidgetLoadFinished");
        o(new C03211(r5));
        int r2 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        String r3 = this.H;
        JSONObject r4 = new JSONObject();
        r4.put("widgetClassName", r5);
        Unit r6 = Unit.INSTANCE;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(r3, "onSpecificWidgetLoadFinished", r4);
    }

    public final void q(String r2) {
        if (this.G == true) goto L9;
        if (ControllerCenter.a() == true) goto L9;
        m(r2);
        return;
    L9:
        if (ECAppInfoService.e.isDebug() == false) goto L13;
        m(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(final Context r6, final com.bytedance.android.ec.adapter.api.state.a r7) {
        if (r7 == null) goto L4;
        this.c = r7;
    L4:
        if (r7 == null) goto L6;
        k(r7);
    L6:
        boolean r3 = false;
        ECLiveEntranceMonitor.trace$default("onLiveFinished roomId: " + this.H, "RealRoomController", false, 4, null);
        q("onLiveFinished");
        o(new RealRoomController$onLiveFinished$1(r6, r7));
        if (r7 == null) goto L13;
        Bundle r8 = r7.n;
        if (r8 == null) goto L13;
        if (r8.getInt("EXTRA_INT_SHOW_CART") != 1) goto L13;
        r3 = true;
    L13:
        if (r3 == false) goto L15;
        int r9 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(this.H, "onLiveFinished", com.bytedance.android.ec.adapter.api.state.b.a(r7));
    L15:
        h();
        n();
        com.bytedance.android.ec.core.opt.ab.d.a();
    }

    public final void p(String r4, y r5) {
        Intrinsics.checkNotNullParameter(r4, "contentType");
        Intrinsics.checkNotNullParameter(r5, "observer");
        com.bytedance.android.livesdk.livecommerce.messagev2.a r2 = this.n;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "contentType");
        Intrinsics.checkNotNullParameter(r5, "observer");
        List r0 = (List) ((HashMap) r2.f).get(r4);
        if (r0 != null) goto L6;
        HashMap r1 = (HashMap) r2.f;
        r1.put(r4, CollectionsKt.mutableListOf(new y[]{r5}));
        return;
    L6:
        if (r0.contains(r5) == true) goto L10;
        r0.add(r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificBehaviorUnload(final String r5, final boolean r6, final boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r5, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r5, "behaviorClassName");
        q("onSpecificBehaviorUnload");
        o(new C03191(r5, r6, r7));
        int r2 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        String r3 = this.H;
        JSONObject r4 = new JSONObject();
        r4.put("behaviorClassName", r5);
        r4.put("isFold", r6);
        r4.put("isFromMsg", r7);
        Unit r8 = Unit.INSTANCE;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(r3, "onSpecificBehaviorUnload", r4);
    }

    public RealRoomController(String r4, String r5, LiveRoomProvider.ECProviderSource r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "uniqueKey");
        Intrinsics.checkNotNullParameter(r6, "env");
        this.H = r4;
        this.I = r5;
        this.J = r6;
        this.K = r7;
        this.j = new MutableLiveData();
        RealRoomController$roomResources$1 r8 = new RealRoomController$roomResources$1(this);
        this.k = r8;
        d r9 = new d(this);
        LinkedList<com.bytedance.android.livesdk.livecommerce.room.api.b> r0 = new LinkedList();
        this.l = r0;
        RoomContextController r1 = new RoomContextController(r8);
        r0.add(r1);
        Unit r2 = Unit.INSTANCE;
        this.m = r1;
        r0.add(new com.bytedance.android.livesdk.livecommerce.message.b(r8, r9));
        com.bytedance.android.livesdk.livecommerce.messagev2.a r3 = new com.bytedance.android.livesdk.livecommerce.messagev2.a(r8, r9);
        r0.add(r3);
        this.n = r3;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.c r10 = new com.bytedance.android.livesdk.livecommerce.room.controller.business.c(r8);
        if (r10.v() == true) goto L5;
        r0.add(r10);
    L5:
        this.o = r10;
        FlashController r11 = new FlashController(r8);
        r0.add(r11);
        this.p = r11;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r12 = new com.bytedance.android.livesdk.livecommerce.room.controller.business.n(r8);
        r0.add(r12);
        this.q = r12;
        PromotionListController r13 = new PromotionListController(r8);
        if (r13.v() == true) goto L8;
        r0.add(r13);
    L8:
        this.r = r13;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.x r14 = new com.bytedance.android.livesdk.livecommerce.room.controller.business.x(r8);
        if (r14.v() == true) goto L11;
        r0.add(r14);
    L11:
        this.s = r14;
        EntryController r15 = new EntryController(r8);
        r0.add(r15);
        this.t = r15;
        ExtraController r16 = new ExtraController(r8);
        r0.add(r16);
        this.u = r16;
        r0.add(new com.bytedance.android.livesdk.livecommerce.room.controller.business.w(r8));
        com.bytedance.android.livesdk.livecommerce.room.controller.business.u r17 = new com.bytedance.android.livesdk.livecommerce.room.controller.business.u(r8);
        r0.add(r17);
        this.v = r17;
        if (((Boolean) ECLiveKmpABUtils.a.getValue()).booleanValue() == false) goto L14;
        com.bytedance.android.livesdk.livecommerce.kmp.b r18 = new com.bytedance.android.livesdk.livecommerce.kmp.b(r4, r5, r8);
        r0.add(r18);
    L15:
        this.w = r18;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.q r19 = new com.bytedance.android.livesdk.livecommerce.room.controller.business.q(r8);
        r0.add(r19);
        this.x = r19;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.a r20 = new com.bytedance.android.livesdk.livecommerce.room.controller.business.a(r8);
        r0.add(r20);
        this.y = r20;
        this.E = LazyKt.lazy(RealRoomController$ecContextContainer$2.INSTANCE);
        this.F = new ArrayList();
        this.G = ((Boolean) EComABUtils.getLiveSettingValue("live_tool_bar_load_opt", Boolean.FALSE)).booleanValue();
        ECLiveEntranceMonitor.trace$default("init roomId=" + r4, "RealRoomController", false, 4, null);
        return;
    L14:
        r18 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.a, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificBehaviorLoad(final String r6, final boolean r7, final boolean r8, final String r9) {
        Intrinsics.checkNotNullParameter(r6, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r9, "extraData");
        super.onSpecificBehaviorLoad(r6, r7, r8, r9);
        q("onSpecificBehaviorLoad");
        o(new C03181(r6, r7, r8, r9));
        int r3 = com.bytedance.android.livesdk.livecommerce.room.utils.c.a;
        String r4 = this.H;
        JSONObject r5 = new JSONObject();
        r5.put("behaviorClassName", r6);
        r5.put("isFold", r7);
        r5.put("isFromMsg", r8);
        r5.put("extraData", r9);
        Unit r10 = Unit.INSTANCE;
        com.bytedance.android.livesdk.livecommerce.room.utils.c.a(r4, "onSpecificBehaviorLoad", r5);
    }
}
