package com.ss.android.lark.featuregatingv2impl.statistics.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregatingv2impl.handler.SettingsMetricsHandler;
import com.ss.android.lark.log.Log;
import idb.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import jdb.c;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import odb.b;
import se6.u;

/* JADX INFO: loaded from: classes35.dex */
public final class FeatureGatingMetricsTracker implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FeatureGatingMetricsTracker f420741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<odb.a> f420742b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<b> f420743c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f420744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static mdb.a f420745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f420746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f420747g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Stack<String> f420748h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Stack<Fragment> f420749i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final WeakHashMap<Fragment, String> f420750j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ExecutorService f420751k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f420752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set<String> f420753m = null;

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f420754a = null;

        static {
            f420754a = new a();
        }

        public a() {
        }

        @Override // jdb.c
        public final void a(boolean r100) {
            Log.i("FeatureGatingMetricsTracker", "featureUpdateValue: " + r100);
        }
    }

    public FeatureGatingMetricsTracker() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    static {
        f420741a = new FeatureGatingMetricsTracker();
        f420742b = new CopyOnWriteArrayList();
        f420743c = new ArrayList();
        f420747g = new Object();
        f420748h = new Stack();
        f420749i = new Stack();
        f420750j = new WeakHashMap();
        f420751k = CoreThreadPool.getDefault().newSerialIODensityThreadPool("metrics_tracker");
        f420753m = SetsKt.mutableSetOf(new String[]{"com.bumptech.glide.manager.SupportRequestManagerFragment", "com.ss.android.lark.main.app.fragment.phone.MainFragmentV2", "com.ss.android.lark.main.app.fragment.phone.MainContainerFragment", "com.ss.android.lark.forseti.node.ForsetiNodeFragment", "com.ss.android.lark.forseti.node.piece.ForsetiNodePiece$ForsetiNodePieceFragment", "com.ss.android.lark.forseti.chain.ForsetiChainFragment", "com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment", "com.ss.android.lark.keyboard.plugin.tool.face.sticker.FacePageNewFragment2", "com.ss.android.lark.framework.larkwidget.WidgetManager", "com.ss.android.lark.keyboard.plugin.tool.face.FaceKBPlugin$EmojiPageNewFragmentNoHitPoint"});
    }

    public static void d() {
        if (f420746f == false) goto L5;
        return;
    L5:
        Object r100 = f420747g;
        monitor-enter(r100);
    L27:
        th = move-exception;
        throw th;
    L8:
        if (f420746f == false) goto L11;
        monitor-exit(r100);
        return;
    L11:
        mdb.a r101 = SettingsMetricsHandler.f420737i.j();     // Catch: Throwable -> L27
        f420745e = r101;     // Catch: Throwable -> L27
        Application r102 = null;
        if (r101 == null) goto L19;
        ArrayList<String> r103 = r101.filterFragment;     // Catch: Throwable -> L27
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("filterFragment");     // Catch: Throwable -> L27
        r103 = null;
    L17:
        if (r103 == null) goto L19;
        f420753m.addAll(r103);     // Catch: Throwable -> L27
    L19:
        IGetDataCallback<mdb.a> r104 = new FeatureGatingMetricsTracker$init$1$configUpdateCallback$1();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r104, "callback");     // Catch: Throwable -> L27
        SettingsMetricsHandler.f420738j = r104;     // Catch: Throwable -> L27
        f.a().addFeatureGatingUpdateListener("lark.fg.performance_metrics_enable", a.f420754a, "_normal_fg");     // Catch: Throwable -> L27
        Context r105 = FeatureGatingModule.getDependency().getContext();     // Catch: Throwable -> L27
        if ((r105 instanceof Application) == false) goto L22;
        r102 = (Application) r105;     // Catch: Throwable -> L27
    L22:
        if (r102 == null) goto L24;
        r102.registerActivityLifecycleCallbacks(f420741a);     // Catch: Throwable -> L27
    L24:
        f420746f = true;     // Catch: Throwable -> L27
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r100);
    }

    public static double a(List r110) {
        if (CollectionUtils.isEmpty(r110) == false) goto L6;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        if (r110.size() != 1) goto L9;
        return 1.0d;
    L9:
        mdb.a r100 = f420745e;
        if (r100 == null) goto L17;
        mdb.a.C6804a r101 = r100.slidingWindow;
        if (r101 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("slidingWindow");
        r101 = null;
    L15:
        if (r101 == null) goto L17;
        int r102 = r101.b();
    L18:
        double r103 = 1000000;
        double r104 = r102;
        if (((((odb.a) CollectionsKt.last(r110)).f522908c - ((odb.a) CollectionsKt.first(r110)).f522907b) / r103) < r104) goto L21;
        int r105 = 0;
        double r106 = 0.0d;
        int r107 = 0;
    L24:
        if (r105 >= r110.size()) goto L29;
        double r111 = (((odb.a) ListProtector.get(r110, r105)).f522908c - ((odb.a) ListProtector.get(r110, r107)).f522907b) / r103;
        if (r111 > r104) goto L27;
        r105 = r105 + 1;
        goto L24
    L27:
        r106 = Math.max(((double) (r105 - r107)) / (r111 / ((double) 1000)), r106);
        r107 = r107 + 1;
        r104 = r104;
        goto L24
    L29:
        double r112 = r104;
        if (r105 <= r107) goto L36;
        double r108 = (((odb.a) ListProtector.get(r110, r105 - 1)).f522908c - ((odb.a) ListProtector.get(r110, r107)).f522907b) / r103;
        int r109 = r105 - r107;
        if (r108 <= r112) goto L34;
        double r113 = ((double) r109) / (r108 / ((double) 1000));
    L35:
        r106 = Math.max(r113, r106);
        goto L36
    L34:
        r113 = r109;
    L36:
        Log.d("FeatureGatingMetricsTracker", "calculateQPS: " + r106);
        return r106;
    L21:
        return r110.size();
    L17:
        r102 = 1000;
        goto L18
    }

    public static void b(odb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "metrics");
        if (FeatureGatingModule.getDependency().Y().booleanValue() == false) goto L6;
        Log.d("FeatureGatingMetricsTracker", "collectMetrics disable");
        return;
    L6:
        d();
        Stack<String> r101 = f420748h;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Fragment r102 = null;
        String r103 = r101.peek();     // Catch: Exception -> L9
    L10:
        String r104 = r103;
        if (r104 != null) goto L14;
        Log.d("FeatureGatingMetricsTracker", "current page: Boost");
        r104 = "Boost";
    L26:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r100.f522910e = r104;
        r100.f522911f = u.a();
        CopyOnWriteArrayList<odb.a> r105 = f420742b;
        r105.add(r100);
        int r106 = r105.size();
        mdb.a r107 = f420745e;
        if (r107 == null) goto L29;
        int r108 = r107.a();
    L30:
        if (r106 <= r108) goto L41;
        ArrayList r109 = new ArrayList(r105);
        r105.clear();
        if (CollectionUtils.isEmpty(r109) == true) goto L42;
        f420751k.execute(new odb.f(r109));
        return;
    L42:
        return;
    L41:
        return;
    L29:
        r108 = 1000;
        goto L30
    L14:
        if (Intrinsics.areEqual("com.ss.android.lark.main.app.MainActivity", r104) == false) goto L22;
        Stack<Fragment> r110 = f420749i;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        r102 = r110.peek();     // Catch: Exception -> L36
    L17:
        Fragment r111 = r102;
        String r112 = f420752l;
        if (r111 == null) goto L20;
        r104 = c(r111);
        goto L22
    L20:
        if (r112 == null) goto L22;
        r104 = r112;
    L22:
        List r113 = StringsKt.split$default(r104, new String[]{"."}, false, 0, 6, null);
        if (r113.size() <= 2) goto L25;
        r104 = ((String) ListProtector.get(r113, r113.size() - 2)) + '.' + ((String) CollectionsKt.last(r113));
    L25:
        Log.d("FeatureGatingMetricsTracker", "current page: " + r104);
    L9:
        r103 = null;
        goto L10
    }

    public static String c(Fragment r100) {
        return f(r100, 0).getClass().getName();
    }

    public static boolean e(Fragment r100) {
        if (r100.isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.isRemoving() == true) goto L9;
        if (r100.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L9;
        return true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        String r101 = r100.getComponentName().getClassName();
        Log.d("FeatureGatingMetricsTracker", "pop page: " + r101);
        f420748h.remove(r101);
        CopyOnWriteArrayList<odb.a> r102 = f420742b;
        ArrayList r103 = new ArrayList(r102);
        r102.clear();
        if (CollectionUtils.isEmpty(r103) == true) goto L7;
        f420751k.execute(new odb.f(r103));
        return;
    }

    public static Fragment f(Fragment r100, int r101) {
        if (r101 < 8) goto L33;
        return r100;
    L33:
        List<Fragment> r102 = r100.getChildFragmentManager().getFragments();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L7
    L9:
        Iterator r103 = CollectionsKt.asReversed(r102).iterator();
    L10:
        Object r104 = null;
        if (r103.hasNext() == false) goto L20;
        Object r105 = r103.next();
        Fragment r106 = (Fragment) r105;
        Intrinsics.checkNotNull(r106);
        if (e(r106) == true) goto L15;
    L17:
        boolean r107 = false;
    L18:
        if (r107 == false) goto L10;
    L21:
        Fragment r108 = (Fragment) r105;
        if (r108 != null) goto L30;
        Iterator r109 = CollectionsKt.asReversed(r102).iterator();
    L25:
        if (r109.hasNext() == false) goto L29;
        Object r110 = r109.next();
        Fragment r111 = (Fragment) r110;
        Intrinsics.checkNotNull(r111);
        if (e(r111) == false) goto L25;
        r104 = r110;
    L29:
        r108 = (Fragment) r104;
    L30:
        if (r108 != null) goto L32;
        return r100;
    L32:
        return f(r108, r101 + 1);
    L15:
        if (f420753m.contains(r106.getClass().getName()) == true) goto L17;
        r107 = true;
        goto L18
    L20:
        r105 = null;
    L7:
        e = move-exception;
        Log.e("FeatureGatingMetricsTracker", "get child fragments failed, e: " + e);
        r102 = CollectionsKt.emptyList();
        goto L9
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        String r102 = r100.getComponentName().getClassName();
        Log.d("FeatureGatingMetricsTracker", "push page: " + r102);
        if (Intrinsics.areEqual("com.ss.android.lark.main.app.MainActivity", r102) == false) goto L12;
        Log.d("FeatureGatingMetricsTracker", "main activity created.");
        if ((r100 instanceof AppCompatActivity) == false) goto L7;
        AppCompatActivity r103 = (AppCompatActivity) r100;
    L8:
        if (r103 == null) goto L12;
        FragmentManager r104 = r103.getSupportFragmentManager();
        if (r104 == null) goto L12;
        r104.registerFragmentLifecycleCallbacks(new AnonymousClass1(), true);
        goto L12
    L7:
        r103 = null;
    L12:
        f420748h.push(r102);
    }
}
