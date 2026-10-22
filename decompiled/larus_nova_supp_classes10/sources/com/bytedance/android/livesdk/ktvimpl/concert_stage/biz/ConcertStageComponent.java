package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ChorusUserType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.enums.ConcertBizIdType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.DynamicConcertStatusChangeEventType;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.ChorusJsbDataContext;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\u001eJ\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/concert_stage/biz/ConcertStageComponent;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lgd2/f;", "Lgd2/d;", "getConcertEarMonitor", "", "interactID", "", "setMainSingerInteractId", "Landroidx/lifecycle/ViewModelStore;", "j", "Lkotlin/Lazy;", "getViewModelStorage", "()Landroidx/lifecycle/ViewModelStore;", "viewModelStorage", "Landroid/content/Context;", "B", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mContext", "Landroid/view/ViewGroup;", "C", "Landroid/view/ViewGroup;", "getContainerView", "()Landroid/view/ViewGroup;", "containerView", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ConcertStageComponent extends FrameLayout implements Observer<KVData>, ViewModelStoreOwnerCompat, gd2.f {
    public final j A;
    public final Context B;
    public final ViewGroup C;
    public boolean a;
    public final float b;
    public float c;
    public int d;
    public final int e;
    public int f;
    public final CopyOnWriteArrayList<gd2.b> g;
    public x h;
    public FrameLayout i;
    public final Lazy j;
    public final CompositeDisposable k;
    public m l;
    public com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a m;
    public js1.a n;
    public SurfaceView o;
    public c p;
    public String q;
    public z0 r;
    public boolean s;
    public boolean t;
    public DataCenter u;
    public final ViewGroup v;
    public boolean w;
    public final ConcertStageComponent$usbReceiver$1 x;
    public final l y;
    public final i z;

    public static final class a {
    }

    static {
    }

    private final ViewModelStore getViewModelStorage() {
        return (ViewModelStore) this.j.getValue();
    }

    public final void f() {
    }

    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
    }

    public final boolean b() {
        x r0 = this.h;
        JoinChorusConcertStatus r1 = null;
        if (r0 == null) goto L5;
        JoinChorusConcertStatus r2 = r0.c;
    L7:
        if (r2 == JoinChorusConcertStatus.JOINED) goto L14;
        if (r0 == null) goto L11;
        r1 = r0.c;
    L11:
        if (r1 == JoinChorusConcertStatus.JOINING) goto L14;
        return false;
    L14:
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public final boolean d() {
        js1.a r0 = this.n;
        if (r0 == null) goto L13;
        vb6.g r1 = r0.a;
        if (r1 == null) goto L13;
        yb6.e r2 = r1.j();
        if (r2 == null) goto L13;
        yb6.n r3 = r2.K();
        if (r3 == null) goto L13;
        if (r3.e != true) goto L13;
        return true;
    L13:
        return false;
    }

    public final void onPause() {
        x r0 = this.h;
        if (r0 == null) goto L5;
        JoinChorusConcertStatus r1 = r0.c;
    L7:
        if (r1 != JoinChorusConcertStatus.JOINED) goto L15;
        js1.a r2 = this.n;
        if (r2 == null) goto L15;
        vb6.g r3 = r2.a;
        if (r3 == null) goto L15;
        yb6.e r4 = r3.j();
        if (r4 == null) goto L15;
        r4.Y("onPause");
    L15:
        w.b("ConcertStageComponent", "onPause, localJoinState = " + this.h);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onResume() {
        l(new ConcertStageComponent$updateStageSize$1(this));
        int r0 = getResources().getConfiguration().orientation;
        if (this.f == r0) goto L9;
        this.f = r0;
        DynamicConcertStatusChangeEventType r1 = DynamicConcertStatusChangeEventType.onScreenOrientationChange;
        JsonObject r2 = new JsonObject();
        if (r0 != 2) goto L7;
        String r3 = "landscape";
    L8:
        r2.addProperty("orientation", r3);
        Unit r4 = Unit.INSTANCE;
        e(new hd2.b(r1, r2));
        goto L9
    L7:
        r3 = "portrait";
    L9:
        x r5 = this.h;
        if (r5 == null) goto L12;
        JoinChorusConcertStatus r6 = r5.c;
    L14:
        if (r6 != JoinChorusConcertStatus.JOINED) goto L22;
        js1.a r7 = this.n;
        if (r7 == null) goto L22;
        vb6.g r8 = r7.a;
        if (r8 == null) goto L22;
        yb6.e r9 = r8.j();
        if (r9 == null) goto L22;
        r9.L("onResume");
    L22:
        w.b("ConcertStageComponent", "onResume, localJoinState = " + this.h);
        return;
    L12:
        r6 = null;
        goto L14
    }

    public final int k() {
        int r0 = getResources().getConfiguration().orientation;
        if (r0 != 1) goto L5;
        int r1 = Math.min(s1.y(), s1.f(375.0f));
        this.d = r1;
        this.c = r1 / this.e;
        return r1;
    L5:
        if (r0 == 2) goto L11;
        return this.d;
    L11:
        return Math.min((int) (this.e * this.c), (int) (s1.y() * this.b));
    }

    public final ViewModelStore tf() {
        return getViewModelStorage();
    }

    public gd2.d getConcertEarMonitor() {
        return this.p;
    }

    public final ViewGroup getContainerView() {
        return this.C;
    }

    public final Context getMContext() {
        return this.B;
    }

    public static final void j(final ConcertStageComponent r4) {
        if (r4.t == false) goto L5;
        return;
    L5:
        if (r4.o == null) goto L16;
        hd0.c.f().k(2);
        boolean r0 = de2.b.a;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L10;
    L13:
        r4.t = true;
        r4.l(new ConcertStageComponent$handleLinkSuccess$1(r4));
        return;
    L10:
        if (de2.b.a == true) goto L13;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("function_type2", "chorus");
        de2.b.a("livesdk_guest_connection_success", r1);
        de2.b.c = System.currentTimeMillis();
        de2.b.a = true;
        de2.b.b = false;
        goto L13
    }

    public final void a(VSChorusConcertWidget.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        w.b("ConcertStageComponent", "unregisterChorusListener, listener: " + r3);
        this.g.remove(r3);
    }

    public final void c(VSChorusConcertWidget.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        w.b("ConcertStageComponent", "registerChorusListener, listener: " + r3);
        if (this.g.contains(r3) == true) goto L6;
        this.g.add(r3);
        return;
    }

    public final void e(hd2.b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        m r1 = this.l;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r5, "event");
        JsonObject r0 = new JsonObject();
        r0.addProperty(LocationMonitorConst.TYPE, r5.a.getTypeName());
        r0.add("data", r5.b);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r6 = r1.a;
        if (r6 == null) goto L9;
        r6.sendJsEvent("onChorusConcertStatusChange", r0);
        return;
    L9:
        return;
    }

    public final JsonObject g(hd2.a r6) {
        Intrinsics.checkNotNullParameter(r6, "getStatus");
        com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a r1 = this.m;
        if (r1 == null) goto L21;
        Intrinsics.checkNotNullParameter(r6, "getStatus");
        String r0 = r6.a;
        boolean r3 = true;
        if (r0.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        return new JsonObject();
    L11:
        if (r6.getType().length() == 0) goto L14;
        r3 = false;
    L14:
        if (r3 == true) goto L24;
        ConcertBizIdType.Companion.getClass();
        ConcertBizIdType r4 = ConcertBizIdType.a.a(r0);
        ce2.a r5 = (ce2.a) ((LinkedHashMap) r1.a).get(r4);
        if (r5 == null) goto L26;
        JsonObject r7 = r5.b(r6);
        if (r7 == null) goto L26;
        return r7;
    L26:
        return new JsonObject();
    L24:
        return new JsonObject();
    L7:
        r2 = false;
        goto L8
    L21:
        return null;
    }

    public final void l(Function1<? super gd2.b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Iterator<gd2.b> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke(r0.next());
        goto L4
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        Intrinsics.checkNotNullParameter(r7, "value");
        String r0 = r7.getKey();
        int r1 = r0.hashCode();
        Object r4 = null;
        if (r1 == (-1238735384)) goto L31;
        if (r1 == (-374564286)) goto L17;
        if (r1 == 382648113) goto L10;
        return;
    L10:
        if (r0.equals("cmd_concert_stage_status") == false) goto L70;
        Object r8 = r7.getData();
        if ((r8 instanceof StageStatus) == false) goto L15;
        r4 = r8;
    L15:
        final StageStatus r5 = (StageStatus) r4;
        l(new AnonymousClass2(r5));
        return;
    L70:
        return;
    L17:
        if (r0.equals(ChorusJsbDataContext.CMD_START_RTC_ENGINE) == false) goto L72;
        this.s = true;
        if (this.r == null) goto L29;
        com.bytedance.live.datacontext.j r9 = com.bytedance.android.live.liveinteract.api.utils.m.i().getMessageManager();
        if (r9 == null) goto L29;
        vlc.d r10 = (vlc.d) r9.getValue();
        if (r10 == null) goto L29;
        tlc.d r2 = this.r;
        if (r2 == null) goto L28;
        r10.j(r2, true);
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.IMessage");
    L29:
        this.r = null;
        return;
    L72:
        return;
    L31:
        if (r0.equals(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE) == false) goto L74;
        Object r11 = r7.getData();
        if ((r11 instanceof x) == true) goto L35;
        r11 = null;
    L35:
        this.h = (x) r11;
        l(new AnonymousClass1(this));
        StringBuilder r12 = new StringBuilder("link state ");
        r12.append((Integer) ((ge1.a) hd0.c.f()).b);
        r12.append(" localJoinState ");
        x r3 = this.h;
        if (r3 == null) goto L40;
        JoinChorusConcertStatus r13 = r3.c;
        if (r13 == null) goto L40;
        Integer r14 = Integer.valueOf(r13.getValue());
    L41:
        r12.append(r14);
        w.b("ConcertStageComponent", r12.toString());
        x r15 = this.h;
        if (r15 == null) goto L46;
        JoinChorusConcertStatus r16 = r15.c;
        if (r16 == null) goto L46;
        Integer r17 = Integer.valueOf(r16.getValue());
    L47:
        int r18 = JoinChorusConcertStatus.LEAVING.getValue();
        if (r17 != null) goto L51;
    L63:
        int r19 = JoinChorusConcertStatus.JOINED.getValue();
        if (r17 != null) goto L67;
        return;
    L67:
        if (r17.intValue() != r19) goto L79;
        this.w = false;
        return;
    L79:
        return;
    L51:
        if (r17.intValue() != r18) goto L63;
        this.r = null;
        x r20 = this.h;
        if (r20 != null) goto L55;
    L56:
        x r21 = this.h;
        if (r21 != null) goto L59;
    L60:
        this.w = true;
        DataCenter r22 = this.u;
        if (r22 == null) goto L77;
        r22.put("cmd_interact_state_change", new a1(4));
        return;
    L77:
        return;
    L59:
        if (r21.b != ChorusUserType.ChorusUserType_Fallback.getType()) goto L60;
        return;
    L55:
        if (r20.b != ChorusUserType.ChorusUserType_Cdn.getType()) goto L56;
        return;
    L46:
        r17 = null;
    L40:
        r14 = null;
        goto L41
    }

    public void setMainSingerInteractId(String r3) {
        Intrinsics.checkNotNullParameter(r3, "interactID");
        w.b("ConcertStageComponent", "setMainSingerInteractId, interactID: " + r3);
        this.q = r3;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageComponent$usbReceiver$1] */
    public ConcertStageComponent(Context r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "mContext");
        Intrinsics.checkNotNullParameter(r6, "containerView");
        super(r5);
        this.B = r5;
        this.C = r6;
        this.b = 0.8f;
        this.c = 3.409091f;
        this.d = s1.f(375.0f);
        int r0 = s1.f(110.0f);
        this.e = r0;
        this.f = 1;
        this.g = new CopyOnWriteArrayList();
        this.j = LazyKt.lazy(ConcertStageComponent$viewModelStorage$2.INSTANCE);
        this.k = new CompositeDisposable();
        this.q = "";
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
        if (r1 == null) goto L5;
        r1.width = k();
        r1.height = r0;
        r6.setVisibility(0);
        r6.setLayoutParams(r1);
    L5:
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View r7 = LayoutInflater.from(r5).inflate(2131565330, r6, false);
        if ((r7 instanceof ViewGroup) == true) goto L8;
        r7 = null;
    L8:
        ViewGroup r8 = (ViewGroup) r7;
        this.v = r8;
        r6.addView(r8);
        w.b("ConcertStageComponent", "init, contentView: " + r8 + " ;; containerView: " + r6);
        this.x = new ConcertStageComponent$usbReceiver$1();
        this.y = new l(this);
        this.z = new i(this);
        this.A = new j(this);
    }

    public final void h(hd2.c r7, com.bytedance.android.live.liveinteract.jsbridge.method.h.b r8) {
        Intrinsics.checkNotNullParameter(r7, "updateStatus");
        Intrinsics.checkNotNullParameter(r8, "callback");
        com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers.a r2 = this.m;
        if (r2 == null) goto L22;
        Intrinsics.checkNotNullParameter(r7, "updateStatus");
        Intrinsics.checkNotNullParameter(r8, "callback");
        String r0 = r7.a;
        boolean r3 = true;
        if (r0.length() != 0) goto L7;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r8.a(IConcertUpdateStatusCallback.Code.Failed, "bizId is null", null);
        return;
    L12:
        if (r7.getType().length() == 0) goto L15;
        r3 = false;
    L15:
        if (r3 == false) goto L17;
        r8.a(IConcertUpdateStatusCallback.Code.Failed, "type is null", null);
        return;
    L17:
        ConcertBizIdType.Companion.getClass();
        ConcertBizIdType r4 = ConcertBizIdType.a.a(r0);
        ce2.a r5 = (ce2.a) ((LinkedHashMap) r2.a).get(r4);
        if (r5 == null) goto L20;
        r5.a(r7, r8);
        return;
    L20:
        r8.a(IConcertUpdateStatusCallback.Code.Failed, "bizId is not support", null);
        return;
    L7:
        r1 = false;
        goto L9
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void i(Context r8, ConcertStageComponent$usbReceiver$1 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
