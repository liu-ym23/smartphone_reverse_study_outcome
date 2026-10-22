package com.relax;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.relax.adaptor.RelaxAdaptor;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.relax.embedding.LLog;
import com.relax.embedding.module.ModuleEcho;
import com.relax.embedding.module.NativeModuleRegistry;
import com.relax.embedding.module.PerformanceCollector;
import com.relax.embedding.module.gen.ModuleNetworkAndroid;
import com.relax.relaxframework.u2;
import com.relax.runtime.gen.GlobalState;
import com.relax.runtime.gen.LifecyclePhaseKey;
import com.relax.runtime.gen.NativeListProxy;
import com.relax.runtime.gen.OnLifeCycleCallback;
import com.relax.runtime.gen.OnMeasureCallback;
import com.relax.runtime.gen.OnSystemInfoStateCallback;
import com.relax.runtime.gen.PageConfig;
import com.relax.uirender.UIRenderRegistry;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes34.dex */
public class RelaxView extends FrameLayout implements qpa.c {
    public static boolean D;
    public static final ViewGroup.LayoutParams E = null;
    public final Object A;
    public final UIRenderRegistry.RenderType B;
    public final RuntimeType C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f404561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlutterView f404562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rpa.a f404563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.relax.v f404564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile RelaxEngine f404565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public hpa.c f404566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f404567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Runnable> f404568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f404569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f404570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, Object> f404571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ipa.b f404572l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CountDownLatch f404573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f404574n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RelaxPageConfig f404575o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.relax.g f404576p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public p f404577q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f404578r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f404579s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f404580t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f404581u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f404582v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OnLifeCycleCallback f404583w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OnMeasureCallback f404584x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList<OnSystemInfoStateCallback> f404585y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public u f404586z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404587a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f404587a.f404572l.getClass();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(RelaxView r100) {
            this.f404587a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404588a;

        @Override // java.lang.Runnable
        public final void run() {
            BackendWorker r100 = this.f404588a.f404565e.f404544c;     // Catch: Throwable -> L10
            Map<String, Object> r101 = this.f404588a.f404571k;     // Catch: Throwable -> L10
            monitor-enter(r100);     // Catch: Throwable -> L10
            r100.c(new com.relax.f(r100, r101));     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public b(RelaxView r100) {
            this.f404588a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f404589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f404590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404591c;

        @Override // java.lang.Runnable
        public final void run() {
            BackendWorker r100 = this.f404591c.f404565e.f404544c;     // Catch: Throwable -> L10
            String r101 = this.f404589a;     // Catch: Throwable -> L10
            Object r102 = this.f404590b;     // Catch: Throwable -> L10
            monitor-enter(r100);     // Catch: Throwable -> L10
            r100.c(new com.relax.c(r100, r102, r101));     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public c(RelaxView r100, String r101, Object r102) {
            this.f404591c = r100;
            this.f404589a = r101;
            this.f404590b = r102;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f404592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RelaxEventListener f404593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404594c;

        @Override // java.lang.Runnable
        public final void run() {
            BackendWorker r100 = this.f404594c.f404565e.f404544c;     // Catch: Throwable -> L10
            String r101 = this.f404592a;     // Catch: Throwable -> L10
            RelaxEventListener r102 = this.f404593b;     // Catch: Throwable -> L10
            monitor-enter(r100);     // Catch: Throwable -> L10
            r100.c(new com.relax.d(r100, r101, r102));     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public d(RelaxView r100, String r101, RelaxEventListener r102) {
            this.f404594c = r100;
            this.f404592a = r101;
            this.f404593b = r102;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f404595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RelaxEventListener f404596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404597c;

        @Override // java.lang.Runnable
        public final void run() {
            BackendWorker r100 = this.f404597c.f404565e.f404544c;     // Catch: Throwable -> L10
            String r101 = this.f404595a;     // Catch: Throwable -> L10
            RelaxEventListener r102 = this.f404596b;     // Catch: Throwable -> L10
            monitor-enter(r100);     // Catch: Throwable -> L10
            r100.c(new com.relax.e(r100, r101, r102));     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public e(RelaxView r100, String r101, RelaxEventListener r102) {
            this.f404597c = r100;
            this.f404595a = r101;
            this.f404596b = r102;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f404598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f404599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404600c;

        @Override // java.lang.Runnable
        public final void run() {
            BackendWorker r100 = this.f404600c.f404565e.f404544c;     // Catch: Throwable -> L11
            String r101 = this.f404598a;     // Catch: Throwable -> L11
            Object r102 = this.f404599b;     // Catch: Throwable -> L11
            if (r100.b() == true) goto L6;
            return;
        L6:
            if (r100.f404534a == null) goto L18;
            ByteBuffer r103 = ipa.c.b(r102);     // Catch: Throwable -> L11
            byte[] r104 = r100.f404534a.callRTSFunction(r101, r103);     // Catch: Throwable -> L11
            if (r104 == null) goto L19;
            ipa.c.a(ByteBuffer.wrap(r104));     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L18:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }

        public f(RelaxView r100, String r101, Object r102) {
            this.f404600c = r100;
            this.f404598a = r101;
            this.f404599b = r102;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404601a;

        public final void a() {
            LLog.i("RelaxView onEnterForeground:" + toString());
            RelaxEngine r100 = this.f404601a.f404565e;
            monitor-enter(r100);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (r100.f404544c.b() == true) goto L8;
            monitor-exit(r100);
            return;
        L8:
            RelaxJNI r101 = r100.f404543b;     // Catch: Throwable -> L13
            if (r101 == null) goto L11;
            r101.onEnterForeground();     // Catch: Throwable -> L13
        L11:
            monitor-exit(r100);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(RelaxView r100) {
            this.f404601a = r100;
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404602a;

        public final void a() {
            LLog.i("RelaxView onEnterBackground:" + toString());
            RelaxEngine r100 = this.f404602a.f404565e;
            monitor-enter(r100);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (r100.f404544c.b() == true) goto L8;
            monitor-exit(r100);
            return;
        L8:
            RelaxJNI r101 = r100.f404543b;     // Catch: Throwable -> L13
            if (r101 == null) goto L11;
            r101.onEnterBackground();     // Catch: Throwable -> L13
        L11:
            monitor-exit(r100);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public h(RelaxView r100) {
            this.f404602a = r100;
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404603a;

        public final void a() {
            RelaxEngine r100 = this.f404603a.f404565e;
            monitor-enter(r100);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (r100.f404544c.b() == false) goto L15;
            RelaxJNI r101 = r100.f404543b;     // Catch: Throwable -> L19
            if (r101 == null) goto L13;
            boolean r102 = ipa.c.f495326a;     // Catch: Throwable -> L19
            ByteBuffer r103 = r101.getAllTimingInfo();     // Catch: Throwable -> L19
            if (r103 == null) goto L13;
            Object r104 = ipa.c.a(r103);     // Catch: Throwable -> L19
            monitor-exit(r100);
        L17:
            HashMap r105 = (HashMap) r104;
            throw null;
        L13:
            monitor-exit(r100);
        L16:
            r104 = null;
            goto L17
        L15:
            monitor-exit(r100);
            goto L16
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public i(RelaxView r100) {
            this.f404603a = r100;
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404604a;

        @Override // java.lang.Runnable
        public final void run() {
            RelaxView r100 = this.f404604a;     // Catch: Throwable -> L4
            r100.f404572l.b(r100.f404564d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(RelaxView r100) {
            this.f404604a = r100;
        }
    }

    public class k implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404605a;

        public k(RelaxView r100) {
            this.f404605a = r100;
        }
    }

    public class l implements com.relax.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404606a;

        public l(RelaxView r100) {
            this.f404606a = r100;
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404607a;

        @Override // java.lang.Runnable
        public final void run() {
            RelaxView.e(this.f404607a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public m(RelaxView r100) {
            this.f404607a = r100;
        }
    }

    public class n implements com.relax.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404608a;

        public n(RelaxView r100) {
            this.f404608a = r100;
        }
    }

    public class o implements com.relax.o.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404609a;

        public o(RelaxView r100) {
            this.f404609a = r100;
        }
    }

    public class p implements com.relax.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404610a;

        @Override // com.relax.g.c
        public final void f() {
            this.f404610a.fireEvent("keyboardstatuschanged", a(0));
        }

        public p(RelaxView r100) {
            this.f404610a = r100;
        }

        public static Map a(int r110) {
            Long r100 = Long.valueOf(System.currentTimeMillis());
            int r101 = 0;
            Integer r102 = Integer.valueOf(r110);
            Integer r103 = Integer.valueOf(r110);
            if (r110 != 0) goto L5;
            String r111 = "off";
        L6:
            Map.Entry[] r104 = {new AbstractMap.SimpleEntry("height", r102), new AbstractMap.SimpleEntry("compatHeight", r103), new AbstractMap.SimpleEntry("status", r111)};
            HashMap r105 = new HashMap(3);
            int r106 = 0;
        L8:
            if (r106 >= 3) goto L14;
            Map.Entry r107 = r104[r106];
            Object r112 = r107.getKey();
            Objects.requireNonNull(r112);
            Object r108 = r107.getValue();
            Objects.requireNonNull(r108);
            if (r105.put(r112, r108) != null) goto L13;
            r106 = r106 + 1;
            goto L8
        L13:
            throw new IllegalArgumentException("duplicate key: " + r112);
        L14:
            Map.Entry[] r109 = {new AbstractMap.SimpleEntry("type", "keyboardstatuschanged"), new AbstractMap.SimpleEntry("timestamp", r100), new AbstractMap.SimpleEntry(PickerReporterConstants.KEY.TARGET, 0), new AbstractMap.SimpleEntry("currentTarget", 0), new AbstractMap.SimpleEntry("detail", Collections.unmodifiableMap(r105))};
            HashMap r113 = new HashMap(5);
        L15:
            if (r101 >= 5) goto L22;
            Map.Entry r114 = r109[r101];
            Object r115 = r114.getKey();
            Objects.requireNonNull(r115);
            Object r116 = r114.getValue();
            Objects.requireNonNull(r116);
            if (r113.put(r115, r116) != null) goto L20;
            r101 = r101 + 1;
            goto L15
        L20:
            throw new IllegalArgumentException("duplicate key: " + r115);
        L22:
            return Collections.unmodifiableMap(r113);
        L5:
            r111 = "on";
            goto L6
        }

        @Override // com.relax.g.c
        public final void g(int r100) {
            this.f404610a.fireEvent("keyboardstatuschanged", a(r100));
        }
    }

    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404611a;

        @Override // java.lang.Runnable
        public final void run() {
            RelaxEngine r100 = this.f404611a.f404565e;     // Catch: Throwable -> L10
            if (r100.f404544c.b() == true) goto L6;
            return;
        L6:
            if (r100.f404543b == null) goto L17;
            r100.b(true);     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public q(RelaxView r100, Configuration r101) {
            this.f404611a = r100;
        }
    }

    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f404612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f404613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RelaxView f404614c;

        @Override // java.lang.Runnable
        public final void run() {
            NativeModuleRegistry.registerObject(this.f404614c.f404565e.f404543b.getBackendWorkerPtr(), this.f404612a, this.f404613b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public r(RelaxView r100, String r101, Object r102) {
            this.f404614c = r100;
            this.f404612a = r101;
            this.f404613b = r102;
        }
    }

    public interface s {
    }

    public interface t {
        void a();
    }

    public interface u {
    }

    public interface v {
    }

    @Override // qpa.c
    public final void a() {
    }

    @Override // android.view.View
    public Object getTag() {
        return "relaxview";
    }

    public void setOnDispatchTouchEventListener(t r100) {
    }

    static {
        E = new ViewGroup.LayoutParams(-1, -1);
    }

    private UIRenderRegistry.RenderType getRenderType() {
        UIRenderRegistry.RenderType r100 = this.B;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (i6a.a.f488445a.booleanValue() == true) goto L10;
        return UIRenderRegistry.RenderType.CLAY;
    L10:
        if (i6a.a.f488446b.booleanValue() == false) goto L14;
        return UIRenderRegistry.RenderType.CLAY;
    L14:
        if (i6a.a.f488447c.booleanValue() == false) goto L18;
        return UIRenderRegistry.RenderType.LYNX_UI;
    L18:
        return UIRenderRegistry.RenderType.CLAY;
    }

    @Override // qpa.c
    public final PageConfig b() {
        RelaxPageConfig r100 = this.f404575o;
        if (r100 != null) goto L7;
        return new PageConfig(false, false);
    L7:
        return new PageConfig(r100.isEnableFlatten(), this.f404575o.isEnableLayoutOnly());
    }

    public void destroy() {
        LLog.i("RelaxView destroy: " + toString());
        com.relax.m r100 = com.relax.m.f404653b;
        getContext();
        r100.getClass();
        r100.f404654a.pop();     // Catch: EmptyStackException -> L5
    L7:
        this.f404569i = true;
        p r101 = this.f404577q;
        if (r101 == null) goto L10;
        this.f404576p.f404647k.remove(r101);
        this.f404577q = null;
    L10:
        com.relax.g r102 = this.f404576p;
        if (r102 != null) goto L13;
    L28:
        rpa.a r103 = this.f404563c;
        if (r103 == null) goto L31;
        ((lpa.f) r103).c();
        this.f404563c = null;
        this.f404564d = null;
        this.f404572l = null;
        this.f404562b = null;
    L31:
        OnLifeCycleCallback r104 = this.f404583w;
        if (r104 == null) goto L35;
        r104.invoke(LifecyclePhaseKey.OnDestroy.getValue());
    L35:
        if (this.f404565e != null) goto L37;
    L43:
        removeAllViews();
        this.f404568h = null;
        this.f404564d = null;
        this.f404571k = null;
        this.f404583w = null;
        this.f404584x = null;
        this.f404585y = null;
        return;
    L37:
        if (this.f404565e.f404544c.f404540g != RuntimeType.RuntimeTypeVM) goto L39;
        NativeModuleRegistry.unregisterFunction(this.f404565e.f404543b.getBackendWorkerPtr(), "");
    L39:
        this.f404565e.a();
        hpa.a r105 = this.f404566f.f486488a;
        if (r105 == null) goto L42;
        r105.destroy();
    L42:
        this.f404565e = null;
        this.f404567g = false;
        goto L43
    L13:
        if (r102.f404639c == false) goto L28;
        monitor-enter(r102);
    L25:
        th = move-exception;
        throw th;
    L16:
        if (r102.f404639c == true) goto L20;
        monitor-exit(r102);
        goto L28
    L20:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L22;
        r102.f404645i.post(new com.relax.i(r102));     // Catch: Throwable -> L25
    L23:
        monitor-exit(r102);
        goto L28
    L22:
        r102.c();     // Catch: Throwable -> L25
    L5:
        e = move-exception;
        LLog.e("RelaxContainerActivityLifecycleManager init error: " + e);
        goto L7
    }

    public Map<String, Object> getSources() {
        RelaxEngine r100 = this.f404565e;
        if (r100 == null) goto L21;
        String r101 = this.f404570j;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        monitor-enter(r100);
        RelaxJNI r102 = r100.f404543b;     // Catch: Throwable -> L17
        if (r102 == null) goto L14;
        Map<String, Object> r103 = r102.getSources(r101);     // Catch: Throwable -> L17
        monitor-exit(r100);
    L16:
        return r103;
    L14:
        r103 = new HashMap();     // Catch: Throwable -> L17
        monitor-exit(r100);
    L17:
        th = move-exception;
        throw th;
    L21:
        return new HashMap();
    }

    public final void h() {
        if (this.f404567g == false) goto L22;
        return;
    L22:
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (this.f404574n == true) goto L15;
        this.f404573m.await();     // Catch: InterruptedException -> L17
        BackendWorker r100 = this.f404565e.f404544c;     // Catch: InterruptedException -> L17
        monitor-enter(r100);     // Catch: InterruptedException -> L17
        r100.f404535b = Looper.getMainLooper();     // Catch: Throwable -> L12
        r100.f404537d = new Handler(r100.f404535b);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L17
    L15:
        bindRelaxEngine(this.f404565e);     // Catch: InterruptedException -> L17
        this.f404567g = true;     // Catch: InterruptedException -> L17
    }

    public void onEnterBackground() {
        f(new h(this));
        rpa.a r100 = this.f404563c;
        if (r100 == null) goto L5;
        r100.getClass();
    L5:
        OnLifeCycleCallback r101 = this.f404583w;
        if (r101 == null) goto L9;
        r101.invoke(LifecyclePhaseKey.OnBackground.getValue());
        return;
    }

    public void onEnterForeground() {
        f(new g(this));
        rpa.a r100 = this.f404563c;
        if (r100 == null) goto L5;
        r100.getClass();
    L5:
        OnLifeCycleCallback r101 = this.f404583w;
        if (r101 == null) goto L9;
        r101.invoke(LifecyclePhaseKey.OnForeground.getValue());
        return;
    }

    public void reloadAndInit() {
        com.relax.v r100 = this.f404564d;
        Map<String, Object> r101 = this.f404571k;
        destroy();
        this.f404564d = r100;
        g(getContext(), true, this.f404574n);
        setGlobalProps(r101);
    }

    @Override // qpa.c
    public final GlobalState d() {
        Resources r100 = getResources();
        DisplayMetrics r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        float r102 = r101.widthPixels;
        float r103 = r101.density;
        double r104 = r102 / r103;
        double r105 = r101.heightPixels / r103;
        double r110 = r103;
        double r111 = this.f404582v;
        if ((r100.getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r106 = true;
    L7:
        return new GlobalState(r104, r105, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, r110, r111, r106, "android", "");
    L5:
        r106 = false;
        goto L7
    }

    public boolean initRuntime() {
        h();
        return true;
    }

    public String getCurrentUrl() {
        return this.f404570j;
    }

    public com.relax.g getKeyboardEvent() {
        return this.f404576p;
    }

    public com.relax.v getRelaxViewClient() {
        return this.f404564d;
    }

    public rpa.a getUIRenderer() {
        return this.f404563c;
    }

    public static void e(final RelaxView r100) {
        ((lpa.f) r100.f404563c).c();
        r100.f404563c = null;
        r100.f404562b = null;
        r100.removeAllViews();
        Context r101 = r100.getContext();
        UIRenderRegistry.RenderType r102 = r100.getRenderType();
        lpa.f r103 = UIRenderRegistry.f405703a.get(r102).a(r101, r100.A);
        r100.f404563c = r103;
        r103.f510279c = new com.relax.t(r100);
        r103.b(r101);
        r100.f404562b = ((lpa.f) r100.f404563c).a(r101);
        rpa.a r104 = r100.f404563c;
        if (r104 == null) goto L7;
        com.relax.v r105 = r100.f404564d;
        com.lynx.clay.embedding.android.d r106 = ((lpa.f) r104).f510277a;
        lpa.e r107 = new lpa.e(r105, r100);
        r106.b();
        FlutterEngine r108 = r106.f380643b;
        if (r108 == null) goto L7;
        r108.getFlutterJNI().setTimingClient(r107);
    L7:
        rpa.a r109 = r100.f404563c;
        long r110 = r100.f404565e.f404543b.getRelaxEnginePtr();
        lpa.f r111 = (lpa.f) r109;
        if (r111.f510278b != null) goto L10;
        r111.f510278b = new RelaxAdaptor(r111.f510277a);
    L10:
        r111.f510278b.a(r110);
        r100.addView(r100.f404562b, -1, E);
        com.relax.v r112 = r100.f404564d;
        if (r112 == null) goto L14;
        r112.a();
        return;
    }

    public static synchronized void initGlobal(Context r100) {
        monitor-enter(RelaxView.class);
        initGlobal(r100, "");     // Catch: Throwable -> L7
        monitor-exit(RelaxView.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void SetNativeListProxy(NativeListProxy r100) {
        this.f404563c.getClass();
    }

    public void bindRelaxEngine(RelaxEngine r100) {
        LLog.i("RelaxView bindRelaxEngine: " + toString());
        if (this.f404569i == true) goto L61;
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.f404567g == false) goto L14;
        if (this.f404565e == null) goto L14;
        throw new RuntimeException("There is already an asynchronous engine construction running here. If you want to use another independent engine instance, please create RelaxView with autoCreateRuntimeContext = false!");
    L14:
        if (this.f404562b == null) goto L60;
        this.f404565e = r100;
        if (this.f404575o == null) goto L23;
        RelaxEngine r101 = this.f404565e;
        boolean r102 = this.f404575o.isEnableFlatten();
        boolean r103 = this.f404575o.isEnableLayoutOnly();
        if (r101.f404544c.b() == false) goto L23;
        RelaxJNI r104 = r101.f404543b;
        if (r104 == null) goto L23;
        r104.setPageConfig(r102, r103);
    L23:
        RelaxEngine r105 = this.f404565e;
        u r106 = this.f404586z;
        if (r105.f404544c.b() == false) goto L30;
        RelaxJNI r107 = r105.f404543b;
        if (r107 == null) goto L30;
        r107.setOnRootSizeChangedCallback(r106);
    L30:
        rpa.a r108 = this.f404563c;
        long r109 = this.f404565e.f404543b.getRelaxEnginePtr();
        lpa.f r110 = (lpa.f) r108;
        if (r110.f510278b != null) goto L33;
        r110.f510278b = new RelaxAdaptor(r110.f510277a);
    L33:
        r110.f510278b.a(r109);
        hpa.c r111 = this.f404566f;
        this.f404565e.f404543b.getRelaxEnginePtr();
        r111.getClass();
        hpa.a r112 = r111.f486488a;
        if (r112 == null) goto L36;
        r112.a();
    L36:
        ipa.b r113 = new ipa.b(this);
        this.f404572l = r113;
        r113.f495315a = this.f404565e;
        com.relax.v r114 = this.f404564d;
        if (r114 == null) goto L39;
        this.f404572l.b(r114);
    L39:
        this.f404572l.c("createLynxStart", this.f404561a);
        this.f404572l.c("createLynxEnd", System.currentTimeMillis());
        BackendWorker r115 = this.f404565e.f404544c;
        l r116 = new l(this);
        monitor-enter(r115);
        r115.c(new com.relax.b(r115, r116));     // Catch: Throwable -> L56
        monitor-exit(r115);
        RelaxEngine r117 = this.f404565e;
        m r118 = new m(this);
        if (r117.f404544c.b() == false) goto L50;
        RelaxJNI r119 = r117.f404543b;
        if (r119 == null) goto L50;
        r119.setOnResetCallback(r118);
    L50:
        this.f404565e.c(new n(this));
        Iterator r120 = ((ArrayList) this.f404568h).iterator();
    L52:
        if (r120.hasNext() == false) goto L54;
        ((Runnable) r120.next()).run();
        goto L52
    L54:
        ((ArrayList) this.f404568h).clear();
        this.f404567g = true;
        return;
    L56:
        th = move-exception;
        throw th;
    L60:
        throw new RuntimeException("There is no content view to bind!");
    }

    @Override // qpa.c
    public final void c(u2 r100) {
        this.f404585y.add(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    public final void f(Runnable r100) {
        if (this.f404569i == false) goto L6;
        return;
    L6:
        if (this.f404567g == false) goto L8;
        r100.run();
        return;
    L8:
        ((ArrayList) this.f404568h).add(r100);
    }

    public void getAllTimingInfo(v r100) {
        f(new i(this));
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        ArrayList<OnSystemInfoStateCallback> r101 = this.f404585y;
        if (r101 == null) goto L11;
        if (r101.isEmpty() == true) goto L11;
        GlobalState r102 = d();
        Iterator<OnSystemInfoStateCallback> r103 = this.f404585y.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r103.next().invoke(r102);
    L11:
        if (this.f404565e == null) goto L19;
        RelaxEngine r104 = this.f404565e;
        if (r104.f404544c.b() == true) goto L16;
        return;
    L16:
        if (r104.f404543b == null) goto L24;
        r104.b(true);
        return;
    L24:
        return;
    L19:
        f(new q(this, r100));
    }

    public void setExtraTiming(ipa.b.C6344b r100) {
        f(new a(this));
    }

    public void setGlobalProps(Map<String, Object> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f404571k = r100;
        f(new b(this));
    }

    public void setOnRootSizeChangedCallback(u r100) {
        this.f404586z = r100;
        int r101 = this.f404578r;
        if (r101 == (-1)) goto L14;
        int r102 = this.f404579s;
        if (r102 == (-1)) goto L15;
        if (r100 == null) goto L16;
        RelaxView r103 = ((k) r100).f404605a;
        if (r103.f404579s == r102) goto L10;
    L12:
        r103.f404579s = r102;
        r103.f404578r = r101;
        return;
    L10:
        if (r103.f404578r != r101) goto L12;
        return;
    L16:
        return;
    L15:
        return;
    }

    public void setRelaxViewClient(com.relax.v r100) {
        this.f404564d = r100;
        f(new j(this));
        rpa.a r101 = this.f404563c;
        if (r101 == null) goto L8;
        com.lynx.clay.embedding.android.d r102 = ((lpa.f) r101).f510277a;
        lpa.e r103 = new lpa.e(r100, this);
        r102.b();
        FlutterEngine r104 = r102.f380643b;
        if (r104 == null) goto L9;
        r104.getFlutterJNI().setTimingClient(r103);
        return;
    L9:
        return;
    }

    public RelaxView(Context r100, Object r101) {
        super(r100);
        this.f404561a = 0;
        this.f404562b = null;
        this.f404563c = null;
        this.f404564d = null;
        this.f404565e = null;
        this.f404566f = null;
        this.f404567g = false;
        this.f404568h = null;
        this.f404569i = false;
        this.f404570j = null;
        this.f404571k = null;
        this.f404572l = null;
        this.f404573m = null;
        this.f404574n = true;
        this.f404575o = null;
        this.f404577q = null;
        this.f404578r = -1;
        this.f404579s = -1;
        this.f404580t = 0;
        this.f404581u = 0;
        this.f404582v = 1.0f;
        this.f404583w = null;
        this.f404584x = null;
        this.f404585y = new ArrayList();
        this.f404586z = new k(this);
        this.A = null;
        this.B = null;
        this.C = RuntimeType.RuntimeTypeNative;
        this.B = RelaxEnv.inst().renderType();
        this.A = r101;
        g(r100, true, true);
    }

    public static synchronized void initGlobal(Context r100, String r101) {
        monitor-enter(RelaxView.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (D == false) goto L9;
        monitor-exit(RelaxView.class);
        return;
    L9:
        D = true;     // Catch: Throwable -> L20
        r100.getApplicationContext();     // Catch: Throwable -> L20
        kpa.b.b();     // Catch: Throwable -> L20
        LLog.Initialize(r100);     // Catch: Throwable -> L20
        spa.b.b(r100, r101);     // Catch: Throwable -> L20
        NativeModuleRegistry.registerFunction("echo", ModuleEcho.class);     // Catch: Throwable -> L12 Exception -> L14
        NativeModuleRegistry.registerFunction(PerfLog.TAG_PERF, PerformanceCollector.class);     // Catch: Throwable -> L12 Exception -> L14
        NativeModuleRegistry.registerFunction("network", ModuleNetworkAndroid.class);     // Catch: Throwable -> L12 Exception -> L14
    L23:
    L18:
        monitor-exit(RelaxView.class);
        return;
    L12:
        th = move-exception;
        LLog.e("ModuleManager init error: " + th);     // Catch: Throwable -> L20
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        goto L23
    }

    public void addEventListener(String r100, RelaxEventListener r101) {
        f(new d(this, r100, r101));
    }

    public void callRTSFunction(String r100, Object r101) {
        callRTSFunction(r100, r101, null);
    }

    public void fireEvent(String r100, Object r101) {
        f(new c(this, r100, r101));
    }

    public boolean loadBytecode(byte[] r100, String r101) {
        h();
        this.f404570j = r101;
        hpa.a r102 = this.f404566f.f486488a;
        if (r102 == null) goto L5;
        r102.onLoad();
    L5:
        BackendWorker r103 = this.f404565e.f404544c;
        if (r103.b() == false) goto L11;
        BackendWorkerJNI r104 = r103.f404534a;
        if (r104 == null) goto L11;
        return r104.loadBytecode(r100, r101);
    L11:
        return false;
    }

    public boolean loadFile(byte[] r100, String r101) {
        h();
        return innerLoadFile(r100, r101, null);
    }

    public boolean loadScript(String r100, String r101) {
        h();
        this.f404570j = r101;
        hpa.a r102 = this.f404566f.f486488a;
        if (r102 == null) goto L5;
        r102.onLoad();
    L5:
        BackendWorker r103 = this.f404565e.f404544c;
        r103.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L14:
        return false;
    L9:
        if (r103.b() == false) goto L14;
        BackendWorkerJNI r104 = r103.f404534a;
        if (r104 == null) goto L14;
        return r104.loadScript(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r210) {
        if (this.f404569i == false) goto L6;
        super.onMeasure(r110, r210);
        return;
    L6:
        int r100 = View.MeasureSpec.getMode(r210);
        int r101 = View.MeasureSpec.getSize(r210);
        int r102 = View.MeasureSpec.getMode(r110);
        int r103 = View.MeasureSpec.getSize(r110);
        OnMeasureCallback r104 = this.f404584x;
        if (r104 == null) goto L24;
        double r105 = r103;
        if (r102 == Integer.MIN_VALUE) goto L13;
        if (r102 == 1073741824) goto L12;
        int r106 = 0;
    L14:
        double r107 = r101;
        if (r100 == Integer.MIN_VALUE) goto L19;
        if (r100 == 1073741824) goto L18;
        int r111 = 0;
    L20:
        ?? r112 = 0;
        ArrayList<Double> r108 = r104.invoke(r105, r106, r107, r111);
        if (r108.size() != 2) goto L25;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(((Double) ListProtector.get(r108, 0)).intValue(), 1073741824), View.MeasureSpec.makeMeasureSpec(((Double) ListProtector.get(r108, 1)).intValue(), 1073741824));
        return;
    L25:
        int r113 = this.f404578r;
        if (r113 != (-1)) goto L28;
        int r109 = 0;
    L29:
        int r114 = this.f404579s;
        if (r114 != (-1)) goto L32;
        r114 = 0;
    L32:
        if (r102 == 0) goto L34;
        int r115 = 1;
    L35:
        if (r100 != 1073741824) goto L37;
        boolean r116 = true;
    L39:
        if (r100 != Integer.MIN_VALUE) goto L43;
        if (r113 == (-1)) goto L42;
        if (r109 <= r101) goto L43;
    L42:
        boolean r117 = true;
    L44:
        if (r116 == true) goto L48;
        if (r117 == true) goto L48;
        int r118 = r109;
    L49:
        if (r115 == 0) goto L51;
        int r119 = r103;
    L52:
        this.f404580t = r115;
        if (r116 == false) goto L56;
    L54:
        int r120 = 1;
    L60:
        this.f404581u = r120;
        if (r118 >= r109) goto L63;
        r118 = r118 | 16777216;
    L63:
        if (r119 >= r114) goto L65;
        r119 = r119 | 16777216;
    L65:
        RelaxEngine r121 = this.f404565e;
        int r122 = this.f404580t;
        int r123 = this.f404581u;
        RelaxEngine.a r124 = r121.f404545d;
        if (r124.f404554i == r122) goto L68;
    L69:
        r124.f404554i = r122;
        r124.f404555j = r123;
        r121.b(r112);
    L70:
        RelaxEngine r125 = this.f404565e;
        double r126 = r103;
        double r127 = r101;
        monitor-enter(r125);
    L89:
        th = move-exception;
        throw th;
    L73:
        if (r125.f404544c.b() == true) goto L77;
        double[] r128 = new double[2];     // Catch: Throwable -> L89
        r128[r112] = 0.0d;     // Catch: Throwable -> L89
        r128[1] = 0.0d;     // Catch: Throwable -> L89
        monitor-exit(r125);
    L85:
        if (r128.length != 2) goto L87;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) r128[r112], 1073741824), View.MeasureSpec.makeMeasureSpec((int) r128[1], 1073741824));
        return;
    L87:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r119, 1073741824), View.MeasureSpec.makeMeasureSpec(r118, 1073741824));
        return;
    L77:
        RelaxJNI r129 = r125.f404543b;     // Catch: Throwable -> L89
        if (r129 == null) goto L82;
        r128 = r129.onMeasure(r126, r127);     // Catch: Throwable -> L89
        monitor-exit(r125);
        goto L85
    L82:
        r128 = new double[2];     // Catch: Throwable -> L89
        r128[r112] = 0.0d;     // Catch: Throwable -> L89
        r128[1] = 0.0d;     // Catch: Throwable -> L89
        monitor-exit(r125);
        goto L85
    L68:
        if (r124.f404555j == r123) goto L70;
    L56:
        if (r100 == Integer.MIN_VALUE) goto L59;
        if (r100 == 1073741824) goto L54;
        r120 = 0;
        goto L60
    L59:
        r120 = 2;
        goto L60
    L51:
        r119 = r114;
    L48:
        r118 = r101;
    L43:
        r117 = false;
        goto L44
    L37:
        r116 = false;
        goto L39
    L34:
        r115 = 0;
        goto L35
    L28:
        r109 = r113;
        goto L29
    L18:
        r111 = 1;
        goto L20
    L19:
        r111 = 2;
        goto L20
    L12:
        r106 = 1;
        goto L14
    L13:
        r106 = 2;
        goto L14
    L24:
        r112 = 0;
        goto L25
    }

    public void registerBridgeModule(String r100, Object r101) {
        f(new r(this, r100, r101));
    }

    public void removeEventListener(String r100, RelaxEventListener r101) {
        f(new e(this, r100, r101));
    }

    public RelaxView(Context r100, RuntimeType r101, Object r102) {
        super(r100);
        this.f404561a = 0;
        this.f404562b = null;
        this.f404563c = null;
        this.f404564d = null;
        this.f404565e = null;
        this.f404566f = null;
        this.f404567g = false;
        this.f404568h = null;
        this.f404569i = false;
        this.f404570j = null;
        this.f404571k = null;
        this.f404572l = null;
        this.f404573m = null;
        this.f404574n = true;
        this.f404575o = null;
        this.f404577q = null;
        this.f404578r = -1;
        this.f404579s = -1;
        this.f404580t = 0;
        this.f404581u = 0;
        this.f404582v = 1.0f;
        this.f404583w = null;
        this.f404584x = null;
        this.f404585y = new ArrayList();
        this.f404586z = new k(this);
        this.A = null;
        this.B = null;
        this.C = RuntimeType.RuntimeTypeNative;
        this.B = RelaxEnv.inst().renderType();
        this.C = r101;
        this.A = r102;
        g(r100, true, true);
    }

    public void callRTSFunction(String r100, Object r101, s r102) {
        f(new f(this, r100, r101));
    }

    public final void g(Context r100, boolean r101, boolean r102) {
        LLog.i("RelaxView init: " + toString());
        com.relax.m.f404653b.f404654a.push(r100);
        this.f404561a = System.currentTimeMillis();
        this.f404566f = new hpa.c(r100, this);
        initGlobal(r100.getApplicationContext());
        this.f404568h = new ArrayList();
        this.f404574n = r102;
        if (r101 == false) goto L7;
        if (r102 == false) goto L6;
        com.relax.o r103 = com.relax.o.a.f404661a;
        Context r104 = getContext();
        RuntimeType r105 = this.C;
        float r106 = this.f404582v;
        r103.getClass();
        this.f404565e = new RelaxEngine(r104, r105, r106);
        goto L7
    L6:
        this.f404573m = new CountDownLatch(1);
        com.relax.o r107 = com.relax.o.a.f404661a;
        Context r108 = getContext();
        RuntimeType r109 = this.C;
        float r110 = this.f404582v;
        r107.f404660a.post(new com.relax.n(r107, new o(this), r108, r109, r110));
    L7:
        this.f404576p = new com.relax.g(getContext());
        lpa.f r111 = UIRenderRegistry.f405703a.get(getRenderType()).a(getContext(), this.A);
        this.f404563c = r111;
        r111.f510279c = new com.relax.s(this);
        if (this.f404575o == null) goto L10;
        r111.getClass();
    L10:
        ((lpa.f) this.f404563c).b(r100);
        this.f404562b = ((lpa.f) this.f404563c).a(r100);
        p r112 = new p(this);
        this.f404577q = r112;
        this.f404576p.f404647k.put(r112, r112);
        addView(this.f404562b, -1, E);
        this.f404569i = false;
    }

    public boolean innerLoadFile(byte[] r100, String r101, Map<String, Object> r102) {
        this.f404570j = r101;
        hpa.a r103 = this.f404566f.f486488a;
        if (r103 == null) goto L5;
        r103.onLoad();
    L5:
        if (r102 == null) goto L7;
        setGlobalProps(r102);
    L7:
        BackendWorker r104 = this.f404565e.f404544c;
        if (r100 != null) goto L11;
        r104.getClass();
    L22:
        boolean r105 = false;
    L23:
        LLog.i("RelaxView loadFile finish: " + toString());
        return r105;
    L11:
        if (r104.b() == false) goto L22;
        Iterator<byte[]> r106 = r104.f404536c.iterator();
    L15:
        if (r106.hasNext() == false) goto L20;
        if (r106.next() != r100) goto L15;
        LLog.e("loadFile same binary in the same runtime current.");
        goto L22
    L20:
        if (r104.f404534a == null) goto L22;
        r104.f404536c.add(r100);
        r105 = r104.f404534a.loadFile(r100, r101);
        goto L23
    }

    public boolean loadFile(byte[] r100, String r101, Map<String, Object> r102) {
        h();
        return innerLoadFile(r100, r101, r102);
    }

    public RelaxView(Context r100, boolean r101, boolean r102) {
        super(r100);
        this.f404561a = 0;
        this.f404562b = null;
        this.f404563c = null;
        this.f404564d = null;
        this.f404565e = null;
        this.f404566f = null;
        this.f404567g = false;
        this.f404568h = null;
        this.f404569i = false;
        this.f404570j = null;
        this.f404571k = null;
        this.f404572l = null;
        this.f404573m = null;
        this.f404574n = true;
        this.f404575o = null;
        this.f404577q = null;
        this.f404578r = -1;
        this.f404579s = -1;
        this.f404580t = 0;
        this.f404581u = 0;
        this.f404582v = 1.0f;
        this.f404583w = null;
        this.f404584x = null;
        this.f404585y = new ArrayList();
        this.f404586z = new k(this);
        this.A = null;
        this.B = null;
        this.C = RuntimeType.RuntimeTypeNative;
        this.B = RelaxEnv.inst().renderType();
        g(r100, r101, r102);
    }

    public RelaxView(Context r100, Object r101, boolean r102, boolean r103) {
        super(r100);
        this.f404561a = 0;
        this.f404562b = null;
        this.f404563c = null;
        this.f404564d = null;
        this.f404565e = null;
        this.f404566f = null;
        this.f404567g = false;
        this.f404568h = null;
        this.f404569i = false;
        this.f404570j = null;
        this.f404571k = null;
        this.f404572l = null;
        this.f404573m = null;
        this.f404574n = true;
        this.f404575o = null;
        this.f404577q = null;
        this.f404578r = -1;
        this.f404579s = -1;
        this.f404580t = 0;
        this.f404581u = 0;
        this.f404582v = 1.0f;
        this.f404583w = null;
        this.f404584x = null;
        this.f404585y = new ArrayList();
        this.f404586z = new k(this);
        this.A = null;
        this.B = null;
        this.C = RuntimeType.RuntimeTypeNative;
        this.f404575o = new RelaxPageConfig();
        this.B = RelaxEnv.inst().renderType();
        this.A = r101;
        g(r100, r102, r103);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r110) {
        super.onSizeChanged(r100, r101, r102, r110);
        int r103 = this.f404580t;
        int r104 = this.f404581u;
        if (this.f404569i == true) goto L6;
        f(new com.relax.u(this, r100, r103, r101, r104));
    L6:
        com.relax.v r105 = this.f404564d;
        if (r105 == null) goto L10;
        r105.getClass();
        return;
    }

    public RelaxView(Context r100, RuntimeType r101, boolean r102, boolean r103) {
        super(r100);
        this.f404561a = 0;
        this.f404562b = null;
        this.f404563c = null;
        this.f404564d = null;
        this.f404565e = null;
        this.f404566f = null;
        this.f404567g = false;
        this.f404568h = null;
        this.f404569i = false;
        this.f404570j = null;
        this.f404571k = null;
        this.f404572l = null;
        this.f404573m = null;
        this.f404574n = true;
        this.f404575o = null;
        this.f404577q = null;
        this.f404578r = -1;
        this.f404579s = -1;
        this.f404580t = 0;
        this.f404581u = 0;
        this.f404582v = 1.0f;
        this.f404583w = null;
        this.f404584x = null;
        this.f404585y = new ArrayList();
        this.f404586z = new k(this);
        this.A = null;
        this.B = null;
        this.C = RuntimeType.RuntimeTypeNative;
        this.B = RelaxEnv.inst().renderType();
        this.C = r101;
        g(r100, r102, r103);
    }

    public RelaxView(Context r100, Object r101, RuntimeType r102, boolean r103, boolean r104) {
        super(r100);
        this.f404561a = 0;
        this.f404562b = null;
        this.f404563c = null;
        this.f404564d = null;
        this.f404565e = null;
        this.f404566f = null;
        this.f404567g = false;
        this.f404568h = null;
        this.f404569i = false;
        this.f404570j = null;
        this.f404571k = null;
        this.f404572l = null;
        this.f404573m = null;
        this.f404574n = true;
        this.f404575o = null;
        this.f404577q = null;
        this.f404578r = -1;
        this.f404579s = -1;
        this.f404580t = 0;
        this.f404581u = 0;
        this.f404582v = 1.0f;
        this.f404583w = null;
        this.f404584x = null;
        this.f404585y = new ArrayList();
        this.f404586z = new k(this);
        this.A = null;
        this.B = null;
        this.C = RuntimeType.RuntimeTypeNative;
        this.f404575o = new RelaxPageConfig();
        this.B = RelaxEnv.inst().renderType();
        this.C = r102;
        this.A = r101;
        g(r100, r103, r104);
    }

    public RelaxView(Context r100, Object r101, boolean r102, boolean r103, RelaxPageConfig r104) {
        super(r100);
        this.f404561a = 0;
        this.f404562b = null;
        this.f404563c = null;
        this.f404564d = null;
        this.f404565e = null;
        this.f404566f = null;
        this.f404567g = false;
        this.f404568h = null;
        this.f404569i = false;
        this.f404570j = null;
        this.f404571k = null;
        this.f404572l = null;
        this.f404573m = null;
        this.f404574n = true;
        this.f404575o = null;
        this.f404577q = null;
        this.f404578r = -1;
        this.f404579s = -1;
        this.f404580t = 0;
        this.f404581u = 0;
        this.f404582v = 1.0f;
        this.f404583w = null;
        this.f404584x = null;
        this.f404585y = new ArrayList();
        this.f404586z = new k(this);
        this.A = null;
        this.B = null;
        this.C = RuntimeType.RuntimeTypeNative;
        this.f404575o = r104;
        this.B = RelaxEnv.inst().renderType();
        this.A = r101;
        g(r100, r102, r103);
    }

    public RelaxView(Context r100, Object r101, RuntimeType r102, float r103, boolean r104, boolean r105, RelaxPageConfig r110) {
        super(r100);
        this.f404561a = 0;
        this.f404562b = null;
        this.f404563c = null;
        this.f404564d = null;
        this.f404565e = null;
        this.f404566f = null;
        this.f404567g = false;
        this.f404568h = null;
        this.f404569i = false;
        this.f404570j = null;
        this.f404571k = null;
        this.f404572l = null;
        this.f404573m = null;
        this.f404574n = true;
        this.f404575o = null;
        this.f404577q = null;
        this.f404578r = -1;
        this.f404579s = -1;
        this.f404580t = 0;
        this.f404581u = 0;
        this.f404582v = 1.0f;
        this.f404583w = null;
        this.f404584x = null;
        this.f404585y = new ArrayList();
        this.f404586z = new k(this);
        this.A = null;
        this.B = null;
        this.C = RuntimeType.RuntimeTypeNative;
        this.f404575o = r110;
        this.f404582v = r103;
        this.B = RelaxEnv.inst().renderType();
        this.C = r102;
        this.A = r101;
        g(r100, r104, r105);
    }
}
