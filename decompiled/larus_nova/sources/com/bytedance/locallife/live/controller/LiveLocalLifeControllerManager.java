package com.bytedance.locallife.live.controller;

import android.content.Context;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController;
import com.bytedance.android.livesdkapi.room.handler.IBaseLiveRoomFunctionHandler;
import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.locallife.live.experiment.d0;
import com.bytedance.locallife.live.message.LiveLocalLifeMessage;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeContext$addObserver$1;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.util.n;
import com.bytedance.locallife.live.util.o;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeRoomLifecycleOwner;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class LiveLocalLifeControllerManager extends AbsLiveRoomController implements IExternalMessageListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f259352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f259353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f259354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBaseLiveRoomFunctionHandler f259355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f259356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, Long> f259357g;

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final String businessType() {
        return "LiveLocalLife";
    }

    public final LiveLocalLifeRoomLifecycleOwner a() {
        return (LiveLocalLifeRoomLifecycleOwner) this.f259354d.getValue();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController
    public final void onPause() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259352b;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L6;
        r102.setResumed(false);
    L6:
        super.onPause();
        LiveLocalLifeRoomLifecycleOwner r103 = a();
        r103.getClass();
        r103.a().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);     // Catch: Exception -> L9
    L11:
        b(C106441.INSTANCE);
        return;
    L9:
        e = move-exception;
        e.getLocalizedMessage();
        goto L11
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController
    public final void onResume() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259352b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        LiveLocalLifeViewModel.access$setLAST_USED_UNIQUE_KEY$cp(r101);
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(this.f259352b);
        if (r102 == null) goto L6;
        r102.setResumed(true);
    L6:
        super.onResume();
        LiveLocalLifeRoomLifecycleOwner r103 = a();
        r103.getClass();
        r103.a().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);     // Catch: Exception -> L9
    L11:
        b(C106451.INSTANCE);
        return;
    L9:
        e = move-exception;
        e.getLocalizedMessage();
        goto L11
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onStart() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259352b;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L6;
        r102.setStarted(true);
    L6:
        super.onStart();
        LiveLocalLifeRoomLifecycleOwner r103 = a();
        r103.getClass();
        r103.a().handleLifecycleEvent(Lifecycle.Event.ON_START);     // Catch: Exception -> L9
    L11:
        b(C106481.INSTANCE);
        return;
    L9:
        e = move-exception;
        e.getLocalizedMessage();
        goto L11
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onStop() {
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259352b;
        r100.getClass();
        LiveLocalLifeViewModel r102 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r102 == null) goto L6;
        r102.setStarted(false);
    L6:
        super.onStop();
        LiveLocalLifeRoomLifecycleOwner r103 = a();
        r103.getClass();
        r103.a().handleLifecycleEvent(Lifecycle.Event.ON_STOP);     // Catch: Exception -> L9
    L11:
        b(C106491.INSTANCE);
        return;
    L9:
        e = move-exception;
        e.getLocalizedMessage();
        goto L11
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onActivityCreated() {
        super.onActivityCreated();
        b(AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onCreate() {
        super.onCreate();
        if (LiveLifeSaaSUtil.C() == false) goto L5;
        LiveLocalLifeViewModel.Companion r100 = LiveLocalLifeViewModel.Companion;
        String r101 = this.f259352b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        LiveLocalLifeViewModel.access$setLAST_USED_UNIQUE_KEY$cp(r101);
    L5:
        LiveLocalLifeRoomLifecycleOwner r102 = a();
        r102.getClass();
        r102.a().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);     // Catch: Exception -> L8
    L10:
        b(C106371.INSTANCE);
        LiveLocalLifeViewModel.Companion r103 = LiveLocalLifeViewModel.Companion;
        String r104 = this.f259352b;
        r103.getClass();
        LiveLocalLifeViewModel r105 = LiveLocalLifeViewModel.Companion.a(r104);
        if (r105 == null) goto L17;
        r105.setLifeCartShown(false);
        return;
    L17:
        return;
    L8:
        e = move-exception;
        e.getLocalizedMessage();
        goto L10
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onDestroy() {
        super.onDestroy();
        LiveLocalLifeRoomLifecycleOwner r100 = a();
        r100.getClass();
        r100.a().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);     // Catch: Exception -> L5
    L7:
        ILiveRoomMessageHandler r101 = getMessageHandler();
        if (r101 == null) goto L10;
        r101.removeListener(this);
    L10:
        b(C106381.INSTANCE);
        LiveLocalLifeControllerProvider r102 = LiveLocalLifeControllerProvider.f259358a;
        String r103 = this.f259352b;
        Intrinsics.checkNotNullParameter(r103, "uniqueKey");
        ALogger.i("LiveLocalLifeControllerProvider", "uniqueKey =" + r103 + " removeController}");
        LiveLocalLifeControllerProvider.f259359b.remove(r103);
        LiveLocalLifeViewModel.Companion r104 = LiveLocalLifeViewModel.Companion;
        String r105 = this.f259352b;
        r104.getClass();
        LiveLocalLifeViewModel r106 = LiveLocalLifeViewModel.Companion.a(r105);
        if (r106 == null) goto L13;
        r106.onExitRoom();
    L13:
        this.f259356f = -1;
        ((LinkedHashMap) this.f259357g).clear();
        return;
    L5:
        e = move-exception;
        e.getLocalizedMessage();
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onEnterRoomPrepared() {
        super.onEnterRoomPrepared();
        b(C106391.INSTANCE);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onExitRoom() {
        super.onExitRoom();
        LiveLocalLifeRoomLifecycleOwner r100 = a();
        r100.getClass();
        r100.a().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);     // Catch: Exception -> L5
    L7:
        ILiveRoomMessageHandler r101 = getMessageHandler();
        if (r101 == null) goto L10;
        r101.removeListener(this);
    L10:
        b(C106401.INSTANCE);
        LiveLocalLifeViewModel.Companion r102 = LiveLocalLifeViewModel.Companion;
        String r103 = this.f259352b;
        r102.getClass();
        LiveLocalLifeViewModel r104 = LiveLocalLifeViewModel.Companion.a(r103);
        if (r104 == null) goto L13;
        r104.onExitRoom();
    L13:
        LiveLocalLifeUtil.f260684b = false;
        LiveLifeSaaSUtil.g().b();
        qv6.a r105 = qv6.a.f534897a;
        Disposable r106 = qv6.a.f534900d;
        if (r106 == null) goto L19;
        r106.dispose();
        return;
    L19:
        return;
    L5:
        e = move-exception;
        e.getLocalizedMessage();
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onWidgetLoadFinished() {
        super.onWidgetLoadFinished();
        b(C106511.INSTANCE);
    }

    public final void b(Function1<? super ILiveMergeRoomController, Unit> r100) {
        Iterator<T> r101 = this.f259353c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke((d) r101.next());
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onContextAttached(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onContextAttached(r100);
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L23:
        b(new C106361(r100));
        return;
    L5:
        if (LiveLifeSaaSUtil.C() == false) goto L23;
        Map<String, WeakReference<FragmentActivity>> r101 = o.f260727c;
        final FragmentActivity r102 = (FragmentActivity) r100;
        final String r103 = this.f259352b;
        Intrinsics.checkNotNullParameter(r102, "activity");
        Intrinsics.checkNotNullParameter(r103, "uniqueKey");
        LiveLifeSaaSUtil.t().i("LiveLocalLifeContext", "set up viewModel and Activity " + r103 + " isPreview: false");
        if (r102.isFinishing() == false) goto L9;
    L22:
        LiveLocalLifeControllerProvider r104 = LiveLocalLifeControllerProvider.f259358a;
        Intrinsics.checkNotNullParameter(r102, "activity");
        goto L23
    L9:
        if (r102.isDestroyed() == true) goto L22;
        Map<String, WeakReference<FragmentActivity>> r105 = o.f260727c;
        WeakReference r106 = (WeakReference) ((LinkedHashMap) r105).get(r103);
        if (r106 == null) goto L14;
        FragmentActivity r107 = (FragmentActivity) r106.get();
    L16:
        if (Intrinsics.areEqual(r102, r107) == true) goto L19;
        r102.getLifecycle().addObserver(new LiveLocalLifeContext$addObserver$1(r102, r103));
    L19:
        r105.put(r103, new WeakReference(r102));
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r108 = LiveLocalLifeViewModel.Companion.a(r103);
        if (r108 == null) goto L22;
        r108.init(false);
        goto L22
    L14:
        r107 = null;
        goto L16
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onFunctionHandlerAttached(final IBaseLiveRoomFunctionHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "functionHandler");
        this.f259355e = r100;
        super.onFunctionHandlerAttached(r100);
        b(new C106411(r100));
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener
    public final void onMessage(tlc.d r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof LiveLocalLifeMessage) == false) goto L16;
        LiveLocalLifeMessage r111 = (LiveLocalLifeMessage) r110;
        r111.getType();
        LinkedHashMap r100 = new LinkedHashMap();
        long r101 = SystemClock.elapsedRealtime();
        long r102 = this.f259356f;
        if (r102 > 0) goto L7;
        r100.put("message_interval", "0");
        r100.put("same_type_message_interval", "0");
    L12:
        this.f259356f = r101;
        this.f259357g.put(Integer.valueOf(r111.getType()), Long.valueOf(r101));
        mv6.e r103 = r111.getMessageBody();
        Intrinsics.checkNotNull(r103);
        String r104 = "message_" + r111.getType();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f515894a = r104;
        r100.put("refresh_single_card", String.valueOf(r111.isRefreshSingleCard()));
        int r105 = qv6.m.f534923a;
        qv6.m.f(this.f259351a, r111, r100);
        Iterator<T> r106 = this.f259353c.iterator();
    L14:
        if (r106.hasNext() == false) goto L18;
        ((d) r106.next()).a(r111);
        goto L14
    L18:
        return;
    L7:
        r100.put("message_interval", String.valueOf(r101 - r102));
        Long r107 = (Long) ((LinkedHashMap) this.f259357g).get(Integer.valueOf(r111.getType()));
        if (r107 == null) goto L10;
        long r108 = r107.longValue();
    L11:
        r100.put("same_type_message_interval", String.valueOf(r101 - r108));
        goto L12
    L10:
        r108 = r101;
        goto L11
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onMessageHandlerAttached(final ILiveRoomMessageHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        super.onMessageHandlerAttached(r100);
        r100.addListener(3001, this);
        b(new C106431(r100));
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onRoomStatusChanged(final IRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        super.onRoomStatusChanged(r100);
        ALogger.i("LiveLocalLifeControllerManager", "onRoomStatusChanged: code=" + hashCode());
        b(new C106461(r100));
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onSpecificWidgetLoadFinished(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetClassName");
        super.onSpecificWidgetLoadFinished(r100);
        ALogger.i("LiveLocalLifeControllerManager", "onSpecificWidgetLoadFinished: code=" + hashCode());
        b(new C106471(r100));
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onViewHandlerAttached(final ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        super.onViewHandlerAttached(r100);
        b(new C106501(r100));
    }

    public LiveLocalLifeControllerManager(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        this.f259351a = r100;
        this.f259352b = r101;
        boolean r102 = false;
        List<d> r103 = CollectionsKt.mutableListOf(new d[]{new f(r100, r101), new e(r100, r101), new i(r100, r101), new c(r100, r101)});
        jv6.h r104 = com.bytedance.locallife.live.settings.c.f();
        if (r104 == null) goto L5;
        int r105 = r104.f();
    L6:
        if (r105 != 1) goto L8;
        r102 = true;
    L8:
        if (r102 == true) goto L11;
        r103.add(new j(r100, r101));
    L11:
        if (d0.a() == false) goto L14;
        r103.add(new b(r100, r101));
    L14:
        if (com.bytedance.locallife.live.experiment.i.a() == false) goto L16;
        n.a("life_icon_opt", null);
        r103.add(new h(r100, r101));
    L16:
        r103.add(new LiveLocalLifeRefluxController(r100, r101));
        this.f259353c = r103;
        this.f259354d = LazyKt.lazy(LiveLocalLifeControllerManager$lifecycleOwner$2.INSTANCE);
        this.f259356f = -1;
        this.f259357g = new LinkedHashMap();
        return;
    L5:
        r105 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomController, com.bytedance.android.livesdkapi.room.controller.AbsLiveRoomStateController, com.bytedance.android.livesdkapi.room.controller.ILiveRoomController
    public final void onLiveFinished(final Context r100, final IRoomState r101) {
        super.onLiveFinished(r100, r101);
        b(new C106421(r100, r101));
    }
}
