package vp1;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.model.z3;
import com.bytedance.android.livesdk.chatroom.utils.w1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes8.dex */
public class g implements jm1.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f556578n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d90.d.a f556579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vr1.k f556580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayerDescriptorList f556581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LayerDescriptorList f556582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f556583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f556584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f556585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public vp1.a f556586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Runnable> f556587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<j70.f> f556588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d90.d f556589k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final mg2.d f556590l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final jm1.a.InterfaceC6459a f556591m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f556592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f556593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f556594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f556595d;

        public b(g r100, boolean r101, boolean r102, boolean r103) {
            this.f556592a = r100;
            this.f556593b = r101;
            this.f556594c = r102;
            this.f556595d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f556592a.g(new h(this));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f556596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f556597b;

        public c(g r100, Runnable r101) {
            this.f556596a = r100;
            this.f556597b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f556596a.g(new i(this));
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f556598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f556599b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f556600a;

            public a(d r100) {
                this.f556600a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            L13:
                return;
            L3:
                if (this.f556600a.f556598a.f556590l.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L9;
                this.f556600a.f556599b.run();     // Catch: Throwable -> L6
                return;
            }
        }

        public d(g r100, Runnable r101) {
            this.f556598a = r100;
            this.f556599b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.f556598a.f556590l.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L13;
            d90.d r100 = this.f556598a.f556589k;     // Catch: Throwable -> L10
            if (r100 == null) goto L7;
            DataCenter r101 = r100.f467480h;     // Catch: Throwable -> L10
        L8:
            String r102 = c50.b.b(r101);     // Catch: Throwable -> L10
            g r103 = this.f556598a;     // Catch: Throwable -> L10
            a r104 = new a(this);     // Catch: Throwable -> L10
            r103.getClass();     // Catch: Throwable -> L10
            Intrinsics.checkNotNullParameter(r104, "$this$bind");     // Catch: Throwable -> L10
            ((ArrayList) r103.f556587i).add(r104);     // Catch: Throwable -> L10
            i0.e(r102, r104);     // Catch: Throwable -> L10
            return;
        L7:
            r101 = null;
            goto L8
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f556601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f556602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f556603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f556604d;

        public e(g r100, boolean r101, IMultiCameraView.Source r102, boolean r103, boolean r104) {
            this.f556601a = r100;
            this.f556602b = r101;
            this.f556603c = r103;
            this.f556604d = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f556601a.g(new j(this));
        }
    }

    static {
    }

    public final void d() {
        Iterator<T> r100 = this.f556587i.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Runnable r101 = (Runnable) r100.next();
        d90.d r102 = this.f556589k;
        if (r102 == null) goto L8;
        DataCenter r103 = r102.f467480h;
    L9:
        i0.k(c50.b.b(r103), r101);
        goto L4
    L8:
        r103 = null;
        goto L9
    L10:
        ((ArrayList) this.f556587i).clear();
    }

    public final j70.f e() {
        d90.d r100 = this.f556589k;
        if (r100 == null) goto L10;
        if (jr1.b.b(r100) != true) goto L10;
        if (this.f556579a != null) goto L14;
        return null;
    L14:
        return d90.d.a.B;
    L10:
        if (this.f556579a != null) goto L12;
        return null;
    L12:
        return d90.d.a.f467608z;
    }

    @Override // jm1.a
    public void onDestroy() {
        d();
        this.f556585g.clear();
        vp1.a r100 = this.f556586h;
        if (r100 == null) goto L6;
        r100.onDestroy();
        return;
    }

    @Override // jm1.a
    public void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        jm1.a.InterfaceC6459a r101 = this.f556591m;
        if (r101 == null) goto L13;
        z3 r102 = r101.e();
        if (r102 == null) goto L13;
        z3.a r103 = r102.f106990d;
        if (r103 == null) goto L13;
        PropertyOwner<Boolean> r104 = r103.f106992b;
        if (r104 == null) goto L13;
        if (r104.f64752a.booleanValue() != true) goto L13;
        r100.run();
        return;
    L13:
        jm1.a.InterfaceC6459a r105 = this.f556591m;
        if (r105 == null) goto L26;
        z3 r106 = r105.e();
        if (r106 == null) goto L27;
        z3.a r107 = r106.f106990d;
        if (r107 == null) goto L28;
        PropertyOwner<Boolean> r108 = r107.f106992b;
        if (r108 == null) goto L29;
        Disposable r109 = r108.subscribe(new c(this, r100));
        if (r109 == null) goto L30;
        RxUtilKt.c(r109, this.f556585g);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    public final void g(Runnable r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f556583e.booleanValue() == false) goto L11;
        d90.d r101 = this.f556589k;
        if (r101 == null) goto L9;
        DataCenter r102 = r101.f467480h;
    L10:
        String r103 = c50.b.b(r102);
        d r104 = new d(this, r100);
        Intrinsics.checkNotNullParameter(r104, "$this$bind");
        ((ArrayList) this.f556587i).add(r104);
        i0.e(r103, r104);
        return;
    L9:
        r102 = null;
        goto L10
    L11:
        r100.run();
    }

    public final void i(boolean r100) {
        if (this.f556584f.booleanValue() == false) goto L10;
        d90.d r101 = this.f556589k;
        if (r101 == null) goto L11;
        DataCenter r102 = r101.f467480h;
        if (r102 == null) goto L12;
        r102.put("cmd_toolbar_reload", Boolean.valueOf(r100));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j(boolean r100) {
        d90.d r101 = this.f556589k;
        if (r101 == null) goto L5;
        DataCenter r102 = r101.f467480h;
    L6:
        u r103 = r.u(r102, null, 2);
        if (r103 == null) goto L19;
        m<Boolean> r104 = r103.o0();
        if (r104 == null) goto L19;
        if (r104.getValue().booleanValue() == true) goto L19;
        if (r100 == true) goto L15;
        this.f556590l.d(mg2.e.f513712e, this.f556580b.g());
        mg2.d r105 = this.f556590l;
        f70.b r106 = mg2.e.f513710c;
        r105.d(r106, this.f556580b.a());
        this.f556590l.d(r106, this.f556580b.k());
        return;
    L15:
        if (this.f556579a == null) goto L21;
        this.f556590l.a(mg2.e.f513712e, d90.d.a.V0);
        mg2.d r107 = this.f556590l;
        f70.b r108 = mg2.e.f513710c;
        r107.a(r108, d90.d.a.f467543m);
        this.f556590l.a(r108, d90.d.a.f467529j0);
        return;
    L21:
        return;
    L19:
        ALogger.i("VSMultiCameraLayerController", "Widget will not reload/unload when change camera among groups for cameraMessageShared is not false.");
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final boolean k(boolean r100, IMultiCameraView.Source r101) {
        if (VSSettingKeys.LIVE_VS_USE_COMPONENT_STRATEGY_IN_PORTRAIT.getValue().booleanValue() == false) goto L12;
        if (r100 == false) goto L12;
        d90.d r102 = this.f556589k;
        if (r102 == null) goto L12;
        if (w1.d(r102) != true) goto L12;
        if (r101 != IMultiCameraView.Source.CameraChange) goto L12;
        return true;
    L12:
        return false;
    }

    public g(d90.d r100, mg2.d r101, jm1.a.InterfaceC6459a r102) {
        Intrinsics.checkNotNullParameter(r101, "mComponentManager");
        this.f556589k = r100;
        this.f556590l = r101;
        this.f556591m = r102;
        LayerDescriptorList r103 = null;
        DataCenter r104 = null;
        if (r100 == null) goto L5;
        d90.d.a r105 = r100.f467478f;
    L6:
        this.f556579a = r105;
        Object r106 = pm1.h.f529822d.c(vr1.k.class);
        Intrinsics.checkNotNull(r106);
        vr1.k r107 = (vr1.k) r106;
        this.f556580b = r107;
        if (r100 == null) goto L9;
        DataCenter r108 = r100.f467480h;
    L10:
        LayerDescriptorList r109 = r107.y(r108);
        if (r109 == null) goto L38;
        if (r100 == null) goto L14;
        DataCenter r110 = r100.f467480h;
    L15:
        LayerDescriptorList r111 = r107.d(r110);
        List r112 = r111;
        if (r111 != null) goto L19;
        r112 = CollectionsKt.emptyList();
    L19:
        r109.addAll(r112);
        if (r100 == null) goto L22;
        DataCenter r113 = r100.f467480h;
    L23:
        LayerDescriptorList r114 = r107.n(r113);
        List r115 = r114;
        if (r114 != null) goto L27;
        r115 = CollectionsKt.emptyList();
    L27:
        r109.addAll(r115);
        if (r100 == null) goto L30;
        DataCenter r116 = r100.f467480h;
    L31:
        LayerDescriptorList r117 = r107.w(r116);
        List r118 = r117;
        if (r117 != null) goto L35;
        r118 = CollectionsKt.emptyList();
    L35:
        r109.addAll(r118);
        LayerDescriptorList r119 = r107.s();
        if (r119 == null) goto L39;
        r109.addAll(r119);
    L39:
        this.f556581c = r109;
        if (r100 == null) goto L42;
        DataCenter r120 = r100.f467480h;
    L43:
        LayerDescriptorList r121 = r107.h(r120);
        if (r121 == null) goto L60;
        if (r100 == null) goto L47;
        DataCenter r122 = r100.f467480h;
    L48:
        LayerDescriptorList r123 = r107.i(r122);
        List r124 = r123;
        if (r123 != null) goto L52;
        r124 = CollectionsKt.emptyList();
    L52:
        r121.addAll(r124);
        if (r100 == null) goto L55;
        r104 = r100.f467480h;
    L55:
        LayerDescriptorList r125 = r107.x(r104);
        List r126 = r125;
        if (r125 != null) goto L59;
        r126 = CollectionsKt.emptyList();
    L59:
        r121.addAll(r126);
        r103 = r121;
        goto L60
    L47:
        r122 = null;
    L60:
        this.f556582d = r103;
        this.f556583e = VSSettingKeys.LIVE_CAMERA_LAYER_ACTION_USE_POST.getValue();
        this.f556584f = VSSettingKeys.LIVE_FIX_CAMERA_TOOLBAR_RELOAD.getValue();
        this.f556585g = new CompositeDisposable();
        this.f556587i = new ArrayList();
        if (r105 == null) goto L63;
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        j70.f r127 = d90.d.a.f467521h2;
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        j70.f r128 = d90.d.a.f467611z2;
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        r105.getClass();
        List<j70.f> r129 = CollectionsKt.mutableListOf(new j70.f[]{d90.d.a.I2, d90.d.a.K1, d90.d.a.f467606y2, d90.d.a.f467531j2, d90.d.a.F, d90.d.a.T1, d90.d.a.V1, d90.d.a.f467526i2, r127, d90.d.a.f467510f1, d90.d.a.f467594w0, d90.d.a.C1, d90.d.a.f467591v2, d90.d.a.S, r128, d90.d.a.f467579t0, r127, r128, d90.d.a.f467559p0, d90.d.a.U});
        r129.addAll(r107.q());
    L64:
        this.f556588j = r129;
        return;
    L63:
        r129 = CollectionsKt.emptyList();
        goto L64
    L42:
        r120 = null;
        goto L43
    L30:
        r116 = null;
        goto L31
    L22:
        r113 = null;
        goto L23
    L14:
        r110 = null;
        goto L15
    L38:
        r109 = null;
        goto L39
    L9:
        r108 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    public final void f(boolean r100, boolean r101, boolean r102) {
        DataCenter r103 = null;
        if (r100 == false) goto L41;
        i(true);
        List<j70.f> r104 = this.f556588j;
        s.i().a();
        MultiTabManagerImpl r105 = MultiTabManagerImpl.f159902e;
        d90.d r106 = this.f556589k;
        if (r106 == null) goto L7;
        DataCenter r107 = r106.f467480h;
    L8:
        ou2.b r108 = r105.l(r107);
        if (r108 == null) goto L11;
        r108.sv();
    L11:
        LayerDescriptorList r109 = this.f556581c;
        if ((r109 instanceof ArrayList) == true) goto L14;
        r109 = null;
    L14:
        if (r109 == null) goto L26;
        Iterator<j70.h<? extends h70.b>> r110 = r109.iterator();
    L17:
        if (r110.hasNext() == false) goto L26;
        j70.h<? extends h70.b> r111 = r110.next();
        d90.d r112 = this.f556589k;
        if (r112 == null) goto L21;
        j70.f r113 = r111.C(r112);
    L23:
        if (CollectionsKt.contains(r104, r113) == true) goto L17;
        if (r113 == null) goto L17;
        this.f556590l.a(mg2.e.f513710c, r113);
        goto L17
    L21:
        r113 = null;
    L26:
        LayerDescriptorList r114 = this.f556582d;
        if ((r114 instanceof ArrayList) == true) goto L29;
        r114 = null;
    L29:
        if (r114 == null) goto L62;
        Iterator<j70.h<? extends h70.b>> r115 = r114.iterator();
    L32:
        if (r115.hasNext() == false) goto L62;
        j70.h<? extends h70.b> r116 = r115.next();
        d90.d r117 = this.f556589k;
        if (r117 == null) goto L36;
        j70.f r118 = r116.C(r117);
    L38:
        if (CollectionsKt.contains(r104, r118) == true) goto L32;
        if (r118 == null) goto L32;
        this.f556590l.a(mg2.e.f513712e, r118);
        goto L32
    L36:
        r118 = null;
    L62:
        ALogger.i("WidgetLoadProperty", "camera hide widget done");
        return;
    L7:
        r107 = null;
        goto L8
    L41:
        if (r101 == true) goto L58;
        if (r102 == false) goto L57;
        i(true);
        s.i().a();
        MultiTabManagerImpl r119 = MultiTabManagerImpl.f159902e;
        d90.d r120 = this.f556589k;
        if (r120 == null) goto L46;
        r103 = r120.f467480h;
    L46:
        ou2.b r121 = r119.l(r103);
        if (r121 == null) goto L49;
        r121.sv();
    L49:
        this.f556590l.a(mg2.e.f513712e, lu2.e.f510832d);
        if (this.f556579a == null) goto L54;
        j70.f r122 = d90.d.a.Z;
        if (r122 == null) goto L54;
        this.f556590l.a(mg2.e.f513710c, r122);
    L54:
        j70.c r123 = this.f556580b.A();
        if (r123 == null) goto L57;
        this.f556590l.a(mg2.e.f513710c, r123);
    L57:
        j(true);
    L58:
        if (r102 == false) goto L62;
        i(true);
        j70.f r124 = e();
        if (r124 == null) goto L62;
        this.f556590l.a(mg2.e.f513712e, r124);
        goto L62
    }

    public final void h(boolean r100, boolean r101, boolean r102) {
        DataCenter r103 = null;
        if (r100 == false) goto L34;
        List<j70.f> r104 = this.f556588j;
        LayerDescriptorList r105 = new LayerDescriptorList();
        LayerDescriptorList r106 = new LayerDescriptorList();
        LayerDescriptorList r107 = this.f556581c;
        if ((r107 instanceof ArrayList) == true) goto L7;
        r107 = null;
    L7:
        if (r107 == null) goto L18;
        Iterator<j70.h<? extends h70.b>> r108 = r107.iterator();
    L10:
        if (r108.hasNext() == false) goto L18;
        j70.h<? extends h70.b> r109 = r108.next();
        d90.d r110 = this.f556589k;
        if (r110 == null) goto L14;
        j70.f r111 = r109.C(r110);
    L16:
        if (CollectionsKt.contains(r104, r111) == true) goto L10;
        r105.add(r109);
        goto L10
    L14:
        r111 = null;
    L18:
        LayerDescriptorList r112 = this.f556582d;
        if ((r112 instanceof ArrayList) == true) goto L21;
        r112 = null;
    L21:
        if (r112 == null) goto L32;
        Iterator<j70.h<? extends h70.b>> r113 = r112.iterator();
    L24:
        if (r113.hasNext() == false) goto L32;
        j70.h<? extends h70.b> r114 = r113.next();
        d90.d r115 = this.f556589k;
        if (r115 == null) goto L28;
        j70.f r116 = r114.C(r115);
    L30:
        if (CollectionsKt.contains(r104, r116) == true) goto L24;
        r106.add(r114);
        goto L24
    L28:
        r116 = null;
    L32:
        this.f556590l.c(mg2.e.f513710c, r105, false);
        this.f556590l.c(mg2.e.f513712e, r106, false);
    L72:
        i(false);
        ALogger.i("WidgetLoadProperty", "camera reload widget done");
        return;
    L34:
        if (r101 == true) goto L59;
        if (r102 == false) goto L58;
        s.i().a();
        MultiTabManagerImpl r117 = MultiTabManagerImpl.f159902e;
        d90.d r118 = this.f556589k;
        if (r118 == null) goto L39;
        DataCenter r119 = r118.f467480h;
    L41:
        if (r117.h(r119) == true) goto L51;
        mg2.d r120 = this.f556590l;
        f70.b r121 = mg2.e.f513710c;
        r120.d(r121, this.f556580b.j());
        d90.d r122 = this.f556589k;
        if (r122 == null) goto L58;
        z70.b r123 = r122.f483964a;
        if (r123 == null) goto L58;
        if (r123.k() != true) goto L58;
        com.bytedance.android.livesdk.widgetdescriptor.template.container.d r124 = this.f556580b.f();
        if (r124 == null) goto L58;
        this.f556590l.d(r121, r124);
        goto L58
    L51:
        s.i().c().getClass();
        this.f556590l.d(mg2.e.f513712e, new com.bytedance.android.livesdk.vscore_impl.component.tabs.d());
        s.i().a();
        d90.d r125 = this.f556589k;
        if (r125 == null) goto L54;
        DataCenter r126 = r125.f467480h;
    L55:
        ou2.b r127 = r117.l(r126);
        if (r127 == null) goto L58;
        r127.pY();
        goto L58
    L54:
        r126 = null;
        goto L55
    L39:
        r119 = null;
    L58:
        j(false);
    L59:
        s.i().a();
        MultiTabManagerImpl r128 = MultiTabManagerImpl.f159902e;
        d90.d r129 = this.f556589k;
        if (r129 == null) goto L63;
        r103 = r129.f467480h;
    L63:
        if (r128.h(r103) == true) goto L72;
        if (r102 == false) goto L72;
        mg2.d r130 = this.f556590l;
        f70.b r131 = mg2.e.f513712e;
        d90.d r132 = this.f556589k;
        if (r132 != null) goto L68;
    L70:
        j70.h<? extends h70.b> r133 = this.f556580b.c();
    L71:
        r130.d(r131, r133);
        goto L72
    L68:
        if (jr1.b.b(r132) != true) goto L70;
        r133 = this.f556580b.o();
        goto L71
    }

    @Override // jm1.a
    public void a(boolean r100, boolean r110, boolean r111, IMultiCameraView.Source r112) {
        Intrinsics.checkNotNullParameter(r112, "source");
        jm1.a.InterfaceC6459a r101 = this.f556591m;
        if (r101 == null) goto L18;
        z3 r102 = r101.e();
        if (r102 == null) goto L18;
        z3.a r103 = r102.f106990d;
        if (r103 == null) goto L18;
        PropertyOwner<Boolean> r104 = r103.f106992b;
        if (r104 == null) goto L18;
        if (r104.f64752a.booleanValue() == true) goto L18;
        if (k(r100, r112) == false) goto L18;
        if (this.f556586h == null) goto L33;
        Intrinsics.checkNotNullParameter(r112, "source");
        return;
    L33:
        return;
    L18:
        jm1.a.InterfaceC6459a r105 = this.f556591m;
        if (r105 == null) goto L31;
        z3 r106 = r105.e();
        if (r106 == null) goto L31;
        z3.a r107 = r106.f106990d;
        if (r107 == null) goto L31;
        PropertyOwner<Boolean> r108 = r107.f106992b;
        if (r108 == null) goto L31;
        if (r108.f64752a.booleanValue() == true) goto L31;
        Disposable r109 = this.f556591m.e().f106990d.f106992b.subscribe(new e(this, r110, r112, r111, r100));
        if (r109 == null) goto L34;
        RxUtilKt.c(r109, this.f556585g);
        return;
    L34:
        return;
    L31:
        h(r110, r111, r100);
    }

    @Override // jm1.a
    public void b(boolean r110, boolean r111, boolean r112, IMultiCameraView.Source r113, mg2.d r114) {
        Intrinsics.checkNotNullParameter(r113, "source");
        d();
        jm1.a.InterfaceC6459a r100 = this.f556591m;
        if (r100 == null) goto L5;
        z3 r101 = r100.e();
    L6:
        if (r101 == null) goto L22;
        z3.a r102 = r101.f106990d;
        if (r102 == null) goto L22;
        PropertyOwner<Boolean> r103 = r102.f106992b;
        if (r103 == null) goto L22;
        if (r103.f64752a.booleanValue() == true) goto L22;
        if (k(r110, r113) == false) goto L22;
        if (this.f556586h != null) goto L18;
        this.f556586h = new vp1.a(this.f556589k, this.f556590l, this.f556591m);
    L18:
        vp1.a r104 = this.f556586h;
        if (r104 == null) goto L34;
        r104.b(r110, r111, r112, r113, r114);
        return;
    L34:
        return;
    L22:
        if (r101 == null) goto L32;
        z3.a r115 = r101.f106990d;
        if (r115 == null) goto L32;
        PropertyOwner<Boolean> r116 = r115.f106992b;
        if (r116 == null) goto L32;
        if (r116.f64752a.booleanValue() == true) goto L32;
        Disposable r117 = r101.f106990d.f106992b.subscribe(new b(this, r111, r112, r110));
        if (r117 == null) goto L35;
        RxUtilKt.c(r117, this.f556585g);
        return;
    L35:
        return;
    L32:
        f(r111, r112, r110);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
